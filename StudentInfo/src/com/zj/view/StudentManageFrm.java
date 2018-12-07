package com.zj.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.zj.dao.ClassDao;
import com.zj.dao.StudentDao;
import com.zj.model.Student;
import com.zj.model.StudentClass;
import com.zj.util.StringUti;

public class StudentManageFrm extends JInternalFrame
{
	private JTextField searchStudentNameTextField;
	private JTable studentListTable;
	private List<StudentClass> studentClassList;
	private JComboBox studentClassEditComboBox;
	private JTextField studentEmailTextField;
	private JTextField studentNameEditTextField;
	private JTextField studentPhoneNumberTextField;
	private JTextField studentAddressTextField;
	private JTextField studentBirthdayTextField;
	private JTextField studentIdTextField;
	private JTextField studentNumberTextField;
	private JComboBox studentSexComboBox;
	private JComboBox selectClassComboBox;
	private JScrollPane scrollPane;
	private JTextField studentPasswordEditTextField;
	private JButton deleteButton;
	private JButton submitButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args)
//	{
//		EventQueue.invokeLater(new Runnable() {
//			public void run()
//			{
//				try
//				{
//					StudentManageFrm frame = new StudentManageFrm();
//					frame.setVisible(true);
//				} catch (Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public StudentManageFrm()
	{
		setTitle("管理学生信息");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(50, 50, 780, 475);

		JLabel label = new JLabel("学生姓名：");
		label.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/学生管理,头像,人 (1).png")));

		searchStudentNameTextField = new JTextField();
		searchStudentNameTextField.setColumns(10);

		JButton searchButton = new JButton("查询");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				searchStudent(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/查找 表单 列表.png")));

		scrollPane = new JScrollPane();

		submitButton = new JButton("确定修改");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				submitEditAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/确认.png")));

		deleteButton = new JButton("删除信息");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				deleteStudent(ae);
			}
		});
		deleteButton.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/reset.png")));

		JLabel label_1 = new JLabel("所属班级：");
		label_1.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/班级信息.png")));

		selectClassComboBox = new JComboBox();

		JLabel label_2 = new JLabel("学生姓名：");

		JLabel label_3 = new JLabel("所属班级：");

		studentSexComboBox = new JComboBox();
		studentSexComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "男", "女" }));

		JLabel label_4 = new JLabel("性    别：");

		studentClassEditComboBox = new JComboBox();

		JLabel label_5 = new JLabel("邮    箱：");

		studentEmailTextField = new JTextField();
		studentEmailTextField.setColumns(10);

		studentNameEditTextField = new JTextField();
		studentNameEditTextField.setColumns(10);

		JLabel label_6 = new JLabel("电话号码：");

		JLabel label_7 = new JLabel("地    址：");

		studentPhoneNumberTextField = new JTextField();
		studentPhoneNumberTextField.setColumns(10);

		studentAddressTextField = new JTextField();
		studentAddressTextField.setColumns(10);

		JLabel label_8 = new JLabel("出生日期：");

		JLabel label_9 = new JLabel("身份证号：");

		JLabel label_10 = new JLabel("学    号：");

		studentBirthdayTextField = new JTextField();
		studentBirthdayTextField.setColumns(10);

		studentIdTextField = new JTextField();
		studentIdTextField.setColumns(10);

		studentNumberTextField = new JTextField();
		studentNumberTextField.setColumns(10);

		JLabel label_11 = new JLabel("密    码：");

		studentPasswordEditTextField = new JTextField();
		studentPasswordEditTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(68).addComponent(label)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(37).addComponent(label_1).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(selectClassComboBox, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addGap(40).addComponent(searchButton).addContainerGap(192, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(label_2, Alignment.LEADING))
										.addComponent(label_4))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(studentSexComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(studentClassEditComboBox, 0, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(studentNameEditTextField, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(label_6).addComponent(label_7))
										.addComponent(label_5))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(studentAddressTextField).addComponent(studentPhoneNumberTextField)
										.addComponent(studentEmailTextField))
								.addGap(24)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label_9)
										.addComponent(label_10).addComponent(label_8))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(studentNumberTextField).addComponent(studentIdTextField)
										.addComponent(studentBirthdayTextField))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(label_11)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(studentPasswordEditTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(deleteButton, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(submitButton))))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)).addGap(4)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(42)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
										.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1)
										.addComponent(selectClassComboBox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(searchButton))
								.addGap(18)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addGap(15)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 16,
														GroupLayout.PREFERRED_SIZE)
												.addGap(23).addComponent(
														label_3, GroupLayout.PREFERRED_SIZE, 16,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGap(78).addGroup(groupLayout
												.createParallelGroup(Alignment.BASELINE)
												.addComponent(studentAddressTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_7).addComponent(label_10)))
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(studentEmailTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_5).addComponent(label_8)
												.addComponent(
														studentBirthdayTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGap(39).addGroup(groupLayout
												.createParallelGroup(Alignment.BASELINE)
												.addComponent(studentPhoneNumberTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_6).addComponent(label_9)
												.addComponent(studentIdTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(
												groupLayout.createSequentialGroup().addGap(78).addComponent(
														studentNumberTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(studentNameEditTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup().addGap(18)
																.addComponent(studentClassEditComboBox,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(groupLayout.createSequentialGroup().addGap(57)
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.BASELINE)
																		.addComponent(studentSexComboBox,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(label_4)))))
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(label_11)
												.addComponent(studentPasswordEditTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGap(39)
												.addComponent(submitButton))
										.addGroup(groupLayout.createSequentialGroup().addGap(78)
												.addComponent(deleteButton)))
								.addContainerGap(29, Short.MAX_VALUE)));

		studentListTable = new JTable();
		studentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				selectTableRow(arg0);
			}
		});
		studentListTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5B66\u751F\u7F16\u53F7", "\u59D3\u540D", "\u73ED\u7EA7", "\u6027\u522B",
						"\u90AE\u7BB1", "\u7535\u8BDD\u53F7\u7801", "\u5730\u5740", "\u51FA\u751F\u65E5\u671F",
						"\u8EAB\u4EFD\u8BC1", "\u5B66\u53F7" }) {
			boolean[] columnEditables = new boolean[] { false, false, true, false, false, false, true, false, true,
					false };

			public boolean isCellEditable(int row, int column)
			{
				return columnEditables[column];
			}
		});
