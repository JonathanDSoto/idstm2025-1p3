package aplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import aplication.Paint.Figura;
import aplication.Paint.MyPoint;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Keyboard implements KeyListener{

	private JFrame frame; 
	private Player player,shadow;
	public PaintPanel panel_2;
	Timer timer,timer2;
	private int seg = 0, lastPress = 0;

	private ArrayList<Player> obstaculos = new ArrayList<Player>();

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
		
		usingCustomFonts();
		
		player = new Player(200,200,25,25,Color.green);
		shadow = new Player(200,200,25,25,Color.green);
		
		obstaculos.add(new Player(150, 350, 220, 35,Color.orange));
		obstaculos.add(new Player(150, 80, 220, 35,Color.orange));
		//obstaculos.add(new Player(50, 100, 20, 220,Color.orange));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Reiniciar");
		btnNewButton.setFont(new Font("Boost Player PERSONAL USE ONLY", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				player.x = 200;
				player.y = 200;
				
				shadow.x = 200;
				shadow.y = 200;
				
				lastPress = 0;
				
				timer.stop();
				
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
		//lblNewLabel.setFont(new Font("Boost Player PERSONAL USE ONLY", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		panel_2 = new PaintPanel();
		panel_2.setBackground(Color.black);
		panel_2.setOpaque(true);
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		
		panel_2.addKeyListener(this);
		panel_2.setFocusable(true);
		
		ActionListener taskPerformer = new ActionListener() {
		       
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				
				String [] split_string = lblNewLabel.getText().split(":");  
				int mil = Integer.parseInt(split_string[1]);
				
				mil+=1;
				
				if(mil>=10) {
					seg++;
					mil = 1;
				} 
				
				lblNewLabel.setText(seg+":"+mil+""); 
				
			}
		  };
		  timer = new Timer(100, taskPerformer);
		  
		  ActionListener movimiento = new ActionListener() {
		       
				@Override
				public void actionPerformed(ActionEvent e) { 
					update();
				}
		   };
		   timer2 = new Timer(4, movimiento);
	}
	
	public void usingCustomFonts() {
	    GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    List<String> AVAILABLE_FONT_FAMILY_NAMES = Arrays.asList(GE.getAvailableFontFamilyNames());
	    try {
	        List<File> LIST = Arrays.asList(
	          new File("BoostPlayer_PERSONAL_USE_ONLY.otf")
	        );
	        for (File LIST_ITEM : LIST) {
	            if (LIST_ITEM.exists()) {
	                Font FONT = Font.createFont(Font.TRUETYPE_FONT, LIST_ITEM);
	                if (!AVAILABLE_FONT_FAMILY_NAMES.contains(FONT.getFontName())) {
	                    GE.registerFont(FONT);
	                }
	            }
	        }
	    } catch (FontFormatException | IOException exception) {
	        JOptionPane.showMessageDialog(null, exception.getMessage());
	    }
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
	       
	       g2.setColor(player.c);  
	       g2.fillRect(player.x,player.y,player.w,player.h);
	       
	       
	       for (Player pared : obstaculos) {
	    	   
	    	   g2.setColor(pared.c);
		       g2.fillRect(pared.x, pared.y, pared.w, pared.h);
		        
	       }
	       
	       
	        
	   }
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		timer.start(); 
		timer2.start();
		
		lastPress = e.getKeyCode();
		
		update();
		
		//panel_2.repaint();
	}
	
	public void update()
	{
		Boolean m = true;
		for (Player pared : obstaculos) {
			if(player.colision(pared)) {
				m = false;
			}
		}
		
		if(m) {
			shadow.x = player.x;
			shadow.y = player.y;
		}
		
		if(lastPress == 87) { 
			
			if(m)
				player.y-=1;
			else {
				player.y = shadow.y;
				player.x = shadow.x; 
				
				lastPress = 0;
				
			} 
		}
		if(lastPress == 83) {
			
			if(m)
				player.y+=1;
			else {
				player.y = shadow.y;
				player.x = shadow.x;
				lastPress = 0;
			}
			 
			
		}
		if(lastPress == 65) {
			
			if(m)
				player.x-=1;
			else {
				player.y = shadow.y;
				player.x = shadow.x;
				lastPress = 0; 
			}
			 
		}
		if(lastPress == 68) {
			
			if(m)
				player.x+=1;
			else {
				player.y = shadow.y;
				player.x = shadow.x;
				lastPress = 0;
			}
			 
		}
		
		panel_2.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	class Player {
		
		int x=0,y=0,w=0,h=0;
		Color c= Color.black;
		
		public Player(int x, int y, int w, int h, Color c) {
			
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.c = c;
		}
		
		public Boolean colision(Player target) { 
			
			if(this.x < target.x + target.w &&
	                this.x + this.w > target.x &&
	                this.y < target.y + target.h &&
	                this.y + this.h > target.y) {
				
				
				return true;
			}
			return false;
			
		}
	}
	

}
