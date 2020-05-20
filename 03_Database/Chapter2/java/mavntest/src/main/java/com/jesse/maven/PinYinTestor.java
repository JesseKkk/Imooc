package com.jesse.maven;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.Scanner;

public class PinYinTestor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] pinyin = PinyinHelper.toHanyuPinyinStringArray('长');
        for (String py:pinyin){
            System.out.println(py);
        }
        System.out.println("你好");
    }
}
