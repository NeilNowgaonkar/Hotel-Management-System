package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Stack;

public class SearchRoom extends JFrame implements ActionListener
{
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    SearchRoom()
    {
        JLabel l1=new JLabel("Search for Room");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setBounds(425,30,200,30);
        add(l1);

        JLabel l2=new JLabel("Room Bed Type");
        l2.setBounds(50,100,100,25);
        add(l2);

        String str[]={"Single Bed","Double Bed"};
        c1=new JComboBox(str);
        c1.setBounds(175,100,150,25);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Only Display Available");
        c2.setBounds(650,100,150,25);
        c2.setBackground(Color.WHITE);
        add(c2);

        t1=new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(50,170,100,25);
        add(l3);

        JLabel l4=new JLabel("Availability");
        l4.setBounds(270,170,100,25);
        add(l4);

        JLabel l5=new JLabel("Cleaning Status");
        l5.setBounds(460,170,100,25);
        add(l5);

        JLabel l6=new JLabel("Price");
        l6.setBounds(680,170,100,25);
        add(l6);

        JLabel l7=new JLabel("Bed Type");
        l7.setBounds(860,170,100,25);
        add(l7);



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
        new SearchRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                String str1="select * from room where bed_type = '"+c1.getSelectedItem()+"'";
                String str2="select * from room where available = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str1);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

                if(c2.isSelected())
                {
                    ResultSet rs2= c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs2));
                }
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
