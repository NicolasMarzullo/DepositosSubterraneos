package edu.unlam.deposito;

import java.util.List;

public class Sistema {
	private int cantidadDeDepositos;
	private int capacidadTotal;
	private List<Deposito> depositos;
	private int petroleoACargar;

	public Sistema(int cantidadDeDepositos, int capacidadTotal, List<Deposito> depositos, int petroleoACargar) {
		this.cantidadDeDepositos = cantidadDeDepositos;
		this.capacidadTotal = capacidadTotal;
		this.depositos = depositos;
		this.petroleoACargar = petroleoACargar;
	}

	public Salida resolver() {
		double petroleoRestante = this.petroleoACargar;
		int cantidadDeDepositosUsados = 1, superficiesUsadas, depositosACargar;
		int i=0;
		double alturaACargar=0;
		Deposito depoAux, depoSiguiente =null;
		
		if(this.capacidadTotal<this.petroleoACargar)
			return new Salida(0, this.petroleoACargar-this.capacidadTotal,this.depositos);
		
		while(petroleoRestante >0) {
			//reseteo las variables 
			depositosACargar = 1;
			superficiesUsadas=0;
			cantidadDeDepositosUsados=1;
			i=0;
			
			depoAux =this.depositos.get(i);
			
			
			while(i<this.cantidadDeDepositos-1 
					&& depoAux.profundidadDisponible == (depoSiguiente=this.depositos.get(i+1)).profundidadDisponible) {
				depositosACargar++;
				cantidadDeDepositosUsados++;
				superficiesUsadas+= depoAux.superficie;
				//profundidadesUsadas+= depoAux.profundidad + depoSiguiente.profundidad;
				i++;
				depoAux = this.depositos.get(i);
			}
			superficiesUsadas+= depoAux.superficie;
			
			alturaACargar =  depoAux.profundidad - depoSiguiente.profundidad;
			
			if(petroleoRestante <= alturaACargar*superficiesUsadas || alturaACargar ==0) {	//me tengo que fijar si entra 
				alturaACargar = petroleoRestante/superficiesUsadas; //heq
			}
		
				
			//El math.round es para redondear porque el tema de los decimales me limita el corte
			for(int j =0; j<depositosACargar;j++)
				petroleoRestante -= this.depositos.get(j).cargar(alturaACargar);
												
			
		}
			
		return new Salida(cantidadDeDepositosUsados, 0, this.depositos);
	}

	public List<Deposito> getDepositos() {
		return depositos;
	}

}
