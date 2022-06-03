package librarymanagementsystem;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Display {
	public void DisplayBooks() {
	String cols[] = {"Book No","Book Name","Quantity","Shelf_No"};
        JTable jt= new JTable();
        jt.setFont(new Font("Arial",Font.PLAIN,10));
        DefaultTableModel model = new DefaultTableModel();
        jt.setModel(model);
        model.setColumnIdentifiers(cols);
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(2000,2000);
        jf.setTitle("RECORDS");
        jf.setBackground(Color.cyan);
        JLabel L6 = new JLabel("DISPLAYING ALL THE BOOKS");
        L6.setBounds(650,20,500,100);
        L6.setForeground(Color.red);
        L6.setFont(new Font("Consolas",Font.BOLD,18));
        jf.add(L6);
	 try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement","root","branch-1");
         Statement stmt=con.createStatement();
         ResultSet rs1 =stmt.executeQuery("SELECT * FROM booksinfo");
         while(rs1.next()) {
             String Book_No = Integer.toString(rs1.getInt("Book_No"));
             String Book_Name = rs1.getString("Book_Name");
             String Quantity= Integer.toString(rs1.getInt("Quantity"));
             String Shelf_No = rs1.getString("shelf_no");   
             model.addRow(new Object[]{Book_No,Book_Name,Quantity,Shelf_No});
         }
	 }
	 catch(Exception ex) {
		 Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
	 }
	 jt.setBounds(200,100, 1000, 1000);
     JScrollPane sp = new JScrollPane(jt);
     sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
     jf.add(sp);
     jf.add(jt);

}
}
