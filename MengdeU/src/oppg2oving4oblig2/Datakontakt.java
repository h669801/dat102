package oppg2oving4oblig2;

public class Datakontakt {
	private Medlem[] medlemstabell;
    private int antallMedlemmer;

    public Datakontakt(int maksAntallMedlemmer) {
        medlemstabell = new Medlem[maksAntallMedlemmer];
        antallMedlemmer = 0;
    }

    public void leggTilMedlem(Medlem person) {
        medlemstabell[antallMedlemmer] = person;
        antallMedlemmer++;
    }

    public int finnMedlemsIndeks(String medlemsnavn) {
        for (int i = 0; i < antallMedlemmer; i++) {
            if (medlemstabell[i].getNavn().equals(medlemsnavn)) {
                return i;
            }
        }
        return -1;
    }

    public int finnPartnerFor(String medlemsnavn) {
        int indeks = finnMedlemsIndeks(medlemsnavn);
        if (indeks == -1) {
            return -1; // medlemmet finnes ikke i medlemstabellen
        }
        Medlem medlem = medlemstabell[indeks];
        if (medlem.getStatusIndeks() != -1) {
            return -1; // medlemmet har allerede en partner
        }
        for (int i = 0; i < antallMedlemmer; i++) {
            if (i != indeks && medlem.passerTil(medlemstabell[i]) && medlemstabell[i].getStatusIndeks() == -1) {
                medlem.setStatusIndeks(i);
                medlemstabell[i].setStatusIndeks(indeks);
                return i;
            }
        }
        return -1; // ingen passende partner funnet
    }

    public void tilbakestillStatusIndeks(String medlemsnavn) {
        int indeks = finnMedlemsIndeks(medlemsnavn);
        if (indeks != -1) {
            Medlem medlem = medlemstabell[indeks];
            int partnerIndeks = medlem.getStatusIndeks();
            if (partnerIndeks != -1) {
                medlem.setStatusIndeks(-1);
                medlemstabell[partnerIndeks].setStatusIndeks(-1);
            }
        }
    }

	public int getAntallMedlemmer() {
		// TODO Auto-generated method stub
		return antallMedlemmer;
	}

	public Medlem[] getMedlemTabell() {
		// TODO Auto-generated method stub
		return medlemstabell;
	}
}
