package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import view.ManagerListView;

public class ManagerListController implements ActionListener {
	private ManagerListView managerListView;

	public ManagerListController(ManagerListView managerListView) {
		this.managerListView = managerListView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (managerListView.getButton_edit().getText().equals("Done") && cmd.equals("Done") == false) {
			managerListView.getButton_edit().setText("Edit");
		}
		if (cmd.equals("Exit")) {
			if (JOptionPane.showConfirmDialog(managerListView, "Do you want exit the program") == JOptionPane.OK_OPTION)
				System.exit(0);
		} else if (cmd.equals("Clear")) {
			managerListView.clearForm();
		} else if (cmd.equals("Insert")) {
			managerListView.insertStudent();
		} else if (cmd.equals("Edit") || cmd.equals("Done")) {
			if (cmd.equals("Edit")) {
				managerListView.loadStudentToFormToEdit();
			}
			if (cmd.equals("Done")) {
				managerListView.completedEditing();
			}
		} else if (cmd.equals("Delete")) {
			managerListView.removeStudent();

		} else if (cmd.equals("Search")) {
			managerListView.filter();
		} else if (cmd.equals("Cancel Search")) {
			managerListView.cancelFilter();
		} else if (cmd.equals("Save")) {
			managerListView.saveStudentListToFile();
		} else if (cmd.equals("Open")) {
			managerListView.loadStudentListFromFile();
		} else if (cmd.equals("About Me")){
			managerListView.showMyInformation();
		}

	}
}
