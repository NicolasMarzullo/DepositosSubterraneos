package edu.unlam.test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import edu.unlam.deposito.ArchivoDeposito;
import edu.unlam.deposito.Deposito;
import edu.unlam.deposito.Sistema;

public class TestsDeposito {
	
	@Test
	public void testDeCarga() throws IOException {
		Sistema sistema = ArchivoDeposito.leer("tests/lotes/in/01_CasoEnunciado.in");
		
		List<Deposito> depositos = sistema.getDepositos();
		
		for(Deposito depo : depositos)
			System.out.println(depo);

	}

	@Test
	public void casoEnunciado01() throws IOException {
		Sistema sistema = ArchivoDeposito.leer("tests/lotes/in/01_CasoEnunciado.in");
		ArchivoDeposito.escribir("tests/lotes/out/01_CasoEnunciado.out", sistema.resolver());
			
	}
	
	
	@Test
	public void casoEnunciado02() throws IOException {
		Sistema sistema = ArchivoDeposito.leer("tests/lotes/in/02_CasoEnunciado.in");
		ArchivoDeposito.escribir("tests/lotes/out/02_CasoEnunciado.out", sistema.resolver());
			
	}
	
	@Test
	public void casoTanquesMismaProfundidad() throws IOException {
		Sistema sistema = ArchivoDeposito.leer("tests/lotes/in/03_CasoTanquesMismaProfundidad.in");
		ArchivoDeposito.escribir("tests/lotes/out/03_CasoTanquesMismaProfundidad.out", sistema.resolver());
			
	}
	
	@Test
	public void TodosLosTanquesMismaProfunidad() throws IOException {
		Sistema sistema = ArchivoDeposito.leer("tests/lotes/in/04_TodosLosTanquesConMismaProfundidad.in");
		ArchivoDeposito.escribir("tests/lotes/out/04_TodosLosTanquesConMismaProfundidad.out", sistema.resolver());
			
	}
	
	@Test
	public void TanquesMismaProfundidadIntermedios() throws IOException {
		Sistema sistema = ArchivoDeposito.leer("tests/lotes/in/05_TanquesMismaProfundidadIntermedios.in");
		ArchivoDeposito.escribir("tests/lotes/out/05_TanquesMismaProfundidadIntermedios.out", sistema.resolver());
			
	}
}
