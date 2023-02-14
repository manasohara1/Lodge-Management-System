import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.awt.event.*;
import java.sql.*;
public class FavColor extends JFrame implements ActionListener
{
	public JLabel l1,l2;
	public JTextField t1,t2;
	public JButton b1;
	FavColor()
	{
		setLayout(null);
		setSize(550,240);
		setLocation(500,200);
		l1=new JLabel("Enter your username again:");
		l1.setFont(new Font("System",Font.BOLD,16));
		l1.setBounds(10,25,250,40);
		add(l1);
		t1=new JTextField();
		t1.setFont(new Font("System",Font.BOLD,14));
		t1.setBounds(270,30,200,32);
		add(t1);
		l2=new JLabel("What is your favourate color?");
		l2.setFont(new Font("System",Font.BOLD,16));
		l2.setBounds(10,85,250,40);
		add(l2);
		JLabel sl1=new JLabel("(Please enter color in capital letters)");
		sl1.setFont(new Font("System",Font.PLAIN,12));
		sl1.setForeground(Color.RED);
		sl1.setBounds(10,110,200,30);
		add(sl1);
		t2=new JTextField();
		t2.setFont(new Font("System",Font.BOLD,14));
		t2.setBounds(270,90,200,32);
		add(t2);
		b1=new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(240,140,100,40);
		b1.addActionListener(this);
		add(b1);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new FavColor();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			if(t1.getText().isEmpty() &&  t2.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Fields Are Empty");
			}
			else
			{
				conn c1=new conn();
				String username=t1.getText().toString();
				String fav_color=t2.getText().toString();
				System.out.println("Username : "+username+"\nColor:"+fav_color);
				String q="select * from login where username= '"+username+"' and color='"+fav_color+"'";
				try{
						ResultSet rs=c1.s.executeQuery(q);
						if(rs.next())
						{
							//System.out.println("Changed Password Successfully!!");
							new ForgetPassword(username);//.setVisible(true);
							//JOptionPane.showMessageDialog(null,"Login Sucessfull!!!");
							this.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Incorrect username or fav_color");
							//this.setVisible(false);
						}
					}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
	}
}