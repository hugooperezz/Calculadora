package Calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

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
	private JPanel botonesOperadores;
	private JPanel botonesRegulares;
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

		// Panel de abajo
		this.buttonPanel = new JPanel();
		this.buttonPanel.setLayout(new FlowLayout());

		// Configuro los botones
		this.botonesOperadores = new JPanel(new GridLayout(4, 3, 5, 5));
		this.botonesRegulares = new JPanel(new GridLayout(5, 1, 5, 5));

		// Inicializo los botones con el metodo
		inicializarBotones();

		// Agregar botones numéricos
		this.botonesRegulares.add(this.n1);
		this.botonesRegulares.add(this.n2);
		this.botonesRegulares.add(this.n3);
		this.botonesRegulares.add(this.n4);
		this.botonesRegulares.add(this.n5);
		this.botonesRegulares.add(this.n6);
		this.botonesRegulares.add(this.n7);
		this.botonesRegulares.add(this.n8);
		this.botonesRegulares.add(this.n9);
		this.botonesRegulares.add(this.reset);
		this.botonesRegulares.add(this.n0);
		this.botonesRegulares.add(this.equal);

		// Agregar los botones de operaciones
		this.botonesOperadores.add(this.add);
		this.botonesOperadores.add(this.subtract);
		this.botonesOperadores.add(this.multiply);
		this.botonesOperadores.add(this.divide);

		// Agregar los botones a la ventana
		this.buttonPanel.add(this.botonesRegulares, BorderLayout.CENTER);
		this.buttonPanel.add(this.botonesOperadores, BorderLayout.EAST);
		this.buttonPanel.setSize(800, 500);

		// Agrego los paneles al panel principal
		this.panelPrincipal.add(this.buttonPanel);

		// Hacer visible la ventana
		this.setVisible(true);

		// Cerrar la ventana
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// Metodo que se encarga de inicializar todos los botones de forma automatica
	// llamando asi a el metodo de createButton que se encarga de verificar que tipo
	// de boton es para darle propiedades segun su tipo
	private void inicializarBotones() {
		// Botones numéricos
		n0 = createButton("0", ButtonType.REGULAR);
		n1 = createButton("1", ButtonType.REGULAR);
		n2 = createButton("2", ButtonType.REGULAR);
		n3 = createButton("3", ButtonType.REGULAR);
		n4 = createButton("4", ButtonType.REGULAR);
		n5 = createButton("5", ButtonType.REGULAR);
		n6 = createButton("6", ButtonType.REGULAR);
		n7 = createButton("7", ButtonType.REGULAR);
		n8 = createButton("8", ButtonType.REGULAR);
		n9 = createButton("9", ButtonType.REGULAR);

		// Botones de operadores
		add = createButton("+", ButtonType.OPERATOR);
		subtract = createButton("-", ButtonType.OPERATOR);
		multiply = createButton("*", ButtonType.OPERATOR);
		divide = createButton("/", ButtonType.OPERATOR);
		equal = createButton("=", ButtonType.OPERATOR);
		reset = createButton("C", ButtonType.OPERATOR);
	}

	// Metodo que se encarga de crear los botones que es llamado en la clase que se
	// encarga de inizializarlo, este metodo verifica que tipo de boton es el que es
	// y segun el tipo le proporciona un color diferente o no
	private JButton createButton(String texto, ButtonType tipo) {
		JButton boton = new JButton(texto);
		boton.setPreferredSize(new Dimension(100, 80));

		if (tipo == ButtonType.OPERATOR) {
			boton.setBackground(Color.LIGHT_GRAY);
		} else if (tipo == ButtonType.REGULAR) {
			boton.setBackground(Color.WHITE);
		}
		boton.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente grande
		boton.setFocusPainted(false); // Eliminar borde de foco
		return boton;

	}
}
