package com.zj.view;

import java.awt.EventQueue;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.zj.dao.TeacherDao;
import com.zj.model.Teacher;
import com.zj.util.StringUti;

public class TeacherManageFrm extends JInternalFrame
{
	private JTable teacherListTable;
	private JTextField searchTeacherNameTextField;
	private JTextField teacherNameEditTextField;
	private JTextField teacherTitleEditTextField;
	private JTextField teacherAgeEditTextField;
	private JTextField teacherPasswordEditTextField;
	private JComboBox teacherSexEditComboBox;
	private JButton deleteButton;
	private JButton submitButton;

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
					TeacherManageFrm frame = new TeacherManageFrm();
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
	public TeacherManageFrm()
	{
		setTitle("教师信息管理");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 642, 378);

		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel("教师姓名：");
		label.setIcon(new ImageIcon(TeacherManageFrm.class.getResource("/images/teacher (1).png")));

		searchTeacherNameTextField = new JTextField();
		searchTeacherNameTextField.setColumns(10);

		JButton searchButton = new JButton("查询");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				searchTeacher(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(TeacherManageFrm.class.getResource("/images/查找 表单 列表.png")));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6559\u5E08\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createSequentialGroup().addComponent(label).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(84).addComponent(searchButton).addGap(101))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 606,
												Short.MAX_VALUE)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
								.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(searchButton)
						.addComponent(label).addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap()));

		JLabel label_1 = new JLabel("教师姓名：");
		label_1.setIcon(new ImageIcon(TeacherManageFrm.class.getResource("/images/teacher (1).png")));

		teacherNameEditTextField = new JTextField();
		teacherNameEditTextField.setColumns(10);

		JLabel label_2 = new JLabel("教师性别：");
		label_2.setIcon(new ImageIcon(TeacherManageFrm.class.getResource("/images/体检性别分析.png")));

		teacherSexEditComboBox = new JComboBox();
		teacherSexEditComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "男", "女" }));

		JLabel label_3 = new JLabel("教师职称：");
		label_3.setIcon(new ImageIcon(TeacherManageFrm.class.getResource("/images/职称.png")));

		JLabel label_4 = new JLabel("教师年龄：");
		label_4.setIcon(new ImageIcon(TeacherManageFrm.class.getResource("/images/age.png")));

		teacherTitleEditTextField = new JTextField();
		teacherTitleEditTextField.setColumns(10);

		teacherAgeEditTextField = new JTextField();
		teacherAgeEditTextField.setColumns(10);

		submitButton = new JButton("确定修改");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				submitEditAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(TeacherManageFrm.class.getResource("/images/确认.png")));

		deleteButton = new JButton("删除信息");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				deleteTeacherAct(ae);
			}
		});
		deleteButton.setIcon(new ImageIcon(TeacherManageFrm.class.getResource("/images/删除.png")));

		JLabel label_5 = new JLabel("登录密码：");
		label_5.setIcon(new ImageIcon(TeacherManageFrm.class.getResource("/images/passwd.png")));

		teacherPasswordEditTextField = new JTextField();
		teacherPasswordEditTextField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup().addComponent(label_5)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(teacherPasswordEditTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(label_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(teacherNameEditTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(label_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(teacherSexEditComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addComponent(label_3)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(teacherTitleEditTextField,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(label_4)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(teacherAgeEditTextField,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(26).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(deleteButton)
						.addComponent(submitButton))
				.addContainerGap(149, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
												.addComponent(teacherNameEditTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_3)
												.addComponent(teacherTitleEditTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(submitButton))
										.addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
												.addComponent(teacherSexEditComboBox, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_4)
												.addComponent(teacherAgeEditTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(deleteButton))
										.addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_5)
												.addComponent(teacherPasswordEditTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		teacherListTable = new JTable();
		teacherListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae)
			{
				selectedTableRow(ae);
			}
		});
		teacherListTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "\u6559\u5E08ID", "\u6559\u5E08\u59D3\u540D",
						"\u6559\u5E08\u6027\u522B", "\u6559\u5E08\u804C\u79F0", "\u6559\u5E08\u5E74\u9F84" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false, false };

					public boolean isCellEditable(int row, int column)
					{
						return columnEditables[column];
					}
				});
		scrollPane.setViewportView(teacherListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Teacher());
		setAuthority();

	}

	protected void searchTeacher(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		String teacherNameString = searchTeacherNameTextField.getText().toString();
		Teacher teacher = new Teacher();
		teacher.setName(teacherNameString);
		setTable(teacher);
	}

	protected void submitEditAct(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		int row = teacherListTable.getSelectedRow();
		if (row == -1)
		{
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
			return;
		}
		String teacherName = teacherNameEditTextField.getText().toString();
		// String teacherSex = teacherSexEditComboBox.isSelected() ?
		// editTeacherSexManRadioButton.getText().toString() :
		// editTeacherSexFemalRadioButton.getText().toString();
		String teacherSex = teacherSexEditComboBox.getSelectedItem().toString();
		String teacherTitle = teacherTitleEditTextField.getText().toString();
		int teacherAge = 0;
		try
		{
			teacherAge = Integer.parseInt(teacherAgeEditTextField.getText().toString());
		} catch (Exception e)
		{
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "年龄只允许输入数字！");
			return;
		}
		String teacherPassword = teacherPasswordEditTextField.getText().toString();
		if (StringUti.isEmpty(teacherName))
		{
			JOptionPane.showMessageDialog(this, "教师姓名必须填写！");
			return;
		}
		if (StringUti.isEmpty(teacherTitle))
		{
			JOptionPane.showMessageDialog(this, "教师职称必须填写！");
			return;
		}
		if (teacherAge == 0 || teacherAge < 0)
		{
			JOptionPane.showMessageDialog(this, "教师年龄必须大于0！");
			return;
		}
