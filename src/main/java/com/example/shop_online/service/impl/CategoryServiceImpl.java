package com.example.shop_online.service.impl;

import com.example.shop_online.entity.Category;
import com.example.shop_online.mapper.CategoryMapper;
import com.example.shop_online.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wujiahao
 * @since 2023-11-08
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
