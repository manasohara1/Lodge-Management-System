import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UpdateRoom extends JFrame
{
	Connection conn = null;
	PreparedStatement pst = null;
	JPanel contentPane;
	JTextField txt_availability,txt_bed,txt_clean,txt_Price,txt_Bed;
	Choice c1, c2;
	public static void main(String[] args)
	{
		new UpdateRoom();
	}
	public void close()
	{
		this.dispose();
	}
	UpdateRoom()
	{
		JLabel l = new JLabel("Update Room Details");
		l.setForeground(Color.RED);
		l.setFont(new Font("Tahoma", Font.BOLD, 20));
		l.setBounds(90,10,300,30);
		add(l);

       	ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/Updateroom.png"));
        JLabel l1 = new JLabel(i1);
       	l1.setBounds(450,50,476,270);
       	add(l1);

		JLabel l2 = new JLabel("Room Number");
		l2.setBounds(35,70,100,14);
		add(l2);

       	c1 = new Choice();
        try{
       		    conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from room where availability='Available' ");
               	while(rs.next())
               	{
                    c1.add(rs.getString("room_number"));
                }
           }catch(Exception e)
           {
			  System.out.println("Exception Occured while giving cid in choice");
		   }
        c1.setBounds(200, 70, 140, 100);
		add(c1);

		JLabel l3 = new JLabel("Availability");
		l3.setBounds(35, 110, 107, 14);
		add(l3);

	    txt_availability = new JTextField();
	    txt_availability.setBounds(200, 110, 140, 20);
	    txt_availability.setEditable(false);
		add(txt_availability);

		JLabel l4 = new JLabel("Clean Status");
		l4.setBounds(35, 150, 97, 14);
		add(l4);

		txt_clean = new JTextField();
		txt_clean.setBounds(200, 150, 140, 20);
		add(txt_clean);
		txt_clean.setEditable(false);
		txt_clean.setColumns(10);


		JLabel l8 = new JLabel("Price");
		l8.setBounds(35, 190, 97, 14);
		add(l8);

		txt_Price = new JTextField();
		txt_Price.setBounds(200, 190, 140, 20);
		add(txt_Price);
		txt_Price.setColumns(10);

		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(35, 230, 107, 14);
		add(l5);

		txt_Bed = new JTextField();
		txt_Bed.setBounds(200, 230, 140, 20);
		add(txt_Bed);
		txt_Bed.setColumns(10);


		JButton b = new JButton("Update");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				if(!(txt_Price.getText()).matches("^[1-9][0-9]*$"))
				{
					JOptionPane.showMessageDialog(null,"Please Retype Amount Paid");
				}
                else if(!(txt_Bed.getText()).matches("^(?:Single Bed|Double Bed)$")){

                    JOptionPane.showMessageDialog(null,"Please Re-enter Bed Type");

                    }
				else
				{
					try{
                             conn c = new conn();
                             String s1 = c1.getSelectedItem();
                             String s2 = txt_Price.getText();
                             String s3 = txt_Bed.getText();
                             c.s.executeUpdate("update room set price = '"+s2+"'where room_number = '"+s1+"'");
                             c.s.executeUpdate("update room set bed_type = '"+s3+"'where room_number = '"+s1+"'");
                             JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                        }catch(Exception ee)
                        {
                                System.out.println(ee);
                        }
				}
			}
		});
		b.setBounds(145,290,99,23);
        b.setBackground(Color.BLACK);
       	b.setForeground(Color.WHITE);
		add(b);

		JButton b1 = new JButton("Check");
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
            	try{

                   	    conn c = new conn();
                        String id = (String) c1.getSelectedItem();
                      	String str = "select * from room where room_number  = '"+id+"'";
                        ResultSet rs = c.s.executeQuery(str);
                        while(rs.next())
                        {
                         		txt_availability.setText(rs.getString("availability"));
                                txt_clean.setText(rs.getString("clean_status"));
                                txt_Price.setText(rs.getString("price"));
                                txt_Bed.setText(rs.getString("bed_type"));

                      	}
                    }catch(Exception ee)
                    {
                    	System.out.println(ee);
					}
			}
		});
		b1.setBounds(35,290,99,23);
       	b1.setBackground(Color.BLACK);
       	b1.setForeground(Color.WHITE);
		add(b1);

		JButton b2=new JButton("Back");
		b2.setBounds(255,290,100,23);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
			}
		});
		add(b2);

      	getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
		setSize(1000,400);
		setVisible(true);
	}

}