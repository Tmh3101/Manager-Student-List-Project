package view;

import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AboutMeView extends JFrame {

	private JPanel contentPane;

	//Create the frame.
	public AboutMeView() {
		setTitle("About Me");
		setIconImage(Toolkit.getDefaultToolkit().createImage(AboutMeView.class.getResource("icon_aboutme.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 540);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_aboutme = new JLabel();
		label_aboutme.setBounds(5, 5, 516, 493);
		label_aboutme.setLayout(new FlowLayout());
		label_aboutme.setIcon(new ImageIcon(AboutMeView.class.getResource("aboutme.png")));
		contentPane.add(label_aboutme);
		setVisible(true);
	}

}
