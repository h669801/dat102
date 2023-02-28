package TestMengde;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class testMengde {

	private KjedetMengde<Integer> m1;
	private KjedetMengde<Integer> m2;
	private KjedetMengde<Integer> emptySet;

	@BeforeEach
	void setUp() {
		m1 = new KjedetMengde<>();
		m2 = new KjedetMengde<>();
		emptySet = new KjedetMengde<>();

		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);

		m2.leggTil(3);
		m2.leggTil(4);
		m2.leggTil(5);
	}

	@Test
	void testUnion_fellesElement() {
		KjedetMengde<Integer> union = new KjedetMengde<>();
		union.leggTil(1);
		union.leggTil(2);
		union.leggTil(3);
		union.leggTil(4);
		union.leggTil(5);

		assertEquals(union, m1.union(m2));
		assertEquals(union, m2.union(m1));
	}

	@Test
	void testUnion_usammenhengende() {
		KjedetMengde<Integer> union = new KjedetMengde<>();
		KjedetMengde m1 = new KjedetMengde();
	    m1.leggTil(1);
	    m1.leggTil(2);
	    m1.leggTil(3);

	    KjedetMengde m2 = new KjedetMengde();
	    m2.leggTil(4);
	    m2.leggTil(5);
	    m2.leggTil(6);

	    KjedetMengde forventet = new KjedetMengde();
	    forventet.leggTil(1);
	    forventet.leggTil(2);
	    forventet.leggTil(3);
	    forventet.leggTil(4);
	    forventet.leggTil(5);
	    forventet.leggTil(6);

	    KjedetMengde resultat = (KjedetMengde) m1.union(m2);

	    assertEquals(forventet, resultat);
	}

	@Test
	void testSnitt_fellesElement() {
		KjedetMengde<Integer> snitt = new KjedetMengde<>();
		snitt.leggTil(3);

		assertEquals(snitt, m1.snitt(m2));
		assertEquals(snitt, m2.snitt(m1));
	}

	@Test
	void testSnitt_usammenhengende() {
		KjedetMengde<Integer> snitt = new KjedetMengde<>();

		assertEquals(snitt, m1.snitt(emptySet));
		assertEquals(snitt, emptySet.snitt(m2));
	}

	@Test
	void testDifferens_fellesElement() {
		KjedetMengde<Integer> differens1 = new KjedetMengde<>();
		differens1.leggTil(1);
		differens1.leggTil(2);

		KjedetMengde<Integer> differens2 = new KjedetMengde<>();
		differens2.leggTil(4);
		differens2.leggTil(5);

		assertEquals(differens1, m1.differens(m2));
		assertEquals(differens2, m2.differens(m1));
	}

	@Test
	void testDifferens_usammenhengende() {
		assertEquals(m1, m1.differens(emptySet));
		assertEquals(m2, emptySet.differens(m2));
	}
}