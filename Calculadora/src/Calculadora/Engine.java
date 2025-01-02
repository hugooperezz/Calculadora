package Calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Engine extends JFrame {
	// Atributos de la clase Engine
	// Marco de la ventana
	private Container panelPrincipal;
	private JFrame frame;
	// Panel general que ocupa toda la ventana
	private JPanel contentPanel;
	// Panel norte que contiene el display
	private JPanel displayPanel;
	private JTextField pantalla;
	// Panel sur que contiene los botones
	private JPanel buttonPanel;
	// Display
	private JTextField display;
	// Botones
	private JButton n0;
	private JButton n1;
	private JButton n2;
	private JButton n3;
	private JButton n4;
	private JButton n5;
	private JButton n6;
	private JButton n7;
	private JButton n8;
	private JButton n9;
	private JButton divide;
	private JButton multiply;
	private JButton subtract;
	private JButton add;
	private JButton equal;
	private JButton reset;

	// Tipos de boton
	private enum ButtonType {
		REGULAR, OPERATOR
	}

	// Almacenar temporalmente ciertos valores
	private int num1, num2, result;
	private char operation;

	public Engine(String msg) {
		super(msg);

		// Contenedor principal
		this.panelPrincipal = this.getContentPane();
		this.panelPrincipal.setLayout(new BorderLayout());

		// Propiedades de la ventana
		this.setLocation(50, 100);
		this.setSize(500, 500);

		// Panel de arriba
		this.displayPanel = new JPanel();
		this.displayPanel.setLayout(new FlowLayout());

		// Configuro el panel donde se van a ver los numeros seleccionados por los
		// botones
		this.pantalla = new JTextField(40);
		this.pantalla.setEditable(false);// Con este comando el usuario no va a poder escribir en la pantalla
		this.pantalla.setHorizontalAlignment(JTextField.RIGHT);// Esto permite que los numeros seleccionados aparezcan a
																// la derecha de la pantalla
		this.pantalla.setPreferredSize(new Dimension(50, 50));// Permite modificar el largo y el ancho (El largo no
																// funciona)
		this.pantalla.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));// Color borde
		this.pantalla.setBackground(Color.LIGHT_GRAY);// Fondo
		this.pantalla.setForeground(Color.BLACK);// Texto
		this.displayPanel.add(this.pantalla);
		this.panelPrincipal.add(this.displayPanel, BorderLayout.NORTH);

	
		// Hacer visible la ventana
		this.setVisible(true);
		
		//Cerrar la ventana
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
