import java.awt.*;
import javax.swing.*;


class class1
{
     public static void main(String[] rk)
     {
	 JFrame jf = new JFrame("Java Maestro");
	 jf.setVisible(true);
	
	/*Set the Property of Close Button
		
		DO_NOTHING_ON_CLOSE
		DISPOSE_ON_CLOSE
		HIDE_ON_CLOSE
		EXIT_ON_CLOSE
	*/

	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//set the size of frame
	jf.setSize(500, 650);

	//To appear the frame at the center

	jf.setLocationRelativeTo(null);

	JLabel lb = new JLabel("This is my first Frame");
	jf.add(lb, BorderLayout.NORTH);

	JButton b1 = new JButton("OK");
	jf.add(b1);

	jf.setResizable(false);
	jf.getContentPane().setBackground(Color.MAGENTA);

	//Introducing the delay of 5 seconds and changing the title

	try {	
		Thread.sleep(5000);   
	      } 
	catch(InterruptedException e){}



	jf.setTitle("Ankan Basu");
	
	ImageIcon ig = new ImageIcon("DeWatermark.ai_1744543533742.png");

	jf.setIconImage(ig.getImage());

	//Set the Background Color of Frame
	//jf.getContentPane().setBackground(new ImageIcon("back.jpg").getImage());

	


     }
}