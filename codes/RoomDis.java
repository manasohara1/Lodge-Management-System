import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.JTableHeader;
import java.sql.*;

public class RoomDis extends JFrame implements ActionListener{
    JButton b1,b2;
    JFrame f;
    JTable t1;
    JPanel p;
    DefaultTableModel d;

    RoomDis(){

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

        t1.getTableHeader().setReorderingAllowed(false);

        frame.setTitle("Room Details");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(400,100,500,600);
        frame.setVisible(true);
}

public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            try{

                conn c = new conn();
                String str = "Select * from room";

                ResultSet rs = c.s.executeQuery(str);

                while(rs.next()){

                    String s1 = rs.getString(1);
                    String s2 = rs.getString(2);
                    String s3 = rs.getString(3);
                    String s4 = rs.getString(4);
                    String s5 = rs.getString(5);
                    d.addRow(new Object[] {s1,s2,s3,s4,s5});

                }


            }catch(Exception e){

            }

        }/*else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }*/

    }
    public static void main(String[] args){
     new RoomDis();
    }

}