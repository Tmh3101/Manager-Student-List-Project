package test;

//import javax.swing.UIManager;
import view.ManagerListView;

public class Test {
	public static void main(String[] args) {
		try {
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			new ManagerListView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}