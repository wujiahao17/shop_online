package com.example.shop_online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shop_online.common.exception.ServerException;
import com.example.shop_online.common.result.PageResult;
import com.example.shop_online.convert.GoodsConvert;
import com.example.shop_online.entity.*;
import com.example.shop_online.mapper.*;
import com.example.shop_online.query.Query;
import com.example.shop_online.query.RecommendByTabGoodsQuery;
import com.example.shop_online.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shop_online.vo.GoodsVO;
import com.example.shop_online.vo.IndexTabGoodsVO;
import com.example.shop_online.vo.IndexTabRecommendVO;
import com.example.shop_online.vo.RecommendGoodsVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wujiahao
 * @since 2023-11-09
 */
@Service
@AllArgsConstructor
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    private IndexRecommendMapper indexRecommendMapper;
    private IndexRecommendTabMapper indexRecommendTabMapper;
    private GoodsDetailMapper goodsDetailMapper;
    private GoodsSpecificationMapper goodsSpecificationMapper;
    private  GoodsSpecificationDetailMapper  goodsSpecificationDetailMapper;
    @Override
    public IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query) {
        IndexRecommend indexRecommend = indexRecommendMapper.selectById(query.getSubType());
        if (indexRecommend == null) {
            throw new ServerException("推荐分类不存在");
        }
//        2、查询该分类下的tab 列表
        LambdaQueryWrapper<IndexRecommendTab> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(IndexRecommendTab::getRecommendId, indexRecommend.getId());
        List<IndexRecommendTab> tabList = indexRecommendTabMapper.selectList(wrapper);
        if (tabList.size() == 0) {
            throw new ServerException("该分类下不存在 tab 分类");
        }
//        3、tab分类下的商品列表
        List<IndexTabGoodsVO> list = new ArrayList<>();
        for (IndexRecommendTab item : tabList) {
            IndexTabGoodsVO tabGoods = new IndexTabGoodsVO();
            tabGoods.setId(item.getId());
            tabGoods.setName(item.getName());
            Page<Goods> page = new Page<>(query.getPage(), query.getPageSize());
            Page<Goods> goodsPage = baseMapper.selectPage(page, new LambdaQueryWrapper<Goods>().eq(Goods::getTabId, item.getId()));
            List<RecommendGoodsVO> goodsList = GoodsConvert.INSTANCE.convertToRecommendGoodsVOList(goodsPage.getRecords());
            PageResult<RecommendGoodsVO> result = new PageResult<>(page.getTotal(), query.getPageSize(), query.getPage(), page.getPages(), goodsList);
            tabGoods.setGoodsItems(result);
            list.add(tabGoods);
        }

        IndexTabRecommendVO recommendVO = new IndexTabRecommendVO();
        recommendVO.setId(indexRecommend.getId());
        recommendVO.setName(indexRecommend.getName());
        recommendVO.setCover(indexRecommend.getCover());
        recommendVO.setSubTypes(list);


        return recommendVO;
    }

    @Override
    public PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query) {
        Page<Goods> page = new Page<>(query.getPage(), query.getPageSize());
        Page<Goods> goodsPage = baseMapper.selectPage(page, null);
        List<RecommendGoodsVO> result = GoodsConvert.INSTANCE.convertToRecommendGoodsVOList(goodsPage.getRecords());
        return new PageResult<>(page.getTotal(), query.getPageSize(), query.getPage(), page.getPages(), result);
    }
    @Override
    public GoodsVO getGoodsDetail(Integer id) {
        //     根据id 获取商品详情
        Goods goods = baseMapper.selectById(id);
        if (goods == null) {
            throw new ServerException("商品不存在");
        }
        GoodsVO goodsVO = GoodsConvert.INSTANCE.convertToGoodsVO(goods);
        //        商品规格
        List<GoodsDetail> goodsDetails = goodsDetailMapper.selectList(new LambdaQueryWrapper<GoodsDetail>().eq(GoodsDetail::getGoodsId, goods.getId()));
        goodsVO.setProperties(goodsDetails);
        //      商品可选规格集合
        List<GoodsSpecification> specificationList = goodsSpecificationMapper.selectList(new LambdaQueryWrapper<GoodsSpecification>().eq(GoodsSpecification::getGoodsId, goods.getId()));
        goodsVO.setSpecs(specificationList);
        //      商品规格详情
        List<GoodsSpecificationDetail> goodsSpecificationDetails = goodsSpecificationDetailMapper.selectList(new LambdaQueryWrapper<GoodsSpecificationDetail>().eq(GoodsSpecificationDetail::getGoodsId, goods.getId()));
        goodsVO.setSkus(goodsSpecificationDetails);
        //      查找同类商品,去除自身
        List<Goods> goodsList = baseMapper.selectList(new LambdaQueryWrapper<Goods>().eq(Goods::getCategoryId, goods.getCategoryId()).ne(Goods::getId, goods.getId()));
        List<RecommendGoodsVO> goodsVOList = GoodsConvert.INSTANCE.convertToRecommendGoodsVOList(goodsList);
        goodsVO.setSimilarProducts(goodsVOList);
        return goodsVO;
    }
}
