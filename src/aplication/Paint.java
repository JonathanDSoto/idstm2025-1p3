package aplication;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.GridLayout;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;

public class Paint implements MouseListener, MouseMotionListener {

	private JFrame frame;
	private PaintPanel panel_2;
	
	private int tool = 1,grosor = 3;
	public Color color = Color.black;
	
	private ArrayList<MyPoint> puntos = new ArrayList<MyPoint>();
	private ArrayList<Figura> figuras = new ArrayList<Figura>();
	List<List<MyPoint>> listaDePuntos = new ArrayList<>(); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint window = new Paint();
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
	public Paint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 839, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Limpiar");
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("1");
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				grosor -= 1;
				lblNewLabel.setText(grosor+"");
			}
			
		});
		panel_1.add(btnNewButton_1);
		
		
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				grosor += 1;
				lblNewLabel.setText(grosor+"");
			}
			
		});
		panel_1.add(btnNewButton_2);
		
		JButton brocha = new JButton("brocha");
		brocha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tool = 1;
			}
			
		});
		panel_1.add(brocha);
		
		JButton cuadrado = new JButton("cuadrado");
		cuadrado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tool = 2;
			}
			
		});
		panel_1.add(cuadrado);
		
		JButton rojo = new JButton("");
		rojo.setOpaque(true);
		rojo.setBackground(Color.red);
		rojo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.red;
			}
			
		});
		panel_1.add(rojo);
		
		JButton azul = new JButton("");
		azul.setOpaque(true);
		azul.setBackground(Color.blue);
		azul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.blue;
			}
			
		});
		panel_1.add(azul);
		
		panel_2 = new PaintPanel();
		
		panel_2.addMouseListener(this);
		panel_2.addMouseMotionListener(this);
		
		panel.add(panel_2, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(tool == 2) {
			
			figuras.add(new Figura(e.getX(),e.getY(),80,80));
			panel_2.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(tool == 1) { 
			//crear una copia de los puntos
			ArrayList ArrList2  = (ArrayList)puntos.clone();
			
			//se guarda en el historial de dibujos
			listaDePuntos.add(ArrList2);
			
			//limpiamos el trazo actual
			puntos.clear();
		
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) { 
		
	}

	@Override
	public void mouseExited(MouseEvent e) { 
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(tool == 1) {
			panel_2.repaint();
			
			
			puntos.add(new MyPoint(e.getX(),e.getY(),grosor,color));
			
			
		}
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) { 
		panel_2.repaint();
	}
	
	class PaintPanel extends JPanel{
		
		public PaintPanel()
		{
			this.setBackground(Color.white);
		}
		
		@Override
	   public void paintComponent(Graphics g) {
	       super.paintComponent(g);
	       
	       Graphics2D g2 = (Graphics2D) g; 
	       g2.setColor(Color.black); 
	       g2.setStroke(new BasicStroke(3)); 
		   
	       //dibujar la trayectoria de puntos 
	       //solo cuando tengo más de 2 puntos
	       if(puntos.size()>1) {
	    	   
	    	   for (int i = 1; i < puntos.size(); i++) {
	    		   
	    		   MyPoint p1 = puntos.get(i-1);
	    		   MyPoint p2 = puntos.get(i);
	    		   
	    		   g2.setStroke(new BasicStroke(p1.g));
	    		   g2.setColor(p1.c); 
	    		   g2.drawLine(p1.x,p1.y,p2.x,p2.y);
	    	   }
	    	   
	       }
	       
	       if(figuras.size()>0) {
	    	   
	    	   for (int i = 1; i < figuras.size(); i++) {
	    		   
	    		   Figura f = figuras.get(i);
	    		   
	    		   g2.drawRect(f.x,f.y,f.w,f.h); 
	    	   }
	    	   
	       }
	       
	       for (Iterator iterator = listaDePuntos.iterator(); iterator.hasNext();) {
			List<MyPoint> trazo = (List<MyPoint>) iterator.next();
			
				if(trazo.size()>1) {
		    	   
		    	   for (int i = 1; i < trazo.size(); i++) {
		    		   
		    		   MyPoint p1 = trazo.get(i-1);
		    		   MyPoint p2 = trazo.get(i);
		    		   
		    		   g2.setStroke(new BasicStroke(p1.g));
		    		   g2.setColor(p1.c); 
		    		   
		    		   g2.drawLine(p1.x,p1.y,p2.x,p2.y);
		    	   }
		    	   
		       }
			
	       }
	   }
		
	}
	
	class Figura{
		
		public int x,y,w,h,t;
		
		public Figura(int x, int y, int w,int h)
		{
			this.x=x;
			this.y = y;
			this.w = w;
			this.h = h;
		} 
		
	}

	class MyPoint{
		
		public int x,y,g;
		
		public Color c;
		
		public MyPoint(int x, int y, int g, Color c) {
			
			this.x = x; 
			this.y = y;
			this.g = g; 
			this.c = c;
		}
	}




}
