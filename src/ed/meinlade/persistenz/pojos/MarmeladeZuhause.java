package ed.meinlade.persistenz.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MarmeladeZuhause {
    public static void main(String[] args) {
        DatenbankZugriff james = new DatenbankZugriff();
//        List<Marmelade> marmeladeList = new ArrayList<>();
//        marmeladeList = james.lesenDerMarmeladenAusDerDatenbank();
//
//        marmeladeList.forEach(marmelade -> System.out.println("Heute lecker;" + marmelade));
        Marmelade neu = new Marmelade("KiwiApfel", 30, LocalDate.now());
        System.out.println(neu);
        james.schreibenEinerMarmeladeInDatenbank(neu);
        System.out.println("Geschrieben wurde" + neu);

        neu = new Marmelade("Pfirsich", 60, LocalDate.of(2025, 7, 8));
        System.out.println(neu);
        james.schreibenEinerMarmeladeInDatenbank(neu);
        james.schreibenEinerMarmeladeInDatenbank(neu);
        System.out.println("Geschrieben wurde" + neu);
    }
}
