package aplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import javax.swing.JButton;  
import javax.swing.JTextField;

public class Ventana extends JFrame{
	
	Font etiquetas = new Font("Annai MN",Font.BOLD,32);

	public Ventana(String title) {
		
		this.setTitle(title);
		this.setVisible(true);
		this.setSize(1000, 500);
		
		this.setResizable(true);
		this.setLayout(null);
		
		//que_pasa_cuando_cierro_mi_aplicación
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//sobre_que_elemento_colocaré_el_item
		this.setLocationRelativeTo(null);
		
		
		//this.add(this.login());
		
		//this.add(this.registro());
		
		this.test();
		
		this.repaint();
		this.revalidate(); 
		this.setMinimumSize(new Dimension(400,400));
		
		this.setMaximumSize(new Dimension(600,600));
		
		
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
		etiqueta1.setSize(160, 40);
		etiqueta1.setLocation(160,10);
		etiqueta1.setBackground(Color.ORANGE);
		etiqueta1.setOpaque(true);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setFont(etiquetas);
		login.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Correo");
		etiqueta2.setBounds(60, 150,160, 30); 
		etiqueta2.setBackground(Color.WHITE);
		etiqueta2.setOpaque(true);
		etiqueta2.setFont(etiquetas);
		//login.add(etiqueta2);
		
		JTextField email = new JTextField();
		email.setBounds(60, 200,260, 30);  
		email.setFont(etiquetas);
		email.setBackground(Color.GREEN);
		email.setOpaque(true);
		//login.add(email);
		
		JButton access = new JButton("Acceder");
		access.setBounds(60, 300,260, 60);  
		access.setFont(etiquetas);
		access.setBackground(Color.GREEN);
		access.setOpaque(true);
		//login.add(access);
			
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
	
	public void test() {
		
		
		JPanel mipanel = new JPanel();
		mipanel.setSize(500,500);
		mipanel.setLocation(500, 0);
		mipanel.setLayout(null);
		
		String botones[] = {"CE","","","","7","8","9","/","4","5","6","*"};
		
		int x = 0, y = 0;
		
		for (String text_button : botones) {
			
			JButton item = new JButton(text_button);
			item.setSize(40, 40);
			if(text_button.equals(""))
				item.setEnabled(false);
			item.setLocation(x, y);
			
			x+=40;
			y+=40;
			
			if(x>120)
				x=0;
			
		}
		
		
	}
}









