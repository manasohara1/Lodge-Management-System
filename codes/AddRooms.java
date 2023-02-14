import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.*;
public class AddRooms extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	ButtonGroup g1;
	JRadioButton r1,r2,r3,r4,r5,r6;
	JButton b1,b2,b3;
	AddRooms()
	{
		l1 = new JLabel("Add Rooms");
		l1.setBounds(130,30,300,30);
		l1.setFont(new Font("Ink Free",Font.BOLD,30));
		l1.setForeground(Color.RED);
		add(l1);

		l2=new JLabel("Room Number");
		l2.setFont(new Font("Tahoma",Font.PLAIN,15));
		l2.setBounds(60,80,120,30);
		add(l2);

		t1=new JTextField(30);
		t1.setBounds(200,80,150,30);
		//t1.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(t1);

		l3=new JLabel("Availability");
		l3.setFont(new Font("Tahoma",Font.PLAIN,15));
		l3.setBounds(60,130,120,30);
		add(l3);

		r1=new JRadioButton("Available",true);
		r1.setBounds(200,130,80,25);
		r1.setBackground(Color.WHITE);
		add(r1);

		r2=new JRadioButton("Occupied");
		r2.setBounds(290,130,80,25);
		r2.setBackground(Color.WHITE);
		add(r2);

		g1 = new ButtonGroup();
		g1.add(r1);
		g1.add(r2);

		l4=new JLabel("Cleaning Status");
		l4.setFont(new Font("Tahoma",Font.PLAIN,15));
		l4.setBounds(60,180,120,30);
		add(l4);

		r3=new JRadioButton("Cleaned",true);
		r3.setBounds(200,180,80,25);
		r3.setBackground(Color.WHITE);
		add(r3);

		r4=new JRadioButton("Dirty");
		r4.setBounds(290,180,80,25);
		r4.setBackground(Color.WHITE);
		add(r4);

		g1 = new ButtonGroup();
		g1.add(r3);
		g1.add(r4);

		l5=new JLabel("Price");
		l5.setFont(new Font("Tahoma",Font.PLAIN,15));
		l5.setBounds(60,230,120,30);
		add(l5);

		t2=new JTextField(20);
		t2.setBounds(200,230,150,30);
		//t2.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(t2);

		l6=new JLabel("Bed Type");
		l6.setFont(new Font("Tahoma",Font.PLAIN,15));
		l6.setBounds(60,280,120,30);
		add(l6);

		r5=new JRadioButton("Single bed",true);
		r5.setBounds(200,280,100,25);
		r5.setBackground(Color.WHITE);
		add(r5);

		r6=new JRadioButton("Double bed");
		r6.setBounds(310,280,90,25);
		r6.setBackground(Color.WHITE);
		add(r6);

		g1 = new ButtonGroup();
		g1.add(r5);
		g1.add(r6);

		b1=new JButton("Add Room");
		b1.setBounds(60,350,130,30);
		b1.addActionListener(this);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		add(b1);

		b2=new JButton("Back");
		b2.setBounds(210,350,130,30);
		b2.addActionListener(this);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		add(b2);

		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/room1.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel lb1 = new JLabel(i2);
        lb1.setBounds(400,30,500,390);
        add(lb1);

        b3=new JButton("Reset");
        b3.setBounds(140,390,120,30);
        b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				t1.setText("");
        		c1.setSelectedIndex(0);
        		c2.setSelectedIndex(0);
        		t2.setText("");
        		c3.setSelectedIndex(0);
			}
		});
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);

        getContentPane().setBackground(Color.WHITE);


		setBounds(300,150,940,500);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		int room_price=Integer.parseInt(t2.getText());
		if(ae.getSource()==b1)
		{
			if(!(t1.getText()).matches("^((?!(0))[0-9]{4})$"))
			{
			JOptionPane.showMessageDialog(null,"Room no.  must be of four digits");
			}
			else if(!(t2.getText()).matches("^[1-9][0-9]*$"))
			{
				JOptionPane.showMessageDialog(null,"Price must be digit and >500");
			}
			else if(room_price<=500)
			{
				JOptionPane.showMessageDialog(null,"Price must be digit and >500");
			}
			else
			{
				int room=Integer.parseInt(t1.getText());
				String availablity=null;
				if(r1.isSelected())
				{
					availablity = "Available";
				}
				else if(r2.isSelected())
				{
					availablity = "Occupied";
				}
				String c_status=null;
				if(r3.isSelected())
				{
					c_status = "Cleaned";
				}
				else if(r4.isSelected())
				{
					c_status = "Dirty";
				}
				String bed_type=null;
				if(r5.isSelected())
				{
					bed_type = "Single bed";
				}
				else if(r6.isSelected())
				{
					bed_type = "Double bed";
				}
				int price=Integer.parseInt(t2.getText());
				try
				{
					conn c=new conn();
					String str1="insert into room values('"+room+"','"+availablity+"','"+c_status+"','"+price+"','"+bed_type+"')";
					c.s.executeUpdate(str1);
					JOptionPane.showMessageDialog(null,"New Room Added");
					//this.setVisible(false);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		if(ae.getSource()==b2)
		{
			new Dashboard().setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AddRooms();
	}
}