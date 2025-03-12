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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame{
	
	Font etiquetas = new Font("Annai MN",Font.BOLD,32);
	Font tags = new Font("Annai MN",Font.BOLD,22);

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
		
		
		this.add(this.login());
		
		//this.add(this.registro());
		
		//this.add(this.test());
		
		
		
		
		this.setMinimumSize(new Dimension(400,400));
		this.setMaximumSize(new Dimension(600,600));
		
		
		JMenuBar barra = new JMenuBar(); //barra de menus
		
		JMenu menu1 = new JMenu("Archivo");
		JMenu menu2 = new JMenu("Ayuda");
		
		JMenuItem op_new = new JMenuItem("Nuevo");
		JMenuItem op_open = new JMenuItem("Abrir");
		JMenuItem op_save = new JMenuItem("Guardar");
		JMenuItem op_close = new JMenuItem("Cerrar");
		
		menu1.add(op_new);
		menu1.add(op_open);
		menu1.add(op_save);
		menu1.add(op_close);
		
		JMenu menu3 = new JMenu("Segundo nivel");
		menu1.add(menu3);
		
		JRadioButtonMenuItem op_help = new JRadioButtonMenuItem("Manual de usuario");
		JCheckBoxMenuItem op_support = new JCheckBoxMenuItem("Soporte");
		
		menu2.add(op_help);
		menu2.add(op_support);
		
		
		barra.add(menu1);
		barra.add(menu2);
		
		this.setJMenuBar(barra);
		
		this.repaint();
		this.revalidate(); 
		
	}
	
	public JPanel login() {
		
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
		
		login.add(access);
			
		login.revalidate();
		
		return login;
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









