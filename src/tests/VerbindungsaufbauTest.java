package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <pre>
 *     Stelle eie Verbingung mit der realtionalen Datenbank Marmelade_db her.
 *     Ermöglicht das Testgen der Verbidung und Verbindungsdaten
 *     Sollte in jeder Application gemacht werden, die auf mit einer Datenbank arbeitet
 *
 *     Java Database Connectivity: JDBC (Package java.sql)
 *
 *     Zugriff auf eine Datenbank:
 *     Wo: Was ist die genaue Adresse der Datenbank
 *     Wer: Auf der Datenbank registierter User
 *     Berechnung: Passwort
 *
 *     Wo: URL:
 *     https://google.de:443/search?q=java
 *
 *     jdbc: mysql://localhost:3306/marmelade_db?createDatabaseIfNotExist=true
 *     wer: root
 *     Berechtigung: leers Password: ""
 *
 *     java.sql.SQLException: No suitable driver
 *     1: Tippfehler in der url
 *     2: Es konnte kein Treiber gefunden werden, kein Objekttyp für den Zugriff
 *     com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure
 *     3: Die datenbank wurde nicht gestartet/läuft nicht
 * </pre>
 */
public class VerbindungsaufbauTest {
    /**
     * Tests Zugangsdaten
     * Überüprüft die verfügbarkeit der Datenbank
     * Üerprüft die Verfügbarkeit notwendiger Biblioteken
     * @param args wird nicht verwandet
     */
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/marmelade_db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";
        Connection verbundung = DriverManager.getConnection(url, user, password);
        System.out.println(verbundung);
    }
}
