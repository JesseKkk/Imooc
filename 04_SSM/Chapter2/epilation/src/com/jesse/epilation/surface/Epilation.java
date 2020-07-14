package com.jesse.epilation.surface;

import com.mathworks.toolbox.javabuilder.MWException;
import sound.Class3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created by Kong on 2020/5/28.
 */
public class Epilation implements ActionListener {
    public static final Integer size = 8;
    public static final String[] paraNames = {"    密度kg/m3","      声速m/s","       频率Hz","  振元振速m/s",
                                            "  换能器半径m","  换能器口径m","换能器上口径m","   微元尺寸m"};
    public static final String[] paraInit = {"1000","1540","2000000","0.015",
                                            "0.012","0.01","0.006","0.0005"};
    JButton button;
    JTextField[] jts = new JTextField[size];
    String[] str = new String[size];
    double[] doubles = new double[size];

    private void go(){
        // 设置窗体的大小和标题
        JFrame jf = new JFrame("启动");
        jf.setPreferredSize(new Dimension(600, 600));
        // 设置关闭窗体就是关闭程序
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置这个窗体的布局管理器为网格布局管理器
        GridLayout glo = new GridLayout(size+2, 1);
        jf.setLayout(glo);

        //开始面板
        JPanel jpBegin = new JPanel(new BorderLayout());
        JLabel jlBegin = new JLabel("设置参数",JLabel.CENTER);
        jf.add(jpBegin);
        jpBegin.add(jlBegin,BorderLayout.CENTER);

        //面板size
        JPanel[] jps = new JPanel[size];
        for (int j = 0; j < size; j++) {
            jps[j] = new JPanel();
        }
        JLabel[] jls = new JLabel[size];
        for (int k = 0; k < size; k++) {
            jls[k] = new JLabel();
        }
        for (int z = 0; z < size; z++) {
            jts[z] = new JTextField();
        }
        for (int i = 0; i < size; i++) {
            jls[i].setText(paraNames[i]);
            jls[i].setFont(new Font("楷体", Font.BOLD, 13));
            jts[i].setText(paraInit[i]);
            jts[i].setColumns(10);
            //设置光标位置为文本内容的最后面
            jts[i].setCaretPosition(jts[i].getText().length());
            jf.add(jps[i]);
            jps[i].add(jls[i]);
            jps[i].add(jts[i]);
        }

        //结束面板
        JPanel jpEnd = new JPanel();
        button = new JButton("运行");
        //向按钮注册
        button.addActionListener(this);
        jf.add(jpEnd);
        jpEnd.add(button);


        //设置窗体可见,居中显示
        jf.pack();;
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //输入锁定
        button.setText("运行中");
        button.setEnabled(false);
        //得到数据
        for (int i = 0; i < size; i++) {
            jts[i].setEditable(false);
            str[i] = jts[i].getText();
        }
        for (int j = 0; j < size; j++) {
            doubles[j] = Double.parseDouble(str[j]);
        }
        //仿真
        try {
            Class3 c = new Class3();
            c.sound(doubles[0],doubles[1],doubles[2],doubles[3],doubles[4],doubles[5],doubles[6],doubles[7]);
        } catch (MWException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Epilation gui = new Epilation();
        gui.go();
    }
}
