import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class deposit implements ActionListener
{
	JFrame f;
	JPanel p;
	JLabel ld,ld1,ld2,ld3;
	JTextField td1,td2,td3;
	JButton b1,b2,b3,b4,b5,b6,b7;
	deposit()
	{
		f=new JFrame("DEPOSIT");
		f.setBackground(Color.white);
		p=new ImagePanel(new ImageIcon("bankgold.jpeg").getImage());
		f.getContentPane().add(p);
		f.setVisible(true);
		f.setSize(500,500);
		p.setLayout(null);
		ld=new JLabel("DEPOSIT ");
		Font fd=new Font("Bookman Old Style",Font.BOLD,30);
		ld.setFont(fd);

		Font fd1=new Font("Lucida Handwriting",Font.BOLD,16);
		ld1=new JLabel("Account No:");
		ld1.setFont(fd1);
		td1=new JTextField(30);
		ld2=new JLabel("Current Balance:");
		ld2.setFont(fd1);
		td2=new JTextField(30);
		ld3=new JLabel("Deposit Amount:");
		ld3.setFont(fd1);
		td3=new JTextField(30);

		b1=new JButton("DEPOSIT");
		b1.setFont(fd1);
		b1.addActionListener(this);
		b2=new JButton("SAVE");
		b2.setFont(fd1);
		b2.addActionListener(this);
		b3=new JButton("SEARCH");
		b3.setFont(fd1);
		b3.addActionListener(this);
		b4=new JButton("UPDATE");
		b4.setFont(fd1);
		b4.addActionListener(this);
		b5=new JButton("DELETE");
		b5.setFont(fd1);
		b5.addActionListener(this);
		b6=new JButton("RESET");
		b6.setFont(fd1);
		b6.addActionListener(this);
		b7=new JButton("BACK TO HOME PAGE");
		b7.setFont(fd1);
		b7.addActionListener(this);

		ld.setBounds(375,100,500,30);
		ld1.setBounds(270,200,300,30);
		td1.setBounds(550,200,200,30);
		ld2.setBounds(270,270,300,30);
		td2.setBounds(550,270,200,30);
		ld3.setBounds(270,340,300,30);
		td3.setBounds(550,340,200,30);

		b1.setBounds(300,450,150,30);
		b2.setBounds(580,500,150,30);
		b3.setBounds(500,450,150,30);
		b4.setBounds(940,500,150,30);
		b5.setBounds(1120,500,150,30);
		b6.setBounds(750,580,150,30);
		b7.setBounds(325,500,300,30);

		p.add(ld);
		p.add(ld1);
		p.add(td1);
		p.add(ld2);
		p.add(td2);
		p.add(ld3);
		p.add(td3);
		p.add(b1);
	
		p.add(b3);
		p.add(b7);
		
	}
		
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			Statement s=c.createStatement();
			ResultSet rs;
			
		if(ae.getSource()==b1)//calculate
		{
			int acc=Integer.parseInt(td2.getText());
			int deposit=Integer.parseInt(td3.getText());
			int x;
			x=acc+deposit;
			td2.setText(""+x);
			td3.setText("");
			
		}

		if(ae.getSource()==b2)//insert
		{

			int r=s.executeUpdate("insert into wtable values('"+td1.getText()+"','"+td2.getText()+"')");

			if(r!=0)
			{
				JOptionPane.showMessageDialog(f,"value inserted");
			}
			td1.setText("");
			td2.setText("");
			
		}

		if(ae.getSource()==b3)//search
		{
			rs=s.executeQuery("select*from wtable where account_no='"+td1.getText()+"'");
			int count=0;
			while(rs.next())
			{
				count++;
				td2.setText(rs.getString(2));
				
			}
			if(count==0)
			{
			JOptionPane.showMessageDialog(f,"Record Not Found");
			td1.setText("");
			}
		}
		if(ae.getSource()==b4) //update
		{
			int r=s.executeUpdate("update wtable set account_no='"+td1.getText()+"',current_balance='"+td2.getText()+"' where account_no='"+td1.getText()+"'");
			if(r!=0)
			{
				 JOptionPane.showMessageDialog(f,"value updated");
			}
			td1.setText("");
			td2.setText("");
			td3.setText("");
			
		}	

		if(ae.getSource()==b5)//delete
		{
			
			int r=s.executeUpdate("delete from wtable where account_no='"+td1.getText()+"'");
			if(r!=0)
			{
				JOptionPane.showMessageDialog(f,"value deleted");
			}
			td1.setText("");
			td2.setText("");
			td3.setText("");
		
		}
			
                                    if(ae.getSource()==b6) //reset
		{
			td1.setText("");
			td2.setText("");
			td3.setText("");
			
		}
		if(ae.getSource()==b7) //close
		{
			new home();
			f.setVisible(false);
			
		}
	}
	catch(Exception e)	
	{
			JOptionPane.showMessageDialog(f,e);
	}
          }	
		
	public static void main(String ar[])
	{
		new deposit();
	}
}
	