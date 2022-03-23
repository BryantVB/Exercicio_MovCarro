package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class carro_cruzando extends Thread {
	private String sentido;
	private Semaphore semaforo_cruzamento;
	
	public carro_cruzando(Semaphore _semaforo) {
		semaforo_cruzamento = _semaforo;
		sentido = getRandomSentido();
	}
	
	public void run() {
		try {
			semaforo_cruzamento.acquire();
			atravessar();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} finally {
			semaforo_cruzamento.release();
		}
	}
	
	private void atravessar() {
		System.out.println("Carro #" + getId() + " atravessando " + sentido);

	}
	
	private static String getRandomSentido() {
		String sentido[] = {"para cima", "para baixo", "para direita", "para esquerda"};
	    int rnd = new Random().nextInt(sentido.length);
	    return sentido[rnd];
	}
}