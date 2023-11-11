package com.example.shop_online.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * author：H
 * Date：2023/11/11 14:57
 */
@Data
public class IndexTabRecommendVO {
    @Schema(description = "主键id")
    private Integer id;
    @Schema(description = "封面图")
    @JsonProperty("bannerPicture")
    private String cover;
    @Schema(description = "热门推荐名称")
    @JsonProperty("title")
    private String name;
    @Schema(description = "商品列表")
    private List<IndexTabGoodsVO> subTypes;
}
