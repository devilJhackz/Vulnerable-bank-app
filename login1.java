import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class login1 extends JFrame implements ActionListener
{
	JLabel l1,l2,l;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	JPanel p;
	login1()
	{
		p=new ImagePanel(new ImageIcon("bank.jpg").getImage());
		getContentPane().add(p);
		setVisible(true);
		setSize(600,600);
		setTitle("BANK APPLICATION");
		p.setLayout(null);

		l=new JLabel("USER LOGIN");
		l1=new JLabel("User Id");
		l2=new JLabel("Password");
		t1=new JTextField(30);
		t2=new JPasswordField(30);
		b1=new JButton("Login");
		b2=new JButton("Cancel");
		Font f1=new Font("ARIALBLACK",Font.ITALIC,22);
		Font f2=new Font("ARIAL",Font.BOLD,18);
		l.setFont(f1);
		l1.setFont(f2);
		l2.setFont(f2);

		l.setBounds(970,120,150,30);
		l1.setBounds(950,200,95,30);
		t1.setBounds(1050,200,115,35);
		l2.setBounds(950,260,95,30);
		t2.setBounds(1050,260,115,35);
		b1.setBounds(950,320,75,30);
		b2.setBounds(1060,320,75,30);

		b1.addActionListener(this);
		b2.addActionListener(this);

		p.add(l);
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(b1);
		p.add(b2);
	}public void actionPerformed(ActionEvent x)
	{
		try
		{
		if(x.getSource()==b1) 
		{
		Class.forName ("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/login1","root","root");
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery("select * from cred");	
		int success=0;
		while(rs.next())
		{
			if( (t1.getText()).equals(rs.getString(1) )&&(t2.getText()).equals(rs.getString(2) ))
			{
			JOptionPane.showMessageDialog(this,new String("Login Succsfull "+rs.getString(1) ) );
				this.setVisible(false);
				new home();
				success++;
			}
		}
		if(success==0)
		{
			JOptionPane.showMessageDialog(this,new String("Invalid User"));
			t1.setText("");
			t2.setText("");
		}	
		}
		if(x.getSource()==b2)
		{
			System.exit(0);
		}
		}
		catch(Exception e){System.out.println(e);}
	}

	public static void main(String arg[])
	{
		new login1();
	}
}