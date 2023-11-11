package com.example.shop_online.query;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * author：wujiahao
 * Date：2023/11/11 8:13
 */
@Data
public class UserLoginQuery {
    @NotBlank(message = "code不能为空")
    private String code;
}
