package com.zj.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.zj.dao.ClassDao;
import com.zj.model.StudentClass;
import com.zj.util.StringUti;

public class studentClassManageFrm extends JInternalFrame
{
	private JTextField searchClassNameTextField;
	private JTable classListTable;
	private JTextField editClassNameTextField;
	private JTextArea editClassInfoTextField;

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
					studentClassManageFrm frame = new studentClassManageFrm();
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
	public studentClassManageFrm()
	{
		setClosable(true);
		setIconifiable(true);

		setTitle("班级信息管理");
		setBounds(50, 50, 524, 388);

		JLabel label = new JLabel("班级名称：");
		label.setIcon(new ImageIcon(studentClassManageFrm.class.getResource("/images/班级管理.png")));

		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setColumns(10);

		JButton searchButton = new JButton("查询");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				StudentClass sc = new StudentClass();
				sc.setName(searchClassNameTextField.getText().toString());
				setTable(sc);
			}
		});
		searchButton.setIcon(new ImageIcon(studentClassManageFrm.class.getResource("/images/查找 表单 列表.png")));

		JScrollPane scrollPane = new JScrollPane();

		JLabel label_1 = new JLabel("班级名称：");
		label_1.setIcon(new ImageIcon(studentClassManageFrm.class.getResource("/images/班级管理.png")));

		editClassNameTextField = new JTextField();
		editClassNameTextField.setColumns(10);

		JLabel label_2 = new JLabel("班级信息：");
		label_2.setIcon(new ImageIcon(studentClassManageFrm.class.getResource("/images/介绍.png")));

		editClassInfoTextField = new JTextArea();
		editClassInfoTextField.setColumns(10);

		JButton submitEditButton = new JButton("确认修改");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(studentClassManageFrm.class.getResource("/images/确认.png")));

		JButton submitDeleteButton = new JButton("删除信息");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				deleteClassAct(ae);
			}
		});
		submitDeleteButton.setIcon(new ImageIcon(studentClassManageFrm.class.getResource("/images/删除.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(75).addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 130,
										GroupLayout.PREFERRED_SIZE)
								.addGap(51)
								.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(74)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup().addComponent(label_1)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 134,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(label_2)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(editClassInfoTextField)))
								.addGap(35)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(submitDeleteButton).addComponent(submitEditButton))))
				.addContainerGap(48, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
						.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
						.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(submitEditButton))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
						.addComponent(editClassInfoTextField, GroupLayout.PREFERRED_SIZE, 48,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(submitDeleteButton))
				.addContainerGap(22, Short.MAX_VALUE)));

		classListTable = new JTable();
		classListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me)
			{
				selectedTableRow(me);
			}
		});
		classListTable.setFont(new Font("微软雅黑", Font.BOLD, 14));
		classListTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u4FE1\u606F" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column)
			{
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(classListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new StudentClass());
	}

	protected void deleteClassAct(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(this, "确定要删除吗？") != JOptionPane.OK_OPTION)
		{
			return;
		}
		int index = classListTable.getSelectedRow();
		if (index == -1)
		{
			JOptionPane.showMessageDialog(this, "请选中要删除的班级！");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		ClassDao classDao = new ClassDao();
		if (classDao.delete(id))
		{
			JOptionPane.showMessageDialog(this, "删除成功！");

		} else
		{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		classDao.closeDao();
		setTable(new StudentClass());
	}

	protected void submitEditAct(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		ClassDao classDao = new ClassDao();
		int index = classListTable.getSelectedRow();
		if (index == -1)
		{
			JOptionPane.showMessageDialog(this, "请选中需要修改的信息");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		String className = dft.getValueAt(classListTable.getSelectedRow(), 1).toString();
		String classInfo = dft.getValueAt(classListTable.getSelectedRow(), 2).toString();
		String editClassName = editClassNameTextField.getText().toString();
		String editClassInfo = editClassInfoTextField.getText().toString();

		if (StringUti.isEmpty(editClassName))
		{
			JOptionPane.showMessageDialog(this, "请输入修改班级！");
			return;
		}
		if (className.equals(editClassName) && classInfo.equals(editClassInfo))
		{
			JOptionPane.showMessageDialog(this, "你还没有做任何修改！");
			return;
		}

		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		StudentClass sc = new StudentClass();
		sc.setId(id);
		sc.setName(editClassName);
		sc.setInfo(editClassInfo);
		if (classDao.update(sc))
		{
			JOptionPane.showMessageDialog(this, "班级信息更新成功！");
			editClassNameTextField.setText("");
			editClassInfoTextField.setText("");
		} else
		{
			JOptionPane.showMessageDialog(this, "班级信息更新失败！");
		}
		classDao.closeDao();
		setTable(new StudentClass());
	}

	protected void selectedTableRow(MouseEvent me)
	{
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 1).toString());
		editClassInfoTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 2).toString());
	}

	private void setTable(StudentClass studentClass)
	{
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		dft.setRowCount(0);
		ClassDao classDao = new ClassDao();
		List<StudentClass> classList = classDao.getClassList(studentClass);
		for (StudentClass sc : classList)
		{
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getInfo());
			dft.addRow(v);
		}
		classDao.closeDao();
	}
}
