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

    public Marmelade(String sorte, int zuckergehalt, LocalDate gekocht) {
        this.sorte = sorte;
        this.zuckergehalt = zuckergehalt;
        this.gekocht = gekocht;
    }

    public int getMarmeladeId() {
        return marmeladeId;
    }

    public void setMarmeladeId(int marmeladeId) {
        this.marmeladeId = marmeladeId;
    }

    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
    }

    public int getZuckergehalt() {
        return zuckergehalt;
    }

    public void setZuckergehalt(int zuckergehalt) {
        this.zuckergehalt = zuckergehalt;
    }

    public LocalDate getGekocht() {
        return gekocht;
    }

    public void setGekocht(LocalDate gekocht) {
        this.gekocht = gekocht;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Marmelade marmelade = (Marmelade) o;
        return zuckergehalt == marmelade.zuckergehalt && sorte.equals(marmelade.sorte) && gekocht.equals(marmelade.gekocht);
    }

    @Override
    public int hashCode() {
        int result = sorte.hashCode();
        result = 31 * result + zuckergehalt;
        result = 31 * result + gekocht.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Marmelade{" +
                "marmeladeId=" + marmeladeId +
                ", sorte='" + sorte + '\'' +
                ", zuckergehalt=" + zuckergehalt +
                ", gekocht=" + gekocht +
                '}';
    }
}
