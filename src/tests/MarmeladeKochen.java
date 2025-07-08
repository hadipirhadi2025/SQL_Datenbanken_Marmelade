package tests;

import ed.meinlade.persistenz.pojos.Marmelade;

import java.time.LocalDate;
import java.util.Scanner;

public class MarmeladeKochen {
    public static void main(String[] args) {
        System.out.println("sorte?");
        Scanner lesser = new Scanner(System.in);
        String sorte = lesser.nextLine();
        System.out.println("Zuchekgehalt?");
        int zuckergehalt = lesser.nextInt();
        //System.out.println("frichgekocht?");
        Marmelade frichgekocht = new Marmelade(sorte, zuckergehalt, LocalDate.now());
        System.out.println(frichgekocht);
        //int gelesenId = datenbankAbfrage.getInt();
        frichgekocht.setMarmeladeId(22);
        System.out.println(frichgekocht);

    }
}
