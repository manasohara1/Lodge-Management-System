import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
public class ForgetPassword extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5;
	JPasswordField p1,p2;
	JButton b1;
	public String str=null;
	ForgetPassword(String username)
	{
		Font lfont=new Font("Calibri",Font.BOLD,20);
		setLayout(null);
		setSize(600,270);
		setLocation(500,200);
		l1=new JLabel("Enter your new password:");
		l1.setFont(lfont);
		l1.setBounds(10,25,250,40);
		add(l1);
		Font subfnt=new Font("Calibri",Font.PLAIN,14);
		l3=new JLabel("(Password  must  contain  1  special  character,");
		l3.setBounds(10,55,450,30);
		l3.setForeground(Color.RED);
		l3.setFont(subfnt);
		add(l3);
		l4=new JLabel("1  number,1  capital  letter ,1  small  letter & ");
		l4.setBounds(15,70,450,30);
		l4.setForeground(Color.RED);
		l4.setFont(subfnt);
		add(l4);
		l5=new JLabel("it  must  be 8  digit )");
		l5.setBounds(15,85,450,30);
		l5.setForeground(Color.RED);
		l5.setFont(subfnt);
		add(l5);
		p1=new JPasswordField();
		p1.setBounds(290,30,250,30);
		p1.setFont(lfont);
		add(p1);
		l2=new JLabel("Enter your new password again :");
		l2.setFont(lfont);
		l2.setBounds(10,110,350,40);
		add(l2);
		p2=new JPasswordField();
		p2.setBounds(290,110,250,30);
		p2.setFont(lfont);
		add(p2);
		b1=new JButton("Change Password");
		b1.setBounds(10,170,200,40);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		setVisible(true);
		System.out.println("got username: "+username);
		str=username;
		System.out.println("In str : "+str);
	}
	/*public static void main(String args[])
	{
		new ForgetPassword("manas");
	}*/
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try{
				String a=p1.getText().toString();
				String b=p2.getText().toString();
				/*System.out.println(b);
				System.out.println(a);
				System.out.println(b);*/
				if(a.equals(b))
				{
					if(isValidPassword(a))
					{
						conn c1=new conn();
						System.out.println("Str: "+str);
						System.out.println("Password : "+a);
						String q1="update login set password='"+a+"'where username='"+str+"'";
						int i= c1.s.executeUpdate(q1);
						System.out.print("i is : "+i);
						if(i>0)
						{
							System.out.println("Records update successfully");
							JOptionPane.showMessageDialog(null,"Updated password successfully!!");
							this.setVisible(false);
						}
						else
						{
							System.out.println("Not Updated!!");
						}
						//JOptionPane.showMessageDialog(null,"Incorrect username or password");
						//this.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Password  must  contain  1  special  character,\n 1  number,1  capital  letter ,1  small  letter & \n it  must  be 8  digit  ");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please check your password");
				}
			}//try
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}//action
	public static boolean isValidPassword(String password)
	{

	        // Regex to check valid password.
	        String regex = "^(?=.*[0-9])"
	                       + "(?=.*[a-z])(?=.*[A-Z])"
	                       + "(?=.*[@#$%^&+=])"
	                       + "(?=\\S+$).{8,20}$";

	        // Compile the ReGex
	        Pattern p = Pattern.compile(regex);

	        // If the password is empty
	        // return false
	        if (password == null) {
	            return false;
	        }

	        // Pattern class contains matcher() method
	        // to find matching between given password
	        // and regular expression.
	        Matcher m = p.matcher(password);

	        // Return if the password
	        // matched the ReGex
	        return m.matches();
    }
}

