package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONObject;

import controllers.ProductController;
import models.User;
import views.ProductView.ButtonEditor;
import views.ProductView.ButtonRenderer;

public class UserView {

	public UserView() {
		// TODO Auto-generated constructor stub
	}
	
	public void showUsers(ArrayList<User> users)
	{
		JFrame ventana = new JFrame();
		ventana.setBounds(100, 100, 920, 534);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true); 
		
		JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        ventana.getContentPane().add(panel); 
        
        // ---------- TÍTULO ----------
        JLabel lblTitle = new JLabel("USUARIOS", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panel.add(lblTitle, BorderLayout.NORTH);
        
        JPanel contenido = new JPanel();
        panel.add(contenido, BorderLayout.CENTER);
        contenido.setLayout(null);
        
        int y = 35;
        for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			
			
			JLabel userlabel = new JLabel(user.name, SwingConstants.CENTER);
			userlabel.setFont(new Font("SansSerif", Font.BOLD, 24));
			userlabel.setBounds(35, y, 200, 40);
			contenido.add(userlabel);
			
			y+=45;
		}
        
        
	}

}
