package com.example.shop_online.service;

import com.example.shop_online.entity.UserShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_online.query.CartQuery;
import com.example.shop_online.vo.CartGoodsVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wujiahao
 * @since 2023-11-09
 */
public interface UserShoppingCartService extends IService<UserShoppingCart> {

    CartGoodsVO addShopCart(CartQuery query);

//    List<CartGoodsVO> shopCartList(Integer userId);
}
