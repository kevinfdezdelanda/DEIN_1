package ej4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.Font;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;

public class Ej4 extends JFrame {

	private JPanel contentPane;
	private static JLabel hora1;
	private static JLabel hora2;
	private static JLabel min1;
	private static JLabel min2;
	private static JLabel seg1;
	private static JLabel seg2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej4 frame = new Ej4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});



	}

	public static void eventos() {
		Timer timer;
		timer = new Timer();

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				String[] imgs = { "ZERO.png", "ONE.png", "TWO.png", "THREE.png", "FOUR.png", "FIVE.png", "SIX.png", "SEVEN.png",
						"EIGHT.png", "NINE.png" };
				LocalTime time = LocalTime.now();
				
				int hora = time.getHour();
				hora1.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/" + imgs[hora / 10])));
				hora2.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/" + imgs[hora % 10])));

				int min = time.getMinute();
				min1.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/" + imgs[min / 10])));
				min2.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/" + imgs[min % 10])));

				int seg = time.getSecond();
				seg1.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/" + imgs[seg / 10])));
				seg2.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/" + imgs[seg % 10])));

			}
		};
		// Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		timer.schedule(task, 0, 1000);
	}

	/**
	 * Create the frame.
	 */
	public Ej4() {
		setTitle("Reloj");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ej4.class.getResource("/ej4_resources/reloj.png")));
		dibujar();
		
		eventos();
		
	}

	public void dibujar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 482, 373);
		lblFondo.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/fondoReloj.png")));
		contentPane.setLayout(null);

		hora1 = new JLabel("");
		hora1.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/ZERO.png")));
		hora1.setBounds(35, 155, 54, 106);
		contentPane.add(hora1);

		hora2 = new JLabel("");
		hora2.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/ZERO.png")));
		hora2.setBounds(89, 155, 54, 106);
		contentPane.add(hora2);

		JLabel dosPuntos1 = new JLabel(":");
		dosPuntos1.setForeground(new Color(255, 102, 0));
		dosPuntos1.setFont(new Font("Dialog", Font.BOLD, 72));
		dosPuntos1.setBounds(149, 155, 64, 106);
		contentPane.add(dosPuntos1);

		min1 = new JLabel("");
		min1.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/ZERO.png")));
		min1.setBounds(179, 155, 54, 106);
		contentPane.add(min1);

		min2 = new JLabel("");
		min2.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/ZERO.png")));
		min2.setBounds(234, 155, 54, 106);
		contentPane.add(min2);

		JLabel dosPuntos2 = new JLabel(":");
		dosPuntos2.setForeground(new Color(255, 102, 0));
		dosPuntos2.setFont(new Font("Dialog", Font.BOLD, 72));
		dosPuntos2.setBounds(288, 155, 64, 106);
		contentPane.add(dosPuntos2);

		seg1 = new JLabel("");
		seg1.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/ZERO.png")));
		seg1.setBounds(328, 155, 54, 106);
		contentPane.add(seg1);

		seg2 = new JLabel("");
		seg2.setIcon(new ImageIcon(Ej4.class.getResource("/ej4_resources/ZERO.png")));
		seg2.setBounds(384, 155, 54, 106);
		contentPane.add(seg2);
		contentPane.add(lblFondo);
	}

}
