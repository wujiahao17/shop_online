package com.example.shop_online.utils;

import java.util.Random;

/**
 * author：wujiahao
 * Date：2023/11/11 8:15
 */
public class GeneratorCodeUtils {
    /**
     * 生成6位随机数
     * @return
     */
    public static String generateCode() {
        int n = 6;
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(random.nextInt(10)).toString());
        }
        return code.toString();
    }
}
