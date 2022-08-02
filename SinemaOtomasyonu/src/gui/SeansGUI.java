package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Seans;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SeansGUI extends JFrame {
	private DefaultTableModel SeansModel = null;
	private Object[] SeansDatabase = null;
	private JPanel contentPane;
	private JTable seansTablosu;
	Seans seans = new Seans();
	static Seans seans1 = new Seans();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeansGUI frame = new SeansGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public SeansGUI() throws SQLException {
		setTitle("SINEMA OTOMASYONU");

		SeansModel = new DefaultTableModel();
		Object[] FilmlerSatýrý = new Object[5];
		FilmlerSatýrý[0] = "Salonu";
		FilmlerSatýrý[1] = "Tarihi";
		FilmlerSatýrý[2] = "Baþlama Saati ";
		FilmlerSatýrý[3] = "Bitiþ Saati  ";
		FilmlerSatýrý[4] = "Ucreti";

		SeansModel.setColumnIdentifiers(FilmlerSatýrý);
		SeansDatabase = new Object[5];
		for (int i = 0; i < seans1.SeansListesi().size(); i++) {
			SeansDatabase[0] = seans1.SeansListesi().get(i).getSalon();
			SeansDatabase[1] = seans1.SeansListesi().get(i).getTarih();
			SeansDatabase[2] = seans1.SeansListesi().get(i).getBaslamaSaati();
			SeansDatabase[3] = seans1.SeansListesi().get(i).getBitisSaati();
			SeansDatabase[4] = seans1.SeansListesi().get(i).getUcret();
			
			SeansModel.addRow(SeansDatabase);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 22, 595, 291);
		contentPane.add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("FÝLMLER", null, scrollPane, null);

		seansTablosu = new JTable(SeansModel);
		scrollPane.setViewportView(seansTablosu);

		JButton geriDon = new JButton("Geri DON");
		geriDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MüsteriGUI frame = new MüsteriGUI(null);
				frame.setVisible(true);
				dispose();
			}
		});
		geriDon.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		geriDon.setBounds(10, 324, 175, 38);
		contentPane.add(geriDon);

		JButton biletAl = new JButton("BILET AL");
		biletAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BiletAlGUI bGUI = new BiletAlGUI();
				bGUI = new BiletAlGUI();
				bGUI.setVisible(true);
				dispose();
			}
		});
		biletAl.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		biletAl.setBounds(396, 324, 208, 38);
		contentPane.add(biletAl);
	}
}
