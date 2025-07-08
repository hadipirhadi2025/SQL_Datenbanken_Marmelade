package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <pre>
 *     Füllen der DatenBank
 *     INSERT INTO
 *
 *
 *     Hier wird erneut Statement Objekt verwendet (einfach schreiben=
 *     später wird PreparedStetment öfer verwendet (Objekt-Orientiert)
 * </pre>
 *
 */
public class EinfachSchreibTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/marmelade_db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";

        Connection verbindung = DriverManager.getConnection(url, user, password);
        Statement umwandler = verbindung.createStatement();

        String sqlEingabe = "INSERT INTO Marmelade VALUES(NULL, 'Ananas mit Chili', 60, '2025-1-19' );";
        umwandler.execute(sqlEingabe);
        System.out.println("Erfolgreich");
    }
}
