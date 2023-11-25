package com.example.shop_online.service;

import com.example.shop_online.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_online.query.OrderPreQuery;
import com.example.shop_online.vo.OrderDetailVO;
import com.example.shop_online.vo.SubmitOrderVO;
import com.example.shop_online.vo.UserOrderGoodsVO;
import com.example.shop_online.vo.UserOrderVO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wujiahao
 * @since 2023-11-09
 */
public interface UserOrderService extends IService<UserOrder> {
    //提交订单
    Integer addGoodsOrder(UserOrderVO orderVO);

    //订单详情
    OrderDetailVO getOrderDetail(Integer id);

    SubmitOrderVO getPreOrderDetail(Integer userId);

    SubmitOrderVO getPreNowOrderDetail(OrderPreQuery query);

    SubmitOrderVO getRepurchaseOrderDetail(Integer id);

}
