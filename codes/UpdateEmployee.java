import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UpdateEmployee extends JFrame
{
	Connection conn = null;
	PreparedStatement pst = null;
	JButton b1,b2,b3,b4;
	JPanel contentPane;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	Choice c1, c2;
	public static void main(String[] args)
	{
		UpdateEmployee frame = new UpdateEmployee();
		frame.setVisible(true);
	}
	public void close()
	{
		this.dispose();
	}
	UpdateEmployee()
	{
		Font tfnt=new Font("Calibri",Font.PLAIN,18);
		Font lfnt=new Font("Calibri",Font.BOLD,16);
		JLabel l1 = new JLabel("Update Employee");
		l1.setBounds(100,20,300,30);
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Ink Free",Font.BOLD,30));
		add(l1);


       	ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/UpdateEmployee.png"));
       	Image i2=i1.getImage().getScaledInstance(320,400,Image.SCALE_DEFAULT);
       	ImageIcon i3=new ImageIcon(i2);
        JLabel l=new JLabel(i3);
       	l.setBounds(350,10,600,600);
       	add(l);

		JLabel l2 = new JLabel("Employee ID:");
		l2.setBounds(35, 70, 100, 20);
		l2.setFont(lfnt);
		add(l2);

       	c1 = new Choice();
        try{
       		    conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from employee");
               	while(rs.next())
               	{
                    c1.add(rs.getString("eid"));
                }
           }catch(Exception e)
           {
			  System.out.println("Exception Occured while giving eid in choice");
		   }
        c1.setBounds(200, 70, 140, 100);
		add(c1);

		JLabel l3 = new JLabel("First Name:");
		l3.setBounds(35, 110, 107, 14);
		l3.setFont(lfnt);
		add(l3);

	    t1 = new JTextField();
	    t1.setBounds(200, 110, 240, 20);
	    t1.setFont(tfnt);
		add(t1);

		JLabel l4 = new JLabel("Middle Name : ");
		l4.setBounds(35, 150, 120, 14);
		l4.setFont(lfnt);
		add(l4);

		t2 = new JTextField();
		t2.setBounds(200, 150, 240, 20);
		t2.setFont(tfnt);
		add(t2);
		//t2.setColumns(10);


		JLabel l8 = new JLabel(" Last Name : ");
		l8.setFont(lfnt);
		l8.setBounds(35, 190, 97, 14);
		add(l8);

		t3 = new JTextField();
		t3.setBounds(200, 190, 240, 20);
		t3.setFont(tfnt);
		add(t3);
		//t3.setColumns(10);

		JLabel l5 = new JLabel("gender :");
		l5.setBounds(35, 230, 107, 14);
		l5.setFont(lfnt);
		add(l5);

		t4 = new JTextField();
		t4.setBounds(200, 230, 240, 20);
		t4.setFont(tfnt);
		add(t4);
		//t4.setColumns(10);


		JLabel l6 = new JLabel("DOB: ");
		l6.setBounds(35, 270, 107, 14);
		l6.setFont(lfnt);
		add(l6);

		t5 = new JTextField();
		t5.setBounds(200, 270, 240, 20);
		t5.setFont(tfnt);
		add(t5);
		//t5.setColumns(10);

		JLabel l19 = new JLabel("Job : ");
		l19.setFont(lfnt);
		l19.setBounds(35, 310, 107, 14);
		add(l19);

		t7 = new JTextField();
		t7.setBounds(200, 310, 240, 20);
		t7.setFont(tfnt);
		add(t7);
		//t7.setColumns(10);

		JLabel l7 = new JLabel("Salary : ");
		l7.setBounds(35, 350, 150, 14);
		l7.setFont(lfnt);
		add(l7);

		t8 = new JTextField();
		t8.setBounds(200, 350, 240, 20);
		t8.setFont(tfnt);
		add(t8);
		//t8.setColumns(10);

		JLabel l18 = new JLabel("Phone no : ");
		l18.setBounds(35, 390, 150, 14);
		l18.setFont(lfnt);
		add(l18);

		t9 = new JTextField();
		t9.setBounds(200, 390, 240, 20);
		t9.setFont(tfnt);
		add(t9);
		//t9.setColumns(10);


		JLabel l10 = new JLabel("Aadhar no : ");
		l10.setBounds(35, 430, 150, 14);
		l10.setFont(lfnt);
		add(l10);

		t11 = new JTextField();
		t11.setBounds(200, 430, 240, 20);
		t11.setFont(tfnt);
		add(t11);
		//t11.setColumns(10);

		JLabel l11 = new JLabel("Email ID : ");
		l11.setBounds(35, 470, 150, 14);
		l11.setFont(lfnt);
		add(l11);

		t12 = new JTextField();
		t12.setBounds(200, 470, 240, 20);
		t12.setFont(tfnt);
		add(t12);
		//t12.setColumns(10);

		JButton b = new JButton("Check");
		b.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
            	try{
                   		String fn=null;
                       	String mn = null;
                       	String ln = null;
                        int amountPaid ;
                      	String price = null;
                   	    conn c = new conn();
                        String id = (String) c1.getSelectedItem();
                      	String str = "select * from employee where eid  = '"+id+"'";
                        ResultSet rs = c.s.executeQuery(str);
                        while(rs.next())
                        {
                         		t1.setText(rs.getString("fname"));
                                t2.setText(rs.getString("maname"));
                                t3.setText(rs.getString("lname"));
                                t4.setText(rs.getString("gender"));
                                t5.setText(rs.getString("dob"));
                                t7.setText(rs.getString("job"));
                                t8.setText(rs.getString("salary"));
                                t9.setText(rs.getString("phone"));
                                t11.setText(rs.getString("aadhar"));
                                t12.setText(rs.getString("email"));

                      	}

                    }catch(Exception ee)
                    {
                    	System.out.println(ee);
					}
			}
		});
		b.setBounds(30, 510, 99, 23);
        b.setBackground(Color.BLACK);
       	b.setForeground(Color.WHITE);
		add(b);

		JButton b1 = new JButton("Update");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				if(t1.getText().isEmpty() &&  t2.getText().trim().isEmpty()&& t3.getText().isEmpty() && t4.getText().trim().isEmpty() && t5.getText().isEmpty() && t6.getText().isEmpty() && t7.getText().isEmpty() && t8.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"Fields Are Empty");
                    }
                    else if(!(t1.getText()).matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,25}$"))
                    {
                        JOptionPane.showMessageDialog(null,"Please Retype First Name");
                    }
                    else if(!(t2.getText()).matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,25}$"))
                    {
                        JOptionPane.showMessageDialog(null,"Please Retype Middle Name");
                    }
                    else if(!(t3.getText()).matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,25}$"))
                    {
                        JOptionPane.showMessageDialog(null,"Please Retype Last Name");
                    }
                    else if(!(t4.getText()).matches("^(?:Male|Female)$"))
                    {
                        JOptionPane.showMessageDialog(null,"Please Retype Gender");
                    }
                    else if(!(t5.getText()).matches(("^\\d{4}-\\d{2}-\\d{2}$")))
                    {
                        JOptionPane.showMessageDialog(null,"Please Retype Your Date of Birth [YYYY-MM-DD]");
                    }
                    else if(!(t7.getText()).matches("^(?:Front Desk Clerks|Porters|Housekeeping|Room Service|Waiter/Waitress|Manager|Accountant)$"))
                    {
                        JOptionPane.showMessageDialog(null,"Please Retype Job(Front Desk Clerks,Porters,Housekeeping,Room Service,Waiter/Waitress,Manager,Accountant)");
                    }
                    else if(!(t8.getText()).matches("^[1-9][0-9]*$"))
                    {
                        JOptionPane.showMessageDialog(null,"Please Retype Salary");
                    }
                    else if(!(t9.getText()).matches("^((?!(0))[0-9]{10})$"))
                    {
                        JOptionPane.showMessageDialog(null,"Please Enter Correct Phone Number");
                    }
                    else if(!(t11.getText()).matches("^((?!(0))[0-9]{12})$"))
                    {
                        JOptionPane.showMessageDialog(null,"Please Retype Aadhar Number & It must be 12 digit ");
                    }
                    else if(!(t12.getText()).matches("^[A-Za-z0-9+_.-]+@(.+)$"))
                    {
                        JOptionPane.showMessageDialog(null,"Please Enter valid Email id");
                    }
				else
				{
					try{
                             conn c = new conn();
                             String s1 = c1.getSelectedItem();
							 String s2 = t1.getText();
                             String s3 = t2.getText();
                             String s4 = t3.getText();
                             String s5 = t4.getText();
                             String s6 = t5.getText();
                             String s8 = t7.getText();
                             String s9 = t8.getText();
                             String s10 = t9.getText();
                             String s11 = t11.getText();
                             String s12 = t12.getText();
                             c.s.executeUpdate("update employee set fname = '"+s2+"', maname = '"+s3+"',lname = '"+s4+"', gender = '"+s5+"', dob = '"+s6+"', job = '"+s8+"', salary = '"+s9+"', phone = '"+s10+"', aadhar = '"+s11+"', email = '"+s12+"' where eid = '"+s1+"'");
                             JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                             //new AddCustomer().setVisible(true);
                             //setVisible(false);
                        }catch(Exception ee)
                        {
                                System.out.println(ee);
                        }
				}
			}
		});
		b1.setBounds(168, 510, 99, 23);
        b1.setBackground(Color.BLACK);
       	b1.setForeground(Color.WHITE);
		add(b1);




      	getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
		setBounds(300,150,900,600);
		setVisible(true);
	}

}