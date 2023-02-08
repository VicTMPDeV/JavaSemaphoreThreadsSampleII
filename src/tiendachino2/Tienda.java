package tiendachino2;

import utilidades.Teclado;

public class Tienda {
	
	public static void main(String[] args) {
		
		int numClientes = Teclado.leerEntero("SELECCINA EL NUMERO DE CLIENTES EN LA TIENDA");
		
		Cajera c = new Cajera(numClientes); //ESTE PARAMETRO TIENE QUE SER UN RANDOM DEL TOTAL DE CLIENTES EN LA TIENDA
		c.start();
		
	}
}
