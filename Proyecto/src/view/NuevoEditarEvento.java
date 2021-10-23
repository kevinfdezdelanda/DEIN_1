package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionDeportes;
import dao.GestionEventos;
import dao.GestionOlimpiadas;
import model.Deporte;
import model.Evento;
import model.Olimpiada;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class NuevoEditarEvento extends javax.swing.JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private Olimpiada olimpiada;
	private Evento evento;
	private JComboBox cbOlimpiadas;
	private JComboBox cbDeporte;
	private DefaultComboBoxModel modeloOlimpiadas;
	private DefaultComboBoxModel modeloDeporte;
	private java.awt.Frame parent;
	private JTextField txtCrearDeporte;
	private JButton btnNuevoDeporte;
	private JButton btnNuevaOlimpiada;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	/**
	 * @wbp.parser.constructor
	 */
	public NuevoEditarEvento(java.awt.Frame parent, boolean modal, Olimpiada o) {
		super(parent,modal);
		this.parent = parent;
		this.olimpiada = o;
		dibujar();
		eventos();
	}
	
	public NuevoEditarEvento(java.awt.Frame parent, boolean modal, Evento e) {
		super(parent,modal);
		this.evento = e;
		olimpiada = e.getOlimpiada();
		dibujar();
		eventos();
	}

	public void dibujar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuevoEditarEvento.class.getResource("/imagenes/olimpiadasLogo.png")));
		setBounds(100, 100, 519, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 3;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		if(evento!=null) {
			txtNombre.setText(evento.getNombre());
		}
		
		JLabel lblDeporte = new JLabel("Deporte");
		GridBagConstraints gbc_lblDeporte = new GridBagConstraints();
		gbc_lblDeporte.anchor = GridBagConstraints.EAST;
		gbc_lblDeporte.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeporte.gridx = 0;
		gbc_lblDeporte.gridy = 1;
		contentPane.add(lblDeporte, gbc_lblDeporte);
		
		cbDeporte = new JComboBox();
		GridBagConstraints gbc_cbDeporte = new GridBagConstraints();
		gbc_cbDeporte.gridwidth = 3;
		gbc_cbDeporte.insets = new Insets(0, 0, 5, 5);
		gbc_cbDeporte.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDeporte.gridx = 1;
		gbc_cbDeporte.gridy = 1;
		contentPane.add(cbDeporte, gbc_cbDeporte);
		
		modeloDeporte = new DefaultComboBoxModel();
		cbDeporte.setModel(modeloDeporte);
		
		rellenarDeporte();
		
		btnNuevoDeporte = new JButton("Nuevo");
		
		JLabel lblNombreDeporteA = new JLabel("Crear deporte:");
		GridBagConstraints gbc_lblNombreDeporteA = new GridBagConstraints();
		gbc_lblNombreDeporteA.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeporteA.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDeporteA.gridx = 1;
		gbc_lblNombreDeporteA.gridy = 2;
		contentPane.add(lblNombreDeporteA, gbc_lblNombreDeporteA);
		
		txtCrearDeporte = new JTextField();
		txtCrearDeporte.setToolTipText("nombre nuevo deporte");
		GridBagConstraints gbc_txtCrearDeporte = new GridBagConstraints();
		gbc_txtCrearDeporte.insets = new Insets(0, 0, 5, 5);
		gbc_txtCrearDeporte.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCrearDeporte.gridx = 2;
		gbc_txtCrearDeporte.gridy = 2;
		contentPane.add(txtCrearDeporte, gbc_txtCrearDeporte);
		txtCrearDeporte.setColumns(10);
		GridBagConstraints gbc_btnNuevoDeporte = new GridBagConstraints();
		gbc_btnNuevoDeporte.insets = new Insets(0, 0, 5, 0);
		gbc_btnNuevoDeporte.gridx = 3;
		gbc_btnNuevoDeporte.gridy = 2;
		contentPane.add(btnNuevoDeporte, gbc_btnNuevoDeporte);
		
		JLabel lblOlimpiada = new JLabel("Olimpiada");
		GridBagConstraints gbc_lblOlimpiada = new GridBagConstraints();
		gbc_lblOlimpiada.anchor = GridBagConstraints.EAST;
		gbc_lblOlimpiada.insets = new Insets(0, 0, 5, 5);
		gbc_lblOlimpiada.gridx = 0;
		gbc_lblOlimpiada.gridy = 3;
		contentPane.add(lblOlimpiada, gbc_lblOlimpiada);
		
		cbOlimpiadas = new JComboBox();
		GridBagConstraints gbc_cbOlimpiadas = new GridBagConstraints();
		gbc_cbOlimpiadas.gridwidth = 2;
		gbc_cbOlimpiadas.gridwidth = 2;
		gbc_cbOlimpiadas.insets = new Insets(0, 0, 5, 5);
		gbc_cbOlimpiadas.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbOlimpiadas.gridx = 1;
		gbc_cbOlimpiadas.gridy = 3;
		contentPane.add(cbOlimpiadas, gbc_cbOlimpiadas);
		
		modeloOlimpiadas = new DefaultComboBoxModel();
		cbOlimpiadas.setModel(modeloOlimpiadas);
		
		rellenarOlimpiadas();
		
		btnNuevaOlimpiada = new JButton("Nuevo");
		GridBagConstraints gbc_btnNuevaOlimpiada = new GridBagConstraints();
		gbc_btnNuevaOlimpiada.insets = new Insets(0, 0, 5, 0);
		gbc_btnNuevaOlimpiada.gridx = 3;
		gbc_btnNuevaOlimpiada.gridy = 3;
		contentPane.add(btnNuevaOlimpiada, gbc_btnNuevaOlimpiada);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{121, 0, 96, 0};
		gbl_panel.rowHeights = new int[]{25, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 0;
		panel.add(btnAceptar, gbc_btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnCancelar.gridx = 0;
		gbc_btnCancelar.gridy = 0;
		panel.add(btnCancelar, gbc_btnCancelar);
		
	}

	public void eventos() {
		btnNuevoDeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtCrearDeporte.getText();
				if(nombre.equals("")) {
					JOptionPane.showMessageDialog(null, "El nombre del deporte no puede estar vacio","Error", JOptionPane.ERROR_MESSAGE);
				}else {
					GestionDeportes gd = new GestionDeportes();
					Deporte d = new Deporte();
					d.setNombre(nombre);
					if(gd.nuevoDeporte(d)) {
						JOptionPane.showMessageDialog(null, "Deporte creado","Exito", JOptionPane.INFORMATION_MESSAGE);
						rellenarDeporte();
					}else {
						JOptionPane.showMessageDialog(null, "Error al crear el deporte","Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btnNuevaOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevaEditarOlimpiada neo = new NuevaEditarOlimpiada(parent,true);
				neo.setVisible(true);
				rellenarOlimpiadas();
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		if(evento==null) {
			setTitle("Nuevo Evento");
		}else {
			setTitle("Editar Evento");
		}
	}

	public void rellenarDeporte() {
		GestionDeportes gd = new GestionDeportes();
		ArrayList<Deporte> deportes = new ArrayList<Deporte>();			
		deportes = gd.getDeportes();
		modeloDeporte.addAll(deportes);
		
		if(evento==null) {
			cbDeporte.setSelectedIndex(0);
		}else {
			cbDeporte.setSelectedItem(evento.getDeporte());
		}
	}

	public void rellenarOlimpiadas() {
		GestionOlimpiadas go = new GestionOlimpiadas();
		ArrayList<Olimpiada> olimpiadas = new ArrayList<Olimpiada>();			
		olimpiadas = go.getOlimpiadas();
		modeloOlimpiadas.addAll(olimpiadas);
		
		cbOlimpiadas.setSelectedItem(olimpiada);
	}

	
	public void guardar() {
		
		String nombre= txtNombre.getText();
		
		if(nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio","Error", JOptionPane.ERROR_MESSAGE);
		}else {
			
			Olimpiada o = (Olimpiada) cbOlimpiadas.getSelectedItem();
			Deporte d = (Deporte) cbDeporte.getSelectedItem();
			
			Evento e = new Evento();
			e.setDeporte(d);
			e.setOlimpiada(o);
			e.setNombre(nombre);
			
			GestionEventos ge = new GestionEventos();
			
			if(evento==null) {
				if(ge.nuevoEvento(e)) {
					JOptionPane.showMessageDialog(null, "Evento creado","Exito", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "Error al crear el evento","Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}else {
				e.setId(evento.getId());
				if(ge.editarEvento(e)) {
					JOptionPane.showMessageDialog(null, "Evento editado","Exito", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error al editar el evento","Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		
	}
}
