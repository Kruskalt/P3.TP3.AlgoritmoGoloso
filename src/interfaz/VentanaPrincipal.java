package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import censo2022.RadioCensal;

public class VentanaPrincipal {

	private JFrame ventanaPrincipal;
	
	//caracteristicas
	final int posX = 50;
	final int posY = 10;
	final int ancho = 1016;
	final int alto = 689;
	
	//paneles
	private Inicio inicio;
	private CensoSinArchivo censoSinArchivo;
	private Extras comparacionesExtras;
	private Asignaciones censistasAsignados;
	
	//clases de negocio
	private RadioCensal radioCensal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
					VentanaPrincipal window = new VentanaPrincipal();
					window.ventanaPrincipal.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		iniciarVentana();
		iniciarPanelInicio();
	}
	
	private void iniciarVentana() {
		ventanaPrincipal = new JFrame();
		ventanaPrincipal.setResizable(false);
		ventanaPrincipal.setBounds(posX, posY, ancho, alto);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void iniciarPanelInicio() {
		inicio = new Inicio(this);
		inicio.mostrarPanel();
		ventanaPrincipal.getContentPane().add(inicio);
	}

	public void crearCensoSinArchivo() {
		inicio.ocultarPanel();
		iniciarPanelCensoSinArchivo();
	}
	
	private void iniciarPanelCensoSinArchivo() {
		censoSinArchivo = new CensoSinArchivo(this);
		censoSinArchivo.mostrarPanel();
		ventanaPrincipal.getContentPane().add(censoSinArchivo);
	}

	public void crearPanelExtras() {
		inicio.ocultarPanel();
		iniciarPanelExtras();
	}
	
	private void iniciarPanelExtras() {
		comparacionesExtras = new Extras(this);
		comparacionesExtras.mostrarPanel();
		ventanaPrincipal.getContentPane().add(comparacionesExtras);
	}

	public void volverInicio() {
		inicio.mostrarPanel();
		
		radioCensal = null;

		if (censoSinArchivo != null)
			ventanaPrincipal.getContentPane().remove(censoSinArchivo);
		
		if (comparacionesExtras != null)
			ventanaPrincipal.getContentPane().remove(comparacionesExtras);
		
		if (censistasAsignados != null)
			ventanaPrincipal.getContentPane().remove(censistasAsignados);
	}
	
	public void iniciarRadioCensal(String vertices) {
		radioCensal = new RadioCensal(Integer.parseInt(vertices));
	}
	
	public void agregarCensista(String censista, String dni) {
		radioCensal.agregarCensista(censista, Integer.parseInt(dni));
	}
	
	public void conectarManzanas(String origen, String destino) {
		radioCensal.agregarConexionEntreManzanas(Integer.parseInt(origen), Integer.parseInt(destino));
	}
	
	public void censar() {
		radioCensal.censar();
	}
	
	public int cantManzanas() {
		return radioCensal.getCantidadManzanas();
	}
	
	public boolean estanConectadas() {
		return radioCensal.estanConectadas();
	}
	
	public boolean hayCensistas() {
		return radioCensal.hayCensistas();
	}
	
	public String censistasSoloNombreYDNI() {
		return radioCensal.censistasNombreYDNI();
	}
	
	public String censistasToString() {
		return radioCensal.censistasToString();
	}
	
	public String grafoToString() {
		return radioCensal.ciudadToString();
	}

	public void crearCensistasAsignados() {
		censoSinArchivo.ocultarPanel();
		iniciarPanelAsignaciones();
	}
	
	private void iniciarPanelAsignaciones() {
		censistasAsignados = new Asignaciones(this);
		censistasAsignados.mostrarPanel();
		ventanaPrincipal.getContentPane().add(censistasAsignados);
	}

	public void reiniciarInformacion(String str) {
		volverInicio();
		if (str.equals("sin_archivo"))
			crearCensoSinArchivo();
		if (str.equals("extras"))
			crearPanelExtras();
	}
}
