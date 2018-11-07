package assignment8;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicBorders.RolloverButtonBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentsApplication extends JFrame {

	private JTable studentsTable;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JComboBox<String> genderComboBox;
	private JButton addStudentBtn;
	private JButton removeStudentBtn;
	private static final String[] geneders = {"Male", "Famle"};
	
	private StudentsTableModel model;
	
	class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String id = idTextField.getText().trim();
			String name = nameTextField.getText().trim();
			
			
			if (id.isEmpty() || name.isEmpty()) {
				JOptionPane.showMessageDialog(null,  "ID or Name is Invalid!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (!id.matches("\\d+")) {
				JOptionPane.showMessageDialog(null,  "ID must be integer!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String s[] = name.split(" ");
			if (s.length != 2) {
				JOptionPane.showMessageDialog(null,  "Name must be only First & Last Name!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			int roll = Integer.parseInt(id);
			Student student = new Student(roll, s[0], s[1], genderComboBox.getSelectedIndex() == 1);
			model.addStudent(student);
			
			studentsTable.updateUI();
			idTextField.setText(roll+1+"");
		}
	}
	
	
	class RemoveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
	
			model.removeLastStudent();
			studentsTable.updateUI();
		}
	}
	
	
	private void addActions() {
		addStudentBtn.addActionListener(new AddListener());
		removeStudentBtn.addActionListener(new RemoveListener());
	}
	

	public StudentsApplication(Students students) {
		
		Font font = new Font("TimesRoman", Font.PLAIN, 20);
		
		JPanel inputPanel = new JPanel();
		
		JLabel idLabel = new JLabel("ID");
		idTextField = new JTextField(10);
		idTextField.setFont(font);
		idTextField.setText("102");
		JPanel idPanel = new JPanel();
		idPanel.add(idLabel);
		idPanel.add(idTextField);
		inputPanel.add(idPanel);
		
		
		JLabel nameLabel = new JLabel("Name");
		nameTextField = new JTextField(10);
		nameTextField.setFont(font);
		nameTextField.setText("Li Meng");
		JPanel namePanel = new JPanel();
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		
		inputPanel.add(namePanel);
		
		JLabel genderLabel = new JLabel("Gender");
		genderComboBox = new JComboBox<String>(geneders);
		genderComboBox.setSelectedItem(0);
		JPanel genderPanel = new JPanel();
		genderPanel.add(genderLabel);
		genderPanel.add(genderComboBox);
		inputPanel.add(genderPanel);
		
		inputPanel.add(genderLabel);
		inputPanel.add(genderComboBox);

		addStudentBtn = new JButton("Add Stduent");
		addStudentBtn.setPreferredSize(new Dimension(200, 30));
		
		removeStudentBtn  = new JButton("Remove Stduent");
		removeStudentBtn.setPreferredSize(new Dimension(200, 30));
		
		JPanel opPanel = new JPanel();
		opPanel.add(addStudentBtn);
		opPanel.add(removeStudentBtn);
		inputPanel.add(opPanel);
		
		model = new StudentsTableModel(students);
		studentsTable = new JTable(model);
		JScrollPane jsp = new JScrollPane(studentsTable);

		
		GridLayout gl = new GridLayout(2, 1);
		Container con = getContentPane();
		con.setLayout(gl);
		con.add(inputPanel);
		
		
		con.add(jsp);
		
		setSize(600, 500);
		setVisible(true);
		
		addActions();
	}
	
	
	
	

	public static void main(String[] args) {
		Students s = new Students();
		s.addStudent(new Student(100, "Divya", "Sharma", true));
		s.addStudent(new Student(101, "Mihir", "Salunke", false));
		new StudentsApplication(s);

	}

}

class Students {
	private ArrayList<Student> students = new ArrayList<Student>();

	public ArrayList<Student> getStudents() {
		return students;

	}
	
	public void removeLastStudent() {
		if (students.size() == 0)
			return;
		
		students.remove(students.size() - 1);
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public int getNumberOfStudents() {
		return getStudents().size();
	}

}

class Student {
	int roll;
	String first;
	String last;
	boolean gender = false;

	public Student(int roll, String first, String last, boolean gender) {
		this.roll = roll;
		this.first = first;
		this.last = last;
		this.gender = gender;
	}
}

class StudentsTableModel extends DefaultTableModel {

	private Students students;

	public StudentsTableModel(Students students) {
		if (students != null)
			this.students = students;
		else
			this.students = new Students();
	}
	
	public void addStudent(Student s) {
		this.students.addStudent(s);
	}
	
	public void removeLastStudent() {
		this.students.removeLastStudent();
	}

	@Override
	public int getRowCount() {
		if (students == null)
			return 0;
		
		return students.getNumberOfStudents();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "ROLL";
		}
		if (columnIndex == 1) {
			return "First";
		}
		if (columnIndex == 2)
			return "Last";
		if (columnIndex == 3)
			return "Gender";
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 3) {
			return Boolean.class;
		}
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Collection<Student> s = students.getStudents();
		int row = -1;
		for (Student student : s) {
			row++;
			if (row == rowIndex) {
				if (columnIndex == 0) {
					return student.roll + "";
				}
				if (columnIndex == 1) {
					return student.first;
				}
				if (columnIndex == 2) {
					return student.last;
				}
				if (columnIndex == 3) {
					return student.gender;
				}
			}
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
