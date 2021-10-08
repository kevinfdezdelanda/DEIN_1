package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionarAeropuertos;
import model.Aeropuerto;
import model.AeropuertoPrivado;
import model.AeropuertoPublico;
import model.Direccion;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AniadirEditar extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPais;
	private JTextField txtCiudad;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtAoDeInauguracion;
	private JTextField txtCapacidad;
	private JTextField txtNumTrabajadores;
	private JTextField txtFinanciacion;
	private JTextField txtNumSocios;
	private JRadioButton rdbtnPrivado;
	private JRadioButton rdbtnPublico;
	private JLabel lblNumeroDeSocios;
	private JLabel lblFinanciacion;
	private JLabel lblNumeroDeTrabajadores;
	private Aeropuerto a;


	/**
	 * Create the frame.
	 */
	public AniadirEditar(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		dibujar();
	}
	
	public AniadirEditar(java.awt.Frame parent, boolean modal,Aeropuerto a) {
		super(parent,modal);
		this.a = a;
		dibujar();
	}

	public void dibujar() {
		setBounds(100, 100, 385, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDatosDelAeropuerto = new JLabel("DATOS DEL AEROPUERTO");
		lblDatosDelAeropuerto.setFont(new Font("Dialog", Font.BOLD, 17));
		GridBagConstraints gbc_lblDatosDelAeropuerto = new GridBagConstraints();
		gbc_lblDatosDelAeropuerto.gridwidth = 2;
		gbc_lblDatosDelAeropuerto.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatosDelAeropuerto.gridx = 0;
		gbc_lblDatosDelAeropuerto.gridy = 0;
		contentPane.add(lblDatosDelAeropuerto, gbc_lblDatosDelAeropuerto);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPais = new JLabel("Pais:");
		GridBagConstraints gbc_lblPais = new GridBagConstraints();
		gbc_lblPais.anchor = GridBagConstraints.EAST;
		gbc_lblPais.insets = new Insets(0, 0, 5, 5);
		gbc_lblPais.gridx = 0;
		gbc_lblPais.gridy = 2;
		contentPane.add(lblPais, gbc_lblPais);
		
		txtPais = new JTextField();
		GridBagConstraints gbc_txtPais = new GridBagConstraints();
		gbc_txtPais.insets = new Insets(0, 0, 5, 0);
		gbc_txtPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPais.gridx = 1;
		gbc_txtPais.gridy = 2;
		contentPane.add(txtPais, gbc_txtPais);
		txtPais.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.EAST;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 0;
		gbc_lblCiudad.gridy = 3;
		contentPane.add(lblCiudad, gbc_lblCiudad);
		
		txtCiudad = new JTextField();
		GridBagConstraints gbc_txtCiudad = new GridBagConstraints();
		gbc_txtCiudad.insets = new Insets(0, 0, 5, 0);
		gbc_txtCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCiudad.gridx = 1;
		gbc_txtCiudad.gridy = 3;
		contentPane.add(txtCiudad, gbc_txtCiudad);
		txtCiudad.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle:");
		GridBagConstraints gbc_lblCalle = new GridBagConstraints();
		gbc_lblCalle.anchor = GridBagConstraints.EAST;
		gbc_lblCalle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCalle.gridx = 0;
		gbc_lblCalle.gridy = 4;
		contentPane.add(lblCalle, gbc_lblCalle);
		
		txtCalle = new JTextField();
		GridBagConstraints gbc_txtCalle = new GridBagConstraints();
		gbc_txtCalle.insets = new Insets(0, 0, 5, 0);
		gbc_txtCalle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCalle.gridx = 1;
		gbc_txtCalle.gridy = 4;
		contentPane.add(txtCalle, gbc_txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.anchor = GridBagConstraints.EAST;
		gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumero.gridx = 0;
		gbc_lblNumero.gridy = 5;
		contentPane.add(lblNumero, gbc_lblNumero);
		
		txtNumero = new JTextField();
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 5;
		contentPane.add(txtNumero, gbc_txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblAoDeInauguracion = new JLabel("Año de inauguración:");
		GridBagConstraints gbc_lblAoDeInauguracion = new GridBagConstraints();
		gbc_lblAoDeInauguracion.anchor = GridBagConstraints.EAST;
		gbc_lblAoDeInauguracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblAoDeInauguracion.gridx = 0;
		gbc_lblAoDeInauguracion.gridy = 6;
		contentPane.add(lblAoDeInauguracion, gbc_lblAoDeInauguracion);
		
		txtAoDeInauguracion = new JTextField();
		GridBagConstraints gbc_txtAoDeInauguracion = new GridBagConstraints();
		gbc_txtAoDeInauguracion.insets = new Insets(0, 0, 5, 0);
		gbc_txtAoDeInauguracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAoDeInauguracion.gridx = 1;
		gbc_txtAoDeInauguracion.gridy = 6;
		contentPane.add(txtAoDeInauguracion, gbc_txtAoDeInauguracion);
		txtAoDeInauguracion.setColumns(10);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		GridBagConstraints gbc_lblCapacidad = new GridBagConstraints();
		gbc_lblCapacidad.anchor = GridBagConstraints.EAST;
		gbc_lblCapacidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacidad.gridx = 0;
		gbc_lblCapacidad.gridy = 7;
		contentPane.add(lblCapacidad, gbc_lblCapacidad);
		
		txtCapacidad = new JTextField();
		GridBagConstraints gbc_txtCapacidad = new GridBagConstraints();
		gbc_txtCapacidad.insets = new Insets(0, 0, 5, 0);
		gbc_txtCapacidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCapacidad.gridx = 1;
		gbc_txtCapacidad.gridy = 7;
		contentPane.add(txtCapacidad, gbc_txtCapacidad);
		txtCapacidad.setColumns(10);
		
		rdbtnPublico = new JRadioButton("Publico");
		rdbtnPublico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				publicoPrivado();
			}
		});
		rdbtnPublico.setSelected(true);
		GridBagConstraints gbc_rdbtnPublico = new GridBagConstraints();
		gbc_rdbtnPublico.anchor = GridBagConstraints.SOUTH;
		gbc_rdbtnPublico.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPublico.gridx = 0;
		gbc_rdbtnPublico.gridy = 8;
		contentPane.add(rdbtnPublico, gbc_rdbtnPublico);
		
		rdbtnPrivado = new JRadioButton("Privado");
		rdbtnPrivado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				publicoPrivado();
			}
		});
		GridBagConstraints gbc_rdbtnPrivado = new GridBagConstraints();
		gbc_rdbtnPrivado.anchor = GridBagConstraints.SOUTH;
		gbc_rdbtnPrivado.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnPrivado.gridx = 1;
		gbc_rdbtnPrivado.gridy = 8;
		contentPane.add(rdbtnPrivado, gbc_rdbtnPrivado);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnPrivado);
	    group.add(rdbtnPublico);
		
		lblNumeroDeTrabajadores = new JLabel("Numero de trabajadores:");
		GridBagConstraints gbc_lblNumeroDeTrabajadores = new GridBagConstraints();
		gbc_lblNumeroDeTrabajadores.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroDeTrabajadores.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDeTrabajadores.gridx = 0;
		gbc_lblNumeroDeTrabajadores.gridy = 9;
		contentPane.add(lblNumeroDeTrabajadores, gbc_lblNumeroDeTrabajadores);
		
		txtNumTrabajadores = new JTextField();
		GridBagConstraints gbc_txtNumTrabajadores = new GridBagConstraints();
		gbc_txtNumTrabajadores.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumTrabajadores.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumTrabajadores.gridx = 1;
		gbc_txtNumTrabajadores.gridy = 9;
		contentPane.add(txtNumTrabajadores, gbc_txtNumTrabajadores);
		txtNumTrabajadores.setColumns(10);
		
		lblFinanciacion = new JLabel("Financiacion:");
		GridBagConstraints gbc_lblFinanciacion = new GridBagConstraints();
		gbc_lblFinanciacion.anchor = GridBagConstraints.EAST;
		gbc_lblFinanciacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinanciacion.gridx = 0;
		gbc_lblFinanciacion.gridy = 10;
		contentPane.add(lblFinanciacion, gbc_lblFinanciacion);
		
		txtFinanciacion = new JTextField();
		GridBagConstraints gbc_txtFinanciacion = new GridBagConstraints();
		gbc_txtFinanciacion.insets = new Insets(0, 0, 5, 0);
		gbc_txtFinanciacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFinanciacion.gridx = 1;
		gbc_txtFinanciacion.gridy = 10;
		contentPane.add(txtFinanciacion, gbc_txtFinanciacion);
		txtFinanciacion.setColumns(10);
		
		lblNumeroDeSocios = new JLabel("Numero de socios:");
		GridBagConstraints gbc_lblNumeroDeSocios = new GridBagConstraints();
		gbc_lblNumeroDeSocios.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNumeroDeSocios.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDeSocios.gridx = 0;
		gbc_lblNumeroDeSocios.gridy = 11;
		contentPane.add(lblNumeroDeSocios, gbc_lblNumeroDeSocios);
		
		txtNumSocios = new JTextField();
		GridBagConstraints gbc_txtNumSocios = new GridBagConstraints();
		gbc_txtNumSocios.anchor = GridBagConstraints.NORTH;
		gbc_txtNumSocios.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumSocios.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumSocios.gridx = 1;
		gbc_txtNumSocios.gridy = 11;
		contentPane.add(txtNumSocios, gbc_txtNumSocios);
		txtNumSocios.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guargar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 12;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 12;
		contentPane.add(btnCancelar, gbc_btnCancelar);
		
		publicoPrivado();
		
		if(a!=null) {
			rellenarDatosEditar(a);
		}
	}
	
	public void rellenarDatosEditar(Aeropuerto aeropuerto) {
		txtNombre.setText(aeropuerto.getNombre());
		txtPais.setText(aeropuerto.getDireccion().getPais());
		txtCiudad.setText(aeropuerto.getDireccion().getCiudad());
		txtCalle.setText(aeropuerto.getDireccion().getCalle());
		txtNumero.setText(aeropuerto.getDireccion().getNumero()+"");
		txtAoDeInauguracion.setText(aeropuerto.getAnio_inauguracion()+"");
		txtCapacidad.setText(aeropuerto.getCapacidad()+"");
		
		if(aeropuerto.getaPrivado()!=null) {
			rdbtnPublico.setSelected(false);
			rdbtnPrivado.setSelected(true);
			publicoPrivado();
			txtNumSocios.setText(aeropuerto.getaPrivado().getnSocios()+"");
		}else {
			txtFinanciacion.setText(aeropuerto.getaPublico().getFinanciacion()+"");
			txtNumTrabajadores.setText(aeropuerto.getaPublico().getNumTrabajadores()+"");
		}
		
		rdbtnPrivado.setEnabled(false);
		rdbtnPublico.setEnabled(false);
	}
	
	public void publicoPrivado() {
		if(rdbtnPrivado.isSelected()) {
			txtNumSocios.setVisible(true);
			txtNumTrabajadores.setVisible(false);
			txtFinanciacion.setVisible(false);
			
			lblNumeroDeSocios.setVisible(true);
			lblNumeroDeTrabajadores.setVisible(false);
			lblFinanciacion.setVisible(false);
		}else {
			txtNumSocios.setVisible(false);
			txtNumTrabajadores.setVisible(true);
			txtFinanciacion.setVisible(true);
			
			lblNumeroDeSocios.setVisible(false);
			lblNumeroDeTrabajadores.setVisible(true);
			lblFinanciacion.setVisible(true);
		}
	}
	
	public void guargar() {
		try {
			Aeropuerto aeropuerto = new Aeropuerto();
			
			String nombre = txtNombre.getText();
			if(nombre.equals("")) {
				throw new Exception("Todos los campos tienen que estar rellenos");
			}
			aeropuerto.setNombre(nombre);
			
			Direccion d = new Direccion();
			
			String pais = txtPais.getText();
			if(pais.equals("")) {
				throw new Exception("Todos los campos tienen que estar rellenos");
			}
			d.setPais(txtPais.getText());
			
			String ciudad = txtCiudad.getText();
			if(ciudad.equals("")) {
				throw new Exception("Todos los campos tienen que estar rellenos");
			}
			d.setCiudad(txtCiudad.getText());
			
			String calle = txtCalle.getText();
			if(calle.equals("")) {
				throw new Exception("Todos los campos tienen que estar rellenos");
			}
			d.setCalle(txtCalle.getText());
			
			d.setNumero(Integer.parseInt(txtNumero.getText()));
			aeropuerto.setDireccion(d);
			
			aeropuerto.setAnio_inauguracion(Integer.parseInt(txtAoDeInauguracion.getText()));
			aeropuerto.setCapacidad(Integer.parseInt(txtCapacidad.getText()));
			
			if(rdbtnPrivado.isSelected()) {
				AeropuertoPrivado ap = new AeropuertoPrivado();
				ap.setnSocios(Integer.parseInt(txtNumSocios.getText()));
				aeropuerto.setaPrivado(ap);
			}else {
				AeropuertoPublico ap = new AeropuertoPublico();
				ap.setNumTrabajadores((Integer.parseInt(txtNumTrabajadores.getText())));
				
				String financiacion = txtFinanciacion.getText();
				if(!financiacion.matches("^-?[0-9]+([\\.,][0-9]+)?$")) {
					throw new Exception("La financiacion debe ser un numero decimal valido");
				}
				ap.setFinanciacion((Double.parseDouble(financiacion)));
				
				aeropuerto.setaPublico(ap);
			}
			
			GestionarAeropuertos ga = new GestionarAeropuertos();
			
			if(a==null) {
				if(ga.nuevoAeropuerto(aeropuerto)) {
					JOptionPane.showMessageDialog(null, "Aeropuerto creado","Exito", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error al guardar","Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				aeropuerto.setId(a.getId());
				aeropuerto.getDireccion().setId(a.getDireccion().getId());
				if(ga.editarAeropuerto(aeropuerto)) {
					JOptionPane.showMessageDialog(null, "Aeropuerto editado","Exito", JOptionPane.INFORMATION_MESSAGE);
					rellenarDatosEditar(aeropuerto);
				}else {
					JOptionPane.showMessageDialog(null, "Error al editar","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debes introducir un numero valido","Error", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
