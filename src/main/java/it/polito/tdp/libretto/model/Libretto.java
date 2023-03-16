package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Libretto {
	private List<Voto> voti; // utilizziamo l'interfaccia e non le classi!!! in questo modo se modifico non sarà un problema

	public Libretto() {
		this.voti=new ArrayList<Voto>(); // qua decidiamo se utilizzare Arraylist o LinkedList
	}
	
	public boolean add(Voto v) {
		if (this.esisteVotoConflitto(v) || this.esisteVotoDuplicato(v)) {
			System.out.println("Voto Errato");
			throw new IllegalArgumentException("Voto Errato: "+v);
			//non aggiungere voto
		}
		return this.voti.add(v); 
	}
		
		
		/**
		 * aggiungi un nuovo voto al libretto
		 * @param v il Voto da Aggiungere 
		 */
	
	
	public String stampa() {
		String stringa="";
		for (Voto v:this.voti) {
			if (stringa.equals(""))
				stringa+=v.toString();
			else
				stringa+="\n "+v.toString();}
		return stringa;
				
			
	}
	
	public void stampaPuntiUguali(int valore) {
		for (Voto v:this.voti) {
			if (v.getPunti()==valore)
				System.out.println(v);}	
	}
	
	public Voto ricercaVotoPerNome(String corso) {
		for (Voto v:this.voti) {
			if (v.getCorso().compareTo(corso)==0)
				return v;}
		throw new RuntimeException("Voto non trovato") ;}
		
	public boolean esisteVotoDuplicato(Voto nuovo) {
		for (Voto v:this.voti) {
			if(v.isDuplicato(nuovo))
				return true;}
		return false;
		
		}
	
	public boolean esisteVotoConflitto(Voto nuovo) {
		for (Voto v:this.voti) {
			if(v.isConflitto(nuovo))
				return true;}
		return false;}
	
	/**
	* Questa classe ha un metodo che restituisce un oggetto della stessa classe!
	*metodo di 'factory'
	*creo nuovo libretto con nomi migliorati.
	*@ return 
	*/
	
	public Libretto librettoMigliorato() {
		Libretto migliore=new Libretto();
		// non posso copiare semplicemente la lista di questo libretto per creare quella di migliore!!1
		// devo creare un clone di questa lista.
		
		migliore.voti=new ArrayList<>();
		
		/**
		 * ATTENZIONE!! DEVO COPIARE GLI OGGETTI, NON POSSO SEMPLICEMENTE INCREMENTARE IL VOTO
		 * ALTRIMENTI MODIFICHEREI GLI OGGETTI ANCHE DELLA LISTA NON MODIFICATA
		 * NOTA: DOVREI FARE LA COPIA FINO A QUANDO NON OTTENGO OGGETTI IMMUTABILI!
		 * @return
		 */
		
		for( Voto v: this.voti) {
			migliore.voti.add(v.clone());
		}
		
		// dopo aver modificato 
		for( Voto v: migliore.voti) {
			v.setPunti(v.getPunti()+2);
		}
		/**
		 * NOTA: se facessi :
		 * migliore.voti=new ArrayList<>(this.voti); creerei una lista con esattamente gli stessi voti dentro.
		 * Nel momento in cui vado a modificare il voto all'interno di questa lista, sto modificando anche il voto all'interno dell'altra
		 * ho bisogno di creare dei voti clonati
		 */
		
		
		return migliore;
	}
	public void cancellaVotiInferiori(int punti) {
		List<Voto> daCancellare=new ArrayList<Voto>();
		for(Voto v:this.voti) {
			if (v.getPunti()<punti) {
				daCancellare.add(v);
			}
		}
		/**
		 *  meglio: this.voti.removeAll(daCancellare);
		 */
		
		for (Voto v1: daCancellare) {
			this.voti.remove(v1);
		}
		
		
		/*ERRATO!!! NON SI MODIFICA MAI LA LISTA CHE STO MODIFICANDO. NON POSSO ITERARE SU UNA LISTA CHE STO MODIFICANDO
		 * QUINDI CREO UNA LISTA CHE MI CONTA TUTTI I VOTI CHE DEVO CANCELLARE E POI DALLA LISTA ORIGINALE RIMUOVO QUEI VOTI
		 * ITERNADO QUESTA VOLTA SULL'ALTRA LISTA!!!!
		for (int i=0;i<this.voti.size();i++) {
			this.voti.remove(i);
		}*/
	}
	
	public Libretto librettoOrdinatoAlfabeticamente() {
		Libretto ordinato=new Libretto();
		ordinato.voti=new ArrayList<>(this.voti);// CREO UNA COPIA DELLA LISTA ORDINATA! IN QUESTO MODO MANTENGO ANCHE LA LISTA NONORDINATA
		ordinato.voti.sort(new ComparatorByName());// QUESTO METODO RICHIEDE UN COMPARATORE!!
		// Collections.sort(ordinato.voti,new ComparatorByName()); // IN QUESTO METODO INVECE SE NON INSERISCO IL COMPARATORE,
		//															   LA LISTA VIENE ORDINATA SECONDO IL COMPARE TO
		
		return ordinato;
		
		
	}
	
	public Libretto librettoOrdinatoPerVoto() {
		Libretto ordinato=new Libretto();
		ordinato.voti=new ArrayList<>(this.voti);
		ordinato.voti.sort(new Comparator<Voto>(){// CLASSE INLINE, NON STO CREANDO UNA NUOVA CLASSE COMPARATORE, MA LA STO SCRIVENDO DIRETTAMENTE QUA
                                                  // CREO IN QUESTO MODO UNA CLASSE ANONIMA
			@Override
			public int compare(Voto o1, Voto o2) {
				
				return o2.getPunti()-o1.getPunti(); //ordinamento decrescente
			}});
		
		return ordinato;
		
	}
	
	
}
