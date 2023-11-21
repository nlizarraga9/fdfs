package ar.edu.unlam.pb2.SegundoParcial;


public abstract class Alimento implements Comparable<Alimento> {

	String nombre;
	Double precio;
	
	public Alimento(String nombre) {
		this.nombre = nombre;
	}
	
	protected abstract void consumir (Alicia alicia, Alimento alimento) throws ConsumoInvalidoException, NoSePuedeAchicarMasException, NoSePuedeAgrandarMasException;

	public String getNombre() {
		return nombre;
	}
	
    @Override
    public int compareTo(Alimento otroAlimento) {
        return this.nombre.compareTo(otroAlimento.nombre);
    }
    
	@Override
	public String toString() {
		return nombre;
	}

}
