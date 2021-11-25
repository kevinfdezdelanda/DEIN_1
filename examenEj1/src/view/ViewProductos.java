package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.GestionProductos;
import model.Producto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ListSelectionModel;

public class ViewProductos extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtFiltro;
	private JTable table;
	private DefaultTableModel model;
	private JCheckBox chckbxDisponible;
	private JButton btnCrear;
	private JButton btnActualizar;
	private JButton btnLimpiar;
	private JButton btnBuscar;
	private JMenuItem borrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProductos frame = new ViewProductos();
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
	public ViewProductos() {
		dibujar();
		eventos();
		rellenarProductos("");
	}

	public void dibujar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GESTIONAR PRODUCTOS");
		setBounds(100, 100, 741, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(100, 149, 237));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBorder(new TitledBorder(null, "Detalles del producto", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.BLACK));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblCdigo = new JLabel("Código:");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 0;
		panel.add(lblCdigo, gbc_lblCdigo);

		txtCodigo = new JTextField();
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigo.gridx = 1;
		gbc_txtCodigo.gridy = 0;
		panel.add(txtCodigo, gbc_txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		panel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio:");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 2;
		panel.add(lblPrecio, gbc_lblPrecio);

		txtPrecio = new JTextField();
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridx = 1;
		gbc_txtPrecio.gridy = 2;
		panel.add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);

		chckbxDisponible = new JCheckBox("Disponible");
		GridBagConstraints gbc_chckbxDisponible = new GridBagConstraints();
		gbc_chckbxDisponible.anchor = GridBagConstraints.WEST;
		gbc_chckbxDisponible.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDisponible.gridx = 1;
		gbc_chckbxDisponible.gridy = 3;
		panel.add(chckbxDisponible, gbc_chckbxDisponible);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel.add(panel_1, gbc_panel_1);

		btnCrear = new JButton("Crear");
		panel_1.add(btnCrear);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);
		panel_1.add(btnActualizar);

		btnLimpiar = new JButton("Limpiar");
		panel_1.add(btnLimpiar);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblFiltro = new JLabel("Filtro:");
		GridBagConstraints gbc_lblFiltro = new GridBagConstraints();
		gbc_lblFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltro.anchor = GridBagConstraints.EAST;
		gbc_lblFiltro.gridx = 0;
		gbc_lblFiltro.gridy = 0;
		panel_2.add(lblFiltro, gbc_lblFiltro);

		txtFiltro = new JTextField();
		GridBagConstraints gbc_txtFiltro = new GridBagConstraints();
		gbc_txtFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_txtFiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFiltro.gridx = 1;
		gbc_txtFiltro.gridy = 0;
		panel_2.add(txtFiltro, gbc_txtFiltro);
		txtFiltro.setColumns(10);

		btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 0;
		panel_2.add(btnBuscar, gbc_btnBuscar);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowGrid(false);
		model = new DefaultTableModel(new Object[][] { { "CODIGO", "NOMBRE", "PRECIO", "DISPONIBLE" }, },
				new String[] { "Codigo", "Nombre", "Precio", "Disponible" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		table.setModel(model);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		panel_2.add(table, gbc_table);
		
		borrar = new JMenuItem("borrar");
		
		btnActualizar.setBackground(Color.white);
		btnBuscar.setBackground(Color.white);
		btnCrear.setBackground(Color.white);
		btnLimpiar.setBackground(Color.white);
	}
	
	public void eventos() {
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearProducto();
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarProducto();
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarDatos();
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenarProductos(txtFiltro.getText());
			}
		});
		
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarProducto();
			}
		});
		
		table.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent e){
		        if(e.getButton() == 3) {
		        	if(table.getSelectedRow()!=0 && table.getSelectedRow()!=-1) {
		        		JPopupMenu popup = new JPopupMenu();
			        	table.setComponentPopupMenu(popup);
			        	
			        	popup.add(borrar);
			        	popup.show(e.getComponent(), e.getX(), e.getY());
			        	
			            popup.setVisible(true);
		        	}
		        }
		    	
		    	if(e.getClickCount()==2){
		    		if(table.getSelectedRow()!=0 && table.getSelectedRow()!=-1) {
		    			cargarDatosProducto();
		    		}
		        }
		    }
		});
	}

	public void rellenarProductos(String filtro) {
		GestionProductos gp = new GestionProductos();

		ArrayList<Producto> productos = new ArrayList<Producto>();
		model = new DefaultTableModel(new Object[][] { { "CODIGO", "NOMBRE", "PRECIO", "DISPONIBLE" }, },
				new String[] { "Codigo", "Nombre", "Precio", "Disponible" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		if (filtro.equals("")) {
			productos = gp.getProductos();
		} else {
			productos = gp.getProductosFiltrados(filtro);
		}

		for (int i = 0; i < productos.size(); i++) {
			Producto p = productos.get(i);
			String disponible;
			if (p.getDisponible() == 1) {
				disponible = "Si";
			} else {
				disponible = "No";
			}
			model.addRow(new String[] { p.getCodigo(), p.getNombre(), p.getPrecio() + "", disponible });

		}

		table.setModel(model);
	}

	public void crearProducto() {

		String error = comprobarDatos();

		if (error.equals("")) {
			GestionProductos gp = new GestionProductos();
			Producto p = obtenerProducto();

			if (gp.existeCodigo(p.getCodigo())) {
				JOptionPane.showMessageDialog(null, "El codigo de producto ya existe", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				if (gp.nuevoProducto(p)) {
					JOptionPane.showMessageDialog(null, "Producto creado", "Exito", JOptionPane.INFORMATION_MESSAGE);
					limpiarDatos();
					rellenarProductos("");
				} else {
					JOptionPane.showMessageDialog(null, "Error al crear el producto", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void limpiarDatos() {
		txtCodigo.setText("");
		txtFiltro.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		chckbxDisponible.setSelected(false);
		btnActualizar.setEnabled(false);
		btnCrear.setEnabled(true);
		txtCodigo.setEnabled(true);
	}

	public void cargarDatosProducto() {
		int i = table.getSelectedRow();
		txtCodigo.setText(table.getValueAt(i, 0) + "");
		txtNombre.setText(table.getValueAt(i, 1) + "");
		txtPrecio.setText(table.getValueAt(i, 2) + "");

		if (table.getValueAt(i, 3).equals("Si")) {
			chckbxDisponible.setSelected(true);
		} else {
			chckbxDisponible.setSelected(false);
		}

		txtCodigo.setEnabled(false);
		btnCrear.setEnabled(false);
		btnActualizar.setEnabled(true);

	}

	public void actualizarProducto() {
		String error = comprobarDatos();
		if (error.equals("")) {
			GestionProductos gp = new GestionProductos();
			Producto p = obtenerProducto();
			if (gp.editarProducto(p)) {
				JOptionPane.showMessageDialog(null, "Exito al actualizar el producto", "Error",
						JOptionPane.INFORMATION_MESSAGE);
				limpiarDatos();
				rellenarProductos("");
			} else {
				JOptionPane.showMessageDialog(null, "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public String comprobarDatos() {
		String codigo = txtCodigo.getText().toUpperCase();
		String nombre = txtNombre.getText().toUpperCase();
		String strPrecio = txtPrecio.getText();

		String error = "";
		if (codigo.equals("") || nombre.equals("") || strPrecio.equals("")) {
			error += "Debes rellenar todos los campos \n";
		}

		if (!codigo.equals("") && codigo.length() != 5) {
			error += "El codigo debe tener una logitud de 5 caracteres \n";
		}

		try {
			if (!strPrecio.equals("")) {
				float precio = Float.parseFloat(strPrecio);
			}
		} catch (NumberFormatException e) {
			error += "El precio debe ser un numero decimal valido \n";
		}

		return error;
	}

	public Producto obtenerProducto() {
		String codigo = txtCodigo.getText().toUpperCase();
		String nombre = txtNombre.getText().toUpperCase();
		String strPrecio = txtPrecio.getText();
		float precio = Float.parseFloat(strPrecio);

		Producto p = new Producto();
		p.setCodigo(codigo);
		p.setNombre(nombre);
		p.setPrecio(precio);
		if (chckbxDisponible.isSelected()) {
			p.setDisponible(1);
		} else {
			p.setDisponible(0);
		}

		return p;
	}
	
	public void borrarProducto() {
		int i = table.getSelectedRow();
		Producto p = new Producto();
		p.setCodigo(table.getValueAt(i, 0) + "");
		p.setNombre(table.getValueAt(i, 1) + "");
		
		int reply = JOptionPane.showConfirmDialog(null, "Esta seguro de borrar el producto: "+p, "Confirmar", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
		    GestionProductos gp = new GestionProductos();
		    if(gp.borrarProducto(p)) {
		    	JOptionPane.showMessageDialog(null, "Producto borrado","Exito", JOptionPane.INFORMATION_MESSAGE);
		    	rellenarProductos("");
		    }else {
				JOptionPane.showMessageDialog(null, "Error al borrar el producto","Error", JOptionPane.ERROR_MESSAGE);
		    }
		} 
	}

	private void showMenu(MouseEvent e) {
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(0, 0, 319, 58);

		popupMenu.add(borrar);
		popupMenu.show(e.getComponent(), e.getX(), e.getY());

	}
}

