import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
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
	public UserPage() {
		super("User page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 611, 446);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);

		lblNewLabel = new JLabel("Welcome " + LoginScreen.getReader().getName());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton("Catalogue");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookCatalogue.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(77, 35, 120, 30);
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen ws = new WelcomeScreen();
				ws.initialize();
				dispose();
			}
		});
		btnNewButton_1.setBounds(77, 146, 120, 30);
		panel_2.add(btnNewButton_1);
		
		JButton btnRequestABook = new JButton("Request");
		btnRequestABook.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRequestABook.setBounds(77, 91, 120, 30);
		panel_2.add(btnRequestABook);

		panel_3 = new JPanel();
		panel_1.add(panel_3);

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(270, 300));
		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false);
		ArrayList<Reservation> reservations = Reservation.getReservation(LoginScreen.getReader().getEmail());
		Object[][] rowData = new Object[reservations.size()][3];
		for (int i = 0; i < rowData.length; i++) {
			rowData[i][0] = reservations.get(i).getBook_id();
			rowData[i][1] = reservations.get(i).getDate_of_reservation();
			rowData[i][2] = reservations.get(i).getReturn_date();
		}
		table.setModel(new DefaultTableModel(rowData, new String[] { "isbn", "Issue date", "Return Date" }) {
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
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		table.setPreferredSize(new Dimension(247, 270));
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setMinimumSize(new Dimension(247, 231));
		scrollPane.setViewportView(table);
		panel_3.add(scrollPane);

	}

	public void initialize() {
		this.setVisible(true);
	}
}
