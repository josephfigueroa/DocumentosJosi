package entrada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class DocumentoDeEntrada {

	//atributos
	private String ruta;
	private String contenido;
	private int cantidadDePalabras;
	private int cantidadDeLinea;
	
	//set and get
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public int getCantidadDePalabras() {
		return cantidadDePalabras;
	}
	public void setCantidadDePalabras(int cantidadDePalabras) {
		this.cantidadDePalabras = cantidadDePalabras;
	}
	public int getCantidadDeLinea() {
		return cantidadDeLinea;
	}
	public void setCantidadDeLinea(int cantidadDeLinea) {
		this.cantidadDeLinea = cantidadDeLinea;
	}
	
	//metodos
	public String abrirUnDocumento(JMenuItem itemArchivoAbrir, JTextArea doc) {
		
		//JTextArea documento = new JTextArea();
		try {
			
			JFileChooser selecionandoArchivo = new JFileChooser();
			
			
			int seleccion = selecionandoArchivo.showOpenDialog(itemArchivoAbrir);
			
			if(seleccion == 0) {
				BufferedReader lector = null;
				File archivo = selecionandoArchivo.getSelectedFile();
				
				setRuta(archivo.getPath());
				
				lector = new BufferedReader(new FileReader(archivo));
				setContenido(lector.readLine()); 
				
				while(getContenido() != null) {
					
					doc.append(getContenido());
					doc.append(System.getProperty("line.separator"));
					setContenido(lector.readLine());
				}
				lector.close();
			}
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
		
		return getRuta();
	}
}

