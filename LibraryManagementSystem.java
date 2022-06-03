
package librarymanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class LibraryManagementSystem extends JFrame implements ActionListener {
	JLabel L,L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L18,L19,L20,L21,L22,L23,L24,L25,L26;
    JButton Display,Borrow,Return,Update;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    JFrame jfr,jfr1,jfr2;
    public LibraryManagementSystem() {
        setVisible(true);
         setSize(2000, 2000);
         setLayout(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setTitle("LIBRARY MANAGEMENT SYSTEM");
         getContentPane().setBackground(Color.CYAN);
      L = new JLabel("LIBRARY MANAGEMENT SYSTEM",JLabel.CENTER);
      L.setForeground(Color.red);
      L.setBounds(650,20,500,100);
      L.setFont(new Font("Consolas",Font.BOLD,30));
      //
      L1 = new JLabel("CHOOSE YOUR OPTION --->",JLabel.CENTER);
      L1.setBounds(700,50,500,100);
      L1.setFont(new Font("Consolas",Font.BOLD,26));
      L1.setForeground(Color.red);
      //
      L2 =new JLabel("DISPLAY ALL THE BOOKS:");
      L2.setBounds(400,200,500,100);
      L2.setFont(new Font("Consolas",Font.BOLD,20));
      L2.setForeground(Color.red);
      //
      L3 =new JLabel("BORROW A BOOK:");
      L3.setBounds(400,300,500,100);
      L3.setFont(new Font("Consolas",Font.BOLD,20));
      L3.setForeground(Color.red);
      //
      L4 = new JLabel("RETURN A BOOK:");
      L4.setBounds(400,400,500,100);
      L4.setFont(new Font("Consolas",Font.BOLD,20));
      L4.setForeground(Color.red);
      //
      Display =  new JButton("DISPLAY");
      Display.setBounds(800,215,100,50);
      //
      Borrow =  new JButton("BORROW");
      Borrow.setBounds(750,320,100,50);
      //
      Return =  new JButton("RETURN");
      Return.setBounds(700,420,100,50);
      //
 
      
      
      // ADDING ALL IN THE FRAME GUI
      add(L);
      add(L1);
      add(L2);
      add(L3);
      add(L4);

      add(Display);
      add(Borrow);

      add(Return);
      
      Display.addActionListener((ActionListener) this);
      Borrow.addActionListener((ActionListener) this);
      Return.addActionListener((ActionListener) this);
    }
   

    public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    	if(obj == Display) {
    		Display d = new Display();
    		d.DisplayBooks();
    	}
    	else if(obj == Borrow) {
    		Borrow b = new Borrow();
    		b.borrowbooks();
    	}
    	else if(obj == Return) {
    		Return r = new Return();
    		r.Returnbooks();
    	}
    }
    
	public static void main(String[] args) {
		new LibraryManagementSystem();
	}

    
}
