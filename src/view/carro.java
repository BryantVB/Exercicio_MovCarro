package view;

import java.util.concurrent.Semaphore;

import controller.carro_cruzando;

public class carro {
	public static void main(String[] args) {
		Semaphore semaforo_cruzamento = new Semaphore(1);
		
		for(int i=0; i < 4; i++)
			new carro_cruzando(semaforo_cruzamento).run();
	}
}
