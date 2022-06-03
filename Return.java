package librarymanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Return extends JFrame implements ActionListener {
	JButton Return;
	JFrame jf2;
	JLabel head,l,l1,l2,l3,l4;
	JTextField t1,t2,t3,t4,t5,t6;
	public void Returnbooks() {
		jf2 = new JFrame();
		jf2.setVisible(true);
		jf2.getContentPane().setBackground(Color.CYAN);
	    jf2.setLayout(null);
	    jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf2.setSize(2000,2000);
	    head = new JLabel("RETURN  PAGE >>>>>>");
	    head.setBounds(650,2,500,100);
	    head.setForeground(Color.RED);
	    head.setFont(new Font("Consolas",Font.BOLD,30));
	    //
	    jf2.add(head);
	    //
	    l2 = new JLabel("Name:");
	    l2.setBounds(200,50,200,100);
	    jf2.add(l2);
	    //
	    t2 = new JTextField();
	    t2.setBounds(400,75,300,30);
	    jf2.add(t2);
	    //
	    l3 = new JLabel("Account No:");
	    l3.setBounds(200,100,200,100);
	    jf2.add(l3);
	    //
	    t3 = new JTextField();
	    t3.setBounds(400,130,300,30);
	    jf2.add(t3);
	    //
	    l = new JLabel("Book No:");
	    l.setBounds(200,150,200,100);
	    jf2.add(l);
	    //
	    t1 = new JTextField();
	    t1.setBounds(400,190,200,30);
	    jf2.add(t1);
	    //
	    l1 = new JLabel("Date return:");
	    l1.setBounds(200,275,200,100);
	    jf2.add(l1);
	    //
	    t5 = new JTextField();
	    t5.setBounds(400,310,200,30);
	    jf2.add(t5);
	    //
	   
	    //
	    Return = new JButton("Return");
	    Return.setBounds(600,500,200,50);
	    jf2.add(Return);
	    Return.addActionListener(this);
	    //
	    
	    
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == Return) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement","root","branch-1");
		        Statement stmt=con.createStatement();
		        PreparedStatement pstmt = con.prepareStatement("INSERT INTO returninfo VALUES(?,?,?,?)");
		        String acc_no = t3.getText();
		        pstmt.setInt(1,Integer.valueOf(acc_no));
		        String name = t2.getText();
		        pstmt.setString(2, name);
		        String Book_no = t1.getText();
		        int no = Integer.valueOf(Book_no);
		        pstmt.setInt(3,Integer.valueOf(Book_no));
		        String date = t5.getText();
		        int datereturn = Integer.valueOf(date);
		        pstmt.setInt(4, Integer.valueOf(date));
		        PreparedStatement pstmt2 = con.prepareStatement("SELECT date FROM borrow WHERE acc_no = ?");
		        pstmt2.setInt(1, Integer.valueOf(acc_no));
		        ResultSet rs1 = pstmt2.executeQuery();
		        while(rs1.next()) {
		        	int dateborrow = rs1.getInt("date");
		        	int no_of_days = datereturn-dateborrow;
		        	if(no_of_days <= 5) {
		        		String Message = name+" has no fine! Book returned Successfully";
		        		JOptionPane.showMessageDialog(jf2,Message);
		        	}
		        	else {
		        		int fine = no_of_days*5;
		        		String showmes = name+" has "+ fine+ " Rs fine! Collect the fine and return the book";
		        		JOptionPane.showMessageDialog(jf2,showmes);
		        	}
		        	pstmt.executeUpdate();
		        
		        	
		        	
		        	}
		        PreparedStatement pstmt4 = con.prepareStatement("SELECT * FROM booksinfo where Book_No = ?");
		        pstmt4.setInt(1,no);
		        ResultSet r = pstmt4.executeQuery();
		        while(r.next()) {
		    	PreparedStatement pstmt3 = con.prepareStatement("Update booksinfo set Quantity = ? where Book_No = ?");
	 	        pstmt3.setString(2,Book_no);
	 	        int qty = r.getInt("Quantity");
	 	        pstmt3.setInt(1,qty+1);
	 	        pstmt3.executeUpdate();
		        }
		        
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	

}
