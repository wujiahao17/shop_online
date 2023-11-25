package com.example.shop_online.mapper;

import com.example.shop_online.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop_online.vo.UserOrderGoodsVO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wujiahao
 * @since 2023-11-09
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    //根据订单id查询商品信息列表
    List<UserOrderGoodsVO> getGoodsListByOrderId(@Param("id") Integer id);
}
