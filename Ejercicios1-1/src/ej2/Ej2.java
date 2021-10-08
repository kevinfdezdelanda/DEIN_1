package ej2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Ej2 extends JFrame {

	private JTextField txtCodigoAnimal;
	private JTextField txtNombreAnimal;
	private JTextField txtEspecie;
	private JTextField txtRaza;
	private JTextField txtEdad;
	private JTextField txtPeso;
	private JTextField txtFecha;
	private JTextField textField;
	private JTable table;
	private JTextPane txtpnObservaciones;
	private JButton btnFecha;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel label;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej2 frame = new Ej2();
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
	public Ej2() {	
		eventos();
		dibujar();
	}

	public void eventos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void dibujar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ej2.class.getResource("/iconos/outline_pets_black_24dp.png")));
		setTitle("REGISTRO DE ANIMALES");
		setBounds(100, 100, 963, 518);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 92, 92));
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{817, 0};
		gbl_panel.rowHeights = new int[]{25, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(10, 0, 10, 0);
		gbc_panel_9.anchor = GridBagConstraints.NORTH;
		gbc_panel_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 0;
		panel.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRegistroDeAnimales = new JLabel("REGISTRO DE ANIMALES");
		panel_9.add(lblRegistroDeAnimales);
		lblRegistroDeAnimales.setBackground(new Color(238, 238, 238));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel_1.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(205, 92, 92));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCodigoDelAnimal = new JLabel("Codigo del animal:");
		panel_2.add(lblCodigoDelAnimal);
		
		txtCodigoAnimal = new JTextField();
		panel_2.add(txtCodigoAnimal);
		txtCodigoAnimal.setColumns(10);
		
		JLabel lblDatosDelAnimal = new JLabel("Datos del animal");
		GridBagConstraints gbc_lblDatosDelAnimal = new GridBagConstraints();
		gbc_lblDatosDelAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosDelAnimal.gridx = 0;
		gbc_lblDatosDelAnimal.gridy = 1;
		panel_1.add(lblDatosDelAnimal, gbc_lblDatosDelAnimal);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(205, 92, 92));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNombreDelAnimal = new JLabel("Nombre del animal:");
		GridBagConstraints gbc_lblNombreDelAnimal = new GridBagConstraints();
		gbc_lblNombreDelAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelAnimal.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDelAnimal.gridx = 0;
		gbc_lblNombreDelAnimal.gridy = 0;
		panel_3.add(lblNombreDelAnimal, gbc_lblNombreDelAnimal);
		
		txtNombreAnimal = new JTextField();
		GridBagConstraints gbc_txtNombreAnimal = new GridBagConstraints();
		gbc_txtNombreAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreAnimal.gridx = 1;
		gbc_txtNombreAnimal.gridy = 0;
		panel_3.add(txtNombreAnimal, gbc_txtNombreAnimal);
		txtNombreAnimal.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Especie:");
		GridBagConstraints gbc_lblEspecie = new GridBagConstraints();
		gbc_lblEspecie.anchor = GridBagConstraints.EAST;
		gbc_lblEspecie.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspecie.gridx = 0;
		gbc_lblEspecie.gridy = 1;
		panel_3.add(lblEspecie, gbc_lblEspecie);
		
		txtEspecie = new JTextField();
		GridBagConstraints gbc_txtEspecie = new GridBagConstraints();
		gbc_txtEspecie.insets = new Insets(0, 0, 5, 5);
		gbc_txtEspecie.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEspecie.gridx = 1;
		gbc_txtEspecie.gridy = 1;
		panel_3.add(txtEspecie, gbc_txtEspecie);
		txtEspecie.setColumns(10);
		
		JLabel lblRaza = new JLabel("Raza:");
		GridBagConstraints gbc_lblRaza = new GridBagConstraints();
		gbc_lblRaza.anchor = GridBagConstraints.EAST;
		gbc_lblRaza.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaza.gridx = 0;
		gbc_lblRaza.gridy = 2;
		panel_3.add(lblRaza, gbc_lblRaza);
		
		txtRaza = new JTextField();
		GridBagConstraints gbc_txtRaza = new GridBagConstraints();
		gbc_txtRaza.insets = new Insets(0, 0, 5, 5);
		gbc_txtRaza.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRaza.gridx = 1;
		gbc_txtRaza.gridy = 2;
		panel_3.add(txtRaza, gbc_txtRaza);
		txtRaza.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 3;
		panel_3.add(lblSexo, gbc_lblSexo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hembra", "Macho"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panel_3.add(comboBox, gbc_comboBox);
		
		JLabel lblEdadaprox = new JLabel("Edad (aprox.):");
		GridBagConstraints gbc_lblEdadaprox = new GridBagConstraints();
		gbc_lblEdadaprox.anchor = GridBagConstraints.EAST;
		gbc_lblEdadaprox.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdadaprox.gridx = 0;
		gbc_lblEdadaprox.gridy = 4;
		panel_3.add(lblEdadaprox, gbc_lblEdadaprox);
		
		txtEdad = new JTextField();
		GridBagConstraints gbc_txtEdad = new GridBagConstraints();
		gbc_txtEdad.insets = new Insets(0, 0, 5, 5);
		gbc_txtEdad.gridx = 1;
		gbc_txtEdad.gridy = 4;
		panel_3.add(txtEdad, gbc_txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		GridBagConstraints gbc_lblPeso = new GridBagConstraints();
		gbc_lblPeso.anchor = GridBagConstraints.EAST;
		gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeso.gridx = 0;
		gbc_lblPeso.gridy = 5;
		panel_3.add(lblPeso, gbc_lblPeso);
		
		txtPeso = new JTextField();
		GridBagConstraints gbc_txtPeso = new GridBagConstraints();
		gbc_txtPeso.insets = new Insets(0, 0, 5, 5);
		gbc_txtPeso.gridx = 1;
		gbc_txtPeso.gridy = 5;
		panel_3.add(txtPeso, gbc_txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 0;
		gbc_lblObservaciones.gridy = 6;
		panel_3.add(lblObservaciones, gbc_lblObservaciones);
		
		txtpnObservaciones = new JTextPane();
		GridBagConstraints gbc_txtpnObservaciones = new GridBagConstraints();
		gbc_txtpnObservaciones.ipady = 60;
		gbc_txtpnObservaciones.ipadx = 10;
		gbc_txtpnObservaciones.gridwidth = 2;
		gbc_txtpnObservaciones.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnObservaciones.fill = GridBagConstraints.BOTH;
		gbc_txtpnObservaciones.gridx = 1;
		gbc_txtpnObservaciones.gridy = 6;
		panel_3.add(txtpnObservaciones, gbc_txtpnObservaciones);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso:");
		GridBagConstraints gbc_lblFechaDeIngreso = new GridBagConstraints();
		gbc_lblFechaDeIngreso.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeIngreso.insets = new Insets(0, 0, 0, 5);
		gbc_lblFechaDeIngreso.gridx = 0;
		gbc_lblFechaDeIngreso.gridy = 7;
		panel_3.add(lblFechaDeIngreso, gbc_lblFechaDeIngreso);
		
		txtFecha = new JTextField();
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.insets = new Insets(0, 0, 0, 5);
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.gridx = 1;
		gbc_txtFecha.gridy = 7;
		panel_3.add(txtFecha, gbc_txtFecha);
		txtFecha.setColumns(10);
		
		btnFecha = new JButton("");
		btnFecha.setSelectedIcon(new ImageIcon(Ej2.class.getResource("/iconos/calendario.png")));
		btnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFecha.setIcon(new ImageIcon(Ej2.class.getResource("/iconos/calendario.png")));
		btnFecha.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnFecha = new GridBagConstraints();
		gbc_btnFecha.gridx = 2;
		gbc_btnFecha.gridy = 7;
		panel_3.add(btnFecha, gbc_btnFecha);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 255, 0));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.SOUTH;
		gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_4.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{94, 0};
		gbl_panel_5.rowHeights = new int[]{25, 25, 25, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		btnNuevo = new JButton("nuevo");
		btnNuevo.setIcon(new ImageIcon(Ej2.class.getResource("/iconos/nuevo.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNuevo.insets = new Insets(10, 10, 5, 10);
		gbc_btnNuevo.gridx = 0;
		gbc_btnNuevo.gridy = 0;
		panel_5.add(btnNuevo, gbc_btnNuevo);
		
		btnGuardar = new JButton("guardar");
		btnGuardar.setIcon(new ImageIcon(Ej2.class.getResource("/iconos/guardar.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.insets = new Insets(5, 10, 5, 10);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 1;
		panel_5.add(btnGuardar, gbc_btnGuardar);
		
		btnCancelar = new JButton("cancelar");
		btnCancelar.setIcon(new ImageIcon(Ej2.class.getResource("/iconos/cancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(5, 10, 10, 10);
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.gridx = 0;
		gbc_btnCancelar.gridy = 2;
		panel_5.add(btnCancelar, gbc_btnCancelar);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 0;
		panel_4.add(panel_6, gbc_panel_6);
		
		label = new JLabel("");
		panel_6.add(label);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 255, 0));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_7.anchor = GridBagConstraints.PAGE_END;
		gbc_panel_7.gridx = 2;
		gbc_panel_7.gridy = 0;
		panel_4.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{117, 0};
		gbl_panel_7.rowHeights = new int[]{25, 25, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		btnNewButton_1 = new JButton("Seleccionar imagen");
		btnNewButton_1.setIcon(new ImageIcon(Ej2.class.getResource("/iconos/seleccionar.png")));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(10, 10, 5, 10);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 0;
		panel_7.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.setIcon(new ImageIcon(Ej2.class.getResource("/iconos/guardar.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(5, 10, 10, 10);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		panel_7.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_8.setBackground(new Color(205, 92, 92));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.gridwidth = 3;
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		panel_4.add(panel_8, gbc_panel_8);
		
		JLabel lblBuscar = new JLabel("Buscar: ");
		panel_8.add(lblBuscar);
		
		textField = new JTextField();
		panel_8.add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Ej2.class.getResource("/iconos/buscar.png")));
		panel_8.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Ej2.class.getResource("/iconos/borrar.png")));
		panel_8.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(Ej2.class.getResource("/iconos/salir.png")));
		panel_8.add(btnSalir);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"NOMBRE", "ESPECIE", "RAZA", "SEXO", "Edad", "PESO", "OBSERVACIONES", null},
				{"Sua", "Perro", null, "Macho", "8", "50", "Operacion de rodilla", "30/09/2021"},
			},
			new String[] {
				"NOMBRE", "ESPECIE", "RAZA", "SEXO", "Edad", "PESO", "OBSERVACIONES", "FECHA"
			}
		));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		panel_4.add(table, gbc_table);
	}

}
