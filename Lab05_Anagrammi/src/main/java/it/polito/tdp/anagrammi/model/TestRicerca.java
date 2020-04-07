package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class TestRicerca {

	public static void main(String[] args) {
		
		String s="ciao";
		System.out.println("Anagrammi di "+":");
		Ricerca r = new Ricerca() ;
		Set<String> anagrammi = r.anagrammi(s) ;
		System.out.println(anagrammi) ;
		
		String s1="cocco";
		System.out.println("Anagrammi di "+":");
		Ricerca r1 = new Ricerca() ;
		Set<String> anagrammi1 = r1.anagrammi(s1) ;
		System.out.println(anagrammi1) ;
	}

}
