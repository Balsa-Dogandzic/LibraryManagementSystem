import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignIn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignIn() {
		super("Sign in");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 373);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(9, 0, 0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

		JLabel lblNewLabel = new JLabel("Please insert your name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 12));

		textField = new JTextField();
		textField.setMinimumSize(new Dimension(21, 19));
		textField.setPreferredSize(new Dimension(93, 19));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(textField);
		textField.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 12));

		JLabel lblNewLabel_1 = new JLabel("Insert your email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel_4.add(lblNewLabel_1);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 12));

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setVgap(12);
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_9);

		JLabel lblNewLabel_3 = new JLabel("Insert your password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel_9.add(lblNewLabel_3);

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setVgap(12);
		flowLayout_1.setHgap(20);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_8);

		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(103, 19));
		passwordField.setSize(new Dimension(56, 45));
		panel_8.add(passwordField);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 12));

		JLabel lblNewLabel_2 = new JLabel("Insert your phone number:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel_6.add(lblNewLabel_2);

		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 12));

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_7.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setBounds(20, 10, 75, 26);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String email = textField_1.getText();
				String phone_number = textField_2.getText();
				String password = String.valueOf(passwordField.getPassword());
				ArrayList<String> errors = Login.addReader(name, email, password, phone_number);
				if (errors == null) {
					JOptionPane.showMessageDialog(contentPane, "Successful Sign-in", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					LoginScreen.main(null);
					dispose();
				} else {
					String s = "";
					for (String error : errors) {
						s += String.format("- %s\n", error);
					}
					JOptionPane.showMessageDialog(contentPane, s, "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1.setLayout(null);
		btnNewButton.setPreferredSize(new Dimension(75, 26));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(btnNewButton);

		JButton btnGoBack = new JButton("Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen.main(null);
				dispose();
			}
		});
		btnGoBack.setPreferredSize(new Dimension(75, 26));
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGoBack.setBounds(393, 10, 75, 26);
		panel_1.add(btnGoBack);
	}

	public void initialize() {
		this.setVisible(true);
	}
}
