package ar.edu.unlam.pb2.SegundoParcial;

public class Agrandador extends Alimento{

	public Agrandador(String nombre) throws AlimentoInvalidoException {
		super(nombre);
		
		switch (nombre) {
		case "Caramelos":
			this.precio = 50.0;
			break;
		case "Gomitas":
			this.precio = 100.0;
			break;
		case "BocadChocolate" :
			this.precio = 150.0;
			break;
		default:
			throw new AlimentoInvalidoException ("El alimento agrandador no existe");
		}
	}
	
	@Override
	public void consumir(Alicia alicia, Alimento alimento) throws ConsumoInvalidoException, NoSePuedeAgrandarMasException{
		if (alicia.getAlimentosComprados().contains(alimento)) {
			if (alicia.getAltura() + 40 <= 280) {
				alicia.setAltura(alicia.getAltura()+40);
			} else
				throw new NoSePuedeAgrandarMasException("Alicia no se puede agrandar mas");
		} else
			throw new ConsumoInvalidoException ("El alimento no fue comprado");
	}

}