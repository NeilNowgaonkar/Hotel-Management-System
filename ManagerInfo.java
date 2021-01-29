package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener
{
    JTable t1;
    JButton b1, b2;

    ManagerInfo()
    {
        t1 = new JTable();
        t1.setBounds(0, 40, 1050, 300);
        add(t1);

        JLabel l1=new JLabel("Name");
        l1.setBounds(50,10,80,20);
        add(l1);

        JLabel l2=new JLabel("Age");
        l2.setBounds(185,10,80,20);
        add(l2);

        JLabel l3=new JLabel("Gender");
        l3.setBounds(300,10,80,20);
        add(l3);

        JLabel l4=new JLabel("Department");
        l4.setBounds(420,10,80,20);
        add(l4);

        JLabel l5=new JLabel("Salary");
        l5.setBounds(570,10,80,20);
        add(l5);

        JLabel l6=new JLabel("Phone");
        l6.setBounds(700,10,80,20);
        add(l6);

        JLabel l7=new JLabel("Aadhar");
        l7.setBounds(820,10,80,20);
        add(l7);

        JLabel l8=new JLabel("Email");
        l8.setBounds(950,10,80,20);
        add(l8);

        b1=new JButton("Load Data");
        b1.setBounds(350,400,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBounds(530,400,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(310,165,1065,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                conn c=new conn();
                String str = "select * from employee where job = 'Manager'";
                ResultSet rs=c.s.executeQuery(str);
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

    public static void main(String[] args)
    {
        new ManagerInfo().setVisible(true);
    }
}


