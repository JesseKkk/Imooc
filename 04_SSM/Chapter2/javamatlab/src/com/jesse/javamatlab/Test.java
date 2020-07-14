package com.jesse.javamatlab;

import com.mathworks.toolbox.javabuilder.MWException;
import sound.Class3;

/**
 * Created by Kong on 2020/5/28.
 */
public class Test {
    public static void main(String[] args) throws MWException {
        Class3 c = new Class3();
        double a = 1000;
        double b = 1540;
        double d = 2000000;
        double e = 0.015;
        double f = 0.012;
        double g = 0.01;
        double h = 0.006;
        double i = 0.0005;

        c.sound(a,b,d,e,f,g,h,i);
    }
}
