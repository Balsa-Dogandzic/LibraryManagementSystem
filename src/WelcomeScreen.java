import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;

public class WelcomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen frame = new WelcomeScreen();
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
	public WelcomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 100));
		contentPane.add(panel, BorderLayout.NORTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 40, 35);
		panel.setLayout(fl_panel);

		JLabel lblNewLabel = new JLabel("Welcome to our Bookstore");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(180, 40));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 41));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(30);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3);

		JButton btnNewButton = new JButton("Log-in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginScreen.main(null);
				dispose();
			}
		});
		panel_3.add(btnNewButton);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_2);

		JButton btnNewButton_1 = new JButton("Sign in ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn si = new SignIn();
				si.initialize();
               dispose();
			}
		});
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("picture1.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(21, 72, 138, 194);
		panel_5.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("48 laws of power");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(21, 29, 151, 33);
		panel_5.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("only for 29.99$");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(21, 276, 133, 33);
		panel_5.add(lblNewLabel_3);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_4.add(panel_5_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("picture2.jpg")).getImage();
		lblNewLabel_1_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1_1.setBounds(21, 72, 138, 194);
		panel_5_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Dark Tower");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(0, 29, 172, 33);
		panel_5_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("only for 60.44$");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(21, 276, 133, 33);
		panel_5_1.add(lblNewLabel_3_1);

		JPanel panel_5_2 = new JPanel();
		panel_5_2.setLayout(null);
		panel_4.add(panel_5_2);

		JLabel lblNewLabel_1_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("picture3.jpg")).getImage();
		lblNewLabel_1_2.setIcon(new ImageIcon(img2));
		lblNewLabel_1_2.setBounds(31, 72, 138, 194);
		panel_5_2.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2_2 = new JLabel("Inferno");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(21, 29, 151, 33);
		panel_5_2.add(lblNewLabel_2_2);

		JLabel lblNewLabel_3_2 = new JLabel("only for 87.99$");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(21, 276, 133, 33);
		panel_5_2.add(lblNewLabel_3_2);

	}

	public void initialize() {
		this.setVisible(true);
	}

}
