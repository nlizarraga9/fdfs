package ar.edu.unlam.pb2.SegundoParcial;

public class NoSePuedeAchicarMasException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoSePuedeAchicarMasException (String mensaje) {
		super(mensaje);
	}

}
