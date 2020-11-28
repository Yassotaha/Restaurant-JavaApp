package ecran;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fonctionnalite.CommandeEnCours;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class E_cuisine extends JFrame {

	private JPanel contentPane;
	private static JTextArea textArea;
	private static JTextArea textArea_1;
	private static JTextArea textArea_2;
	private static JTextArea textArea_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					E_cuisine frame = new E_cuisine();
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
	
	public E_cuisine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 100, 901, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 885, 488);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btnPret1 = new JButton("Pret");
		btnPret1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				CommandeEnCours.btnPret("Table 1");
			}
		});
		btnPret1.setBounds(78, 454, 89, 23);
		panel.add(btnPret1);
		
		JButton btnPret2 = new JButton("Pret");
		btnPret2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("");
				CommandeEnCours.btnPret("Table 2");
			}
		});
		btnPret2.setBounds(295, 454, 89, 23);
		panel.add(btnPret2);
		
		JButton btnPret3 = new JButton("Pret");
		btnPret3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_2.setText("");
				CommandeEnCours.btnPret("Table 3");
			}
		});
		btnPret3.setBounds(507, 454, 89, 23);
		panel.add(btnPret3);
		
		JButton btnPret4 = new JButton("Pret");
		btnPret4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_3.setText("");
				CommandeEnCours.btnPret("Table 4");
			}
		});
		btnPret4.setBounds(719, 454, 89, 23);
		panel.add(btnPret4);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 208, 436);
		panel.add(scrollPane_3);
		
		 setTextArea(new JTextArea());
		 scrollPane_3.setViewportView(getTextArea());
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(238, 12, 204, 431);
		panel.add(scrollPane_2);
		
		 setTextArea_1(new JTextArea());
		scrollPane_2.setViewportView(getTextArea_1());
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(452, 12, 204, 431);
		panel.add(scrollPane_1);
		
		setTextArea_2(new JTextArea());
		scrollPane_1.setViewportView(getTextArea_2());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(671, 12, 204, 431);
		panel.add(scrollPane);
		
		 setTextArea_3(new JTextArea());
		scrollPane.setViewportView(getTextArea_3());
	}

	public static JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public static JTextArea getTextArea_1() {
		return textArea_1;
	}

	public static void setTextArea_1(JTextArea textArea_1) {
		E_cuisine.textArea_1 = textArea_1;
	}

	public static JTextArea getTextArea_2() {
		return textArea_2;
	}

	public static void setTextArea_2(JTextArea textArea_2) {
		E_cuisine.textArea_2 = textArea_2;
	}

	public static JTextArea getTextArea_3() {
		return textArea_3;
	}

	public static void setTextArea_3(JTextArea textArea_3) {
		E_cuisine.textArea_3 = textArea_3;
	}
}
