package com.example.shop_online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.shop_online.common.exception.ServerException;
import com.example.shop_online.convert.AddressConvert;
import com.example.shop_online.entity.AddressDefaultEnum;
import com.example.shop_online.entity.UserShippingAddress;
import com.example.shop_online.mapper.UserShippingAddressMapper;
import com.example.shop_online.service.UserShippingAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shop_online.vo.AddressVO;
import org.springframework.stereotype.Service;

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
public class UserShippingAddressServiceImpl extends ServiceImpl<UserShippingAddressMapper, UserShippingAddress> implements UserShippingAddressService {

//private AddressVO addressVO;
    @Override
    public Integer saveShippingAddress(AddressVO addressVO) {
        UserShippingAddress convert = AddressConvert.INSTANCE.convert(addressVO);
        if (addressVO.getIsDefault()== AddressDefaultEnum.DEFAULT_ADDRESS.getValue()){
            List<UserShippingAddress> list = baseMapper.selectList(new LambdaQueryWrapper<UserShippingAddress>()
                    .eq(UserShippingAddress::getIsDefault,
                    AddressDefaultEnum.DEFAULT_ADDRESS.getValue()));
                        if (list.size()>0){
                            throw  new ServerException("已经存在默认地址，请勿重复操作");
                        }
        }
        save(convert);
        return  convert.getId()
;    }

    @Override
    public Integer editShippingAddress(AddressVO addressVO) {
        UserShippingAddress userShippingAddress = baseMapper.selectById(addressVO.getId());
        if (userShippingAddress==null){
            throw new ServerException("地址不存在");
        }
        if (addressVO.getIsDefault()==AddressDefaultEnum.DEFAULT_ADDRESS.getValue()){
            UserShippingAddress address = baseMapper.selectOne(new LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getUserId, addressVO.getUserId()).eq(UserShippingAddress::getIsDefault,
                    AddressDefaultEnum.DEFAULT_ADDRESS.getValue()));

        }
        UserShippingAddress address = AddressConvert.INSTANCE.convert(addressVO);
        updateById(address);
        return address.getId();
    }

    @Override
    public List<AddressVO> getList(Integer userId) {
        LambdaQueryWrapper<UserShippingAddress> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(UserShippingAddress::getIsDefault,userId);
        queryWrapper.orderByDesc(UserShippingAddress::getIsDefault);
        List<UserShippingAddress> list = baseMapper.selectList(queryWrapper);
        List<AddressVO> addressVOS = AddressConvert.INSTANCE.convertToAddressVOList(list);
        return addressVOS;

//
//        List<UserShippingAddress> list = baseMapper.selectList(new LambdaQueryWrapper<UserShippingAddress>()
//                .eq(UserShippingAddress::getIsDefault, AddressDefaultEnum.DEFAULT_ADDRESS.getValue()));
//        List<AddressVO> convert = AddressConvert.INSTANCE.convertToAddressVOList(list);
//        return convert;
    }
}
