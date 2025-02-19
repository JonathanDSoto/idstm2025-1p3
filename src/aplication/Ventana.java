package aplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame{
	
	Font etiquetas = new Font("Andale Mono", Font.BOLD, 22);

	public Ventana(String title) {
		
		this.setTitle(title);
		this.setVisible(true);
		this.setSize(500, 500);
		
		this.setResizable(true);
		this.setLayout(null);
		
		//que_pasa_cuando_cierro_mi_aplicación
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//sobre_que_elemento_colocaré_el_item
		this.setLocationRelativeTo(null);
		
		this.setMinimumSize(new Dimension(400,400));
		
		this.setMaximumSize(new Dimension(600,600));
		
		this.add(this.login());
		this.repaint();
		
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

}
