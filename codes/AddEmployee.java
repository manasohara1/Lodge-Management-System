import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher.*;
import java.util.regex.Pattern.*;
public class AddEmployee extends JFrame implements ActionListener
{
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JRadioButton r1,r2;
    JComboBox c1,c2;
    JButton b1,b2;
    ButtonGroup g1;
    int eid;
    AddEmployee()
    {
        //tfont
        Font tfnt=new Font("Comic Sans MS",Font.BOLD,14);
        Font lfnt=new Font("Calibri",Font.PLAIN,20);
        Random ran=new Random();
		int first4= (ran.nextInt() %500)+ 100;
		eid=Math.abs(first4);
        //name------------------------------
        JLabel fname=new JLabel("First Name :");
        fname.setBounds(60, 30, 120, 30);
        fname.setFont(lfnt);
        add(fname);
        t1=new JTextField();
        t1.setBounds(200, 30, 150, 30);
        t1.setFont(tfnt);
        add(t1);
        JLabel mname=new JLabel("Middle Name :");
		mname.setBounds(60, 80, 160, 30);
		mname.setFont(lfnt);
		add(mname);
		t7=new JTextField();
		t7.setBounds(200, 80, 150, 30);
		t7.setFont(tfnt);
        add(t7);
        JLabel lname=new JLabel("Last Name : ");
		lname.setBounds(60, 128, 160, 30);
		lname.setFont(lfnt);
		add(lname);
		t8=new JTextField();
		t8.setBounds(200, 128, 150, 30);
		t8.setFont(tfnt);
        add(t8);
        //name done-------------------------

        //age------------------------------
        JLabel age=new JLabel("Date of birth : ");
        JLabel date_format=new JLabel("(YYYY-MM-DD)");
        date_format.setFont(new Font("System",Font.PLAIN,12));
        date_format.setBounds(60,195,160,30);
        add(date_format);
        age.setBounds(60, 180, 150, 30);
        add(age);
        age.setFont(lfnt);
        t2=new JTextField();
        t2.setBounds(200, 180, 150, 30);
        t2.setFont(tfnt);
        add(t2);
        //age done-------------------------

        //gender------------------------------
        JLabel gender=new JLabel("Gender : ");
        gender.setFont(lfnt);
        gender.setBounds(60, 230, 120, 30);
        add(gender);
        r1=new JRadioButton("Male");
        r1.setBounds(200, 230, 70, 30);
        r1.setFont(new Font("Tohoma",Font.PLAIN,14));
        r1.setBackground(Color.WHITE);
        add(r1);
        r2=new JRadioButton("Female");
        r2.setBounds(270, 230, 100, 30);
        r2.setFont(new Font("Tohoma",Font.PLAIN,14));
        r2.setBackground(Color.WHITE);
        add(r2);
        g1=new ButtonGroup();
        g1.add(r1);
        g1.add(r2);
        //gender done-------------------------

        //Job------------------------------
        JLabel job=new JLabel("Job : ");
        job.setFont(lfnt);
        job.setBounds(60, 280, 120, 30);
        add(job);
        //types of jobs for employee
        String []s1={"Front Desk Clerks","Porters","Housekeeping","Room Service","Waiter/Waitress","Manager","Accountant"};
        c1=new JComboBox(s1);
        c1.setBounds(200, 280, 150, 30);
        c1.setBackground(Color.WHITE);
        add(c1);
        //job done-------------------------

        //salary------------------------------
        JLabel salary=new JLabel("Salary : ");
        salary.setFont(lfnt);
        salary.setBounds(60, 330, 120, 30);
        add(salary);
        t3=new JTextField();
        t3.setFont(tfnt);
        t3.setBounds(200, 330, 150, 30);
        add(t3);
        //salary done-------------------------

         //phone------------------------------
         JLabel phone=new JLabel("Phone : ");
         phone.setFont(lfnt);
         phone.setBounds(60, 380, 120, 30);
         add(phone);
         t4=new JTextField();
         t4.setFont(tfnt);
         t4.setBounds(200, 380, 150, 30);
         add(t4);
         //phone done-------------------------

        //AADHAR------------------------------
        JLabel aadhar=new JLabel("Aadhar : ");
        aadhar.setFont(lfnt);
        aadhar.setBounds(60, 430, 120, 30);
        add(aadhar);
        t5=new JTextField();
        t5.setFont(tfnt);
        t5.setBounds(200, 430, 150, 30);
        add(t5);
        //AADHAR done-------------------------

        //Email------------------------------
         JLabel email=new JLabel("Email : ");
         email.setFont(lfnt);
         email.setBounds(60, 480, 120, 30);
         add(email);
         t6=new JTextField();
         t6.setFont(tfnt);
         t6.setBounds(200, 480, 150, 30);
         add(t6);
         //Email done-------------------------

        //buttons-----------------------------
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200,540,150,30);
        b1.addActionListener(this);
        add(b1);
        b2=new JButton("Reset");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(20,540,150,30);
		b2.addActionListener(this);
        add(b2);
        //butons done-------------------------

