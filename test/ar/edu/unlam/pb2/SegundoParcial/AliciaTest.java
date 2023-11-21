package ar.edu.unlam.pb2.SegundoParcial;

import static org.junit.Assert.*;

import org.junit.Test;

public class AliciaTest {

	@Test
	public void queSePuedaCrearAAlicia() {
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		assertNotNull(alicia);
	}
	
	@Test
	public void queSePuedaComprarAlimentosYSeDescuenteElDinero() throws DineroInsuficienteException, AlimentoInvalidoException {
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		Achicador masitas = new Achicador("Masitas");
		Agrandador caramelos = new Agrandador ("Caramelos");
		
		alicia.comprar(caramelos);
		alicia.comprar(masitas);
		
		Double esperado = 400.0;
		Double obtenido = alicia.getDinero();
		
		assertEquals(esperado,obtenido);
		
	}
	
	@Test (expected = DineroInsuficienteException.class)
	public void queNoSePuedaComprarAlimentosSiNoAlcanzaElDinero() throws DineroInsuficienteException, AlimentoInvalidoException {
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		Achicador alfajores = new Achicador("Alfajores");
		Agrandador caramelos = new Agrandador ("Caramelos");
		
		alicia.comprar(caramelos);
		alicia.comprar(alfajores);
		alicia.comprar(alfajores);
		alicia.comprar(alfajores);
		alicia.comprar(alfajores);
		alicia.comprar(alfajores);
		
	}
	
	@Test
	public void queAlConsumirUnAchicadorSeAchique() throws DineroInsuficienteException, ConsumoInvalidoException, NoSePuedeAchicarMasException, NoSePuedeAgrandarMasException, AlimentoInvalidoException {
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		Achicador masitas = new Achicador("Masitas");
		
		alicia.comprar(masitas);
		alicia.comerAlimento(masitas);
		
		Double esperadoD = 450.0;
		Integer esperado = 130;
		
		Double obtenidoD = alicia.getDinero();
		Integer obtenido = alicia.getAltura();
		
		assertEquals(esperado, obtenido);
		assertEquals(esperadoD, obtenidoD);

	}
	
	@Test (expected = NoSePuedeAchicarMasException.class)
	public void queAlConsumirUnAchicadorNoSeAchiqueMasDelLimite() throws DineroInsuficienteException, ConsumoInvalidoException, NoSePuedeAchicarMasException, NoSePuedeAgrandarMasException, AlimentoInvalidoException {
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		Achicador masitas = new Achicador("Masitas");
		
		alicia.comprar(masitas);
		alicia.comprar(masitas);
		alicia.comprar(masitas);
		alicia.comprar(masitas);
		alicia.comerAlimento(masitas);
		alicia.comerAlimento(masitas);
		alicia.comerAlimento(masitas);
		alicia.comerAlimento(masitas);

	}
	
	@Test
	public void queAlConsumirUnAgrandadorSeAgrande() throws DineroInsuficienteException, ConsumoInvalidoException, NoSePuedeAchicarMasException, NoSePuedeAgrandarMasException, AlimentoInvalidoException {
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		Agrandador gomitas = new Agrandador ("Gomitas");
		
		alicia.comprar(gomitas);
		alicia.comerAlimento(gomitas);
		
		Double esperadoD = 400.0;
		Integer esperado = 220;
		
		Double obtenidoD = alicia.getDinero();
		Integer obtenido = alicia.getAltura();
		
		assertEquals(esperado, obtenido);
		assertEquals(esperadoD, obtenidoD);

	}
	
	@Test (expected = NoSePuedeAgrandarMasException.class)
	public void queAlConsumirUnAgrandadorNoSeAgrandeMasDelLimite() throws DineroInsuficienteException, ConsumoInvalidoException, NoSePuedeAchicarMasException, NoSePuedeAgrandarMasException, AlimentoInvalidoException {
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		Agrandador gomitas = new Agrandador ("Gomitas");
		
		alicia.comprar(gomitas);
		alicia.comprar(gomitas);
		alicia.comprar(gomitas);
		alicia.comprar(gomitas);
		alicia.comerAlimento(gomitas);
		alicia.comerAlimento(gomitas);
		alicia.comerAlimento(gomitas);
		alicia.comerAlimento(gomitas);
	}
	
	@Test
	public void queAlConsumirUnAlimentoSeDescuenteDelStockDisponibleParaConsumo() throws DineroInsuficienteException, ConsumoInvalidoException, NoSePuedeAchicarMasException, NoSePuedeAgrandarMasException, AlimentoInvalidoException {
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		Agrandador gomitas = new Agrandador ("Gomitas");
		
		alicia.comprar(gomitas);
		alicia.comprar(gomitas);
		alicia.comerAlimento(gomitas);
		
		Integer esperado = 1;
		Integer obtenido = alicia.alimentos.size();
		
		assertEquals (esperado, obtenido);
	}
	
	@Test (expected = ConsumoInvalidoException.class)
	public void queNoSePuedaConsumirUnAlimentoQueNoFueComprado() throws ConsumoInvalidoException, NoSePuedeAchicarMasException, NoSePuedeAgrandarMasException, AlimentoInvalidoException{
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		Agrandador gomitas = new Agrandador ("Gomitas");

		alicia.comerAlimento(gomitas);
	}
	
	@Test
	public void queLosAlimentosEstenOrdenados() throws DineroInsuficienteException, AlimentoInvalidoException {
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		Achicador masitas = new Achicador ("Masitas");
		Agrandador gom = new Agrandador ("Gomitas");
		Achicador alfajores = new Achicador ("Alfajores");
		Agrandador bom = new Agrandador ("BocadChocolate");
		
		alicia.comprar(gom);
		alicia.comprar(alfajores);
		alicia.comprar(masitas);
		alicia.comprar(bom);
		
		alicia.ordenarAlimentos();
		assertEquals(alfajores, alicia.getAlimentosComprados().get(0));
		assertEquals(masitas, alicia.getAlimentosComprados().get(3));
	}
	
	@Test
	public void queLosAlimentosAchicadoresSeGuardenOrdenados() throws DineroInsuficienteException, AlimentoInvalidoException {
		Alicia alicia = new Alicia ("Alicia", 180, 70, 20, 500.0);
		Achicador bagels = new Achicador ("Bagels");
		Achicador masitas = new Achicador ("Masitas");
		Achicador alfajores = new Achicador ("Alfajores");
		
		alicia.comprar(bagels);
		alicia.comprar(alfajores);
		alicia.comprar(masitas);
		
		alicia.ordenarAlimentos();
		assertEquals(alfajores, alicia.alimentosAchicadores.get(0));
		assertEquals(masitas, alicia.alimentosAchicadores.get(2));
	}

}
