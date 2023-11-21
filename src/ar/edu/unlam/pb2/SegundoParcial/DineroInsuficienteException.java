package ar.edu.unlam.pb2.SegundoParcial;

public class DineroInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DineroInsuficienteException (String mensaje) {
		super(mensaje);
	}
}
