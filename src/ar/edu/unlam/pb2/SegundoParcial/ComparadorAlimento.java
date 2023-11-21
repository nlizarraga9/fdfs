package ar.edu.unlam.pb2.SegundoParcial;

import java.util.Comparator;

public class ComparadorAlimento implements Comparator<Alimento>{

	@Override
	public int compare(Alimento a1, Alimento a2) {
		String nom1 = a1.nombre;
		String nom2 = a2.nombre;
		return nom1.compareTo(nom2);
	}
	

}
