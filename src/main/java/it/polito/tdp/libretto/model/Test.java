package it.polito.tdp.libretto.model;
import java.time.LocalDate;
import java.util.List;

public class Test {

	public void run() {
        
		
		
		Libretto lib = new Libretto();
		
		Voto v1 = new Voto("Analisi II" , 25 ,LocalDate.of(2019,12,01));
		Voto v2 = new Voto("Fisica I" , 30 ,LocalDate.of(2019,03,04));
		Voto v3 = new Voto("Chimica" , 18 ,LocalDate.of(2020,05,04));
		
		
	    lib.add(v1);
	    lib.add(v2);
		lib.add(v3);
		
		
		System.out.println(lib);
		
		Libretto l = lib.corsiConVoto(30);
		System.out.println(l);
		
		
		
		System.out.println(lib.cercaCorso("Analisi II"));
		
		Voto copia= new Voto("Analisi II" , 25 ,LocalDate.of(2019,12,01));
		//devo verificare se c'è già questo oggetto voto.
		
		Libretto migliorato = lib.migliorato();
		System.out.println(migliorato);
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Test test = new Test();
        test.run();
		
	}

}
