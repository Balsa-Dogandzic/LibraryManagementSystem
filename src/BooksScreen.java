import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.util.ArrayList;


public class BooksScreen {

	private JFrame frame;
	private JPanel panel_1;
	private JTable table;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 541, 371);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 527, 334);
		frame.getContentPane().add(panel_1);
		
		table = new JTable();
		ArrayList<Book> books = Book.getFreeBooks();
		Object[][] rowData = new Object[books.size()][6];
		for(int i = 0; i < rowData.length; i++) {
			rowData[i][0] = books.get(i).getIsbn();
			rowData[i][1] = books.get(i).getName();
			rowData[i][2] = books.get(i).getCategory();
			rowData[i][3] = books.get(i).getPrice();
			rowData[i][4] = books.get(i).getAuthor();
			rowData[i][5] = books.get(i).getYear();
		}
		table.setModel(new DefaultTableModel(
			rowData,
			new String[] {
				"isbn", "Name", "Category", "Price", "Author", "Year"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		
		panel_1.add(table);
	}

}
