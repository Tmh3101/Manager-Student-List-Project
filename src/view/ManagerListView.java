package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

import model.ManagerListModel;
import model.Province;
import model.ProvinceList;
import model.Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.ManagerListController;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class ManagerListView extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private ManagerListModel managerListModel;
	private JCheckBoxMenuItem chbxItem_darkMode;
	private JTable table;
	private JComboBox<String> cmbbx_stuInfor_pOB;
	private ButtonGroup bg_sex;
	private JLabel lbl_total;
	private JRadioButton rdbtn_stuInfor_male;
	private JRadioButton rdbtn_stuInfor_female;
	private JComboBox<String> cmbx_filter_pOB;


	private JPanel pnl_filter;
	private JLabel lbl_stuFilter;
	private JLabel lbl_pOBFilter;
	private JLabel lbl_stuIDFilter;
	private JTextField txtfld_stuIDFilter;
	private JButton btn_search;
	private JButton btn_cancelSearch;

	private JPanel pnl_stuInfor_left;
	private JLabel lbl_stuInfor;
	private JPanel pnl_empty1;
	private JLabel lbl_stuInfor_id;
	private JTextField txtfld_stuInfor_id;
	private JLabel lbl_stuInfor_name;
	private JTextField txtfld_studInfor_name;
	private JLabel lbl_stuInfor_pOB;
	private JLabel lbl_stuInfor_dOB;
	private JTextField txtfld_stuInfor_dOB;
	private JLabel lbl_stuInfor_sex;
	private JPanel pnl_male_female;

	private JPanel pnl_stuInfor;
	private JPanel pnl_stuInfor_right;
	private JPanel pnl_empty2;
	private JPanel pnl_empty3;
	private JLabel lbl_stuInfor_score1;
	private JTextField txtfld_score1;
	private JLabel lbl_stuInfor_score2;
	private JTextField txtfld_score2;
	private JLabel lbl_stuInfor_score3;
	private JTextField txtfld_score3;
	private JLabel lbl_stuInfor_total;
	private JPanel pnl_empty4;
	private JPanel pnl_empty5;

	private JPanel pnl_button;
	private JButton btn_insert;
	private JButton btn_delete;
	private JButton btn_edit;
	private JButton btn_clear;



	// Create the frame.
	public ManagerListView() {

		managerListModel = new ManagerListModel();
		setTitle("Manager Student List");
		setIconImage(Toolkit.getDefaultToolkit().createImage(ManagerListView.class.getResource("icon_list.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(350, 80, 850, 650);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		ManagerListController action = new ManagerListController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		Font fnt_menu = new Font("Arial", Font.PLAIN, 14);
		Font default_font = new Font("Calibri", Font.PLAIN, 16);

		JMenu menu_file = new JMenu("File");
		menu_file.setFont(fnt_menu);

		JMenuItem menuItem_open = new JMenuItem("Open");
		menuItem_open.setFont(fnt_menu);
		menuItem_open.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManagerListView.class.getResource("icon_open.png"))));
		menuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		menuItem_open.addActionListener(action);

		JMenuItem menuItem_save = new JMenuItem("Save");
		menuItem_save.setFont(fnt_menu);
		menuItem_save.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManagerListView.class.getResource("icon_save.png"))));
		menuItem_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		menuItem_save.addActionListener(action);

		JMenuItem menuItem_exit = new JMenuItem("Exit", KeyEvent.VK_E);
		menuItem_exit.setFont(fnt_menu);
		menuItem_exit.addActionListener(action);
		menuItem_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

		menu_file.add(menuItem_open);
		menu_file.add(menuItem_save);
		menu_file.add(new JSeparator());
		menu_file.add(menuItem_exit);
		menuBar.add(menu_file);

		JMenu menu_view = new JMenu("View");
		menu_view.setFont(fnt_menu);

		chbxItem_darkMode = new JCheckBoxMenuItem("Dark Mode");
		chbxItem_darkMode.setFont(fnt_menu);
		chbxItem_darkMode.addActionListener(action);
		menu_view.add(chbxItem_darkMode);
		menuBar.add(menu_view);

		JMenu menu_about = new JMenu("About");
		menu_about.setFont(fnt_menu);
		JMenuItem menuItem_aboutMe = new JMenuItem("About Me");
		menuItem_aboutMe.setFont(fnt_menu);
		menuItem_aboutMe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManagerListView.class.getResource("icon_aboutme.png"))));
		menuItem_aboutMe.addActionListener(action);
		menuBar.add(menu_about);
		menu_about.add(menuItem_aboutMe);

		pnl_filter = new JPanel();
		pnl_filter.setPreferredSize(new Dimension(20, 80));
		contentPane.add(pnl_filter, BorderLayout.NORTH);
		pnl_filter.setLayout(null);

		lbl_stuFilter = new JLabel("Student Filter");
		lbl_stuFilter.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lbl_stuFilter.setBounds(0, 0, 90, 15);
		pnl_filter.add(lbl_stuFilter);

		lbl_pOBFilter = new JLabel("Bitrth Place");
		lbl_pOBFilter.setFont(default_font);
		lbl_pOBFilter.setBounds(20, 30, 90, 25);
		pnl_filter.add(lbl_pOBFilter);

		cmbx_filter_pOB = new JComboBox<String>(ProvinceList.getProvinceNameList());
		cmbx_filter_pOB.setFont(default_font);
		cmbx_filter_pOB.setBounds(110, 30, 125, 25);
		cmbx_filter_pOB.setSelectedIndex(-1);
		pnl_filter.add(cmbx_filter_pOB);

		lbl_stuIDFilter = new JLabel("Student ID");
		lbl_stuIDFilter.setFont(default_font);
		lbl_stuIDFilter.setBounds(250, 30, 95, 25);
		pnl_filter.add(lbl_stuIDFilter);

		txtfld_stuIDFilter = new JTextField();
		txtfld_stuIDFilter.setFont(default_font);
		txtfld_stuIDFilter.setBounds(330, 30, 160, 25);
		pnl_filter.add(txtfld_stuIDFilter);
		txtfld_stuIDFilter.setColumns(10);

		btn_search = new JButton("Search");
		btn_search.addActionListener(action);
		btn_search.setFont(default_font);;
		btn_search.setBounds(510, 30, 130, 25);
		pnl_filter.add(btn_search);

		btn_cancelSearch = new JButton("Cancel Search");
		btn_cancelSearch.addActionListener(action);
		btn_cancelSearch.setFont(default_font);
		btn_cancelSearch.setBounds(670, 30, 130, 25);
		pnl_filter.add(btn_cancelSearch);

		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new GridLayout(2, 1, 0, 0));
		panel_center.setLayout(new GridLayout(2, 1));

		DefaultTableModel dtm = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Birth Palce", "Birth Day", "Sex", "Score 1", "Score 2", "Score 3" }){

			public boolean isCellEditable(int row, int column){
				return false;
			}

		};

		table = new JTable(dtm);
		table.setFont(default_font);
		//table.setModel(new DefaultTableModel(new Object[][] {},
		//		new String[] { "ID", "Name", "Birth Palce", "Birth Day", "Sex", "Score 1", "Score 2", "Score 3" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.setRowHeight(25);
		table.getTableHeader().setReorderingAllowed(false);
		
		
		JScrollPane scrollPane_table = new JScrollPane(table);
		panel_center.add(scrollPane_table);

		pnl_stuInfor = new JPanel();
		pnl_stuInfor.setLayout(new GridLayout(1, 2, 10, 10));


		pnl_stuInfor_left = new JPanel();
		pnl_stuInfor_left.setLayout(new GridLayout(6, 2, 10, 10));

		lbl_stuInfor = new JLabel("Student Information");
		lbl_stuInfor.setFont(new Font("Tahoma", Font.ITALIC, 14));
		pnl_stuInfor_left.add(lbl_stuInfor);

		pnl_empty1 = new JPanel();
		pnl_stuInfor_left.add(pnl_empty1);

		lbl_stuInfor_id = new JLabel("Student ID", JLabel.CENTER);
		lbl_stuInfor_id.setFont(default_font);
		pnl_stuInfor_left.add(lbl_stuInfor_id);

		txtfld_stuInfor_id = new JTextField();
		txtfld_stuInfor_id.setFont(default_font);
		txtfld_stuInfor_id.setColumns(10);
		pnl_stuInfor_left.add(txtfld_stuInfor_id);

		lbl_stuInfor_name = new JLabel("Name", JLabel.CENTER);
		lbl_stuInfor_name.setFont(default_font);
		pnl_stuInfor_left.add(lbl_stuInfor_name);

		txtfld_studInfor_name = new JTextField();
		txtfld_studInfor_name.setFont(default_font);
		txtfld_studInfor_name.setColumns(10);
		pnl_stuInfor_left.add(txtfld_studInfor_name);

		lbl_stuInfor_pOB = new JLabel("Birth Place", JLabel.CENTER);
		lbl_stuInfor_pOB.setFont(default_font);
		pnl_stuInfor_left.add(lbl_stuInfor_pOB);

		cmbbx_stuInfor_pOB = new JComboBox<String>(ProvinceList.getProvinceNameList());
		cmbbx_stuInfor_pOB.setFont(default_font);
		cmbbx_stuInfor_pOB.setSelectedIndex(-1);
		pnl_stuInfor_left.add(cmbbx_stuInfor_pOB);

		lbl_stuInfor_dOB = new JLabel("BirthDay", JLabel.CENTER);
		lbl_stuInfor_dOB.setFont(default_font);
		pnl_stuInfor_left.add(lbl_stuInfor_dOB);

		txtfld_stuInfor_dOB = new JTextField();
		txtfld_stuInfor_dOB.setFont(default_font);
		txtfld_stuInfor_dOB.setColumns(10);
		pnl_stuInfor_left.add(txtfld_stuInfor_dOB);

		lbl_stuInfor_sex = new JLabel("Sex", JLabel.CENTER);
		lbl_stuInfor_sex.setFont(default_font);
		pnl_stuInfor_left.add(lbl_stuInfor_sex);

		pnl_male_female = new JPanel();
		pnl_male_female.setLayout(new GridLayout(1, 2));


		rdbtn_stuInfor_male = new JRadioButton("Male");
		rdbtn_stuInfor_male.setFont(default_font);
		rdbtn_stuInfor_male.setActionCommand("Male");
		rdbtn_stuInfor_male.addActionListener(action);
		pnl_male_female.add(rdbtn_stuInfor_male);

		rdbtn_stuInfor_female = new JRadioButton("Female");
		rdbtn_stuInfor_female.setFont(default_font);
		rdbtn_stuInfor_female.setActionCommand("Female");
		rdbtn_stuInfor_female.addActionListener(action);
		pnl_male_female.add(rdbtn_stuInfor_female);

		pnl_stuInfor_left.add(pnl_male_female);

		bg_sex = new ButtonGroup();
		bg_sex.add(rdbtn_stuInfor_male);
		bg_sex.add(rdbtn_stuInfor_female);

		pnl_stuInfor_right = new JPanel();
		pnl_stuInfor_right.setLayout(new GridLayout(6, 2, 10, 10));

		pnl_empty2 = new JPanel();
		pnl_stuInfor_right.add(pnl_empty2);

		pnl_empty3 = new JPanel();
		pnl_stuInfor_right.add(pnl_empty3);

		lbl_stuInfor_score1 = new JLabel("Score of subject 1", JLabel.CENTER);
		lbl_stuInfor_score1.setFont(default_font);
		pnl_stuInfor_right.add(lbl_stuInfor_score1);

		txtfld_score1 = new JTextField();
		txtfld_score1.setFont(default_font);
		txtfld_score1.setColumns(10);
		pnl_stuInfor_right.add(txtfld_score1);

		lbl_stuInfor_score2 = new JLabel("Score of subject 2", JLabel.CENTER);
		lbl_stuInfor_score2.setFont(default_font);
		pnl_stuInfor_right.add(lbl_stuInfor_score2);

		txtfld_score2 = new JTextField();
		txtfld_score2.setFont(default_font);
		txtfld_score2.setColumns(10);
		pnl_stuInfor_right.add(txtfld_score2);

		lbl_stuInfor_score3 = new JLabel("Score of subject 3", JLabel.CENTER);
		lbl_stuInfor_score3.setFont(default_font);
		pnl_stuInfor_right.add(lbl_stuInfor_score3);

		txtfld_score3 = new JTextField();
		txtfld_score3.setFont(default_font);
		txtfld_score3.setColumns(10);
		pnl_stuInfor_right.add(txtfld_score3);

		lbl_stuInfor_total = new JLabel("Total", JLabel.CENTER);
		lbl_stuInfor_total.setFont(default_font);
		pnl_stuInfor_right.add(lbl_stuInfor_total);

		lbl_total = new JLabel("0.0");
		lbl_total.setFont(default_font);
		pnl_stuInfor_right.add(lbl_total);

		pnl_empty4 = new JPanel();
		pnl_stuInfor_right.add(pnl_empty4);

		pnl_empty5 = new JPanel();
		pnl_stuInfor_right.add(pnl_empty5);

		pnl_stuInfor.add(pnl_stuInfor_left);
		pnl_stuInfor.add(pnl_stuInfor_right);
		panel_center.add(pnl_stuInfor);

		pnl_button = new JPanel();
		pnl_button.setPreferredSize(new Dimension(20, 50));
		contentPane.add(pnl_button, BorderLayout.SOUTH);
		pnl_button.setLayout(new GridLayout(1, 4, 25, 0));

		btn_insert = new JButton("Insert");
		btn_insert.setFont(default_font);
		btn_insert.addActionListener(action);
		pnl_button.add(btn_insert);

		btn_delete = new JButton("Delete");
		btn_delete.setFont(default_font);
		btn_delete.addActionListener(action);
		pnl_button.add(btn_delete);

		btn_edit = new JButton("Edit");
		btn_edit.setFont(default_font);
		btn_edit.addActionListener(action);
		pnl_button.add(btn_edit);

		btn_clear = new JButton("Clear");
		btn_clear.setFont(default_font);
		btn_clear.addActionListener(action);
		pnl_button.add(btn_clear);

		setDisplay();
		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public ManagerListModel getManagerListModel() {
		return managerListModel;
	}

	public JTextField gettxtfld_stuIDFilter() {
		return txtfld_stuIDFilter;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField gettxtfld_stuInfor_id() {
		return txtfld_stuInfor_id;
	}

	public JTextField gettxtfld_studInfor_name() {
		return txtfld_studInfor_name;
	}

	public JTextField gettxtfld_stuInfor_dOB() {
		return txtfld_stuInfor_dOB;
	}

	public JTextField gettxtfld_score1() {
		return txtfld_score1;
	}

	public JTextField gettxtfld_score2() {
		return txtfld_score2;
	}

	public JTextField gettxtfld_score3() {
		return txtfld_score3;
	}

	public JComboBox<String> getcmbbx_stuInfor_pOB() {
		return cmbbx_stuInfor_pOB;
	}

	public ButtonGroup getBg_sex() {
		return bg_sex;
	}

	public JLabel getLbl_total() {
		return lbl_total;
	}

	public JButton getbtn_edit() {
		return btn_edit;
	}

	public Student getSelectedStudent() {
		return managerListModel.getStudentList().get(table.getSelectedRow());
	}

	public Student getStudentFromForm() {
		Student student;
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date birthDay = df.parse(txtfld_stuInfor_dOB.getText());
			student = new Student(txtfld_stuInfor_id.getText(),
					txtfld_studInfor_name.getText(),
					new Province(cmbbx_stuInfor_pOB.getSelectedIndex()), birthDay,
					bg_sex.getSelection().getActionCommand().equals("Male"),
					Float.valueOf(txtfld_score1.getText()),
					Float.valueOf(txtfld_score2.getText()),
					Float.valueOf(txtfld_score3.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Information is not valid");
			return null;
		}
		return student;
	}

	public void clearForm() {
		txtfld_stuInfor_id.setText("");
		txtfld_studInfor_name.setText("");
		cmbbx_stuInfor_pOB.setSelectedIndex(-1);
		txtfld_stuInfor_dOB.setText("");
		bg_sex.clearSelection();
		txtfld_score1.setText("");
		txtfld_score2.setText("");
		txtfld_score3.setText("");
		lbl_total.setText("0.0");
		JOptionPane.showMessageDialog(this, "Form has been cleared");
	}

	@SuppressWarnings("deprecation")
	public void insertStudent() {
		if (managerListModel.isDuplicate(txtfld_stuInfor_id.getText())) {
			JOptionPane.showMessageDialog(this, "Student id is duplicate");
		} else {
			Student student = getStudentFromForm();
			if (student != null) {
				managerListModel.insert(student);
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.addRow(new Object[] { student.getId(), student.getName(), student.getBirthPlace(),
						student.getBirthDay().getDate() + "/" + (student.getBirthDay().getMonth() + 1) + "/"
								+ (student.getBirthDay().getYear() + 1900),
						(student.isSex_isMale()) ? "Male" : "Female", student.getScore1(), student.getScore2(),
						student.getScore3() });
				lbl_total.setText((student.getScore1() + student.getScore2() + student.getScore3()) + "");
				JOptionPane.showMessageDialog(this, "Insert student successfully");
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void loadStudentToFormToEdit() {
		try {
			Student student = getSelectedStudent();
			txtfld_stuInfor_id.setText(student.getId());
			txtfld_studInfor_name.setText(student.getName());
			cmbbx_stuInfor_pOB.setSelectedIndex(managerListModel.getProvinceList().getIndexOf(student.getBirthPlace()) + 1);
			txtfld_stuInfor_dOB.setText(student.getBirthDay().getDate() + "/"
					+ (student.getBirthDay().getMonth() + 1) + "/" + (student.getBirthDay().getYear() + 1900));
			if (student.isSex_isMale())
				rdbtn_stuInfor_male.setSelected(true);
			else
				rdbtn_stuInfor_female.setSelected(true);
			txtfld_score1.setText(student.getScore1() + "");
			txtfld_score2.setText(student.getScore2() + "");
			txtfld_score3.setText(student.getScore3() + "");
			lbl_total.setText((student.getScore1() + student.getScore2() + student.getScore3()) + "");

			btn_edit.setText("Done");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Let choose a student");
		}
	}

	public void completedEditing() {
		editStudent(getStudentFromForm());
		clearForm();
		btn_edit.setText("Edit");
		JOptionPane.showMessageDialog(this, "Edit student successfully");
	}

	@SuppressWarnings("deprecation")
	public void editStudent(Student student) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		managerListModel.getStudentList().get(table.getSelectedRow()).edit(student);
		int i = 0;
		dtm.setValueAt(student.getId(), table.getSelectedRow(), i++);
		dtm.setValueAt(student.getName(), table.getSelectedRow(), i++);
		dtm.setValueAt(student.getBirthPlace(), table.getSelectedRow(), i++);
		dtm.setValueAt(student.getBirthDay().getDate() + "/" + (student.getBirthDay().getMonth() + 1) + "/"
				+ (student.getBirthDay().getYear() + 1900), table.getSelectedRow(), i++);
		dtm.setValueAt((student.isSex_isMale()) ? "Male" : "Female", table.getSelectedRow(), i++);
		dtm.setValueAt(student.getScore1(), table.getSelectedRow(), i++);
		dtm.setValueAt(student.getScore2(), table.getSelectedRow(), i++);
		dtm.setValueAt(student.getScore3(), table.getSelectedRow(), i++);
	}

	public void removeStudent() {

		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Let choose a student");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Do you want delete this student") == JOptionPane.YES_OPTION) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				managerListModel.delete(getSelectedStudent());
				dtm.removeRow(table.getSelectedRow());

			}
		}
	}

	@SuppressWarnings("deprecation")
	public void setTable(ArrayList<Student> list) {

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		for (Student student : list) {
			dtm.addRow(new Object[] { student.getId(), student.getName(), student.getBirthPlace(),
					student.getBirthDay().getDate() + "/" + (student.getBirthDay().getMonth() + 1) + "/"
							+ (student.getBirthDay().getYear() + 1900),
					(student.isSex_isMale()) ? "Male" : "Female", student.getScore1(), student.getScore2(),
					student.getScore3() });
		}
	}

	public void filter() {
		ArrayList<Student> filteredList = new ArrayList<Student>();
		if (cmbx_filter_pOB.getSelectedIndex() != -1 && txtfld_stuIDFilter.getText().isEmpty()) {
			for (Student student : managerListModel.getStudentList()) {
				if (student.getBirthPlace().getName().equals(cmbx_filter_pOB.getSelectedItem().toString()))
					filteredList.add(student);
			}
			setTable(filteredList);
		} else if (cmbx_filter_pOB.getSelectedIndex() == -1
				&& !(txtfld_stuIDFilter.getText().isEmpty())) {
			for (Student student : managerListModel.getStudentList()) {
				if (student.getId().equals(txtfld_stuIDFilter.getText()))
					filteredList.add(student);
			}
			setTable(filteredList);
		} else if (cmbx_filter_pOB.getSelectedIndex() != -1
				&& !(txtfld_stuIDFilter.getText().isEmpty())) {
			for (Student student : managerListModel.getStudentList()) {
				if (student.getBirthPlace().getName().equals(cmbx_filter_pOB.getSelectedItem().toString())
						&& student.getId().equals(txtfld_stuIDFilter.getText()))
					filteredList.add(student);
			}
			setTable(filteredList);
		} else {
			JOptionPane.showMessageDialog(this, "Let choose a province or enter the student code");
		}
	}

	public void cancelFilter() {
		setTable(managerListModel.getStudentList());
		cmbx_filter_pOB.setSelectedIndex(-1);
		txtfld_stuIDFilter.setText("");
	}

	public void saveStudentListToFile() {
		JFileChooser fc = new JFileChooser();
		if (managerListModel.getCurentFileName().length() > 0) {
			managerListModel.saveStudentListToFile(new File(managerListModel.getCurentFileName()));
			JOptionPane.showMessageDialog(this, "Save student successfully");
		} else {
			if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				managerListModel.saveStudentListToFile(fc.getSelectedFile().getAbsoluteFile());
				JOptionPane.showMessageDialog(this, "Save student successfully");
			}
		}
	}

	public void loadStudentListFromFile() {
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			managerListModel.loadStudentListFromFile(fc.getSelectedFile().getAbsoluteFile());
			setTable(managerListModel.getStudentList());
			JOptionPane.showMessageDialog(this, "Open student successfully");
		}
	}

	public void showMyInformation(){
		new AboutMeView();
	}

	public void setDisplay(){
		if(chbxItem_darkMode.isSelected()){
			contentPane.setBackground(Color.decode("#353b48"));

			//filter
			pnl_filter.setBackground(Color.decode("#353b48"));
			lbl_stuFilter.setForeground(Color.decode("#ecf0f1"));
			lbl_pOBFilter.setForeground(Color.decode("#ecf0f1"));

			cmbx_filter_pOB.setOpaque(true);
			cmbx_filter_pOB.setBackground(Color.decode("#808e9b"));
			cmbx_filter_pOB.setForeground(Color.decode("#ecf0f1"));

			lbl_stuIDFilter.setForeground(Color.decode("#ecf0f1"));

			txtfld_stuIDFilter.setBackground(Color.decode("#808e9b"));
			txtfld_stuIDFilter.setForeground(Color.decode("#ecf0f1"));

			btn_search.setBackground(Color.decode("#808e9b"));
			btn_search.setForeground(Color.decode("#ecf0f1"));

			btn_cancelSearch.setBackground(Color.decode("#808e9b"));
			btn_cancelSearch.setForeground(Color.decode("#ecf0f1"));

			//table
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();

			dtcr.setBackground(Color.decode("#808e9b"));
			dtcr.setForeground(Color.decode("#ecf0f1"));

			for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(dtcr);
            }


			//infor
			pnl_stuInfor.setBackground(Color.decode("#353b48"));

			pnl_stuInfor_left.setBackground(Color.decode("#353b48"));

			lbl_stuInfor.setOpaque(true);
			lbl_stuInfor.setBackground(Color.decode("#353b48"));
			lbl_stuInfor.setForeground(Color.decode("#ecf0f1"));

			pnl_empty1.setBackground(Color.decode("#353b48"));

			lbl_stuInfor_id.setOpaque(true);
			lbl_stuInfor_id.setBackground(Color.decode("#353b48"));
			lbl_stuInfor_id.setForeground(Color.decode("#ecf0f1"));

			txtfld_stuInfor_id.setBackground(Color.decode("#808e9b"));
			txtfld_stuInfor_id.setForeground(Color.decode("#ecf0f1"));

			lbl_stuInfor_name.setOpaque(true);
			lbl_stuInfor_name.setBackground(Color.decode("#353b48"));
			lbl_stuInfor_name.setForeground(Color.decode("#ecf0f1"));

			txtfld_studInfor_name.setBackground(Color.decode("#808e9b"));
			txtfld_studInfor_name.setForeground(Color.decode("#ecf0f1"));


			lbl_stuInfor_pOB.setOpaque(true);
			lbl_stuInfor_pOB.setBackground(Color.decode("#353b48"));
			lbl_stuInfor_pOB.setForeground(Color.decode("#ecf0f1"));

			cmbbx_stuInfor_pOB.setOpaque(true);
			cmbbx_stuInfor_pOB.setBackground(Color.decode("#808e9b"));
			cmbbx_stuInfor_pOB.setForeground(Color.decode("#ecf0f1"));

			lbl_stuInfor_dOB.setOpaque(true);
			lbl_stuInfor_dOB.setBackground(Color.decode("#353b48"));
			lbl_stuInfor_dOB.setForeground(Color.decode("#ecf0f1"));

			txtfld_stuInfor_dOB.setBackground(Color.decode("#808e9b"));
			txtfld_stuInfor_dOB.setForeground(Color.decode("#ecf0f1"));


			lbl_stuInfor_sex.setOpaque(true);
			lbl_stuInfor_sex.setBackground(Color.decode("#353b48"));
			lbl_stuInfor_sex.setForeground(Color.decode("#ecf0f1"));

			pnl_male_female.setBackground(Color.decode("#353b48"));

			rdbtn_stuInfor_male.setBackground(Color.decode("#353b48"));
			rdbtn_stuInfor_male.setForeground(Color.decode("#ecf0f1"));

			rdbtn_stuInfor_female.setBackground(Color.decode("#353b48"));
			rdbtn_stuInfor_female.setForeground(Color.decode("#ecf0f1"));

			pnl_stuInfor_right.setBackground(Color.decode("#353b48"));

			pnl_empty2.setBackground(Color.decode("#353b48"));

			pnl_empty3.setBackground(Color.decode("#353b48"));

			lbl_stuInfor_score1.setOpaque(true);
			lbl_stuInfor_score1.setBackground(Color.decode("#353b48"));
			lbl_stuInfor_score1.setForeground(Color.decode("#ecf0f1"));

			txtfld_score1.setBackground(Color.decode("#808e9b"));
			txtfld_score1.setForeground(Color.decode("#ecf0f1"));

			lbl_stuInfor_score2.setOpaque(true);
			lbl_stuInfor_score2.setBackground(Color.decode("#353b48"));
			lbl_stuInfor_score2.setForeground(Color.decode("#ecf0f1"));

			txtfld_score2.setBackground(Color.decode("#808e9b"));
			txtfld_score2.setForeground(Color.decode("#ecf0f1"));

			lbl_stuInfor_score3.setOpaque(true);
			lbl_stuInfor_score3.setBackground(Color.decode("#353b48"));
			lbl_stuInfor_score3.setForeground(Color.decode("#ecf0f1"));

			txtfld_score3.setBackground(Color.decode("#808e9b"));
			txtfld_score3.setForeground(Color.decode("#ecf0f1"));

			lbl_stuInfor_total.setOpaque(true);
			lbl_stuInfor_total.setBackground(Color.decode("#353b48"));
			lbl_stuInfor_total.setForeground(Color.decode("#ecf0f1"));

			lbl_total.setOpaque(true);
			lbl_total.setBackground(Color.decode("#353b48"));
			lbl_total.setForeground(Color.decode("#ecf0f1"));

			pnl_empty4.setBackground(Color.decode("#353b48"));

			pnl_empty5.setBackground(Color.decode("#353b48"));

			//button
			pnl_button.setBackground(Color.decode("#353b48"));

			btn_insert.setBackground(Color.decode("#808e9b"));
			btn_insert.setForeground(Color.decode("#ecf0f1"));

			btn_delete.setBackground(Color.decode("#808e9b"));
			btn_delete.setForeground(Color.decode("#ecf0f1"));

			btn_edit.setBackground(Color.decode("#808e9b"));
			btn_edit.setForeground(Color.decode("#ecf0f1"));

			btn_clear.setBackground(Color.decode("#808e9b"));
			btn_clear.setForeground(Color.decode("#ecf0f1"));

		} else {

			contentPane.setBackground(Color.decode("#ecf0f1"));

			//filter
			pnl_filter.setBackground(Color.decode("#ecf0f1"));
			lbl_stuFilter.setForeground(Color.decode("#353b48"));
			lbl_pOBFilter.setForeground(Color.decode("#353b48"));

			cmbx_filter_pOB.setOpaque(true);
			cmbx_filter_pOB.setBackground(Color.decode("#ecf0f1"));
			cmbx_filter_pOB.setForeground(Color.decode("#353b48"));

			lbl_stuIDFilter.setForeground(Color.decode("#353b48"));

			txtfld_stuIDFilter.setBackground(Color.WHITE);
			txtfld_stuIDFilter.setForeground(Color.decode("#353b48"));

			btn_search.setBackground(Color.decode("#ecf0f1"));
			btn_search.setForeground(Color.decode("#353b48"));

			btn_cancelSearch.setBackground(Color.decode("#ecf0f1"));
			btn_cancelSearch.setForeground(Color.decode("#353b48"));

			//table
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();

			dtcr.setBackground(Color.decode("#ecf0f1"));
			dtcr.setForeground(Color.decode("#353b48"));

			for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(dtcr);
            }

			//infor
			pnl_stuInfor.setBackground(Color.decode("#ecf0f1"));

			pnl_stuInfor_left.setBackground(Color.decode("#ecf0f1"));

			lbl_stuInfor.setOpaque(true);
			lbl_stuInfor.setBackground(Color.decode("#ecf0f1"));
			lbl_stuInfor.setForeground(Color.decode("#353b48"));

			pnl_empty1.setBackground(Color.decode("#ecf0f1"));

			lbl_stuInfor_id.setOpaque(true);
			lbl_stuInfor_id.setBackground(Color.decode("#ecf0f1"));
			lbl_stuInfor_id.setForeground(Color.decode("#353b48"));

			txtfld_stuInfor_id.setBackground(Color.WHITE);
			txtfld_stuInfor_id.setForeground(Color.decode("#353b48"));

			lbl_stuInfor_name.setOpaque(true);
			lbl_stuInfor_name.setBackground(Color.decode("#ecf0f1"));
			lbl_stuInfor_name.setForeground(Color.decode("#353b48"));

			txtfld_studInfor_name.setBackground(Color.WHITE);
			txtfld_studInfor_name.setForeground(Color.decode("#353b48"));


			lbl_stuInfor_pOB.setOpaque(true);
			lbl_stuInfor_pOB.setBackground(Color.decode("#ecf0f1"));
			lbl_stuInfor_pOB.setForeground(Color.decode("#353b48"));

			cmbbx_stuInfor_pOB.setOpaque(true);
			cmbbx_stuInfor_pOB.setBackground(Color.decode("#ecf0f1"));
			cmbbx_stuInfor_pOB.setForeground(Color.decode("#353b48"));

			lbl_stuInfor_dOB.setOpaque(true);
			lbl_stuInfor_dOB.setBackground(Color.decode("#ecf0f1"));
			lbl_stuInfor_dOB.setForeground(Color.decode("#353b48"));

			txtfld_stuInfor_dOB.setBackground(Color.WHITE);
			txtfld_stuInfor_dOB.setForeground(Color.decode("#353b48"));


			lbl_stuInfor_sex.setOpaque(true);
			lbl_stuInfor_sex.setBackground(Color.decode("#ecf0f1"));
			lbl_stuInfor_sex.setForeground(Color.decode("#353b48"));

			pnl_male_female.setBackground(Color.decode("#ecf0f1"));

			rdbtn_stuInfor_male.setBackground(Color.decode("#ecf0f1"));
			rdbtn_stuInfor_male.setForeground(Color.decode("#353b48"));

			rdbtn_stuInfor_female.setBackground(Color.decode("#ecf0f1"));
			rdbtn_stuInfor_female.setForeground(Color.decode("#353b48"));

			pnl_stuInfor_right.setBackground(Color.decode("#ecf0f1"));

			pnl_empty2.setBackground(Color.decode("#ecf0f1"));

			pnl_empty3.setBackground(Color.decode("#ecf0f1"));

			lbl_stuInfor_score1.setOpaque(true);
			lbl_stuInfor_score1.setBackground(Color.decode("#ecf0f1"));
			lbl_stuInfor_score1.setForeground(Color.decode("#353b48"));

			txtfld_score1.setBackground(Color.WHITE);
			txtfld_score1.setForeground(Color.decode("#353b48"));

			lbl_stuInfor_score2.setOpaque(true);
			lbl_stuInfor_score2.setBackground(Color.decode("#ecf0f1"));
			lbl_stuInfor_score2.setForeground(Color.decode("#353b48"));

			txtfld_score2.setBackground(Color.WHITE);
			txtfld_score2.setForeground(Color.decode("#353b48"));

			lbl_stuInfor_score3.setOpaque(true);
			lbl_stuInfor_score3.setBackground(Color.decode("#ecf0f1"));
			lbl_stuInfor_score3.setForeground(Color.decode("#353b48"));

			txtfld_score3.setBackground(Color.decode("#ecf0f1"));
			txtfld_score3.setForeground(Color.decode("#353b48"));

			lbl_stuInfor_total.setOpaque(true);
			lbl_stuInfor_total.setBackground(Color.decode("#ecf0f1"));
			lbl_stuInfor_total.setForeground(Color.decode("#353b48"));

			lbl_total.setOpaque(true);
			lbl_total.setBackground(Color.decode("#ecf0f1"));
			lbl_total.setForeground(Color.decode("#353b48"));

			pnl_empty4.setBackground(Color.decode("#ecf0f1"));

			pnl_empty5.setBackground(Color.decode("#ecf0f1"));

			//button
			pnl_button.setBackground(Color.decode("#ecf0f1"));

			btn_insert.setBackground(Color.decode("#ecf0f1"));
			btn_insert.setForeground(Color.decode("#353b48"));

			btn_delete.setBackground(Color.decode("#ecf0f1"));
			btn_delete.setForeground(Color.decode("#353b48"));

			btn_edit.setBackground(Color.decode("#ecf0f1"));
			btn_edit.setForeground(Color.decode("#353b48"));

			btn_clear.setBackground(Color.decode("#ecf0f1"));
			btn_clear.setForeground(Color.decode("#353b48"));



		}
	}

}
