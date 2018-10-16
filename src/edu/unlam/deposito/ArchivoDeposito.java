package edu.unlam.deposito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ArchivoDeposito {
	
	
	public static Sistema leer(String path) throws IOException {
		Scanner sc = new Scanner(new File(path));
		List<Deposito> depositos = new ArrayList<>();
		int cantDeDepositos = sc.nextInt();
		int sup, prof;
		int capacidadTotal=0;
		
		for(int i=0; i<cantDeDepositos;i++) {
			depositos.add(new Deposito(sup = sc.nextInt(), prof = sc.nextInt()));
			capacidadTotal += sup*prof;
		}
			
		
		int petroleoACargar = sc.nextInt();
		
		sc.close();
		
		return new Sistema(cantDeDepositos, capacidadTotal, depositos, petroleoACargar);
	}
	
	public static void escribir(String path, Salida salida) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(path));
		List <Deposito> depositos = salida.getDepositos();
		
		if(salida.getCantTanquesUsados()==0)
			pw.println("Rebasan: " + salida.getRebasan());
		else {
			for(int i=0; i<salida.getCantTanquesUsados();i++)
				pw.println(Math.round(depositos.get(i).alturaPetroleoCargado));
		}
			
		
		pw.close();
	}

}
