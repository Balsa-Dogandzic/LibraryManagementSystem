import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class BooksScreen {

	private JFrame frame;
	private JPanel panel_1;
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

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
		frame = new JFrame("Free books");
		frame.setBounds(100, 100, 706, 408);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		
		table = new JTable();
		//Fetching data for table rows
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
		//Setting a table model
		table.setModel(new DefaultTableModel(
			rowData,
			new String[] {
				"isbn", "Name", "Category", "Price", "Author", "Year"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //Disables editing on the cells
		       return false;
		    }
		});
		//Disables resizing the columns
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		panel_1.setLayout(new BorderLayout(0, 0));
		//Adding the table in the JScrollPane
		JScrollPane sp = new JScrollPane(table);

		panel_1.add(sp);
		
		panel = new JPanel();
		panel_1.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(8, 1, 3, 3));
		
		btnNewButton = new JButton("Choose a book");
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Add book");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddBookScreen.main(null);
				frame.dispose();
			}
		});
		panel.add(btnNewButton_1);
		
		//Go back button, should add the home screen to go back to
		btnNewButton_2 = new JButton("Go back");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnNewButton_2);
	}

}
