import javax.swing.*;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{

	JTextField t1,t2,t3,t4,t5,t6,t7,t16;
	JButton b1,b2,b3;
	JComboBox c1,c3;
	Choice c2;
	JRadioButton r1,r2,r3,r4;
	ButtonGroup g1;
	AddCustomer()
	{
		JLabel l1 = new JLabel("NEW CUSTOMER FORM");
		l1.setBounds(100,20,300,30);
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Ink Free",Font.BOLD,30));
		add(l1);

		JLabel l2 = new JLabel("ID Proof");
		l1.setFont(new Font("Serif",Font.PLAIN,20));
		l2.setBounds(35,80,100,20);
		add(l2);

		c1= new JComboBox(new String[] {"Passport","Voter-Id Card","Driving License","Aadhar Card"});
		c1.setBounds(200,80,150,25);
		add(c1);

		JLabel l16 = new JLabel("Customer ID");
		l16.setBounds(35,120,100,20);
		add(l16);

		t16= new JTextField();
		t16.setBounds(200,120,150,25);
		add(t16);

		JLabel l3 = new JLabel("Phone Number");
		l3.setBounds(35,160,100,20);
		add(l3);

		t1= new JTextField();
		t1.setBounds(200,160,150,25);
		add(t1);

		JLabel l4 = new JLabel("First Name");
		l4.setBounds(35,200,100,20);
		add(l4);

		t2= new JTextField();
		t2.setBounds(200,200,150,25);
		add(t2);

		JLabel l11 = new JLabel("Last Name");
		l11.setBounds(35,240,100,20);
		add(l11);

		t6= new JTextField();
		t6.setBounds(200,240,150,25);
		add(t6);

		JLabel l5 = new JLabel("Gender");
		l5.setBounds(35,280,100,20);
		add(l5);

		r1=new JRadioButton("Male",true);
		r1.setBounds(200,280,80,25);
		r1.setBackground(Color.WHITE);
		add(r1);

		r2=new JRadioButton("Female");
		r2.setBounds(290,280,80,25);
		r2.setBackground(Color.WHITE);
		add(r2);

		g1 = new ButtonGroup();
		g1.add(r1);
		g1.add(r2);


		JLabel l6 = new JLabel("Country");
		l6.setBounds(35,320,100,20);
		add(l6);

		t3= new JTextField();
		t3.setBounds(200,320,150,25);
		add(t3);

		JLabel l7 = new JLabel("Allocated Room Number");
		l7.setBounds(35,360,150,20);
		add(l7);

		c2 = new Choice();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
			String str = "Select * from room where availability = 'Available'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(str);

			while(rs.next()){

						c2.add(rs.getString("room_number"));
			}

		}
		catch(Exception e){
			System.out.println(e);
		}

		c2.setBounds(200,360,150,25);
		add(c2);

		/*JLabel l8 = new JLabel("Cheked In");
		l8.setBounds(35,400,100,20);
		add(l8);

		r3=new JRadioButton("Yes",true);
		r3.setBounds(200,400,80,25);
		r3.setBackground(Color.WHITE);
		add(r3);

		r4=new JRadioButton("No");
		r4.setBounds(290,400,80,25);
		r4.setBackground(Color.WHITE);
		add(r4);*/

		JLabel l9 = new JLabel("Deposit");
		l9.setBounds(35,400,100,20);
		add(l9);

		t5= new JTextField();
		t5.setBounds(200,400,150,25);
		add(t5);

		b1= new JButton("Add Customer");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(35,440,150,25);
		b1.addActionListener(this);
		add(b1);

		b2= new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(200,440,150,25);
		b2.addActionListener(this);
		add(b2);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel l10 = new JLabel(i3);
		l10.setBounds(390,10,500,500);
		add(l10);

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(300,150,900,550);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			if(t2.getText().isEmpty() &&  t3.getText().trim().isEmpty()&& t16.getText().isEmpty() && t5.getText().trim().isEmpty() && t1.getText().isEmpty() )
			{
				JOptionPane.showMessageDialog(null,"Fields Are Empty");
			}
			else if(!(t16.getText()).matches("^((?!(0))[0-9]{4})$"))
			{
				JOptionPane.showMessageDialog(null,"Please Retype Customer ID & it must be atleast 4 digit");
			}
			else if(!(t1.getText()).matches("^((?!(0))[0-9]{10})$"))
			{
			JOptionPane.showMessageDialog(null,"Please Enter Correct Phone Number");
			}
			else if(!(t2.getText()).matches(("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,25}$")))
			{
			JOptionPane.showMessageDialog(null,"Please Retype First Name");
			}
			else if(!(t6.getText()).matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,25}$"))
			{
				JOptionPane.showMessageDialog(null,"Please Retype Last Name");
			}
			else if(!(t3.getText()).matches("^[a-zA-Z]{2,10}$"))
			{
				JOptionPane.showMessageDialog(null,"Please Retype Country Name ");
			}
			else if(!(t5.getText()).matches("^[1-9][0-9]*$"))
			{
				JOptionPane.showMessageDialog(null,"Please Retype Deposit");
			}
			else
			{
				String idP = (String) c1.getSelectedItem();
				String id = t16.getText();
				String number = t1.getText();
				String f_name = t2.getText();
				String l_name = t6.getText();
				String gender = null;
				if(r1.isSelected())
				{
					gender = "Male";
				}
				else if(r2.isSelected())
				{
					gender = "Female";
				}
				String country = t3.getText();
				String room = c2.getSelectedItem();
				String status = "Yes";
				/*if(r3.isSelected())
				{
					status = "Yes";
				}
				else if(r4.isSelected())
				{
					status = "No";
				}*/
				String deposit = t5.getText();
				String str = "insert into customer values ('"+id+"','"+idP+"','"+number+"','"+f_name+"','"+l_name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
				String str1 = "Update room set availability = 'Occupied' where room_number = '"+room+"' ";
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
					Statement stmt=con.createStatement();
					stmt.executeUpdate(str);
					stmt.executeUpdate(str1);
					JOptionPane.showMessageDialog(null,"New Customer Added");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		if(ae.getSource()==b2)
		{
			//new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main(String[] args){
		new AddCustomer().setVisible(true);
	}
}