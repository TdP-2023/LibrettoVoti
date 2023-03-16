package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi 1",25,LocalDate.of(2021, 2, 15)));
		lib.add(new Voto("Fisica 1",19,LocalDate.of(2021, 3, 15)));
		lib.add(new Voto("AA 2",26,LocalDate.of(2021, 9, 15)));
		
		System.out.println("Stampo voti con punteggio uguale a 25");
		lib.stampaPuntiUguali(25);
		try {
			System.out.println("Ricerco voto per Nome: ");
			System.out.println(lib.ricercaVotoPerNome("Analisi 1"));}
			catch(Exception e) {
				System.out.println(e.getMessage());
		}
		//Voto a1Bis=new Voto("Analisi 1",25,LocalDate.of(2021, 3, 15));
		try {
			System.out.println("\n \n Tentativo inserimento nuovo voto ");
			Voto a1Bis=new Voto("Analisi 1",23,LocalDate.of(2021, 2, 15));
			lib.add(a1Bis);
		}catch (IllegalArgumentException e) {
			System.out.println("Errore inserimento voto");
			System.out.print(e.getMessage());
		}
		
		Libretto migliore=lib.librettoMigliorato();
		System.out.println("\nLibretto migliorato: ");
		migliore.stampa();
		System.out.println("\nLibretto originario: ");
		lib.stampa();
		//lib.cancellaVotiInferiori(24);
		//System.out.println("Libretto originario <24");
		//lib.stampa();
		
		System.out.println("Libretto originario ordinato byName");
		lib.librettoOrdinatoAlfabeticamente().stampa();
		
		System.out.println("Libretto originario ordinato perVoto");
		lib.librettoOrdinatoPerVoto().stampa();
	}

}
