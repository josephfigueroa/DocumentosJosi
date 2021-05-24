package salida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class DocumentoDeSalida {
	
	private String contenido;
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getContenido() {
		return contenido;
	}
	public void guadarUnDocumento(JMenuItem itemArchivoGuardar, JTextArea doc) {
		
		JFileChooser selecionandoArchivo = new JFileChooser();
		
		int seleccion = selecionandoArchivo.showSaveDialog(selecionandoArchivo);
		
		if(seleccion == 0) {
			PrintWriter escritor = null;
			File archivo = selecionandoArchivo.getSelectedFile();
			
			try {
				escritor = new PrintWriter(archivo);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			escritor.print(doc.getText());
			escritor.close();
		}
	}
}
