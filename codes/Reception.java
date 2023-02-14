import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Reception extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    JLabel l4;
    Reception()
    {
		l4=new JLabel("Receptionist");
		l4.setBounds(360,30,200,30);
		l4.setFont(new Font("Papyrus",Font.BOLD,26));
		l4.setForeground(Color.RED);
		add(l4);

        b1=new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10, 30, 200, 30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(10, 70, 200, 30);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Department");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(10, 110, 200, 30);
        b3.addActionListener(this);
        add(b3);

        b4=new JButton("All Employee Info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(10, 150, 200, 30);
        b4.addActionListener(this);
        add(b4);

        b5=new JButton("Customer Info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(10, 190, 200, 30);
        b5.addActionListener(this);
        add(b5);

        b6=new JButton("Manager Information");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(10, 230, 200, 30);
        b6.addActionListener(this);
        add(b6);

        b7=new JButton("Check out");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(10, 270, 200, 30);
        b7.addActionListener(this);
        add(b7);

        b8=new JButton("Update Check Status");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBounds(10, 310, 200, 30);
        b8.addActionListener(this);
        add(b8);

        b9=new JButton("Update Room Status");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.addActionListener(this);
        b9.setBounds(10, 350, 200, 30);
        add(b9);

        b10=new JButton("Search Rooms");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.setBounds(10, 390, 200, 30);
        b10.addActionListener(this);
        add(b10);

        b11=new JButton("Logout");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.setBounds(10, 430, 200, 30);
        b11.addActionListener(this);
        add(b11);

        //adding image to frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/receptionist.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        //we can not add image to label so converted to imgicon
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(200,100,500,280);
        add(l3);

        setLayout(null);
        setSize(700,550);
        setLocation(350, 200);
    }
    public static void main(String[] args)
    {
     	new Reception().setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
			new AddCustomer().setVisible(true);
        }
        else if(ae.getSource()==b2)
        {
			new RoomDis().setVisible(true);
		}
		else if(ae.getSource()==b3)
		{
			new Department().setVisible(true);
		}
        else if(ae.getSource()==b4)
        {
            new EmployeeDis().setVisible(true);
        }
        else if(ae.getSource()==b5)
        {
			new CustomerDis().setVisible(true);
		}
		else if(ae.getSource()==b6)
		{
			new ManagerDis().setVisible(true);
		}
		else if(ae.getSource()==b7)
		{
			new CheckOut().setVisible(true);
		}
		else if(ae.getSource()==b8)
		{
			new UpdateCheck().setVisible(true);
		}
		else if(ae.getSource()==b9)
		{
			new RoomStatus().setVisible(true);
		}
		else if(ae.getSource()==b10)
		{
			new SearchRoom().setVisible(true);
		}
		else if(ae.getSource()==b11)
		{
			this.setVisible(false);
			JOptionPane.showMessageDialog(null,"Logged out Successfully !! ");
			new HotelManagementSystem().setVisible(true);
		}
    }
}