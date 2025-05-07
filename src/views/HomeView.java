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

import controllers.HomeController;
import controllers.ProductController;

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
		panel.setBackground(new Color(255, 255, 255));
		ventana.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver productos");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setOpaque(true);
		//btnNewButton.setForeground(new Color(255, 255, 255)); 
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ventana.dispose();
				
				ProductController pc = new ProductController();
				pc.products();
				
			}});
		btnNewButton.setBounds(36, 213, 341, 37);
		panel.add(btnNewButton);
	}

}
