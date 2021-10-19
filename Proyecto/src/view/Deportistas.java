package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionDeportes;
import dao.GestionDeportistas;
import dao.GestionEquipos;
import model.Deporte;
import model.Deportista;
import model.Deporte;
import model.Equipo;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deportistas extends JDialog {
	private DefaultListModel modelDeportistas;
	private JList listDeportistas;


	/**
	 * Create the dialog.
	 */
	public Deportistas(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				listDeportistas = new JList();
				scrollPane.setViewportView(listDeportistas);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNuevo = new JButton("Nuevo");
				btnNuevo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						NuevoEditarDeportista ned = new NuevoEditarDeportista(parent, true);
						ned.setVisible(true);
						rellenarDeportistas();
					}
				});
				btnNuevo.setActionCommand("OK");
				buttonPane.add(btnNuevo);
				getRootPane().setDefaultButton(btnNuevo);
			}
			{
				JButton btnNewButton = new JButton("Editar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Deportista d = (Deportista) listDeportistas.getSelectedValue();
						
						if(d==null) {
							JOptionPane.showMessageDialog(null, "Debes seleccionar un deportista","Error", JOptionPane.ERROR_MESSAGE);
						}else {
							NuevoEditarDeportista ned = new NuevoEditarDeportista(parent, true, d);
							ned.setVisible(true);
							rellenarDeportistas();
						}
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton btnBorrar = new JButton("Borrar");
				btnBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Deportista d = (Deportista) listDeportistas.getSelectedValue();
						GestionDeportistas gd = new GestionDeportistas();
						
						if(d==null) {
							JOptionPane.showMessageDialog(null, "Debes seleccionar un deportista","Error", JOptionPane.ERROR_MESSAGE);
						}else {
							if(gd.borrarDeportista(d)) {
								JOptionPane.showMessageDialog(null, "Deportista borrado","Exito", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Error al borrar el deportista (Existen dependencias)","Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						
						rellenarDeportistas();
					}
				});
				buttonPane.add(btnBorrar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		rellenarDeportistas();
	}
	
	public void rellenarDeportistas() {
		GestionDeportistas gd = new GestionDeportistas();
		ArrayList<Deportista> deportistas = gd.getDeportistas();
		
		modelDeportistas = new DefaultListModel();
		
		listDeportistas.setModel(modelDeportistas);
		if(deportistas.size()==0) {
			ArrayList<String> error = new ArrayList<String>();
			error.add("Sin Deportistas");
			modelDeportistas.addAll(error);
		}else {
			modelDeportistas.addAll(deportistas);
		}
	}
}
