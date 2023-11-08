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
 * @since 2023-11-08
 */
@Getter
@Setter
@TableName("students")
@ApiModel(value = "Students对象", description = "")
public class Students {

    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    @TableField("stu_num")
    private String stuNum;

    @TableField("stu_name")
    private String stuName;

    @TableField("stu_gender")
    private String stuGender;

    @TableField("stu_age")
    private Integer stuAge;
}
