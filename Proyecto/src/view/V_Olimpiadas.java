package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import dao.GestionDeportistas;
import dao.GestionEventos;
import dao.GestionOlimpiadas;
import model.Deportista;
import model.Evento;
import model.Olimpiada;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class V_Olimpiadas extends JFrame {

	private JPanel contentPane;
	private JList listOlimpiadas;
	private DefaultListModel modelOlimpiadas2;
	private DefaultListModel modelEventos2;
	private JList listaEvento;
	private JMenuItem mntmEquipos;
	private JMenuItem mntmDeportistas;
	private JMenuItem mntmDeporte;
	private JButton btnNuevaOlimpiada;
	private JButton btnEditarOlimpiada;
	private JButton btnBorrarOlimpiada;
	private JButton btnNuevoEvento;
	private JButton btnEditarEvento;
	private JButton btnBorrarEvento;
	private JButton btnParticipaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_Olimpiadas frame = new V_Olimpiadas();
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
	public V_Olimpiadas() {
		
		dibujar();
		eventos();
		
		rellenarOlimpiadas();
	}

	public void dibujar() {
		setTitle("Olimpiadas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(V_Olimpiadas.class.getResource("/imagenes/olimpiadasLogo.png")));
		
		modelOlimpiadas2 = new DefaultListModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 334);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmEquipos = new JMenuItem("Equipos");
		mntmEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmEquipos);
		
		mntmDeportistas = new JMenuItem("Deportistas");
		mntmDeportistas.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmDeportistas);
		
		mntmDeporte = new JMenuItem("Deportes");
		mntmDeporte.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmDeporte);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(V_Olimpiadas.class.getResource("/imagenes/olimpiadas_img.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblOlimpiadas = new JLabel("Olimpiadas:");
		GridBagConstraints gbc_lblOlimpiadas = new GridBagConstraints();
		gbc_lblOlimpiadas.anchor = GridBagConstraints.WEST;
		gbc_lblOlimpiadas.insets = new Insets(0, 0, 5, 5);
		gbc_lblOlimpiadas.gridx = 0;
		gbc_lblOlimpiadas.gridy = 0;
		panel.add(lblOlimpiadas, gbc_lblOlimpiadas);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		listOlimpiadas = new JList();
		scrollPane.setViewportView(listOlimpiadas);
		listOlimpiadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOlimpiadas.setModel(modelOlimpiadas2);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{79, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		btnNuevaOlimpiada = new JButton("Nueva");
		GridBagConstraints gbc_btnNueva = new GridBagConstraints();
		gbc_btnNueva.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNueva.insets = new Insets(0, 0, 5, 0);
		gbc_btnNueva.gridx = 0;
		gbc_btnNueva.gridy = 0;
		panel_2.add(btnNuevaOlimpiada, gbc_btnNueva);
		
		btnEditarOlimpiada = new JButton("Editar");
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.fill = GridBagConstraints.BOTH;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditar.gridx = 0;
		gbc_btnEditar.gridy = 1;
		panel_2.add(btnEditarOlimpiada, gbc_btnEditar);
		
		btnBorrarOlimpiada = new JButton("Borrar");
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.fill = GridBagConstraints.BOTH;
		gbc_btnBorrar.gridx = 0;
		gbc_btnBorrar.gridy = 2;
		panel_2.add(btnBorrarOlimpiada, gbc_btnBorrar);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblEventos = new JLabel("Eventos:");
		GridBagConstraints gbc_lblEventos = new GridBagConstraints();
		gbc_lblEventos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEventos.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventos.gridx = 0;
		gbc_lblEventos.gridy = 0;
		panel_1.add(lblEventos, gbc_lblEventos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		listaEvento = new JList();
		scrollPane_1.setViewportView(listaEvento);
		listaEvento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaEvento.setSelectedIndex(0);
		
		JPanel panel_2_1 = new JPanel();
		GridBagConstraints gbc_panel_2_1 = new GridBagConstraints();
		gbc_panel_2_1.fill = GridBagConstraints.BOTH;
		gbc_panel_2_1.gridx = 1;
		gbc_panel_2_1.gridy = 1;
		panel_1.add(panel_2_1, gbc_panel_2_1);
		GridBagLayout gbl_panel_2_1 = new GridBagLayout();
		gbl_panel_2_1.columnWidths = new int[]{79, 0};
		gbl_panel_2_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2_1.setLayout(gbl_panel_2_1);
		
		btnNuevoEvento = new JButton("Nuevo");
		GridBagConstraints gbc_btnNueva_1 = new GridBagConstraints();
		gbc_btnNueva_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNueva_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNueva_1.gridx = 0;
		gbc_btnNueva_1.gridy = 0;
		panel_2_1.add(btnNuevoEvento, gbc_btnNueva_1);
		
		btnEditarEvento = new JButton("Editar");
		GridBagConstraints gbc_btnEditar_1 = new GridBagConstraints();
		gbc_btnEditar_1.fill = GridBagConstraints.BOTH;
		gbc_btnEditar_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditar_1.gridx = 0;
		gbc_btnEditar_1.gridy = 1;
		panel_2_1.add(btnEditarEvento, gbc_btnEditar_1);
		
		btnBorrarEvento = new JButton("Borrar");
		GridBagConstraints gbc_btnBorrar_1 = new GridBagConstraints();
		gbc_btnBorrar_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrar_1.fill = GridBagConstraints.BOTH;
		gbc_btnBorrar_1.gridx = 0;
		gbc_btnBorrar_1.gridy = 2;
		panel_2_1.add(btnBorrarEvento, gbc_btnBorrar_1);
		
		btnParticipaciones = new JButton("Participaciones");
		GridBagConstraints gbc_btnDetalles = new GridBagConstraints();
		gbc_btnDetalles.gridx = 0;
		gbc_btnDetalles.gridy = 3;
		panel_2_1.add(btnParticipaciones, gbc_btnDetalles);
	}

	public void eventos() {
		mntmEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Equipos e = new Equipos(V_Olimpiadas.this,true);
				e.setVisible(true);
			}
		});
		
		mntmDeportistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deportistas d = new Deportistas(V_Olimpiadas.this,true);
				d.setVisible(true);
			}
		});
		
		mntmDeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deportes d = new Deportes(V_Olimpiadas.this,true);
				d.setVisible(true);
			}
		});
		
		listOlimpiadas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Olimpiada o = (Olimpiada) listOlimpiadas.getSelectedValue();
				if(o!=null) {
					rellenarEventos(o);
				}
				
			}
		});
		
		btnNuevaOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevaEditarOlimpiada neo = new NuevaEditarOlimpiada(V_Olimpiadas.this,true);
				neo.setVisible(true);
				rellenarOlimpiadas();

			}
		});
		
		btnEditarOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Olimpiada o = (Olimpiada) listOlimpiadas.getSelectedValue();
				NuevaEditarOlimpiada neo = new NuevaEditarOlimpiada(V_Olimpiadas.this,true,o);
				neo.setVisible(true);
				rellenarOlimpiadas();
			}
		});
		
		btnBorrarOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Olimpiada o = (Olimpiada) listOlimpiadas.getSelectedValue();
				int reply = JOptionPane.showConfirmDialog(null, "Esta seguro de borrar la olimpiada: "+o.getNombre(), "Confirmar", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
				    GestionOlimpiadas go = new GestionOlimpiadas();
				    if(go.borrarOlimpiada(o)) {
				    	JOptionPane.showMessageDialog(null, "Olimpiada borrada","Exito", JOptionPane.INFORMATION_MESSAGE);
				    	rellenarOlimpiadas();
				    }else {
						JOptionPane.showMessageDialog(null, "Error al borrar la olimpiada","Error", JOptionPane.ERROR_MESSAGE);
				    }
				} 
			}
		});
		
		btnNuevoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Olimpiada o = (Olimpiada) listOlimpiadas.getSelectedValue();
				NuevoEditarEvento nee = new NuevoEditarEvento(V_Olimpiadas.this,true,o);
				nee.setVisible(true);
				rellenarEventos(o);
			}
		});
		
		btnEditarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Olimpiada o = (Olimpiada) listOlimpiadas.getSelectedValue();
					Evento e = (Evento) listaEvento.getSelectedValue();
					NuevoEditarEvento nee = new NuevoEditarEvento(V_Olimpiadas.this,true,e);
					nee.setVisible(true);
					rellenarEventos(o);
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Debes seleccionar un evento valido","Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnBorrarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Olimpiada o = (Olimpiada) listOlimpiadas.getSelectedValue();
				Evento e = (Evento) listaEvento.getSelectedValue();
				GestionEventos ge = new GestionEventos();
				if(e!=null) {
					int dialogResult = JOptionPane.showConfirmDialog (null, "¿Estas seguro de realizar esta accion?","Seguro?",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						if(ge.borrarEvento(e)) {
							JOptionPane.showMessageDialog(null, "Evento borrado","Exito", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Error al borrar el evento (Existen dependencias)","Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Debes seleccionar un evento valido","Error", JOptionPane.ERROR_MESSAGE);
				}
				rellenarEventos(o);
				
			}
		});
		
		btnParticipaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Evento e = (Evento) listaEvento.getSelectedValue();
					Participaciones p = new Participaciones(V_Olimpiadas.this,true,e);
					p.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Debes seleccionar un evento valido","Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}
	
	public void rellenarOlimpiadas() {
		GestionOlimpiadas go = new GestionOlimpiadas();
		
		ArrayList<Olimpiada> olimpiadas = new ArrayList<Olimpiada>();			
		
		olimpiadas = go.getOlimpiadas();

		//listOlimpiadas.setModel(modelOlimpiadas2);
		modelOlimpiadas2.removeAllElements();
		modelOlimpiadas2.addAll(olimpiadas);
		listOlimpiadas.setSelectedIndex(0);
	}
	
	public void rellenarEventos(Olimpiada o) {
		GestionEventos ge = new GestionEventos();
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		eventos = ge.getEventos(o);
		
		modelEventos2 = new DefaultListModel();
		
		listaEvento.setModel(modelEventos2);
		if(eventos.size()==0) {
			ArrayList<String> error = new ArrayList<String>();
			error.add("Sin eventos");
			modelEventos2.addAll(error);
		}else {
			modelEventos2.addAll(eventos);
		}
		
	}

}
