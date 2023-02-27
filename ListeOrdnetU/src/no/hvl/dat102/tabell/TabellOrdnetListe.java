package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		T resultat = liste[bak - 1];
	    liste[bak - 1] = null;
	    bak--;

//		T resultat = null;
		// ... Fyll ut
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		T resultat = liste[0];
		for (int i = 0; i < bak - 1; i++) {
	        liste[i] = liste[i + 1];
	    }
	    liste[bak - 1] = null;
	    bak--;
		
//		T resultat = null;
		// ... Fyll ut
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");	
		T resultat = liste[bak - 1];
//		T resultat = null;
		// ...Fyll ut

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		if (bak == liste.length) {
	        utvid();
	    }
		
	    // Finn plassen hvor elementet skal settes inn
	    int indeks = 0;
	    while (indeks < bak && element.compareTo(liste[indeks]) > 0) {
	        indeks++;
	    }

	    // Flytt alle elementer en plass til høyre for å gi plass til det nye elementet
	    for (int i = bak; i > indeks; i--) {
	        liste[i] = liste[i - 1];
	    }

	    liste[indeks] = element;
	    bak++;
		// ...Fyll ut
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		// ...Fyll ut
		
		 int indeks = finn(element);

//		    if (indeks == IKKE_FUNNET) {
//		        throw new NoSuchElementException("Elementet finnes ikke i listen");
//		    }

		    // Flytt alle elementer en plass til venstre for å fjerne elementet
//		    T resultat = liste[indeks];
		    for (int i = indeks; i < bak - 1; i++) {
		        liste[i] = liste[i + 1];
		    }

		    liste[bak - 1] = null;
		    bak--;

//		    return resultat;
		return element;

	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		// ...Fyll ut
	    for (i = 0; i < bak && resultat == IKKE_FUNNET; i++) {
	        if (liste[i].equals(el)) {
	            resultat = i;
	        }
	    }
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
