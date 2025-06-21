import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class LoginPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Page");
        frame.setSize(700, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.MAGENTA);
        frame.setLayout(null); 

        Font font1 = new Font(Font.SERIF, Font.BOLD, 24);

        // Username Field
        JTextField tf = new JTextField("Username");
        tf.setFont(font1);
        tf.setBounds(200, 250, 300, 50);
        frame.add(tf);

        // Password Field
        JPasswordField pf = new JPasswordField("Password");
        pf.setFont(font1);
        pf.setBounds(200, 330, 300, 50);
        pf.setEchoChar((char) 0); // Visible for placeholder; will fix this later
        frame.add(pf);

        // Sign In Button
        JButton submit = new JButton("Sign In");
        submit.setFont(font1);
        submit.setBounds(200, 410, 300, 50);
        frame.add(submit);

        // Reset Button
        JButton reset = new JButton("Reset");
        reset.setFont(font1);
        reset.setBounds(200, 480, 300, 50);
        frame.add(reset);

        frame.setVisible(true);
    }
}
