package it.polito.tdp.ruzzle.model;

import java.util.*;

public class Ricorsione {
	
	public List<Pos> trovaParola (String parola, Board board) {

		//cercare la prima lettera
		for(Pos p: board.getPositions()) {
			if(board.getCellValueProperty(p).get().charAt(0)==parola.charAt(0)) {
				//chiamo la ricorsione
				List<Pos> parziale = new ArrayList<>();
				parziale.add(p);
				if(cerca(parola, board, parziale, 1)==true)
					return parziale;
			}
		}		
		return null;
	}

	private boolean cerca(String parola, Board board, List<Pos> parziale, int i) {
		
		//condizioni terminali
		if(i==parola.length())
			return true;
		
		//ricorsione
		Pos ultima = parziale.get(parziale.size()-1);
		List<Pos> adiacenti = board.getAdjacencies(ultima);
		for(Pos a: adiacenti) { //controlliamo ciascuna delle parole adiacenti per verificare se sono presenti nella parola
			if(board.getCellValueProperty(a).get().charAt(0)==parola.charAt(i) && !parziale.contains(a)) {
				parziale.add(a);
				cerca(parola, board, parziale, i+1);
				parziale.remove(a);
			}
		}
		
		return false;
	}

}
