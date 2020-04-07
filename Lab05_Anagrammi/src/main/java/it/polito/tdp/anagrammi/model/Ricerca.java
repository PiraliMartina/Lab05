package it.polito.tdp.anagrammi.model;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Ricerca {
	
	private int N;
	private Set<String> anagrammi;
	private List<Character> parola = new LinkedList<Character>();

	public Set<String> anagrammi(String s) {
		
		N = s.length();
		
		for(int i=0; i<N; i++) {
			parola.add(s.charAt(i));
		}
		
		String parziale = "";
		int livello = 0;
		
		anagrammi = new HashSet<String>();
		
		ricorsiva(parziale, livello, parola);
		
		return anagrammi;
	}

	private void ricorsiva(String parziale, int livello, List<Character> disponibili) {
		
		if(livello == N) {
			anagrammi.add(parziale);
		}
		else {
			for(Character ch: disponibili) {
				
				String daPassare = parziale + ch;
				List<Character> rimanenti = new LinkedList<Character>(disponibili);
				rimanenti.remove(ch);
				ricorsiva(daPassare, livello+1, rimanenti);
			
			}
		}
		
	}

}
