package it.polito.tdp.libretto.model;
import java.time.*;

public class Voto {
	private String corso;
	private int punti; // da 18 a 31
	private LocalDate dataEsame;
	
	public Voto(String corso, int punti, LocalDate dataEsame) {
		super();
		this.corso = corso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}
	
	//COPY CONSTRUCTOR, PUO ESSERE UTILIZZATO IN ALTERNATIVA AL CLONE
	public Voto(Voto voto) {
		this.corso = voto.corso;
		this.punti = voto.punti;
		this.dataEsame = voto.dataEsame;
	}
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public LocalDate getDataEsame() {
		return dataEsame;
	}
	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}
	@Override
	public String toString() {
		return "Voto [corso=" + corso + ", punti=" + punti + ", dataEsame=" + dataEsame + "]";
	}
	
	public boolean isDuplicato(Voto altro) {
		return this.getCorso().equals(altro.getCorso()) && this.getPunti()== altro.getPunti();
		
	}
	public boolean isConflitto(Voto altro) {
		return this.getCorso().equals(altro.getCorso()) && this.getPunti()!= altro.getPunti();
		
	}
	
	public Voto clone() {
		return new Voto(this.corso,this.punti, this.dataEsame);
	}

	
	
	
	

}
