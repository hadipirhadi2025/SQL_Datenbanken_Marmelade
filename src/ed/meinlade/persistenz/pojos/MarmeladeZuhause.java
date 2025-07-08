package ed.meinlade.persistenz.pojos;

import java.util.ArrayList;
import java.util.List;

public class MarmeladeZuhause {
    public static void main(String[] args) {
        DatenbankZugriff james = new DatenbankZugriff();
        List<Marmelade> marmeladeList = new ArrayList<>();
        marmeladeList = james.lesenDerMarmeladenAusDerDatenbank();

        marmeladeList.forEach(marmelade -> System.out.println("Heute lecker;" + marmelade));

    }
}