         //Image
       	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Emp11.jpg"));
        Image i2=i1.getImage().getScaledInstance(430,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(380,80,450,450);
        add(l1);
         //Image done-------------------------

        JLabel l2=new JLabel("Add Employee Details: ");
        l2.setForeground(Color.BLUE);
        l2.setBounds(420, 30, 400, 30);
        l2.setFont(new Font("Aleo",Font.BOLD,30));
        add(l2);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //setBounds(250, 100, 850, 640);
       	setSize(800,620);
        setLocation(340,140);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new AddEmployee().setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
			if(t1.getText().isEmpty() &&  t2.getText().trim().isEmpty()&& t3.getText().isEmpty() && t4.getText().trim().isEmpty() && t5.getText().isEmpty() && t6.getText().isEmpty() && t7.getText().isEmpty() && t8.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null,"Fields Are Empty");
					}
					else if(!(t1.getText()).matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,25}$"))
					{
						JOptionPane.showMessageDialog(null,"Please Retype First Name");
					}
					else if(!(t7.getText()).matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,25}$"))
					{
						JOptionPane.showMessageDialog(null,"Please Retype Middle Name");
					}
					else if(!(t8.getText()).matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,25}$"))
                    {
                        JOptionPane.showMessageDialog(null,"Please Retype Last Name");
                    }
					else if(!(t2.getText()).matches(("^\\d{4}-\\d{2}-\\d{2}$")))
					{
						JOptionPane.showMessageDialog(null,"Please Retype Your Date of Birth [YYYY-MM-DD]");
					}
					else if(!(t3.getText()).matches("^[1-9][0-9]*$"))
					{
						JOptionPane.showMessageDialog(null,"Please Retype Salary");
					}
					else if(!(t4.getText()).matches("^((?!(0))[0-9]{10})$"))
					{
						JOptionPane.showMessageDialog(null,"Please Enter Correct Phone Number");
					}
					else if(!(t5.getText()).matches("^((?!(0))[0-9]{12})$"))
					{
						JOptionPane.showMessageDialog(null,"Please Retype Aadhar Number & It must be 12 digit ");
					}
					else if(!(t6.getText()).matches("^[A-Za-z0-9+_.-]+@(.+)$"))
					{
						JOptionPane.showMessageDialog(null,"Please Enter valid Email id");
					}
					else
					{
						String fname= t1.getText();
						String mname= t7.getText();
						String lname= t8.getText();
						String dob  = t2.getText();
						String gender = null;
						if(r1.isSelected())
						{
							gender = "Male";
						}
						else if(r2.isSelected())
						{
							gender = "Female";
						}
						String job = (String)c1.getSelectedItem();
						//int phone= Integer.valueOf(t4.getText());
						String phone=t4.getText();
						float salary = Float.valueOf(t3.getText());
						//int aadhar=Integer.valueOf(t5.getText());
						String aadhar=t5.getText();
						String email=t6.getText();
						System.out.println("Entered Deatils Are:");
						System.out.println("Fname :"+fname+"\nMname: "+mname+"\nLname : "+lname+"Gender : "+gender);
						System.out.println("job : "+job+"\nSal:"+salary+"\nphone: "+phone+"\naadhar : "+aadhar+"\nemail"+email);
                        String str1 = "select * from employee where aadhar='"+aadhar+"' ";
						String str = "insert into employee values ('"+eid+"','"+fname+"','"+mname+"','"+lname+"','"+gender+"','"+dob+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
						try{
							conn c1=new conn();
                            ResultSet rs = c1.s.executeQuery(str1);
                            if(rs.next()){

                                JOptionPane.showMessageDialog(null,"Duplicate entry of aadhar numbers");

                            }
                            else{

							c1.s.executeUpdate(str);
							JOptionPane.showMessageDialog(null,"New Employee Added");
							this.setVisible(false);
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