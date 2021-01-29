package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener
{
    Main()
    {
        setBounds(140,150,1366,565);
        //setSize(400,400);
        //setLocation(300,300);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        Image i2= i1.getImage().getScaledInstance(1366,600,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel l1= new JLabel(i3);
        l1.setBounds(0,0,1366,600);
        add(l1);

        JLabel l2 = new JLabel("Welcome To Hotel Grand");
        l2.setBounds(250,435,1000,90);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.PLAIN,70));
        l1.add(l2);

        JButton b1=new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(1150,450,150,50);
        b1.addActionListener(this);
        l1.add(b1);

        setLayout(null);
        setVisible(true);

        while (true)
        {
            l2.setVisible(false);//Getting Invisible
            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            l2.setVisible(true);//Getting back the dipper
            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args)
    {
        new Main();

    }
}


