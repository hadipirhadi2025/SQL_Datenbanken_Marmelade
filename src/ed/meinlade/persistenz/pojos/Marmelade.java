package ed.meinlade.persistenz.pojos;

import java.time.LocalDate;

/**
 * <pre>
 *     Pojos sind oft geeignet und Datensätze einer Datenbanktabelle zu repräsentieren
 *     Ein Datensatz aus der Tabelle Marmelade entspricht einem Object der Klasse Marmelade
 * </pre>
 */
public class Marmelade {
    /**
     * Entspricht der Primärschlüselspalte in der Datenbank mt dem SQL Datentyp INT
     * und dem Spaltennamen marmelade_id
     * wird von er Datenbank erzeugt!
     */
    private int marmeladeId ;
    /**
     * Entspricht dem varchar(64) in der Tabelle
     */
    private String sorte;
    /**
     * Wie in der Datenbank
     */
    private int zuckergehalt;
    /**
     * Entspricht der Spalte eingekocht aus der Tabelle mit den SQL Datentyp Date,
     */

    private LocalDate gekocht;
}
