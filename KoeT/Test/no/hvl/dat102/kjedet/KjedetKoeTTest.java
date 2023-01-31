package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeTADTTest;
import no.hvl.dat102.kjedet.KjedetKoe;

public class KjedetKoeTTest extends KoeTADTTest{
	
	@Override
	protected KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
	}	
}
