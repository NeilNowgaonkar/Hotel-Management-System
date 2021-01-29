package hotel.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Stack;

public class Pickup extends JFrame implements ActionListener
{
    Choice c1;
    JButton b1,b2;
    JTable t1;
    Pickup()
    {
        JLabel l1=new JLabel("Pickup Service");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setBounds(425,30,200,30);
        add(l1);

        JLabel l2=new JLabel("Type Of Car");
        l2.setBounds(50,100,100,25);
        add(l2);

        c1 = new Choice();
        try
        {
            conn c = new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next())
            {
                c1.add(rs.getString("brand"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        c1.setBounds(150,100,200,30);
        add(c1);

        t1=new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);

        JLabel l3=new JLabel("Name");
        l3.setBounds(50,170,100,25);
        add(l3);

        JLabel l4=new JLabel("Age");
        l4.setBounds(200,170,100,25);
        add(l4);

        JLabel l5=new JLabel("Gender");
        l5.setBounds(330,170,100,25);
        add(l5);

        JLabel l6=new JLabel("Company");
        l6.setBounds(470,170,100,25);
        add(l6);

        JLabel l7=new JLabel("Brand");
        l7.setBounds(620,170,100,25);
        add(l7);

        JLabel l8=new JLabel("Availability");
        l8.setBounds(750,170,100,25);
        add(l8);

        JLabel l9=new JLabel("Location");
        l9.setBounds(880,170,100,25);
        add(l9);

        b1=new JButton("Submit");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBounds(300,550,120,30);
        add(b1);

        b2=new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setBounds(500,550,120,30);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(325,100,1000,650);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Pickup().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                String str1="select * from driver where brand = '"+c1.getSelectedItem()+"'";
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
