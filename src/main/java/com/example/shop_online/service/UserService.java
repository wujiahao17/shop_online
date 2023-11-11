package com.example.shop_online.service;

import com.example.shop_online.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_online.query.UserLoginQuery;
import com.example.shop_online.vo.LoginResultVO;
import com.example.shop_online.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wujiahao
 * @since 2023-11-09
 */
public interface UserService extends IService<User> {
//用户登录
LoginResultVO login(UserLoginQuery query);


    User getUserInfo(Integer userId);
//xiugaiyonghuxinxi

    UserVO editUserInfo(UserVO userVO);

//修改头像
    String editUserAvatar(Integer UserId, MultipartFile file);

}
