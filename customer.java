import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class customer  implements ActionListener
{
	JFrame f;
	JPanel p;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JTextArea t9;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JComboBox cb;
	JRadioButton rb1,rb2;
	ButtonGroup bg;
	ButtonModel m1,m2;

	customer()
	{
		f=new JFrame("CUSTOMER DETAILS");
		p=new ImagePanel(new ImageIcon("dollar.jpg").getImage());
		f.getContentPane().add(p);
		f.setVisible(true);
		f.setSize(600,600);
		p.setLayout(null);
		Font f1=new Font("Bookman Old Style",Font.BOLD,22);
		l1=new JLabel("CUSTOMER DETAIL");
		l1.setFont(f1);
		Font fd=new Font("Lucida Handwriting",Font.BOLD,18);
		l2=new JLabel("Aadhar :");
		l2.setFont(fd);
		t1=new JTextField(30);
		l3=new JLabel("Acc No:");
		l3.setFont(fd);
		t2=new JTextField(30);
		l4=new JLabel("Name:");
		l4.setFont(fd);
		t3=new JTextField(30);
		l5=new JLabel("Gender:");
		l5.setFont(fd);
		bg=new ButtonGroup();
		rb1=new JRadioButton("male",true);
		rb1.setActionCommand("male");
		m1=rb1.getModel();
		rb2=new JRadioButton("female");
		rb2.setActionCommand("female");
		m2=rb2.getModel();
		bg.add(rb1);
		bg.add(rb2);
		
		
			
		l6=new JLabel("State:");
		l6.setFont(fd);
		cb=new JComboBox();
		cb.addItem("TamilNadu");
		cb.addItem("Puducherry");
		cb.addItem("Kerala");


		l7=new JLabel("D.O.B");
		l7.setFont(fd);
		t4=new JTextField(30);
		l8=new JLabel("Age:");
		l8.setFont(fd);
		t5=new JTextField(30);
		l9=new JLabel("Phone:");
		l9.setFont(fd);
		t6=new JTextField(30);
		l10=new JLabel("Email :");
		l10.setFont(fd);
		t7=new JTextField(30);
		l11=new JLabel("Balance:");
		l11.setFont(fd);
		t8=new JTextField(30);
		l12=new JLabel("Address:");
		l12.setFont(fd);
		t9=new JTextArea(30,20);
		
		b2=new JButton("SAVE");
		b2.addActionListener(this);
		b3=new JButton("SEARCH");
		b3.addActionListener(this);
		b4=new JButton("UPDATE");
		b4.addActionListener(this);
		b5=new JButton("DELETE");
		b5.addActionListener(this);
		b6=new JButton("RESET");
		b6.addActionListener(this);
		b7=new JButton("BACK");
		b7.addActionListener(this);
		
		l1.setBounds(550,100,500,30);
		l2.setBounds(300,200,100,30);
		t1.setBounds(410,200,100,30);
		l3.setBounds(300,260,100,30);
		t2.setBounds(410,260,100,30);
		l4.setBounds(300,320,100,30);
		t3.setBounds(410,320,100,30);
		l5.setBounds(300,380,100,30);
		rb1.setBounds(410,380,100,30);
		rb2.setBounds(520,380,100,30);
		l6.setBounds(300,440,100,30);
		cb.setBounds(410,440,100,30);
		l7.setBounds(300,500,100,30);
		t4.setBounds(410,500,100,30);
		l8.setBounds(800,200,100,30);
		t5.setBounds(910,200,100,30);
		l9.setBounds(800,260,100,30);
		t6.setBounds(910,260,100,30);
		l10.setBounds(800,320,100,30);
		t7.setBounds(910,320,100,30);
		l11.setBounds(800,380,100,30);
		t8.setBounds(910,380,100,30);
		l12.setBounds(800,440,100,30);
		t9.setBounds(910,440,100,30);
		
		b2.setBounds(300,600,100,30);
		b3.setBounds(410,600,100,30);
		b4.setBounds(520,600,100,30);
		b5.setBounds(630,600,100,30);
		b6.setBounds(740,600,100,30);
		b7.setBounds(850,600,100,30);

		p.add(l1);
		p.add(l2);
		p.add(t1);
		p.add(l3);
		p.add(t2);
		p.add(l4);
		p.add(t3);
		p.add(l5);
		p.add(l6);
		p.add(cb);
		p.add(l7);
		p.add(t4);
		p.add(rb1);
		p.add(rb2);
		p.add(l8);
		p.add(t5);
		p.add(l9);
		p.add(t6);
		p.add(l10);
		p.add(t7);
		p.add(l11);
		p.add(t8);
		p.add(l12);
		p.add(t9);
		
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
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
			
		if(ae.getSource()==b2)//insert
		{
			String gender=bg.getSelection().getActionCommand();
			int r=s.executeUpdate("insert into ctable values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+gender+"','"+cb.getSelectedItem()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"','"+t9.getText()+"')");

			if(r!=0)
			{
				JOptionPane.showMessageDialog(f,"value inserted");
			}
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			cb.setSelectedIndex(0);
			bg.setSelected(m1,true);
		}
	if(ae.getSource()==b3)//search
		{
			rs=s.executeQuery("select*from ctable where aadar_no='"+t1.getText()+"'");
			int count=0;
			while(rs.next())
			{
				count++;
				t2.setText(rs.getString(2));
				t3.setText(rs.getString(3));

				String g=rs.getString(4);

				if(g.equals("male"))
				{
					bg.setSelected(m1,true);
				}
				else
				{
					bg.setSelected(m2,true);
				}
				cb.setSelectedItem(rs.getString(5));
				
				t4.setText(rs.getString(6));
				t5.setText(rs.getString(7));
				t6.setText(rs.getString(8));
				t7.setText(rs.getString(9));
				t8.setText(rs.getString(10));
				t9.setText(rs.getString(11));
			}
			if(count==0)
			{
			JOptionPane.showMessageDialog(f,"Record Not Found");
			t1.setText("");
			}
		}

		if(ae.getSource()==b4) //update
		{
			String gender=bg.getSelection().getActionCommand();
			int r=s.executeUpdate("update ctable set aadar_no='"+t1.getText()+"',account_no='"+t2.getText()+"',name='"+t3.getText()+"', gender='"+gender+"', state='"+cb.getSelectedItem()+"', dob='"+t4.getText()+"', age='"+t5.getText()+"',phone_no='"+t6.getText()+"', email='"+t7.getText()+"', balance_amount='"+t8.getText()+"',address='"+t9.getText()+"' where aadar_no='"+t1.getText()+"'");
			if(r!=0)
			{
				 JOptionPane.showMessageDialog(f,"value updated");
			}
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			cb.setSelectedIndex(0);
			bg.setSelected(m1,true);
		}	

				
		if(ae.getSource()==b5)//delete
		{
			String gender=bg.getSelection().getActionCommand();
			int r=s.executeUpdate("delete from ctable where aadar_no='"+t1.getText()+"'");
			if(r!=0)
			{
				JOptionPane.showMessageDialog(f,"value deleted");
			}
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			cb.setSelectedIndex(0);
			bg.setSelected(m1,true);
		}
			
		if(ae.getSource()==b6) //reset
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			cb.setSelectedIndex(0);
			bg.setSelected(m1,true);
		}
		if(ae.getSource()==b7) //back
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
			new customer();
		}
}
		


		