package ar.edu.unlam.pb2.SegundoParcial;

public class AlimentoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AlimentoInvalidoException (String mensaje) {
		super(mensaje);
	}

}
