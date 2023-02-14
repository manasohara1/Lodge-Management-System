import java.awt.*;
import java.awt.event.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.sql.*;

public class RoomStatus extends JFrame
{
	Choice c1;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	RoomStatus()
	{

		JLabel l1=new JLabel("Update Room Status");
		l1.setFont(new Font("Tahoma",Font.PLAIN,25));
		l1.setForeground(Color.RED);
		l1.setBounds(30,30,250,30);
		add(l1);

		JLabel l2=new JLabel("Guest ID:");
		l2.setBounds(30,80,120,20);
		add(l2);

		c1=new Choice();
		try{
			conn c=new conn();
			ResultSet rs=c.s.executeQuery("select * from customer");
			while(rs.next())
			{
				c1.add(rs.getString("cid"));
			}
		}
		catch(Exception e){}
		c1.setBounds(200,80,150,25);
		add(c1);

		JLabel l3=new JLabel("Room Number:");
		l3.setBounds(30,130,120,20);
		add(l3);

		t1=new JTextField(20);
		t1.setBounds(200,130,150,25);
		add(t1);

		JLabel l4=new JLabel("Availability");
		l4.setBounds(30,180,120,20);
		add(l4);

		t2=new JTextField(20);
		t2.setBounds(200,180,150,25);
		t2.setEditable(false);
		add(t2);

		JLabel l5=new JLabel("Clean Status");
		l5.setBounds(30,230,120,20);
		add(l5);

		t3=new JTextField(20);
		t3.setBounds(200,230,150,25);
		add(t3);

		b1=new JButton("Check");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(130,300,120,30);
		b1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent ae) {


				try
			{
				String id=c1.getSelectedItem();
				conn c=new conn();
				ResultSet rs1=c.s.executeQuery("select * from customer where cid="+id);
				while(rs1.next())
				{
					t1.setText(rs1.getString("Room_number"));
				}
			}
			catch(Exception e){}

			try
			{
				String rno=t1.getText();
				conn c=new conn();
				ResultSet rs2=c.s.executeQuery("select * from room where Room_number="+rno);
				while(rs2.next())
				{
					t2.setText(rs2.getString("Availability"));
					t3.setText(rs2.getString("Clean_Status"));
				}
			}
			catch(Exception e){}
		}


		});
		add(b1);

		b2=new JButton("Update");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(40,350,120,30);
		b2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent ae){

			  if(!(t1.getText()).matches("^((?!(0))[0-9]{4})$")){

			JOptionPane.showMessageDialog(null,"Please Retype Room number & it must be atleast 3 digit");

			}else if(!(t2.getText()).matches("^(?:Available|Occupied)$")){

			JOptionPane.showMessageDialog(null,"Please Retype Availability[Available or Occupied]");

			}else if(!(t3.getText()).matches("^(?:Clean|Dirty)$")){

			JOptionPane.showMessageDialog(null,"Please Retype Status[Yes or No]");
		}
		else{
				try
			{
				conn c=new conn();
				String rno=t1.getText();
				String status=t3.getText();
				String str="update room set Clean_status = '"+status+"' where Room_number = "+rno;
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"Status Updated");
			}
			catch(Exception e){}
		}
	}

		});
		add(b2);

		b3=new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(220,350,120,30);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new Reception().setVisible(true);
                        setVisible(false);
			}
		});
		add(b3);

		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bed3.jpeg"));
        Image i3 = i1.getImage().getScaledInstance(500,250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel lb1 = new JLabel(i2);
        lb1.setBounds(400,80,550,250);
        add(lb1);

		setLayout(null);
		setSize(1000,450);
		setResizable(false);
		setVisible(true);
	}


	public static void main(String[] args) {
		new RoomStatus();
	}
}