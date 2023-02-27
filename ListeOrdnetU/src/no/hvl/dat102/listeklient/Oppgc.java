package no.hvl.dat102.listeklient;

import java.util.Scanner;
import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.tabell.TabellOrdnetListe;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;

public class Oppgc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        OrdnetListeADT<Person> liste = new KjedetOrdnetListe<Person>();

        // Les inn noen Person-objekter fra tastaturet og legg dem inn i listen
        System.out.print("Hvor mange personer skal du legge til? ");
        int antall = scanner.nextInt();

        for (int i = 0; i < antall; i++) {
            System.out.println("Legg til person #" + (i+1) + ":");
            System.out.print("fornavn: ");
            String fornavn = scanner.next();
            System.out.println("etternavn: ");
            String etternavn = scanner.next();
            System.out.print("Fødselsaar: ");
            int fodselsar = scanner.nextInt();
            liste.leggTil(new Person(fornavn, etternavn , fodselsar));
        }
        // Skriv ut personene i stigende alder inntil listen er tom
        System.out.println("\nPersoner i listen:");
        while (!liste.erTom()) {
            Person person = liste.fjernFoerste();
            System.out.println(person.getFornavn() + person.getEtternavn() + " (" + person.getFoedselsaar() + ")");
        }
	}

}
