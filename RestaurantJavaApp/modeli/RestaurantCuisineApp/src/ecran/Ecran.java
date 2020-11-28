package ecran;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import fonctionnalite.BaseDeDonnees;
import fonctionnalite.CommandeEnCours;
import fonctionnalite.DescriptionPlat;
import fonctionnalite.Facture;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JSpinner;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;


public class Ecran extends JFrame {

	private static JLabel lblTotal;
	private static JLabel lblTemoinPaye;
	private JPanel contentPane;
	private static JTextField id_textField;
	private static JPasswordField passwordField;
	private static JSpinner spinner;
	private static int temoinS = 1;
	private static String userSwitch = "employee";
	private static DefaultListModel dm = new DefaultListModel();
	private static JList list_1 = new JList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ecran frame = new Ecran();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private static JTextField idField;
	private static JTextField passField;
	private JTextField ageField;
	private static JTable employer_table;
	private static JTextField titreField;
	private static JComboBox comboBox;
	private static JComboBox comboBox_1;
	private static JTextField textFieldMontant;
	private static JTable table_vente;
	public static String getId_textField() {	
		return id_textField.getText();
		
	}
	public static String getPasswordField() {
		return passwordField.getText();
	}
	public static String getUserSwitch() {
		return userSwitch;
	}
	public static void setUserSwitch(String userSwitch) {
		Ecran.userSwitch = userSwitch;
	}
	/**
	 * Create the frame.
	 */
	public Ecran() {
		connection = BaseDeDonnees.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//----------------------------------------------------------------------
		JPanel ecran_serveur = new JPanel();
		ecran_serveur.setBackground(Color.LIGHT_GRAY);
		ecran_serveur.setBounds(0, 0, 901, 505);
		contentPane.add(ecran_serveur);
		ecran_serveur.setLayout(null);
		ecran_serveur.setVisible(false);
		E_cuisine frame = new E_cuisine();
		frame.setVisible(true);
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDeDonnees.enregistrer_vente();
				CommandeEnCours.afficher_ecran_cuisine();
				Facture.supprimer_enreg();
				}
		});
		btnEnregistrer.setBackground(Color.WHITE);
		btnEnregistrer.setBounds(6, 409, 112, 41);
		ecran_serveur.add(btnEnregistrer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm.isEmpty() || list_1.isSelectionEmpty()) {
					
				}else {
				Facture.supprimer_element();
				}
			}
		});
		btnSupprimer.setBackground(Color.WHITE);
		btnSupprimer.setBounds(119, 409, 112, 41);
		ecran_serveur.add(btnSupprimer);
		 setLblTotal(new JLabel("Total :"));
		getLblTotal().setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		getLblTotal().setBounds(16, 381, 194, 16);
		ecran_serveur.add(getLblTotal());
		
		JPanel panel_paimant = new JPanel();
		panel_paimant.setBounds(243, 14, 457, 474);
		ecran_serveur.add(panel_paimant);
		panel_paimant.setLayout(null);
		panel_paimant.setVisible(false);
		
		lblTemoinPaye = new JLabel("Paiment...");
		lblTemoinPaye.setBounds(36, 321, 314, 34);
		panel_paimant.add(lblTemoinPaye);
		
		textFieldMontant = new JTextField();
		textFieldMontant.setBounds(228, 160, 203, 34);
		panel_paimant.add(textFieldMontant);
		textFieldMontant.setColumns(10);
		
		JButton btnPayer_1 = new JButton("Payer");
		btnPayer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommandeEnCours.payer_commande();
			}
		});
		btnPayer_1.setBounds(342, 208, 89, 23);
		panel_paimant.add(btnPayer_1);
		

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(Color.GRAY));
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(239, 6, 461, 493);
		ecran_serveur.add(tabbedPane);
		
		JButton btnPayer = new JButton("Payer");
		btnPayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_paimant.setVisible(true);
				tabbedPane.setVisible(false);
			}
		});
		btnPayer.setBackground(Color.WHITE);
		btnPayer.setBounds(6, 447, 225, 41);
		ecran_serveur.add(btnPayer);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setVisible(true);
				panel_paimant.setVisible(false);
			}
		});
		btnMenu.setBackground(Color.WHITE);
		btnMenu.setBounds(342, 397, 89, 23);
		panel_paimant.add(btnMenu);
		
		JPanel nouvelle_commande = new JPanel();
		nouvelle_commande.setForeground(new Color(0, 0, 0));
		nouvelle_commande.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Nouvelle commande", null, nouvelle_commande, null);
		nouvelle_commande.setLayout(null);
		
		JTabbedPane tabbedPane_nCommande = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_nCommande.setBorder(new LineBorder(Color.GRAY));
		tabbedPane_nCommande.setBackground(Color.LIGHT_GRAY);
		tabbedPane_nCommande.setBounds(0, 22, 456, 396);
		nouvelle_commande.add(tabbedPane_nCommande);
		
		JPanel boisson = new JPanel();
		boisson.setBackground(Color.LIGHT_GRAY);
		tabbedPane_nCommande.addTab("Boisson", null, boisson, null);
		boisson.setLayout(null);
		
		JButton btnBissap = new JButton("Bissap");
		btnBissap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionPlat bissap = new DescriptionPlat("Bissap", 5.0);
				Facture.afficher_description(bissap.getNom(),bissap.getPrix());
			}
		});
		btnBissap.setBounds(19, 45, 126, 40);
		boisson.add(btnBissap);
		
		JButton btnGrenadia = new JButton("Grenadia");
		btnGrenadia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionPlat grenadia = new DescriptionPlat("Grenadia", 5.0);
				Facture.afficher_description(grenadia.getNom(),grenadia.getPrix());
			}
		});
		btnGrenadia.setBounds(19, 113, 126, 40);
		boisson.add(btnGrenadia);
		
		JButton btnCassimango = new JButton("Cassimango");
		btnCassimango.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionPlat cassimango = new DescriptionPlat("Cassimango", 5.0);
				Facture.afficher_description(cassimango.getNom(),cassimango.getPrix());
			}
		});
		btnCassimango.setBounds(19, 254, 126, 40);
		boisson.add(btnCassimango);
		
		JButton btnGnanmankoudji = new JButton("Gnanmankoudji");
		btnGnanmankoudji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionPlat gnamankoudji = new DescriptionPlat("Gnamankoudji", 5.0);
				Facture.afficher_description(gnamankoudji.getNom(),gnamankoudji.getPrix());
			}
		});
		btnGnanmankoudji.setBounds(19, 184, 126, 40);
		boisson.add(btnGnanmankoudji);
		
		JPanel plat = new JPanel();
		plat.setBackground(Color.LIGHT_GRAY);
		tabbedPane_nCommande.addTab("Plat", null, plat, null);
		plat.setLayout(null);
		
		JButton btnGriot = new JButton("Griot");
		btnGriot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionPlat griot = new DescriptionPlat("Griot", 14.0);
				Facture.afficher_description(griot.getNom(),griot.getPrix());
			}
		});
		btnGriot.setBounds(20, 255, 128, 45);
		plat.add(btnGriot);
		
		JButton btnCouscous = new JButton("Tajines");
		btnCouscous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionPlat tajines = new DescriptionPlat("Tajines", 10.0);
				Facture.afficher_description(tajines.getNom(),tajines.getPrix());
			}
		});
		btnCouscous.setBounds(20, 39, 128, 45);
		plat.add(btnCouscous);
		
		JButton btnAttike = new JButton("Attiéke");
		btnAttike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionPlat attieke = new DescriptionPlat("Attiéke", 11.0);
				Facture.afficher_description(attieke.getNom(),attieke.getPrix());
			}
		});
		btnAttike.setBounds(251, 39, 128, 45);
		plat.add(btnAttike);
		
		JButton btnTchep = new JButton("Tchep");
		btnTchep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionPlat tchep = new DescriptionPlat("Tchep", 14.0);
				Facture.afficher_description(tchep.getNom(),tchep.getPrix());
			}
		});
		btnTchep.setBounds(251, 149, 128, 45);
		plat.add(btnTchep);
		
		JButton btnNdol = new JButton("N'dolé");
		btnNdol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionPlat ndole = new DescriptionPlat("N'dolé", 13.0);
				Facture.afficher_description(ndole.getNom(),ndole.getPrix());
			}
		});
		btnNdol.setBounds(20, 149, 128, 45);
		plat.add(btnNdol);
		
		JButton btnPastilla = new JButton("Pastilla");
		btnPastilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionPlat pastilla = new DescriptionPlat("Pastilla", 12.0);
				Facture.afficher_description(pastilla.getNom(),pastilla.getPrix());
			}
		});
		btnPastilla.setBounds(251, 255, 128, 45);
		plat.add(btnPastilla);
		
		JLabel lblQuantite = new JLabel("Quantite :");
		lblQuantite.setBounds(288, 6, 71, 16);
		nouvelle_commande.add(lblQuantite);
		
		 spinner = new JSpinner();
		spinner.setBounds(365, 1, 50, 26);
		nouvelle_commande.add(spinner);
		spinner.setValue(1);
		
		setComboBox(new JComboBox());
		
		getComboBox().addItem("Table 1");
		getComboBox().addItem("Table 2");
		getComboBox().addItem("Table 3");
		getComboBox().addItem("Table 4");
		getComboBox().setBounds(106, 3, 151, 22);
		nouvelle_commande.add(getComboBox());
		
		JLabel lblTable_1 = new JLabel("Table :");
		lblTable_1.setBounds(38, 6, 56, 16);
		nouvelle_commande.add(lblTable_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 14, 234, 365);
		ecran_serveur.add(scrollPane);
		
		list_1 = new JList();
		scrollPane.setViewportView(getList_1());
		
		setComboBox_1(new JComboBox());
		getComboBox_1().setBounds(712, 168, 152, 22);
		ecran_serveur.add(getComboBox_1());
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommandeEnCours.rechercher_commande();
			}
		});
		btnRechercher.setBackground(Color.WHITE);
		btnRechercher.setBounds(729, 212, 130, 25);
		ecran_serveur.add(btnRechercher);
		

		getList_1().setModel(getDm());
				
				
				
				
				setEmployer_table(new JTable());
				setIdField(new JTextField());
				getIdField().setBounds(97, 89, 86, 20);
				getIdField().setColumns(10);
				
				setPassField(new JTextField());
				getPassField().setBounds(97, 114, 86, 20);
				getPassField().setColumns(10);
				
				setTitreField(new JTextField());
				getTitreField().setBounds(97, 139, 86, 20);
				getTitreField().setColumns(10);
		

		//----------------------------------------------------------------------
		
		JPanel ecran_admin = new JPanel();
		ecran_admin.setBackground(Color.LIGHT_GRAY);
		ecran_admin.setBounds(0, 0, 901, 505);
		contentPane.add(ecran_admin);
		ecran_admin.setLayout(null);
		
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBackground(Color.LIGHT_GRAY);
		tabbedPane_3.setBounds(0, 0, 891, 452);
		ecran_admin.add(tabbedPane_3);
		
		JPanel vente = new JPanel();
		vente.setBackground(Color.LIGHT_GRAY);
		tabbedPane_3.addTab("Vente", null, vente, null);
		vente.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(242, 23, 549, 338);
		vente.add(scrollPane_2);
		
		setTable_vente(new JTable());
		scrollPane_2.setViewportView(getTable_vente());
		
		JButton btnReinitialiser = new JButton("Reinitialiser");
		btnReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDeDonnees.reinit_vente();
			}
		});
		btnReinitialiser.setBounds(243, 368, 129, 25);
		vente.add(btnReinitialiser);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BaseDeDonnees.loadTableVente();
			}
		});
		btnAfficher.setBounds(696, 368, 97, 25);
		vente.add(btnAfficher);
		
		JPanel employer = new JPanel();
		
				employer.setBackground(Color.LIGHT_GRAY);
				tabbedPane_3.addTab("Employer", null, employer, null);
				employer.setLayout(null);
				employer.add(getTitreField());
				
				JLabel lblIdentifiant = new JLabel("Identifiant");
				lblIdentifiant.setBounds(10, 92, 59, 14);
				employer.add(lblIdentifiant);
				
				JLabel lblMotsDePasse_1 = new JLabel("Mots de passe");
				lblMotsDePasse_1.setBounds(10, 117, 89, 14);
				employer.add(lblMotsDePasse_1);
				employer.add(getIdField());
				employer.add(getPassField());
				
				JLabel lblTitre = new JLabel("Titre");
				lblTitre.setBounds(10, 142, 46, 14);
				employer.add(lblTitre);
				
				
				JButton btnEnregistrer_psn = new JButton("Enregistrer");
				btnEnregistrer_psn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BaseDeDonnees.enregistrer_employer();
						BaseDeDonnees.loadTable();
					}
				});
				btnEnregistrer_psn.setBackground(Color.WHITE);
				btnEnregistrer_psn.setBounds(76, 193, 107, 23);
				employer.add(btnEnregistrer_psn);
				
				
				JButton btnSupprimer_psn = new JButton("Supprimer");
				btnSupprimer_psn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BaseDeDonnees.supprimer_employer();
						BaseDeDonnees.loadTable();
					}
				});
				btnSupprimer_psn.setBackground(Color.WHITE);
				btnSupprimer_psn.setBounds(76, 227, 107, 23);
				employer.add(btnSupprimer_psn);
				
				
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(219, 58, 590, 292);
				employer.add(scrollPane_1);
				scrollPane_1.setViewportView(getEmployer_table());
				
				JButton btnLoad = new JButton("Afficher");
				btnLoad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BaseDeDonnees.loadTable();

					}
				});
				btnLoad.setBounds(698, 367, 89, 23);
				employer.add(btnLoad);
				
				
				JButton btnCommande = new JButton("Commande");
				btnCommande.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ecran_serveur.setVisible(true);
						ecran_admin.setVisible(false);
					}
				});
				btnCommande.setBounds(713, 459, 122, 23);
				ecran_admin.add(btnCommande);
				ecran_admin.setVisible(false);
				
		
		
		//----------------------------------------------------------------------
		JPanel ecran_de_connexion = new JPanel();
		ecran_de_connexion.setBounds(0, 0, 901, 505);
		contentPane.add(ecran_de_connexion);
		ecran_de_connexion.setLayout(null);
		
		
		JButton btnDeconnection_adm = new JButton("Deconnection");
		btnDeconnection_adm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecran_admin.setVisible(false);
				ecran_de_connexion.setVisible(true);
			}
		});
		btnDeconnection_adm.setBounds(10, 459, 116, 23);
		ecran_admin.add(btnDeconnection_adm);
		
		JButton btnDeconnectionSvr = new JButton("Deconnection");
		btnDeconnectionSvr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecran_serveur.setVisible(false);
				ecran_de_connexion.setVisible(true);
			}
		});
		btnDeconnectionSvr.setBounds(703, 456, 174, 23);
		ecran_serveur.add(btnDeconnectionSvr);
		
		JLabel lblCommandePret = new JLabel("Commandes prets:");
		lblCommandePret.setBounds(741, 126, 112, 25);
		ecran_serveur.add(lblCommandePret);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(238, 238, 238));
		panel.setBounds(314, 39, 268, 419);
		ecran_de_connexion.add(panel);
		panel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(62, 34, 145, 145);
		logo.setIcon(new ImageIcon(Ecran.class.getResource("/logo.png")));
		panel.add(logo);
		
		id_textField = new JTextField();
		id_textField.setBounds(16, 225, 237, 29);	
		panel.add(id_textField);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(16, 286, 237, 29);
		panel.add(passwordField);
		
		JButton btnConnection = new JButton("Se connecter");
		btnConnection.setBackground(Color.LIGHT_GRAY);
		btnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDeDonnees.verifier_connection();
				if (BaseDeDonnees.getverif() == 1) {
					if (userSwitch == "employee") {
					ecran_de_connexion.setVisible(false);
					ecran_serveur.setVisible(true);
					}else if(userSwitch == "employeur") {
						ecran_de_connexion.setVisible(false);
						ecran_admin.setVisible(true);
					}
				}
			}
		});
		btnConnection.setBounds(76, 327, 117, 29);
		panel.add(btnConnection);
		
		JLabel lblId = new JLabel("Identification :");
		lblId.setBounds(24, 207, 104, 16);
		panel.add(lblId);
		
		JLabel lblMotsDePasse = new JLabel("Mots de passe :");
		lblMotsDePasse.setBounds(26, 269, 102, 16);
		panel.add(lblMotsDePasse);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(184, 177, 69, 23);
		panel.add(btnAdmin);
		btnAdmin.setBackground(Color.LIGHT_GRAY);
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 10));
		JPanel temoin = new JPanel();
		temoin.setBackground(Color.RED);
		temoin.setBounds(184, 177, 69, 25);
		panel.add(temoin);
		temoin.setVisible(false);
		
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(temoinS == 1) {
					temoinS = 2;
					setUserSwitch("employeur");
					temoin.setVisible(true);
				}else if(temoinS == 2) {
					temoinS = 1;
					temoin.setVisible(false);
					setUserSwitch("employee");
				}
			}
		});
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 901, 505);
		background.setIcon(new ImageIcon(Ecran.class.getResource("/background.jpg")));
		ecran_de_connexion.add(background);
		
	}
	public static JLabel getLblTemoinPaye() {
		return lblTemoinPaye;
	}
	public static void setLblTemoinPaye(JLabel lblTemoinPaye) {
		Ecran.lblTemoinPaye = lblTemoinPaye;
	}
	public static JTextField getTextFieldMontant() {
		return textFieldMontant;
	}
	public void setTextFieldMontant(JTextField textFieldMontant) {
		this.textFieldMontant = textFieldMontant;
	}
	public static DefaultListModel getDm() {
		return dm;
	}
	public void setDm(DefaultListModel dm) {
		this.dm = dm;
	}
	public static int getQtt() {
		return (int) spinner.getValue();
	}
	public static JLabel getLblTotal() {
		return lblTotal;
	}
	public static void setLblTotal(JLabel lblTotal) {
		Ecran.lblTotal = lblTotal;
	}
	public static JList getList_1() {
		return list_1;
	}
	public static JTable getEmployer_table() {
		return employer_table;
	}
	public void setEmployer_table(JTable employer_table) {
		this.employer_table = employer_table;
	}
	public static JTextField getIdField() {
		return idField;
	}
	public void setIdField(JTextField idField) {
		this.idField = idField;
	}
	public static JTextField getPassField() {
		return passField;
	}
	public void setPassField(JTextField passField) {
		this.passField = passField;
	}
	public static JTextField getTitreField() {
		return titreField;
	}
	public void setTitreField(JTextField titreField) {
		this.titreField = titreField;
	}
	public static JComboBox getComboBox() {
		return comboBox;
	}
	public static void setComboBox(JComboBox comboBox) {
		Ecran.comboBox = comboBox;
	}
	public static JComboBox getComboBox_1() {
		return comboBox_1;
	}
	public static void setComboBox_1(JComboBox comboBox_1) {
		Ecran.comboBox_1 = comboBox_1;
	}
	public static JTable getTable_vente() {
		return table_vente;
	}
	public void setTable_vente(JTable table_vente) {
		this.table_vente = table_vente;
	}
}
