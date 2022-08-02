package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.*;
import Yardýmcýlar.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YoneticiGUI extends JFrame {
	Filmler filmler = new Filmler();
	static Yonetici ynt = new Yonetici();

	private JPanel contentPane;
	private JTextField filmAdý;
	private JTextField filmTuru;
	private JTextField filmDili;
	private JTextField filmTarihi;
	private JTextField FilmID;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private DefaultTableModel filmlerModel = null;

	private Object[] fimlerData = null;

	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiGUI frame = new YoneticiGUI(ynt);
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
	public YoneticiGUI(Yonetici ynt) throws SQLException {

		// filmler model
		// verileri veritabanýndan çekip tabloda gösteren metot
		filmlerModel = new DefaultTableModel();
		Object[] colFilmler = new Object[5];
		colFilmler[0] = "ID";
		colFilmler[1] = "adý";
		colFilmler[2] = "türü ";
		colFilmler[3] = "dili ";
		colFilmler[4] = "tarihi";
		filmlerModel.setColumnIdentifiers(colFilmler);
		fimlerData = new Object[5];

		for (int i = 0; i < filmler.getList().size(); i++) {
			fimlerData[0] = filmler.getList().get(i).getId();
			fimlerData[1] = filmler.getList().get(i).getAdý();
			fimlerData[2] = filmler.getList().get(i).getTürü();
			fimlerData[3] = filmler.getList().get(i).getDili();
			fimlerData[4] = filmler.getList().get(i).getTarihi();
			filmlerModel.addRow(fimlerData);

		}
		setTitle("SÝNEMA OTOMASYONU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 433);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHosgeldinizSayn = new JLabel("Hosgeldiniz, Sayýn  " + ynt.getName());
		lblHosgeldinizSayn.setBounds(10, 11, 541, 41);
		lblHosgeldinizSayn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		contentPane.add(lblHosgeldinizSayn);

		JButton btnNewButton = new JButton("Cýkýs Yap");
		btnNewButton.setBounds(653, 11, 120, 41);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		contentPane.add(btnNewButton);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 52, 763, 339);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("SALON1", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADI");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel.setBounds(662, 14, 46, 14);
		panel.add(lblNewLabel);

		filmAdý = new JTextField();
		filmAdý.setBounds(662, 39, 86, 20);
		panel.add(filmAdý);
		filmAdý.setColumns(10);

		JLabel lblTr = new JLabel("Turu");
		lblTr.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblTr.setBounds(662, 57, 68, 24);
		panel.add(lblTr);

		filmTuru = new JTextField();
		filmTuru.setColumns(10);
		filmTuru.setBounds(662, 82, 86, 20);
		panel.add(filmTuru);

		JLabel lblDili = new JLabel("Dili");
		lblDili.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblDili.setBounds(662, 103, 46, 20);
		panel.add(lblDili);

		JLabel lblTarihi = new JLabel("Tarihi");
		lblTarihi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblTarihi.setBounds(662, 146, 68, 24);
		panel.add(lblTarihi);

		filmDili = new JTextField();
		filmDili.setColumns(10);
		filmDili.setBounds(662, 128, 86, 20);
		panel.add(filmDili);

		filmTarihi = new JTextField();
		filmTarihi.setColumns(10);
		filmTarihi.setBounds(662, 173, 86, 20);
		panel.add(filmTarihi);

		JButton btnNewButton_1 = new JButton("Film Ekle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (filmAdý.getText().length() == 0 || filmDili.getText().length() == 0
						|| filmTarihi.getText().length() == 0 || filmTuru.getText().length() == 0) {
					yardýmcý.mesaj("Lütfen tüm alanlarý doldurunuz");

				} else {
					try {
						boolean control1 = ynt.FilmEkle(filmAdý.getText(), filmTuru.getText(), filmDili.getText(),
								filmTarihi.getText(), "");
						if (control1) {
							yardýmcý.mesaj("baþarýlý");
							filmAdý.setText(null);
							filmTuru.setText(null);
							filmDili.setText(null);
							filmTarihi.setText(null);
							GuncelleFilmModel();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(659, 204, 89, 23);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Film ID");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(679, 229, 55, 23);
		panel.add(lblNewLabel_1);

		FilmID = new JTextField();
		FilmID.setEnabled(false);
		FilmID.setColumns(10);
		FilmID.setBounds(662, 252, 86, 20);
		panel.add(FilmID);

		JButton btnNewButton_2 = new JButton("SIL");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FilmID.getText().length() == 0) {
					yardýmcý.mesaj("Geçerli bir Film seçiniz");

				} else {
					int seciliID = Integer.parseInt(FilmID.getText());
					try {
						boolean kontrol = ynt.FilmSil(seciliID);
						if (kontrol) {
							yardýmcý.mesaj("baþarili");
							FilmID.setText(null);
							GuncelleFilmModel();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnNewButton_2.setBounds(659, 277, 89, 23);
		panel.add(btnNewButton_2);

		JScrollPane scrollsalon = new JScrollPane();
		scrollsalon.setBounds(10, 11, 650, 289);
		panel.add(scrollsalon);

		table = new JTable(filmlerModel);
		scrollsalon.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				FilmID.setText(table.getValueAt(table.getSelectedRow(), 0).toString());

			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("SALON2", null, panel_2, null);
		panel_2.setLayout(null);

		JScrollPane scrollsalon_1 = new JScrollPane();
		scrollsalon_1.setBounds(10, 11, 590, 289);
		panel_2.add(scrollsalon_1);

		table_1 = new JTable();
		scrollsalon_1.setViewportView(table_1);

		JLabel lblNewLabel_3 = new JLabel("ADI");
		lblNewLabel_3.setBounds(662, 11, 46, 14);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_2.add(lblNewLabel_3);

		textField_5 = new JTextField();
		textField_5.setBounds(662, 36, 86, 20);
		textField_5.setColumns(10);
		panel_2.add(textField_5);

		JLabel lblTr_2 = new JLabel("Turu");
		lblTr_2.setBounds(662, 54, 68, 24);
		lblTr_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_2.add(lblTr_2);

		textField_6 = new JTextField();
		textField_6.setBounds(662, 79, 86, 20);
		textField_6.setColumns(10);
		panel_2.add(textField_6);

		JLabel lblDili_2 = new JLabel("Dili");
		lblDili_2.setBounds(662, 100, 46, 20);
		lblDili_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_2.add(lblDili_2);

		textField_7 = new JTextField();
		textField_7.setBounds(662, 125, 86, 20);
		textField_7.setColumns(10);
		panel_2.add(textField_7);

		JLabel lblTarihi_2 = new JLabel("Tarihi");
		lblTarihi_2.setBounds(662, 143, 68, 24);
		lblTarihi_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_2.add(lblTarihi_2);

		textField_8 = new JTextField();
		textField_8.setBounds(662, 170, 86, 20);
		textField_8.setColumns(10);
		panel_2.add(textField_8);

		JButton btnNewButton_1_2 = new JButton("Film Ekle");
		btnNewButton_1_2.setBounds(659, 201, 89, 23);
		panel_2.add(btnNewButton_1_2);

		JLabel lblNewLabel_1_2 = new JLabel("Film ID");
		lblNewLabel_1_2.setBounds(679, 226, 55, 23);
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_2.add(lblNewLabel_1_2);

		textField_9 = new JTextField();
		textField_9.setBounds(662, 249, 86, 20);
		textField_9.setEnabled(false);
		textField_9.setColumns(10);
		panel_2.add(textField_9);

		JButton btnNewButton_2_2 = new JButton("SIL");
		btnNewButton_2_2.setBounds(659, 274, 89, 23);
		panel_2.add(btnNewButton_2_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("SALON3", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("ADI");
		lblNewLabel_2.setBounds(689, 0, 58, 24);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_1.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(661, 23, 86, 20);
		textField.setColumns(10);
		panel_1.add(textField);

		JLabel lblTr_1 = new JLabel("Turu");
		lblTr_1.setBounds(689, 42, 35, 24);
		lblTr_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_1.add(lblTr_1);

		textField_1 = new JTextField();
		textField_1.setBounds(661, 65, 86, 20);
		textField_1.setColumns(10);
		panel_1.add(textField_1);

		JLabel lblDili_1 = new JLabel("Dili");
		lblDili_1.setBounds(689, 86, 24, 24);
		lblDili_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_1.add(lblDili_1);

		textField_2 = new JTextField();
		textField_2.setBounds(661, 108, 86, 20);
		textField_2.setColumns(10);
		panel_1.add(textField_2);

		JLabel lblTarihi_1 = new JLabel("Tarihi");
		lblTarihi_1.setBounds(668, 131, 79, 24);
		lblTarihi_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_1.add(lblTarihi_1);

		textField_3 = new JTextField();
		textField_3.setBounds(661, 154, 86, 20);
		textField_3.setColumns(10);
		panel_1.add(textField_3);

		JButton btnNewButton_1_1 = new JButton("Film Ekle");
		btnNewButton_1_1.setBounds(661, 185, 103, 23);
		panel_1.add(btnNewButton_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Film ID");
		lblNewLabel_1_1.setBounds(693, 211, 54, 24);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_1.add(lblNewLabel_1_1);

		textField_4 = new JTextField();
		textField_4.setBounds(661, 246, 86, 20);
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		panel_1.add(textField_4);

		JButton btnNewButton_2_1 = new JButton("SIL");
		btnNewButton_2_1.setBounds(671, 277, 77, 23);
		panel_1.add(btnNewButton_2_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 648, 289);
		panel_1.add(scrollPane);

		table_2 = new JTable();
		scrollPane.setViewportView(table_2);

	}

	public void GuncelleFilmModel() throws SQLException {
		DefaultTableModel temizleModel = (DefaultTableModel) table.getModel();
		temizleModel.setRowCount(0);
		for (int i = 0; i < filmler.getList().size(); i++) {
			fimlerData[0] = filmler.getList().get(i).getId();
			fimlerData[1] = filmler.getList().get(i).getAdý();
			fimlerData[2] = filmler.getList().get(i).getTürü();
			fimlerData[3] = filmler.getList().get(i).getDili();
			fimlerData[4] = filmler.getList().get(i).getTarihi();
			filmlerModel.addRow(fimlerData);

		}
	}

}
