package Yard�mc�lar;

import javax.swing.*;

public class yard�mc� {
	public static void mesaj(String string) {
		String mesage;
		switch (string) {
		case "fill up":

			mesage = "l�tfen t�m alanlar� doldurunuz.";
		case "ba�ar�l�":
			mesage = "��LEM BA�ARILI";
			break;
		default:
			mesage = string;
		}
		JOptionPane.showMessageDialog(null, mesage, "Mesaj", JOptionPane.INFORMATION_MESSAGE);

	}

}
