package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Inicio extends Panel {
	
	private static final long serialVersionUID = 5427436349781456150L;
	
	//botones y sus caracteristicas:
	private JButton btnIniciarCensoSinArchivo;
	private JButton btnIniciarExtras;

	private final int xBtn = ancho/2 - anchoBtn/2;
	private final int yBtn = alto/4 - altoBtn/2;
	
	//etiquetas
	private JLabel lblAvisoImportante;
	private JLabel lblBienvenido;
	
	
	public Inicio (VentanaPrincipal vp) {
		super(vp);
		
		iniciarPanel();
		iniciarBotones();
		iniciarEtiquetas();
	}

	private void iniciarPanel() {
		setBounds(posX, posY, ancho, alto);
		setBorder(lineaBordeada);
		setBackground(colorDeFondo);
		setLayout(null);
	}
	
	private void iniciarBotones() {
		iniciarBtnIniciarCensoSinArchivo();
		iniciarBtnIniciarExtras();
	}
	
	private void iniciarBtnIniciarCensoSinArchivo() {
		btnIniciarCensoSinArchivo = new JButton("A mano");
		btnIniciarCensoSinArchivo.setBackground(colorBtn);
		btnIniciarCensoSinArchivo.setFont(fuenteBtn);
		btnIniciarCensoSinArchivo.setBounds(xBtn, yBtn*2, anchoBtn, altoBtn);
		btnIniciarCensoSinArchivo.setToolTipText("Ingresa los datos de los censistas y de la ciudad");
		accionBtnSinArchivo();
		add(btnIniciarCensoSinArchivo);
	}
	
	private void accionBtnSinArchivo() {
		btnIniciarCensoSinArchivo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.crearCensoSinArchivo();
			}
		});
	}

	private void iniciarBtnIniciarExtras() {
		btnIniciarExtras = new JButton("Extras");
		btnIniciarExtras.setBackground(colorBtn);
		btnIniciarExtras.setFont(fuenteBtn);
		btnIniciarExtras.setBounds(xBtn, yBtn*3, anchoBtn, altoBtn);
		accionBtnExtras();
		add(btnIniciarExtras);
	}

	private void accionBtnExtras() {
		btnIniciarExtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.crearPanelExtras();
			}
		});
	}

	private void iniciarEtiquetas() {
		iniciarLblBienvenido();
		iniciarLblAvisoImportante();
	}

	private void iniciarLblBienvenido() {
		lblBienvenido = new JLabel("Bienvenido al Censo 2022!");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Consolas", Font.BOLD, 25));
		lblBienvenido.setBounds(10, 72, ancho-20, 50);
		add(lblBienvenido);
	}

	private void iniciarLblAvisoImportante() {
		lblAvisoImportante = new JLabel("   *Por favor, vuelca la informaci\u00F3n pertinente:");
		lblAvisoImportante.setFont(new Font("Consolas", Font.ITALIC, 15));
		lblAvisoImportante.setBounds(10, 213, ancho-20, 50);
		add(lblAvisoImportante);
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
