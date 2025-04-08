package aplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aplication.Paint.Figura;
import aplication.Paint.MyPoint;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Keyboard implements KeyListener{

	private JFrame frame;
	private int x=200,y=200;
	public PaintPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Keyboard window = new Keyboard();
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
	public Keyboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 515, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Reiniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				x =200;
				y = 200;
				panel_2.repaint();
				panel_2.setFocusable(true);
				panel_2.requestFocus();
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("0:00");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		panel_2 = new PaintPanel();
		panel_2.setBackground(Color.black);
		panel_2.setOpaque(true);
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		
		panel_2.addKeyListener(this);
		panel_2.setFocusable(true);
	}
	
	class PaintPanel extends JPanel{
		
		public PaintPanel()
		{
			this.setBackground(Color.black);
		}
		
		@Override
	   public void paintComponent(Graphics g) {
	       super.paintComponent(g);
	       
	       Graphics2D g2 = (Graphics2D) g; 
	       
	       g2.setColor(Color.green);  
	       g2.fillRect(x,y,30,30);
	        
	   }
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 87) {
			y-=5;
		}
		if(e.getKeyCode() == 83) {
			y+=5;
		}
		if(e.getKeyCode() == 65) {
			x-=5;
		}
		if(e.getKeyCode() == 68) {
			x+=5;
		}
		
		panel_2.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	/*
	 * return (this.x < target.x + target.width &&
                this.x + this.width > target.x &&
                this.y < target.y + target.height &&
                this.y + this.height > target.y);
	 */

}
