import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookCatalogue {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookCatalogue window = new BookCatalogue();
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
	public BookCatalogue() {
		initialize();
	}

	private JTable createTable() {
		String[] colName = { "isbn", "name", "category", "price", "author", "year" };
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
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);

		// Allows selection of only one row
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);

		return table;
	}

	// Inserts the rows in the table from the database
	private void insertTableData() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		ArrayList<Book> books = Book.getAllBooks();

		for (Book b : books) {
			Object[] data = new Object[6];
			data[0] = b.getIsbn();
			data[1] = b.getName();
			data[2] = b.getCategory();
			data[3] = b.getPrice();
			data[4] = b.getAuthor();
			data[5] = b.getYear();
			tableModel.addRow(data);
		}
		table.setModel(tableModel);
	}

	private void filter(String query) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(sorter);
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Book catalogue");
		frame.setBounds(100, 100, 531, 347);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		table = createTable();
		insertTableData();
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 96, 517, 214);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 517, 92);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Look for yourself!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 497, 28);
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(10, 63, 175, 19);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String query = textField.getText();
				filter(query);
			}
		});
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Search a book:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 44, 175, 19);
		panel_1.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Go back");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserPage.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(405, 48, 102, 35);
		panel_1.add(btnNewButton);
	}
}
