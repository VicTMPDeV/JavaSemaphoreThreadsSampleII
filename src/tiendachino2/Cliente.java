package tiendachino2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cliente extends Thread {

	//ATRIBUTOS
	public Random aleatorio = new Random();
	public int miCompra;
	public Semaphore turnoCobroCajera; //ES EL SEMAFORO DEL CHINO QUE LE VA A COBRAR
	//CONSTRUCTOR
	public Cliente(Semaphore cobrameChino) {
		this.miCompra = (aleatorio.nextInt(20))+1; //MAS 1 PARA QUE NO ME COBRE 0, QUE ESO NO SE COBRA...
		this.turnoCobroCajera = cobrameChino;
	}

	public int pagar() {
		return miCompra;
	}
	//LO QUE HACE EL HILO
	public void run() {
		//CHINITO, COBRAME ANDA
		try {
			//EL CLIENTE ENTRA EN LA TIENDA Y SE PONE A COMPRAR UN TIEMPO ALEATORIO
			sleep((aleatorio.nextInt(5000))+5000); //ESTARA COMPRANDO ENTRE 5 Y 10 SEGUNDOS
			//CUANDO PUEDA ATENDERME EL CHINO, ME COBRARA
			turnoCobroCajera.acquire();
			System.out.println(this.getName()+" DICE: HOLA, ES MI TURNO PARA QUE ME COBRES");
			sleep(2000);
			System.out.println(this.getName()+" DICE: HASTA LUEGO !!!");
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		turnoCobroCajera.release();
	}
	
}
