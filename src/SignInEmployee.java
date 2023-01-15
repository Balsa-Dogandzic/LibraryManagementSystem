import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignInEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInEmployee frame = new SignInEmployee();
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
	public SignInEmployee() {
		super("Add employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 515, 374);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 0, 0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

		JLabel lblNewLabel = new JLabel("please insert your username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_3);

		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(12);
		flowLayout_1.setHgap(20);
		panel.add(panel_4);

		JLabel lblNewLabel_1 = new JLabel("please insert your password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel_4.add(lblNewLabel_1);

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(20);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel.add(panel_5);

		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
		flowLayout_3.setVgap(10);
		flowLayout_3.setHgap(20);
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel.add(panel_6);

		JLabel lblNewLabel_2 = new JLabel("Why do  you think we should hire you:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel_6.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_7.getLayout();
		flowLayout_4.setVgap(0);
		flowLayout_4.setHgap(20);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_7);

		JTextPane textPane = new JTextPane();
		panel_7.add(textPane);
		textPane.setPreferredSize(new Dimension(130, 35));

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_8.getLayout();
		flowLayout_5.setVgap(12);
		flowLayout_5.setHgap(20);
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_8);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
			
				if (l.addWorker(textField.getText(), textField_1.getText())) {
					JOptionPane.showMessageDialog(null, "Successful Sign-in", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "You inserted wrong data", "Message",
							JOptionPane.ERROR_MESSAGE);
				}
				notInitialeze();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_8.add(btnNewButton);
	}

	public void initialize() {
		this.setVisible(true);
	}

	public void notInitialeze() {
		this.setVisible(false);
	}

}
