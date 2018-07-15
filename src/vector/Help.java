package vector;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
/**
 * This vector calculator receives user data to do vector calculations with operations
 * Show Vectors
 * @author Vinojan Veluppilai
 * @author Hargun Bedi
 * @author Yash Kamath
 * @version 1.7
 * @since   2018-03-18
 */
public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame for Help
	 */
	public Help() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 765);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel Assist = new JLabel("hellow");
		Assist.setVerticalAlignment(JLabel.TOP);
		Assist.setVisible(true);	
	
		final JTextArea txtErrors = new JTextArea();
		txtErrors.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		txtErrors.setText("If you are receiving any errors when inputting or displaying data, "
				+ "restart \r\nthe program. Make sure all of your inputted data is numerical "
				+ "and that \r\nyou have entered all of the necessary information that is "
				+ "required to \r\ncompute the vectors. If you require further assistance, "
				+ "or if you do not \r\nknow how to operate the calculator, please refer to "
				+ "the last option \r\n\"How to use the vector calculator.");
		txtErrors.setBounds(6, 240, 631, 267);
		contentPane.add(txtErrors);
		txtErrors.setVisible(false);

		final JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setIcon(new ImageIcon("./images/HelpScreen2.JPG"));
		lblNewLabel2.setBounds(-29, 154, 655, 355);
		contentPane.add(lblNewLabel2);
			
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("./images/HelpScreen1.JPG"));
		lblNewLabel.setBounds(6, 154, 620, 355);
		contentPane.add(lblNewLabel);
			
		final JButton btnBack = new JButton("\u2190");
		btnBack.setBackground(Color.lightGray);	
		btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblNewLabel.setVisible(true);
					lblNewLabel2.setVisible(false);
				}
			});
			
		final JButton btnNext = new JButton("\u2192");
		btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblNewLabel.setVisible(false);
					lblNewLabel2.setVisible(true);					
				}
			});
			
		btnNext.setVisible(false);
		btnBack.setVisible(false);
		btnNext.setBackground(Color.WHITE);
		btnNext.setBounds(549, 523, 61, 25);
		contentPane.add(btnNext);
		lblNewLabel.setVisible(false);
		lblNewLabel2.setVisible(false);
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("./images/MssLogo.JPG"));
		lblLogo.setBounds(127, 425, 343, 300);
		contentPane.add(lblLogo);
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setBounds(476, 523, 61, 25);
		contentPane.add(btnBack);
		
		final JComboBox cmbOptions = new JComboBox();
		cmbOptions.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cmbOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == cmbOptions) {
					JComboBox cmbInput = (JComboBox)arg0.getSource(); 
 					String strOptions = (String)cmbInput.getSelectedItem();
 					lblNewLabel.setVisible(true);
 					txtErrors.setVisible(false);
 					if (strOptions == "How to use the vector calculator") {
 						btnNext.setVisible(true);
 						btnBack.setVisible(true);
 						btnBack.setEnabled(true);
 					} else if (strOptions == "Why am I receiving errors?") {
 						txtErrors.setVisible(true);
 						lblNewLabel.setVisible(false);
 						lblNewLabel2.setVisible(false);
 						btnNext.setVisible(false);
 						btnBack.setVisible(false);
 					
 					} else if (strOptions == "Select an option") {
 						lblNewLabel.setVisible(false);
 						lblNewLabel2.setVisible(false);
 						btnNext.setVisible(false);
 						btnBack.setVisible(false);
 						txtErrors.setVisible(false);
 					}
				}
			}
		});
		cmbOptions.setModel(new DefaultComboBoxModel(new String[] {"Select an option", "How to use the vector calculator", "Why am I receiving errors?"}));
		cmbOptions.setBounds(98, 97, 407, 29);
		contentPane.add(cmbOptions);
		
		JLabel lblMssLions = new JLabel("Copyright \u00A9 2018 MSS LIONS");
		lblMssLions.setForeground(Color.GRAY);
		lblMssLions.setHorizontalAlignment(SwingConstants.CENTER);
		lblMssLions.setBounds(12, 690, 598, 33);
		contentPane.add(lblMssLions);

		JLabel lblHelp = new JLabel("WE ARE HERE TO HELP YOU");
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelp.setFont(new Font("Leelawadee UI", Font.BOLD, 33));
		lblHelp.setBounds(12, 13, 598, 46);
		contentPane.add(lblHelp);
		
		JLabel lblSelectAnyOption = new JLabel("select any option from the list . . .");
		lblSelectAnyOption.setForeground(Color.GRAY);
		lblSelectAnyOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAnyOption.setFont(new Font("Louis George Caf� Light", Font.ITALIC, 21));
		lblSelectAnyOption.setBounds(12, 55, 598, 46);
		contentPane.add(lblSelectAnyOption);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(307, 307, 77, 108);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(380, 307, 77, 108);
		contentPane.add(label_5);
		
		if (cmbOptions.equals("How to use the vector calculator")){
			this.setVisible(true);
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
