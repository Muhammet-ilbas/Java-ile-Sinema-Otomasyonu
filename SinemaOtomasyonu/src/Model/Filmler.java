package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Yardýmcýlar.DBConnection;

public class Filmler {

	PreparedStatement preparedStatement = null;

	private int id;
	private String adý, türü, dili, tarihi, Salon;
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;

	public Filmler(int id, String adý, String türü, String dili, String tarihi, String Salon) {
		super();
		this.id = id;
		this.adý = adý;
		this.türü = türü;
		this.dili = dili;
		this.tarihi = tarihi;
		this.Salon = Salon;
	}

	public Filmler() {
	}

	public ArrayList<Filmler> getList() throws SQLException {
		ArrayList<Filmler> list = new ArrayList<>();
		Filmler obj;

		try {
			Connection con = conn.connDb();
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM film ");
			while (rs.next()) {

				obj = new Filmler();
				obj.setId(rs.getInt("id"));
				obj.setAdý(rs.getString("adý"));
				obj.setTürü(rs.getString("türü"));
				obj.setDili(rs.getString("dili"));
				obj.setTarihi(rs.getString("tarihi"));
				list.add(obj);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			st.close();
			rs.close();
			con.close();
		}

		return list;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdý() {
		return adý;
	}

	public void setAdý(String adý) {
		this.adý = adý;
	}

	public String getTürü() {
		return türü;
	}

	public void setTürü(String türü) {
		this.türü = türü;
	}

	public String getDili() {
		return dili;
	}

	public void setDili(String dili) {
		this.dili = dili;
	}

	public String getTarihi() {
		return tarihi;
	}

	public void setTarihi(String tarihi) {
		this.tarihi = tarihi;
	}

	public String getSalon() {
		return Salon;
	}

	public void setSalon(String salon) {
		Salon = salon;
	}

}
