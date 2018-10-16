package edu.unlam.deposito;

public class Deposito {
	int superficie;
	int profundidad;
	int capacidad;
	double petroleoCargado;
	double alturaPetroleoCargado;
	double profundidadDisponible;
	

	public Deposito(int superficie, int profundidad) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.capacidad = superficie * profundidad;
		this.petroleoCargado = 0;
		this.alturaPetroleoCargado = 0;
		this.profundidadDisponible = this.profundidad;
	}

	@Override
	public String toString() {
		return this.superficie + " " + this.profundidad;
	}



	public double cargar(double alturaACargar) {
		this.petroleoCargado += this.superficie * alturaACargar;
		this.alturaPetroleoCargado += alturaACargar;
		this.profundidadDisponible = this.profundidad - this.alturaPetroleoCargado;
		
		return (this.superficie * alturaACargar);
	}
	
	
	
	
	
	
	
}
