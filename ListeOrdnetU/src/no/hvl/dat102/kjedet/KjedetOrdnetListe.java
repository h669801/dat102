package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

//		T resultat = null;
		
		T resultat = foerste.getElement();
	    foerste = foerste.getNeste();
	    antall--;

	    if (erTom())
	        siste = null;
		// ...Fyll ut
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

//		T resultat = null;
		// ...Fyll ut
		T resultat = siste.getElement();

	    if (foerste == siste) { // kun ett element i listen
	        foerste = null;
	        siste = null;
	    } else {
	        LinearNode<T> aktuell = foerste;
	        LinearNode<T> forrige = null;
	        while (aktuell != siste) { // finn nest siste
	            forrige = aktuell;
	            aktuell = aktuell.getNeste();
	        }
	        forrige.setNeste(null); // fjern siste element
	        siste = forrige; // oppdater siste-peker
	    }
	    antall--;
		
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {

		// ...Fyll ut
		
		LinearNode<T> nyNode = new LinearNode<T>(element);

	    if (erTom()) {
	        foerste = nyNode;
	        siste = nyNode;
	    } else if (element.compareTo(foerste.getElement()) < 0) {
	        nyNode.setNeste(foerste);
	        foerste = nyNode;
	    } else if (element.compareTo(siste.getElement()) > 0) {
	        siste.setNeste(nyNode);
	        siste = nyNode;
	    } else {
	        LinearNode<T> aktuell = foerste;
	        LinearNode<T> forrige = null;

	        while (aktuell != null && element.compareTo(aktuell.getElement()) > 0) {
	            forrige = aktuell;
	            aktuell = aktuell.getNeste();
	        }
	        forrige.setNeste(nyNode);
	        nyNode.setNeste(aktuell);
	    }
	    antall++;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
