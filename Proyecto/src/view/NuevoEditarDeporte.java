package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionDeportes;
import dao.GestionDeportes;
import model.Deporte;
import model.Deportista;
import model.Deporte;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoEditarDeporte extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private Deporte deporte;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public NuevoEditarDeporte(java.awt.Frame parent, boolean modal, Deporte d) {
		super(parent,modal);
		deporte = d;
		
		dibujar();
		eventos();
	}
	
	public NuevoEditarDeporte(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		
		dibujar();
		eventos();
	}

	public void dibujar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuevoEditarDeporte.class.getResource("/imagenes/olimpiadasLogo.png")));
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
			JLabel lblNewLabel = new JLabel("Deporte");
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
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Guardar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		if(deporte != null) {
			tfNombre.setText(deporte.getNombre());
			setTitle("Editar Deporte");
		}else {
			setTitle("Nuevo Deporte");
		}
	}

	public void eventos() {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	
	public void guardar() {
		String nombre = tfNombre.getText();
		
		if(nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos","Error", JOptionPane.ERROR_MESSAGE);
		}else {
			Deporte d = new Deporte();
			d.setNombre(nombre);
			
			GestionDeportes ge = new GestionDeportes();
			if(deporte==null) {
				if(ge.nuevoDeporte(d)) {
					JOptionPane.showMessageDialog(null, "deporte creado","Exito", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error al crear el deporte","Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				d.setId(deporte.getId());
				if(ge.editarDeporte(d)) {
					JOptionPane.showMessageDialog(null, "deporte editado","Exito", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error al editar el deporte","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
}
