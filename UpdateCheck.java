package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener
{
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;

    UpdateCheck()
    {
        JLabel l1=new JLabel("Check in Details");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(90,20,200,30);
        add(l1);

        JLabel l2=new JLabel("Customer-ID");
        l2.setBounds(30,80,100,25);
        add(l2);

        c1=new Choice();
        try
        {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                c1.add(rs.getString("number"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        c1.setBounds(200,80,188,30);
        add(c1);

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(30,130,100,25);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(30,180,100,25);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);

        JLabel l5=new JLabel("Check-In");
        l5.setBounds(30,230,100,25);
        add(l5);


        t3 = new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);

        JLabel l6=new JLabel("Amount Paid");
        l6.setBounds(30,280,100,25);
        add(l6);

        t4 = new JTextField();
        t4.setBounds(200,280,150,25);
        add(t4);


        JLabel l7=new JLabel("Balance Amount");
        l7.setBounds(30,330,100,25);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(200,330,150,25);
        add(t5);

        b1=new JButton("Check");
        b1.setBounds(145,400,120,25);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Update");
        b2.setBounds(60,450,120,25);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setBounds(230,450,120,25);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        add(b3);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        Image i2= i1.getImage().getScaledInstance(625,400,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel icon= new JLabel(i3);
        icon.setBounds(375,50,600,400);
        add(icon);

        setLayout(null);
        setBounds(310,200,1000,550);
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
                String id=c1.getSelectedItem();
                String room_number=null;

                int amountPaid=0;
                String price=null;
                String deposit  =null;
                String str="select * from customer where number = '"+id+"'";
                ResultSet rs1=c.s.executeQuery(str);
                while(rs1.next())
                {
                    t1.setText(rs1.getString("room_number"));
                    t2.setText(rs1.getString("name"));
                    t3.setText(rs1.getString("status"));
                    t4.setText(rs1.getString("deposit"));
                    room_number=rs1.getString("room_number");
                    deposit=rs1.getString("deposit");

                }

                String str2="select * from room where room_number = '"+room_number+"'";
                ResultSet rs2=c.s.executeQuery(str2);
                while(rs2.next())
                {
                    price=rs2.getString("price");
                    amountPaid=Integer.parseInt(price)-Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPaid));
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
                String name=t2.getText();
                String status=t3.getText();
                String deposit=t4.getText();
                //String str1="update customer set room_number = '"+room_number+", name = '"+name+"', status = '"+status+"', deposit = '"+deposit+"' where room_number = '"+room_number+"'";
                String str1="update customer set name = '"+name+"', status = '"+status+"', deposit = '"+deposit+"' where room_number = '"+room_number+"'";

                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
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
        new UpdateCheck().setVisible(true);
    }
}
