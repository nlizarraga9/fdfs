package ar.edu.unlam.pb2.SegundoParcial;

public class Achicador extends Alimento{

	public Achicador(String nombre) throws AlimentoInvalidoException {
		super(nombre);
		
		switch (nombre) {
		case "Masitas":
			this.precio = 50.0;
			break;
		case "Alfajores":
			this.precio = 100.0;
			break;
		case "Bagels" :
			this.precio = 150.0;
			break;
		default:
			throw new AlimentoInvalidoException ("El alimento achicador no existe");
		}
	}
	
	@Override
	public void consumir(Alicia alicia, Alimento alimento) throws ConsumoInvalidoException, NoSePuedeAchicarMasException{
		if (alicia.getAlimentosComprados().contains(alimento)) {
			if (alicia.getAltura() - 50 >= 50) {
				alicia.setAltura(alicia.getAltura()-50);
			} else
				throw new NoSePuedeAchicarMasException("Alicia no se puede achicar mas");
		} else
			throw new ConsumoInvalidoException ("El alimento no fue comprado");
	}

}
