import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.*;
public class DeleteRoom extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	Choice c1;
	JButton b1,b2;
	DeleteRoom()
	{
		setSize(800,300);
		setLocation(400,200);
		setLayout(null);
		Font lfnt=new Font("System",Font.BOLD,14);
		l1=new JLabel("Delete Rooms");
		l1.setFont(new Font("Ink Free",Font.BOLD,24));
		l1.setBounds(160,0,200,30);
		l1.setForeground(Color.RED);
		add(l1);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delroom.jpg"));
        Image i2=i1.getImage().getScaledInstance(220,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l11=new JLabel(i3);
        l11.setBounds(450,50,300,150);
        add(l11);
		l2=new JLabel("Room Number : ");
		l2.setBounds(10,50,140,40);
		l2.setFont(lfnt);
		add(l2);
		String s="Available";
		c1 = new Choice();
		try{
			    conn c = new conn();
		        ResultSet rs = c.s.executeQuery("select room_number from room where availability='"+s+"'");
		        while(rs.next())
		        {
		        	c1.add(rs.getString("room_number"));
		        }
		 	}
		catch(Exception e)
		{
			System.out.println("Exception Occured while giving cid in choice");
		}
		setVisible(true);
		c1.setBounds(160,60,200,50);
		add(c1);
		b1=new JButton("Delete");
		b1.setBounds(30,150,120,30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		add(b1);
		b2=new JButton("Back");
		b2.setBounds(230,150,120,30);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.addActionListener(this);
		add(b2);
	}
	public static void main(String args[])
	{
		new DeleteRoom().setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			int room_number=Integer.parseInt(c1.getSelectedItem());
			try{
					conn c = new conn();
					c.s.executeUpdate("delete from room where room_number='"+room_number+"'");
					JOptionPane.showMessageDialog(null,"Deleted Room Successfully from the system!!");
				}
			catch(Exception e)
			{
				System.out.println("Exception Occured while deleting room from system");
			}
		 }
		 if(ae.getSource()==b2)
		 {
			 this.setVisible(false);
		 }
	}
}