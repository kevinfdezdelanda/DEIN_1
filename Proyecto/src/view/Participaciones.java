package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionDeportistas;
import dao.GestionEquipos;
import dao.GestionEventos;
import dao.GestionParticipaciones;
import model.Deportista;
import model.Equipo;
import model.Evento;
import model.Participacion;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Participaciones extends javax.swing.JDialog {

	private JPanel contentPane;
	private JPanel panelForm;
	private Evento evento;
	private JList list;
	private DefaultListModel modelParticipaciones;
	private DefaultComboBoxModel modelDeportistas;
	private DefaultComboBoxModel modelEquipos;
	private JComboBox cbDeportista;
	private JLabel lblEquipo;
	private JComboBox cbEquipos;
	private boolean editando;
	private JLabel lblNomevento;
	private JSpinner jsEdad;
	private JComboBox cbMedallas;
	private JButton btnEditarDep;
	private JButton btnNuevoDep;
	private JButton btnBorrarDep;


	/**
	 * Create the frame.
	 */
	public Participaciones(java.awt.Frame parent, boolean modal, Evento e) {
		super(parent,modal);
		evento = e;
		editando = false;
		
		setBounds(100, 100, 950, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNomevento = new JLabel("nomEvento");
		lblNomevento.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_lblNomevento = new GridBagConstraints();
		gbc_lblNomevento.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomevento.gridx = 0;
		gbc_lblNomevento.gridy = 0;
		contentPane.add(lblNomevento, gbc_lblNomevento);
		
		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		contentPane.add(list, gbc_list);
		
		panelForm = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panelForm, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panelForm.setLayout(gbl_panel);
		
		JLabel lblNombre = new JLabel("Edad:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panelForm.add(lblNombre, gbc_lblNombre);
		
		jsEdad = new JSpinner();
		jsEdad.setModel(new SpinnerNumberModel(18, 13, 100, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.anchor = GridBagConstraints.EAST;
		gbc_spinner.insets = new Insets(0, 0, 5, 0);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 0;
		panelForm.add(jsEdad, gbc_spinner);
		
		JLabel lblDeportista = new JLabel("Deportista:");
		GridBagConstraints gbc_lblDeportista = new GridBagConstraints();
		gbc_lblDeportista.anchor = GridBagConstraints.EAST;
		gbc_lblDeportista.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeportista.gridx = 0;
		gbc_lblDeportista.gridy = 1;
		panelForm.add(lblDeportista, gbc_lblDeportista);
		
		cbDeportista = new JComboBox();
		GridBagConstraints gbc_cbDeportista = new GridBagConstraints();
		gbc_cbDeportista.insets = new Insets(0, 0, 5, 0);
		gbc_cbDeportista.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDeportista.gridx = 1;
		gbc_cbDeportista.gridy = 1;
		panelForm.add(cbDeportista, gbc_cbDeportista);
		modelDeportistas = new DefaultComboBoxModel<Deportista>();
		cbDeportista.setModel(modelDeportistas);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		panelForm.add(panel_1, gbc_panel_1);
		
		btnNuevoDep = new JButton("Nuevo");
		btnNuevoDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoEditarDeportista ned = new NuevoEditarDeportista(parent, true);
				ned.setVisible(true);
				rellenarDeportistas();
			}
		});
		panel_1.add(btnNuevoDep);
		
		btnBorrarDep = new JButton("Borrar");
		btnBorrarDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deportista d = (Deportista) cbDeportista.getSelectedItem();
				GestionDeportistas gd = new GestionDeportistas();
				
				if(gd.borrarDeportista(d)) {
					JOptionPane.showMessageDialog(null, "deportista borrado","Exito", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error al borrar el deportista (Existen dependencias)","Error", JOptionPane.ERROR_MESSAGE);
				}
				
				rellenarDeportistas();
			}
		});
		panel_1.add(btnBorrarDep);
		
		btnEditarDep = new JButton("Editar");
		btnEditarDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deportista d = (Deportista) cbDeportista.getSelectedItem();
				NuevoEditarDeportista ned = new NuevoEditarDeportista(parent, true, d);
				ned.setVisible(true);
				rellenarDeportistas();
			}
		});
		panel_1.add(btnEditarDep);
		
		lblEquipo = new JLabel("Equipo:");
		GridBagConstraints gbc_lblEquipo = new GridBagConstraints();
		gbc_lblEquipo.anchor = GridBagConstraints.EAST;
		gbc_lblEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipo.gridx = 0;
		gbc_lblEquipo.gridy = 3;
		panelForm.add(lblEquipo, gbc_lblEquipo);
		
		cbEquipos = new JComboBox();
		GridBagConstraints gbc_cbEquipos = new GridBagConstraints();
		gbc_cbEquipos.insets = new Insets(0, 0, 5, 0);
		gbc_cbEquipos.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEquipos.gridx = 1;
		gbc_cbEquipos.gridy = 3;
		panelForm.add(cbEquipos, gbc_cbEquipos);
		modelEquipos = new DefaultComboBoxModel<Equipo>();
		cbEquipos.setModel(modelEquipos);
		
		JPanel panel_1_1 = new JPanel();
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_1.gridx = 1;
		gbc_panel_1_1.gridy = 4;
		panelForm.add(panel_1_1, gbc_panel_1_1);
		
		JButton btnNuevo_1_1 = new JButton("Nuevo");
		panel_1_1.add(btnNuevo_1_1);
		
		JButton btnBorrar_1_1 = new JButton("Borrar");
		panel_1_1.add(btnBorrar_1_1);
		
		JButton btnEditar_1_1 = new JButton("Editar");
		panel_1_1.add(btnEditar_1_1);
		
		JLabel lblMedalla = new JLabel("Medalla:");
		GridBagConstraints gbc_lblMedalla = new GridBagConstraints();
		gbc_lblMedalla.anchor = GridBagConstraints.EAST;
		gbc_lblMedalla.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedalla.gridx = 0;
		gbc_lblMedalla.gridy = 5;
		panelForm.add(lblMedalla, gbc_lblMedalla);
		
		cbMedallas = new JComboBox();
		cbMedallas.setModel(new DefaultComboBoxModel(new String[] {"Sin Medalla", "Bronce", "Plata", "Oro"}));
		cbMedallas.setSelectedIndex(0);
		GridBagConstraints gbc_cbMedallas = new GridBagConstraints();
		gbc_cbMedallas.insets = new Insets(0, 0, 5, 0);
		gbc_cbMedallas.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbMedallas.gridx = 1;
		gbc_cbMedallas.gridy = 5;
		panelForm.add(cbMedallas, gbc_cbMedallas);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 7;
		panelForm.add(panel_2, gbc_panel_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desabilitarHabilitarElementos(false);
			}
		});
		panel_2.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		panel_2.add(btnGuardar);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		contentPane.add(panel_3, gbc_panel_3);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desabilitarHabilitarElementos(true);
			}
		});
		panel_3.add(btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desabilitarHabilitarElementos(true);
				Participacion p = (Participacion) list.getSelectedValue();
				jsEdad.setValue(p.getEdad());
				cbDeportista.setSelectedItem(p.getDeportista());
				cbEquipos.setSelectedItem(p.getEquipo());
				
				if(p.getMedalla().equals(null)) {
					cbMedallas.setSelectedIndex(0);;
				}else {
					cbMedallas.setSelectedItem(p.getMedalla());
				}
				
				cbDeportista.setEnabled(false);
				btnBorrarDep.setEnabled(false);
				btnNuevoDep.setEnabled(false);
				
				editando = true;
			}
		});
		panel_3.add(btnEditar);
		
		JButton btnBorrar = new JButton("Borrar");
		panel_3.add(btnBorrar);
		
		lblNomevento.setText(e.getNombre());
		rellenarParticipaciones();
		rellenarDeportistas();
		rellenarEquipos();
		desabilitarHabilitarElementos(false);
	}
	
	public void desabilitarHabilitarElementos(boolean b) {
		Component[] componentes = panelForm.getComponents();
		
		for (int i = 0; i < componentes.length; i++) {
			
			if(componentes[i] instanceof JPanel) {
				Component[] componentes2 = ((JPanel) componentes[i]).getComponents();
				
				for (int j = 0; j < componentes2.length; j++) {
					componentes2[j].setEnabled(b);
				}
			}
			
			componentes[i].setEnabled(b);
		}
		
		if(!b) {
			jsEdad.setValue(18);
			cbDeportista.setSelectedIndex(0);
			cbEquipos.setSelectedIndex(0);
			cbMedallas.setSelectedIndex(0);
		}
	}

	
	public void rellenarParticipaciones() {
		GestionParticipaciones gp = new GestionParticipaciones();
		ArrayList<Participacion> participaciones = new ArrayList<Participacion>();
		participaciones = gp.getParticipaciones(evento);
		
		modelParticipaciones = new DefaultListModel();
		
		list.setModel(modelParticipaciones);
		if(participaciones.size()==0) {
			ArrayList<String> error = new ArrayList<String>();
			error.add("Sin participaciones");
			modelParticipaciones.addAll(error);
		}else {
			modelParticipaciones.addAll(participaciones);
		}
	}
	
	public void rellenarDeportistas() {
		GestionDeportistas gd = new GestionDeportistas();
		ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
		deportistas = gd.getDeportistas();
		
		modelDeportistas = new DefaultComboBoxModel<Deportista>();
		
		if(deportistas.size()==0) {
			ArrayList<String> error = new ArrayList<String>();
			error.add("Sin deportistas");
			modelDeportistas.addAll(error);
		}else {
			modelDeportistas.addAll(deportistas);
		}
		
		cbDeportista.setModel(modelDeportistas);
		cbDeportista.setSelectedIndex(0);
	}
	
	public void rellenarEquipos() {
		GestionEquipos ge = new GestionEquipos();
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		equipos = ge.getEquipos();
		
		modelEquipos = new DefaultComboBoxModel<Equipo>();
		
		if(equipos.size()==0) {
			ArrayList<String> error = new ArrayList<String>();
			error.add("Sin equipos");
			modelEquipos.addAll(error);
		}else {
			modelEquipos.addAll(equipos);
		}
		
		cbEquipos.setModel(modelEquipos);
		cbEquipos.setSelectedIndex(0);
	}
	
	public void guardar(){
		Participacion nPart = new Participacion();
		
		try {
			nPart.setEdad(Integer.parseInt(jsEdad.getValue().toString()));
			nPart.setDeportista((Deportista)cbDeportista.getSelectedItem());
			nPart.setEquipo((Equipo)cbEquipos.getSelectedItem());
			
			String medalla = cbMedallas.getSelectedItem().toString();
			if(medalla.equals("Sin Medalla")) {
				medalla = "null";
			}
			
			nPart.setMedalla(medalla);
			nPart.setEvento(evento);
			
			GestionParticipaciones gp = new GestionParticipaciones();
			if(editando) {
				if(gp.editarParticipacion(nPart)) {
					JOptionPane.showMessageDialog(null, "participacion editada","Exito", JOptionPane.INFORMATION_MESSAGE);
					rellenarParticipaciones();
					desabilitarHabilitarElementos(false);
				}else {
					JOptionPane.showMessageDialog(null, "Error al editar la participacion","Error", JOptionPane.ERROR_MESSAGE);
				}
				editando = false;
			}else {
				if(gp.nuevaParticipacion(nPart)) {
					JOptionPane.showMessageDialog(null, "participacion creada","Exito", JOptionPane.INFORMATION_MESSAGE);
					rellenarParticipaciones();
					desabilitarHabilitarElementos(false);
				}else {
					JOptionPane.showMessageDialog(null, "Error al crear la participacion (No puedes repetir deportistas)","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Introduce una edad valida","Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
}
