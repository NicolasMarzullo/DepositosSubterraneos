package edu.unlam.deposito;

import java.util.List;

public class Salida {

	private int cantTanquesUsados;
	private int rebasan;
	private List<Deposito> depositos;
	

	public Salida(int cantTanquesUsados, int rebasan, List<Deposito> depositos) {
		this.cantTanquesUsados = cantTanquesUsados;
		this.rebasan = rebasan;
		this.depositos = depositos;
	}

	public int getCantTanquesUsados() {
		return cantTanquesUsados;
	}

	public int getRebasan() {
		return rebasan;
	}

	public List<Deposito> getDepositos() {
		return depositos;
	}

	
	
	
}
