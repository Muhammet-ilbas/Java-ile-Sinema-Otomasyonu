package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class M�steri extends User {
	PreparedStatement preparedStatement = null;
	Statement st = null;
	ResultSet rs = null;
	Connection con = conn.connDb();

	public M�steri() {

	}

	public M�steri(int id, String kullan�c�Ad�, String sifre, String name, String tip) {
		super(id, kullan�c�Ad�, sifre, name, tip);

	}

	public boolean Kay�tOl(String kullan�c�Ad�, String sifre, String name) throws SQLException {
		int anahtar = 0;
		boolean sayac = false;
		String sorgulama = "INSERT INTO USER" + "(kullan�c�Ad�,sifre,name,tip) VALUES" + "(?,?,?,?)";
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE sifre='" + sifre + "'");
			while (rs.next()) {
				sayac = true;
				break;
			}
			if (!sayac) {
				preparedStatement = con.prepareStatement(sorgulama);
				preparedStatement.setString(1, kullan�c�Ad�);
				preparedStatement.setString(2, sifre);
				preparedStatement.setString(3, name);
				preparedStatement.setString(4, "m�steri");

			}
			anahtar = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (anahtar == 1)
			return true;
		else
			return false;
	}
}
