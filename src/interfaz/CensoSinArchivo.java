package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CensoSinArchivo extends Panel {

	private static final long serialVersionUID = -7094063314919649788L;
	
	
	//paquete ingresar cantidad de manzanas
	private JLabel lblCantManzanas;
	private JTextField textCantManzanas;
	private JButton btnAceptarCantidad;
	
	
	//paquete ingresar censistas
	private JLabel lblIngresarCensista;
	private JLabel lblCensistaNombre;
	private JLabel lblCensistaDNI;
	private JTextField tfCensistaNombre;
	private JTextField tfCensistaDNI;
	private JButton btnIngresarCensista;
	
	
	//paquete ingresar manzanas contiguas
	private JLabel lblIngresarContiguas;
	private JLabel lblManzanaID1;
	private JLabel lblManzanaID2;
	private JTextField tfManzanaID1;
	private JTextField tfManzanaID2;
	private JButton btnIngresarContiguas;

	
	//cosas extras
	private JLabel lblRecordatorioCantManzanas;
	private JLabel lblAvisoImportante;
	private JLabel lblExcepciones;
	private JButton btnAsignarCensistas;
	private final Font fuenteEtiqueta = new Font("Consolas", Font.BOLD | Font.ITALIC, 18);
	private final Font fuenteCampoTexto = new Font("Consolas", Font.ITALIC, 12);
	private final Font fuenteBtnAceptar = new Font("Consolas", Font.BOLD, 12);
	
	
	public CensoSinArchivo(VentanaPrincipal vp) {
		super(vp);
		
		iniciarPanel();
		iniciarBtnVolverInicio();
		
		iniciarPaqueteCantidadManzanas();
		mostrarPaqueteCantidadManzanas();
		
		iniciarPaqueteCensistas();
		ocultarPaqueteCensistas();
		
		iniciarPaqueteManzanasContiguas();
		ocultarPaqueteManzanasContiguas();
		
		iniciarCosasExtras();
		ocultarBtnAsignar();
		
		ignorarCaracteres();
	}

	@Override
	public void mostrarPanel() {
		setVisible(true);
		btnVolverInicio.setVisible(true);
	}

	@Override
	public void ocultarPanel() {
		setVisible(false);
		btnVolverInicio.setVisible(false);
	}

	private void iniciarPanel() {
		setBounds(posX, posY, ancho, alto);
		setBorder(lineaBordeada);
		setBackground(colorDeFondo);
		setLayout(null);
	}
	
	private void iniciarPaqueteCantidadManzanas() {
		lblCantManzanas = new JLabel("N\u00B0 de manzanas a simular:");
		lblCantManzanas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantManzanas.setFont(fuenteEtiqueta);
		lblCantManzanas.setBounds(ancho/2 -150, 120, 300, 30);
		add(lblCantManzanas);
		
		
		textCantManzanas = new JTextField();
		textCantManzanas.setHorizontalAlignment(SwingConstants.CENTER);
		textCantManzanas.setFont(fuenteCampoTexto);
		textCantManzanas.setBounds(ancho/2 -75, 160, 150, 30);
		add(textCantManzanas);
		
		
		btnAceptarCantidad = new JButton("aceptar\r\n");
		btnAceptarCantidad.setFont(fuenteBtnAceptar);
		btnAceptarCantidad.setBounds(ancho/2 -50, 200, 100, 30);
		btnAceptarCantidad.setToolTipText("Clickea aqui cuando hayas ingresado la cantidad de manzanas de la ciudad.");
		accionBtnAceptarCantidad();
		add(btnAceptarCantidad);
	}
	
	private void iniciarPaqueteCensistas() {
		lblIngresarCensista = new JLabel("Ingresar Censista:");
		lblIngresarCensista.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarCensista.setFont(fuenteEtiqueta);
		lblIngresarCensista.setBounds(ancho/3 -200, 265, 300, 30);
		add(lblIngresarCensista);
		
		
		lblCensistaNombre = new JLabel("Nombre: ");
		lblCensistaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensistaNombre.setFont(fuenteEtiqueta);
		lblCensistaNombre.setBounds(ancho/3 -150, 305, 100, 30);
		add(lblCensistaNombre);
		
		tfCensistaNombre = new JTextField();
		tfCensistaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		tfCensistaNombre.setFont(fuenteCampoTexto);
		tfCensistaNombre.setBounds(ancho/3 -50, 305, 100, 30);
		add(tfCensistaNombre);
		
		
		lblCensistaDNI = new JLabel("DNI: ");
		lblCensistaDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensistaDNI.setFont(fuenteEtiqueta);
		lblCensistaDNI.setBounds(ancho/3 -150, 345, 100, 30);
		add(lblCensistaDNI);
		
		tfCensistaDNI =  new JTextField();
		tfCensistaDNI.setHorizontalAlignment(SwingConstants.CENTER);
		tfCensistaDNI.setFont(fuenteCampoTexto);
		tfCensistaDNI.setBounds(ancho/3 -50, 345, 100, 30);
		add(tfCensistaDNI);
		
		
		btnIngresarCensista = new JButton("ingresar\r\n");
		btnIngresarCensista.setHorizontalAlignment(SwingConstants.CENTER);
		btnIngresarCensista.setFont(fuenteBtnAceptar);
		btnIngresarCensista.setBounds(ancho/3 -50, 385, 100, 30);
		btnIngresarCensista.setToolTipText("Registra al censista con su DNI y nombre");
		accionBtnIngresarCensista();
		add(btnIngresarCensista);
	}
	
	private void iniciarPaqueteManzanasContiguas() {
		lblIngresarContiguas = new JLabel("Ingresar manzanas contiguas:");
		lblIngresarContiguas.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarContiguas.setFont(fuenteEtiqueta);
		lblIngresarContiguas.setBounds(ancho/3 *2 -100, 265, 300, 30);
		add(lblIngresarContiguas);
		
		
		lblManzanaID1 = new JLabel("ID 1: ");
		lblManzanaID1.setHorizontalAlignment(SwingConstants.CENTER);
		lblManzanaID1.setFont(fuenteEtiqueta);
		lblManzanaID1.setBounds(ancho/3 *2 -50, 305, 100, 30);
		add(lblManzanaID1);
		
		tfManzanaID1 = new JTextField();
		tfManzanaID1.setHorizontalAlignment(SwingConstants.CENTER);
		tfManzanaID1.setFont(fuenteCampoTexto);
		tfManzanaID1.setBounds(ancho/3 *2 +25, 305, 100, 30);
		add(tfManzanaID1);
		
		
		lblManzanaID2 = new JLabel("ID 2: ");
		lblManzanaID2.setHorizontalAlignment(SwingConstants.CENTER);
		lblManzanaID2.setFont(fuenteEtiqueta);
		lblManzanaID2.setBounds(ancho/3 *2 -50, 345, 100, 30);
		add(lblManzanaID2);
		
		tfManzanaID2 =  new JTextField();
		tfManzanaID2.setHorizontalAlignment(SwingConstants.CENTER);
		tfManzanaID2.setFont(fuenteCampoTexto);
		tfManzanaID2.setBounds(ancho/3 *2 +25, 345, 100, 30);
		add(tfManzanaID2);
		
		
		btnIngresarContiguas = new JButton("ingresar\r\n");
		btnIngresarContiguas.setHorizontalAlignment(SwingConstants.CENTER);
		btnIngresarContiguas.setFont(fuenteBtnAceptar);
		btnIngresarContiguas.setBounds(ancho/3 *2 +25, 385, 100, 30);
		btnIngresarContiguas.setToolTipText("Ingrese las conexiones entre las manzanas de su ciudad, "
											+ "recuerde que las ID deben ser mayores a 0 y menores a la cantidad de manzanas que ingreso anteriormente");
		accionBtnIngresarContiguas();
		add(btnIngresarContiguas);
	}
	
	private void iniciarCosasExtras() {
		lblAvisoImportante = new JLabel("   *Por favor, brinde la informacion pertinente...");
		lblAvisoImportante.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
		lblAvisoImportante.setBounds(10, 11, 980, 50);
		add(lblAvisoImportante);
		
		lblRecordatorioCantManzanas = new JLabel();
		lblRecordatorioCantManzanas.setFont(fuenteEtiqueta);
		lblRecordatorioCantManzanas.setBounds(ancho/2 -100, 120, 300, 30);
		lblRecordatorioCantManzanas.setVisible(false);
		add(lblRecordatorioCantManzanas);
		
		btnAsignarCensistas = new JButton("asignar censistas");
		btnAsignarCensistas.setHorizontalAlignment(SwingConstants.CENTER);
		btnAsignarCensistas.setBackground(colorBtn);
		btnAsignarCensistas.setFont(fuenteBtn);
		btnAsignarCensistas.setBounds(ancho-10 -anchoBtn, alto-10 -altoBtn, anchoBtn, altoBtn);
		btnAsignarCensistas.setToolTipText("Cuando haya terminado de agregar a todos sus censistas y uniones entre manzanas clickee aqui!");
		accionBtnAsignarCensistas();
		add(btnAsignarCensistas);
		
		lblExcepciones = new JLabel();
		lblExcepciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcepciones.setFont(new Font("Consolas", Font.BOLD, 15));
		lblExcepciones.setBounds(10, 500, 980, 50);
		add(lblExcepciones);
	}
	
	private void accionBtnAceptarCantidad() {
		btnAceptarCantidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.iniciarRadioCensal(textCantManzanas.getText());
					mostrarPaqueteCensistas();
					mostrarPaqueteContiguas();
					ocultarPaqueteCantidadManzanas();
					lblRecordatorioCantManzanas.setText("Manzanas propuestas: "+textCantManzanas.getText());
					lblRecordatorioCantManzanas.setVisible(true);
					lblExcepciones.setText("");
				}
				catch (Exception ex) {
					lblExcepciones.setText("**"+ex.getMessage()+"**");
				}
				
			}
		});
	}
	
	private void accionBtnIngresarCensista() {
		btnIngresarCensista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.agregarCensista(tfCensistaNombre.getText(), tfCensistaDNI.getText());
					tfCensistaDNI.setText("");
					tfCensistaNombre.setText("");
					if (ventana.estanConectadas() && ventana.hayCensistas()) {
						mostrarBtnAsignar();
					}
					lblExcepciones.setText("");
				}
				catch(Exception ex) {
					if (ex.getClass().equals(NumberFormatException.class)) {
						lblExcepciones.setText("**Te olvidaste de agregar el nombre o el DNI!**");
					}
					else {
						lblExcepciones.setText("**"+ex.getMessage()+"**");
					}
				}
			}
		});
	}
	
	private void accionBtnIngresarContiguas() {
		btnIngresarContiguas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.conectarManzanas(tfManzanaID1.getText(), tfManzanaID2.getText());
					tfManzanaID1.setText("");
					tfManzanaID2.setText("");
					if (ventana.estanConectadas() && ventana.hayCensistas()) {
						mostrarBtnAsignar();
					}
					lblExcepciones.setText("");
				}
				catch(Exception ex) {
					if (ex.getClass().equals(NumberFormatException.class)) {
						lblExcepciones.setText("Te olvidaste de ingresar algun ID!");
					}
					else {
						lblExcepciones.setText("**"+ex.getMessage()+"**");
						//System.out.println(ex.toString()); //MOMENTANEO, FALTA IMPLEMENTAR TEXTFIELD DE EXCEPCIONES
					}
				}
			}
		});
	}
	
	private void accionBtnAsignarCensistas() {
		btnAsignarCensistas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.censar();
				ventana.crearCensistasAsignados();
			}
		});
	}

	private void ocultarPaqueteCensistas() {
		lblIngresarCensista.setVisible(false);
		lblCensistaNombre.setVisible(false);
		lblCensistaDNI.setVisible(false);
		tfCensistaNombre.setVisible(false);
		tfCensistaDNI.setVisible(false);
		btnIngresarCensista.setVisible(false);
	}
	
	private void mostrarPaqueteCensistas() {
		lblIngresarCensista.setVisible(true);
		lblCensistaNombre.setVisible(true);
		lblCensistaDNI.setVisible(true);
		tfCensistaNombre.setVisible(true);
		tfCensistaDNI.setVisible(true);
		btnIngresarCensista.setVisible(true);
	}
	
	private void ocultarPaqueteManzanasContiguas() {
		lblIngresarContiguas.setVisible(false);
		lblManzanaID1.setVisible(false);
		lblManzanaID2.setVisible(false);
		tfManzanaID1.setVisible(false);
		tfManzanaID2.setVisible(false);
		btnIngresarContiguas.setVisible(false);
	}
	
	private void mostrarPaqueteContiguas() {
		lblIngresarContiguas.setVisible(true);
		lblManzanaID1.setVisible(true);
		lblManzanaID2.setVisible(true);
		tfManzanaID1.setVisible(true);
		tfManzanaID2.setVisible(true);
		btnIngresarContiguas.setVisible(true);
	}
	
	private void ocultarPaqueteCantidadManzanas() {
		lblCantManzanas.setVisible(false);
		textCantManzanas.setVisible(false);
		btnAceptarCantidad.setVisible(false);
	}
	
	private void mostrarPaqueteCantidadManzanas() {
		lblCantManzanas.setVisible(true);
		textCantManzanas.setVisible(true);
		btnAceptarCantidad.setVisible(true);
	}
	
	private void ocultarBtnAsignar() {
		btnAsignarCensistas.setVisible(false);
	}
	
	private void mostrarBtnAsignar() {
		btnAsignarCensistas.setVisible(true);
	}
	
	private void ignorarCaracteres() {
		ignorarLetras(textCantManzanas);
		ignorarLetras(tfCensistaDNI);
		ignorarLetras(tfManzanaID1);
		ignorarLetras(tfManzanaID2);
		ignorarNumeros(tfCensistaNombre);
	}

	
	private void ignorarNumeros(JTextField texto) {
		texto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			    if ( ((c < 'A') || (c > 'z')) && (c != 'ñ') && (c != KeyEvent.VK_BACK_SPACE)) {
			       e.consume();
			    }
			}
		});
	}
}
