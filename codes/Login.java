//package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
public class Login extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	public Login()
	{
		setResizable(false);
		setLayout(null);
		setBounds(400,200,550,250);
		Font lfnt=new Font("Calibri",Font.BOLD,18);
		l1=new JLabel("Username :");
		l1.setFont(lfnt);
		l1.setBounds(40,20,100,30);
		add(l1);

		l2=new JLabel("Password :");
		l2.setFont(lfnt);
		l2.setBounds(40,70,100,30);
		add(l2);

		t1=new JTextField();
		t1.setFont(lfnt);
		t1.setBounds(150,20,150,30);
		add(t1);

		t2=new JPasswordField();
		t2.setBounds(150,70,150,30);
		add(t2);

		l3=new JLabel("Forgot Password?");
		l3.setForeground(Color.BLUE);
		l3.setBounds(40,110,150,30);
		/*add a mouselistener instead and listen to mouse clicks*/
		  l3.addMouseListener(new MouseAdapter() {
		                @Override
		                public void mouseClicked(MouseEvent e) {
							new FavColor().setVisible(true);
							//this.
							setVisible(false);
		                    System.out.println("You Forgotted the password!!");
		                }

            });
		add(l3);

		b1=new JButton("Login");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(40,150,120,30);
		b1.addActionListener(this);
		add(b1);

		b2=new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(180,150,120,30);
		b2.addActionListener(this);
		add(b2);

		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		 Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
		 //we can not add image to label so converted to imgicon
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel l3=new JLabel(i3);
		 l3.setBounds(350,10,200,200);
		 add(l3);

		 //changing bg of whole frame
		 getContentPane().setBackground(Color.WHITE);
		 setVisible(true);
	}
	public static void main(String[] args)
	{
		new Login().setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==b1)
			{
				conn c1=new conn();
				String a=t1.getText();
				String temp=t2.getText();
				if(!isValidPassword(temp))
				{
					JOptionPane.showMessageDialog(null,"Please enter proper password");
					//this.setVisible(false);
				}
				else
				{
					String b=t2.getText();
					String q="select * from login where username= '"+a+"' and password='"+b+"'";
					try{
						ResultSet rs=c1.s.executeQuery(q);
						if(rs.next())
						{
							System.out.println("Logged In Successfully!!");
							new Dashboard();//.setVisible(true);
							JOptionPane.showMessageDialog(null,"Login Sucessfull!!!");
							this.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Incorrect username or password");
							//this.setVisible(false);
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}//if 1
			else if(ae.getSource() ==b2)
			{
				System.exit(0);
			}//if2
			if(ae.getSource()==l3)
			{
				System.out.println("Forgotted Password!!");
			}
		} //try
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
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
