import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;

public class AddBookScreen {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookScreen window = new AddBookScreen();
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
	public AddBookScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add a new book");
		frame.setBounds(100, 100, 408, 458);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Add a new book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Enter the isbn:");
		lblNewLabel_1.setSize(new Dimension(100, 13));
		lblNewLabel_1.setMaximumSize(new Dimension(100, 13));
		lblNewLabel_1.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 10, 220, 13);
		panel_1.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(10, 33, 220, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Enter the title:");
		lblNewLabel_2.setSize(new Dimension(100, 13));
		lblNewLabel_2.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_2.setMaximumSize(new Dimension(100, 13));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 62, 220, 13);
		panel_1.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 85, 220, 20);
		panel_1.add(textField_1);

		JLabel lblNewLabel_3 = new JLabel("Enter the category:");
		lblNewLabel_3.setSize(new Dimension(100, 13));
		lblNewLabel_3.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_3.setMaximumSize(new Dimension(100, 13));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 114, 220, 20);
		panel_1.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 137, 220, 20);
		panel_1.add(textField_2);

		JLabel lblNewLabel_4 = new JLabel("Enter the price:");
		lblNewLabel_4.setSize(new Dimension(100, 13));
		lblNewLabel_4.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_4.setMaximumSize(new Dimension(100, 13));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 166, 220, 20);
		panel_1.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 196, 160, 20);
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Allows user to enter one dot and digits only
				String character = Character.toString(e.getKeyChar());
				if (character.equals(".") && !(textField_3.getText().contains(".")))
					return;
				if (!(Character.isDigit(e.getKeyChar())))
					e.consume();
			}
		});
		panel_1.add(textField_3);

		JLabel lblNewLabel_5 = new JLabel("Choose the author:");
		lblNewLabel_5.setSize(new Dimension(100, 13));
		lblNewLabel_5.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_5.setMaximumSize(new Dimension(100, 13));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 226, 220, 20);
		panel_1.add(lblNewLabel_5);

		ArrayList<Author> authors = Author.getAuthors();
		Author[] array = new Author[authors.size()];
		authors.toArray(array);
		JComboBox<Author> comboBox = new JComboBox<Author>(array);

		comboBox.setBounds(10, 256, 220, 21);
		panel_1.add(comboBox);

		JLabel lblNewLabel_6 = new JLabel("Enter the year of publication:");
		lblNewLabel_6.setSize(new Dimension(100, 13));
		lblNewLabel_6.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_6.setMaximumSize(new Dimension(100, 13));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 287, 220, 20);
		panel_1.add(lblNewLabel_6);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 317, 160, 20);
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Allows user to enter only four digits
				if (!(Character.isDigit(e.getKeyChar())) || textField_4.getText().length() >= 4)
					e.consume();
			}
		});
		panel_1.add(textField_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 347, 374, 37);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 3, 5, 5));

		JButton btnNewButton_2 = new JButton("Go back");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BooksScreen.main(null);
				frame.dispose();
			}
		});
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Add book");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String isbn = textField.getText();
				String name = textField_1.getText();
				String category = textField_2.getText();
				double price = Double.parseDouble(textField_3.getText());
				Author a = (Author) comboBox.getSelectedItem();
				// Takes a author id
				int author_id = a.getId();
				int year = Integer.parseInt(textField_4.getText());

				if (Book.addBook(isbn, name, category, price, author_id, year)) {
					JOptionPane.showMessageDialog(null, "Book successfully added", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					BooksScreen.main(null);
					frame.dispose();
					return;
				}
				JOptionPane.showMessageDialog(null, "Something went wrong", "Message", JOptionPane.ERROR_MESSAGE);
			}
		});
		panel_2.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Add an author");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddAuthorScreen.main(null);
				frame.dispose();
			}
		});
		panel_2.add(btnNewButton);
	}
}
