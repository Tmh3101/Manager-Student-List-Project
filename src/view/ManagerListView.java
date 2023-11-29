package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

import model.ManagerListModel;
import model.Province;
import model.ProvinceList;
import model.Student;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.ManagerListController;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class ManagerListView extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private ManagerListModel managerListModel;
	private JTextField textField_studentCodeFilter;
	private JTable table;
	private JTextField textField_studentInformation_code;
	private JTextField textField_studentInformation_name;
	private JTextField textField_studentInformation_birthDay;
	private JTextField textField_scoreOfSubject1;
	private JTextField textField_scoreOfSubject2;
	private JTextField textField_scoreOfSubject3;
	private JComboBox<String> comboBox_studentInformation_birthPlace;
	private ButtonGroup bg_sex;
	private JLabel label_total;
	private JRadioButton radioButton_studentInformation_sex_male;
	private JRadioButton radioButton_studentInformation_sex_female;
	private JButton button_edit;
	private JComboBox<String> comboBox_filter_birthPlace;

	// Create the frame.
	public ManagerListView() {
		setTitle("Manager Student List");
		managerListModel = new ManagerListModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		ManagerListController action = new ManagerListController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu_file = new JMenu("File");
		JMenuItem menuItem_open = new JMenuItem("Open");
		menuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		menuItem_open.addActionListener(action);
		JMenuItem menuItem_save = new JMenuItem("Save");
		menuItem_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		menuItem_save.addActionListener(action);
		JMenuItem menuItem_exit = new JMenuItem("Exit", KeyEvent.VK_E);
		menuItem_exit.addActionListener(action);
		menuItem_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

		menu_file.add(menuItem_open);
		menu_file.add(menuItem_save);
		menu_file.add(new JSeparator());
		menu_file.add(menuItem_exit);
		menuBar.add(menu_file);

		JMenu menu_about = new JMenu("About");
		JMenuItem menuItem_AboutMe = new JMenuItem("About Me");
		menuBar.add(menu_about);
		menu_about.add(menuItem_AboutMe);

		JPanel panel_filter = new JPanel();
		panel_filter.setPreferredSize(new Dimension(20, 80));
		contentPane.add(panel_filter, BorderLayout.NORTH);
		panel_filter.setLayout(null);

		JLabel label_studentFilter = new JLabel("Student Filter");
		label_studentFilter.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label_studentFilter.setBounds(0, 0, 90, 15);
		panel_filter.add(label_studentFilter);

		JLabel label_birthPlaceFilter = new JLabel("Bitrth Place");
		label_birthPlaceFilter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_birthPlaceFilter.setBounds(20, 30, 90, 25);
		panel_filter.add(label_birthPlaceFilter);

		comboBox_filter_birthPlace = new JComboBox<String>(ProvinceList.getProvinceNameList());
		comboBox_filter_birthPlace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_filter_birthPlace.setBounds(110, 30, 125, 25);
		comboBox_filter_birthPlace.setSelectedIndex(-1);
		panel_filter.add(comboBox_filter_birthPlace);

		JLabel label_studentCodeFilter = new JLabel("Student Code");
		label_studentCodeFilter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_studentCodeFilter.setBounds(250, 30, 95, 25);
		panel_filter.add(label_studentCodeFilter);

		textField_studentCodeFilter = new JTextField();
		textField_studentCodeFilter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_studentCodeFilter.setBounds(350, 30, 160, 25);
		panel_filter.add(textField_studentCodeFilter);
		textField_studentCodeFilter.setColumns(10);

		JButton button_search = new JButton("Search");
		button_search.addActionListener(action);
		button_search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_search.setBounds(525, 30, 125, 25);
		panel_filter.add(button_search);

		JButton button_cancelSearch = new JButton("Cancel Search");
		button_cancelSearch.addActionListener(action);
		button_cancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_cancelSearch.setBounds(670, 30, 125, 25);
		panel_filter.add(button_cancelSearch);

		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new GridLayout(2, 1, 0, 0));
		panel_center.setLayout(new GridLayout(2, 1));

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Code", "Name", "Birth Palce", "Birth Day", "Sex", "Score 1", "Score 2", "Score 3" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		
		
		JScrollPane scrollPane_table = new JScrollPane(table);
		panel_center.add(scrollPane_table);

		JPanel panel_studentInformation = new JPanel();
		panel_center.add(panel_studentInformation);
		panel_studentInformation.setLayout(null);

		JLabel label_studentInformation = new JLabel("Student Information");
		label_studentInformation.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label_studentInformation.setBounds(0, 0, 142, 13);
		panel_studentInformation.add(label_studentInformation);

		JLabel label_studentInformation_code = new JLabel("Student Code");
		label_studentInformation_code.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_studentInformation_code.setBounds(10, 30, 110, 30);
		panel_studentInformation.add(label_studentInformation_code);

		JLabel label_studentInformation_name = new JLabel("Name");
		label_studentInformation_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_studentInformation_name.setBounds(10, 75, 110, 30);
		panel_studentInformation.add(label_studentInformation_name);

		JLabel label_studentInformation_birthPlace = new JLabel("Birth Place");
		label_studentInformation_birthPlace.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_studentInformation_birthPlace.setBounds(10, 120, 110, 30);
		panel_studentInformation.add(label_studentInformation_birthPlace);

		JLabel label_studentInformation_birthDay = new JLabel("BirthDay");
		label_studentInformation_birthDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_studentInformation_birthDay.setBounds(10, 165, 110, 30);
		panel_studentInformation.add(label_studentInformation_birthDay);

		JLabel label_studentInformation_sex = new JLabel("Sex");
		label_studentInformation_sex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_studentInformation_sex.setBounds(10, 210, 110, 30);
		panel_studentInformation.add(label_studentInformation_sex);

		textField_studentInformation_code = new JTextField();
		textField_studentInformation_code.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_studentInformation_code.setColumns(10);
		textField_studentInformation_code.setBounds(140, 30, 200, 30);
		panel_studentInformation.add(textField_studentInformation_code);

		textField_studentInformation_name = new JTextField();
		textField_studentInformation_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_studentInformation_name.setColumns(10);
		textField_studentInformation_name.setBounds(140, 75, 200, 30);
		panel_studentInformation.add(textField_studentInformation_name);

		textField_studentInformation_birthDay = new JTextField();
		textField_studentInformation_birthDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_studentInformation_birthDay.setColumns(10);
		textField_studentInformation_birthDay.setBounds(140, 165, 200, 30);
		panel_studentInformation.add(textField_studentInformation_birthDay);

		comboBox_studentInformation_birthPlace = new JComboBox<String>(ProvinceList.getProvinceNameList());
		comboBox_studentInformation_birthPlace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_studentInformation_birthPlace.setBounds(140, 120, 200, 30);
		comboBox_studentInformation_birthPlace.setSelectedIndex(-1);
		panel_studentInformation.add(comboBox_studentInformation_birthPlace);

		radioButton_studentInformation_sex_male = new JRadioButton("Male");
		radioButton_studentInformation_sex_male.setActionCommand("Male");
		radioButton_studentInformation_sex_male.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_studentInformation_sex_male.setBounds(140, 210, 100, 30);
		radioButton_studentInformation_sex_male.addActionListener(action);
		panel_studentInformation.add(radioButton_studentInformation_sex_male);

		radioButton_studentInformation_sex_female = new JRadioButton("Female");
		radioButton_studentInformation_sex_female.setActionCommand("Female");
		radioButton_studentInformation_sex_female.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_studentInformation_sex_female.setBounds(240, 210, 100, 30);
		radioButton_studentInformation_sex_female.addActionListener(action);
		panel_studentInformation.add(radioButton_studentInformation_sex_female);

		bg_sex = new ButtonGroup();
		bg_sex.add(radioButton_studentInformation_sex_male);
		bg_sex.add(radioButton_studentInformation_sex_female);

		JLabel label_studentInformation_score_1 = new JLabel("Score of subject 1");
		label_studentInformation_score_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_studentInformation_score_1.setBounds(390, 30, 140, 30);
		panel_studentInformation.add(label_studentInformation_score_1);

		textField_scoreOfSubject1 = new JTextField();
		textField_scoreOfSubject1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_scoreOfSubject1.setColumns(10);
		textField_scoreOfSubject1.setBounds(550, 30, 200, 30);
		panel_studentInformation.add(textField_scoreOfSubject1);

		JLabel label_studentInformation_score_2 = new JLabel("Score of subject 2");
		label_studentInformation_score_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_studentInformation_score_2.setBounds(390, 75, 140, 30);
		panel_studentInformation.add(label_studentInformation_score_2);

		textField_scoreOfSubject2 = new JTextField();
		textField_scoreOfSubject2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_scoreOfSubject2.setColumns(10);
		textField_scoreOfSubject2.setBounds(550, 75, 200, 30);
		panel_studentInformation.add(textField_scoreOfSubject2);

		JLabel label_studentInformation_score_3 = new JLabel("Score of subject 3");
		label_studentInformation_score_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_studentInformation_score_3.setBounds(390, 120, 140, 30);
		panel_studentInformation.add(label_studentInformation_score_3);

		JLabel label_studentInformation_total = new JLabel("Total");
		label_studentInformation_total.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_studentInformation_total.setBounds(390, 165, 140, 30);
		panel_studentInformation.add(label_studentInformation_total);

		textField_scoreOfSubject3 = new JTextField();
		textField_scoreOfSubject3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_scoreOfSubject3.setColumns(10);
		textField_scoreOfSubject3.setBounds(550, 120, 200, 30);
		panel_studentInformation.add(textField_scoreOfSubject3);

		label_total = new JLabel("0.0");
		label_total.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_total.setBounds(550, 165, 200, 30);
		panel_studentInformation.add(label_total);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 263, 806, 2);
		panel_studentInformation.add(separator);

		JPanel panel_button = new JPanel();
		panel_button.setPreferredSize(new Dimension(20, 50));
		contentPane.add(panel_button, BorderLayout.SOUTH);
		panel_button.setLayout(new GridLayout(1, 4, 25, 0));

		JButton button_Insert = new JButton("Insert");
		button_Insert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_Insert.addActionListener(action);
		panel_button.add(button_Insert);

		JButton button_detele = new JButton("Delete");
		button_detele.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_detele.addActionListener(action);
		panel_button.add(button_detele);

		button_edit = new JButton("Edit");
		button_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_edit.addActionListener(action);
		panel_button.add(button_edit);

		JButton button_clear = new JButton("Clear");
		button_clear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_clear.addActionListener(action);
		panel_button.add(button_clear);

		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public ManagerListModel getManagerListModel() {
		return managerListModel;
	}

	public JTextField getTextField_studentCodeFilter() {
		return textField_studentCodeFilter;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTextField_studentInformation_code() {
		return textField_studentInformation_code;
	}

	public JTextField getTextField_studentInformation_name() {
		return textField_studentInformation_name;
	}

	public JTextField getTextField_studentInformation_birthDay() {
		return textField_studentInformation_birthDay;
	}

	public JTextField getTextField_scoreOfSubject1() {
		return textField_scoreOfSubject1;
	}

	public JTextField getTextField_scoreOfSubject2() {
		return textField_scoreOfSubject2;
	}

	public JTextField getTextField_scoreOfSubject3() {
		return textField_scoreOfSubject3;
	}

	public JComboBox<String> getComboBox_studentInformation_birthPlace() {
		return comboBox_studentInformation_birthPlace;
	}

	public ButtonGroup getBg_sex() {
		return bg_sex;
	}

	public JLabel getLabel_total() {
		return label_total;
	}

	public JButton getButton_edit() {
		return button_edit;
	}

	public Student getSelectedStudent() {
		return managerListModel.getStudentList().get(table.getSelectedRow());
	}

	public Student getStudentFromForm() {
		Student student;
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date birthDay = df.parse(textField_studentInformation_birthDay.getText());
			student = new Student(textField_studentInformation_code.getText(),
					textField_studentInformation_name.getText(),
					new Province(comboBox_studentInformation_birthPlace.getSelectedIndex()), birthDay,
					bg_sex.getSelection().getActionCommand().equals("Male"),
					Float.valueOf(textField_scoreOfSubject1.getText()),
					Float.valueOf(textField_scoreOfSubject2.getText()),
					Float.valueOf(textField_scoreOfSubject3.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Information is not valid");
			// e.printStackTrace();
			return null;
		}
		return student;
	}

	public void clearForm() {
		textField_studentInformation_code.setText("");
		textField_studentInformation_name.setText("");
		comboBox_studentInformation_birthPlace.setSelectedIndex(-1);
		textField_studentInformation_birthDay.setText("");
		bg_sex.clearSelection();
		textField_scoreOfSubject1.setText("");
		textField_scoreOfSubject2.setText("");
		textField_scoreOfSubject3.setText("");
		label_total.setText("0.0");
		JOptionPane.showMessageDialog(this, "Form has been cleared");
	}

	@SuppressWarnings("deprecation")
	public void insertStudent() {
		if (managerListModel.isDuplicate(textField_studentInformation_code.getText())) {
			JOptionPane.showMessageDialog(this, "Student code is duplicate");
		} else {
			Student student = getStudentFromForm();
			if (student != null) {
				managerListModel.insert(student);
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.addRow(new Object[] { student.getCode(), student.getName(), student.getBirthPlace(),
						student.getBirthDay().getDate() + "/" + (student.getBirthDay().getMonth() + 1) + "/"
								+ (student.getBirthDay().getYear() + 1900),
						(student.isSex_isMale()) ? "Male" : "Female", student.getScore_1(), student.getScore_2(),
						student.getScore_3() });
				label_total.setText((student.getScore_1() + student.getScore_2() + student.getScore_3()) + "");
				JOptionPane.showMessageDialog(this, "Insert student successfully");
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void loadStudentToFormToEdit() {
		try {
			Student student = getSelectedStudent();
			textField_studentInformation_code.setText(student.getCode());
			textField_studentInformation_name.setText(student.getName());
			comboBox_studentInformation_birthPlace
					.setSelectedIndex(managerListModel.getProvinceList().getIndexOf(student.getBirthPlace()) + 1);
			textField_studentInformation_birthDay.setText(student.getBirthDay().getDate() + "/"
					+ (student.getBirthDay().getMonth() + 1) + "/" + (student.getBirthDay().getYear() + 1900));
			if (student.isSex_isMale())
				radioButton_studentInformation_sex_male.setSelected(true);
			else
				radioButton_studentInformation_sex_female.setSelected(true);
			textField_scoreOfSubject1.setText(student.getScore_1() + "");
			textField_scoreOfSubject2.setText(student.getScore_2() + "");
			textField_scoreOfSubject3.setText(student.getScore_3() + "");
			label_total.setText((student.getScore_1() + student.getScore_2() + student.getScore_3()) + "");

			button_edit.setText("Done");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Let choose a student");
			// e1.printStackTrace();
		}
	}

	public void completedEditing() {
		editStudent(getStudentFromForm());
		clearForm();
		button_edit.setText("Edit");
		JOptionPane.showMessageDialog(this, "Edit student successfully");
	}

	@SuppressWarnings("deprecation")
	public void editStudent(Student student) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		managerListModel.getStudentList().get(table.getSelectedRow()).edit(student);
		int i = 0;
		dtm.setValueAt(student.getCode(), table.getSelectedRow(), i++);
		dtm.setValueAt(student.getName(), table.getSelectedRow(), i++);
		dtm.setValueAt(student.getBirthPlace(), table.getSelectedRow(), i++);
		dtm.setValueAt(student.getBirthDay().getDate() + "/" + (student.getBirthDay().getMonth() + 1) + "/"
				+ (student.getBirthDay().getYear() + 1900), table.getSelectedRow(), i++);
		dtm.setValueAt((student.isSex_isMale()) ? "Male" : "Female", table.getSelectedRow(), i++);
		dtm.setValueAt(student.getScore_1(), table.getSelectedRow(), i++);
		dtm.setValueAt(student.getScore_2(), table.getSelectedRow(), i++);
		dtm.setValueAt(student.getScore_3(), table.getSelectedRow(), i++);
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
			dtm.addRow(new Object[] { student.getCode(), student.getName(), student.getBirthPlace(),
					student.getBirthDay().getDate() + "/" + (student.getBirthDay().getMonth() + 1) + "/"
							+ (student.getBirthDay().getYear() + 1900),
					(student.isSex_isMale()) ? "Male" : "Female", student.getScore_1(), student.getScore_2(),
					student.getScore_3() });
		}
	}

	public void filter() {
		ArrayList<Student> filteredList = new ArrayList<Student>();
		if (comboBox_filter_birthPlace.getSelectedIndex() != -1 && textField_studentCodeFilter.getText().isEmpty()) {
			for (Student student : managerListModel.getStudentList()) {
				if (student.getBirthPlace().getName().equals(comboBox_filter_birthPlace.getSelectedItem().toString()))
					filteredList.add(student);
			}
			setTable(filteredList);
		} else if (comboBox_filter_birthPlace.getSelectedIndex() == -1
				&& !(textField_studentCodeFilter.getText().isEmpty())) {
			for (Student student : managerListModel.getStudentList()) {
				if (student.getCode().equals(textField_studentCodeFilter.getText()))
					filteredList.add(student);
			}
			setTable(filteredList);
		} else if (comboBox_filter_birthPlace.getSelectedIndex() != -1
				&& !(textField_studentCodeFilter.getText().isEmpty())) {
			for (Student student : managerListModel.getStudentList()) {
				if (student.getBirthPlace().getName().equals(comboBox_filter_birthPlace.getSelectedItem().toString())
						&& student.getCode().equals(textField_studentCodeFilter.getText()))
					filteredList.add(student);
			}
			setTable(filteredList);
		} else {
			JOptionPane.showMessageDialog(this, "Let choose a province or enter the student code");
		}
	}

	public void cancelFilter() {
		setTable(managerListModel.getStudentList());
		comboBox_filter_birthPlace.setSelectedIndex(-1);
		textField_studentCodeFilter.setText("");
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

}
