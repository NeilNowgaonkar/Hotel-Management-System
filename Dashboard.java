package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener
{
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;

    Dashboard()
    {
        mb = new JMenuBar();
        add(mb);

        m1=new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.RED);
        mb.add(m1);

        m2=new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        mb.add(m2);

        i1=new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);

        i2=new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);

        i3=new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);

        i4=new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);

        mb.setBounds(0,0,1950,30);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image i2= i1.getImage().getScaledInstance(1600,800,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel l1= new JLabel(i3);
        l1.setBounds(0,0,1600,800);
        add(l1);

        JLabel l2=new JLabel("HOTEL GRAND WELCOMES YOU");
        l2.setBounds(500,80,600,50);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,40));
        l1.add(l2);

        setLayout(null);
        setBounds(0,0,1950,1020);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Dashboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("RECEPTION"))
        {
            new Reception().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmloyee().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD ROOMS"))
        {
            new AddRooms().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS"))
        {
            new AddDriver().setVisible(true);
        }
    }
}
