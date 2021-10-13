package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionEventos;
import dao.GestionParticipaciones;
import model.Evento;
import model.Participacion;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

public class Participaciones extends JFrame {

	private JPanel contentPane;
	private JTextField txtTxtnombre;
	private JPanel panelForm;
	private Evento evento;
	private JList list;
	private DefaultListModel modelParticipaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Participaciones frame = new Participaciones(null);
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
	public Participaciones(Evento e) {
		evento = e; 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNomevento = new JLabel("nomEvento");
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
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panelForm.add(lblNombre, gbc_lblNombre);
		
		txtTxtnombre = new JTextField();
		GridBagConstraints gbc_txtTxtnombre = new GridBagConstraints();
		gbc_txtTxtnombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtTxtnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTxtnombre.gridx = 1;
		gbc_txtTxtnombre.gridy = 0;
		panelForm.add(txtTxtnombre, gbc_txtTxtnombre);
		txtTxtnombre.setColumns(10);
		
		JLabel lblDeportista = new JLabel("Deportista:");
		GridBagConstraints gbc_lblDeportista = new GridBagConstraints();
		gbc_lblDeportista.anchor = GridBagConstraints.EAST;
		gbc_lblDeportista.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeportista.gridx = 0;
		gbc_lblDeportista.gridy = 1;
		panelForm.add(lblDeportista, gbc_lblDeportista);
		
		JComboBox cbDeportista = new JComboBox();
		GridBagConstraints gbc_cbDeportista = new GridBagConstraints();
		gbc_cbDeportista.insets = new Insets(0, 0, 5, 0);
		gbc_cbDeportista.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDeportista.gridx = 1;
		gbc_cbDeportista.gridy = 1;
		panelForm.add(cbDeportista, gbc_cbDeportista);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		panelForm.add(panel_1, gbc_panel_1);
		
		JButton btnNuevo_1 = new JButton("Nuevo");
		panel_1.add(btnNuevo_1);
		
		JButton btnBorrar_1 = new JButton("Borrar");
		panel_1.add(btnBorrar_1);
		
		JButton btnEditar_1 = new JButton("Editar");
		panel_1.add(btnEditar_1);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		GridBagConstraints gbc_lblEquipo = new GridBagConstraints();
		gbc_lblEquipo.anchor = GridBagConstraints.EAST;
		gbc_lblEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipo.gridx = 0;
		gbc_lblEquipo.gridy = 3;
		panelForm.add(lblEquipo, gbc_lblEquipo);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panelForm.add(comboBox, gbc_comboBox);
		
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
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 5;
		panelForm.add(comboBox_1, gbc_comboBox_1);
		
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
		panel_2.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		panel_2.add(btnGuardar);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		contentPane.add(panel_3, gbc_panel_3);
		
		JButton btnNuevo = new JButton("Nuevo");
		panel_3.add(btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		panel_3.add(btnEditar);
		
		JButton btnBorrar = new JButton("Borrar");
		panel_3.add(btnBorrar);
		
		desabilitarHabilitarElementos(false);
		rellenarParticipaciones();
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
}
