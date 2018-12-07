package com.zj.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.zj.dao.TeacherDao;
import com.zj.model.Teacher;
import com.zj.util.StringUti;

public class TeacherAddFrm extends JInternalFrame
{
	private JTextField teacherNameTextField;
	private JTextField teacherAgeTextField;
	private JTextField teacherProfessionTextField;
	private JTextField teacherPasswordTextField;
	private JComboBox teacherSexComboBox;

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
					TeacherAddFrm frame = new TeacherAddFrm();
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
	public TeacherAddFrm()
	{
		setClosable(true);
		setIconifiable(true);

		setTitle("添加教师");
		setBounds(100, 100, 315, 286);

		JLabel lblNewLabel = new JLabel("教师姓名：");
		lblNewLabel.setIcon(new ImageIcon(TeacherAddFrm.class.getResource("/images/teacher (1).png")));

		JLabel lblNewLabel_1 = new JLabel("教师职称：");
		lblNewLabel_1.setIcon(new ImageIcon(TeacherAddFrm.class.getResource("/images/职称.png")));
		lblNewLabel_1.setToolTipText("");

		JLabel lblNewLabel_2 = new JLabel("教师年龄：");
		lblNewLabel_2.setIcon(new ImageIcon(TeacherAddFrm.class.getResource("/images/age.png")));

		JLabel lblNewLabel_3 = new JLabel("密         码：");
		lblNewLabel_3.setIcon(new ImageIcon(TeacherAddFrm.class.getResource("/images/passwd.png")));

		JLabel lblNewLabel_4 = new JLabel("性         别：");
		lblNewLabel_4.setIcon(new ImageIcon(TeacherAddFrm.class.getResource("/images/体检性别分析.png")));

		teacherNameTextField = new JTextField();
		teacherNameTextField.setColumns(12);

		teacherAgeTextField = new JTextField();
		teacherAgeTextField.setColumns(12);

		teacherProfessionTextField = new JTextField();
		teacherProfessionTextField.setColumns(12);

		teacherPasswordTextField = new JTextField();
		teacherPasswordTextField.setColumns(12);

		JButton submitButton = new JButton("确定");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				teacherAddAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(TeacherAddFrm.class.getResource("/images/确认.png")));

		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				resetValues(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(TeacherAddFrm.class.getResource("/images/reset.png")));

		teacherSexComboBox = new JComboBox();
		teacherSexComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "男", "女" }));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addGap(44).addComponent(submitButton)
										.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_2).addComponent(lblNewLabel_1)
												.addComponent(lblNewLabel_3).addComponent(lblNewLabel_4)
												.addComponent(lblNewLabel))
										.addGap(18)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(teacherSexComboBox, 0, 84, Short.MAX_VALUE)
										.addComponent(teacherAgeTextField, 84, 84, 84)
										.addComponent(teacherProfessionTextField, 84, 84, 84)
										.addComponent(teacherPasswordTextField, 84, 84, 84)
										.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, 84,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(resetButton))
						.addGap(76)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(teacherSexComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(teacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(teacherProfessionTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(teacherPasswordTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
						.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(resetButton).addComponent(submitButton))
						.addContainerGap(16, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	protected void teacherAddAct(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		String teacherName = teacherNameTextField.getText().toString();
		String teacherPassword = teacherPasswordTextField.getText().toString();
		String teacherSex = teacherSexComboBox.getSelectedItem().toString();
		String teacherProfession = teacherProfessionTextField.getText().toString();
		int teacherAge = 0;
		teacherAge = Integer.parseInt(teacherAgeTextField.getText().toString());
		if (StringUti.isEmpty(teacherName))
		{
			JOptionPane.showMessageDialog(this, "请输入教师姓名！");
			return;
		}
		if (StringUti.isEmpty(teacherProfession))
		{
			JOptionPane.showMessageDialog(this, "请输入教师职称！");
			return;
		}
		if (StringUti.isEmpty(teacherPassword))
		{
			JOptionPane.showMessageDialog(this, "请输入密码！");
			return;
		}
		if (teacherAge == 0 || teacherAge < 0)
		{
			JOptionPane.showMessageDialog(this, "教师年龄必须大于0！");
			return;
		}

		Teacher teacher = new Teacher();
		teacher.setName(teacherName);
		teacher.setSex(teacherSex);
		teacher.setTitle(teacherProfession);
		teacher.setAge(teacherAge);
		teacher.setPassword(teacherPassword);
		TeacherDao teacherDao = new TeacherDao();
		if (teacherDao.addTeacher(teacher))
		{
			JOptionPane.showMessageDialog(this, "添加教师成功！");

		} else
		{
			JOptionPane.showMessageDialog(this, "添加教师失败！");
		}
		teacherDao.closeDao();
		resetValues(ae);
	}

	protected void resetValues(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		teacherAgeTextField.setText("");
		teacherNameTextField.setText("");
		teacherPasswordTextField.setText("");
		teacherProfessionTextField.setText("");
		teacherSexComboBox.setSelectedIndex(0);
	}
}
