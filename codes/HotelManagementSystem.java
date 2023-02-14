import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
public class HotelManagementSystem extends JFrame implements ActionListener
{
	JButton b1;
	public HotelManagementSystem()
	{
		setSize(1300,520);

		setResizable(false);
		setLocation(50,100);
		// we  can use
		//setBounds(0, 100,1366,565);

		/*ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/lodge11.jpg"));
		JLabel lb1=new JLabel(i1);
		lb1.setBounds(0,0,1366,565);
		add(lb1);*/
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/lodge11.jpg"));
		Image i3 = i1.getImage().getScaledInstance(1300,500,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel lb1 = new JLabel(i2);
		lb1.setBounds(0,0,1300,500);
        add(lb1);


		JLabel l2=new JLabel("LodgeSmart");
		l2.setBounds(20,390,1000,90);
		lb1.add(l2);
		l2.setForeground(Color.YELLOW);
		l2.setFont(new Font("Serif",Font.PLAIN,70));

		b1=new JButton("Next");
		b1.setFont(new Font("Serif",Font.BOLD,20));
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.YELLOW);
		b1.setBounds(1100,440,150,40);
		lb1.add(b1);
		//adding listener
		b1.addActionListener(this);

		setLayout(null);
		setVisible(true);

		while(true)
		{
			l2.setVisible(false);
				try
				{
					Thread.sleep(500);
				}catch(Exception e) {}
			l2.setVisible(true);
				try
				{
					Thread.sleep(500);
				}catch(Exception e) {}
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			new Login().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main(String[] args)
	{
		new HotelManagementSystem().setVisible(true);
	}
}
