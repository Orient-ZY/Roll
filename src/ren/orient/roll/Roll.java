package ren.orient.roll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Roll extends JFrame {
    private int frameHeight = 250;
    private int frameWidth = 400;
    private int btnHeight = 30;
    private int btnWidth = 80;
    private int index = 0;
    private List<String> names = new ArrayList<String>();
    private JLabel textLab = null;
    private Timer timer = null;

    private Roll() {
        this.setTitle("Roll");
        this.setSize(frameWidth, frameHeight);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // 屏幕中央显示
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // 自定义布局
        //System.out.println(this.names);
        getNames();
        init();
        this.setVisible(true);

    }

    private void init() {
        JButton startBtn = new JButton("Start");
        startBtn.setBounds(60, 150, btnWidth, btnHeight);
        this.add(startBtn);

        JButton stopBtn = new JButton("Stop");
        stopBtn.setBounds(240, 150, btnWidth, btnHeight);
        this.add(stopBtn);

        this.textLab = new JLabel("Press Start", JLabel.CENTER);
        this.textLab.setBounds(100, 50, 200, 70);
        this.textLab.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        this.add(this.textLab);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLab.setText(names.get(index));
                //System.out.println(names.get(index));
                index++;
                if (index == names.size()) {
                    index = 0;
                }
            }
        });
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

    }

    private void getNames() {
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader("./names.txt"));
            String name = file.readLine();
            while (name != null) {
                this.names.add(name);
                name = file.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Roll();
    }
}
