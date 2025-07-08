package tests;

import java.sql.*;
import java.time.LocalDate;

/**
 * Verbindung ist getestet
 * Lesen aus Datenbank wird getestet:
 * Getestet wird Tabellenname und Spaltenname und Datentypen
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
            System.out.println("Und weiter ein Datensatz");
            int schluessel = marmeladeCursor.getInt("marmelade_id");
            String sorte =  marmeladeCursor.getString("sorte");
            int zuckergehalt=  marmeladeCursor.getInt("zuckergehalt");
            LocalDate eingekocht = marmeladeCursor.getDate("eingekocht").toLocalDate();

            System.out.println(schluessel +"\t"+ sorte+"\t"+zuckergehalt+"\t"+eingekocht);
;        }
    }
}
