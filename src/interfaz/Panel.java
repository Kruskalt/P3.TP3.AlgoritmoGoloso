package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public abstract class Panel extends JPanel {

	private static final long serialVersionUID = 4693745450615514199L;
	
	protected VentanaPrincipal ventana;

	//caracteristicas del panel:
	protected final int posX = 0;
	protected final int posY = 0;
	protected final int ancho = 1000;
	protected final int alto = 650;
	protected final Color colorDeFondo = new Color(51, 153, 255);
	protected final LineBorder lineaBordeada = new LineBorder(new Color(51, 51, 255), 2, true);

	//botones y sus caracteristicas:
	protected final Font fuenteBtn = new Font("Consolas", Font.BOLD, 18);
	protected final Color colorBtn = new Color(51, 190, 255);
	protected final int anchoBtn = 300;
	protected final int altoBtn = 50;

	protected JButton btnVolverInicio;
	

	public Panel (VentanaPrincipal vp) {
		ventana = vp;
	}
	
	protected void iniciarBtnVolverInicio() {
		btnVolverInicio = new JButton("Volver al inicio");
		btnVolverInicio.setBackground(colorBtn);
		btnVolverInicio.setFont(fuenteBtn);
		btnVolverInicio.setBounds(ancho/100, alto-10 - altoBtn, anchoBtn, altoBtn);
		btnVolverInicio.setToolTipText("Vuelve al inicio, tendras que reingresar tus datos!");
		accionBtnVolverInicio();
		add(btnVolverInicio);
	}

	private void accionBtnVolverInicio() {
		btnVolverInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.volverInicio();
			}
		});
	}
	
	protected void ignorarLetras(JTextField texto) {
		texto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			    if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			       e.consume();
			    }
			}
		});
	}
	
	public abstract void mostrarPanel();
	
	public abstract void ocultarPanel();

}
