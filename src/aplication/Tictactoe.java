package aplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class Tictactoe {

	private JFrame frame;
	public Boolean turno = true;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tictactoe window = new Tictactoe();
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
	public Tictactoe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Tictactoe.class.getResource("/aplication/4th-of-july.png")));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String player = "X";
				if(turno){
					turno = false;
					player = "X";

				}else{
					turno = true;
					player = "O";
				}
				btnNewButton.setText(player);
				btnNewButton.setEnabled(false);
				verificar();
				
			}
		});
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String player = "X";
				if(turno){
					turno = false;
					player = "X";

				}else{
					turno = true;
					player = "O";
				}
				btnNewButton_1.setText(player);
				btnNewButton_1.setEnabled(false);
				verificar();
			}
		});
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		panel.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String player = "X";
				if(turno){
					turno = false;
					player = "X";

				}else{
					turno = true;
					player = "O";
				}
				btnNewButton_2.setText(player);
				btnNewButton_2.setEnabled(false);
				verificar();
			}
		});
		
		JButton btnNewButton_3 = new JButton("");
		panel.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String player = "X";
				if(turno){
					turno = false;
					player = "X";

				}else{
					turno = true;
					player = "O";
				}
				btnNewButton_3.setText(player);
				btnNewButton_3.setEnabled(false);
				verificar();
			}
		});
		
		JButton btnNewButton_4 = new JButton("");
		panel.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String player = "X";
				if(turno){
					turno = false;
					player = "X";

				}else{
					turno = true;
					player = "O";
				}
				btnNewButton_4.setText(player);
				btnNewButton_4.setEnabled(false);
				verificar();
			}
		});
		
		JButton btnNewButton_5 = new JButton("");
		panel.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String player = "X";
				if(turno){
					turno = false;
					player = "X";

				}else{
					turno = true;
					player = "O";
				}
				btnNewButton_5.setText(player);
				btnNewButton_5.setEnabled(false);
				verificar();
			}
		});
		
		JButton btnNewButton_6 = new JButton("");
		panel.add(btnNewButton_6);
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String player = "X";
				if(turno){
					turno = false;
					player = "X";

				}else{
					turno = true;
					player = "O";
				}
				btnNewButton_6.setText(player);
				btnNewButton_6.setEnabled(false);
				verificar();
			}
		});
		
		JButton btnNewButton_7 = new JButton("");
		panel.add(btnNewButton_7);
		btnNewButton_7.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String player = "X";
				if(turno){
					turno = false;
					player = "X";

				}else{
					turno = true;
					player = "O";
				}
				btnNewButton_7.setText(player);
				btnNewButton_7.setEnabled(false);
				verificar();
			}
		});
		
		JButton btnNewButton_8 = new JButton("");
		panel.add(btnNewButton_8);
		btnNewButton_8.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.LINE_END);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_9 = new JButton("Reiniciar");
		btnNewButton_9.setMinimumSize(new Dimension(100,100)); 
		panel_2.add(btnNewButton_9);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String player = "X";
				if(turno){
					turno = false;
					player = "X";

				}else{
					turno = true;
					player = "O";
				}
				btnNewButton_8.setText(player);
				btnNewButton_8.setEnabled(false);
				verificar();
			}
		});
	}
	
	public void verificar()
	{
		
		if(btnNewButton.getText().equals(btnNewButton_1.getText())
			&& 
			btnNewButton_1.getText().equals(btnNewButton_2.getText())
			&& 
			!btnNewButton.getText().equals("")
				) {
			
			System.out.println("Hola");
		}
		
	 
		
	}

}
