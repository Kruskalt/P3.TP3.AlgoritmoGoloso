package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Asignaciones extends Panel {

	private static final long serialVersionUID = 6989169245019280871L;

	// paquete de variables "censistas registrados"
	private JLabel lblCensistasRegistrados;
	private JTextPane txpCensistasRegistrados;
	private JScrollPane spCensistasRegistrados;	
	
	
	// paquete de variables "manzanas registradas"
	private JLabel lblManzanasRegistradas;
	private JTextPane txpManzanasRegistradas;
	private JScrollPane spManzanasRegistradas;

	
	// paquete de variables "censitas asignados a cierta cantidad de manzanas"
	private JLabel lblAsignaciones;
	private JTextPane txpAsignaciones;
	private JScrollPane spAsignaciones;
	
	
	// cosas extras
	private JButton btnReiniciarInformacion;
	private final Font fuenteEtiqueta = new Font("Consolas", Font.BOLD | Font.ITALIC, 15);
	private final Font fuenteCampoTexto = new Font("Consolas", Font.BOLD, 12);
	private final Color colorCampoTexto = new Color(200, 225, 255);
	
	
	// caracteristicas de las casillas de texto
	private final int casillaPosX = 40;
	private final int casillaPosY = 110;
	private final int casillaAncho = 240;
	private final int casillaAlto = 440;
	
	
	public Asignaciones(VentanaPrincipal vp) {
		super(vp);
		
		iniciarPanel();
		
		iniciarBtnVolverInicio();
		iniciarBtnReiniciarInformacion();
		
		iniciarPaqueteCensistasRegistrados();
		iniciarPaqueteManzanasRegistradas();
		iniciarPaqueteAsignaciones();
	}
	
	private void iniciarPanel() {
		setBounds(posX, posY, ancho, alto);
		setBorder(lineaBordeada);
		setBackground(colorDeFondo);
		setLayout(null);
	}
	
	private void iniciarPaqueteCensistasRegistrados() {
		lblCensistasRegistrados = new JLabel("Registro de Censistas:");
		lblCensistasRegistrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensistasRegistrados.setFont(fuenteEtiqueta);
		lblCensistasRegistrados.setBounds(40, 75, 200, 30);
		add(lblCensistasRegistrados);
		
		txpCensistasRegistrados = new JTextPane();
		txpCensistasRegistrados.setEditable(false);
		txpCensistasRegistrados.setFont(fuenteCampoTexto);
		txpCensistasRegistrados.setBackground(colorCampoTexto);
		txpCensistasRegistrados.setBounds(0, 0, casillaAncho, casillaAlto);
		add(txpCensistasRegistrados);
		txpCensistasRegistrados.setText(ventana.censistasSoloNombreYDNI());
		
		spCensistasRegistrados = new JScrollPane(txpCensistasRegistrados);
		spCensistasRegistrados.setBounds(casillaPosX, casillaPosY, casillaAncho, casillaAlto);
		add(spCensistasRegistrados);
	}
	
	private void iniciarPaqueteManzanasRegistradas() {
		lblManzanasRegistradas = new JLabel("Registro de Manzanas:");
		lblManzanasRegistradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblManzanasRegistradas.setFont(fuenteEtiqueta);
		lblManzanasRegistradas.setBounds(330, 75, 200, 30);
		add(lblManzanasRegistradas);
		
		txpManzanasRegistradas = new JTextPane();
		txpManzanasRegistradas.setEditable(false);
		txpManzanasRegistradas.setFont(fuenteCampoTexto);
		txpManzanasRegistradas.setBackground(colorCampoTexto);
		txpManzanasRegistradas.setBounds(0, 0, casillaAncho, casillaAlto);
		add(txpManzanasRegistradas);
		txpManzanasRegistradas.setText(ventana.grafoToString());
		
		spManzanasRegistradas = new JScrollPane(txpManzanasRegistradas);
		spManzanasRegistradas.setBounds(casillaPosX*2 + casillaAncho, casillaPosY, casillaAncho, casillaAlto);
		add(spManzanasRegistradas);
	}
	
	private void iniciarPaqueteAsignaciones() {
		lblAsignaciones = new JLabel("Asignaciones:");
		lblAsignaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignaciones.setFont(fuenteEtiqueta);
		lblAsignaciones.setBounds(600, 75, 200, 30);
		add(lblAsignaciones);
		
		txpAsignaciones = new JTextPane();
		txpAsignaciones.setEditable(false);
		txpAsignaciones.setFont(fuenteCampoTexto);
		txpAsignaciones.setBackground(colorCampoTexto);
		txpAsignaciones.setBounds(0, 0, casillaAncho, casillaAlto);
		add(txpAsignaciones);
		txpAsignaciones.setText(ventana.censistasToString());
		
		spAsignaciones = new JScrollPane(txpAsignaciones);
		spAsignaciones.setBounds(casillaPosX*3 + casillaAncho*2, casillaPosY, (casillaAncho*3) /2, casillaAlto);
		add(spAsignaciones);
	}
	
	private void iniciarBtnReiniciarInformacion() {
		btnReiniciarInformacion = new JButton("Reiniciar info");
		btnReiniciarInformacion.setHorizontalAlignment(SwingConstants.CENTER);
		btnReiniciarInformacion.setFont(fuenteBtn);
		btnReiniciarInformacion.setBackground(colorBtn);
		btnReiniciarInformacion.setBounds(ancho -10 - anchoBtn, alto -10 -altoBtn, anchoBtn, altoBtn);
		btnReiniciarInformacion.setVisible(true);
		btnReiniciarInformacion.setToolTipText("Volver a crear la ciudad e ingresar los datos, recuerde que si aprieta este boton los datos actuales seran eliminados");
		accionBtnReiniciarInformacion();
		add(btnReiniciarInformacion);
	}
	
	private void accionBtnReiniciarInformacion() {
		btnReiniciarInformacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.reiniciarInformacion("sin_archivo");
			}
		});
	}
	
	@Override
	public void mostrarPanel() {
		setVisible(true);
	}

	@Override
	public void ocultarPanel() {
		setVisible(false);
	}

}
