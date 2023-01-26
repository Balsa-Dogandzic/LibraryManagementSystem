import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;

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

	private JTable createTable() {
		String[] colName = { "reader", "phone", "email", "isbn", "name", "issue_date", "return_date" };
		if (table == null) {
			table = new JTable() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				// Disables cell editing
				public boolean isCellEditable(int nRow, int nCol) {
					return false;
				}
			};
		}

		DefaultTableModel contactTableModel = (DefaultTableModel) table.getModel();
		contactTableModel.setColumnIdentifiers(colName);

		// Disables resizing the columns
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);

		// Allows selection of only one row
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);

		return table;
	}

	private void insertTableData() {
		// Should fill the data in the table, see BookCatalogue class for the same
		// method
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		try {
			Connection conn = JDBCConnection.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT reader.name, reader.phone_number, reader.email, book.isbn, book.name, reservation.date_of_reservation, reservation.return_date FROM reader JOIN reservation ON reservation.reader_id = reader.id JOIN book ON reservation.book_id = book.isbn ORDER BY reservation.return_date;");
			while (rs.next()) {
				Object[] data = new Object[7];
				data[0] = rs.getString(1);
				data[1] = rs.getString(2);
				data[2] = rs.getString(3);
				data[3] = rs.getString(4);
				data[4] = rs.getString(5);
				data[5] = rs.getString(6);
				data[6] = rs.getString(7);
				tableModel.addRow(data);
			}
			table.setModel(tableModel);

		} catch (Exception e) {
			System.out.println("Greska sa bazom.");
		}

	}

	/**
	 * Create the frame.
	 */
	public EmployeePage() {
		super("Employee screen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 690, 484);
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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 11, 490, 30);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("all books");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BooksScreen.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(20, 52, 120, 30);
		panel.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("request");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Work in progress", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_2.setBounds(536, 52, 120, 30);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("reservation");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddReservationScreen.main(null);
				dispose();
			}
		});
		btnNewButton_3.setBounds(20, 107, 120, 30);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("return a book");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(contentPane, "Do you really want to return this book", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (table.getSelectedRow() != -1 && option == 0) {
					String isbn = table.getValueAt(table.getSelectedRow(), 3).toString();
					if(Reservation.deleteReservation(isbn)) {
						DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
						tableModel.removeRow(table.getSelectedRow());
						return;
					}
					JOptionPane.showMessageDialog(contentPane, "Something went wrong", "Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_4.setBounds(283, 51, 120, 30);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("log out");
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen.main(null);
				dispose();
			}
		});
		btnNewButton_5.setBounds(536, 107, 120, 30);
		panel.add(btnNewButton_5);

		table = createTable();
		insertTableData();

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 170, 666, 265);
		panel.add(scrollPane);

		JButton btnNewButton_3_1 = new JButton("new employee");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignInEmployee.main(null);
				dispose();
			}
		});
		btnNewButton_3_1.setBounds(283, 107, 120, 30);
		panel.add(btnNewButton_3_1);

	}
}
