package AlgoActivity;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class floydwarshallAlgorithmActivityUI extends JFrame {
	
	private static int matrixSize;
	private static int lastMatrixSize;
	
	private JPanel contentPane;
	private static int result;
	private JTextField MatrixSizetextField;
	private static JTextField inputField [][]; 
	private static double myMatrix [][];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					floydwarshallAlgorithmActivityUI frame = new floydwarshallAlgorithmActivityUI();
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
	public floydwarshallAlgorithmActivityUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatrixSize = new JLabel("matrix size");
		lblMatrixSize.setBounds(95, 111, 81, 14);
		contentPane.add(lblMatrixSize);
		
		MatrixSizetextField = new JTextField(10);
		MatrixSizetextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {					
					matrixSize = Integer.parseInt(MatrixSizetextField.getText());
					if(matrixSize < 3 || matrixSize > 5) {
						JOptionPane.showMessageDialog(null,"MINIMUM (3) AND MAXIMUM (5)"
								,null, JOptionPane.OK_CANCEL_OPTION);
					}else {
						lastMatrixSize = matrixSize;
						
						myMatrix = new double[lastMatrixSize][lastMatrixSize];
						setElements(myMatrix,"Fill the  Matrix");
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"IT SHOULD BE POSITIVE INTEGERS"
							,null, JOptionPane.OK_CANCEL_OPTION);
				}
			}
		});
		MatrixSizetextField.setBounds(186, 108, 96, 20);
		contentPane.add(MatrixSizetextField);
		MatrixSizetextField.setColumns(10);
	}

	protected void setElements(double[][] matrix, String title) {
		
		 int temp, temp1;        
	     String tempString;
		
		 JPanel choosePanel[] = new JPanel[matrix.length+2];
	     choosePanel[0] = new JPanel();
	     choosePanel[0].add(new Label(title));
	     choosePanel[choosePanel.length-1] = new JPanel();
	     choosePanel[choosePanel.length-1].add(new Label("consider space field as zeros & INF = 999999"));
	     inputField  = new JTextField [matrix.length][matrix[0].length];
	     
	     for(temp = 1; temp <= matrix.length; temp++)
	       {
	           choosePanel[temp] = new JPanel();
	           
	           
	           for(temp1 = 0; temp1 < matrix[0].length; temp1++)
	           {
	               inputField [temp-1][temp1] = new JTextField(3);
	               choosePanel[temp].add(inputField [temp-1][temp1]);
	               
	               if(temp1 < matrix[0].length -1)
	               {
	               choosePanel[temp].add(Box.createHorizontalStrut(15)); // a spacer
	               }
	               
	           }
	           
	       }
	     
	     result = JOptionPane.showConfirmDialog(null, choosePanel, 
	               null, JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
	     
	     System.out.println(result);
	}
}
