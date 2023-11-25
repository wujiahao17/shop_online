package com.example.shop_online.service;

import com.example.shop_online.common.result.PageResult;
import com.example.shop_online.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_online.query.CancelGoodsQuery;
import com.example.shop_online.query.OrderPreQuery;
import com.example.shop_online.query.OrderQuery;
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

    //订单列表
    PageResult<OrderDetailVO> getOrderList(OrderQuery query);
    //取消订单
    OrderDetailVO cancelOrder(CancelGoodsQuery query);
    //删除订单
    void deleteOrder(List<Integer> ids,Integer userId);

    //模拟支付
    void payOrder(Integer id);

    //模拟发货
    void consignOrder(Integer id);

}
