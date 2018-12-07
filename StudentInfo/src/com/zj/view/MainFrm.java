package com.zj.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.zj.model.UserType;

public class MainFrm extends JFrame
{

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;
	private JMenuItem teacherAddMenuItem;
	private JMenuItem teacherManageMenuItem;
	private JMenuItem studentClassAddMenuItem;
	private JMenuItem studentClassManageMenuItem;
	private JMenuItem studentAddMenuItem;
	private JMenuItem studentManageMenuItem;
	private JMenu studentClassManageMenu;
	private JMenu studentManageMenu;
	private JMenu teacherManageMenu;

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
					MainFrm frame = new MainFrm(null, null);
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
	public MainFrm(UserType userType, Object userObject)
	{
		this.userType = userType;
		this.userObject = userObject;
		setTitle("学生信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 627);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("系统设置");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/设置.png")));
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("密码修改");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				editPssdword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/修改密码.png")));
		menu.add(menuItem);

		JMenuItem mntmNewMenuItem = new JMenuItem("退出系统");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				if (JOptionPane.showConfirmDialog(MainFrm.this, "确定退出？") == JOptionPane.OK_OPTION)
				{
					System.exit(0);
				}
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/退出.png")));
		menu.add(mntmNewMenuItem);

		teacherManageMenu = new JMenu("教师管理");
		teacherManageMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/teacher (1).png")));
		menuBar.add(teacherManageMenu);

		teacherAddMenuItem = new JMenuItem("添加教师");
		teacherAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				TeacherAddFrm teacherAddFrm = new TeacherAddFrm();
				teacherAddFrm.setVisible(true);
				desktopPane.add(teacherAddFrm);
			}
		});
		teacherAddMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/添加.png")));
		teacherManageMenu.add(teacherAddMenuItem);

		teacherManageMenuItem = new JMenuItem("管理教师");
		teacherManageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				TeacherManageFrm teacherManageFrm = new TeacherManageFrm();
				teacherManageFrm.setVisible(true);
				desktopPane.add(teacherManageFrm);
			}
		});
		teacherManageMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/列表.png")));
		teacherManageMenu.add(teacherManageMenuItem);

		studentClassManageMenu = new JMenu("班级管理");
		studentClassManageMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/班级管理.png")));
		menuBar.add(studentClassManageMenu);

		studentClassAddMenuItem = new JMenuItem("添加班级");
		studentClassAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				addStudentClass(ae);
			}
		});
		studentClassAddMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/添加.png")));
		studentClassManageMenu.add(studentClassAddMenuItem);

		studentClassManageMenuItem = new JMenuItem("管理班级");
		studentClassManageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				studentClassManageFrm classManageFrm = new studentClassManageFrm();
				classManageFrm.setVisible(true);
				desktopPane.add(classManageFrm);
			}
		});
		studentClassManageMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/列表.png")));
		studentClassManageMenu.add(studentClassManageMenuItem);

		studentManageMenu = new JMenu("学生管理");
		studentManageMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/学生管理,头像,人 (1).png")));
		menuBar.add(studentManageMenu);

		studentAddMenuItem = new JMenuItem("添加学生");
		studentAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				StudentAddFrm studentAddFrm = new StudentAddFrm();
				studentAddFrm.setVisible(true);
				desktopPane.add(studentAddFrm);
			}
		});
		studentAddMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/添加.png")));
		studentManageMenu.add(studentAddMenuItem);

		studentManageMenuItem = new JMenuItem("管理学生");
		studentManageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				StudentManageFrm studentManageFrm = new StudentManageFrm();
				studentManageFrm.setVisible(true);
				desktopPane.add(studentManageFrm);
			}
		});
		studentManageMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/列表.png")));
		studentManageMenu.add(studentManageMenuItem);

		JMenu mnNewMenu_2 = new JMenu("帮助");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/帮助.png")));
		menuBar.add(mnNewMenu_2);

		JMenuItem menuItem_6 = new JMenuItem("关于我");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				aboutMe(ae);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		mnNewMenu_2.add(menuItem_6);

		JMenuItem menuItem_7 = new JMenuItem("联系我");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				contactMe(ae);
			}
		});
		menuItem_7.setIcon(new ImageIcon(MainFrm.class.getResource("/images/number.png")));
		mnNewMenu_2.add(menuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JTextPane textPane = new JTextPane();
		desktopPane.setLayer(textPane, -1);
		textPane.setFont(new Font("微软雅黑", Font.PLAIN, 50));
		textPane.setText("学生信息管理系统");
		textPane.setBounds(163, 143, 427, 61);
		desktopPane.add(textPane);

		JTextArea textArea = new JTextArea();
		desktopPane.setLayer(textArea, -1);
		textArea.setFont(new Font("微软雅黑", Font.BOLD, 17));
		textArea.setText("16电信2班\r\n庄捷\r\n201621191030");
		textArea.setBounds(320, 294, 135, 88);
		desktopPane.add(textArea);
		setLocationRelativeTo(null);
		setAuthority();
	}

	protected void contactMe(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		String info = "请致电15986909153\n";
		JOptionPane.showMessageDialog(this, info);
	}

	protected void addStudentClass(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		StudentClassAddFrm sca = new StudentClassAddFrm();
		sca.setVisible(true);
		desktopPane.add(sca);
	}

	protected void editPssdword(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}

	protected void aboutMe(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		String info = "16电信2班\n";
		info += "庄捷\n";
		info += "201621191030";
		JOptionPane.showMessageDialog(this, info);
		// JOptionPane.showOptionDialog(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);

	}

	private static void addPopup(Component component, final JPopupMenu popup)
	{
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e)
			{
				if (e.isPopupTrigger())
				{
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e)
			{
				if (e.isPopupTrigger())
				{
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e)
			{
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void setAuthority()
	{
		if ("学生".equals(userType.getName()))
		{
			studentAddMenuItem.setEnabled(false);
			studentClassManageMenu.setEnabled(false);
			teacherManageMenu.setEnabled(false);
		}
		if ("教师".equals(userType.getName()))
		{
			teacherAddMenuItem.setEnabled(false);
		}
	}
}
