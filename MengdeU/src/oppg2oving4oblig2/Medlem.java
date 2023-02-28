package oppg2oving4oblig2;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = -1;
	}

	public boolean passerTil(Medlem medlem2) {
		return hobbyer.equals(medlem2.getHobbyer());
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	@Override
	public String toString() {
		return "Navn: " + navn + "\nHobbyer: " + hobbyer.toString() + "\nStatusindeks: " + statusIndeks;
	}
}
