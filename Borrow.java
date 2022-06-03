package librarymanagementsystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
@SuppressWarnings("serial")
public class Borrow extends JFrame implements ActionListener{
	JButton Borrow;
	JFrame jf1;
	JLabel head,l,l1,l2,l3,l4;
	JTextField t1,t2,t3,t4,t5,t6;
	public void borrowbooks() {
		jf1 = new JFrame();
		jf1.setVisible(true);
		jf1.getContentPane().setBackground(Color.CYAN);
	    jf1.setLayout(null);
	    jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf1.setSize(2000,2000);
	    head = new JLabel("BORROW PAGE >>>>>>");
	    head.setBounds(650,2,500,100);
	    head.setForeground(Color.RED);
	    head.setFont(new Font("Consolas",Font.BOLD,30));
	    //
	    jf1.add(head);
	    //
	    l2 = new JLabel("Name:");
	    l2.setBounds(200,50,200,100);
	    jf1.add(l2);
	    //
	    t2 = new JTextField();
	    t2.setBounds(400,75,300,30);
	    jf1.add(t2);
	    //
	    l3 = new JLabel("Account No:");
	    l3.setBounds(200,100,200,100);
	    jf1.add(l3);
	    //
	    t3 = new JTextField();
	    t3.setBounds(400,130,300,30);
	    jf1.add(t3);
	    //
	    l = new JLabel("Book No:");
	    l.setBounds(200,150,200,100);
	    jf1.add(l);
	    //
	    t1 = new JTextField();
	    t1.setBounds(400,190,200,30);
	    jf1.add(t1);
	    //
	    l1 = new JLabel("Date issued:");
	    l1.setBounds(200,275,200,100);
	    jf1.add(l1);
	    //
	    t5 = new JTextField();
	    t5.setBounds(400,310,200,30);
	    jf1.add(t5);
	    //
	    Borrow = new JButton("Borrow");
	    Borrow.setBounds(600,500,200,50);
	    jf1.add(Borrow);
	    Borrow.addActionListener(this);
	    //
	    
	    
	}

	
public void actionPerformed(ActionEvent e) {
	Object obj = e.getSource();
	if(obj == Borrow) {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement","root","branch-1");
	        Statement stmt=con.createStatement();
	        PreparedStatement pstmt = con.prepareStatement("INSERT INTO borrow VALUES(?,?,?,?)");
	        String acc_no = t3.getText();
	        pstmt.setInt(1, Integer.valueOf(acc_no));
	        String user_name = t2.getText();
	        pstmt.setString(2, user_name);
	        String book_no = t1.getText();
	        pstmt.setInt(3,Integer.valueOf(book_no));
	        String date = t5.getText();
	        pstmt.setInt(4, Integer.valueOf(date));
	        PreparedStatement pstm1 = con.prepareStatement("SELECT * FROM booksinfo WHERE Book_No = ?");
	        pstm1.setInt(1, Integer.valueOf(book_no));
	        ResultSet rs = pstm1.executeQuery();
	        while(rs.next()) {
	        	String book_name = rs.getString("Book_Name");
	        	String message = book_name + " has been borrowed Successfully.!Alert that you have to return the book within 5 days";
	        	JOptionPane.showMessageDialog(jf1,message);
	        	 pstmt.executeUpdate();
	        	PreparedStatement pstmt2 = con.prepareStatement("Update booksinfo set Quantity = ? where Book_No = ?");
	 	        pstmt2.setString(2,book_no);
	 	        int qty = rs.getInt("Quantity");
	 	        pstmt2.setInt(1,qty-1);
	 	        pstmt2.executeUpdate();
	        }
	       
	        
	        
	       
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
	}
}
}


