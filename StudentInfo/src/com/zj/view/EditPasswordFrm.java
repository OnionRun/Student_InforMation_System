package com.zj.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.zj.dao.AdminDao;
import com.zj.dao.StudentDao;
import com.zj.dao.TeacherDao;
import com.zj.model.Admin;
import com.zj.model.Student;
import com.zj.model.Teacher;
import com.zj.util.StringUti;

public class EditPasswordFrm extends JInternalFrame
{

	private JPanel contentPane;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;
	private JLabel currentUserLabel;

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
//					EditPasswordFrm frame = new EditPasswordFrm();
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
	public EditPasswordFrm()
	{

		setTitle(MainFrm.userType.getName() + "修改密码");
		setBounds(100, 100, 310, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);

		JLabel label = new JLabel("原始密码：");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/密码.png")));

		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setColumns(10);

		JLabel label_1 = new JLabel("新密码：");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/passwd.png")));

		newPasswordTextField = new JTextField();
		newPasswordTextField.setColumns(10);

		JLabel label_2 = new JLabel("确认密码：");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/确认-充值成功.png")));

		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);

		JButton submitButton = new JButton("确定");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				submitEdit(ae);
			}
		});
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/确认.png")));

		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				resetValue(ae);
			}
		});
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		resetButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/reset.png")));

		JLabel label_3 = new JLabel("当前用户：");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_3.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/学生管理,头像,人 (1).png")));

		currentUserLabel = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(36)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(submitButton).addGap(43)
								.addComponent(resetButton))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(label_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(confirmPasswordTextField, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(label_1)
										.addComponent(label).addComponent(label_3))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(newPasswordTextField, GroupLayout.DEFAULT_SIZE, 109,
														Short.MAX_VALUE)
												.addComponent(oldPasswordTextField, GroupLayout.DEFAULT_SIZE, 109,
														Short.MAX_VALUE))
										.addComponent(currentUserLabel))))
				.addGap(44)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(30, Short.MAX_VALUE)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(label_3).addComponent(currentUserLabel))
				.addGap(17)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(oldPasswordTextField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(
						newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_2).addComponent(
						confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(resetButton)
						.addComponent(submitButton))
				.addGap(20)));
		contentPane.setLayout(gl_contentPane);
		if ("系统管理员".equals(MainFrm.userType.getName()))
		{
			Admin admin = (Admin) MainFrm.userObject;
			currentUserLabel.setText("【系统管理员】" + admin.getName());
		} else if ("学生".equals(MainFrm.userType.getName()))
		{
			Student student = (Student) MainFrm.userObject;
			currentUserLabel.setText("【学生】" + student.getName());
		} else
		{
			Teacher teacher = (Teacher) MainFrm.userObject;
			currentUserLabel.setText("【教师】" + teacher.getName());
		}

	}

	protected void submitEdit(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String confirmPassword = confirmPasswordTextField.getText().toString();

		if (StringUti.isEmpty(oldPassword))
		{
			JOptionPane.showMessageDialog(this, "请输入原始密码！");
			return;
		}
		if (StringUti.isEmpty(newPassword))
		{
			JOptionPane.showMessageDialog(this, "请输入新的密码！");
			return;
		}
		if (StringUti.isEmpty(confirmPassword))
		{
			JOptionPane.showMessageDialog(this, "请确认新密码！");
			return;
		}

		if (!newPassword.equals(confirmPassword))
		{
			JOptionPane.showMessageDialog(this, "两次输入的密码不一致！");
			return;
		}

		if ("系统管理员".equals(MainFrm.userType.getName()))
		{
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin) MainFrm.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setPassword(oldPassword);
			adminTmp.setId(admin.getId());

			String retString;
			retString = adminDao.editPassword(adminTmp, newPassword);
			JOptionPane.showMessageDialog(this, retString);
			// JOptionPane.
			if ("修改成功！".equals(retString))
			{
				resetValue(ae);
			}
			adminDao.closeDao();
			return;
		}

		if ("学生".equals(MainFrm.userType.getName()))
		{
			StudentDao studentDao = new StudentDao();
			Student studentTmp = new Student();
			Student student = (Student) MainFrm.userObject;
			studentTmp.setName(student.getName());
			studentTmp.setPassword(oldPassword);
			studentTmp.setId(student.getId());

			String retString;
			retString = studentDao.editPassword(studentTmp, newPassword);
			JOptionPane.showMessageDialog(this, retString);

			if ("修改成功！".equals(retString))
			{
				resetValue(ae);
			}
			studentDao.closeDao();
			return;
		}

		if ("教师".equals(MainFrm.userType.getName()))
		{
			TeacherDao teacherDao = new TeacherDao();
			Teacher teacherTmp = new Teacher();
			Teacher teacher = (Teacher) MainFrm.userObject;
			teacherTmp.setName(teacher.getName());
			teacherTmp.setPassword(teacher.getPassword());
			teacherTmp.setId(teacher.getId());

			String retString;
			retString = teacherDao.editPassword(teacher, newPassword);
			JOptionPane.showMessageDialog(this, retString);
			if ("修改成功！".equals(retString))
			{
				resetValue(ae);
			}
			teacherDao.closeDao();
			return;
		}
	}

	protected void resetValue(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
