package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}

	/**
	 * Aggiungi un nuovo voto al libretto (per ora non fa nessun controll)
	 * 
	 * @param v il Voto da aggiungere
	 * @return true
	 */
	public boolean add(Voto v) {
		if (this.esisteVotoConflitto(v) ||
				this.esisteVotoDuplicato(v))  {
			throw new IllegalArgumentException("Voto errato: "+v);
		}
		return this.voti.add(v);
	}

	public void stampa() {
		for (Voto v : this.voti) {
			System.out.println(v);
		}
	}

	public void stampaPuntiUguali(int valore) {
		for (Voto v : this.voti) {
			if (v.getPunti() == valore) {
				System.out.println(v);
			}
		}
	}

	public Voto cercaVotoPerNome(String corso) {
		for (Voto v : this.voti) {
//			if(v.getCorso().compareTo(corso)==0) 
			if (v.getCorso().equals(corso)) {
				return v;
			}
		}

		return null;

//		throw new RuntimeException("Voto non trovato") ;
	}

	public boolean esisteVotoDuplicato(Voto nuovo) {
		for (Voto v : this.voti) {
			if(v.isDuplicato(nuovo))
				return true;
		}
		return false;
	}

	public boolean esisteVotoConflitto(Voto nuovo) {
		for (Voto v : this.voti) {
			if(v.isConflitto(nuovo)) {
				return true;
			}
		}
		return false ;
	}

	/**
	 * Metodo 'factory' per creare un nuovo libretto
	 * con i voti migliorati.
	 * 
	 * @return
	 */
	public Libretto librettoMigliorato() {
		Libretto migliore = new Libretto() ;
		migliore.voti = new ArrayList<>() ;
		for(Voto v: this.voti) {
			migliore.voti.add(v.clone()) ;
//			migliore.voti.add(new Voto(v)) ;
		}
		for(Voto v : migliore.voti ) {
			v.setPunti(v.getPunti()+2);
		}
		return migliore ;
	}
	
	public void cancellaVotiInferiori(int punti) {
		for(Voto v: this.voti) {
			if(v.getPunti()<punti) {
				this.voti.remove(v) ;
			}
		}
		
//		for(int i=0; i<this.voti.size(); i++) {
//			if(this.voti.get(i).getPunti()<punti) {
//				this.voti.remove(i);
//			}
//		}
	}
	
}
