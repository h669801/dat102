package no.hvl.dat102.tabell;

public class Sjekker implements Parentessjekker{

	@Override
    public boolean erVenstreparentes(char p) {
        return p == '(' || p == '[' || p == '{';
    }

    @Override
    public boolean erHogreparentes(char p) {
        return p == ')' || p == ']' || p == '}';
    }

    @Override
    public boolean erParentes(char p) {
        return erVenstreparentes(p) || erHogreparentes(p);
    }

    @Override
    public boolean erPar(char venstre, char hogre) {
        if (venstre == '(') {
            return hogre == ')';
        } else if (venstre == '[') {
            return hogre == ']';
        } else if (venstre == '{') {
            return hogre == '}';
        } else {
            return false;
        }
    }

    @Override
    public boolean erBalansert(String s) {
        int antallParenteser = 0;
        int antallFirkanter = 0;
        int antallKrøller = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                antallParenteser++;
            } else if (c == ')') {
                antallParenteser--;
            } else if (c == '[') {
                antallFirkanter++;
            } else if (c == ']') {
                antallFirkanter--;
            } else if (c == '{') {
                antallKrøller++;
            } else if (c == '}') {
                antallKrøller--;
            }
            if (antallParenteser < 0 || antallFirkanter < 0 || antallKrøller < 0) {
                return false;
            }
        }
        return antallParenteser == 0 && antallFirkanter == 0 && antallKrøller == 0;
    }
}
