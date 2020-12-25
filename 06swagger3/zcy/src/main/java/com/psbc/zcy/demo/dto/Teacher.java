package com.psbc.zcy.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//1、@Data可以为类提供读写功能，从而不用写get、set方法。
//2、他还会为类提供 equals()、hashCode()、toString() 方法
@Data
@ApiModel(description="教师实体")
public class Teacher {
    //@JsonProperty 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，
    //如把id属性序列化为id，由于tName第一个单词只有一个字母，所以加此注解
    @JsonProperty("id")
    @ApiModelProperty("主键编号")
    private Integer id;

    @NotNull
    @JsonProperty("tName")
    @ApiModelProperty("教师姓名")
    private String tName;

    @NotNull
    @Min(value = 0, message = "教师编号错误，需要大于等于0")
    @JsonProperty("tId")
    @ApiModelProperty("教师编号")
    private String tId;

    @NotNull
    @JsonProperty("tAge")
    @ApiModelProperty("年龄")
    private Integer tAge;

    @NotNull
    @JsonProperty("tSex")
    @ApiModelProperty("性别")
    private String tSex;

    @NotNull
    @Size(min = 1, max = 100, message = "地址长度错误，最小值为1，最大值为100")
    @JsonProperty("tAddress")
    @ApiModelProperty("地址")
    private String tAddress;

    @NotNull
    @JsonProperty("tSubject")
    @ApiModelProperty("科目")
    private String tSubject;
}
