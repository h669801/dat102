package no.hvl.dat102.tabell;

public class Main3a {
	    public static void main(String[] args) {
	        Parentessjekker sjekker = new Sjekker();
	        String[] strenger = {"(abc]", "{abc}", "[(abc)]", "{(abc})", "{(abc])}", "abc", "(abc))"};

	        for (String s : strenger) {
	            if (sjekker.erBalansert(s)) {
	                System.out.println(s + " er balansert");
	            } else {
	                System.out.println(s + " er ikke balansert");
	            }
	        }
	    }
	}
