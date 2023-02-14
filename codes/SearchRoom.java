import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.table.JTableHeader;
import java.awt.event.*;
public class SearchRoom extends JFrame implements ActionListener
{
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2,b3,b4,b5;
    JTable t1;
    JRadioButton r1,r2,r3,r4;
    ButtonGroup g1;
    DefaultTableModel d;

    SearchRoom()
    {
            JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());


        d = new DefaultTableModel(0,5){
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
  };
        t1 = new JTable(d);
        String  header[] = {"Room Number","Availability","Status","Price","Bed Type"};
        d.setColumnIdentifiers(header);
        t1.getTableHeader().setFont( new Font( "Dialog" , Font.BOLD, 12 ));
        t1.setRowHeight(30);
        t1.setBounds(10,20,300,300);
        t1.setShowGrid(true);
        t1.setGridColor(new Color(153, 0 , 0));


        JScrollPane pane = new JScrollPane(t1);
        JPanel panel=new JPanel();
        panel.add(pane);
        frame.add(panel);



        JPanel btnPnl = new JPanel(new BorderLayout());
        JPanel topBtnPnl = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(35,400,120,30);
        add(l5);

        r1=new JRadioButton("Single bed",true);
        r1.setBounds(200,280,80,25);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2=new JRadioButton("Double bed");
        r2.setBounds(290,280,80,25);
        r2.setBackground(Color.WHITE);
        add(r2);

        g1 = new ButtonGroup();
        g1.add(r1);
        g1.add(r2);

        b1 = new JButton("Only Single");
        b1.setBounds(100,460,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        bottombtnPnl.add(b1);

        b2 = new JButton("Only Double");
        b2.setBounds(250,460,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        bottombtnPnl.add(b2);

        b3 = new JButton("Single & Available");
        b3.setBounds(300,460,120,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        bottombtnPnl.add(b3);

        b4 = new JButton("Double & Available");
        b4.setBounds(450,460,120,30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        bottombtnPnl.add(b4);

        b5 = new JButton("Clear Old data");
        b5.setBounds(600,460,120,30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        bottombtnPnl.add(b5);




        btnPnl.add(topBtnPnl, BorderLayout.NORTH);
        btnPnl.add(bottombtnPnl, BorderLayout.CENTER);





        frame.add(t1.getTableHeader(), BorderLayout.NORTH);

        frame.add(btnPnl, BorderLayout.SOUTH);

        t1.getTableHeader().setReorderingAllowed(false);

        frame.setTitle("Room Details");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(400,100,700,600);
        frame.setVisible(true);



}

    //constructor
    public static void main(String[] args) {
        new SearchRoom();
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try {
                String str1="select * from room where bed_type='Single bed'";
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(str1);
                while(rs.next()){

                    String s1 = rs.getString(1);
                    String s2 = rs.getString(2);
                    String s3 = rs.getString(3);
                    String s4 = rs.getString(4);
                    String s5 = rs.getString(5);
                    d.addRow(new Object[] {s1,s2,s3,s4,s5});

                }

            } catch (Exception e) {

            }
        }
        else if(ae.getSource()==b2)
        {
            try {
                String str1="select * from room where bed_type='Double bed'";
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(str1);
                while(rs.next()){

                    String s1 = rs.getString(1);
                    String s2 = rs.getString(2);
                    String s3 = rs.getString(3);
                    String s4 = rs.getString(4);
                    String s5 = rs.getString(5);
                    d.addRow(new Object[] {s1,s2,s3,s4,s5});

                }

            } catch (Exception e) {

            }
        }
            else if(ae.getSource()==b3)
        {
            try {
                String str1="select * from room where bed_type='Single bed' AND availability='Available' ";
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(str1);
                while(rs.next()){

                    String s1 = rs.getString(1);
                    String s2 = rs.getString(2);
                    String s3 = rs.getString(3);
                    String s4 = rs.getString(4);
                    String s5 = rs.getString(5);
                    d.addRow(new Object[] {s1,s2,s3,s4,s5});

                }

            } catch (Exception e) {

            }
        }
            else if(ae.getSource()==b4)
        {
            try {
                String str1="select * from room where bed_type='Double bed' AND availability='Available'";
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(str1);
                while(rs.next()){

                    String s1 = rs.getString(1);
                    String s2 = rs.getString(2);
                    String s3 = rs.getString(3);
                    String s4 = rs.getString(4);
                    String s5 = rs.getString(5);
                    d.addRow(new Object[] {s1,s2,s3,s4,s5});

                }

            } catch (Exception e) {

            }
         }
         else if(ae.getSource()==b5)
        {
            try {
                   DefaultTableModel model = (DefaultTableModel) t1.getModel();
                        while(model.getRowCount() > 0){
                            for(int i =0; i<model.getRowCount();i++){
                                model.removeRow(i);
                            }
                        }

                 } catch (Exception e)
                 {
                System.out.println(e);
            }
         }
    }
}







