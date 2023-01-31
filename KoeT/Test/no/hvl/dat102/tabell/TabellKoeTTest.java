package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeTADTTest;
import no.hvl.dat102.tabell.TabellSirkulaerKoe;

public class TabellKoeTTest extends KoeTADTTest{
	
	@Override
	protected KoeADT<Integer> reset() {
		return new TabellSirkulaerKoe<Integer>();
	}

}
