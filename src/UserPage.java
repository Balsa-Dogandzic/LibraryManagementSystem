import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class UserPage extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 446);
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

		lblNewLabel = new JLabel("Welcome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel(LoginScreen.getName());
		panel.add(lblNewLabel_1);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		panel_2 = new JPanel();
		panel_1.add(panel_2);

		panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		panel_1.add(panel_3);

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(270, 300));
		DefaultTableModel model = new DefaultTableModel();
		model.addRow(new Object[] {});
		JTable table = new JTable(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, },
				new String[] { "ISBN", "Reservation Date", "Return Date" }));
		table.setPreferredSize(new Dimension(247, 270));
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setMinimumSize(new Dimension(247, 231));
		scrollPane.setViewportView(table);
		panel_3.add(scrollPane);

	}

	public void initialize() {
		this.setVisible(true);
	}

}
