package test;

import view.ManagerListView;

public class Test {
	public static void main(String[] args) {
		try {
			new ManagerListView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}