//		if (StringUti.isEmpty(teacherPassword))
//		{
//			JOptionPane.showMessageDialog(this, "教师登录密码必须填写！");
//			return;
//		}
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(teacherListTable.getValueAt(row, 0).toString()));
		teacher.setName(teacherName);
		teacher.setSex(teacherSex);
		teacher.setTitle(teacherTitle);
		teacher.setAge(teacherAge);
		teacher.setPassword(teacherPassword);
		TeacherDao teacherDao = new TeacherDao();
		if (teacherDao.update(teacher))
		{
			JOptionPane.showMessageDialog(this, "修改成功！");
			resetValues();
		} else
		{
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		teacherDao.closeDao();
		setTable(new Teacher());
	}

	protected void selectedTableRow(MouseEvent ae)
	{
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) teacherListTable.getModel();
		teacherNameEditTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 1).toString());
		teacherTitleEditTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 3).toString());
		teacherAgeEditTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 4).toString());
		// teacherPasswordEditTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(),
		// 5).toString());
		String sex = dft.getValueAt(teacherListTable.getSelectedRow(), 2).toString();
		teacherSexEditComboBox.setSelectedIndex(getIndexBySex(sex));

	}

	private int getIndexBySex(String sex)
	{
		// TODO Auto-generated method stub
		if ("".equals(sex))
		{
			return 0;
		} else if ("男".equals(sex))
		{
			return 1;
		} else if ("女".equals(sex))
		{
			return 2;
		}
		return 0;
	}

	protected void deleteTeacherAct(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		int row = teacherListTable.getSelectedRow();
		if (row == -1)
		{
			JOptionPane.showMessageDialog(this, "请选择要删除的信息！");
			return;
		}

		if (JOptionPane.showConfirmDialog(this, "确定要删除信息？") != JOptionPane.OK_OPTION)
			return;
		int id = Integer.parseInt(teacherListTable.getValueAt(row, 0).toString());
		TeacherDao teacherDao = new TeacherDao();
		if (teacherDao.delete(id))
		{
			JOptionPane.showMessageDialog(this, "删除成功！");
			resetValues();
		} else
		{
			JOptionPane.showMessageDialog(this, "删除失败!");
		}
		teacherDao.closeDao();
		setTable(new Teacher());
	}

	private void setTable(Teacher teacher)
	{
//		if ("教师".equals(MainFrm.userType.getName()))
//		{
//			Teacher tLogined = (Teacher) MainFrm.userObject;
//			teacher.setName(tLogined.getName());
//			searchTeacherNameTextField.setText(teacher.getName());
//		}

		DefaultTableModel defaultTableModel = (DefaultTableModel) teacherListTable.getModel();
		defaultTableModel.setRowCount(0);
		TeacherDao teacherDao = new TeacherDao();
		List<Teacher> teacherList = teacherDao.getTeacherList(teacher);
		for (Teacher t : teacherList)
		{
			Vector vector = new Vector();
			vector.add(t.getId());
			vector.add(t.getName());
			vector.add(t.getSex());
			vector.add(t.getTitle());
			vector.add(t.getAge());
			// vector.add(t.getPassword());
			defaultTableModel.addRow(vector);
		}
		teacherDao.closeDao();
	}

	private void resetValues()
	{
		teacherAgeEditTextField.setText("");
		teacherNameEditTextField.setText("");
		teacherPasswordEditTextField.setText("");
		teacherSexEditComboBox.setSelectedIndex(0);
		teacherTitleEditTextField.setText("");
	}

	private void setAuthority()
	{
		if ("教师".equals(MainFrm.userType.getName()))
		{
			submitButton.setEnabled(false);
			deleteButton.setEnabled(false);
			// searchTeacherNameTextField.setEditable(false);
		}
	}
}
