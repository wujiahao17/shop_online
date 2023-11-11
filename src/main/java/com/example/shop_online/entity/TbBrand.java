package com.example.shop_online.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wujiahao
 * @since 2023-11-09
 */
@Getter
@Setter
@TableName("tb_brand")
@ApiModel(value = "TbBrand对象", description = "")
public class TbBrand {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("brand_name")
    private String brandName;

    @TableField("company_name")
    private String companyName;

    @TableField("ordered")
    private Integer ordered;

    @TableField("description")
    private String description;

    @TableField("status")
    private Integer status;
}
