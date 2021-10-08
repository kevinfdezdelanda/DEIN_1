package ej1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Ej1 extends JFrame {

	private JTextField textField;
	private JComboBox comboBox;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JCheckBox chckbxPracticaAlgunDeporte;
	private JList list;
	private JSlider slider;
	private JLabel lblNewLabel_1;
	private JSlider slider_1;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej1 frame = new Ej1();
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
	public Ej1() {
		setTitle("ENCUESTA");
		eventos();
		dibujar();
	}

	private void eventos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void dibujar() {
		setBounds(100, 100, 470, 449);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {20, 0, 0, 0, 0, 20, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblProfesin = new JLabel("Profesión:");
		GridBagConstraints gbc_lblProfesin = new GridBagConstraints();
		gbc_lblProfesin.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesin.anchor = GridBagConstraints.EAST;
		gbc_lblProfesin.gridx = 1;
		gbc_lblProfesin.gridy = 0;
		contentPane.add(lblProfesin, gbc_lblProfesin);
		
		textField = new JTextField();
		textField.setToolTipText("Escribe tu profesión");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 3;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNHermanos = new JLabel("Nº Hermanos:");
		GridBagConstraints gbc_lblNHermanos = new GridBagConstraints();
		gbc_lblNHermanos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNHermanos.gridx = 1;
		gbc_lblNHermanos.gridy = 1;
		contentPane.add(lblNHermanos, gbc_lblNHermanos);
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.ipadx = 20;
		gbc_spinner.anchor = GridBagConstraints.WEST;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 1;
		contentPane.add(spinner, gbc_spinner);
		
		JLabel lblNewLabel = new JLabel("Edad");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Menores de 18", "Entre 18 y 30", "Entre 31 y 50", "Entre 51 y 70", "Mayores de 70"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 1;
		contentPane.add(comboBox, gbc_comboBox);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Selecciona tu sexo");
		panel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));
		
		rdbtnNewRadioButton_1 = new JRadioButton("Mujer");
		panel.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton = new JRadioButton("Hombre");
		panel.add(rdbtnNewRadioButton);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnNewRadioButton_1);
	    group.add(rdbtnNewRadioButton);
		
		chckbxPracticaAlgunDeporte = new JCheckBox("Practica algun deporte?");
		GridBagConstraints gbc_chckbxPracticaAlgunDeporte = new GridBagConstraints();
		gbc_chckbxPracticaAlgunDeporte.gridwidth = 2;
		gbc_chckbxPracticaAlgunDeporte.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPracticaAlgunDeporte.gridx = 1;
		gbc_chckbxPracticaAlgunDeporte.gridy = 3;
		contentPane.add(chckbxPracticaAlgunDeporte, gbc_chckbxPracticaAlgunDeporte);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "\u00BFCual?", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setSelectedIndices(new int[] {2});
		list.setVisibleRowCount(2);
		list.setToolTipText("Selecciona un deporte");
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Tenis", "Fútbol", "Baloncesto", "Natación", "Ciclismo", "Otro"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblMarqueSuGrado = new JLabel("Marque su grado de afición del  1 al 10 a:");
		GridBagConstraints gbc_lblMarqueSuGrado = new GridBagConstraints();
		gbc_lblMarqueSuGrado.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarqueSuGrado.gridwidth = 4;
		gbc_lblMarqueSuGrado.gridx = 1;
		gbc_lblMarqueSuGrado.gridy = 4;
		contentPane.add(lblMarqueSuGrado, gbc_lblMarqueSuGrado);
		
		JLabel lblCompras = new JLabel("Compras:");
		GridBagConstraints gbc_lblCompras = new GridBagConstraints();
		gbc_lblCompras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompras.gridx = 1;
		gbc_lblCompras.gridy = 5;
		contentPane.add(lblCompras, gbc_lblCompras);
		
		slider = new JSlider();
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setValue(5);
		slider.setMaximum(10);
		slider.setToolTipText("");
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridwidth = 3;
		gbc_slider.gridx = 2;
		gbc_slider.gridy = 5;
		contentPane.add(slider, gbc_slider);
		
		lblNewLabel_1 = new JLabel("Ver televisión:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		slider_1 = new JSlider();
		slider_1.setValue(5);
		slider_1.setToolTipText("");
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMaximum(10);
		slider_1.setMajorTickSpacing(1);
		GridBagConstraints gbc_slider_1 = new GridBagConstraints();
		gbc_slider_1.insets = new Insets(0, 0, 5, 5);
		gbc_slider_1.gridwidth = 3;
		gbc_slider_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_1.gridx = 2;
		gbc_slider_1.gridy = 6;
		contentPane.add(slider_1, gbc_slider_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ir al cine:");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 7;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		JSlider slider_1_1 = new JSlider();
		slider_1_1.setValue(5);
		slider_1_1.setToolTipText("");
		slider_1_1.setSnapToTicks(true);
		slider_1_1.setPaintTicks(true);
		slider_1_1.setPaintLabels(true);
		slider_1_1.setMinorTickSpacing(1);
		slider_1_1.setMaximum(10);
		slider_1_1.setMajorTickSpacing(1);
		GridBagConstraints gbc_slider_1_1 = new GridBagConstraints();
		gbc_slider_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_slider_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_1_1.gridwidth = 3;
		gbc_slider_1_1.gridx = 2;
		gbc_slider_1_1.gridy = 7;
		contentPane.add(slider_1_1, gbc_slider_1_1);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 8;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{96, 89, 96, 0};
		gbl_panel_2.rowHeights = new int[]{25, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.gridwidth = 2;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 0;
		panel_2.add(btnAceptar, gbc_btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 0;
		panel_2.add(btnCancelar, gbc_btnCancelar);
	}
}
