package com.example.shop_online.service;

import com.example.shop_online.common.result.PageResult;
import com.example.shop_online.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_online.query.Query;
import com.example.shop_online.vo.GoodsVO;
import com.example.shop_online.vo.IndexTabRecommendVO;
import com.example.shop_online.vo.RecommendGoodsVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wujiahao
 * @since 2023-11-09
 */
public interface GoodsService extends IService<Goods> {
    /**
     * 首页热门推荐 - 根据 tab Id 获取该推荐下的商品列表
     *
     * @return
     */
    IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query);
    /**
     * 首页推荐 - 猜你喜欢(分页)
     *
     * @param query
     * @return
     */
    PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query);

    /**
     * 根据id 获取商品详情
     *
     * @param id
     * @return
     */
    GoodsVO getGoodsDetail(Integer id);
}
