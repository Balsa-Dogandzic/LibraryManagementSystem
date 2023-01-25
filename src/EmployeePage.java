import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EmployeePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePage frame = new EmployeePage();
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
	public EmployeePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 484);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Bookstore");
		lblNewLabel.setBounds(221, 10, 85, 13);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("all books");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BooksScreen.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(20, 61, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("add book");
		btnNewButton_1.setBounds(168, 61, 85, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("request");
		btnNewButton_2.setBounds(317, 61, 85, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("reserve a book");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddReservationScreen.main(null);
				dispose();
			}
		});
		btnNewButton_3.setBounds(88, 128, 85, 21);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("return a book");
		btnNewButton_4.setBounds(250, 128, 85, 21);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("log out");
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginScreen.main(null);
				dispose();
			}
		});
		btnNewButton_5.setBounds(425, 128, 85, 21);
		panel.add(btnNewButton_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 184, 490, 219);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBounds(20, 184, 488, 216);
		panel.add(table);
		table.setPreferredSize(new Dimension(200, 216));
	}
}
