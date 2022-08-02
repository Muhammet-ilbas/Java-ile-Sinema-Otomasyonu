package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Yonetici;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import Yardýmcýlar.DBConnection;
import Yardýmcýlar.yardýmcý;

public class GirisGUI extends JFrame {

	private JPanel contentPane;
	private JTextField yoneticiID;
	private JTextField müsteriID;
	private JPasswordField yoneticiPass;
	private DBConnection conn = new DBConnection();
	private JPasswordField müsteriPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisGUI frame = new GirisGUI();
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
	public GirisGUI() {
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Dadas Sinemasýna Hosgeldiniz");
		label.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		label.setBounds(114, 68, 279, 44);
		getContentPane().add(label);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\acb\\Desktop\\sinema.png"));
		setTitle("SÝNEMA OTOMASYONU");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 188, 474, 172);
		contentPane.add(tabbedPane);

		JPanel yoneticiPanel = new JPanel();
		yoneticiPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Yönetici Giriþi", null, yoneticiPanel, null);
		yoneticiPanel.setLayout(null);

		JLabel admin = new JLabel("Kullanýcý Adý:");
		admin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		admin.setBounds(10, 4, 155, 44);
		yoneticiPanel.add(admin);

		JLabel labelSifre = new JLabel("Sifre:");
		labelSifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		labelSifre.setBounds(20, 59, 140, 44);
		yoneticiPanel.add(labelSifre);

		yoneticiID = new JTextField();
		yoneticiID.setBounds(128, 16, 209, 32);
		yoneticiPanel.add(yoneticiID);
		yoneticiID.setColumns(10);
		// 59-102 satýrlarý arasý gui tasarým kodlarý
		JButton buton = new JButton("Giriþ Yap");
		buton.addActionListener(new ActionListener() {
			// yönetici alanlardan birini boþ doldurursa eðer bir hata mesajý alýr bunu da
			// yardýmcý sýnýfýndan bir metotla yapýlýr.
			public void actionPerformed(ActionEvent e) {
				if (yoneticiID.getText().length() == 0 || yoneticiPass.getText().length() == 0) {
					yardýmcý.mesaj("fill up");

				} else {

					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						while (rs.next()) {
							if (yoneticiID.getText().equals(rs.getString("kullanýcýAdý"))
									&& yoneticiPass.getText().equals(rs.getString("sifre"))) {
								Yonetici yonetici = new Yonetici();
								yonetici.setId(rs.getInt("id"));
								yonetici.setSifre("sifre");
								yonetici.setKullanýcýAdý(rs.getString("kullanýcýAdý"));
								yonetici.setName(rs.getString("name"));
								yonetici.setTip(rs.getString("tip"));
								YoneticiGUI yGUI = new YoneticiGUI(yonetici);
								yGUI.setVisible(true);
								dispose();

							}
						}
					} catch (SQLException e1) {

						e1.printStackTrace();
					}

				}

			}
		});
		buton.setBounds(327, 105, 121, 28);
		yoneticiPanel.add(buton);

		yoneticiPass = new JPasswordField();
		yoneticiPass.setBounds(128, 59, 209, 32);
		yoneticiPanel.add(yoneticiPass);

		JPanel musteriPanel = new JPanel();
		musteriPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Müþteri Giriþi", null, musteriPanel, null);
		musteriPanel.setLayout(null);

		JLabel lblKullancAd = new JLabel("Kullanýcý Adý:");
		lblKullancAd.setBounds(10, 0, 137, 44);
		lblKullancAd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		musteriPanel.add(lblKullancAd);

		müsteriID = new JTextField();
		müsteriID.setBounds(142, 11, 224, 33);
		musteriPanel.add(müsteriID);
		müsteriID.setColumns(10);

		JLabel lblifre = new JLabel("sifre:");
		lblifre.setBounds(10, 55, 88, 44);
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		musteriPanel.add(lblifre);

		JButton buton_2 = new JButton("Kayýt Ol");
		buton_2.setBounds(9, 110, 154, 34);
		buton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buton_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		musteriPanel.add(buton_2);

		JButton buton_3 = new JButton("Giris Yap");
		buton_3.setBounds(272, 110, 187, 34);
		buton_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		musteriPanel.add(buton_3);

		müsteriPass = new JPasswordField();
		müsteriPass.setBounds(142, 55, 224, 36);
		musteriPanel.add(müsteriPass);

		JLabel labelHosgeldýn = new JLabel("Dadas Sinemas\u0131na Hosgeldiniz");
		labelHosgeldýn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		labelHosgeldýn.setBounds(102, 48, 261, 86);
		contentPane.add(labelHosgeldýn);
	}
}