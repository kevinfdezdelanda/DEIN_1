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
import java.awt.Toolkit;

public class Deportistas extends JDialog {
	private DefaultListModel modelDeportistas;
	private JList listDeportistas;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JButton cancelButton;


	/**
	 * Create the dialog.
	 */
	public Deportistas(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		
		dibujar();
		eventos(parent);
	}

	public void dibujar() {
		setTitle("Deportistas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Deportistas.class.getResource("/imagenes/olimpiadasLogo.png")));
		
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
				btnNuevo = new JButton("Nuevo");
				btnNuevo.setActionCommand("OK");
				buttonPane.add(btnNuevo);
				getRootPane().setDefaultButton(btnNuevo);
			}
			{
				btnEditar = new JButton("Editar");
				buttonPane.add(btnEditar);
			}
			{
				btnBorrar = new JButton("Borrar");
				buttonPane.add(btnBorrar);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		rellenarDeportistas();
	}

	public void eventos(java.awt.Frame parent) {
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevoEditarDeportista ned = new NuevoEditarDeportista(parent, true);
				ned.setVisible(true);
				rellenarDeportistas();
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
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
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deportista d = (Deportista) listDeportistas.getSelectedValue();
				GestionDeportistas gd = new GestionDeportistas();
				
				if(d==null) {
					JOptionPane.showMessageDialog(null, "Debes seleccionar un deportista","Error", JOptionPane.ERROR_MESSAGE);
				}else {
					int dialogResult = JOptionPane.showConfirmDialog (null, "¿Estas seguro de realizar esta accion?","Seguro?",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						if(gd.borrarDeportista(d)) {
							JOptionPane.showMessageDialog(null, "Deportista borrado","Exito", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Error al borrar el deportista (Existen dependencias)","Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
				rellenarDeportistas();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
