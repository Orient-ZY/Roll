package ren.orient.roll.main;

import ren.orient.roll.view.*;
import ren.orient.roll.model.*;
import java.util.List;

public class Roll {
	// ���ڱ���
	private static String title = "test";
	// textLabel��ʼ��ʾ
	private static String label = "Press Start";
	// �ļ�·��
	private static String path = "./names.txt";

	
	public static void main(String[] args) {
		
		Model model = new Model(path);
		List<String> names = model.getNames();
		
		new RollView(title, label, names);
		
	}

}
