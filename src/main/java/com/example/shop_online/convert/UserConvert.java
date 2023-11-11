package com.example.shop_online.convert;

import com.example.shop_online.entity.User;
import com.example.shop_online.vo.LoginResultVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * author：wujiahao
 * Date：2023/11/11 8:30
 */
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    LoginResultVO convertToLoginResultVO(User user);
}
