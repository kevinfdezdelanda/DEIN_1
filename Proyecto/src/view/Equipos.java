package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionEquipos;
import dao.GestionParticipaciones;
import model.Equipo;
import model.Participacion;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Equipos extends JDialog {
	private DefaultListModel modelEquipos;
	private JList listEquipos;

	/**
	 * Create the dialog.
	 */
	public Equipos(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		
		dibujar(parent);
		
		rellenarEquipos();
	}

	public void dibujar(java.awt.Frame parent) {
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{241, 35, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JPanel buttonPane = new JPanel();
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.insets = new Insets(0, 0, 5, 0);
			gbc_buttonPane.fill = GridBagConstraints.BOTH;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 1;
			getContentPane().add(buttonPane, gbc_buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			{
				JButton btnNuevo = new JButton("Nuevo");
				btnNuevo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						NuevoEditarEquipo nee = new NuevoEditarEquipo(parent, true);
						nee.setVisible(true);
						rellenarEquipos();
					}
				});
				btnNuevo.setActionCommand("OK");
				buttonPane.add(btnNuevo);
			}
			{
				JButton btnNewButton = new JButton("Editar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Equipo e = (Equipo) listEquipos.getSelectedValue();
						
						if(e==null) {
							JOptionPane.showMessageDialog(null, "Debes seleccionar un equipo","Error", JOptionPane.ERROR_MESSAGE);
						}else {
							NuevoEditarEquipo nee = new NuevoEditarEquipo(parent, true, e);
							nee.setVisible(true);
							rellenarEquipos();
						}
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton btnBorrar = new JButton("Borrar");
				btnBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Equipo e = (Equipo) listEquipos.getSelectedValue();
						GestionEquipos ge = new GestionEquipos();
						
						if(e==null) {
							JOptionPane.showMessageDialog(null, "Debes seleccionar un equipo","Error", JOptionPane.ERROR_MESSAGE);
						}else {
							if(ge.borrarEquipo(e)) {
								JOptionPane.showMessageDialog(null, "Equipo borrado","Exito", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Error al borrar el equipo (Existen dependencias)","Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						
						rellenarEquipos();
					}
				});
				buttonPane.add(btnBorrar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			GridBagConstraints gbc_contentPanel = new GridBagConstraints();
			gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
			gbc_contentPanel.fill = GridBagConstraints.BOTH;
			gbc_contentPanel.gridx = 0;
			gbc_contentPanel.gridy = 0;
			getContentPane().add(contentPanel, gbc_contentPanel);
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
					listEquipos = new JList();
					scrollPane.setViewportView(listEquipos);
				}
			}
		}
	}
	
	public void rellenarEquipos() {
		GestionEquipos ge = new GestionEquipos();
		ArrayList<Equipo> equipos = ge.getEquipos();
		
		modelEquipos = new DefaultListModel();
		listEquipos.setModel(modelEquipos);
		if(equipos.size()==0) {
			ArrayList<String> error = new ArrayList<String>();
			error.add("Sin Equipos");
			modelEquipos.addAll(error);
		}else {
			modelEquipos.addAll(equipos);
		}
	}
}
