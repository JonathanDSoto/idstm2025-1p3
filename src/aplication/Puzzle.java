package aplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class Puzzle {

	private JFrame frame;
	
	public ArrayList<JButton> botones = new ArrayList<JButton>();
	public JPanel panel_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Puzzle window = new Puzzle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Puzzle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		for (int i = 0; i < 16; i++) {
			 
			String text = i==0 ? "" : i+""; 
			
			JButton tmp = new JButton(text); 
			tmp.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			botones.add(tmp);
		}
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 667, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createLineBorder(Color.decode("#B983F5"), 10));
		panel_1.setBackground(Color.decode("#B983F5"));
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(8, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Puzzle");
		lblNewLabel.setForeground(new Color(243, 251, 240));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("00:00:00:00");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(243, 251, 240));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_14 = new JButton("Reanudar");
		panel_1.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Pausar");
		panel_1.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("Reiniciar");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				reset();
				
			}
		});
		panel_1.add(btnNewButton_16);
		
		panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createLineBorder(Color.decode("#B983F5"), 10));
		panel_2.setBackground(Color.decode("#B983F5"));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(4, 4, 10, 10));
		
		reset();
		 
	}
	
	public void reset()
	{
		Collections.shuffle(botones);
		panel_2.removeAll();
		
		for (int i = 0; i < 16; i++) {
			
			panel_2.add(botones.get(i)); 
			
			botones.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) { 
					
					JButton tmp = ((JButton) e.getSource());
					
					//System.out.println( tmp.getText() );  
					int x = getIndex( tmp.getText() );
					
					System.out.println(x);
					
					if(x+1<=15) {
						if(botones.get(x+1).getText().equals("")) { 
							
							botones.get(x+1).setText(tmp.getText());
							tmp.setText("");
						}
						
						if(x+4<=15) {
							if(botones.get(x+4).getText().equals("")) {
								
								botones.get(x+4).setText(tmp.getText());
								tmp.setText("");
							} 
						} 
					
					}
					if(x-1>=0) {
						if(botones.get(x-1).getText().equals("")) {
							botones.get(x-1).setText(tmp.getText());
							tmp.setText("");
						}
						
						if(x-4>=0) {
							if(botones.get(x-4).getText().equals("")) {
								botones.get(x-4).setText(tmp.getText());
								tmp.setText("");
							}
							
						}
					}
					
					System.out.println(validar());
				}
				
			});
			
		} 
		
		panel_2.repaint();
		panel_2.revalidate(); 
		
	}
	
	public int getIndex(String texto) {
		
		for (int i = 0; i < 16; i++) {
			
			if( botones.get(i).getText().equals(texto) ) {
				
				return i;
			}
			
		} 
		
		return 0;
	}
	
	
	public boolean validar()
	{
		
		int x = 0;
		
		for (int i = 0; i < 16; i++) {
			
			
			if(!botones.get(i).getText().equals("")) { 
			
				int y =  Integer.parseInt(botones.get(i).getText());
				
				if( y < x ) {
					
					return false;
				}
				
				x = y;
			
			}
			
		} 
		
		if(botones.get(0).getText().equals("")) {
			return true;
		}
		if(botones.get(15).getText().equals("")) {
			return true;
		} 
		
		return false;
	}
	
	
	

}
