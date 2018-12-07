package com.zj.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.zj.dao.ClassDao;
import com.zj.dao.StudentDao;
import com.zj.model.Student;
import com.zj.model.StudentClass;
import com.zj.util.StringUti;

public class StudentAddFrm extends JInternalFrame
{
	private JTextField studentNameTextField;
	private JComboBox studentSexConboBox;
	private JComboBox studentClassComboBox;
	private JTextField emailTextField;
	private JTextField phoneTextField;
	private JTextField studentNumberTextField;
	private JTextField addressTextField;
	private JTextField birthdayTextField;
	private JTextField idCardTextField;
	private JPasswordField studentPasswordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					StudentAddFrm frame = new StudentAddFrm();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentAddFrm()
	{
		setClosable(true);
		setIconifiable(true);
		setTitle("添加学生");
		setBounds(100, 100, 516, 337);

		JLabel label = new JLabel("学生姓名：");
		label.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/姓名.png")));

		JLabel label_1 = new JLabel("学生性别：");
		label_1.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/体检性别分析.png")));

		JLabel label_2 = new JLabel("所属班级：");
		label_2.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/班级管理.png")));

		JLabel label_3 = new JLabel("电子邮箱：");
		label_3.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/邮箱.png")));

		JLabel label_4 = new JLabel("电话号码：");
		label_4.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/number.png")));

		JLabel label_5 = new JLabel("常住地址：");
		label_5.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/地址.png")));

		JLabel label_6 = new JLabel("出生日期：");
		label_6.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/日期.png")));

		JLabel lblNewLabel = new JLabel("身份证号：");
		lblNewLabel.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/ID，姓名，证件.png")));

		JLabel label_7 = new JLabel("学    号：");
		label_7.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/学习.png")));

		studentNameTextField = new JTextField();
		studentNameTextField.setToolTipText("必填");
		studentNameTextField.setColumns(10);

		studentSexConboBox = new JComboBox();
		studentSexConboBox.setToolTipText("必选");
		studentSexConboBox.setModel(new DefaultComboBoxModel(new String[] { "", "男", "女" }));

		studentClassComboBox = new JComboBox();

		studentClassComboBox.setToolTipText("必选");

		emailTextField = new JTextField();
		emailTextField.setColumns(10);

		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);

		studentNumberTextField = new JTextField();
		studentNumberTextField.setToolTipText("必填");
		studentNumberTextField.setColumns(10);

		addressTextField = new JTextField();
		addressTextField.setColumns(10);

		birthdayTextField = new JTextField();
		birthdayTextField.setColumns(10);

		idCardTextField = new JTextField();
		idCardTextField.setColumns(10);

		JButton submitButton = new JButton("确认");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				studentAddAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/确认.png")));

		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				resetValues(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/reset.png")));

		JLabel label_8 = new JLabel("登陆密码：");
		label_8.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/passwd.png")));

		studentPasswordTextField = new JPasswordField();
		studentPasswordTextField.setToolTipText("必填");
		studentPasswordTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addGap(40)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(label_4)
										.addComponent(label_3).addComponent(label_2).addComponent(label_1))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(studentSexConboBox, 0, 109, Short.MAX_VALUE)
										.addComponent(studentClassComboBox, 0, 109, Short.MAX_VALUE)
										.addComponent(phoneTextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
										.addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(40).addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(studentNameTextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(submitButton)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(29)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel)
										.addComponent(label_8)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(label_5).addComponent(label_6))))
						.addGroup(groupLayout.createSequentialGroup().addGap(30)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(resetButton)
										.addComponent(label_7))))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(studentPasswordTextField).addComponent(idCardTextField)
						.addComponent(birthdayTextField).addComponent(addressTextField)
						.addComponent(studentNumberTextField, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
				.addContainerGap(40, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(24)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(studentNumberTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
								studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
						.addComponent(studentSexConboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5).addComponent(addressTextField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
						.addComponent(studentClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6).addComponent(birthdayTextField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3).addComponent(lblNewLabel).addComponent(idCardTextField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(label_4)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(phoneTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8).addComponent(studentPasswordTextField,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(53).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(resetButton)
						.addComponent(submitButton))
				.addGap(39)));
		getContentPane().setLayout(groupLayout);
		setStudentClassInfo();
	}

	protected void studentAddAct(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		String studentName = studentNameTextField.getText().toString();
		char[] thestr = studentPasswordTextField.getPassword();
		String studentPassword = new String(thestr).trim();
		if (StringUti.isEmpty(studentName))
		{
			JOptionPane.showMessageDialog(this, "请输入学生姓名！");
			return;
		}
		if (StringUti.isEmpty(studentPassword))
		{
			JOptionPane.showMessageDialog(this, "请输入密码！");
			return;
		}
		StudentClass sClass = (StudentClass) studentClassComboBox.getSelectedItem();
		String sex = studentSexConboBox.getSelectedItem().toString();
		String birthday = birthdayTextField.getText().toString();
		String email = emailTextField.getText();
		String address = addressTextField.getText();
		String idCard = idCardTextField.getText();
		String stunumber = studentNumberTextField.getText();
		String phone = phoneTextField.getText();
		Student student = new Student();
		student.setName(studentName);
		student.setPassword(studentPassword);
		student.setSex(sex);
		student.setClassId(sClass.getId());
		student.setBirthday(birthday);
		student.setAddress(address);
		student.setEmail(email);
		student.setIdcard(idCard);
		student.setStuNumber(stunumber);
		student.setPhoneNumber(phone);
		StudentDao studentDao = new StudentDao();
		if (studentDao.addStudent(student))
		{
			JOptionPane.showMessageDialog(this, "添加成功！");
			resetValues(ae);

		} else
		{
			JOptionPane.showMessageDialog(this, "添加失败！");
		}

	}

	protected void setStudentClassInfo()
	{
		// TODO Auto-generated method stub
		ClassDao classDao = new ClassDao();
		List<StudentClass> classList = classDao.getClassList(new StudentClass());
		for (StudentClass sc : classList)
		{
			studentClassComboBox.addItem(sc);
		}
		classDao.closeDao();
	}

	protected void resetValues(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		studentClassComboBox.setSelectedIndex(0);
		studentNameTextField.setText("");
		studentNumberTextField.setText("");
		studentPasswordTextField.setText("");
		studentSexConboBox.setSelectedIndex(0);
		emailTextField.setText("");
		idCardTextField.setText("");
		addressTextField.setText("");
		birthdayTextField.setText("");
		phoneTextField.setText("");
	}
}
