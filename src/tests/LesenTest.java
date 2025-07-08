package tests;

import java.sql.*;
import java.time.LocalDate;

/**
 * Verbindung ist getestet
 * Lesen aus Datenbank wird getestet:
 * Getestet wird Tabellenname und Spaltenname und Datentypen
 *
 * marmeladenCursor.getInt(1); Zugriff über den Spaltenindex:
 * Mit 1 wird auf die erste Spalte zugriffen: Indizes JDBC start bei 1
 */
public class LesenTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/marmelade_db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";

        Connection verbindung = DriverManager.getConnection(url, user, password);
        Statement umwandler = verbindung.createStatement();
        System.out.println(umwandler);

        String abfrage = "SELECT * FROM Marmelade";
        ResultSet marmeladeCursor = umwandler.executeQuery(abfrage);
        System.out.println(marmeladeCursor);
        while (marmeladeCursor.next()){
            //System.out.println("Und weiter ein Datensatz");
            //int schluessel = marmeladeCursor.getInt("marmelade_id");
            int schluessel = marmeladeCursor.getInt(1);
            //String sorte =  marmeladeCursor.getString("sorte");
            String sorte =  marmeladeCursor.getString(2);
            //int zuckergehalt=  marmeladeCursor.getInt("zuckergehalt");
            int zuckergehalt=  marmeladeCursor.getInt(3);
            LocalDate eingekocht = marmeladeCursor.getDate(4).toLocalDate();

            System.out.println(schluessel +"\t"+ sorte+"\t"+zuckergehalt+"\t"+eingekocht);
;        }
    }
}
