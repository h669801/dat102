package oppg2oving4oblig2;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;
import oppg2oving4oblig2.*;

public class KlientDatakontakt {
	public static void main(String[] args) {
		Datakontakt datakontakt = new Datakontakt(10);

		// Oppretter noen medlemmer
		Medlem m1 = new Medlem("Ole", new KjedetMengde<>());
		Medlem m2 = new Medlem("Petter", new KjedetMengde<>());
		Medlem m3 = new Medlem("Kari", new KjedetMengde<>());
//		Medlem medlem1 = "Thomas F";
//		String medlem2 = "Thomas E";
//		String medlem3 = "Thomas A";
//		Medlem m1 = new Medlem(medlem1, "fotball");
//		Medlem m2 = new Medlem("Thomas E");
//		Medlem m3 = new Medlem("Thomas A");
		datakontakt.leggTilMedlem(m1);
		datakontakt.leggTilMedlem(m2);
		datakontakt.leggTilMedlem(m3);
		datakontakt.finnPartnerFor(m1.getNavn());
		datakontakt.finnPartnerFor(m2.getNavn());
		datakontakt.finnPartnerFor(m3.getNavn());
		int indeks = datakontakt.finnMedlemsIndeks(m1.getNavn());
		System.out.println("finnMedlemsIndeks: " + indeks);
		System.out.println(m1.getNavn());
		System.out.println(datakontakt.getAntallMedlemmer());
		System.out.println(datakontakt.getMedlemTabell());
		datakontakt.tilbakestillStatusIndeks(m1.getNavn());
		System.out.println(datakontakt.getMedlemTabell());
		System.out.println(datakontakt.getAntallMedlemmer());
		
//
//		for (int i = 0; i < datakontakt.getAntallMedlemmer(); i++) {
//			System.out.println(datakontakt.Datakontakt(i).getNavn() + ": " + datakontakt.getMedlem(i).getStatusIndeks());
//		}
//
//		datakontakt.tilbakestillStatusIndeks("Ole");
//		datakontakt.tilbakestillStatusIndeks("Petter");
//		datakontakt.tilbakestillStatusIndeks("Kari");
//
//		for (int i = 0; i < datakontakt.getAntallMedlemmer(); i++) {
//			System.out.println(datakontakt.getMedlem(i).getNavn() + ": " + datakontakt.getMedlem(i).getStatusIndeks());
//		}
//	}
//	datakontakt.leggTilMedlem(new Medlem("Per", new TabellMengde<>(new Hobby[] {Hobby.FRILUFTSLIV, Hobby.MATLAGING})));
//    datakontakt.leggTilMedlem(new Medlem("Kari", new TabellMengde<>(new Hobby[] {Hobby.MUSIKK, Hobby.REISE})));
//    datakontakt.leggTilMedlem(new Medlem("Ola", new TabellMengde<>(new Hobby[] {Hobby.SPORT, Hobby.FOTOGRAFERING})));
    
    // Finn partner for medlemmer
//    datakontakt.finnPartnerFor(m1);
//    datakontakt.finnPartnerFor("Kari");
//    datakontakt.finnPartnerFor("Ola");
    
    // Skriv ut medlemmene og deres partnere
//    Tekstgrensesnitt.skrivParListe(datakontakt);
    
    // Tilbakestill statusindeks for medlemmer
//    datakontakt.tilbakestillStatusIndeks("Per");
//    datakontakt.tilbakestillStatusIndeks("Kari");
//    datakontakt.tilbakestillStatusIndeks("Ola");
	}
}
