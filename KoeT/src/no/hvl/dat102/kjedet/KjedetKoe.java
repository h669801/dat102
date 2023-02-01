package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

//********************************************************************
// 
//  Representerer en samling k� implementer vha kjedet struktur
//********************************************************************

public class KjedetKoe<T> implements KoeADT<T> {
	private LinearNode<T> foran, bak;


	/******************************************************************
	 * Oppretter en tom k�.
	 ******************************************************************/
	public KjedetKoe() {

		foran = bak = null;
	}

	/******************************************************************
	 * Legger inn et spesifisert element i k�en.
	 ******************************************************************/
	@Override
	public void innKoe(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		if(erTom()) {
			foran = nyNode;
		}else {
		bak.setNeste(nyNode);
		}
		bak = nyNode;
		
//		nyNode.setNeste(foran);
//		foran = nyNode;
		//Fyll ut

	}

	/******************************************************************
	 * Fjerner og returnerer elementet foran i k�en.
	 ******************************************************************/
	@Override
	public T utKoe() {
		if (erTom()) {
			
			throw new EmptyCollectionException("koe");
		}
		
//		T resultat = foran.getElement();
//		if (foran != bak) {
//		foran = foran.getNeste();
//		}else {
//			foran = bak = null;
//		}
////		if(erTom()) {
////			bak = null;
////		}
//		
//		return resultat;
		
		T res = foran.getElement();
        foran = foran.getNeste();

//        if(erTom()) {
//            bak = null;
//        }
        if(foran == null) {
        	bak = null;
        }

        return res;

		//Fyll ut
		
//		return null;//Midlertidig
	}

	/******************************************************************
	 * Returnerer elementet foran i k�en ute � fjerne det.
	 ******************************************************************/
	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("koe");

		T resultat = foran.getElement();
		return resultat;
	}

	/******************************************************************
	 * Returnerer sann hvis k�en er tom, usann ellers.
	 ******************************************************************/
	@Override
	public boolean erTom() {
		return (foran == null && (bak == null));
	}

	/******************************************************************
	 * Returnerer en strengrepresentasjon av elementene i k�en.
	 ******************************************************************/
	public String toString() {
		String resultat = "";
		LinearNode<T> aktuell = foran;

		while (aktuell != null) {
			resultat = resultat + (aktuell.getElement()).toString() + "\n";
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}
}// class
