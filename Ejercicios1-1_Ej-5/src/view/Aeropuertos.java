package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.GestionarAeropuertos;
import model.Aeropuerto;
import model.AeropuertoPrivado;
import model.AeropuertoPublico;
import model.Direccion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Aeropuertos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTable table;
	private DefaultTableModel model;
	private JRadioButton rdbtnPublicos;
	private JRadioButton rdbtnPrivado;
	private JMenuBar menuBar;
	private JMenu mnAeropuertos;
	private JMenuItem mntmAadir;
	private JMenuItem mntmEditar;
	private JMenuItem mntmBorrar;
	private JMenuItem mntmMostrarInformacion;
	private JMenu mnAviones;
	private JMenuItem mntmAadir_1;
	private JMenuItem mntmActivarDesactivar;
	private JMenuItem mntmBorrar_1;
	private JMenu mnAyuda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aeropuertos frame = new Aeropuertos();
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
	public Aeropuertos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1342, 314);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAeropuertos = new JMenu("Aeropuertos");
		menuBar.add(mnAeropuertos);
		
		mntmAadir = new JMenuItem("Añadir");
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AniadirEditar ae = new AniadirEditar(Aeropuertos.this,true);
				ae.setVisible(true);
				rellenarTabla("privado", "");
				getRdbtnPrivado().setSelected(true);
				
			}
		});
		mnAeropuertos.add(mntmAadir);
		
		mntmEditar = new JMenuItem("Editar");
		mntmEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int i= table.getSelectedRow();
					Aeropuerto a = new Aeropuerto();
					
					a.setId(Integer.parseInt((String) table.getValueAt(i, 0)));
					a.setNombre((String) table.getValueAt(i, 1));
					
					GestionarAeropuertos ga = new GestionarAeropuertos();
					Direccion d = new Direccion();
					d.setPais((String) table.getValueAt(i, 2));
					d.setNumero(Integer.parseInt((String) table.getValueAt(i, 3)));
					d.setCalle((String) table.getValueAt(i, 4));
					d.setCiudad((String) table.getValueAt(i, 5));
					d.setId(ga.obtenerIdDireccion(a.getId()));
					a.setDireccion(d);
					
					a.setAnio_inauguracion(Integer.parseInt((String) table.getValueAt(i, 6)));
					a.setCapacidad(Integer.parseInt((String) table.getValueAt(i, 7)));
					
					if(table.getColumnCount()==9) {
						AeropuertoPrivado ap = new AeropuertoPrivado();
						ap.setIdAeropuerto(a.getId());
						ap.setnSocios(Integer.parseInt((String) table.getValueAt(i, 8)));
						a.setaPrivado(ap);
					}else {
						AeropuertoPublico ap = new AeropuertoPublico();
						ap.setIdAeropuerto(a.getId());
						ap.setFinanciacion(Double.parseDouble((String) table.getValueAt(i, 8)));
						ap.setNumTrabajadores(Integer.parseInt((String) table.getValueAt(i, 9)));
						a.setaPublico(ap);
					}
					
					AniadirEditar ae = new AniadirEditar(Aeropuertos.this,true,a);
					ae.setVisible(true);
					rellenarTabla("privado", "");
					getRdbtnPrivado().setSelected(true);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		mnAeropuertos.add(mntmEditar);
		
		mntmBorrar = new JMenuItem("Borrar");
		mnAeropuertos.add(mntmBorrar);
		
		mntmMostrarInformacion = new JMenuItem("Mostrar informacion");
		mnAeropuertos.add(mntmMostrarInformacion);
		
		mnAviones = new JMenu("Aviones");
		menuBar.add(mnAviones);
		
		mntmAadir_1 = new JMenuItem("Añadir");
		mnAviones.add(mntmAadir_1);
		
		mntmActivarDesactivar = new JMenuItem("Activar / Desactivar");
		mnAviones.add(mntmActivarDesactivar);
		
		mntmBorrar_1 = new JMenuItem("Borrar");
		mnAviones.add(mntmBorrar_1);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblListadoAeropuertos = new JLabel("LISTADO  DE AEROPUERTOS");
		GridBagConstraints gbc_lblListadoAeropuertos = new GridBagConstraints();
		gbc_lblListadoAeropuertos.insets = new Insets(0, 0, 5, 0);
		gbc_lblListadoAeropuertos.gridx = 0;
		gbc_lblListadoAeropuertos.gridy = 0;
		contentPane.add(lblListadoAeropuertos, gbc_lblListadoAeropuertos);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		rdbtnPrivado = new JRadioButton("Privados");
		rdbtnPrivado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenarTabla("privado","");
			}
		});
		GridBagConstraints gbc_rdbtnPrivado = new GridBagConstraints();
		gbc_rdbtnPrivado.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnPrivado.gridx = 0;
		gbc_rdbtnPrivado.gridy = 0;
		panel.add(rdbtnPrivado, gbc_rdbtnPrivado);
		rdbtnPrivado.setSelected(true);
		
		rdbtnPublicos = new JRadioButton("Publicos");
		rdbtnPublicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenarTabla("publico","");
			}
		});
		GridBagConstraints gbc_rdbtnPublicos = new GridBagConstraints();
		gbc_rdbtnPublicos.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnPublicos.gridx = 1;
		gbc_rdbtnPublicos.gridy = 0;
		panel.add(rdbtnPublicos, gbc_rdbtnPublicos);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnPrivado);
	    group.add(rdbtnPublicos);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 0;
		panel.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String nombre = ((JTextField) e.getSource()).getText();
				if(rdbtnPublicos.isSelected()) {
					rellenarTabla("publico", nombre);
				}else {
					rellenarTabla("privado", nombre);
				}
				
				
			}
		});
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridx = 4;
		gbc_txtNombre.gridy = 0;
		panel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "NOMBRE", "PAIS", "NUMERO", "CALLE", "CIUDAD", "A\u00D1O DE INAUGURACION", "CAPACIDAD", "NUMERO DE SOCIOS"},
			},
			new String[] {
				"ID", "Nombre", "Pais", "Numero", "Calle", "Ciudad", "A\u00F1o de inauguracion", "Capacidad", "Numero de socios"
			}
		));
		model = (DefaultTableModel) table.getModel();
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		contentPane.add(table, gbc_table);
		
		rellenarTabla("privado","");
		
	}
	
	public void rellenarTabla(String tipo, String nombre) {
		GestionarAeropuertos ga = new GestionarAeropuertos();
		
		ArrayList<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();
		if(tipo=="privado") {
			model = new DefaultTableModel(
					new Object[][] {
						{"ID", "NOMBRE", "PAIS", "NUMERO", "CALLE", "CIUDAD", "A\u00D1O DE INAUGURACION", "CAPACIDAD", "NUMERO DE SOCIOS"},
					},
					new String[] {
						"ID", "Nombre", "Pais", "Numero", "Calle", "Ciudad", "A\u00F1o de inauguracion", "Capacidad", "Numero de socios"
					}
				);
			
			aeropuertos = ga.getAeropuertosPrivados(nombre);
			
			for (int i = 0; i < aeropuertos.size(); i++) {
				Aeropuerto a = aeropuertos.get(i);
				model.addRow(new String[]{a.getId()+"", a.getNombre(), a.getDireccion().getPais(), a.getDireccion().getNumero()+"", a.getDireccion().getCalle(), a.getDireccion().getCiudad(), a.getAnio_inauguracion()+"",a.getCapacidad()+"", a.getaPrivado().getnSocios()+""});
			}
		}else {
			model = new DefaultTableModel(
					new Object[][] {
						{"ID", "NOMBRE", "PAIS", "NUMERO", "CALLE", "CIUDAD", "A\u00D1O DE INAUGURACION", "CAPACIDAD", "FINANCIACION","NUM_TRABAJADORES"},
					},
					new String[] {
						"ID", "Nombre", "Pais", "Numero", "Calle", "Ciudad", "A\u00F1o de inauguracion", "Capacidad", "Financiacion","NUM_TRABAJADORES"
					}
				);
			
			aeropuertos = ga.getAeropuertosPublicos(nombre);
			
			for (int i = 0; i < aeropuertos.size(); i++) {
				Aeropuerto a = aeropuertos.get(i);
				model.addRow(new String[]{a.getId()+"", a.getNombre(), a.getDireccion().getPais(), a.getDireccion().getNumero()+"", a.getDireccion().getCalle(), a.getDireccion().getCiudad(), a.getAnio_inauguracion()+"",a.getCapacidad()+"", a.getaPublico().getFinanciacion()+"",a.getaPublico().getNumTrabajadores()+""});
			}
		}

		table.setModel(model);
		
	}

	public JRadioButton getRdbtnPrivado() {
		return rdbtnPrivado;
	}

	public void setRdbtnPrivado(JRadioButton rdbtnPrivado) {
		this.rdbtnPrivado = rdbtnPrivado;
	}
	
	

}
