package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionEquipos;
import model.Deportista;
import model.Equipo;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoEditarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfIniciales;
	private Equipo equipo;

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public NuevoEditarEquipo(java.awt.Frame parent, boolean modal, Equipo e) {
		super(parent,modal);
		equipo = e;
		
		dibujar();
	}
	
	public NuevoEditarEquipo(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		
		dibujar();
	}

	public void dibujar() {
		setBounds(100, 100, 201, 241);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Equipo");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			tfNombre = new JTextField();
			GridBagConstraints gbc_tfNombre = new GridBagConstraints();
			gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
			gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfNombre.gridx = 1;
			gbc_tfNombre.gridy = 1;
			contentPanel.add(tfNombre, gbc_tfNombre);
			tfNombre.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Iniciales:");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			tfIniciales = new JTextField();
			GridBagConstraints gbc_tfIniciales = new GridBagConstraints();
			gbc_tfIniciales.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfIniciales.gridx = 1;
			gbc_tfIniciales.gridy = 2;
			contentPanel.add(tfIniciales, gbc_tfIniciales);
			tfIniciales.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guardar();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	
	public void guardar() {
		String nombre = tfNombre.getText();
		String inicales = tfIniciales.getText();
		
		if(nombre.equals("") || inicales.equals("")) {
			JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos","Error", JOptionPane.ERROR_MESSAGE);
		}else {
			Equipo e = new Equipo();
			e.setIniciales(inicales);
			e.setNombre(nombre);
			
			GestionEquipos ge = new GestionEquipos();
			if(equipo==null) {
				if(ge.nuevoEquipo(e)) {
					JOptionPane.showMessageDialog(null, "Equipo creado","Exito", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error al crear el equipo","Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				e.setId(equipo.getId());
				if(ge.editarEquipo(e)) {
					JOptionPane.showMessageDialog(null, "Equipo editado","Exito", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error al editar el Equipo","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
}
