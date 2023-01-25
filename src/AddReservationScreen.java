import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;

public class AddReservationScreen {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReservationScreen window = new AddReservationScreen();
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
	public AddReservationScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add a reservation");
		frame.setBounds(100, 100, 654, 470);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Make a reservation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 495, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose a book:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 62, 115, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("yyyy/mm/dd");
		lblNewLabel_3_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(221, 344, 115, 21);
		panel.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(135, 62, 196, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		table = createTable();
		insertTableData();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 108, 620, 111);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Choose the reader:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 242, 115, 21);
		panel.add(lblNewLabel_2);
		
		ArrayList<Reader> list = Reader.getReaders();
		Reader[] readers = new Reader[list.size()];
		list.toArray(readers);
		JComboBox<Reader> comboBox = new JComboBox<Reader>(readers);
		comboBox.setBounds(10, 273, 201, 21);
		panel.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Return date:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 313, 115, 21);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.setBounds(10, 394, 155, 29);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EmployeePage.main(null);
				frame.dispose();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.setBounds(475, 394, 155, 29);
		btnReserve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Adds new reservation
				String isbn = textField.getText();
				Reader r = (Reader)comboBox.getSelectedItem();
				int readerId = r.getId();
				String reserveDate = String.valueOf(new Date(System.currentTimeMillis()));
				String returnDate = textField_1.getText();
				
				if(Reservation.addReservation(readerId, isbn, reserveDate, returnDate)) {
					int option = JOptionPane.showConfirmDialog(frame, "Book reserved successfully. Are you done with the reservations?", "Message",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					if (table.getSelectedRow() != -1) {
						tableModel.removeRow(table.getSelectedRow());
						textField.setText("");
					}
					if(option == 0) {
						EmployeePage.main(null);
						frame.dispose();
						return;
					}
					return;
				}
				JOptionPane.showMessageDialog(frame, "Something went wrong", "Message", JOptionPane.ERROR_MESSAGE);
			}
		});
		panel.add(btnReserve);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 344, 201, 21);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//Doesn't allow wrong date format
				Pattern p = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$");
				if (!(p.matcher(textField_1.getText() + e.getKeyChar()).matches())) {
					lblNewLabel_3_1.setForeground(new Color(255,0,0));
					btnReserve.setEnabled(false);
				}else {
					lblNewLabel_3_1.setForeground(new Color(128, 128, 128));
					btnReserve.setEnabled(true);
				}
			}
		});
		panel.add(textField_1);
		
		JLabel lblNewLabel_4 = new JLabel("Date: " + String.valueOf(new Date(System.currentTimeMillis())));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(536, 10, 94, 21);
		panel.add(lblNewLabel_4);
	}
	
	//Method that creates a table
	private JTable createTable() {
		String[] colName = { "isbn", "name", "category", "price", "author", "year"};
	    if (table == null) {
	        table = new JTable() {
	            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				//Disables cell editing
				public boolean isCellEditable(int nRow, int nCol) {
	                return false;
	            }
	        };
	    }
		
	    DefaultTableModel contactTableModel = (DefaultTableModel) table.getModel();
	    contactTableModel.setColumnIdentifiers(colName);
	    
	    //Disables resizing the columns
	    table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		
		//Allows selection of only one row
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    table.getTableHeader().setReorderingAllowed(false);
	    
	    //Calls the function when the row is selected
	    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() != -1)
					textField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			}
		});
	    
	    return table;
	}
	
	//Inserts the rows in the table from the database
	private void insertTableData() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		ArrayList<Book> books = Book.getFreeBooks();
		
		for(Book b : books) {
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
}
