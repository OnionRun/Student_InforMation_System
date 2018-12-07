package com.zj.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.zj.dao.AdminDao;
import com.zj.dao.StudentDao;
import com.zj.dao.TeacherDao;
import com.zj.model.Admin;
import com.zj.model.Student;
import com.zj.model.Teacher;
import com.zj.model.UserType;
import com.zj.util.StringUti;

public class LoginFrm extends JFrame
{

	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField userpasswdText;
	private JComboBox userType;

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
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm()
	{
		setTitle("登陆界面");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JLabel label = new JLabel("学生信息管理系统");
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/学生 (1).png")));
		label.setFont(new Font("微软雅黑", Font.BOLD, 16));

		JLabel userName = new JLabel("用户名：");
		userName.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/学生管理,头像,人 (1).png")));
		userName.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel userPasswd = new JLabel("密  码：");
		userPasswd.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/passwd.png")));
		userPasswd.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		usernameText = new JTextField();
		usernameText.setColumns(10);

		userpasswdText = new JPasswordField();
		userpasswdText.setColumns(10);

		JButton btnLogin = new JButton("登录");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				loginAct(ae);
			}
		});
		btnLogin.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/login.png")));

		JButton btnReset = new JButton("重置");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				resetValue(ae);
			}
		});
		btnReset.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/reset.png")));

		JLabel label_1 = new JLabel("身  份：");
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/type.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		userType = new JComboBox();
		userType.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		userType.setModel(
				new DefaultComboBoxModel(new UserType[] { UserType.ADMIN, UserType.TEACHER, UserType.STUDENT }));

		JLabel label_2 = new JLabel("16电信2班");

		JLabel label_3 = new JLabel("庄捷");

		JLabel label_4 = new JLabel("201621191030");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(
								80)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnLogin)
										.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
										.addComponent(btnReset))
								.addGroup(gl_contentPane
										.createSequentialGroup().addComponent(label_2)
										.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
										.addComponent(label_3).addGap(37).addComponent(label_4))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(userPasswd)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(userpasswdText))
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(userName)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(usernameText,
														GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(label_1)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(userType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGap(98))
						.addGroup(Alignment.LEADING,
								gl_contentPane
										.createSequentialGroup().addGap(107).addComponent(label,
												GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(110, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(userName).addComponent(
						usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(userPasswd).addComponent(userpasswdText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(
						userType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnReset)
						.addComponent(btnLogin))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
						.addComponent(label_4).addComponent(label_3))
				.addGap(8)));
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		String userName = usernameText.getText().toString();
		char[] thestr = userpasswdText.getPassword();
		String userPasswd = new String(thestr).trim();
		UserType selectedItem = (UserType) userType.getSelectedItem();

		if (StringUti.isEmpty(userName))
		{
			JOptionPane.showMessageDialog(this, "用户名不能为空!");
			return;
		}

		if (StringUti.isEmpty(userPasswd))
		{
			JOptionPane.showMessageDialog(this, "密码不能为空!");
			return;
		}
		Admin admin = null;
		if ("系统管理员".equals(selectedItem.getName()))
		{
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(userPasswd);
			admin = adminDao.login(adminTmp);
			adminDao.closeDao();
			if (admin == null)
			{
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【" + selectedItem.getName() + "】：" + admin.getName() + "登录系统");
			this.dispose();
			new MainFrm(selectedItem, admin).setVisible(true);
		} else if ("教师".equals(selectedItem.getName()))
		{
			// 教师登录
			Teacher teacher = null;
			TeacherDao teacherDao = new TeacherDao();
			Teacher teacherTmp = new Teacher();
			teacherTmp.setName(userName);
			teacherTmp.setPassword(userPasswd);
			teacher = teacherDao.login(teacherTmp);
			teacherDao.closeDao();
			if (teacher == null)
			{
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【" + selectedItem.getName() + "】：" + teacher.getName() + "登录系统");
			this.dispose();
			new MainFrm(selectedItem, teacher).setVisible(true);

		} else
		{
			// 学生登录
			Student student = null;
			StudentDao studentDao = new StudentDao();
			Student studentTmp = new Student();
			studentTmp.setName(userName);
			studentTmp.setPassword(userPasswd);
			student = studentDao.login(studentTmp);
			studentDao.closeDao();
			if (student == null)
			{
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【" + selectedItem.getName() + "】：" + student.getName() + "登陆系统");
			this.dispose();
			new MainFrm(selectedItem, student).setVisible(true);
		}
	}

	protected void resetValue(ActionEvent ae)
	{
		usernameText.setText("");
		userpasswdText.setText("");
		userType.setSelectedIndex(0);

	}
}
