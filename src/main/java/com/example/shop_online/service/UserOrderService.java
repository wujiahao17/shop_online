package com.example.shop_online.service;

import com.example.shop_online.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_online.vo.OrderDetailVO;
import com.example.shop_online.vo.UserOrderVO;

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
}
