package ed.meinlade.persistenz.pojos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <tre>
 *     Bei Lesen werden Marmelade Objekte erstellt
 *     Beim Schreiben werden Marmelade Objekte in die Datenbank geschrieben
 *     Zugriff mt Objekt-Orientierung
 *
 *     HIER finden die Datenbank Aktionen statt
 *
 *     try-with-resurces: In try-Parameter initialisierte Resources werden automatisch geschlossen
 * </tre>
 */
public class DatenbankZugriff {
    private String url = "jdbc:mysql://localhost:3306/marmelade_db?createDatabaseIfNotExist=true";
    private String user = "root";
    private String password = "";

    public List<Marmelade> lesenDerMarmeladenAusDerDatenbank(){
        List<Marmelade> dieMarmrlade = new ArrayList<>();
        String abfrage = "Select * from Marmelade";
        try (Connection verbindung = DriverManager.getConnection(url, user, password);
             Statement umwandler = verbindung.createStatement();
             ResultSet marmeladeCursor = umwandler.executeQuery(abfrage)){
            while (marmeladeCursor.next()){
                int id = marmeladeCursor.getInt("marmelade_id");
                String sorte =  marmeladeCursor.getString("sorte");
                int zuckergehalt=  marmeladeCursor.getInt("zuckergehalt");
                LocalDate eingekocht = marmeladeCursor.getDate("eingekocht").toLocalDate();

                Marmelade ausDatenbank = new Marmelade(sorte, zuckergehalt,eingekocht);
                ausDatenbank.setMarmeladeId(id);

                dieMarmrlade.add(ausDatenbank);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }

        //Hier ist verbindung sicher geschlossen: try-with-resources schließt die Verbindung

        return dieMarmrlade;

    }

}
