import java.awt.EventQueue;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class LoginScreen {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_2;
//	private static String name;
//	private static String email;
	private static Reader reader;

	public static Reader getReader() {
		return reader;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 5, 5));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login as:");
		lblNewLabel.setBounds(0, 1, 215, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1;
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(10, 20, 54, 15);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		ButtonGroup bg = new ButtonGroup();

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Employee");
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getSource() == rdbtnNewRadioButton) {
					lblNewLabel_1.setText("Username");
				}
			}
		});
		rdbtnNewRadioButton.setBounds(0, 54, 215, 48);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton.setSelected(true);
		bg.add(rdbtnNewRadioButton);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Reader");
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getSource() == rdbtnNewRadioButton_1) {
					lblNewLabel_1.setText("Email");
				}
			}
		});
		rdbtnNewRadioButton_1.setBounds(0, 107, 215, 48);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bg.add(rdbtnNewRadioButton_1);
		panel.add(rdbtnNewRadioButton_1);

		JButton btnGoBack = new JButton("Go back");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGoBack.setBounds(10, 204, 195, 34);
		btnGoBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen.main(null);
				frame.dispose();
			}
		});
		panel.add(btnGoBack);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel_1.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(10, 55, 195, 28);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(10, 107, 54, 15);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_2);

		textField_2 = new JPasswordField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 138, 195, 28);
		panel_1.add(textField_2);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1 = textField.getText();
				String text2 = String.valueOf(textField_2.getPassword());
				reader = Reader.getReader(text1);
				if (rdbtnNewRadioButton.isSelected()) {
					if (Login.validateEmployee(text1, text2)) {
						EmployeePage.main(null);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "Invalid credentials", "Message",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					if (Login.validateReader(text1, text2)) {
						UserPage.main(null);
						frame.dispose();

					} else {
						JOptionPane.showMessageDialog(frame, "Invalid credentials", "Message",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(10, 203, 195, 34);
		panel_1.add(btnNewButton);
	}

}
