package ren.orient.roll.main;

import ren.orient.roll.view.*;
import ren.orient.roll.model.*;
import java.util.List;

public class Roll {
	// 窗口标题
	private static String title = "test";
	// textLabel初始显示
	private static String label = "Press Start";
	// 文件路径
	private static String path = "./names.txt";

	
	public static void main(String[] args) {
		
		Model model = new Model(path);
		List<String> names = model.getNames();
		
		new RollView(title, label, names);
		
	}

}
