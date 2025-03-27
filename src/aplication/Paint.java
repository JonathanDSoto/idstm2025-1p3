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
	
	private ArrayList<Point> puntos = new ArrayList<Point>();
	
	List<List<Point>> listaDePuntos = new ArrayList<>(); 
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
		
		JButton btnNewButton_1 = new JButton("-");
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("+");
		panel_1.add(btnNewButton_2);
		
		panel_2 = new PaintPanel();
		
		panel_2.addMouseListener(this);
		panel_2.addMouseMotionListener(this);
		
		panel.add(panel_2, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		//crear una copia de los puntos
		ArrayList ArrList2  = (ArrayList)puntos.clone();
		
		//se guarda en el historial de dibujos
		listaDePuntos.add(ArrList2);
		
		//limpiamos el trazo actual
		puntos.clear();
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) { 
		
	}

	@Override
	public void mouseExited(MouseEvent e) { 
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		panel_2.repaint();
		
		puntos.add(e.getPoint());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) { 
		
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
	    		   
	    		   Point p1 = puntos.get(i-1);
	    		   Point p2 = puntos.get(i);
	    		   
	    		   g2.drawLine(p1.x,p1.y,p2.x,p2.y);
	    	   }
	    	   
	       }
	       
	       for (Iterator iterator = listaDePuntos.iterator(); iterator.hasNext();) {
			List<Point> trazo = (List<Point>) iterator.next();
			
				if(trazo.size()>1) {
		    	   
		    	   for (int i = 1; i < trazo.size(); i++) {
		    		   
		    		   Point p1 = trazo.get(i-1);
		    		   Point p2 = trazo.get(i);
		    		   
		    		   g2.drawLine(p1.x,p1.y,p2.x,p2.y);
		    	   }
		    	   
		       }
			
	       }
	   }
		
	}

}
