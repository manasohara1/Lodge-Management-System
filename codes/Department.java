import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.JTableHeader;
import java.sql.*;

public class Department extends JFrame implements ActionListener
{
    JTable t1;
    JButton b1,b2;
    JPanel panel;
    DefaultTableModel d;

    Department()
    {
        setLayout(new BorderLayout());
        setTitle("Departmental Budget");

        d=new DefaultTableModel(0,1);
        t1=new JTable(d);
        String label[]={"Department","Budget"};
        d.setColumnIdentifiers(label);
        t1.getTableHeader().setFont(new Font("Dialog",Font.BOLD,12));
        t1.setRowHeight(30);
        t1.setBounds(10,20,300,300);
        t1.setShowGrid(true);
        t1.setGridColor(new Color(153,0,0));


        JScrollPane pane=new JScrollPane(t1);
        panel=new JPanel();
        panel.add(pane);
        add(panel);

        JPanel btn1=new JPanel(new BorderLayout());
        JPanel topBtn = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JPanel bottombtn = new JPanel(new FlowLayout(FlowLayout.CENTER));

        b1 = new JButton("Load Data");
        b1.setBounds(100,460,120,30);  
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        bottombtn.add(b1);

        
        

        btn1.add(topBtn,BorderLayout.NORTH);
        btn1.add(bottombtn,BorderLayout.CENTER);

        add(t1.getTableHeader(), BorderLayout.NORTH);
        
        add(btn1, BorderLayout.SOUTH);

        t1.getTableHeader().setReorderingAllowed(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        //setSize(500,530);
        //setLocation(200,200);
        setBounds(800,100,500,550);
        setVisible(true);
        setResizable(false);


    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                conn c=new conn();
                String str="select * from department";

                ResultSet rs=c.s.executeQuery(str);

                while(rs.next())
                {
                    String s1=rs.getString(1);
                    String s2=rs.getString(2);
                    d.addRow(new Object[] {s1,s2});
                }
            }
            catch(Exception e){}           
        }

    }
    public static void main(String[] args) {
        new Department();
    }
}