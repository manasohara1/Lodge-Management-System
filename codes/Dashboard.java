import java.sql.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener
{
	JMenuBar mb;
	JMenu m1,m2,sm1,sm2;
	JMenuItem i1,i2,i3,i4,i5,i6,i7;
	Dashboard()
	{
		//Menubar-------------
			mb=new JMenuBar();
			mb.setBackground(Color.WHITE);
			mb.setBounds(0,0,1950,30);
			add(mb);
			//Menu----------
				m1=new JMenu("Hotel Management");
				Font mfont=new Font("Calibri",Font.BOLD,16);
				m1.setFont(mfont);
				m1.setForeground(Color.RED);
				mb.add(m1);
				//MenuItem-------
					i1=new JMenuItem("Receptionist");
					i1.addActionListener(this);
					m1.add(i1);
				m2=new JMenu("Admin");
				m2.setFont(mfont);
				m2.setForeground(Color.BLUE);
				//mb.add(m2);
				sm1=new JMenu("Room");
				//sm1.setFont(mfont);
				m2.add(sm1);
				m2.addSeparator();
				//MenuItem---------
					i2=new JMenuItem("Add rooms");
					i2.addActionListener(this);
					sm1.add(i2);
					i4=new JMenuItem("Delete Rooms");
					i4.addActionListener(this);
					sm1.add(i4);
					i6=new JMenuItem("Upadate Rooms");
					i6.addActionListener(this);
					sm1.add(i6);
				//-------------------
				sm2=new JMenu("Employee");
				//sm2.setFont("System",Font.PLAIN,14);
				//MenuItem---------------
					i3=new JMenuItem("Add Employee(s)");
					i3.addActionListener(this);
					sm2.add(i3);
					i5=new JMenuItem("Delete Employee(s)");
					i5.addActionListener(this);
					sm2.add(i5);
					i7=new JMenuItem("Update Employee(s)");
					i7.addActionListener(this);
					sm2.add(i7);
				m2.add(sm2);
				mb.add(m2);
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/l11.jpg"));
		Image img1=img.getImage().getScaledInstance(1450,1000,Image.SCALE_DEFAULT);
		ImageIcon img2=new ImageIcon(img1);
		JLabel l1=new JLabel(img2);
		l1.setBounds(0,0,1450,900);
		add(l1);
		JLabel l2=new JLabel("LodgeSmart WELCOMES YOU TO THE SYSTEM!!");
		l2.setForeground(Color.YELLOW);
		//l2.setForeground( new Color(232,230,176));

		l2.setFont(new Font("Consolas",Font.BOLD,34));
		l2.setBounds(350,70,1400,50);
		l1.add(l2);//adding label over image
		setLayout(null);
		setResizable(false);
		setSize(1400,700);
		setLocation(0,0);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new Dashboard().setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==i1)
		{
			new Reception().setVisible(true);
		}
		if(ae.getSource()==i2)
		{
			new AddRooms().setVisible(true);
		}
		if(ae.getSource()==i3)
		{
			new AddEmployee().setVisible(true);
		}
		if(ae.getSource()==i4)
		{
			new DeleteRoom().setVisible(true);
		}
		if(ae.getSource()==i5)
		{
			new DeleteEmployee().setVisible(true);
		}
		if(ae.getSource()==i6)
		{
			new UpdateRoom().setVisible(true);
		}
		if(ae.getSource()==i7)
		{
			new UpdateEmployee().setVisible(true);
		}
	}
}