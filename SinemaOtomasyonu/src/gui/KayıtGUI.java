package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.M�steri;
import Yard�mc�lar.yard�mc�;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Kay�tGUI extends JFrame {

	private JPanel contentPane;
	private JTextField kullaniciAdi;
	private JPasswordField m�steriSifre;
	private JTextField m�steriAd�;
	private M�steri m�steri = new M�steri();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kay�tGUI frame = new Kay�tGUI();
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
	public Kay�tGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 11, 96, 14);
		contentPane.add(lblNewLabel);

		kullaniciAdi = new JTextField();
		kullaniciAdi.setBounds(10, 36, 153, 26);
		contentPane.add(kullaniciAdi);
		kullaniciAdi.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 67, 153, 20);
		contentPane.add(lblNewLabel_1);

		m�steriSifre = new JPasswordField();
		m�steriSifre.setBounds(10, 92, 153, 26);
		contentPane.add(m�steriSifre);

		JLabel lblNewLabel_2 = new JLabel("Ad\u0131 Soyad\u0131");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 129, 153, 14);
		contentPane.add(lblNewLabel_2);

		m�steriAd� = new JTextField();
		m�steriAd�.setBounds(10, 154, 153, 20);
		contentPane.add(m�steriAd�);
		m�steriAd�.setColumns(10);

		JButton buton_1 = new JButton("Kay\u0131t Ol");
		buton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kullaniciAdi.getText().length() == 0 || m�steriSifre.getText().length() == 0
						|| m�steriAd�.getText().length() == 0) {
					yard�mc�.mesaj("L�tfen T�m alanlar� doldurunuz");

				} else {
					try {
						boolean kontroller = m�steri.Kay�tOl(kullaniciAdi.getText(), m�steriSifre.getText(),
								m�steriAd�.getText());
						if (kontroller) {
							yard�mc�.mesaj("��LEM BA�ARILI");
							GirisGUI gGUI = new GirisGUI();
							gGUI.setVisible(true);
							dispose();
						} else {
							yard�mc�.mesaj("HATA");
						}
					} catch (SQLException e1) {

						e1.printStackTrace();
					}

				}

			}
		});
		buton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		buton_1.setBounds(10, 185, 153, 23);
		contentPane.add(buton_1);

		JButton buton_2 = new JButton("Geri D\u00F6n");
		buton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GirisGUI gGUI = new GirisGUI();
				gGUI.setVisible(true);
				dispose();
			}
		});
		buton_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		buton_2.setBounds(10, 219, 153, 23);
		contentPane.add(buton_2);
	}
}
