package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class DobbelKjedetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeADT<T> {
	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
		// F�rste node
		//TODO
		foerste = new DobbelNode<>(minVerdi);
		// Siste node
		//TODO
		siste = new DobbelNode<>(maksVerdi);
		// Kjeding
		//TODO
		foerste.setNeste(siste);
	    siste.setForrige(foerste);
	    antall = 2;
	}

	@Override
	public void leggTil(T el) {
		DobbelNode<T> nyNode = new DobbelNode<T>(el);
		DobbelNode<T> aktuell = foerste.getNeste();
		while ((el.compareTo(aktuell.getElement()) > 0)) {
			aktuell = aktuell.getNeste();
		}
		// Legg inn foran aktuell
		nyNode.setNeste(aktuell);
		nyNode.setForrige(aktuell.getForrige());
		aktuell.getForrige().setNeste(nyNode);
		aktuell.setForrige(nyNode);
		antall++;

	}

	@Override
	public T fjern(T el) {
		T resultat = null;
		if (erTom())
			throw new EmptyCollectionException("dobbelkjedet ordnet liste er tom");
		DobbelNode<T> aktuell = finn(el);
		if (aktuell != null) {// returner og slett
			resultat = aktuell.getElement();
			aktuell.getForrige().setNeste(aktuell.getNeste());
			aktuell.getNeste().setForrige(aktuell.getForrige());

		}

		return resultat;

	}

	/*
	 * Returnerer referansen til noden hvis el fins, ellers returneres
	 * null-referansen
	 */
	public DobbelNode<T> finn(T el) {
//		return null;
		//TODO
		 DobbelNode<T> denne = foerste;
		    while (denne != null && el.compareTo(denne.getElement()) > 0) {
		        denne = denne.getNeste();
		    }
		    while (denne != null && el.compareTo(denne.getElement()) < 0) {
		        denne = denne.getForrige();
		    }
		    if (denne != null && el.equals(denne.getElement())) {
		        return denne;
		    } else {
		        return null;
		    }

	}
	public void visListe() {
	    if (erTom()) {
	        System.out.println("Listen er tom.");
	        return;
	    }
	    DobbelNode<T> current = foerste;
	    while (current != null) {
	        // Sjekk om noden er en av de kunstige verdiene
	        if (current.getForrige() != null && current.getNeste() != null) {
	            System.out.print(current.getElement() + " ");
	        }
	        current = current.getNeste();
	    }
	    System.out.println();
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	public String toString() {
		String resultat = "";
		DobbelNode<T> aktuell = foerste.getNeste();
		while (aktuell != siste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}

	public String tilStrengBaklengs() {
		String resultat = "";
		DobbelNode<T> aktuell = siste.getForrige();
		while (aktuell != foerste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getForrige();
		}

		return resultat;

	}

}