package com.example.shop_online.service;

import com.example.shop_online.entity.UserShippingAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_online.vo.AddressVO;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyh
 * @since 2023-11-09
 */
public interface UserShippingAddressService extends IService<UserShippingAddress> {

    //添加收货地址
    Integer saveShippingAddress(AddressVO addressVO);
    //修改
    Integer editShippingAddress(AddressVO addressVO);
    //获取
    /**
     * 收货地址列表
     *
     * @param userId
     * @return
     */
    List<AddressVO> getList(Integer userId);
    /**
     *收货地址详情
     *
     * @param id
     * @return
     */
    AddressVO getAddressInfo(Integer id);
    /**
     * 删除收货地址
     *
     * @param id
     */
    void removeShippingAddress(Integer id);

}
