package aplication;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame{
	
	Font etiquetas = new Font("Annai MN",Font.BOLD,32);
	Font tags = new Font("Annai MN",Font.BOLD,22);
	
	Random rand = new Random();

	public Ventana(String title) {
		
		this.setTitle(title);
		this.setVisible(true);
		this.setSize(1000, 600);
		
		//this.setBackground(Color.black);		
		this.setResizable(true);
		this.setLayout(null);
		
		//que_pasa_cuando_cierro_mi_aplicación
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//sobre_que_elemento_colocaré_el_item
		this.setLocationRelativeTo(null);
		
		
		//this.add(this.login());
		
		//this.add(this.registro());
		
		//this.add(this.test());
		
		this.add(this.botones());
		
		
		
		
		
		//this.setMinimumSize(new Dimension(400,400));
		//this.setMaximumSize(new Dimension(600,600));
		
		
		JMenuBar barra = new JMenuBar(); //barra de menus
		
		JMenu menu1 = new JMenu("Archivo");
		JMenu menu2 = new JMenu("Ayuda");
		JMenu menu4 = new JMenu("Cuenta");
		
		JMenuItem op_new = new JMenuItem("Nuevo");
		JMenuItem op_open = new JMenuItem("Abrir");
		JMenuItem op_save = new JMenuItem("Guardar");
		JMenuItem op_close = new JMenuItem("Cerrar");
		
		JMenuItem ir_login = new JMenuItem("Acceder");
		JMenuItem ir_registro = new JMenuItem("Registrarse");
		
		ir_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manager("login");
				
			}});
		
		ir_registro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manager("register");
				
			}});
		
		menu1.add(op_new);
		menu1.add(op_open);
		menu1.add(op_save);
		menu1.add(op_close);
		
		menu4.add(ir_login);
		menu4.add(ir_registro);
		
		JMenu menu3 = new JMenu("Segundo nivel");
		menu1.add(menu3);
		
		JRadioButtonMenuItem op_help = new JRadioButtonMenuItem("Manual de usuario");
		JCheckBoxMenuItem op_support = new JCheckBoxMenuItem("Soporte");
		
		menu2.add(op_help);
		menu2.add(op_support);
		
		
		barra.add(menu1);
		barra.add(menu2);
		barra.add(menu4);
		
		this.setJMenuBar(barra);
		
		this.repaint();
		this.revalidate(); 
		
	}
	
	public JPanel login() {
		
		JTextField textField;
		JPasswordField passwordField;
		
		/*
		JPanel login = new JPanel();
		login.setLocation(0, 0);
		login.setSize(500, 500);
		login.setOpaque(true);
		login.setBackground(new Color(229, 114, 126));
		login.setVisible(true);
		login.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(200, 40);
		etiqueta1.setLocation(160,10);
		etiqueta1.setBackground(Color.ORANGE);
		etiqueta1.setOpaque(true);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setFont(etiquetas);
		login.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Correo");
		etiqueta2.setBounds(60, 150,160, 30);   
		etiqueta2.setFont(tags);
		etiqueta2.setForeground(Color.white);
		login.add(etiqueta2);
		
		JTextField email = new JTextField();
		email.setBounds(60, 200,260, 30);  
		email.setFont(tags);
		//email.setBackground(Color.GREEN);
		//email.setOpaque(true);
		login.add(email);
		
		JButton access = new JButton("Acceder");
		access.setBounds(60, 300,260, 60);  
		access.setFont(etiquetas);
		access.setBackground(Color.GREEN);
		access.setOpaque(true);
		
		access.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hola");
				
				if( email.getText().equals("") ) {
					
					email.setBorder(BorderFactory.createLineBorder(Color.red,10));
					
				}
				
			} 
		});
		
		JButton ir_al_registro = new JButton("¿Aún no tienes cuenta?");
		ir_al_registro.setLocation(60, 380);
		ir_al_registro.setSize(200, 40);
		
		ir_al_registro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				manager("register");
			}
			
		});
		
		login.add(ir_al_registro);
		
		
		login.add(access);
			
		login.revalidate();
		
		return login;
		*/
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		//this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(Application.class.getResource("/aplication/logouabcs1.png")));
		lblNewLabel_7.setBounds(642, 52, 137, 59);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		/*
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(228, 192, 250));
		lblNewLabel_1.setBounds(124, 25, 183, 47); 
		panel.add(lblNewLabel_1);
		*/
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(36, 186, 353, 81);
		lblNewLabel_8.setBorder(BorderFactory.createTitledBorder("Correo electrónico"));
		panel.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBackground(new Color(218, 230, 225));
		textField.setBounds(49, 211, 328, 42);
		panel.add(textField);
		textField.setBorder(new LineBorder(new Color(91, 253, 255), 1, true));
		textField.setBorder(null);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(218, 230, 225));
		passwordField.setBounds(49, 300, 295, 42);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setOpaque(true);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String passText = new String(passwordField.getPassword());
				Boolean flag1 = false, flag2 = false;
				
				
				if( passText.equals("") ) {
					
					passwordField.setBorder(BorderFactory.createLineBorder(Color.red,2));
					
				}else {
					
					passwordField.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag1 = true;
				}
				
				
				if(textField.getText().equals("")) {
					textField.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}else {
					
					textField.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag2 = true;
				}
				
				if(flag1 && flag2) {
					
					if(textField.getText().equals("fake@mail.com") ) {
						if(passText.equals("12345")) {
							
							JOptionPane.showMessageDialog(null, "Bienvenido.");
							
						}else {
							JOptionPane.showMessageDialog(null, "Error al acceder","verifique su información",JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Error al acceder","verifique su información",JOptionPane.WARNING_MESSAGE);
					}
					
					
				}
				
			}
		});
		btnNewButton.setBounds(36, 413, 341, 37);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Sabiduría como meta, patria como destino ");
		lblNewLabel_1.setBounds(69, 73, 308, 16);
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Application.class.getResource("/aplication/redd-francisco-9o8YdYGTT64-unsplash.jpg")));
		lblNewLabel_6.setBounds(531, 6, 383, 494);
		lblNewLabel_6.setBorder(BorderFactory.createLineBorder(Color.white,5,true));
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ingresa al panel administrador");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel_2_1.setBounds(49, 109, 340, 39);
		lblNewLabel_2_1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setBorder(BorderFactory.createTitledBorder("Contraseña"));
		lblNewLabel_8_1.setBounds(36, 279, 353, 81);
		panel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Application.class.getResource("/aplication/hidden.png")));
		lblNewLabel_2.setBounds(351, 315, 24, 16);
		panel.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordar contraseña");
		chckbxNewCheckBox.setBounds(36, 372, 180, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("¿Aún no tienes cuenta?");
		lblNewLabel_3.setBounds(225, 462, 152, 16);
		panel.add(lblNewLabel_3);
		
		return panel;
	}
	
	public JPanel registro()
	{
		JPanel mipanel = new JPanel();
		mipanel.setSize(500,500);
		mipanel.setLocation(500, 0);
		mipanel.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("Registro");
		
		etiqueta1.setSize(180, 30);
		etiqueta1.setLocation(150, 10);
		etiqueta1.setBackground(Color.ORANGE);
		etiqueta1.setOpaque(true);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setFont(etiquetas);
		
		mipanel.add(etiqueta1);
		
		
		JLabel email_tag = new JLabel();
		email_tag.setText("Ingrese su correo electrónico: ");
		email_tag.setLocation(30, 90);
		email_tag.setSize(200, 30);
		email_tag.setBorder(BorderFactory.createLineBorder(Color.black) );
		mipanel.add(email_tag);
		
		
		JTextField email = new JTextField();
		email.setSize(180, 40);
		email.setLocation(30, 130);
		mipanel.add(email);
		
		String [] colonias_dataset = {"Centro","villas del encanto","pedregal","Agua escondida","Balandra","Camino real"};
		
		JComboBox colonias = new JComboBox(colonias_dataset);
		colonias.setLocation(30, 180);
		colonias.setSize(180, 40);
		mipanel.add(colonias);
		
		ButtonGroup terminos = new ButtonGroup();
		
		JRadioButton terms1 = new JRadioButton("Acepto los términos",true);
		terms1.setLocation(30, 220);
		terms1.setSize(180, 40);
		terms1.setBorder(BorderFactory.createLineBorder(Color.red));
		mipanel.add(terms1);
		
		JRadioButton terms2 = new JRadioButton("No acepto los términos");
		terms2.setLocation(220, 220);
		terms2.setSize(180, 40);
		terms2.setBorderPainted(true);
		terms2.setBorder(BorderFactory.createLineBorder(Color.red,3));
		mipanel.add(terms2);
		
		terminos.add(terms1);
		terminos.add(terms2);
		
		
		JButton ir_al_login = new JButton("¿Aún no tienes cuenta?");
		ir_al_login.setLocation(60, 380);
		ir_al_login.setSize(200, 40);
		
		ir_al_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				manager("login");
			}
			
		});
		
		mipanel.add(ir_al_login);
		
		return mipanel;
	}
	
	public JPanel test() {
		
		JPanel test = new JPanel();
		test.setLocation(0, 0);
		test.setSize(500, 500);
		test.setOpaque(true);
		test.setBackground(new Color(229, 114, 126));
		test.setVisible(true);
		test.setLayout(new BorderLayout());
		
		JLabel etiqueta1 = new JLabel("Interés");
		etiqueta1.setSize(200, 40);
		etiqueta1.setLocation(160,10);
		etiqueta1.setBackground(Color.ORANGE);
		etiqueta1.setOpaque(true);
		etiqueta1.setHorizontalAlignment(JLabel.LEFT);
		etiqueta1.setFont(etiquetas);
		test.add(etiqueta1,BorderLayout.NORTH);
		
		TitledBorder title = BorderFactory.createTitledBorder("Calcular interés");
		
		JPanel calculadora = new JPanel(); 
		calculadora.setOpaque(true);
		calculadora.setBackground(new Color(130, 220, 121));
		calculadora.setVisible(true); 
		calculadora.setBorder(title);
		calculadora.setLayout(new GridLayout(4,2));
		test.add(calculadora,BorderLayout.CENTER);
		
		//items de la calculadora
		

		//items de la calculadora
		
		JPanel footer = new JPanel();
		footer.setOpaque(true);
		footer.setBackground(new Color(207,147,240));
		footer.setVisible(true);
		footer.setLayout(new GridLayout(2,2,20,20));
		
		//items del footer
		
		JLabel interes_tag = new JLabel("Interés:");
		JTextField interes_input = new JTextField("315.000002");
		
		interes_tag.setBorder(BorderFactory.createMatteBorder(10,60,10,10,new Color(207,147,240)));
		
		JLabel amount_tag = new JLabel("Monto:");
		JTextField amount_input = new JTextField("1815.000002");
		
		footer.add(interes_tag);
		footer.add(interes_input);
		
		footer.add(amount_tag);
		footer.add(amount_input);
		
		//items del footer
		
		
		test.add(footer,BorderLayout.PAGE_END);
	
		return test;
		
	}
	
	public JPanel botones() {
		
		JPanel mipanel = new JPanel();
		mipanel.setSize(1000, 600);
		mipanel.setLocation(0, 0);
		mipanel.setLayout(null);
		mipanel.setOpaque(true);
		mipanel.setBackground(Color.decode("#984BEE"));
		
		
		JButton main_boton = new JButton("Click Me");
		main_boton.setSize(300, 60);
		main_boton.setFont(etiquetas);
		main_boton.setLocation(350, 450);
		main_boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton boton = new JButton("Hola: "+rand.nextInt(600));
				boton.setSize(rand.nextInt(100), rand.nextInt(100));
				boton.setLocation(rand.nextInt(600), rand.nextInt(500));
				 
				mipanel.add(boton);
				
				mipanel.repaint();
				
			}
		});
		mipanel.add(main_boton);
		
		
		return mipanel;
	}
	
 	public void manager(String target) {
	
		this.getContentPane().removeAll();
		
		
		if(target.equals("register")) {
			this.add(this.registro());
		}
		
		if(target.equals("login")) {
			this.add(this.login());
		} 
		
		this.repaint();
		this.revalidate(); 
		
	}
	
	@Override
 	public void paint(Graphics g) {
		
		super.paint(g);
		
		/*Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.red);
		
		g2.drawRect(80, 80, 400, 400);
		g2.fillRect(200, 200, 200, 200);
		g2.clearRect(220, 220, 50, 50);
		
		g2.setColor(Color.blue);
		g2.fillRoundRect(400, 80, 200, 200, 30, 30);
		
		
		g2.setColor(Color.green);
		
		g2.setStroke(new BasicStroke(10));
		g2.drawLine(100,100,900,500);
		
		g2.setStroke(new BasicStroke(5));
		
		g2.setColor(new Color(229, 114, 126));
		g2.drawOval(400, 400, 90, 90);
		g2.fillOval(400, 450, 75, 150);
		
		
		g2.setColor(new Color(207,147,240));
		
		g2.drawArc(600,200,200,200,1,-180);
		g2.fillArc(600,200,200,200,1,180);
		
		
		g2.setColor(Color.decode("#33A7F1"));
		g2.setFont(etiquetas);
		
		g2.drawString("Hola crayola", 350, 200);
		
		BufferedImage image;
		try {
			
			image = ImageIO.read(new File("4th-of-july.png"));
		
			g2.drawImage(image,
	                 800,
	                 250,
	                 100,
	                 100, Color.gray, null);
		
		
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
		int[] xs = {100,100,400};
		int[] ys = {100,200,400};
		
		g2.drawPolygon(xs,ys,3);
		
		int[] xs2 = {600,500,100};
		int[] ys2 = {600,200,150};
		
		//g2.fillPolygon(xs2,ys2,3);
		
		//this.repaint();
		*/
	}
	
}









