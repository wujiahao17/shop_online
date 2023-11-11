package com.example.shop_online.service;

import com.example.shop_online.convert.AddressConvert;
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
 * @author wujiahao
 * @since 2023-11-09
 */
public interface UserShippingAddressService extends IService<UserShippingAddress> {

    Integer saveShippingAddress(AddressVO addressVO);

    Integer editShippingAddress(AddressVO addressVO);

//    List<UserShippingAddress> findAddress(Integer userId);
}
