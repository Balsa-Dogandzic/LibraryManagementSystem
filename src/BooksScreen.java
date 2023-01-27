import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BooksScreen {

	private JFrame frame;
	private JPanel panel_1;
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnExcel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooksScreen window = new BooksScreen();
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
	public BooksScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Book catalogue");
		frame.setBounds(100, 100, 706, 408);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);

		table = new JTable();
		// Fetching data for table rows
		table.getTableHeader().setReorderingAllowed(false);
		ArrayList<Book> books = Book.getAllBooks();
		Object[][] rowData = new Object[books.size()][6];
		for (int i = 0; i < rowData.length; i++) {
			rowData[i][0] = books.get(i).getIsbn();
			rowData[i][1] = books.get(i).getName();
			rowData[i][2] = books.get(i).getCategory();
			rowData[i][3] = books.get(i).getPrice();
			rowData[i][4] = books.get(i).getAuthor();
			rowData[i][5] = books.get(i).getYear();
		}
		// Setting a table model
		table.setModel(
				new DefaultTableModel(rowData, new String[] { "isbn", "Name", "Category", "Price", "Author", "Year" }) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public boolean isCellEditable(int row, int column) {
						// Disables editing on the cells
						return false;
					}
				});
		// Disables resizing the columns
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() != -1)
					btnNewButton.setEnabled(true);
				else
					btnNewButton.setEnabled(false);
			}
		});

		panel_1.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 692, 131);
		panel_1.add(panel);
		panel.setLayout(null);

		btnNewButton_1 = new JButton("Add book");
		btnNewButton_1.setBounds(131, 69, 111, 33);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddBookScreen.main(null);
				frame.dispose();
			}
		});
		panel.add(btnNewButton_1);

		// Go back button, should add the home screen to go back to
		btnNewButton_2 = new JButton("Go back");
		btnNewButton_2.setBounds(10, 69, 111, 33);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EmployeePage.main(null);
				frame.dispose();
			}
		});
		panel.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("List of all books");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 672, 49);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Count: " + table.getRowCount(), SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(552, 10, 130, 33);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String query = textField.getText();
				filter(query);
			}
		});
		textField.setBounds(498, 83, 184, 19);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Search a book:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(498, 64, 138, 19);
		panel.add(lblNewLabel_2);

		btnNewButton = new JButton("Delete book");
		btnNewButton.setBounds(252, 69, 111, 33);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(frame, "Do you really want to return this book", "Message",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == 0 && table.getSelectedRow() != -1) {
					String isbn = table.getValueAt(table.getSelectedRow(), 0).toString();
					if (Book.delete(isbn)) {
						DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
						tableModel.removeRow(table.getSelectedRow());
						lblNewLabel_1.setText("Count: " + table.getRowCount());
						return;
					}
					JOptionPane.showMessageDialog(frame, "Deletion failed. Maybe the book is reserved.", "Message",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnNewButton);

		btnExcel = new JButton("Excel");
		btnExcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Should write to a file
				JOptionPane.showMessageDialog(frame, "Work in progress", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnExcel.setBounds(373, 69, 111, 33);
		panel.add(btnExcel);

		// Adding the table in the JScrollPane
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 133, 692, 238);

		panel_1.add(sp);
	}

	private void filter(String query) {
		// Method for table filtering
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(sorter);
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));// Case insensitive
	}
}
