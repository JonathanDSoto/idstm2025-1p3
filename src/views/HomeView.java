package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.HomeController;
import controllers.ProductController;
import controllers.UserController;

public class HomeView {

	public HomeView() {
		// TODO Auto-generated constructor stub
	}
	
	public void home()
	{
		JFrame ventana = new JFrame();
		ventana.setBounds(100, 100, 920, 534);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		ventana.getContentPane().add(panel, BorderLayout.CENTER);

		// ---------- TÍTULO ----------
		JLabel title = new JLabel("UABCS - DASC");
		title.setFont(new Font("SansSerif", Font.BOLD, 26));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setBounds(260, 20, 400, 40);
		panel.add(title);

		// ---------- WIDGETS ----------
		// ---------- WIDGETS CON TEXTO ----------
		int widgetSize = 150;
		int spacing    = 30;
		int widgetY    = 80;

		// Colores de fondo
		Color[] colors = {
		    new Color(255, 138, 128),
		    new Color(128, 216, 255),
		    new Color(204, 255, 144),
		    new Color(255, 213, 79)
		};

		// Textos a mostrar en cada widget
		String[] metrics = {
		    "40 Usuarios",
		    "30 Productos",
		    "10 Pedidos",
		    "5 Config"
		};

		Font metricFont = new Font("SansSerif", Font.BOLD, 16);

		for (int i = 0; i < 4; i++) {
		    // Panel widget
		    JPanel widget = new JPanel(new BorderLayout());
		    widget.setBackground(colors[i]);
		    widget.setBounds(110 + (i * (widgetSize + spacing)), widgetY, widgetSize, widgetSize);
		    widget.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

		    // Label centrado con métrica
		    JLabel lbl = new JLabel(metrics[i], SwingConstants.CENTER);
		    lbl.setFont(metricFont);
		    lbl.setForeground(Color.BLACK);
		    widget.add(lbl, BorderLayout.CENTER);

		    panel.add(widget);
		}


		// ---------- BOTONES ----------
		Font buttonFont = new Font("SansSerif", Font.BOLD, 16);
		int buttonY = 350;
		int buttonWidth = 180;
		int buttonHeight = 40;

		// Usuarios
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(110, buttonY, buttonWidth, buttonHeight);
		btnUsuarios.setBackground(new Color(41, 128, 185));
		btnUsuarios.setForeground(Color.BLACK);
		btnUsuarios.setOpaque(true);
		btnUsuarios.setFont(buttonFont);
		btnUsuarios.addActionListener(e -> {
		    ventana.dispose();
		    
		    UserController uc = new UserController();
		    uc.users();
		    
		});
		panel.add(btnUsuarios);

		// Productos
		JButton btnProductos = new JButton("Productos");
		btnProductos.setBounds(370, buttonY, buttonWidth, buttonHeight);
		btnProductos.setBackground(new Color(46, 204, 113));
		btnProductos.setForeground(Color.BLACK);
		btnProductos.setFont(buttonFont);
		btnProductos.setOpaque(true);
		btnProductos.addActionListener(e -> {
		    ventana.dispose();
		    ProductController pc = new ProductController();
		    pc.products();
		});
		panel.add(btnProductos);

		// Configuración
		JButton btnConfig = new JButton("Configuración");
		btnConfig.setBounds(640, buttonY, buttonWidth, buttonHeight);
		btnConfig.setBackground(new Color(241, 196, 15));
		btnConfig.setForeground(Color.BLACK);
		btnConfig.setOpaque(true);
		btnConfig.setFont(buttonFont);
		panel.add(btnConfig); 
		 
	}

}
