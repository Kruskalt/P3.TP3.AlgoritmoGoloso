package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import censo2022.StressTest;

public class Extras extends Panel {

	private static final long serialVersionUID = -4665652223084303911L;
	
	//paquete de variables "iniciar StressTest"
	private JLabel lblCantVertices;
	private JLabel lblCantCensistas;
	private JTextField txpCantVertices;
	private JTextField txpCantCensistas;
	private JButton btnComparar;

	// paquete de variables "Solver Goloso"
	private JLabel lblSolverGoloso;
	private JTextPane txpSolverGoloso;
	private JScrollPane spSolverGoloso;

	
	// paquete de variables "Solver Fuerza Bruta"
	private JLabel lblSolverFuerzaBruta;
	private JTextPane txpSolverFuerzaBruta;
	private JScrollPane spSolverFuerzaBruta;
	
	// cosas extras
	private JLabel lblExcepciones;
	private final Font fuenteEtiqueta = new Font("Consolas", Font.BOLD | Font.ITALIC, 15);
	private final Font fuenteCampoTexto = new Font("Consolas", Font.BOLD, 12);
	private final Color colorCampoTexto = new Color(200, 225, 255);

		// caracteristicas de las casillas de texto
		private final int casillaPosX = 40;
		private final int casillaPosY = 110;
		private final int casillaAncho = 400;
		private final int casillaAlto = 300;
	
	
	public Extras(VentanaPrincipal vp) {
		super(vp);
		
		iniciarPanel();
		iniciarBtnVolverInicio();
		
		iniciarPaqueteSolverGoloso();
		iniciarPaqueteSolverFuerzaBruta();
		
		iniciarPaqueteStressTest();
		
		ignorarCaracteres();
	}

	private void iniciarPanel() {
		setBounds(posX, posY, ancho, alto);
		setBorder(lineaBordeada);
		setBackground(colorDeFondo);
		setLayout(null);
	}

	private void iniciarPaqueteSolverGoloso() {
		lblSolverGoloso = new JLabel("Solver Goloso:");
		lblSolverGoloso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolverGoloso.setFont(fuenteEtiqueta);
		lblSolverGoloso.setBounds(casillaPosX, 100, 200, 30);
		add(lblSolverGoloso);
		
		txpSolverGoloso = new JTextPane();
		txpSolverGoloso.setEditable(false);
		txpSolverGoloso.setFont(fuenteCampoTexto);
		txpSolverGoloso.setBackground(colorCampoTexto);
		txpSolverGoloso.setBounds(0, 0, casillaAncho, casillaAlto);
		add(txpSolverGoloso);
		txpSolverGoloso.setToolTipText("Aqui se mostrara la solucion y tiempo de ejecucion del SolverGoloso");
		
		spSolverGoloso = new JScrollPane(txpSolverGoloso);
		spSolverGoloso.setBounds(casillaPosX, casillaPosY +20, casillaAncho, casillaAlto);
		add(spSolverGoloso);
	}
	
	private void iniciarPaqueteSolverFuerzaBruta() {
		lblSolverFuerzaBruta = new JLabel("Solver Fuerza Bruta:");
		lblSolverFuerzaBruta.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolverFuerzaBruta.setFont(fuenteEtiqueta);
		lblSolverFuerzaBruta.setBounds(ancho/2 + casillaPosX, 100, 200, 30);
		add(lblSolverFuerzaBruta);
		
		txpSolverFuerzaBruta = new JTextPane();
		txpSolverFuerzaBruta.setEditable(false);
		txpSolverFuerzaBruta.setFont(fuenteCampoTexto);
		txpSolverFuerzaBruta.setBackground(colorCampoTexto);
		txpSolverFuerzaBruta.setBounds(0, 0, casillaAncho, casillaAlto);
		add(txpSolverFuerzaBruta);
		txpSolverFuerzaBruta.setToolTipText("Aqui se mostrara la solucion y tiempo de ejecucion del Solver de FuerzaBruta");
		
		spSolverFuerzaBruta = new JScrollPane(txpSolverFuerzaBruta);
		spSolverFuerzaBruta.setBounds(ancho/2 + casillaPosX, casillaPosY +20, casillaAncho, casillaAlto);
		add(spSolverFuerzaBruta);
	}
	
	private void iniciarPaqueteStressTest() {
		lblCantVertices = new JLabel("Cantidad de vertices:");
		lblCantVertices.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantVertices.setFont(fuenteEtiqueta);
		lblCantVertices.setBounds(100, 500, 200, 30);
		add(lblCantVertices);
		
		lblCantCensistas = new JLabel("Cantidad de censistas:");
		lblCantCensistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantCensistas.setFont(fuenteEtiqueta);
		lblCantCensistas.setBounds(300, 500, 200, 30);
		add(lblCantCensistas);
		
		txpCantVertices = new JTextField();
		txpCantVertices.setHorizontalAlignment(SwingConstants.CENTER);
		txpCantVertices.setFont(fuenteEtiqueta);
		txpCantVertices.setBounds(150, 530, 100, 30);
		add(txpCantVertices);
		
		txpCantCensistas = new JTextField();
		txpCantCensistas.setHorizontalAlignment(SwingConstants.CENTER);
		txpCantCensistas.setFont(fuenteEtiqueta);
		txpCantCensistas.setBounds(350, 530, 100, 30);
		add(txpCantCensistas);
		
		btnComparar = new JButton("Iniciar Comparacion");
		btnComparar.setHorizontalAlignment(SwingConstants.CENTER);
		btnComparar.setFont(fuenteBtn);
		btnComparar.setBackground(colorBtn);
		btnComparar.setBounds(ancho -10 - anchoBtn, alto -10 -altoBtn, anchoBtn, altoBtn);
		accionBtnComparar();
		btnComparar.setToolTipText("Clickea aqui para comparar, tene en cuenta que mientras mas grandes sean los numeros mas van a tardar!");
		add(btnComparar);
		
		lblExcepciones = new JLabel();
		lblExcepciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcepciones.setFont(fuenteEtiqueta);
		lblExcepciones.setBounds(310, 560, 980, 30);
		add(lblExcepciones);
	}

	private void accionBtnComparar() {
		btnComparar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				lblExcepciones.setText("");
				StressTest s = new StressTest(Integer.parseInt(txpCantVertices.getText())
						, Integer.parseInt(txpCantCensistas.getText()));
				
				txpSolverGoloso.setText("");
				txpSolverGoloso.setText(s.stressTestGoloso());
				
				txpSolverFuerzaBruta.setText("");
				txpSolverFuerzaBruta.setText(s.stressTestFuerzaBruta());
				}
				catch (Exception ex){
					if (ex.getClass().equals(NumberFormatException.class)) {
						lblExcepciones.setText("TE olvidaste de poner los valores!");
					}
					else {
						lblExcepciones.setText(ex.getMessage());
					}
				}
			}
		});
	}
	
	private void ignorarCaracteres() {
		ignorarLetras(txpCantCensistas);
		ignorarLetras(txpCantVertices);
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

}
