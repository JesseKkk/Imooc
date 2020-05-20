package com.jesse.aspectj.demo3;

import org.springframework.stereotype.Component;

@Component("targetClass")
public class TargetClass {
    /**
     * 拼接两个字符串
     */
    public String joint(String str1, String str2) {
        return str1 + "+" + str2;
    }
}
