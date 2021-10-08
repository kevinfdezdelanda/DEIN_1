package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionOlimpiadas;
import model.Olimpiada;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NuevaEditarOlimpiada extends javax.swing.JDialog {

	private JPanel contentPane;
	private JTextField txtAnio;
	private JLabel lblTemporada;
	private JLabel lblCiudad;
	private JTextField txtCiudad;
	private JPanel panel;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JComboBox cbTemp;
	private Olimpiada olimpiada;
	
	/**
	 * Create the frame.
	 */
	public NuevaEditarOlimpiada(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		
		dibujar();
	}
	
	public NuevaEditarOlimpiada(java.awt.Frame parent, boolean modal, Olimpiada o) {
		super(parent,modal);
		this.olimpiada = o;
		dibujar();
	}

	public void dibujar() {
		setBounds(100, 100, 248, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAo = new JLabel("Año:");
		GridBagConstraints gbc_lblAo = new GridBagConstraints();
		gbc_lblAo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAo.anchor = GridBagConstraints.EAST;
		gbc_lblAo.gridx = 0;
		gbc_lblAo.gridy = 0;
		contentPane.add(lblAo, gbc_lblAo);
		
		txtAnio = new JTextField();
		GridBagConstraints gbc_txtAnio = new GridBagConstraints();
		gbc_txtAnio.insets = new Insets(0, 0, 5, 0);
		gbc_txtAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnio.gridx = 1;
		gbc_txtAnio.gridy = 0;
		contentPane.add(txtAnio, gbc_txtAnio);
		txtAnio.setColumns(10);
		
		lblTemporada = new JLabel("Temporada:");
		GridBagConstraints gbc_lblTemporada = new GridBagConstraints();
		gbc_lblTemporada.anchor = GridBagConstraints.EAST;
		gbc_lblTemporada.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemporada.gridx = 0;
		gbc_lblTemporada.gridy = 1;
		contentPane.add(lblTemporada, gbc_lblTemporada);
		
		cbTemp = new JComboBox();
		cbTemp.setModel(new DefaultComboBoxModel(new String[] {"Summer", "Winter"}));
		GridBagConstraints gbc_cbTemp = new GridBagConstraints();
		gbc_cbTemp.insets = new Insets(0, 0, 5, 0);
		gbc_cbTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTemp.gridx = 1;
		gbc_cbTemp.gridy = 1;
		contentPane.add(cbTemp, gbc_cbTemp);
		
		lblCiudad = new JLabel("Ciudad:");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.EAST;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 0;
		gbc_lblCiudad.gridy = 2;
		contentPane.add(lblCiudad, gbc_lblCiudad);
		
		txtCiudad = new JTextField();
		GridBagConstraints gbc_txtCiudad = new GridBagConstraints();
		gbc_txtCiudad.insets = new Insets(0, 0, 5, 0);
		gbc_txtCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCiudad.gridx = 1;
		gbc_txtCiudad.gridy = 2;
		contentPane.add(txtCiudad, gbc_txtCiudad);
		txtCiudad.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		panel.add(btnAceptar);
		
		if(olimpiada!=null) {
			rellenarDatos();
		}
	}
	
	public void guardar() {
		int anio = 0;
		String error = "";
		try {
			anio = Integer.parseInt(txtAnio.getText());
		}catch (NumberFormatException e) {
			error += "El año debe ser un numero \n";
		}
		
		if(anio>2999 || anio<1000) {
			error += "El año debe ser valido (desde 1000, hasta 2999)\n";
		}
		
		String temp = (String) cbTemp.getSelectedItem();
		String ciudad = txtCiudad.getText();
		
		if(ciudad.equals("")) {
			error += "Debes rellenar todos los campos";
		}
		
		if(!error.equals("")) {
			JOptionPane.showMessageDialog(null, error,"Error", JOptionPane.ERROR_MESSAGE);
		}else {
			
			String nombre = anio+" "+temp;
			
			Olimpiada o = new Olimpiada();
			o.setAnio(anio);
			o.setCiudad(ciudad);
			o.setNombre(nombre);
			o.setTemporada(temp);
			
			GestionOlimpiadas go = new GestionOlimpiadas();
			
			if(olimpiada==null) {
				if(go.nuevaOlimpiada(o)) {
					JOptionPane.showMessageDialog(null, "Olimpiada creada","Exito", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error al crear la olimpiada","Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				o.setId(olimpiada.getId());
				if(go.editarOlimpiada(o)) {
					JOptionPane.showMessageDialog(null, "Olimpiada editada","Exito", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error al editar la olimpiada","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		
	}
	
	public void rellenarDatos() {
		txtAnio.setText(olimpiada.getAnio()+"");
		txtCiudad.setText(olimpiada.getCiudad());
		cbTemp.setSelectedItem(olimpiada.getTemporada());
	}

}
