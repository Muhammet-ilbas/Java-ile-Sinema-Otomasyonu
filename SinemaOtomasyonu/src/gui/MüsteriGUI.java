package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Filmler;
import Model.Yonetici;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MüsteriGUI extends JFrame {
	static Yonetici ynt = new Yonetici();
	private JPanel contentPane;
	private JTable GösterimTablo;
	private DefaultTableModel filmlerModel = null;
	private Object[] fimlerData = null;
	Filmler filmler = new Filmler();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MüsteriGUI frame = new MüsteriGUI(ynt);
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
	public MüsteriGUI(Yonetici ynt) {
		setTitle("SINEMA OTOMASYONU");
		filmlerModel = new DefaultTableModel();
		Object[] colFilmler = new Object[6];
		colFilmler[0] = "ID";
		colFilmler[1] = "adi";
		colFilmler[2] = "türü ";
		colFilmler[3] = "dili ";
		colFilmler[4] = "tarihi";
		colFilmler[5] = "Salon";
		filmlerModel.setColumnIdentifiers(colFilmler);
		fimlerData = new Object[6];
		try {
			for (int i = 0; i < filmler.getList().size(); i++) {
				fimlerData[0] = filmler.getList().get(i).getId();
				fimlerData[1] = filmler.getList().get(i).getAdý();
				fimlerData[2] = filmler.getList().get(i).getTürü();
				fimlerData[3] = filmler.getList().get(i).getDili();
				fimlerData[4] = filmler.getList().get(i).getTarihi();
				fimlerData[5] = filmler.getList().get(i).getSalon();
				filmlerModel.addRow(fimlerData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 533, 252);
		contentPane.add(scrollPane);

		GösterimTablo = new JTable(filmlerModel);
		scrollPane.setViewportView(GösterimTablo);

		JButton ileriButon = new JButton("ILERI");
		ileriButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeansGUI frame;
				try {
					frame = new SeansGUI();
					frame.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		ileriButon.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		ileriButon.setBounds(481, 338, 89, 23);
		contentPane.add(ileriButon);

		JButton geriButon = new JButton("GERI");
		geriButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GirisGUI frame = new GirisGUI();
				frame.setVisible(true);
				dispose();
			}
		});
		geriButon.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		geriButon.setBounds(10, 338, 127, 23);
		contentPane.add(geriButon);

		JLabel lblNewLabel = new JLabel("GOSTERIMDE OLAN FÝLMLER");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel.setBounds(163, 11, 226, 24);
		contentPane.add(lblNewLabel);
	}
}
