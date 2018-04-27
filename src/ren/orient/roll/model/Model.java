package ren.orient.roll.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
	private List<String> names = new ArrayList<String>();
	private BufferedReader file = null; 
	private String filePath;
	
	public Model(String path) {
		this.filePath = path;
	}
	
	public List<String> getNames() {
		try {
			file = new BufferedReader(new FileReader(filePath));
			String name = file.readLine();
			while (name != null) {
				names.add(name);
				name = file.readLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return names;
	}

}
