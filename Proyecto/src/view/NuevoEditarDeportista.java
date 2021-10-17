package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionDeportistas;
import model.Deportista;
import model.Evento;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.BreakIterator;
import java.awt.event.ActionEvent;

public class NuevoEditarDeportista extends JDialog {

	private JPanel contentPane;
	private JTextField jTnombre;
	private Deportista deportista;
	private JComboBox cbSexo;
	private JSpinner spPeso;
	private JSpinner spAltura;
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public NuevoEditarDeportista(java.awt.Frame parent, boolean modal, Deportista d) {
		super(parent,modal);
		deportista = d;
		
		dibujar();
	}
	
	public NuevoEditarDeportista(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		
		dibujar();
	}

	public void dibujar() {
		setBounds(100, 100, 236, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Deportista");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jTnombre = new JTextField();
		GridBagConstraints gbc_jTnombre = new GridBagConstraints();
		gbc_jTnombre.insets = new Insets(0, 0, 5, 0);
		gbc_jTnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTnombre.gridx = 1;
		gbc_jTnombre.gridy = 1;
		contentPane.add(jTnombre, gbc_jTnombre);
		jTnombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		GridBagConstraints gbc_cbSexo = new GridBagConstraints();
		gbc_cbSexo.insets = new Insets(0, 0, 5, 0);
		gbc_cbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSexo.gridx = 1;
		gbc_cbSexo.gridy = 2;
		contentPane.add(cbSexo, gbc_cbSexo);
		
		JLabel lblNewLabel_3 = new JLabel("Peso:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		spPeso = new JSpinner();
		spPeso.setModel(new SpinnerNumberModel(50, 30, 150, 1));
		GridBagConstraints gbc_spPeso = new GridBagConstraints();
		gbc_spPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_spPeso.insets = new Insets(0, 0, 5, 0);
		gbc_spPeso.gridx = 1;
		gbc_spPeso.gridy = 3;
		contentPane.add(spPeso, gbc_spPeso);
		
		JLabel lblNewLabel_4 = new JLabel("Altura:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		spAltura = new JSpinner();
		spAltura.setModel(new SpinnerNumberModel(150, 100, 250, 1));
		GridBagConstraints gbc_spAltura = new GridBagConstraints();
		gbc_spAltura.insets = new Insets(0, 0, 5, 0);
		gbc_spAltura.fill = GridBagConstraints.HORIZONTAL;
		gbc_spAltura.gridx = 1;
		gbc_spAltura.gridy = 4;
		contentPane.add(spAltura, gbc_spAltura);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		contentPane.add(panel, gbc_panel);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnCancelar);
		
		if(deportista != null) {
			jTnombre.setText(deportista.getNombre());
			cbSexo.setSelectedItem(deportista.getSexo());;
			spAltura.setValue(deportista.getAltura());
			spPeso.setValue(deportista.getPeso());
		}
	}

	public void guardar() {
		Deportista d = new Deportista();
		
		String nombre = jTnombre.getText();
		if (nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Debes introducir un nombre","Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String sexo = cbSexo.getSelectedItem().toString();
		int peso = Integer.parseInt(spPeso.getValue().toString());
		int altura = Integer.parseInt(spAltura.getValue().toString());
		
		d.setAltura(altura);
		d.setNombre(nombre);
		d.setPeso(peso);
		d.setSexo(sexo);
		
		GestionDeportistas gd = new GestionDeportistas();
		
		if(deportista==null) {
			if(gd.nuevoDeportista(d)) {
				JOptionPane.showMessageDialog(null, "deportista creado","Exito", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Error al crear el deportista","Error", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			d.setId(deportista.getId());
			if(gd.editarDeportista(d)) {
				JOptionPane.showMessageDialog(null, "deportista editado","Exito", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Error al editar el deportista","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
