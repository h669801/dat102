package oppg2oving4oblig2;

import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Tekstgrensesnitt {
//	private static final Scanner scanner = new Scanner(System.in);

    // Leser opplysningene om et medlem fra tastatur
    public static Medlem lesMedlem() {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv inn medlemsnavn:");
        String navn = scanner.nextLine();
        MengdeADT<Hobby> hobbyer = new KjedetMengde<>();
        while (true) {
            System.out.println("Skriv inn hobby eller skriv 'stop' for å avslutte:");
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            }
            hobbyer.leggTil(new Hobby(input));
        }
        return new Medlem(navn, hobbyer);
    }

    // Skriver ut hobbylisten for et medlem
    public static void skrivHobbyListe(Medlem medlem) {
    	System.out.println("Hobbyer til " + medlem.getNavn() + ":");
        System.out.println(medlem.getHobbyer().toString());
    }

    public static void skrivParListe(Datakontakt arkiv) {
//    	System.out.println("Parliste:");
//        System.out.println("PARNAVN\tHOBBYER");
//        int antallPar = 0;
//        for (int i = 0; i < arkiv.getAntallMedlemmer(); i++) {
//            Medlem medlem1 = arkiv.getMedlemTabell()[i];
//            if (medlem1.getStatusIndeks() == -1) {
//                for (int j = i + 1; j < arkiv.getAntallMedlemmer(); j++) {
//                    Medlem medlem2 = arkiv.getMedlemTabell()[j];
//                    if (medlem2.getStatusIndeks() == -1 && medlem1.passerTil(medlem2)) {
//                        System.out.println(medlem1.getNavn() + " og " + medlem2.getNavn() + "\t" + medlem1.getHobbyer().toString());
//                        medlem1.setStatusIndeks(j);
//                        medlem2.setStatusIndeks(i);
//                        antallPar++;
//                        break;
//                    }
//                }
//            }
//        }
//        System.out.println("Antall par funnet: " + antallPar);
//    }
    	 System.out.println("Parliste:");
         System.out.println("PARNAVN\tHOBBYER");
         int antallPar = 0;
         for (int i = 0; i < arkiv.getAntallMedlemmer(); i++) {
             Medlem medlem1 = arkiv.getMedlemTabell()[i];
             if (medlem1.getStatusIndeks() == -1) {
                 for (int j = i + 1; j < arkiv.getAntallMedlemmer(); j++) {
                     Medlem medlem2 = arkiv.getMedlemTabell()[j];
                     if (medlem2.getStatusIndeks() == -1 && medlem1.passerTil(medlem2)) {
                         System.out.println(medlem1.getNavn() + " og " + medlem2.getNavn() + "\t" + medlem1.getHobbyer().toString());
                         medlem1.setStatusIndeks(j);
                         medlem2.setStatusIndeks(i);
                         antallPar++;
                         break;
                     }
                 }
             }
         }
         System.out.println("Antall par funnet: " + antallPar);
     }
}
