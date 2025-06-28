import java.awt.*;
import javax.swing.*;

public class Project1LoginPage
{
    static public void main(String[] arg)
    {
	JFrame f = new JFrame("LogIn");
	f.setSize(700, 800);
	f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	f.setLocationRelativeTo(null);
	f.getContentPane().setBackground(Color.MAGENTA);
	f.setLayout(null);		//Setting the Layout to null	

	Font font1 = new Font(Font.SERIF, 1, 24);

	JTextField tf = new JTextField("User Name");
	f.add(tf);		
	tf.setFont(font1);		//Changing the Font of TextField
	tf.setBounds(200, 200, 300, 50);

	JPasswordField pf = new JPasswordField();
	f.add(pf);		
	pf.setEchoChar('*');
	pf.setFont(font1);		//Changing the Font of TextField
	pf.setBounds(200, 280, 300, 50);

	JButton submit = new JButton("Sign In");
	f.add(submit);
	submit.setFont(font1);
	submit.setBounds(240, 360, 220, 50);

	//	Registering the ActionListener

	submit.addActionListener( //ActionListener Object
		(x) -> {
				JOptionPane.showInputDialog(f, "Navigating to Home Page");
			   }
						);

	JButton reset = new JButton("Reset");
	f.add(reset);
	reset.setFont(font1);
	reset.setBounds(240, 440, 220, 50);
	reset.addActionListener(
		(ac) -> { tf.setText(null); 	pf.setText(null); }
		);


	JLabel logo = new JLabel(new ImageIcon("logo.jpg"));
	f.add(logo);
	logo.setBounds(300, 50, 100, 100);


	JLabel back = new JLabel(new ImageIcon("conclave.jpg"));
//	f.add(back);
//	back.setBounds(0, 0, 700, 800);

	f.setVisible(true);
    }
}