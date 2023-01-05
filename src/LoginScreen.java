import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JLabel label1, label2;
	private JTextField txt1;
	private JPasswordField txt2;
	private JButton submit;
	
	public LoginScreen() {
		super("Login");
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel = new JPanel();
		this.add(panel);
		panel.setLayout(new FlowLayout());
		label1 = new JLabel("Enter your username:");
		panel.add(label1);
		txt1 = new JTextField("",20);
		panel.add(txt1);
		label2 = new JLabel("Enter your password:");
		panel.add(label2);
		txt2 = new JPasswordField("",20);
		panel.add(txt2);
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = txt1.getText();
				String password = String.valueOf(txt2.getPassword());
				Login l = new Login();
				if(l.validate(username, password)) {
					JOptionPane.showMessageDialog(null, "Successful login","Message",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid credentials","Message",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		panel.add(submit);
	}
	
	public void initialize() {
		this.setVisible(true);
	}

}
