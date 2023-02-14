import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import javax.swing.table.*;
import javax.swing.table.JTableHeader;
import java.sql.*;

public class CustomerDis extends JFrame implements ActionListener{
    JButton b1,b2;
    JFrame f;
    JTable t1;
    JPanel p;


    DefaultTableModel d;

    CustomerDis(){



       JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());



        d = new DefaultTableModel(0,8);
        t1 = new JTable(d);
        String  header[] = {"Customer ID","Document Type","Phone Number","First Name","Last Name","Gender","Country","Allocated Room Number","Check In","Deposit"};
        d.setColumnIdentifiers(header);
        t1.getTableHeader().setFont( new Font( "Dialog" , Font.BOLD, 12 ));
        t1.setRowHeight(30);
        t1.setShowGrid(true);
        t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t1.setGridColor(new Color(153, 0 , 0));

        t1.getColumnModel().getColumn(0).setPreferredWidth(100);
        t1.getColumnModel().getColumn(1).setPreferredWidth(100);
        t1.getColumnModel().getColumn(2).setPreferredWidth(100);
        t1.getColumnModel().getColumn(3).setPreferredWidth(100);
        t1.getColumnModel().getColumn(4).setPreferredWidth(100);
        t1.getColumnModel().getColumn(5).setPreferredWidth(100);
        t1.getColumnModel().getColumn(7).setPreferredWidth(100);
        t1.getColumnModel().getColumn(8).setPreferredWidth(100);
        t1.getColumnModel().getColumn(9).setPreferredWidth(100);

        JScrollPane pane = new JScrollPane(t1);
        JPanel panel=new JPanel();
        panel.add(pane);
        frame.add(panel);



        JPanel btnPnl = new JPanel(new BorderLayout());
        JPanel topBtnPnl = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));

        t1.getTableHeader().setReorderingAllowed(false);

        b1 = new JButton("Load Data");
        b1.setBounds(100,460,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        bottombtnPnl.add(b1);



        /*b2 = new JButton("Back");
        b2.setBounds(250,460,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        bottombtnPnl.add(b2);*/


        btnPnl.add(topBtnPnl, BorderLayout.NORTH);
        btnPnl.add(bottombtnPnl, BorderLayout.CENTER);





        frame.add(t1.getTableHeader(), BorderLayout.NORTH);
        frame.add(btnPnl, BorderLayout.SOUTH);



        frame.setTitle("Customer Details");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(250,100,600,600);
        frame.setResizable(false);
        frame.setVisible(true);


}

public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            try{

                conn c = new conn();
                String str = "Select * from customer";

                ResultSet rs = c.s.executeQuery(str);

                while(rs.next()){

                    String s1 = rs.getString(1);
                    String s2 = rs.getString(2);
                    String s3 = rs.getString(3);
                    String s4 = rs.getString(4);
                    String s5 = rs.getString(5);
                    String s6 = rs.getString(6);
                    String s7 = rs.getString(7);
                    String s8 = rs.getString(8);
                    String s9 = rs.getString(9);
                    String s10 = rs.getString(10);
                    d.addRow(new Object[] {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10});

                }


            }catch(Exception e){

            }

        }else if(ae.getSource()==b2){
            //new Reception().setVisible(true);
            this.setVisible(false);
        }

    }
    public static void main(String[] args){
     new CustomerDis();
    }

}