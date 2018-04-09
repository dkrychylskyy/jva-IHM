package toto.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class IHM {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				final IHM window = new IHM();
				window.frame.setVisible(true);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		});
	}

	private JFrame frame;
	private JButton btnSave;
	private JButton btnLoad;
	private JTextField textPrenom;
	private JTextField textNom;
	private JTextArea textEleves;
	private JLabel lblEleves;
	private JLabel lblPrenomLabel;
	private JLabel lblNomLabel;
	private JLabel lblMessageLabel;

	// Text test pour btnLoad
	private String textTest = "My text";

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public IHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, -45, 450, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnSave = new JButton("Save");

		// btnSave Action
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nom = textNom.getText();
				String prenom = textPrenom.getText();
				// On apple le methode save depuis le contoler
				// c.save(nom, prenom);
				updateNP(nom, prenom);
			}
		});
		btnSave.setBounds(161, 125, 97, 25);
		frame.getContentPane().add(btnSave);

		textPrenom = new JTextField();
		textPrenom.setBounds(12, 90, 177, 22);
		frame.getContentPane().add(textPrenom);
		textPrenom.setColumns(10);

		lblPrenomLabel = new JLabel("Prenom");
		lblPrenomLabel.setBounds(12, 70, 56, 16);
		frame.getContentPane().add(lblPrenomLabel);

		textNom = new JTextField();
		textNom.setBounds(230, 90, 177, 22);
		frame.getContentPane().add(textNom);
		textNom.setColumns(10);

		lblNomLabel = new JLabel("Nom");
		lblNomLabel.setBounds(230, 70, 56, 16);
		frame.getContentPane().add(lblNomLabel);

		lblEleves = new JLabel("Eleves");
		lblEleves.setBounds(12, 158, 56, 16);
		frame.getContentPane().add(lblEleves);

		textEleves = new JTextArea();
		textEleves.setBounds(12, 176, 395, 197);
		frame.getContentPane().add(textEleves);

		btnLoad = new JButton("Load");

		// btnLoad Action
		btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateList(textTest);
			}
		});
		btnLoad.setBounds(161, 386, 97, 25);
		frame.getContentPane().add(btnLoad);

		lblMessageLabel = new JLabel("");
		lblMessageLabel.setBounds(12, 13, 395, 44);
		frame.getContentPane().add(lblMessageLabel);

		// Test methode updateErreur
		updateErreur(textTest);
	}

	// Mes methodes
	public void updateErreur(String e) {
		lblMessageLabel.setText(e);
	}

	public void updateList(String list) {
		textEleves.setText(list);
	}

	public void updateNP(String nom, String prenom) {

	}
}
