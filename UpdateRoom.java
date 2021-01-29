package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener
{
    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;

    UpdateRoom()
    {
        JLabel l1=new JLabel("Update Room Status");
        l1.setFont(new Font("Tahoma",Font.PLAIN,26));
        l1.setForeground(Color.BLUE);
        l1.setBounds(30,20,250,25);
        add(l1);

        JLabel l2=new JLabel("Guest ID");
        l2.setBounds(30,80,120,25);
        add(l2);

        c1=new Choice();
        try
        {
            conn c=new conn();
            String s = "select * from customer";
            ResultSet rs=c.s.executeQuery(s);
            while (rs.next())
            {
                c1.add(rs.getString("number"));
            }
        }
        catch (Exception e)
        {

        }

        c1.setBounds(200,80,185,35);
        add(c1);

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(30,130,120,25);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);

        JLabel l4=new JLabel("Availability");
        l4.setBounds(30,180,120,25);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);

        JLabel l5=new JLabel("Cleaning Status");
        l5.setBounds(30,230,120,25);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);

        b1=new JButton("Check");
        b1.setBounds(145,300,120,25);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Update");
        b2.setBounds(60,350,120,25);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setBounds(230,350,120,25);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2= i1.getImage().getScaledInstance(625,400,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel icon= new JLabel(i3);
        icon.setBounds(375,50,600,400);
        add(icon);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(310,200,1000,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String s1=c1.getSelectedItem();
            String room=null;

            conn c=new conn();
            try
            {
                ResultSet rs1=c.s.executeQuery("select * from customer where number = '"+s1+"'");
                while(rs1.next())
                {
                    t1.setText(rs1.getString("room_number"));
                    room=rs1.getString("room_number");
                }

                ResultSet rs2=c.s.executeQuery("select * from room where room_number = '"+room+"'");
                while(rs2.next())
                {
                    t2.setText(rs2.getString("available"));
                    t3.setText(rs2.getString("status"));
                }

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2)
        {
            try
            {
                conn c=new conn();
                String room_number=t1.getText();
                String available=t2.getText();
                String status=t3.getText();

                String str1="update room set available = '"+available+"', status = '"+status+"' where room_number = '"+room_number+"'";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Room Updated Successfully");
                new Reception().setVisible(true);
                this.setVisible(false);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b3)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new UpdateRoom().setVisible(true);
    }
}


