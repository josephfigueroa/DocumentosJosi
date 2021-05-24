package entrada;

import java.awt.Font;

public class Fuente {
	
	private static String fuente;
	private static int estados;
	private static int size;
	
	//colores
	private static int rojo;
	private static int verde;
	private static int azul;
	
	public Fuente() {
		setFuente("Arial");
		setEstados(Font.PLAIN);
		setSize(12);
	}
	
	public static String getFuente() {
		return fuente;
	}
	public static void setFuente(String fuente) {
		Fuente.fuente = fuente;
	}
	public static int getEstados() {
		return estados;
	}
	public static void setEstados(int estados) {
		Fuente.estados = estados;
	}
	public static int getSize() {
		return size;
	}
	public static void setSize(int size) {
		Fuente.size = size;
	}

	public static int getRojo() {
		return rojo;
	}

	public static void setRojo(int rojo) {
		Fuente.rojo = rojo;
	}

	public static int getVerde() {
		return verde;
	}

	public static void setVerde(int verde) {
		Fuente.verde = verde;
	}

	public static int getAzul() {
		return azul;
	}

	public static void setAzul(int azul) {
		Fuente.azul = azul;
	}

}
