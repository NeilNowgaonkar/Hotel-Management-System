package hotel.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Stack;

public class Department extends JFrame implements ActionListener
{
    JButton b1,b2;
    JTable t1;
    Department()
    {

        t1=new JTable();
        t1.setBounds(0,50,700,350);
        add(t1);

        JLabel l3=new JLabel("Department");
        l3.setBounds(150,10,100,25);
        add(l3);

        JLabel l4=new JLabel("Budget");
        l4.setBounds(480,10,100,25);
        add(l4);

        b1=new JButton("Load");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBounds(180,400,120,30);
        add(b1);

        b2=new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setBounds(380,400,120,30);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(450,180,700,500);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Department().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                String str1="select * from department";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str1);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }
}

