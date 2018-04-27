package ren.orient.roll.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class RollView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// button size
	private int btnWidth = 80;
	private int btnHeight = 30;
	// 窗口大小
	private int framWidth = 400;
	private int frameHeight = 250;
	
	private JLabel textLabel = null;
	private String startLabel;
	private List<String> names = null;
	
	private int index = 0;
	// 定时器
	private Timer timer = null;
	
	public RollView(String title, String start, List<String> nameList) {
		
		names = nameList;
		
		this.setTitle(title);
		this.setVisible(true);
		this.setSize(framWidth, frameHeight);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.startLabel = start;
		
		addBtn();
		addTextLabel();
		
	}
	
	private void addBtn() {
		JButton startBtn = new JButton("Start");
		startBtn.setBounds(60, 150, btnWidth, btnHeight);
		this.add(startBtn);
		
		JButton stopBtn = new JButton("Stop");
		stopBtn.setBounds(240, 150, btnWidth, btnHeight);
		this.add(stopBtn);
		
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setTextLabel(names);
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
	
	private void addTextLabel() {
		textLabel = new JLabel(startLabel,JLabel.CENTER);
		textLabel.setBounds(100, 50, 200, 70);
		textLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		this.add(textLabel);
	}

	public void setTextLabel(List<String> names) {
		textLabel.setText(names.get(index));
		index++;
		if (index == names.size()) {
			index = 0;
		}
	}
	
}
