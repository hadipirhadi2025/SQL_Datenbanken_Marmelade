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

    public void schreibenEinerMarmeladeInDatenbank(Marmelade zuSchreiben){
        if(zuSchreiben.getMarmeladeId() !=0){
            throw new PrimaeschluesselException("Kein zweites Schreiben in die Datenbank");
        }
        // String sqlEingabe = "INSERT INTO Marmelade VALUES(NULL, 'Ananas mit Chili', 60, '2025-1-19' );";
//        String sqlEingaben = "INSERT INTO Marmelade VALUES(NULL, '"+ zuSchreiben.getSorte()+"',"+zuSchreiben.getZuckergehalt()
//                +", '"+zuSchreiben.getGekocht()+"')";
        String sqlEingaben = "INSERT INTO Marmelade VALUES(NULL,?,?,?)";
        //Platzhalter statt Werten aus Objekt
        try(Connection verbindung = DriverManager.getConnection(url, user, password);
            PreparedStatement besserUmwandler = verbindung.prepareStatement(sqlEingaben)){

            besserUmwandler.setString(1, zuSchreiben.getSorte());
            besserUmwandler.setInt(2, zuSchreiben.getZuckergehalt());
            besserUmwandler.setDate(3, Date.valueOf(zuSchreiben.getGekocht()));

            besserUmwandler.execute();

            //Kaffee Kochen
            //besserUmwandler.get

        }catch (SQLException ausnahme){
            System.out.println("Fehler in Insert eine Marmelade:"+ausnahme.getMessage());
            ausnahme.printStackTrace();
        }
    }

}
