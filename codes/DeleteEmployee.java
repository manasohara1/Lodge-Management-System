import javax.swing.*;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.io.File;
import java.sql.*;

public class DeleteEmployee extends JFrame implements ActionListener{

	JButton b1,b2;
	Choice c2;

	DeleteEmployee(){

		JLabel l1 = new JLabel("Delete Employee");
		l1.setBounds(100,20,300,30);
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Ink Free",Font.BOLD,30));
		add(l1);

		JLabel l2 = new JLabel("Select Employee id");
		l2.setBounds(35,100,150,20);
		add(l2);

		c2 = new Choice();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
			String str = "Select * from employee";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(str);

			while(rs.next()){

						c2.add(rs.getString("eid"));
			}

		}
		catch(Exception e){
			System.out.println(e);
		}

		c2.setBounds(200,100,150,25);
		add(c2);

		b1=new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,150,150,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,150,150,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delemployee.png"));
        Image i2=i1.getImage().getScaledInstance(220,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l11=new JLabel(i3);
        l11.setBounds(450,50,300,150);
        add(l11);

		getContentPane().setBackground(Color.WHITE);

		setLayout(null);
		setBounds(300,150,700,300);
		setVisible(true);

}
public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== b1)
        {
            String eid =  c2.getSelectedItem();
            String str1 = "Delete from employee where eid = '"+eid+"' ";
			try
			{
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
				conn c1=new conn();
				c1.s.executeUpdate(str1);
				JOptionPane.showMessageDialog(null,"Employee Deleted ");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==b2)
		{
			this.setVisible(false);
		}
	}
	public static void main(String[] args)
	{
		new  DeleteEmployee().setVisible(true);
	}
}
