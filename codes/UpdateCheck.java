import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UpdateCheck extends JFrame
{
	Connection conn = null;
	PreparedStatement pst = null;
	JPanel contentPane;
	JTextField txt_ID, txt_Room, txt_Status, txt_f_name, txt_l_name, txt_d, txt_Payment,txt_Price;
	Choice c1, c2;
	public static void main(String[] args)
	{
		UpdateCheck frame = new UpdateCheck();
		frame.setVisible(true);
	}
	public void close()
	{
		this.dispose();
	}
	UpdateCheck()
	{
		JLabel l = new JLabel("Check-In Details");
		l.setForeground(Color.RED);
		l.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l.setBounds(100,10,300,30);
		add(l);

       	ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/check.png"));
        JLabel l1 = new JLabel(i1);
       	l1.setBounds(350,70,476,270);
       	add(l1);

		JLabel l2 = new JLabel("ID:");
		l2.setBounds(35, 70, 46, 14);
		add(l2);

       	c1 = new Choice();
        try{
       		    conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from customer");
               	while(rs.next())
               	{
                    c1.add(rs.getString("cid"));
                }
           }catch(Exception e)
           {
			  System.out.println("Exception Occured while giving cid in choice");
		   }
        c1.setBounds(200, 70, 140, 100);
		add(c1);

		JLabel l3 = new JLabel("Room Number :");
		l3.setBounds(35, 110, 107, 14);
		add(l3);

	    txt_ID = new JTextField();
	    txt_ID.setBounds(200, 110, 140, 20);
	    txt_ID.setEditable(false);
		add(txt_ID);

		JLabel l4 = new JLabel(" First Name : ");
		l4.setBounds(35, 150, 97, 14);
		add(l4);

		txt_f_name = new JTextField();
		txt_f_name.setBounds(200, 150, 140, 20);
		add(txt_f_name);
		txt_f_name.setEditable(false);
		txt_f_name.setColumns(10);


		JLabel l8 = new JLabel(" Last Name : ");
		l8.setBounds(35, 190, 97, 14);
		add(l8);

		txt_l_name = new JTextField();
		txt_l_name.setBounds(200, 190, 140, 20);
		add(txt_l_name);
		txt_l_name.setEditable(false);
		txt_l_name.setColumns(10);

		JLabel l5 = new JLabel("Checked-in :");
		l5.setBounds(35, 230, 107, 14);
		add(l5);

		txt_Status = new JTextField();
		txt_Status.setBounds(200, 230, 140, 20);
		add(txt_Status);
		txt_Status.setEditable(false);
		txt_Status.setColumns(10);


		JLabel l6 = new JLabel("Room Price(Rs) : ");
		l6.setBounds(35, 270, 107, 14);
		add(l6);

		txt_Price = new JTextField();
		txt_Price.setBounds(200, 270, 140, 20);
		txt_Price.setEditable(false);
		add(txt_Price);
		txt_Price.setColumns(10);

		JLabel l9 = new JLabel("Amount Paid (Rs) : ");
		l9.setBounds(35, 310, 107, 14);
		add(l9);
		txt_d = new JTextField();
		txt_d.setBounds(200, 310, 140, 20);
		add(txt_d);
		txt_d.setColumns(10);

		JLabel l7 = new JLabel("Pending Amount (Rs) : ");
		l7.setBounds(35, 350, 150, 14);
		add(l7);

		txt_Payment = new JTextField();
		txt_Payment.setBounds(200, 350, 140, 20);
		add(txt_Payment);
		txt_Payment.setEditable(false);
		txt_Payment.setColumns(10);

		JButton b = new JButton("Update");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				if(txt_ID.getText().isEmpty() &&  txt_f_name.getText().trim().isEmpty()&& txt_l_name.getText().isEmpty() && txt_Status.getText().trim().isEmpty() && txt_d.getText().isEmpty() && txt_Payment.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Fields Are Empty");
				}
				else if(!(txt_ID.getText()).matches("\\d{4}"))
				{
					JOptionPane.showMessageDialog(null,"Please Retype Room Number & it must be atMost 4 digit");
				}
				else if(!(txt_f_name.getText()).matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,25}$"))
				{
					JOptionPane.showMessageDialog(null,"Please Retype First Name");
				}
				else if(!(txt_l_name.getText()).matches(("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,25}$")))
				{
					JOptionPane.showMessageDialog(null,"Please Retype Last Name");
				}
				else if(!(txt_Status.getText()).matches("^(?:Yes|No)$"))
				{
					JOptionPane.showMessageDialog(null,"Please Retype Status[YES or NO] ");
				}
				else if(!(txt_d.getText()).matches("^[1-9][0-9]*$"))
				{
					JOptionPane.showMessageDialog(null,"Please Retype Amount Paid");
				}
				else
				{
					try{
                             conn c = new conn();
                             String s1 = c1.getSelectedItem();
							 String s2 = txt_ID.getText(); //room_number;
                             String s3 = txt_f_name.getText(); //name
                             String s4 = txt_l_name.getText();
                             String s5 = txt_Status.getText(); //status;
                             String s6 = txt_d.getText(); //deposit
                             c.s.executeUpdate("update customer set room_number = '"+s2+"', First_name = '"+s3+"',Last_name = '"+s4+"', status = '"+s5+"', deposit = '"+s6+"' where cid = '"+s1+"'");
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
		b.setBounds(168, 390, 99, 23);
        b.setBackground(Color.BLACK);
       	b.setForeground(Color.WHITE);
		add(b);

		JButton b2 = new JButton("Check");
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
            	try{
                   		String room=null;
                       	String deposit = null;
                        int amountPaid ;
                      	String price = null;
                   	    conn c = new conn();
                        String id = (String) c1.getSelectedItem();
                      	String str = "select * from customer where cid  = '"+id+"'";
                      	String str2="select price from room where room_number='"+room+"'";
                        ResultSet rs = c.s.executeQuery(str);
                        while(rs.next())
                        {
                         		txt_ID.setText(rs.getString("room_number"));
                                txt_f_name.setText(rs.getString("First_name"));
                                txt_l_name.setText(rs.getString("Last_name"));
                                txt_Status.setText(rs.getString("status"));
                                txt_d.setText(rs.getString("deposit"));
                                room=rs.getString("room_number");
                                deposit=rs.getString("deposit");
                      	}
						ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"' ");
                        while(rs2.next())
                        {
                        	price = rs2.getString("price");
                            amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                            txt_Payment.setText(Integer.toString(amountPaid));
                            txt_Price.setText(rs2.getString("price"));
                         }
                         ResultSet rs3=c.s.executeQuery(str2);
                         while(rs3.next())
                         {

						 }
                    }catch(Exception ee)
                    {
                    	System.out.println(ee);
					}
			}
		});
		b2.setBounds(56, 390, 99, 23);
       	b2.setBackground(Color.BLACK);
       	b2.setForeground(Color.WHITE);
		add(b2);

      	getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
		setBounds(300,150,800,460);
		setVisible(true);
	}

}