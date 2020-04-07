package it.polito.tdp.anagrammi.model;

import java.util.Set;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {
	
	DizionarioDAO d = new DizionarioDAO();
	
	public Set<String> anagrammiCorretti(String s){
		Ricerca r = new Ricerca();
		return d.anagrammiCorretti(r.anagrammi(s));
	}
	
	public Set<String> anagrammiSbagliati(String s){
		Ricerca r = new Ricerca();
		Set<String> risultato = r.anagrammi(s);
		risultato.removeAll(anagrammiCorretti(s));
		return risultato;
	}

}
