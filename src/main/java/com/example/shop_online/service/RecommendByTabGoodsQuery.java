package com.example.shop_online.service;

import com.example.shop_online.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RecommendByTabGoodsQuery extends Query {
    @Schema(description = "分类 tabId")
    private Integer subType;
}