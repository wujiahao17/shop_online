package com.example.shop_online.service;

import com.example.shop_online.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_online.query.UserLoginQuery;
import com.example.shop_online.vo.LoginResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wujiahao
 * @since 2023-11-09
 */
public interface UserService extends IService<User> {

    LoginResultVO login(UserLoginQuery query);

    User getUserInfo(Integer userId);
}
