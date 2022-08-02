package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Yardýmcýlar.DBConnection;

public class Seans {
	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	Connection con = conn.connDb();
	PreparedStatement preparedStatement = null;
	private int ucret;
	private String salon, baslamaSaati, bitisSaati, tarih;

	public Seans() {

	}

	public ArrayList<Seans> SeansListesi() throws SQLException {
		ArrayList<Seans> listem = new ArrayList<>();
		Seans nesne;

		try {
			Connection con = conn.connDb();
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM seans");
			while (rs.next()) {

				nesne = new Seans();
				nesne.setUcret(rs.getInt("ucreti"));
				nesne.setSalon(rs.getString("salon"));
				nesne.setBaslamaSaati(rs.getString("baslamaSaati"));
				nesne.setBitisSaati(rs.getString("bitisSaati"));
				nesne.setTarih(rs.getString("tarih"));
				listem.add(nesne);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			st.close();
			rs.close();
			con.close();
		}

		return listem;

	}

	public Seans(int ucret, String salon, String baslamaSaati, String bitisSaati, String tarih) {
		super();
		this.ucret = ucret;
		this.salon = salon;
		this.baslamaSaati = baslamaSaati;
		this.bitisSaati = bitisSaati;
		this.tarih = tarih;
	}

	public int getUcret() {
		return ucret;
	}

	public void setUcret(int ucret) {
		this.ucret = ucret;
	}

	public String getSalon() {
		return salon;
	}

	public void setSalon(String salon) {
		this.salon = salon;
	}

	public String getBaslamaSaati() {
		return baslamaSaati;
	}

	public void setBaslamaSaati(String baslamaSaati) {
		this.baslamaSaati = baslamaSaati;
	}

	public String getBitisSaati() {
		return bitisSaati;
	}

	public void setBitisSaati(String bitisSaati) {
		this.bitisSaati = bitisSaati;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

}
