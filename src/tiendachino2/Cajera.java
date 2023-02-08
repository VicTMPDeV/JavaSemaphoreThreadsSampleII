package tiendachino2;

import java.util.concurrent.Semaphore;

public class Cajera extends Thread {
	//ATRIBUTOS
	public Cliente colaDeClientes[];
	public Semaphore turnoCobro;
	//REPRESENTA LA CAJA DEL CHINO, QUE ES LA SECCION CRITICA DONDE TODOS QUEREMOS ACCEDER PARA QUE NOS COBRE Y TERMINEMOS NUESTRA TAREA
	public int dineroEnCaja = 0;
	//CONSTRUCTOR
	public Cajera(int numClientes) {
		this.colaDeClientes = new Cliente [numClientes];
		this.turnoCobro = new Semaphore(1);
	}
	//RUN
	public void run() {
		try {
			System.out.println("CAJERA "+this.getName()+" TIENE ..."+colaDeClientes.length+"... EN SU COLA ");
			for (int i = 0; i < colaDeClientes.length ; i++) {
				colaDeClientes[i] = new Cliente(turnoCobro); //LE DOY AL CLIENTE MI SEMAFORO
				colaDeClientes[i].start(); //ARRANCAN LOS HILOS CLIENTE QUE TIENE EL CHINO EN SU COLA
			} 
			for (int i = 0; i < 10 ; i++) {
				try {
					colaDeClientes[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("A VEL CUANTO DINELITO HA GANADO CHINITO???...");
			Thread.sleep(2000);
			System.out.println("OOOOOOOUUUUHHH!!!...CHINITO HA GANADO "+dineroEnCaja+" EULITOOOOO");
			System.out.println("AHOLA VAMO A ECHALO A LA CAJA GENELAL");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
