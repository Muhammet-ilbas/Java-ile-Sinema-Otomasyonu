package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Yard�mc�lar.DBConnection;

public class Filmler {

	PreparedStatement preparedStatement = null;

	private int id;
	private String ad�, t�r�, dili, tarihi, Salon;
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;

	public Filmler(int id, String ad�, String t�r�, String dili, String tarihi, String Salon) {
		super();
		this.id = id;
		this.ad� = ad�;
		this.t�r� = t�r�;
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
				obj.setAd�(rs.getString("ad�"));
				obj.setT�r�(rs.getString("t�r�"));
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

	public String getAd�() {
		return ad�;
	}

	public void setAd�(String ad�) {
		this.ad� = ad�;
	}

	public String getT�r�() {
		return t�r�;
	}

	public void setT�r�(String t�r�) {
		this.t�r� = t�r�;
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
