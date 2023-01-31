package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.adt.*;

public abstract class KoeTADTTest {

	// Referanse til koe
	private KoeADT<Integer> Koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Hent en ny koe for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		Koe = reset();
	}

	/**
	 * Test paa at en ny koe er tom.
	 */
	@Test
	public void nyKoeErTom() {
		assertTrue(Koe.erTom());
	}

	/**
	 * Test paa inn and ut.
	 */
	@Test
	public void innOgUt() {

		Koe.innKoe(e0);
		Koe.innKoe(e1);
		Koe.innKoe(e2);
		Koe.innKoe(e3);

		try {
			assertEquals(e3, Koe.utKoe());
			assertEquals(e2, Koe.utKoe());
			assertEquals(e1, Koe.utKoe());
			assertEquals(e0, Koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("Ut feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test paa inn og ut med duplikate verdier.
	 */
	@Test
	public void innOgUtMedDuplikater() {

		Koe.innKoe(e0);
		Koe.innKoe(e1);
		Koe.innKoe(e1);
		Koe.innKoe(e2);

		try {
			assertEquals(e2, Koe.utKoe());
			assertEquals(e1, Koe.utKoe());
			assertEquals(e1, Koe.utKoe());
			assertEquals(e0, Koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("Ut feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing paa foerste.
	 */
	@Test
	public void innUtInnInnUtFoerste() {
		try {
			Koe.innKoe(e2);
			Koe.utKoe();
			Koe.innKoe(e3);
			Koe.innKoe(e4);
			Koe.utKoe();
			assertEquals(e3, Koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("Ut eller foerste feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test paa at en koe med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		Koe.innKoe(e0);
		Koe.innKoe(e1);
		assertFalse(Koe.erTom());
	}

	/**
	 * Test paa at en koe med null elementer er tom.
	 */
	@Test
	public void innUtErTom() {
		try {
			Koe.innKoe(e0);
			Koe.utKoe();
			assertTrue(Koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("inn eller ut feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Forsok paa ut av en tom koe skal gi "underflow excepton" *
	 * 
	 * @throws EmptyCollectionException expected exception
	 */
	@Test
	public void utFromEmptyIsUnderflowed() {
		/*
		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
		 * 
		 * @Override public void execute() throws Throwable { stabel.pop(); } });
		 */

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			Koe.utKoe();
		});
	}

}
