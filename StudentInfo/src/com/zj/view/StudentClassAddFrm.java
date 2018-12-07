package com.zj.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.zj.dao.ClassDao;
import com.zj.model.StudentClass;
import com.zj.util.StringUti;

public class StudentClassAddFrm extends JInternalFrame
{
	private JTextField classNameTextField;
	private JTextArea classInfoTextArea;

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
//					StudentClassAddFrm frame = new StudentClassAddFrm();
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
	public StudentClassAddFrm()
	{
		setClosable(true);
		setIconifiable(true);

		setTitle("添加班级信息");
		setBounds(100, 100, 371, 279);

		JLabel label = new JLabel("班级名称：");
		label.setIcon(new ImageIcon(StudentClassAddFrm.class.getResource("/images/班级管理.png")));

		classNameTextField = new JTextField();
		classNameTextField.setColumns(10);

		JLabel label_1 = new JLabel("班级介绍：");
		label_1.setIcon(new ImageIcon(StudentClassAddFrm.class.getResource("/images/介绍.png")));

		classInfoTextArea = new JTextArea();

		JButton submitButton = new JButton("提交");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				submitClass(ae);
			}

		});
		submitButton.setIcon(new ImageIcon(StudentClassAddFrm.class.getResource("/images/确认.png")));

		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(StudentClassAddFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(54)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addComponent(label_1)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(classInfoTextArea,
												GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(label)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(classNameTextField))))
						.addGroup(groupLayout.createSequentialGroup().addGap(76).addComponent(submitButton).addGap(36)
								.addComponent(resetButton)))
				.addContainerGap(141, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(40)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
								classNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label_1).addComponent(
								classInfoTextArea, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGap(30).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(submitButton).addComponent(resetButton))
						.addContainerGap()));
		getContentPane().setLayout(groupLayout);

	}

	protected void submitClass(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		String className = classNameTextField.getText().toString();
		String classInfo = classInfoTextArea.getText().toString();
		if (StringUti.isEmpty(className))
		{
			JOptionPane.showMessageDialog(this, "请输入班级名称！");
			return;
		}
		StudentClass scl = new StudentClass();
		scl.setName(className);
		scl.setInfo(classInfo);
		ClassDao classDao = new ClassDao();
		if (classDao.addClass(scl))
		{
			JOptionPane.showMessageDialog(this, "添加班级成功");

		} else
		{
			JOptionPane.showMessageDialog(this, "添加班级失败");
		}
		classDao.closeDao();
		resetValue(ae);
	}

	protected void resetValue(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		classNameTextField.setText("");
		classInfoTextArea.setText("");
	}
}
