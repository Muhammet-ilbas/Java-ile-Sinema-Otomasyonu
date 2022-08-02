package Yardýmcýlar;

import javax.swing.*;

public class yardýmcý {
	public static void mesaj(String string) {
		String mesage;
		switch (string) {
		case "fill up":

			mesage = "lütfen tüm alanlarý doldurunuz.";
		case "baþarýlý":
			mesage = "ÝÞLEM BAÞARILI";
			break;
		default:
			mesage = string;
		}
		JOptionPane.showMessageDialog(null, mesage, "Mesaj", JOptionPane.INFORMATION_MESSAGE);

	}

}
