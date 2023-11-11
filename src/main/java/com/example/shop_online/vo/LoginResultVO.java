package com.example.shop_online.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * author：wujiahao
 * Date：2023/11/11 9:31
 */
@Data
public class LoginResultVO {
    @Schema(description = "用户id")
    private Integer id;
    @Schema(description = "手机号")
    private String mobile;
    @Schema(description = "登录token")
    private String token;
    @Schema(description = "用户名")
    private String nickname;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "账号")
    private String account;
}
