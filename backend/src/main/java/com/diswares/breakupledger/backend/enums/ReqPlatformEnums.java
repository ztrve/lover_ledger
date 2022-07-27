package com.diswares.breakupledger.backend.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author: z_true
 * @date: 2022/7/26 14:36
 * @version: 1.0.0
 */
@Getter
public enum ReqPlatformEnums {
    /**
     * wx
     */
    WX(0, "微信")
    ;

    @JsonValue
    @EnumValue
    private final Integer code;

    private final String desc;

    ReqPlatformEnums(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 自定义反序列化enum方法
     */
    @JsonCreator
    public static ReqPlatformEnums getEnum(Integer code){
        for(ReqPlatformEnums item : values()){
            if(item.getCode().equals(code)){
                return item;
            }
        }
        throw new IllegalArgumentException(
                "Cannot convert code " + code + " to category type enums");
    }
}
