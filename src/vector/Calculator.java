package vector;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextArea;

import vector.ShowVectors;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField txtGeoMag;
	private JTextField txtCarty;
	private JTextField txtCartz;
	private JTextField txtCartx;
	private JTextField txtGeo1;
	private JTextField txtGeo2;
	private JTextField txtGeo3;

	/**
	 * This vector calculator receives user data to do vector calculations with operations
	 * Show Vectors
	 * @author Vinojan Veluppilai
	 * @author Hargun Bedi
	 * @author Yash Kamath
	 * @version 1.7
	 * @since   2018-03-18
	 */
	
	ArrayList<Vector> vectors = new ArrayList<Vector>();
	String[] vectorsCounted;
	VectorCalculations vectorAns;
	private int vectorCount = 0;
	private int vectCount;
	private ArrayList<Double> mag3 = new ArrayList<Double>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame for Calculator
	 */
	public Calculator() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 617);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnuClear = new JMenu("Clear");
		menuBar.add(mnuClear);
		
		JMenu mnuRestart = new JMenu("Restart");
		mnuRestart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
				Calculator calc = new Calculator();
				calc.show();
				
			}
		});
		menuBar.add(mnuRestart);
		JMenu mnHelp = new JMenu("Help");
		mnHelp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Help.main(null);
			}
		});
		
		menuBar.add(mnHelp);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox cmbCross2 = new JComboBox();
		cmbCross2.setBounds(789, 440, 62, 27);
		contentPane.add(cmbCross2);
		
		final JComboBox cmbCross1 = new JComboBox();
		cmbCross1.setBounds(688, 439, 62, 27);
		contentPane.add(cmbCross1);
		
		final JComboBox cmbDot2 = new JComboBox();
		cmbDot2.setBounds(789, 402, 62, 27);
		contentPane.add(cmbDot2);
		
		final JComboBox cmbDot1 = new JComboBox();
		cmbDot1.setBounds(688, 401, 62, 27);
		contentPane.add(cmbDot1);
		
		txtGeoMag = new JTextField();
		txtGeoMag.setBounds(25, 309, 65, 22);
		contentPane.add(txtGeoMag);
		txtGeoMag.setColumns(10);
		
		final JLabel lblMag = new JLabel("Magnitude");
		lblMag.setForeground(Color.WHITE);
		lblMag.setBackground(Color.WHITE);
		lblMag.setHorizontalAlignment(SwingConstants.LEFT);
		lblMag.setBounds(25, 285, 70, 16);
		contentPane.add(lblMag);
		
		final JLabel lblCartesian = new JLabel("Cartesian");
		lblCartesian.setForeground(Color.WHITE);
		lblCartesian.setBackground(Color.WHITE);
		lblCartesian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCartesian.setBounds(8, 251, 87, 16);
		contentPane.add(lblCartesian);
		
		final JButton btnSave = new JButton("SAVE & ADD NEW\r\n\r\n");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnSave.setBounds(25, 460, 256, 25);
		contentPane.add(btnSave);
		
		final JLabel lblX = new JLabel("x");
		lblX.setForeground(Color.WHITE);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(25, 397, 65, 16);
		contentPane.add(lblX);
		
		final JLabel lblY = new JLabel("y");
		lblY.setForeground(Color.WHITE);
		lblY.setHorizontalAlignment(SwingConstants.CENTER);
		lblY.setBounds(120, 397, 62, 16);
		contentPane.add(lblY);
		
		final JLabel lblZ = new JLabel("z");
		lblZ.setForeground(Color.WHITE);
		lblZ.setHorizontalAlignment(SwingConstants.CENTER);
		lblZ.setBounds(216, 397, 62, 16);
		contentPane.add(lblZ);
		
		final JButton btnShowVectors = new JButton("Show Vectors");
		
		btnShowVectors.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShowVectors.setBounds(25, 498, 256, 25);
		contentPane.add(btnShowVectors);
		
		txtCarty = new JTextField();
		txtCarty.setColumns(10);
		txtCarty.setBounds(120, 370, 65, 22);
		contentPane.add(txtCarty);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 118, 429, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 225, 429, 2);
		contentPane.add(separator_2);
		
		final JLabel lblBrack2 = new JLabel("]");
		lblBrack2.setForeground(Color.WHITE);
		lblBrack2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblBrack2.setBounds(285, 363, 43, 33);
		contentPane.add(lblBrack2);
		
		final JRadioButton radMag = new JRadioButton("Magnitude of v");
		radMag.setBackground(Color.DARK_GRAY);
		radMag.setForeground(Color.WHITE);
		radMag.setBounds(494, 58, 140, 25);
		contentPane.add(radMag);
		
		final JTextArea txtSumOfV = new JTextArea();
		JScrollPane areaScrollPane = new JScrollPane(txtSumOfV);
		txtSumOfV.setEditable(false);
		areaScrollPane.setBounds(595, 308, 228, 43);
		areaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		contentPane.add(areaScrollPane);
		
		final JRadioButton radSumOfV = new JRadioButton("Sum of All");
		radSumOfV.setBackground(Color.DARK_GRAY);
		radSumOfV.setForeground(Color.WHITE);
		radSumOfV.setBounds(494, 315, 97, 25);
		contentPane.add(radSumOfV);
		
		final JRadioButton radDotProduct = new JRadioButton("Dot product of v");
		radDotProduct.setBackground(Color.DARK_GRAY);
		radDotProduct.setForeground(Color.WHITE);
		radDotProduct.setBounds(492, 397, 152, 33);
		contentPane.add(radDotProduct);
		
		final JRadioButton radDiffOfV = new JRadioButton("Diff of All");
		radDiffOfV.setBackground(Color.DARK_GRAY);
		radDiffOfV.setForeground(Color.WHITE);
		radDiffOfV.setBounds(494, 360, 97, 25);
		contentPane.add(radDiffOfV);
		
		final JTextArea txtDiffOfV = new JTextArea();
		JScrollPane areaScrollPane2 = new JScrollPane(txtDiffOfV);
		txtDiffOfV.setEditable(false);
	
		areaScrollPane2.setBounds(595, 352, 228, 43);
		
		areaScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		contentPane.add(areaScrollPane2);
		 
		final JRadioButton radCrossProduct = new JRadioButton("Cross product of v");
		radCrossProduct.setBackground(Color.DARK_GRAY);
		radCrossProduct.setForeground(Color.WHITE);
		radCrossProduct.setBounds(492, 434, 152, 33);
		contentPane.add(radCrossProduct);
		
		final JRadioButton radUnit = new JRadioButton("Unit Vector of v");
		radUnit.setBackground(Color.DARK_GRAY);
		radUnit.setForeground(Color.WHITE);
		radUnit.setBounds(494, 96, 140, 31);
		contentPane.add(radUnit);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(494, 269, 576, 10);
		contentPane.add(separator_3);
		
		final JTextArea txtValues = new JTextArea();
		JScrollPane areaScrollPane3 = new JScrollPane(txtValues);
		areaScrollPane3.setBounds(494, 191, 536, 76);
		areaScrollPane3.setVerticalScrollBarPolicy(
		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		txtValues.setEditable(false);
		
		contentPane.add(areaScrollPane3);
		
		final JTextArea txtOperations = new JTextArea();
		JScrollPane areaScrollPane4 = new JScrollPane(txtOperations);
		areaScrollPane4.setBounds(494, 482, 536, 76);
		areaScrollPane4.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		txtOperations.setEditable(false);
		
		contentPane.add(areaScrollPane4);
		
		JLabel lblVector = new JLabel("Vector Values");
		lblVector.setForeground(Color.WHITE);
		lblVector.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVector.setBounds(494, 30, 127, 24);
		contentPane.add(lblVector);
		
		JLabel lblOperations = new JLabel("Operations");
		lblOperations.setForeground(Color.WHITE);
		lblOperations.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOperations.setBounds(494, 277, 127, 24);
		contentPane.add(lblOperations);
		
		txtCartz = new JTextField();
		txtCartz.setColumns(10);
		txtCartz.setBounds(214, 370, 65, 22);
		contentPane.add(txtCartz);
		
		final JLabel lblAngles = new JLabel("Angles");
		lblAngles.setForeground(Color.WHITE);
		lblAngles.setBackground(Color.WHITE);
		lblAngles.setHorizontalAlignment(SwingConstants.LEFT);
		lblAngles.setBounds(25, 349, 65, 16);
		contentPane.add(lblAngles);
		
		final JLabel lblCoor = new JLabel("Coordinates");
		lblCoor.setForeground(Color.WHITE);
		lblCoor.setBackground(Color.WHITE);
		lblCoor.setHorizontalAlignment(SwingConstants.LEFT);
		lblCoor.setBounds(25, 349, 93, 16);
		contentPane.add(lblCoor);
		
		final JLabel lblTheta = new JLabel("\u019F");
		lblTheta.setForeground(Color.WHITE);
		lblTheta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheta.setBounds(25, 397, 65, 16);
		contentPane.add(lblTheta);
		
		final JLabel lblAlpha = new JLabel("\u03B1");
		lblAlpha.setForeground(Color.WHITE);
		lblAlpha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlpha.setBounds(120, 397, 65, 16);
		contentPane.add(lblAlpha);
		
		final JLabel lblGamma = new JLabel("\u03B3");
		lblGamma.setForeground(Color.WHITE);
		lblGamma.setHorizontalAlignment(SwingConstants.CENTER);
		lblGamma.setBounds(216, 397, 62, 16);
		contentPane.add(lblGamma);
		
		txtCartx = new JTextField();
		txtCartx.setColumns(10);
		txtCartx.setBounds(25, 370, 65, 22);
		contentPane.add(txtCartx);
		
		txtGeo1 = new JTextField();
		txtGeo1.setColumns(10);
		txtGeo1.setBounds(25, 370, 65, 22);
		contentPane.add(txtGeo1);
		
		txtGeo2 = new JTextField();
		txtGeo2.setColumns(10);
		txtGeo2.setBounds(120, 370, 65, 22);
		contentPane.add(txtGeo2);
		
		txtGeo3 = new JTextField();
		txtGeo3.setColumns(10);
		txtGeo3.setBounds(214, 370, 65, 22);
		contentPane.add(txtGeo3);
		
		final JLabel lblComma2 = new JLabel(",");
		lblComma2.setForeground(Color.WHITE);
		lblComma2.setHorizontalAlignment(SwingConstants.CENTER);
		lblComma2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblComma2.setBounds(183, 370, 31, 43);
		contentPane.add(lblComma2);
		
		final JLabel lblDimensions = new JLabel("Dimensions");
		lblDimensions.setForeground(Color.WHITE);
		lblDimensions.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDimensions.setBounds(8, 138, 127, 22);
		contentPane.add(lblDimensions);
		
		final JLabel lblGeometric = new JLabel("Geometric");
		lblGeometric.setForeground(Color.WHITE);
		lblGeometric.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGeometric.setBounds(8, 251, 87, 16);
		contentPane.add(lblGeometric);		
		
		final JRadioButton rad1D = new JRadioButton("1D");
		rad1D.setBackground(Color.DARK_GRAY);
		rad1D.setForeground(Color.WHITE);
		rad1D.setBounds(8, 177, 53, 25);
		contentPane.add(rad1D);
		
		
		final JRadioButton rad2D = new JRadioButton("2D");
		rad2D.setBackground(Color.DARK_GRAY);
		rad2D.setForeground(Color.WHITE);
		rad2D.setBounds(188, 177, 93, 25);
		contentPane.add(rad2D);
		
		final JRadioButton rad3D = new JRadioButton("3D");
		rad3D.setBackground(Color.DARK_GRAY);
		rad3D.setForeground(Color.WHITE);
		rad3D.setBounds(369, 177, 60, 25);
		contentPane.add(rad3D);
		
		final JButton btnDisplay = new JButton("Display");
		btnDisplay.setEnabled(false);
		
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDisplay.setBounds(935, 141, 97, 25);
		contentPane.add(btnDisplay);
		
		final JButton btnDisplayOperations = new JButton("Display");
		btnDisplayOperations.setEnabled(false);
		
		btnDisplayOperations.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDisplayOperations.setBounds(933, 438, 97, 25);
		contentPane.add(btnDisplayOperations);
		
		final JComboBox cmbAngle1 = new JComboBox();
		cmbAngle1.setBounds(888, 60, 65, 25);
		contentPane.add(cmbAngle1);
		
		final JComboBox cmbAngle2 = new JComboBox();
		cmbAngle2.setBounds(990, 62, 62, 26);
		contentPane.add(cmbAngle2);
		
		final JComboBox cmbProj1 = new JComboBox();
		cmbProj1.setBounds(628, 139, 62, 20);
		contentPane.add(cmbProj1);
		
		
		final JComboBox cmbProj2 = new JComboBox();
		cmbProj2.setBounds(743, 141, 65, 20);
		contentPane.add(cmbProj2);
		
		final JComboBox cmbUnit = new JComboBox();
		cmbUnit.setBounds(628, 100, 62, 20);
		contentPane.add(cmbUnit);
		
		final JComboBox cmbMagnitude = new JComboBox();
		cmbMagnitude.setBounds(628, 59, 62, 20);
		contentPane.add(cmbMagnitude);
		
				
		final JRadioButton radProj = new JRadioButton("Projection of:");
		radProj.setBackground(Color.DARK_GRAY);
		radProj.setForeground(Color.WHITE);
		radProj.setBounds(494, 137, 140, 25);
		contentPane.add(radProj);
		
		final JRadioButton radAng = new JRadioButton("Angle between:");
		radAng.setBackground(Color.DARK_GRAY);
		radAng.setForeground(Color.WHITE);
		radAng.setBounds(753, 56, 140, 30);
		contentPane.add(radAng);
		
		JLabel lblVectorType = new JLabel("Vector Type");
		lblVectorType.setBounds(11, 33, 97, 19);
		contentPane.add(lblVectorType);
		lblVectorType.setForeground(Color.WHITE);
		lblVectorType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		final JButton btnDone = new JButton("Done");
		
		btnDone.setBounds(287, 479, 117, 29);
		contentPane.add(btnDone);
		
		final JRadioButton radGeometric = new JRadioButton("Geometric");
		radGeometric.setBackground(Color.DARK_GRAY);
		radGeometric.setForeground(Color.WHITE);
		radGeometric.setBounds(8, 70, 127, 25);
		contentPane.add(radGeometric);
		
		final JRadioButton radCartesian = new JRadioButton("Cartesian");
		radCartesian.setBackground(Color.DARK_GRAY);
		radCartesian.setForeground(Color.WHITE);
		
		radCartesian.setBounds(188, 70, 93, 25);
		contentPane.add(radCartesian);
		
		final JRadioButton radAng180 = new JRadioButton("180");
		radAng180.setBackground(Color.DARK_GRAY);
		radAng180.setForeground(Color.WHITE);
		radAng180.setBounds(102, 370, 65, 23);
		contentPane.add(radAng180);
		
		
		final JLabel lblBrack1 = new JLabel("[");
		lblBrack1.setForeground(Color.WHITE);
		lblBrack1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblBrack1.setBounds(10, 363, 43, 33);
		contentPane.add(lblBrack1);
		
		final JRadioButton radAng0 = new JRadioButton("0");
		radAng0.setBackground(Color.DARK_GRAY);
		radAng0.setForeground(Color.WHITE);
		radAng0.setBounds(6, 369, 65, 23);
		contentPane.add(radAng0);
		
		final JLabel lblComma1 = new JLabel(",");
		lblComma1.setForeground(Color.WHITE);
		lblComma1.setHorizontalAlignment(SwingConstants.CENTER);
		lblComma1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblComma1.setBounds(89, 370, 31, 43);
		contentPane.add(lblComma1);
		lblComma1.setVisible(false);
		
		/**
		 * Set Angles to false for 1D
		 */
		radAng0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radAng0.setEnabled(false);
				radAng180.setEnabled(false);
			}
		});
		/**
		 * Set Angles to false for 1D
		 */
		radAng180.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radAng0.setEnabled(false);
				radAng180.setEnabled(false);
			}
		});
		
		lblCartesian.setVisible(false);
		lblX.setVisible(false);
		lblY.setVisible(false);
		lblZ.setVisible(false);
		lblCoor.setVisible(false);
		txtCartx.setVisible(false);
		txtCarty.setVisible(false);
		txtCartz.setVisible(false);
		lblGeometric.setVisible(false);
		lblTheta.setVisible(false);
		lblGamma.setVisible(false);
		lblAlpha.setVisible(false);
		txtGeoMag.setVisible(false);
		lblMag.setVisible(false);
		lblAngles.setVisible(false);
		txtGeo1.setVisible(false);
		txtGeo2.setVisible(false);
		txtGeo3.setVisible(false);
		lblBrack2.setVisible(false);
		lblComma2.setVisible(false);
		btnShowVectors.setVisible(false);
		btnSave.setVisible(false);
		rad1D.setEnabled(false);
		rad2D.setEnabled(false);
		rad3D.setEnabled(false);
		radAng0.setVisible(false);
		lblBrack1.setVisible(false);
		radAng180.setVisible(false);
		btnDone.setVisible(false);
		
		/** 
		 * Clicking Cartesian radio button 
		 * */
			radCartesian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCartesian.setVisible(false);
				lblX.setVisible(false);
				lblY.setVisible(false);
				lblZ.setVisible(false);
				lblCoor.setVisible(false);
				txtCartx.setVisible(false);
				txtCarty.setVisible(false);
				txtCartz.setVisible(false);
				btnShowVectors.setVisible(false);
				btnSave.setVisible(false);
				rad1D.setEnabled(true);
				rad2D.setEnabled(true);
				rad3D.setEnabled(true);
				
				if (radCartesian.isSelected()) {
					radGeometric.setEnabled(false);
					radCartesian.setEnabled(false);
				}
			}
		});
		
		/** 
		 * Clicking Cartesian radio button 
		 * */
		radGeometric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGeometric.setVisible(false);
				lblTheta.setVisible(false);
				lblGamma.setVisible(false);
				lblAlpha.setVisible(false);
				txtGeoMag.setVisible(false);
				lblMag.setVisible(false);
				lblAngles.setVisible(false);
				txtGeo1.setVisible(false);
				txtGeo2.setVisible(false);
				txtGeo3.setVisible(false);
				lblX.setBounds(25, 382, 65, 16);
				lblY.setBounds(120, 382, 62, 16);
				lblZ.setBounds(214, 382, 62, 16);
				txtCartx.setBounds(25,355,65,22);
				txtCarty.setBounds(120,355,65,22);
				txtCartz.setBounds(214,355,65,22);
				lblComma1.setBounds(89, 355, 31, 43);
				lblComma2.setBounds(183, 355, 31, 43);
				lblBrack1.setBounds(10, 348, 43, 33);
				lblBrack2.setBounds(285, 348, 43, 33);
				lblCoor.setBounds(25, 334, 87, 16);
				btnShowVectors.setVisible(false);
				btnSave.setVisible(false);
				rad1D.setEnabled(true);
				rad2D.setEnabled(true);
				rad3D.setEnabled(true);
				
				if (radGeometric.isSelected()) {
					radCartesian.setEnabled(false);
					radGeometric.setEnabled(false);
				}
				}
		}
		);		
		
		/** 
		 * Features of vectors 
		 * */
		radProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i <= vectorCount; i++) {	
					cmbProj1.addItem("" + i);
					cmbProj2.addItem("" + i);
				}
				radProj.setEnabled(false);
			}
		});

		radMag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i <= vectorCount; i++) {
					cmbMagnitude.addItem("" + i);
				}
				radMag.setEnabled(false);
			}
		});
		
		radUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i <= vectorCount; i++) {
					cmbUnit.addItem("" + i);	
				}
				radUnit.setEnabled(false);
			}
		});
	
		radAng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i <= vectorCount; i++) {		
					cmbAngle1.addItem("" + i);
					cmbAngle2.addItem("" + i);				
				}
				radAng.setEnabled(false);
			}
		});

		/** 
		 * All dimensions of vectors
		 * */
		rad1D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radGeometric.isSelected()) {
					txtGeoMag.setVisible(true);
					lblMag.setVisible(true);
					lblGeometric.setVisible(true);
					btnShowVectors.setVisible(true);
					btnSave.setVisible(true);
					lblAngles.setVisible(true);
					radAng0.setVisible(true);
					radAng180.setVisible(true);
					
				} else if (radCartesian.isSelected()) {
					lblBrack1.setVisible(true);
					lblCoor.setVisible(true);
					lblBrack1.setBounds(10, 343, 43, 33);
					lblComma1.setVisible(true);
					lblComma1.setText("]");
					txtCartx.setVisible(true);
					txtCartx.setBounds(28, 351, 65, 22);
					lblCoor.setBounds(28, 330, 93, 16);
					lblCartesian.setVisible(true);
					lblComma1.setBounds(84, 343, 43, 33);
					lblX.setVisible(true);
					lblX.setBounds(25, 380, 65, 16);
					btnShowVectors.setVisible(true);
					btnSave.setVisible(true);
				}
				
				if (rad1D.isSelected()) {
					rad2D.setEnabled(false);
					rad3D.setEnabled(false);
					rad1D.setEnabled(false);
					radDotProduct.setVisible(false);
					radCrossProduct.setVisible(false);
					cmbCross1.setVisible(false);
					cmbCross2.setVisible(false);
					cmbDot1.setVisible(false);
					cmbDot2.setVisible(false);
				}
			}
		});
		
		rad2D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radGeometric.isSelected()) {
					lblTheta.setVisible(true);
					txtGeoMag.setVisible(true);
					lblBrack1.setVisible(true);
					lblBrack1.setBounds(10, 363, 43, 33);
					lblBrack2.setVisible(true);
					lblMag.setVisible(true);
					lblGeometric.setVisible(true);
					lblAngles.setVisible(true);
					txtGeo1.setVisible(true);
					btnShowVectors.setVisible(true);
					btnSave.setVisible(true);
					lblBrack2.setBounds(95, 358, 31, 43);
					
				} else if (radCartesian.isSelected()) {
					lblCartesian.setVisible(true);
					lblCoor.setVisible(true);
					lblCoor.setBounds(28, 330, 93, 16);
					txtCartx.setVisible(true);
					txtCarty.setVisible(true);
					txtCartx.setBounds(28, 351, 65, 22);
					txtCarty.setBounds(123, 351, 65, 22);
					lblX.setVisible(true);
					lblY.setVisible(true);
					lblBrack1.setVisible(true);
					lblBrack1.setBounds(10, 343, 43, 33);
					lblComma1.setVisible(true);
					lblComma1.setBounds(84, 343, 43, 33);
					lblBrack2.setVisible(true);
					lblBrack2.setBounds(196, 343, 43, 33);
					btnShowVectors.setVisible(true);
					btnSave.setVisible(true);
					lblX.setBounds(25, 380, 65, 16);
					lblY.setBounds(120, 380, 65, 16);
				}
				
				if (rad2D.isSelected() == true) {
					rad1D.setEnabled(false);
					rad3D.setEnabled(false);
					rad2D.setEnabled(false);
					radCrossProduct.setVisible(false);
					cmbCross1.setVisible(false);
					cmbCross2.setVisible(false);
				}
			}
		});
		
		/** 
		 * Set all components visible except radio buttons 
		 * */
		rad3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radGeometric.isSelected()) {
				lblGeometric.setVisible(true);
				lblTheta.setVisible(true);
				lblAlpha.setVisible(true);
				lblGamma.setVisible(true);
				txtGeoMag.setVisible(true);
				lblBrack1.setVisible(true);
				lblBrack1.setBounds(10, 363, 43, 33);
				lblBrack2.setVisible(true);
				lblComma2.setBounds(183, 363, 43, 33);
				lblComma1.setVisible(true);
				lblComma2.setVisible(true);
				lblMag.setVisible(true);
				lblComma1.setBounds(84, 363, 43, 33);
				txtGeo1.setVisible(true);
				txtGeo2.setVisible(true);
				txtGeo3.setVisible(true);
				btnSave.setVisible(true);
				btnShowVectors.setVisible(true);
				lblBrack2.setBounds(284, 358, 31, 43);	
				} else if (radCartesian.isSelected()){
				lblCartesian.setVisible(true);
				txtCartx.setVisible(true);
				txtCarty.setVisible(true);
				txtCartz.setVisible(true);
				lblX.setVisible(true);
				lblY.setVisible(true);
				lblZ.setVisible(true);
				lblCoor.setVisible(true);
				lblCoor.setBounds(28, 330, 93, 16);
				txtCartx.setBounds(28, 351, 65, 22);
				txtCarty.setBounds(123, 351, 65, 22);
				txtCartz.setBounds(218, 351, 65, 22);
				lblComma1.setBounds(84, 343, 43, 33);
				lblComma2.setBounds(183, 343, 43, 33);
				lblCoor.setVisible(true);
				lblComma1.setVisible(true);
				lblComma2.setVisible(true);
				lblX.setBounds(25, 380, 65, 16);
				lblY.setBounds(120, 380, 65, 16);
				lblZ.setBounds(215, 380, 65, 16);
				lblBrack1.setVisible(true);
				lblBrack1.setBounds(10, 343, 43, 33);
				btnShowVectors.setVisible(true);
				lblBrack2.setVisible(true);
				lblBrack2.setBounds(291, 343, 43, 33);
				btnSave.setVisible(true);
				}
				if (rad3D.isSelected()) {
					rad1D.setEnabled(false);
					rad2D.setEnabled(false);
					rad3D.setEnabled(false);
				}
			}
		});
		
		/** 
		 * Save all vectors inputted
		 * */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				if (rad1D.isSelected() == true) {		
					if (radCartesian.isSelected()) {
							 double x = Double.parseDouble(txtCartx.getText());//if value cannot be parsed, a NumberFormatException will be thrown
								Vector vector = new Vector(x,0.0,0.0);
								vectors.add(vector);
					}
					if (radGeometric.isSelected()) {
						double angle = Double.NaN;
						
						if (radAng0.isSelected()) {
							angle = 0.0;
						}
						
						if (radAng180.isSelected()) {
							angle = 180;
						}

						 mag3.add( Double.parseDouble(txtGeoMag.getText()));
						Vector vectorGeo = new Vector();
						vectors.add(vectorGeo.convertGeometricToCartesian1D(mag3.get(vectorCount), angle));
					
						if (radAng0.isSelected() == false && radAng180.isSelected() == false) {
							JOptionPane.showMessageDialog(new Frame(), "Please Choose One Angle");
							vectors.remove(vectorCount);
							vectorCount--;
						}
					}
				}
				
				if (rad2D.isSelected() == true) {
					if (radCartesian.isSelected()) {
						try {
						double x = Double.parseDouble(txtCartx.getText());
						double y = Double.parseDouble(txtCarty.getText());
						Vector vector = new Vector(x,y,0.0);
						vectors.add(vector);
						}   catch ( NumberFormatException e1){
							JOptionPane.showMessageDialog(new Frame(), "Please Enter Numerical Values");   
				    	}
					}
					
					if (radGeometric.isSelected()) {
						mag3.add(Double.parseDouble(txtGeoMag.getText()));
						double angle = Double.parseDouble(txtGeo1.getText());
						Vector vectorGeo = new Vector();
						vectors.add(vectorGeo.convertGeometricToCartesian2D(mag3.get(vectorCount), angle));
					}
				}
					
				if (rad3D.isSelected() == true) {
					if (radCartesian.isSelected()) {
						double x = Double.parseDouble(txtCartx.getText());
						double y = Double.parseDouble(txtCarty.getText());
						double z = Double.parseDouble(txtCartz.getText());		
						Vector vector = new Vector(x,y,z);
						vectors.add(vector);
					}
					
					if (radGeometric.isSelected()) {
						mag3.add(Double.parseDouble(txtGeoMag.getText()));
						double angle1 = Double.parseDouble(txtGeo1.getText());
						double angle2 = Double.parseDouble(txtGeo2.getText());
						double angle3 = Double.parseDouble(txtGeo3.getText());
						Vector vectorGeo = new Vector();
						vectors.add(vectorGeo.convertGeometricToCartesian3D(mag3.get(vectorCount), angle1, angle2, angle3));
					}	
				}
					    }
			    catch ( NumberFormatException e1){
			    	JOptionPane.showMessageDialog(null,"Please Enter Numerical Values", "Error", 0);
			    	vectorCount--;
			    }
				radAng0.setSelected(false);
				radAng0.setEnabled(true);
				radAng180.setEnabled(true);
				radAng180.setSelected(false);
							
				vectorCount+=1;

				if (vectorCount == 0 ) {
					btnDone.setVisible(false);
				} else if (vectorCount > 0) {
					btnDone.setVisible(true);
				}
				txtGeoMag.setText("");
				txtCartx.setText("");
				txtCarty.setText("");
				txtCartz.setText("");
				txtGeo1.setText("");
				txtGeo2.setText("");
				txtGeo3.setText("");
			}
		});
	
		radDotProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		for (int i = 1; i <= vectorCount; i++) {
			cmbDot1.addItem("" + i);
			cmbDot2.addItem("" + i);
		}
		radDotProduct.setEnabled(false);
			}
			});
		
		radCrossProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i <= vectorCount; i++) {
					cmbCross1.addItem("" + i);
					cmbCross2.addItem("" + i);
				}
				radCrossProduct.setEnabled(false);
			}
			
			});
		
		btnDisplayOperations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vectorAns = new VectorCalculations(vectors);
				String type = "";
				
				if(rad1D.isSelected()) {
					type = "1D";
					if (radSumOfV.isSelected()) {
						if (radCartesian.isSelected()) {
							if(vectCount == 0) {
								txtSumOfV.setText(vectorAns.addVector().toString(type));
							} else if (vectCount >= 1) {
								txtSumOfV.setText(txtSumOfV.getText());
							}
							
						}
						
						if (radGeometric.isSelected()) {
							VectorCalculations vector1 = vectorAns.addVector();
							if (vectCount == 0) {
								txtSumOfV.setText(vectorAns.Geometric(vector1, type));
							} else if(vectCount >= 1) {
								txtSumOfV.setText(txtSumOfV.getText());
							}
						}
						
						
					}
									
					if(radDiffOfV.isSelected()) {
					
						if (radCartesian.isSelected()) {
						txtDiffOfV.setText(vectorAns.subVector().toString1(type));
						}
						
						if (radGeometric.isSelected()) {
							VectorCalculations vector1 = vectorAns.subVector();
							txtDiffOfV.setText(vectorAns.Geometric(vector1, type));
							}
						
						}
					}
			
				if(rad2D.isSelected()) {					
					type = "2D";				
					if (radSumOfV.isSelected()) {
						if (radCartesian.isSelected()) {
							if(vectCount == 0) {
								txtSumOfV.setText(vectorAns.addVector().toString(type));
							} else if (vectCount >= 1) {
								txtSumOfV.setText(txtSumOfV.getText());
						}
					}
						
						if (radGeometric.isSelected()) {
							VectorCalculations vector1 = vectorAns.addVector();
							if (vectCount == 0) {
								txtSumOfV.setText(vectorAns.Geometric(vector1, type));
							} else if(vectCount >= 1) {
								txtSumOfV.setText(txtSumOfV.getText());
							}
						}
						
					
					}
					if(radDiffOfV.isSelected()) {
						if(radCartesian.isSelected()) {
							txtDiffOfV.setText(vectorAns.subVector().toString1(type));
						}
						
						if (radGeometric.isSelected()) {
							VectorCalculations vector1 = vectorAns.subVector();
							txtDiffOfV.setText(vectorAns.Geometric(vector1, type));
							}
						
					}
					
					if (radDotProduct.isSelected()) {
						
						txtOperations.setText( "Dot Product: " + String.format("%.2f",(vectorAns.dotVector(vectors.get(Integer.valueOf((String) cmbDot1.getSelectedItem()) - 1), 
								vectors.get(Integer.valueOf((String) cmbDot2.getSelectedItem()) -1)))) + "\n");
						radDotProduct.setEnabled(false);
						
					}
				
				}
				
				if(rad3D.isSelected()) {
					
					
					
					type = "3D";
					
					if (radSumOfV.isSelected()) {
					
						if (radCartesian.isSelected()) {
						if(vectCount == 0) {
							txtSumOfV.setText(vectorAns.addVector().toString(type));
						} else if (vectCount >= 1) {
							txtSumOfV.setText(txtSumOfV.getText());
						}
						}
						
						if (radGeometric.isSelected()) {
							VectorCalculations vector1 = vectorAns.addVector();
							if (vectCount == 0) {
							txtSumOfV.setText(vectorAns.Geometric(vector1, type));
							} else if(vectCount >= 1) {
								txtSumOfV.setText(txtSumOfV.getText());
							}
						}
						
					}
						
					if(radDiffOfV.isSelected()) {
						if(radCartesian.isSelected()) {
						txtDiffOfV.setText(vectorAns.subVector().toString1(type));
						}
						
						if (radGeometric.isSelected()) {
							VectorCalculations vector1 = vectorAns.subVector();					
							txtDiffOfV.setText(vectorAns.Geometric(vector1, type));
						}
						
					}
					
					if (radDotProduct.isSelected()) {
						txtOperations.setText( "Dot Product: " 
								+ String.format("%.2f",(vectorAns.dotVector(vectors.get(Integer.valueOf((String) cmbDot1.getSelectedItem()) - 1)
								, vectors.get(Integer.valueOf((String) cmbDot2.getSelectedItem()) -1)))) + "\n");
						radDotProduct.setEnabled(false);
					}
					
					if (radCrossProduct.isSelected()) {
						if (radCartesian.isSelected()) {
						txtOperations.setText(txtOperations.getText() + "Cross Product: " 
								+ (vectorAns.crossProduct(vectors.get(Integer.valueOf((String) cmbCross1.getSelectedItem()) - 1)
								, vectors.get(Integer.valueOf((String) cmbCross2.getSelectedItem()) - 1))).toString2(type) + "\n");
						}
						if (radGeometric.isSelected()) {
							VectorCalculations vector1;	
							vector1 = vectorAns.crossProduct(vectors.get(Integer.valueOf((String) cmbCross1.getSelectedItem()) - 1)
									, vectors.get(Integer.valueOf((String) cmbCross2.getSelectedItem()) - 1));
							txtOperations.setText(txtOperations.getText() + "Cross Product: " 
									+ vectorAns.Geometric(vector1, type));
						}
						radCrossProduct.setEnabled(false);
					}
				}
				radSumOfV.setEnabled(false);
				radDiffOfV.setEnabled(false);
				
				
				vectCount+=1;
			}
		});
		
		/** 
		 * Display vector values
		 */
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = "";
				vectorAns = new VectorCalculations(vectors);
			
				
				if(radMag.isSelected()) {
					int index = Integer.valueOf((String) cmbMagnitude.getSelectedItem());			
					if (rad1D.isSelected() || rad2D.isSelected() || (rad3D.isSelected() && radCartesian.isSelected())) {
						
					double answer = VectorCalculations.magnitude(vectors.get(index-1));					
					txtValues.setText("Magnitude: " + String.format("%.2f", answer) + "\n");
					}
					if (rad3D.isSelected() && radGeometric.isSelected()) {
						double answer3 = mag3.get(index -1);
						txtValues.setText("Magnitude: " + String.format("%.2f", answer3) + "\n");
					}
					radMag.setEnabled(false);
				}
				
				if(radUnit.isSelected()) {
					int index = Integer.valueOf((String) cmbUnit.getSelectedItem()) - 1;
					if (rad1D.isSelected()) {
						type = "1D";
						if(radCartesian.isSelected()) {
						txtValues.setText(txtValues.getText() + "Unit Vector: " + 
						(vectorAns.unitVector(vectors.get(index)).toString3(type)) + "\n");
						}
						if (radGeometric.isSelected()) {
							VectorCalculations vector1;
							vector1 = vectorAns.unitVector(vectors.get(index));
							
							txtValues.setText(txtValues.getText() + "Unit Vector: " + vectorAns.Geometric(vector1, type) + "\n");
						}
					}
					
					if (rad2D.isSelected()) {
						type = "2D";
						if (radCartesian.isSelected()) {
						txtValues.setText(txtValues.getText() + "Unit Vector: " + 
						(vectorAns.unitVector(vectors.get(index)).toString3(type)) + "\n");
						}
						if (radGeometric.isSelected()) {
							VectorCalculations vector1;
							vector1 = vectorAns.unitVector(vectors.get(index));
							
							txtValues.setText(txtValues.getText() + "Unit Vector: " + vectorAns.Geometric(vector1, type) + "\n");
						}
					}
					
					if (rad3D.isSelected()) {
						type = "3D";
						if(radCartesian.isSelected()) {
						txtValues.setText(txtValues.getText() + "Unit Vector: " + 
						(vectorAns.unitVector(vectors.get(index)).toString3(type)) + "\n");
						}
						if (radGeometric.isSelected()) {
							VectorCalculations vector1;
							vector1 = vectorAns.unitVector(vectors.get(index));
							
							txtValues.setText(txtValues.getText() + "Unit Vector: " + vectorAns.Geometric(vector1, type) + "\n");
						}
					}
					radUnit.setEnabled(false);
				}
				
				if (radAng.isSelected()) {
					int index = Integer.valueOf((String) cmbAngle1.getSelectedItem()) - 1;
					int index2 = Integer.valueOf((String) cmbAngle2.getSelectedItem()) - 1;
					txtValues.setText(txtValues.getText() + "Angle Between: " + 
					String.format("%.2f", (vectorAns.angleBetween(vectors.get(index), 
							vectors.get(index2)))) + "\u00b0" + "\n");
					radAng.setEnabled(false);
				}

				if (radProj.isSelected()) {
					int index = Integer.valueOf((String) cmbProj1.getSelectedItem()) - 1;
					int index2 = Integer.valueOf((String) cmbProj2.getSelectedItem()) - 1;
					double proj = vectorAns.projection(vectors.get(index), vectors.get(index2));
					if (Double.isNaN(proj)) {
						txtValues.setText(txtValues.getText() + "Projection: Not Possible" + "\n");
					} else {
						txtValues.setText(txtValues.getText() + "Projection: " + 
								String.format("%.2f", (vectorAns.projection(vectors.get(index), 
								vectors.get(index2)))) + " Of Vector " + (index2+1) +"\n");
					}
					radProj.setEnabled(false);
				}
				
				
				
				
			}
		});
		
		/** 
		 * Make all buttons and text areas uneditable
		 */
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if (vectorCount <= 1) {
					JOptionPane.showMessageDialog(null,"Please Enter More Than One Vector", "Error", 0);
				}
				else {
					btnSave.setEnabled(false);
					btnDisplay.setEnabled(true);
					btnDisplayOperations.setEnabled(true);
					txtGeoMag.setEditable(false);
					txtCartx.setEditable(false);
					txtCarty.setEditable(false);
					txtCartz.setEditable(false);
					txtGeo1.setEditable(false);
					txtGeo2.setEditable(false);
					txtGeo3.setEditable(false);
					btnDone.setEnabled(false);
					setBounds(100, 100, 1070, 617);
					}	
				}
			});
		
		/** 
		 * Display vectors on new form
		 */
		btnShowVectors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String type = "";
				String type2 = "";
				
				if (radCartesian.isSelected()) {
					type2 = "Cartesian";
				}
				
				if (radGeometric.isSelected()) {
					type2 = "Geometric";
				}
				
				if (rad1D.isSelected()) {
					type = "1D";
				}
				if (rad2D.isSelected()) {
					type = "2D";
				}
				
				if (rad3D.isSelected()) {
					type = "3D";
				}
				ShowVectors vects = new ShowVectors(vectors, type, type2, mag3);
				vects.setVisible(true);
				}
			});
		
		/** 
		 * Clear text in magnitude/component text areas
		 */
		mnuClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtGeoMag.setText("");
				txtCartx.setText("");
				txtCarty.setText("");
				txtCartz.setText("");
				radAng0.setSelected(false);
				radAng180.setSelected(false);
				}
			});
		}
	}



