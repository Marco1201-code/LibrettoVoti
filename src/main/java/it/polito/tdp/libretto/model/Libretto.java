package it.polito.tdp.libretto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti ;
	
	

	public Libretto() {
		super();
		this.voti = new ArrayList<Voto>() ;
	}

	public List<Voto> getVoti() {
		return voti;
	}

	public void setVoti(List<Voto> voti) {
		this.voti = voti;
	}
	
	public boolean  add(Voto v) {
		if(this.isConflitto(v) || this.esiste(v)) {
			return false; 
		}
		else {
		this.voti.add(v);
		 return true ; 
		}
	}
	

	
	public Libretto corsiConVoto(int voto){
		Libretto temp = new Libretto();
		for(Voto v : this.voti) {
			if(v.getVoto()==voto) {
				temp.add(v);
			}
		}
		return temp;
	}

	@Override
	public String toString() {
		return this.voti.toString();
	}
	
	public Voto cercaCorso(String nomeCorso) {
		int pos = this.voti.indexOf(new Voto(nomeCorso,0,null));
	    if(pos!=-1) {
	    	return this.voti.get(pos);
	    } else {
	    	return null ;
	    }	
	}
	
	public boolean esiste(Voto voto) {
	  Voto esiste = this.cercaCorso(voto.getNomeCorso());
	  if(esiste==null) {
		  return false ;
	  }
	  
	  return esiste.getVoto()== voto.getVoto();
	  
	}
	
	public boolean isConflitto(Voto voto) {
		Voto esiste = this.cercaCorso(voto.getNomeCorso());
		  if(esiste==null) {
			  return false ;
		  }
		  
		  return esiste.getVoto()!= voto.getVoto();
		  
	}
	
	public Libretto migliorato() {
		Libretto migliorato = new Libretto();
	
		for(Voto voto : this.voti) {
			Voto v = voto.clona();
			if(v.getVoto()<24) {
			  v.setVoto(v.getVoto()+1);
			}
			else if (v.getVoto()<=28) {
				v.setVoto(v.getVoto()+2);
				
			}
			migliorato.add(v);
		}
		
		return migliorato ;
	}
	
}
