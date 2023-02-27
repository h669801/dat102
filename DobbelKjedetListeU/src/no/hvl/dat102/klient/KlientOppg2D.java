package no.hvl.dat102.klient;

import no.hvl.dat102.kjedet.DobbelKjedetOrdnetListe;
import no.hvl.dat102.kjedet.DobbelNode;

public class KlientOppg2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DobbelKjedetOrdnetListe<Integer> liste = new DobbelKjedetOrdnetListe<>(-100, 100);

        liste.leggTil(0);
        liste.leggTil(-3);
        liste.leggTil(4);
        liste.leggTil(7);
        liste.leggTil(9);
        liste.leggTil(12);
        System.out.println("Liste etter leggTil:");
        liste.visListe();
        liste.fjern(7);
//        liste.fjern(-100);
        liste.fjern(4);
        liste.fjern(0);
        System.out.println("Liste etter fjern:");
        
        liste.visListe();
        int tall = 2;
        DobbelNode<Integer> node = liste.finn(tall);
        if (node == null) {
            System.out.println(tall + "er ikke i listen");
        } else {
            System.out.println(tall + "er i listen");
        }
	}

}
