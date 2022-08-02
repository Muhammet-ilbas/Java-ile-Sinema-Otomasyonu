package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Seans;
import Yardýmcýlar.yardýmcý;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BiletAlGUI extends JFrame {

	private JPanel contentPane;

	Seans seans = new Seans();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BiletAlGUI frame = new BiletAlGUI();
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
	public BiletAlGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 376);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox filmAdý = new JComboBox();
		filmAdý.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		filmAdý.setBounds(95, 57, 291, 22);
		contentPane.add(filmAdý);
		filmAdý.addItem("SÝZ HÝÇ ATEÞ BÖCEÐÝ GÖRDÜNÜZ MÜ");
		filmAdý.addItem("FAST AND FURÝOUTS");
		filmAdý.addItem("SAW(TESTERE");

		JLabel lblNewLabel = new JLabel("F\u0130LM ADI");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 56, 97, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u00DCCRET\u0130");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 100, 75, 22);
		contentPane.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 104, 107, 22);
		contentPane.add(comboBox);
		comboBox.addItem("10");
		comboBox.addItem("15");
		comboBox.addItem("20");

		JLabel lblNewLabel_2 = new JLabel("\u00D6DEME");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 173, 75, 22);
		contentPane.add(lblNewLabel_2);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(95, 177, 117, 22);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("kredi");
		comboBox_1.addItem("kredi kartý");

		JButton btnNewButton = new JButton("B\u0130LET\u0130 AL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yardýmcý.mesaj("Biletiniz Onaylanmýþtýr. ÝYÝ SEYÝRLER!");
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnNewButton.setBounds(273, 292, 225, 38);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Geri Don");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SeansGUI sGUI1 = new SeansGUI();
					sGUI1.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(10, 292, 216, 41);
		contentPane.add(btnNewButton_1);

	}
}
