package oppg2oving4oblig2;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class MedlemKlient {
	public static void main(String[] args) {
        Hobby hobby1 = new Hobby("Tennis");
        Hobby hobby2 = new Hobby("Basketball");
        Hobby hobby3 = new Hobby("Fotball");
//        Hobby hobby4 = new Hobby("Sykle");

        Medlem medlem1 = new Medlem("Thomas", new KjedetMengde<>());
        Medlem medlem2 = new Medlem("Pål", new KjedetMengde<>());
        Medlem medlem3 = new Medlem("Per", new TabellMengde<>());

        medlem1.getHobbyer().leggTil(hobby1);
        medlem1.getHobbyer().leggTil(hobby2);

        medlem2.getHobbyer().leggTil(hobby1);
        medlem2.getHobbyer().leggTil(hobby2);

        medlem3.getHobbyer().leggTil(hobby1);
        medlem3.getHobbyer().leggTil(hobby3);

        System.out.println(medlem1.toString());
        System.out.println(medlem2.toString());
        System.out.println(medlem3.toString());

        System.out.println("medlem1 passer med medlem2: " + medlem1.passerTil(medlem2));
        System.out.println("medlem1 passer med medlem3: " + medlem1.passerTil(medlem3));
    }
}
