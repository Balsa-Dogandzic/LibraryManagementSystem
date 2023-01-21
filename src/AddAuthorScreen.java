import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AddAuthorScreen {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAuthorScreen window = new AddAuthorScreen();
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
	public AddAuthorScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add a new author");
		frame.setBounds(100, 100, 450, 270);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add new author");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(25, 10, 389, 29);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(25, 104, 389, 27);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Enter the authors name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(25, 74, 158, 20);
		panel.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Add the author");
		btnNewButton.setBounds(291, 188, 123, 35);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserts the author and asks the user if he wants to enter more authors
				String name = textField.getText();
				if (Author.addAuthor(name)) {
					int option = JOptionPane.showConfirmDialog(null,
							"Author successfully added. Do you want to add the book now?", "Message",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option == 0) {
						AddBookScreen.main(null);
						frame.dispose();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Invalid data format", "Message", JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		panel.add(btnNewButton);

		JButton btnGoBack = new JButton("Go back");
		btnGoBack.setBounds(25, 188, 123, 35);
		btnGoBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Goes back to add book screen
				AddBookScreen.main(null);
				frame.dispose();
			}
		});
		panel.add(btnGoBack);
	}
}
