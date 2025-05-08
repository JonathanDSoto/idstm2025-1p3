package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import controllers.ProductController;
import models.ProducModel;

public class ProductView {

	public ProductView() {
		
	}
	
	public void products(JSONArray data) {
		
		JFrame ventana = new JFrame();
		
		ventana.setBounds(100, 100, 920, 534);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		ventana.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton add = new JButton("añadir producto");
		add.setBounds(635, 70, 200, 40);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
				ProductController pc = new ProductController();
				pc.add();
			}
			
		});
		panel.add(add);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		int x = 90;
		
		for (Object product1 : data) {
			
			JSONObject product = (JSONObject) product1; 
			
			JLabel lblNewLabel2 = new JLabel((String) product.get("title"));
			lblNewLabel2.setForeground(new Color(0, 0, 0)); 
			lblNewLabel2.setBounds(107, x, 210, 26);
			lblNewLabel2.setHorizontalAlignment(JLabel.CENTER);
			panel.add(lblNewLabel2); 
			
			JButton remove = new JButton("Eliminar");
			remove.setName((Long) product.get("id")+"");
			remove.setBounds(257, x, 210, 26);
			remove.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) { 
					
					((JButton) e.getSource()).getName();
					
					System.out.println("Hola: "+((JButton) e.getSource()).getName());
				
					ProducModel pm = new ProducModel();
					pm.remove();
					
					ventana.dispose();
					
					ProductController pc = new ProductController();
					pc.products();
				}
				
			});
			
			panel.add(remove);
			
			x+=35;
			
		}
		
		
		
		//data.forEach( emp -> parseTestData( (JSONObject) emp ) );
		 
	}
	
	public void add()
	{
		
		JFrame ventana = new JFrame();
		
		ventana.setBounds(100, 100, 920, 534);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		ventana.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel nameTag = new JLabel("Nombre del producto");
		nameTag.setBounds(100, 100, 200, 40);
		panel.add(nameTag);
		
		JTextField nameInput = new JTextField();
		nameInput.setBounds(100, 160, 200, 40);
		panel.add(nameInput);
		
		
		JButton add = new JButton("añadir producto");
		add.setBounds(100, 450, 200, 40);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String name = nameInput.getText();
				
				ProducModel pm = new ProducModel();
				pm.addProduct(name);
				
				ventana.dispose();
				
				ProductController pc = new ProductController();
				pc.products();
				
			}});
		panel.add(add); 
		
		
	}
	
	private static void parseTestData(JSONObject product)
    {
		
		// Obtener valores directamente del objeto producto
	    String title = (String) product.get("title");   
	    System.out.println("Title: " + title);
	      
	    String description = (String) product.get("description");   
	    System.out.println("Description: " + description);
	      
	    String category = (String) product.get("category"); 
	    System.out.println("Category: " + category); 
	    
    }
}
