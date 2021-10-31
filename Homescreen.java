import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Paint implements ActionListener
{
	JFrame f;
	JButton b1,b2,b3,b4;
	Paint()
	{
		f=new JFrame("Homescreen");
		f.setSize(400,400);
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		b1=new JButton("Add Item");
		b2=new JButton("view Item");
		b3=new JButton("sales");
		b4=new JButton("view");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.setVisible(true);
	}
	
		
public static void main(String ar[])
{
	new Paint();
}
}