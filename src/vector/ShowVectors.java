package vector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This vector calculator receives user data to do vector calculations with operations
 * Show Vectors
 * @author Vinojan Veluppilai
 * @author Hargun Bedi
 * @author Yash Kamath
 * @version 1.7
 * @since   2018-03-18
 */

public class ShowVectors extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	ArrayList<Vector> vectors1 = new ArrayList<Vector>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowVectors frame = new ShowVectors();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ShowVectors() {
		
	}
	/**
	 * 
	 * @param vectors gives arrayList of all the vectors entered
	 * @param type 1D or 2D or 3D
	 * @param type3 Geometric or Cartesian
	 * @param mag2 arrayList of all magnitudes entered for Geometric 
	 * Create Frame
	 */
	public ShowVectors(ArrayList<Vector> vectors, String type, String type3, ArrayList<Double> mag2) {
		setResizable(false);
		final String type1 = type;
		final String type2 = type3;
		final ArrayList<Double> mag = mag2;
		this.vectors1 = vectors;
		setBounds(10, 10, 484, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);
		JLabel lblNewLabel = new JLabel("Vectors Inputted");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(56, 16, 350, 46);
		contentPane.add(lblNewLabel);
		
		final JTextArea txtVectors = new JTextArea();
		JScrollPane areaScrollPane = new JScrollPane(txtVectors);
		areaScrollPane.setBounds(30, 86, 404, 136);
		areaScrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		txtVectors.setEditable(false);
		contentPane.add(areaScrollPane);
		
		JButton btnShow = new JButton("Show");
		btnShow.setBounds(166, 222, 117, 29);
		contentPane.add(btnShow);
		
		/**
		 * @param Display vectors in text area
		 */
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < vectors1.size(); i ++) {
					if (type2 == "Cartesian") {
						if(type1 == "1D") {
							txtVectors.setText(txtVectors.getText() + "Vector " + (i+1) 
									+ ": " + "[" + vectors1.get(i).getxComp() + "]" + "\n");
						}
					
						if (type1 == "2D") {
							txtVectors.setText(txtVectors.getText() + "Vector " + (i+1) + ": " 
										+ "[" + vectors1.get(i).getxComp() + ", " 
										+ vectors1.get(i).getyComp() + "]" + "\n");
						}
					
						if (type1 == "3D") {
							txtVectors.setText(txtVectors.getText() + "Vector " + (i+1) + ": " 
									+ "[" + vectors1.get(i).getxComp() + ", " 
									+ vectors1.get(i).getyComp() + ", " 
									+ vectors1.get(i).getzComp() + "]" + "\n");
						}
					}
					
					if (type2 == "Geometric") {
						txtVectors.setText(txtVectors.getText() + "Vector " + (i + 1) + ": " 
									+ Vector.Geometric(vectors1.get(i), type1, mag.get(i)) + "\n");
					}
				}				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
