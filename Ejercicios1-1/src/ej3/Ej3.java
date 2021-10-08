package ej3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import idiomas.Messages;

import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej3 extends JFrame {

	private JLabel lblRojo;
	private JLabel lblCoche;
	private JLabel lblNewLabel;
	private JLabel lblConfiguraTuMini;
	private JLabel lblLuz;
	private JLabel lblSeleccionaTuColor;
	private JLabel lblAzul;
	private JLabel lblnegro;
	private JLabel lblGris;
	private JLabel lblBlanco;
	private JLabel lblGrisOscuro;
	private JLabel lblAmarillo;
	private JButton btnLuz;
	private JButton btnEs;
	private JButton btnEu;
	private JButton btnEn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej3 frame = new Ej3();
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
	public Ej3() {
		Locale locale = null;
		dibujar(locale);
		eventos();
	}

	public void dibujar(Locale locale) {
		setBounds(100, 100, 691, 597);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ej3.class.getResource("/resources/images/cooperLogo.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		
		
		
		lblConfiguraTuMini = new JLabel(Messages.getString("Ej3.5",locale));
		lblConfiguraTuMini.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblConfiguraTuMini = new GridBagConstraints();
		gbc_lblConfiguraTuMini.insets = new Insets(0, 0, 5, 0);
		gbc_lblConfiguraTuMini.gridx = 1;
		gbc_lblConfiguraTuMini.gridy = 1;
		contentPane.add(lblConfiguraTuMini, gbc_lblConfiguraTuMini);
		
		lblLuz = new JLabel("");
		GridBagConstraints gbc_lblLuz = new GridBagConstraints();
		gbc_lblLuz.gridwidth = 2;
		gbc_lblLuz.insets = new Insets(0, 0, 5, 0);
		gbc_lblLuz.gridx = 0;
		gbc_lblLuz.gridy = 3;
		contentPane.add(lblLuz, gbc_lblLuz);
		
		
		lblCoche = new JLabel(""); //$NON-NLS-1$
		lblCoche.setIcon(new ImageIcon(Ej3.class.getResource("/resources/coches/miniBlazingRed.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_lblCoche = new GridBagConstraints();
		gbc_lblCoche.insets = new Insets(0, 0, 5, 0);
		gbc_lblCoche.gridwidth = 2;
		gbc_lblCoche.gridx = 0;
		gbc_lblCoche.gridy = 3;
		contentPane.add(lblCoche, gbc_lblCoche);
		
		lblSeleccionaTuColor = new JLabel(Messages.getString("Ej3.0",locale));
		lblSeleccionaTuColor.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblSeleccionaTuColor = new GridBagConstraints();
		gbc_lblSeleccionaTuColor.gridwidth = 2;
		gbc_lblSeleccionaTuColor.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeleccionaTuColor.gridx = 0;
		gbc_lblSeleccionaTuColor.gridy = 4;
		contentPane.add(lblSeleccionaTuColor, gbc_lblSeleccionaTuColor);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
		
		lblRojo = new JLabel(""); //$NON-NLS-1$
		panel.add(lblRojo);
		lblRojo.setIcon(new ImageIcon(Ej3.class.getResource("/resources/colores/colorBlazingRed.jpg"))); //$NON-NLS-1$
		
		lblAzul = new JLabel("");
		panel.add(lblAzul);
		lblAzul.setIcon(new ImageIcon(Ej3.class.getResource("/resources/colores/colorElectricBlue.jpg"))); //$NON-NLS-1$
		
		lblnegro = new JLabel("");
		panel.add(lblnegro);
		lblnegro.setIcon(new ImageIcon(Ej3.class.getResource("/resources/colores/colorLapisluxuryBlue.jpg"))); //$NON-NLS-1$
		
		lblGris = new JLabel("");
		panel.add(lblGris);
		lblGris.setIcon(new ImageIcon(Ej3.class.getResource("/resources/colores/colorMidnightBlack.jpg"))); //$NON-NLS-1$
		
		lblBlanco = new JLabel("");
		panel.add(lblBlanco);
		lblBlanco.setIcon(new ImageIcon(Ej3.class.getResource("/resources/colores/colorPepperWhite.jpg"))); //$NON-NLS-1$
		lblBlanco.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblGrisOscuro = new JLabel("");
		panel.add(lblGrisOscuro);
		lblGrisOscuro.setIcon(new ImageIcon(Ej3.class.getResource("/resources/colores/colorThunderGray.jpg"))); //$NON-NLS-1$
		
		lblAmarillo = new JLabel("");
		panel.add(lblAmarillo);
		lblAmarillo.setIcon(new ImageIcon(Ej3.class.getResource("/resources/colores/colorVolcaninOrange.jpg"))); //$NON-NLS-1$
		
		btnLuz = new JButton("");
		btnLuz.setToolTipText(Messages.getString("Ej3.6",locale));
		btnLuz.setBackground(new Color(255, 255, 255));
		btnLuz.setIcon(new ImageIcon(Ej3.class.getResource("/resources/images/lucesOn.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_btnLuz = new GridBagConstraints();
		gbc_btnLuz.anchor = GridBagConstraints.WEST;
		gbc_btnLuz.insets = new Insets(0, 0, 5, 5);
		gbc_btnLuz.gridx = 0;
		gbc_btnLuz.gridy = 2;
		contentPane.add(btnLuz, gbc_btnLuz);
		
		btnEs = new JButton("ES");
		btnEs.setForeground(Color.WHITE);
		btnEs.setBackground(new Color(25, 25, 25));
		panel_1.add(btnEs);
		
		btnEu = new JButton("EU");
		btnEu.setForeground(Color.WHITE);
		btnEu.setBackground(new Color(25, 25, 25));
		panel_1.add(btnEu);
		
		btnEn = new JButton("EN");
		btnEn.setForeground(Color.WHITE);
		btnEn.setBackground(new Color(25, 25, 25));
		panel_1.add(btnEn);
		
	}

	public void eventos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblRojo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ej3.class.getResource("/resources/coches/miniBlazingRed.png"))); //$NON-NLS-1$
			}
		});
		lblAzul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ej3.class.getResource("/resources/coches/miniElectricBlue.png"))); //$NON-NLS-1$
			}
		});
		lblnegro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ej3.class.getResource("/resources/coches/miniLapisluxuryBlue.png"))); //$NON-NLS-1$
			}
		});
		lblGris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ej3.class.getResource("/resources/coches/miniMidnightBlack.png"))); //$NON-NLS-1$
			}
		});
		lblBlanco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ej3.class.getResource("/resources/coches/miniPepperWhite.png"))); //$NON-NLS-1$
			}
		});
		lblGrisOscuro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ej3.class.getResource("/resources/coches/miniThunderGray.png"))); //$NON-NLS-1$
			}
		});
		lblAmarillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ej3.class.getResource("/resources/coches/miniVolcaninOrange.png"))); //$NON-NLS-1$
			}
		});
		btnLuz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblLuz.getIcon()== null) {
					lblLuz.setIcon(new ImageIcon(Ej3.class.getResource("/resources/images/autoLuz.png"))); //$NON-NLS-1$
					btnLuz.setIcon(new ImageIcon(Ej3.class.getResource("/resources/images/lucesOff.png"))); //$NON-NLS-1$
				}else {
					lblLuz.setIcon(null);
					btnLuz.setIcon(new ImageIcon(Ej3.class.getResource("/resources/images/lucesOn.png"))); //$NON-NLS-1$
				}
				
			}
		});
		btnEs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Locale locale=new Locale("es","ES");
				lblSeleccionaTuColor.setText(Messages.getString("Ej3.0",locale));
				lblConfiguraTuMini.setText(Messages.getString("Ej3.5",locale));
				btnLuz.setToolTipText(Messages.getString("Ej3.6",locale));
			}
		});
		btnEu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Locale locale=new Locale("eu","ES");
				lblSeleccionaTuColor.setText(Messages.getString("Ej3.0",locale));
				lblConfiguraTuMini.setText(Messages.getString("Ej3.5",locale));
				btnLuz.setToolTipText(Messages.getString("Ej3.6",locale));
			}
		});
		btnEn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Locale locale=new Locale("en","GB");
				lblSeleccionaTuColor.setText(Messages.getString("Ej3.0",locale));
				lblConfiguraTuMini.setText(Messages.getString("Ej3.5",locale));
				btnLuz.setToolTipText(Messages.getString("Ej3.6",locale));
			}
		});
	}

}
