package ar.edu.unlam.pb2.SegundoParcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alicia {

	private String nombre;
	private int altura;
	private int peso;
	private int edad;
	private double dinero;
	ArrayList<Alimento> alimentos = new ArrayList<>();
	ArrayList<Alimento> alimentosAchicadores = new ArrayList<>();

	public Alicia(String nombre, int altura, int peso, int edad, double dinero) {
		
		this.nombre = nombre;
		this.altura = altura;
		this.peso = peso;
		this.edad = edad;
		this.dinero = dinero;
	}
	
	public void comprar (Alimento alimento) throws DineroInsuficienteException {
		if (dinero >= alimento.precio) {
			alimentos.add(alimento);
			dinero -= alimento.precio;
			
			if (alimento instanceof Achicador) {
				alimentosAchicadores.add(alimento);
				ordenarAlimentosAchicadores();
			}
		} else
			throw new DineroInsuficienteException("Dinero insuficiente para realizar la compra");
		
	}

	public void comerAlimento(Alimento alimento) throws ConsumoInvalidoException, NoSePuedeAchicarMasException, NoSePuedeAgrandarMasException {
		alimento.consumir(this, alimento);
		alimentos.remove(alimento);
	}

	public String getNombre() {
		return nombre;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public int getEdad() {
		return edad;
	}

	public double getDinero() {
		return dinero;
	}

    public List<Alimento> getAlimentosComprados() {
        return alimentos;
    }

    public void ordenarAlimentos() {
    	ComparadorAlimento comparador = new ComparadorAlimento();
    	Collections.sort(this.alimentos, comparador);
    }
	
	private void ordenarAlimentosAchicadores() {
    	ComparadorAlimento comparador = new ComparadorAlimento();
    	Collections.sort(this.alimentosAchicadores, comparador);
	}

}