//		studentListTable.getColumnModel().getColumn(0).setPreferredWidth(40);
//		studentListTable.getColumnModel().getColumn(1).setPreferredWidth(30);
//		studentListTable.getColumnModel().getColumn(3).setPreferredWidth(50);
//		studentListTable.getColumnModel().getColumn(4).setPreferredWidth(30);
//		studentListTable.getColumnModel().getColumn(5).setPreferredWidth(65);
//		studentListTable.getColumnModel().getColumn(6).setPreferredWidth(65);
//		studentListTable.getColumnModel().getColumn(7).setPreferredWidth(60);
//		studentListTable.getColumnModel().getColumn(8).setPreferredWidth(70);
//		studentListTable.getColumnModel().getColumn(9).setPreferredWidth(70);
		scrollPane.setViewportView(studentListTable);
		getContentPane().setLayout(groupLayout);
		setStudentClassInfo();
		Student student = new Student();
		setTable(student);
		// setAuthority();
	}

	protected void selectTableRow(MouseEvent ae)
	{
		// TODO Auto-generated method stub
		DefaultTableModel defaultTableModel = (DefaultTableModel) studentListTable.getModel();
		studentNameEditTextField.setText(defaultTableModel.getValueAt(studentListTable.getSelectedRow(), 1).toString());
		String className = defaultTableModel.getValueAt(studentListTable.getSelectedRow(), 2).toString();
		for (int i = 0; i < studentClassEditComboBox.getItemCount(); i++)
		{
			StudentClass sClass = (StudentClass) studentClassEditComboBox.getItemAt(i);
			if (className.equals(sClass.getName()))
				studentClassEditComboBox.setSelectedIndex(i);
		}
		String sex = defaultTableModel.getValueAt(studentListTable.getSelectedRow(), 3).toString();
		studentSexComboBox.setSelectedIndex(getIndexBySex(sex));
		studentEmailTextField.setText(defaultTableModel.getValueAt(studentListTable.getSelectedRow(), 4).toString());
		studentPhoneNumberTextField
				.setText(defaultTableModel.getValueAt(studentListTable.getSelectedRow(), 5).toString());
		studentAddressTextField.setText(defaultTableModel.getValueAt(studentListTable.getSelectedRow(), 6).toString());
		studentBirthdayTextField.setText(defaultTableModel.getValueAt(studentListTable.getSelectedRow(), 7).toString());
		studentIdTextField.setText(defaultTableModel.getValueAt(studentListTable.getSelectedRow(), 8).toString());
		studentNumberTextField.setText(defaultTableModel.getValueAt(studentListTable.getSelectedRow(), 9).toString());
	}

	protected void searchStudent(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setName(searchStudentNameTextField.getText().toString());
		StudentClass sClass = (StudentClass) selectClassComboBox.getSelectedItem();
		student.setClassId(sClass.getId());
		setTable(student);
	}

	protected void submitEditAct(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		StudentDao studentDao = new StudentDao();
		int row = studentListTable.getSelectedRow();
		if (row == -1)
		{
			JOptionPane.showMessageDialog(this, "请选中要修改的信息！");
			return;
		}
		String studentName = studentNameEditTextField.getText().toString();
		String studentNumber = studentNumberTextField.getText().toLowerCase();
		if (StringUti.isEmpty(studentName))
		{
			JOptionPane.showMessageDialog(this, "请填写学生姓名！");
			return;
		}
		if (StringUti.isEmpty(studentNumber))
		{
			JOptionPane.showMessageDialog(this, "请填写学号！");
			return;
		}

		Student student = new Student();

		student.setName(studentName);
		student.setStuNumber(studentNumber);
		StudentClass sClass = (StudentClass) studentClassEditComboBox.getSelectedItem();
		student.setClassId(sClass.getId());
		student.setSex(getSexByIndex(studentSexComboBox.getSelectedIndex()));
		student.setAddress(studentAddressTextField.getText().toString());
		student.setBirthday(studentBirthdayTextField.getText().toString());
		student.setEmail(studentEmailTextField.getText().toString());
		student.setIdcard(studentIdTextField.getText().toString());
		student.setPhoneNumber(studentPhoneNumberTextField.getText().toString());
		student.setPassword(studentPasswordEditTextField.getText().toString());
		student.setStuNumber(studentNumberTextField.getText().toString());
		student.setId(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()));
		if (studentDao.update(student))
		{
			JOptionPane.showMessageDialog(this, "更新成功！");
			resetValues();
		} else
		{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		studentDao.closeDao();
		setTable(new Student());

	}

	protected void deleteStudent(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		int row = studentListTable.getSelectedRow();
		if (row == -1)
		{
			JOptionPane.showMessageDialog(this, "请选中要删除的信息！");
			return;
		}
		if (JOptionPane.showConfirmDialog(this, "确定要删除信息吗？") != JOptionPane.OK_OPTION)
			return;
		StudentDao studentDao = new StudentDao();
		if (studentDao.delete(Integer.parseInt(studentListTable.getValueAt(row, 0).toString())))
		{
			JOptionPane.showMessageDialog(this, "删除信息成功！");
		} else
		{
			JOptionPane.showMessageDialog(this, "删除信息失败！");
		}
		studentDao.closeDao();
		setTable(new Student());
	}

	public void setTable(Student student)
	{
		// if ("学生".equals(MainFrm.userType.getName()))
		// {
		// Student s = (Student) MainFrm.userObject;
		// student.setName(s.getName());
		// JOptionPane.showMessageDialog(this, "无权限！");
		// return;
		// }
		DefaultTableModel defaultTableModel = (DefaultTableModel) studentListTable.getModel();
		defaultTableModel.setRowCount(0);
		StudentDao studentDao = new StudentDao();
		List<Student> studentList = studentDao.getStudentList(student);
		for (Student s : studentList)
		{
			Vector vector = new Vector();
			vector.add(s.getId());
			vector.add(s.getName());
			vector.add(getClassNameById(s.getClassId()));
			// vector.add(s.getPassword());
			vector.add(s.getSex());
			vector.add(s.getEmail());
			vector.add(s.getPhoneNumber());
			vector.add(s.getAddress());
			vector.add(s.getBirthday());
			vector.add(s.getIdcard());
			vector.add(s.getStuNumber());
			defaultTableModel.addRow(vector);
		}
		studentDao.closeDao();
	}

	private String getClassNameById(int id)
	{
		// TODO Auto-generated method stub
		for (StudentClass sClass : studentClassList)
		{
			if (sClass.getId() == id)
				return sClass.getName();
		}
		return "";
	}

	public void resetValues()
	{
		studentAddressTextField.setText("");
		studentBirthdayTextField.setText("");
		studentEmailTextField.setText("");
		studentIdTextField.setText("");
		studentNumberTextField.setText("");
		studentPhoneNumberTextField.setText("");
		studentSexComboBox.setSelectedIndex(0);
		studentClassEditComboBox.setSelectedIndex(0);
		studentNameEditTextField.setText("");
		studentPasswordEditTextField.setText("");
	}

	public void setStudentClassInfo()
	{
		ClassDao classDao = new ClassDao();
		studentClassList = classDao.getClassList(new StudentClass());
		for (StudentClass sClass : studentClassList)
		{
			selectClassComboBox.addItem(sClass);
			studentClassEditComboBox.addItem(sClass);
		}
		classDao.closeDao();
	}

	private int getIndexBySex(String string)
	{
		if ("".equals(string))
		{
			return 0;
		} else if ("男".equals(string))
		{
			return 1;
		} else if ("女".equals(string))
		{
			return 2;
		}
		return 0;
	}

	private String getSexByIndex(int index)
	{
		if (index == 0)
		{
			return "";
		} else if (index == 1)
		{
			return "男";
		} else if (index == 2)
		{
			return "女";
		}
		return "";
	}

	private void setAuthority()
	{
		if ("学生".equals(MainFrm.userType.getName()))
		{
			submitButton.setEnabled(false);
			deleteButton.setEnabled(false);
			// searchTeacherNameTextField.setEditable(false);
		}
	}
}
