package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import entrada.DocumentoDeEntrada;
import entrada.Fuente;
import salida.DocumentoDeSalida;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Toolkit tk;
	private Dimension dimensiones;
	private File documento;
	private Fuente fuente = new Fuente();
	
	private SpinnerModel model = new SpinnerNumberModel(0, 0, 255, 15);
	private SpinnerModel model2 = new SpinnerNumberModel(0, 0, 255, 15);
	private SpinnerModel model3 = new SpinnerNumberModel(0, 0, 255, 15);
	
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		
		tk = Toolkit.getDefaultToolkit();
		dimensiones = tk.getScreenSize();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, dimensiones.width, dimensiones.height);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTextArea documentoCadena = new JTextArea();
        documentoCadena.setFont(new Font(Fuente.getFuente(), Fuente.getEstados(), Fuente.getSize()));
		contentPane.add(documentoCadena);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel("Font");
		panel.add(lblNewLabel_4);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fuente.setFuente(comboBox.getSelectedItem().toString());
				documentoCadena.setFont(new Font(Fuente.getFuente(), Fuente.getEstados(), Fuente.getSize()));
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {".AppleSystemUIFont ", ".AppleSystemUIFontMonospaced", "Academy Engraved LET", "Al Bayan", "Al Nile", "Al Tarikh", "American Typewriter", "Andale Mono", "Apple Braille", "Apple Chancery", "Apple Color Emoji", "Apple SD Gothic Neo", "Apple Symbols", "AppleGothic", "AppleMyungjo", "Arial", "Arial Black", "Arial Hebrew", "Arial Hebrew Scholar", "Arial Narrow", "Arial Rounded MT Bold", "Arial Unicode MS", "Avenir", "Avenir Next", "Avenir Next Condensed", "Ayuthaya", "Baghdad", "Bangla MN", "Bangla Sangam MN", "Baskerville", "Beirut", "Big Caslon", "Bodoni 72", "Bodoni 72 Oldstyle", "Bodoni 72 Smallcaps", "Bodoni Ornaments", "Bradley Hand", "Brush Script MT", "Canela", "Canela Deck", "Canela Text", "Chalkboard", "Chalkboard SE", "Chalkduster", "Charter", "Cochin", "Comic Sans MS", "Copperplate", "Corsiva Hebrew", "Courier", "Courier New", "Damascus", "DecoType Naskh", "Devanagari MT", "Devanagari Sangam MN", "Dialog", "DialogInput", "Didot", "DIN Alternate", "DIN Condensed", "Diwan Kufi", "Diwan Thuluth", "Euphemia UCAS", "Farah", "Farisi", "Futura", "Galvji", "GB18030 Bitmap", "Geeza Pro", "Geneva", "Georgia", "Gill Sans", "Grantha Sangam MN", "Graphik", "Gujarati MT", "Gujarati Sangam MN", "Gurmukhi MN", "Gurmukhi MT", "Gurmukhi Sangam MN", "Heiti SC", "Heiti TC", "Helvetica", "Helvetica Neue", "Herculanum", "Hiragino Maru Gothic ProN", "Hiragino Mincho ProN", "Hiragino Sans", "Hiragino Sans GB", "Hoefler Text", "Impact", "InaiMathi", "ITF Devanagari", "ITF Devanagari Marathi", "Kailasa", "Kannada MN", "Kannada Sangam MN", "Kefa", "Khmer MN", "Khmer Sangam MN", "Kohinoor Bangla", "Kohinoor Devanagari", "Kohinoor Gujarati", "Kohinoor Telugu", "Kokonor", "Krungthep", "KufiStandardGK", "Lao MN", "Lao Sangam MN", "Lucida Grande", "Luminari", "Malayalam MN", "Malayalam Sangam MN", "Marker Felt", "Menlo", "Microsoft Sans Serif", "Mishafi", "Mishafi Gold", "Monaco", "Monospaced", "Mshtakan", "Mukta Mahee", "Muna", "Myanmar MN", "Myanmar Sangam MN", "Nadeem, New Peninim MT", "Noteworthy", "Noto Nastaliq Urdu", "Noto Sans Kannada", "Noto Sans Myanmar", "Noto Sans Oriya", "Noto Serif Myanmar", "Optima", "Oriya MN", "Oriya Sangam MN", "Palatino", "Papyrus", "Party LET", "Phosphate", "PingFang HK", "PingFang SC", "PingFang TC", "Plantagenet Cherokee", "Proxima Nova", "PT Mono", "PT Sans", "PT Sans Caption", "PT Sans Narrow", "PT Serif", "PT Serif Caption", "Publico Headline", "Publico Text", "Raanana", "Rockwell", "Sana", "SansSerif", "Sathu", "Savoye LET", "Serif", "Shree Devanagari 714", "SignPainter", "Silom", "Sinhala MN", "Sinhala Sangam MN", "Skia", "Snell Roundhand", "Songti SC", "Songti TC", "STIXGeneral", "STIXIntegralsD", "STIXIntegralsSm", "STIXIntegralsUp", "STIXIntegralsUpD", "STIXIntegralsUpSm", "STIXNonUnicode", "STIXSizeFiveSym", "STIXSizeFourSym", "STIXSizeOneSym", "STIXSizeThreeSym", "STIXSizeTwoSym", "STIXVariants", "STSong", "Sukhumvit Set", "Symbol", "Tahoma", "Tamil MN", "Tamil Sangam MN", "Telugu MN", "Telugu Sangam MN", "Thonburi", "Times", "Times New Roman", "Trattatello", "Trebuchet MS", "Verdana", "Waseem", "Webdings", "Wingdings", "Wingdings 2", "Wingdings 3", "Zapf Dingbats", "Zapfino"}));
		comboBox.setSelectedIndex(15);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Red");
		panel.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(model);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Fuente.setRojo((int)spinner.getValue());
				documentoCadena.setForeground(new Color(Fuente.getRojo(), Fuente.getVerde(), Fuente.getAzul()));
			}
		});
		panel.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Green");
		panel.add(lblNewLabel_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(model2);
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Fuente.setVerde((int)spinner_1.getValue());
				documentoCadena.setForeground(new Color(Fuente.getRojo(), Fuente.getVerde(), Fuente.getAzul()));
			}
		});
		panel.add(spinner_1);
		
		JLabel lblNewLabel_2 = new JLabel("Blue");
		panel.add(lblNewLabel_2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(model3);
		spinner_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				Fuente.setAzul((int)spinner_2.getValue());
				documentoCadena.setForeground(new Color(Fuente.getRojo(), Fuente.getVerde(), Fuente.getAzul()));
			}
		});
		panel.add(spinner_2);
		
		JLabel lblNewLabel_3 = new JLabel("Size");
		panel.add(lblNewLabel_3);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Fuente.setSize((int)spinner_3.getValue());
				documentoCadena.setFont(new Font(Fuente.getFuente(), Fuente.getEstados(), Fuente.getSize()));
			}
		});
		spinner_3.setValue(12);
		
		panel.add(spinner_3);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_48 = new JCheckBoxMenuItem("Bold");
		panel.add(chckbxmntmNewCheckItem_48);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_49 = new JCheckBoxMenuItem("Italic");
		panel.add(chckbxmntmNewCheckItem_49);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_50 = new JCheckBoxMenuItem("Underline");
		panel.add(chckbxmntmNewCheckItem_50);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		//cuando el usuario click en open
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentoDeEntrada docEntrada = new DocumentoDeEntrada();
				documento = new File(docEntrada.abrirUnDocumento(mntmNewMenuItem, documentoCadena));
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open Remote");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Recent Document");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Close");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("Wizards");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Templates");
		mnNewMenu.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Reload");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Versions");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Save");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter escritor = new FileWriter(documento ,true);
					escritor.write(documentoCadena.getText());
					escritor.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Save As ...");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentoDeSalida docSalida = new DocumentoDeSalida();
				docSalida.guadarUnDocumento(mntmNewMenuItem_5, documentoCadena);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Save Remote ...");
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Save a Copy");
		mnNewMenu.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Save all");
		mnNewMenu.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Check Out");
		mnNewMenu.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Cancel Check Out");
		mnNewMenu.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Check in ...");
		mnNewMenu.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Export ...");
		mnNewMenu.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_5 = new JMenu("Export as ");
		mnNewMenu.add(mnNewMenu_5);
		
		JMenu mnNewMenu_6 = new JMenu("Send");
		mnNewMenu.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Preview In Web Browser");
		mnNewMenu.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Print Preview");
		mnNewMenu.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Print");
		mnNewMenu.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Printer Setting");
		mnNewMenu.add(mntmNewMenuItem_17);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Properties");
		mnNewMenu.add(mntmNewMenuItem_18);
		
		JMenu mnNewMenu_7 = new JMenu("Digital Signature");
		mnNewMenu.add(mnNewMenu_7);
		
		JMenu mnNewMenu_8 = new JMenu("Edit");
		menuBar.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Undo");
		mnNewMenu_8.add(mntmNewMenuItem_19);
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Redo");
		mnNewMenu_8.add(mntmNewMenuItem_20);
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Repeat");
		mnNewMenu_8.add(mntmNewMenuItem_21);
		
		JMenuItem mntmNewMenuItem_22 = new JMenuItem("Cut");
		mnNewMenu_8.add(mntmNewMenuItem_22);
		
		JMenuItem mntmNewMenuItem_23 = new JMenuItem("Copy");
		mnNewMenu_8.add(mntmNewMenuItem_23);
		
		JMenuItem mntmNewMenuItem_24 = new JMenuItem("Paste");
		mnNewMenu_8.add(mntmNewMenuItem_24);
		
		JMenu mnNewMenu_9 = new JMenu("Paste Special");
		mnNewMenu_8.add(mnNewMenu_9);
		
		JMenuItem mntmNewMenuItem_25 = new JMenuItem("Select All");
		mnNewMenu_8.add(mntmNewMenuItem_25);
		
		JMenu mnNewMenu_10 = new JMenu("Selection Mode");
		mnNewMenu_8.add(mnNewMenu_10);
		
		JMenuItem mntmNewMenuItem_26 = new JMenuItem("Select Text");
		mnNewMenu_8.add(mntmNewMenuItem_26);
		
		JMenuItem mntmNewMenuItem_27 = new JMenuItem("Find . . .");
		mnNewMenu_8.add(mntmNewMenuItem_27);
		
		JMenuItem mntmNewMenuItem_28 = new JMenuItem("Find And Replace . . .");
		mnNewMenu_8.add(mntmNewMenuItem_28);
		
		JMenuItem mntmNewMenuItem_29 = new JMenuItem("Go To Page . . .");
		mnNewMenu_8.add(mntmNewMenuItem_29);
		
		JMenu mnNewMenu_11 = new JMenu("Truck Changes");
		mnNewMenu_8.add(mnNewMenu_11);
		
		JMenu mnNewMenu_12 = new JMenu("Comment");
		mnNewMenu_8.add(mnNewMenu_12);
		
		JMenuItem mntmNewMenuItem_30 = new JMenuItem("Hyper Link");
		mnNewMenu_8.add(mntmNewMenuItem_30);
		
		JMenu mnNewMenu_13 = new JMenu("Reference");
		mnNewMenu_8.add(mnNewMenu_13);
		
		JMenuItem mntmNewMenuItem_31 = new JMenuItem("Fields . . .");
		mnNewMenu_8.add(mntmNewMenuItem_31);
		
		JMenuItem mntmNewMenuItem_32 = new JMenuItem("Links To External Files . . .");
		mnNewMenu_8.add(mntmNewMenuItem_32);
		
		JMenuItem mntmNewMenuItem_33 = new JMenuItem("Exchanges Database");
		mnNewMenu_8.add(mntmNewMenuItem_33);
		
		JMenu mnNewMenu_14 = new JMenu("Object");
		mnNewMenu_8.add(mnNewMenu_14);
		
		JMenuItem mntmNewMenuItem_34 = new JMenuItem("Direct Cursor Mode");
		mnNewMenu_8.add(mntmNewMenuItem_34);
		
		JMenuItem mntmNewMenuItem_35 = new JMenuItem("Edit Mode");
		mnNewMenu_8.add(mntmNewMenuItem_35);
		
		JMenu mnNewMenu_15 = new JMenu("View");
		menuBar.add(mnNewMenu_15);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Normal");
		mnNewMenu_15.add(chckbxmntmNewCheckItem);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_1 = new JCheckBoxMenuItem("Web");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_1);
		
		JMenuItem mntmNewMenuItem_36 = new JMenuItem("User Interface . . .");
		mnNewMenu_15.add(mntmNewMenuItem_36);
		
		JMenu mnNewMenu_16 = new JMenu("Toolbars");
		mnNewMenu_15.add(mnNewMenu_16);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_2 = new JCheckBoxMenuItem("Status Bar");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_2);
		
		JMenu mnNewMenu_17 = new JMenu("Rulers");
		mnNewMenu_15.add(mnNewMenu_17);
		
		JMenu mnNewMenu_18 = new JMenu("Scrollbars");
		mnNewMenu_15.add(mnNewMenu_18);
		
		JMenu mnNewMenu_19 = new JMenu("Grid And Helplines");
		mnNewMenu_15.add(mnNewMenu_19);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_3 = new JCheckBoxMenuItem("Formatting Marks");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_3);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_4 = new JCheckBoxMenuItem("Text Boundaries");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_4);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_5 = new JCheckBoxMenuItem("Table Boundaries");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_5);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_6 = new JCheckBoxMenuItem("Images And Charts");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_6);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_7 = new JCheckBoxMenuItem("Show Whitespace");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_7);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_8 = new JCheckBoxMenuItem("Show Tracked Changes");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_8);
		
		JMenuItem mntmNewMenuItem_37 = new JMenuItem("Comments");
		mnNewMenu_15.add(mntmNewMenuItem_37);
		
		JMenuItem mntmNewMenuItem_38 = new JMenuItem("Resolved Comments");
		mnNewMenu_15.add(mntmNewMenuItem_38);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_9 = new JCheckBoxMenuItem("Field Shadings");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_9);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_10 = new JCheckBoxMenuItem("Field Names");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_10);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_11 = new JCheckBoxMenuItem("Field Hidden Paragraphs");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_11);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_12 = new JCheckBoxMenuItem("Sidebar");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_12);
		
		JMenuItem mntmNewMenuItem_39 = new JMenuItem("Styles");
		mnNewMenu_15.add(mntmNewMenuItem_39);
		
		JMenuItem mntmNewMenuItem_40 = new JMenuItem("Gallery");
		mnNewMenu_15.add(mntmNewMenuItem_40);
		
		JMenuItem mntmNewMenuItem_41 = new JMenuItem("Navigator");
		mnNewMenu_15.add(mntmNewMenuItem_41);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_13 = new JCheckBoxMenuItem("Data Source");
		mnNewMenu_15.add(chckbxmntmNewCheckItem_13);
		
		JMenuItem mntmNewMenuItem_42 = new JMenuItem("FullScreen");
		mnNewMenu_15.add(mntmNewMenuItem_42);
		
		JMenuItem mntmNewMenuItem_43 = new JMenuItem("Zoom");
		mnNewMenu_15.add(mntmNewMenuItem_43);
		
		JMenu mnNewMenu_20 = new JMenu("Insert");
		menuBar.add(mnNewMenu_20);
		
		JMenuItem mntmNewMenuItem_44 = new JMenuItem("Page Break");
		mnNewMenu_20.add(mntmNewMenuItem_44);
		
		JMenu mnNewMenu_21 = new JMenu("More Breaks");
		mnNewMenu_20.add(mnNewMenu_21);
		
		JMenuItem mntmNewMenuItem_45 = new JMenuItem("Image . . .");
		mnNewMenu_20.add(mntmNewMenuItem_45);
		
		JMenuItem mntmNewMenuItem_46 = new JMenuItem("Chart . . .");
		mnNewMenu_20.add(mntmNewMenuItem_46);
		
		JMenu mnNewMenu_22 = new JMenu("Media");
		mnNewMenu_20.add(mnNewMenu_22);
		
		JMenu mnNewMenu_23 = new JMenu("Object");
		mnNewMenu_20.add(mnNewMenu_23);
		
		JMenu mnNewMenu_24 = new JMenu("Shape");
		mnNewMenu_20.add(mnNewMenu_24);
		
		JMenuItem mntmNewMenuItem_47 = new JMenuItem("Section . . .");
		mnNewMenu_20.add(mntmNewMenuItem_47);
		
		JMenuItem mntmNewMenuItem_48 = new JMenuItem("Text From File . . .");
		mnNewMenu_20.add(mntmNewMenuItem_48);
		
		JMenuItem mntmNewMenuItem_49 = new JMenuItem("Text Box");
		mnNewMenu_20.add(mntmNewMenuItem_49);
		
		JMenuItem mntmNewMenuItem_50 = new JMenuItem("Comment");
		mnNewMenu_20.add(mntmNewMenuItem_50);
		
		JMenu mnNewMenu_25 = new JMenu("Frame");
		mnNewMenu_20.add(mnNewMenu_25);
		
		JMenuItem mntmNewMenuItem_51 = new JMenuItem("FontWork . . .");
		mnNewMenu_20.add(mntmNewMenuItem_51);
		
		JMenuItem mntmNewMenuItem_52 = new JMenuItem("Caption . . .");
		mnNewMenu_20.add(mntmNewMenuItem_52);
		
		JMenuItem mntmNewMenuItem_53 = new JMenuItem("HyperLink . . .");
		mnNewMenu_20.add(mntmNewMenuItem_53);
		
		JMenuItem mntmNewMenuItem_54 = new JMenuItem("Bookmark . . .");
		mnNewMenu_20.add(mntmNewMenuItem_54);
		
		JMenuItem mntmNewMenuItem_55 = new JMenuItem("Cross-Reference . . .");
		mnNewMenu_20.add(mntmNewMenuItem_55);
		
		JMenuItem mntmNewMenuItem_56 = new JMenuItem("Special Character . . .");
		mnNewMenu_20.add(mntmNewMenuItem_56);
		
		JMenu mnNewMenu_26 = new JMenu("Formatting Mark");
		mnNewMenu_20.add(mnNewMenu_26);
		
		JMenuItem mntmNewMenuItem_57 = new JMenuItem("Horizontal Line ");
		mnNewMenu_20.add(mntmNewMenuItem_57);
		
		JMenu mnNewMenu_27 = new JMenu("Footnote and Endnote");
		mnNewMenu_20.add(mnNewMenu_27);
		
		JMenu mnNewMenu_28 = new JMenu("Table Of Contents And Index");
		mnNewMenu_20.add(mnNewMenu_28);
		
		JMenu mnNewMenu_29 = new JMenu("Page Number");
		mnNewMenu_20.add(mnNewMenu_29);
		
		JMenu mnNewMenu_30 = new JMenu("Field");
		mnNewMenu_20.add(mnNewMenu_30);
		
		JMenu mnNewMenu_31 = new JMenu("Header And Footer");
		mnNewMenu_20.add(mnNewMenu_31);
		
		JMenuItem mntmNewMenuItem_58 = new JMenuItem("Envelope . . .");
		mnNewMenu_20.add(mntmNewMenuItem_58);
		
		JMenuItem mntmNewMenuItem_59 = new JMenuItem("SignatureLine . . .");
		mnNewMenu_20.add(mntmNewMenuItem_59);
		
		JMenu mnNewMenu_32 = new JMenu("Format");
		menuBar.add(mnNewMenu_32);
		
		JMenu mnNewMenu_33 = new JMenu("Text");
		mnNewMenu_32.add(mnNewMenu_33);
		
		JMenu mnNewMenu_34 = new JMenu("Spacing");
		mnNewMenu_32.add(mnNewMenu_34);
		
		JMenu mnNewMenu_35 = new JMenu("Align Text");
		mnNewMenu_32.add(mnNewMenu_35);
		
		JMenu mnNewMenu_36 = new JMenu("List");
		mnNewMenu_32.add(mnNewMenu_36);
		
		JMenuItem mntmNewMenuItem_60 = new JMenuItem("Clone Formatting");
		mnNewMenu_32.add(mntmNewMenuItem_60);
		
		JMenuItem mntmNewMenuItem_61 = new JMenuItem("Clear Direct Formatting");
		mnNewMenu_32.add(mntmNewMenuItem_61);
		
		JMenuItem mntmNewMenuItem_62 = new JMenuItem("Character . . .");
		mnNewMenu_32.add(mntmNewMenuItem_62);
		
		JMenuItem mntmNewMenuItem_63 = new JMenuItem("Paragraph . . .");
		mnNewMenu_32.add(mntmNewMenuItem_63);
		
		JMenuItem mntmNewMenuItem_64 = new JMenuItem("Bullets And Numbering . . .");
		mnNewMenu_32.add(mntmNewMenuItem_64);
		
		JMenuItem mntmNewMenuItem_65 = new JMenuItem("Page Style . . .");
		mnNewMenu_32.add(mntmNewMenuItem_65);
		
		JMenuItem mntmNewMenuItem_66 = new JMenuItem("Title Page . . .");
		mnNewMenu_32.add(mntmNewMenuItem_66);
		
		JMenuItem mntmNewMenuItem_67 = new JMenuItem("Comments . . .");
		mnNewMenu_32.add(mntmNewMenuItem_67);
		
		JMenuItem mntmNewMenuItem_68 = new JMenuItem("Asian Phonetic Guide , . .");
		mnNewMenu_32.add(mntmNewMenuItem_68);
		
		JMenuItem mntmNewMenuItem_69 = new JMenuItem("Columns . . .");
		mnNewMenu_32.add(mntmNewMenuItem_69);
		
		JMenuItem mntmNewMenuItem_70 = new JMenuItem("Watermark . . .");
		mnNewMenu_32.add(mntmNewMenuItem_70);
		
		JMenuItem mntmNewMenuItem_71 = new JMenuItem("Sections . . .");
		mnNewMenu_32.add(mntmNewMenuItem_71);
		
		JMenu mnNewMenu_37 = new JMenu("Image");
		mnNewMenu_32.add(mnNewMenu_37);
		
		JMenu mnNewMenu_38 = new JMenu("Text Box And Shape");
		mnNewMenu_32.add(mnNewMenu_38);
		
		JMenu mnNewMenu_39 = new JMenu("Frame And Object");
		mnNewMenu_32.add(mnNewMenu_39);
		
		JMenuItem mntmNewMenuItem_72 = new JMenuItem("Name . . .");
		mnNewMenu_32.add(mntmNewMenuItem_72);
		
		JMenuItem mntmNewMenuItem_73 = new JMenuItem("Description . . .");
		mnNewMenu_32.add(mntmNewMenuItem_73);
		
		JMenu mnNewMenu_40 = new JMenu("Anchor ");
		mnNewMenu_32.add(mnNewMenu_40);
		
		JMenu mnNewMenu_41 = new JMenu("Wrap ");
		mnNewMenu_32.add(mnNewMenu_41);
		
		JMenu mnNewMenu_42 = new JMenu("Arrange ");
		mnNewMenu_32.add(mnNewMenu_42);
		
		JMenu mnNewMenu_43 = new JMenu("Rotate Or Flip");
		mnNewMenu_32.add(mnNewMenu_43);
		
		JMenu mnNewMenu_44 = new JMenu("Group");
		mnNewMenu_32.add(mnNewMenu_44);
		
		JMenu mnNewMenu_45 = new JMenu("Styles");
		menuBar.add(mnNewMenu_45);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_14 = new JCheckBoxMenuItem("Textbody");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_14);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_15 = new JCheckBoxMenuItem("Title");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_15);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_16 = new JCheckBoxMenuItem("Subtitle");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_16);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_17 = new JCheckBoxMenuItem("Heading 1");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_17);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_18 = new JCheckBoxMenuItem("Heading 2");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_18);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_19 = new JCheckBoxMenuItem("Heading 3");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_19);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_20 = new JCheckBoxMenuItem("Quotations");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_20);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_21 = new JCheckBoxMenuItem("Preformatted Text ");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_21);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_22 = new JCheckBoxMenuItem("Default Character");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_22);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_23 = new JCheckBoxMenuItem("Emphasis");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_23);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_24 = new JCheckBoxMenuItem("Strong Emphasis");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_24);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_25 = new JCheckBoxMenuItem("Quotations");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_25);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_26 = new JCheckBoxMenuItem("Source Text");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_26);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_27 = new JCheckBoxMenuItem("Bullet List");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_27);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_28 = new JCheckBoxMenuItem("Number List");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_28);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_29 = new JCheckBoxMenuItem("Alphabet Uppercase List");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_29);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_30 = new JCheckBoxMenuItem("Alphabet Lowercase List");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_30);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_31 = new JCheckBoxMenuItem("Roman Lowercase List");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_31);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_32 = new JCheckBoxMenuItem("Roman Uppercase List");
		mnNewMenu_45.add(chckbxmntmNewCheckItem_32);
		
		JMenuItem mntmNewMenuItem_74 = new JMenuItem("Edit Style . . .");
		mnNewMenu_45.add(mntmNewMenuItem_74);
		
		JMenuItem mntmNewMenuItem_75 = new JMenuItem("Update Selected Style");
		mnNewMenu_45.add(mntmNewMenuItem_75);
		
		JMenuItem mntmNewMenuItem_76 = new JMenuItem("New Style From Selection");
		mnNewMenu_45.add(mntmNewMenuItem_76);
		
		JMenuItem mntmNewMenuItem_77 = new JMenuItem("Load Style . . .");
		mnNewMenu_45.add(mntmNewMenuItem_77);
		
		JMenuItem mntmNewMenuItem_78 = new JMenuItem("Manage Styles");
		mnNewMenu_45.add(mntmNewMenuItem_78);
		
		JMenu mnNewMenu_46 = new JMenu("Table");
		menuBar.add(mnNewMenu_46);
		
		JMenuItem mntmNewMenuItem_79 = new JMenuItem("Insert Table");
		mnNewMenu_46.add(mntmNewMenuItem_79);
		
		JMenu mnNewMenu_47 = new JMenu("Insert");
		mnNewMenu_46.add(mnNewMenu_47);
		
		JMenu mnNewMenu_48 = new JMenu("Delete");
		mnNewMenu_46.add(mnNewMenu_48);
		
		JMenu mnNewMenu_49 = new JMenu("Select");
		mnNewMenu_46.add(mnNewMenu_49);
		
		JMenu mnNewMenu_50 = new JMenu("Size");
		mnNewMenu_46.add(mnNewMenu_50);
		
		JMenuItem mntmNewMenuItem_80 = new JMenuItem("Merge Cells");
		mnNewMenu_46.add(mntmNewMenuItem_80);
		
		JMenuItem mntmNewMenuItem_81 = new JMenuItem("Split Cells ");
		mnNewMenu_46.add(mntmNewMenuItem_81);
		
		JMenuItem mntmNewMenuItem_82 = new JMenuItem("Merge Table");
		mnNewMenu_46.add(mntmNewMenuItem_82);
		
		JMenuItem mntmNewMenuItem_83 = new JMenuItem("Split Table");
		mnNewMenu_46.add(mntmNewMenuItem_83);
		
		JMenuItem mntmNewMenuItem_84 = new JMenuItem("Protected Cells");
		mnNewMenu_46.add(mntmNewMenuItem_84);
		
		JMenuItem mntmNewMenuItem_85 = new JMenuItem("Unprotected Cells");
		mnNewMenu_46.add(mntmNewMenuItem_85);
		
		JMenuItem mntmNewMenuItem_86 = new JMenuItem("Autoformat Styles");
		mnNewMenu_46.add(mntmNewMenuItem_86);
		
		JMenuItem mntmNewMenuItem_87 = new JMenuItem("Number Format . . .");
		mnNewMenu_46.add(mntmNewMenuItem_87);
		
		JMenuItem mntmNewMenuItem_88 = new JMenuItem("Number Recognition");
		mnNewMenu_46.add(mntmNewMenuItem_88);
		
		JMenuItem mntmNewMenuItem_89 = new JMenuItem("Header Rows Repeat Across Page");
		mnNewMenu_46.add(mntmNewMenuItem_89);
		
		JMenuItem mntmNewMenuItem_90 = new JMenuItem("Row To Break Across Pages");
		mnNewMenu_46.add(mntmNewMenuItem_90);
		
		JMenu mnNewMenu_51 = new JMenu("Convert");
		mnNewMenu_46.add(mnNewMenu_51);
		
		JMenuItem mntmNewMenuItem_91 = new JMenuItem("Formula");
		mnNewMenu_46.add(mntmNewMenuItem_91);
		
		JMenuItem mntmNewMenuItem_92 = new JMenuItem("Sort . . .");
		mnNewMenu_46.add(mntmNewMenuItem_92);
		
		JMenuItem mntmNewMenuItem_93 = new JMenuItem("Properties . . .");
		mnNewMenu_46.add(mntmNewMenuItem_93);
		
		JMenu mnNewMenu_52 = new JMenu("Form");
		menuBar.add(mnNewMenu_52);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_33 = new JCheckBoxMenuItem("Design Mode");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_33);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_34 = new JCheckBoxMenuItem("Control Wizards");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_34);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_35 = new JCheckBoxMenuItem("Label");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_35);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_36 = new JCheckBoxMenuItem("Check Box");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_36);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_37 = new JCheckBoxMenuItem("Option Button");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_37);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_38 = new JCheckBoxMenuItem("List Box");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_38);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_39 = new JCheckBoxMenuItem("Combo Box");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_39);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_40 = new JCheckBoxMenuItem("Push Button");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_40);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_41 = new JCheckBoxMenuItem("Image Button");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_41);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_42 = new JCheckBoxMenuItem("Formatted Field");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_42);
		
		JMenu mnNewMenu_53 = new JMenu("More Fields");
		mnNewMenu_52.add(mnNewMenu_53);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_43 = new JCheckBoxMenuItem("Image Control");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_43);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_44 = new JCheckBoxMenuItem("File Selection");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_44);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_45 = new JCheckBoxMenuItem("Table Control");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_45);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_46 = new JCheckBoxMenuItem("Navigation Bar");
		mnNewMenu_52.add(chckbxmntmNewCheckItem_46);
		
		JMenuItem mntmNewMenuItem_94 = new JMenuItem("Control Properties . . .");
		mnNewMenu_52.add(mntmNewMenuItem_94);
		
		JMenuItem mntmNewMenuItem_95 = new JMenuItem("Form Properties");
		mnNewMenu_52.add(mntmNewMenuItem_95);
		
		JMenuItem mntmNewMenuItem_96 = new JMenuItem("Form Navigator . . .");
		mnNewMenu_52.add(mntmNewMenuItem_96);
		
		JMenuItem mntmNewMenuItem_97 = new JMenuItem("Activation Order . . .");
		mnNewMenu_52.add(mntmNewMenuItem_97);
		
		JMenuItem mntmNewMenuItem_98 = new JMenuItem("Open In Design Mode");
		mnNewMenu_52.add(mntmNewMenuItem_98);
		
		JMenuItem mntmNewMenuItem_99 = new JMenuItem("Automatic Control Focus");
		mnNewMenu_52.add(mntmNewMenuItem_99);
		
		JMenu mnNewMenu_54 = new JMenu("Tools");
		menuBar.add(mnNewMenu_54);
		
		JMenuItem mntmNewMenuItem_100 = new JMenuItem("Spelling . . .");
		mnNewMenu_54.add(mntmNewMenuItem_100);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_47 = new JCheckBoxMenuItem("Automatic Spell Checking ");
		mnNewMenu_54.add(chckbxmntmNewCheckItem_47);
		
		JMenuItem mntmNewMenuItem_101 = new JMenuItem("Thesaurus . . .");
		mnNewMenu_54.add(mntmNewMenuItem_101);
		
		JMenu mnNewMenu_55 = new JMenu("Language");
		mnNewMenu_54.add(mnNewMenu_55);
		
		JMenuItem mntmNewMenuItem_102 = new JMenuItem("Word Count . . .");
		mnNewMenu_54.add(mntmNewMenuItem_102);
		
		JMenuItem mntmNewMenuItem_103 = new JMenuItem("Accessibility Check . . .");
		mnNewMenu_54.add(mntmNewMenuItem_103);
		
		JMenu mnNewMenu_56 = new JMenu("Autocorrect");
		mnNewMenu_54.add(mnNewMenu_56);
		
		JMenuItem mntmNewMenuItem_104 = new JMenuItem("Autotext . . .");
		mnNewMenu_54.add(mntmNewMenuItem_104);
		
		JMenuItem mntmNewMenuItem_105 = new JMenuItem("Imagemap");
		mnNewMenu_54.add(mntmNewMenuItem_105);
		
		JMenuItem mntmNewMenuItem_106 = new JMenuItem("Redact");
		mnNewMenu_54.add(mntmNewMenuItem_106);
		
		JMenuItem mntmNewMenuItem_107 = new JMenuItem("Auto Redact");
		mnNewMenu_54.add(mntmNewMenuItem_107);
		
		JMenuItem mntmNewMenuItem_108 = new JMenuItem("Chapter Numbering . . .");
		mnNewMenu_54.add(mntmNewMenuItem_108);
		
		JMenuItem mntmNewMenuItem_109 = new JMenuItem("Line Numbering . . .");
		mnNewMenu_54.add(mntmNewMenuItem_109);
		
		JMenuItem mntmNewMenuItem_110 = new JMenuItem("Footnotes And Endnotes . . .");
		mnNewMenu_54.add(mntmNewMenuItem_110);
		
		JMenuItem mntmNewMenuItem_111 = new JMenuItem("Mail Merge Wizard . . .");
		mnNewMenu_54.add(mntmNewMenuItem_111);
		
		JMenuItem mntmNewMenuItem_112 = new JMenuItem("Bibliography Database");
		mnNewMenu_54.add(mntmNewMenuItem_112);
		
		JMenuItem mntmNewMenuItem_113 = new JMenuItem("Address Book Source . . .");
		mnNewMenu_54.add(mntmNewMenuItem_113);
		
		JMenu mnNewMenu_57 = new JMenu("Update");
		mnNewMenu_54.add(mnNewMenu_57);
		
		JMenu mnNewMenu_58 = new JMenu("Protect Document ");
		mnNewMenu_54.add(mnNewMenu_58);
		
		JMenuItem mntmNewMenuItem_114 = new JMenuItem("Calculate");
		mnNewMenu_54.add(mntmNewMenuItem_114);
		
		JMenuItem mntmNewMenuItem_115 = new JMenuItem("Sort . . .");
		mnNewMenu_54.add(mntmNewMenuItem_115);
		
		JMenu mnNewMenu_59 = new JMenu("Macros");
		mnNewMenu_54.add(mnNewMenu_59);
		
		JMenuItem mntmNewMenuItem_116 = new JMenuItem("Extension Manger . . .");
		mnNewMenu_54.add(mntmNewMenuItem_116);
		
		JMenuItem mntmNewMenuItem_117 = new JMenuItem("Costomize . . .");
		mnNewMenu_54.add(mntmNewMenuItem_117);
		
		JMenu mnNewMenu_60 = new JMenu("Window");
		menuBar.add(mnNewMenu_60);
		
		JMenuItem mntmNewMenuItem_118 = new JMenuItem("New Window");
		mnNewMenu_60.add(mntmNewMenuItem_118);
		
		JMenu mnNewMenu_61 = new JMenu("Help");
		menuBar.add(mnNewMenu_61);
		
		
		
	}
}
