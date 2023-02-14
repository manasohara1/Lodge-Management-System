import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class CheckOut extends JFrame implements ActionListener
{
    Choice c1;
    JButton b1,b2,b3;
    JTextField t1;
    CheckOut()
    {
        JLabel l1=new JLabel("Check Out");
        l1.setBounds(30,20,100,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Ink Free",Font.PLAIN,20));
        add(l1);

        JLabel l2=new JLabel("Customer ID");
        l2.setBounds(30,80,100,30);
        add(l2);

        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer where room_number in(select room_number from room where price=deposit)");
            while(rs.next())
            {
                c1.addItem(rs.getString("cid"));
            }
        }catch(Exception e)
        {}
        c1.setBounds(150,80,150,30);
        add(c1);

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);

        t1=new JTextField(20);
        t1.setBounds(150,130,150,30);
        add(t1);

        b1=new JButton("CheckOut");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,180,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(170,180,120,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JButton b3 = new JButton(i6);
        b3.setBounds(310,80,25,30);
        b3.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent ae){

                try{

                    conn c = new conn();
                    String number = c1.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select * from customer where cid = '"+number+"'");

                    if(rs.next()){
                        t1.setText(rs.getString("room_number"));
                    }
                }catch(Exception e){}
            }
        });

        add(b3);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel lb1 = new JLabel(i2);
        lb1.setBounds(350,0,400,250);
        add(lb1);

        setLayout(null);
        setSize(800,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String id=c1.getSelectedItem();
            String r1=t1.getText();
            String s1="delete from customer where cid="+id;
            String s2="update room set availability='Available' where room_number="+r1;
            try{
                conn c=new conn();
                c.s.executeUpdate(s1);
                c.s.executeUpdate(s2);
                JOptionPane.showMessageDialog(null,"CheckOut Done");
                this.setVisible(false);
            }
            catch(Exception e){}
        }

        else if(ae.getSource()==b2)
        {
            //new Reception().setVisible(true);
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new CheckOut();
    }
}
