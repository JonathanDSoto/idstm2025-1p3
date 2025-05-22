package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        ventana.getContentPane().add(panel);
        
        
        // ---------- TÍTULO ----------
        JLabel lblTitle = new JLabel("PRODUCTOS", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panel.add(lblTitle, BorderLayout.NORTH);

        // ---------- BOTÓN AÑADIR ----------
        JPanel topPanel = new JPanel(new FlowLayout());
        JButton addBtn = new JButton("Añadir producto");
        addBtn.addActionListener(e -> {
            ventana.dispose();
            new ProductController().add();
        });
        topPanel.add(addBtn);
        panel.add(topPanel, BorderLayout.SOUTH);

        // ---------- DATOS PARA LA TABLA ----------
        String[] columnas = {"Título", "Categoría", "Precio", "Acción"};
        Object[][] filas = new Object[data.size()][4];

        for (int i = 0; i < data.size(); i++) {
            JSONObject p = (JSONObject) data.get(i);
            filas[i][0] = p.get("title");
            filas[i][1] = p.get("category");
            filas[i][2] = "$" + p.get("price").toString();
            filas[i][3] = "Eliminar";
        }

        DefaultTableModel model = new DefaultTableModel(filas, columnas) {
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Solo el botón "Eliminar" es editable
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.getColumn("Acción").setCellRenderer(new ButtonRenderer());
        table.getColumn("Acción").setCellEditor(new ButtonEditor(new JCheckBox(), data));

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);  
		

		 
	}
	
	public void add()
	{
		
		JFrame ventana = new JFrame();
		
		ventana.setBounds(100, 100, 920, 534);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		ventana.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel titulo = new JLabel("Añadir producto");
		titulo.setFont(new Font("SansSerif", Font.BOLD, 26));
		titulo.setBounds(320, 20, 300, 40);
		panel.add(titulo);

		int inputWidth = 400;
		int inputHeight = 30;
		int labelX = 100;
		int inputX = 250;
		int y = 80;
		int spacing = 50;

		JLabel titleLabel = new JLabel("Título del producto:");
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		titleLabel.setBounds(labelX, y, 150, 30);
		panel.add(titleLabel);

		JTextField titleInput = new JTextField();
		titleInput.setBounds(inputX, y, inputWidth, inputHeight);
		panel.add(titleInput);

		y += spacing;
		JLabel descLabel = new JLabel("Descripción:");
		descLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		descLabel.setBounds(labelX, y, 150, 30);
		panel.add(descLabel);

		JTextArea descInput = new JTextArea();
		descInput.setLineWrap(true);
		descInput.setWrapStyleWord(true);
		descInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		descInput.setBounds(inputX, y, inputWidth, 80);
		panel.add(descInput);

		y += 90;
		JLabel catLabel = new JLabel("Categoría:");
		catLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		catLabel.setBounds(labelX, y, 150, 30);
		panel.add(catLabel);

		String[] categories = { "beauty", "electronics", "fashion", "home", "sports" };
		JComboBox<String> categoryInput = new JComboBox<>(categories);
		categoryInput.setBounds(inputX, y, inputWidth, inputHeight);
		panel.add(categoryInput);

		y += spacing;
		JLabel priceLabel = new JLabel("Precio ($):");
		priceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		priceLabel.setBounds(labelX, y, 150, 30);
		panel.add(priceLabel);

		JTextField priceInput = new JTextField();
		priceInput.setBounds(inputX, y, inputWidth, inputHeight);
		panel.add(priceInput);

		y += 70;
		JButton addBtn = new JButton("Añadir producto");
		addBtn.setBounds(inputX + 210, y, 190, 40);
		addBtn.setBackground(new Color(33, 150, 243)); 
		addBtn.setOpaque(true);
		addBtn.setForeground(Color.BLACK);
		addBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(addBtn);

		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(inputX, y, 190, 40);
		cancelBtn.setBackground(new Color(220, 53, 69));
		cancelBtn.setForeground(Color.BLACK);
		cancelBtn.setOpaque(true);
		cancelBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(cancelBtn);

		addBtn.addActionListener(e -> {
		    try {
		        String title = titleInput.getText();
		        String desc = descInput.getText();
		        String category = categoryInput.getSelectedItem().toString();
		        double price = Double.parseDouble(priceInput.getText());

		        ProducModel pm = new ProducModel();
		        pm.addProduct(title, desc, category, price);

		        ventana.dispose();

		        ProductController pc = new ProductController();
		        pc.products();
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(ventana, "Precio inválido", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		});

		cancelBtn.addActionListener(e -> ventana.dispose()); 
		
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
	
	// ---------- RENDERER PARA EL BOTÓN ----------
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // ---------- EDITOR PARA EL BOTÓN ----------
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean clicked;
        private List<Object> data;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox, List<Object> data) {
            super(checkBox);
            this.data = data;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            clicked = true;
            selectedRow = row;
            return button;
        }

        public Object getCellEditorValue() {
            if (clicked) {
                JSONObject product = (JSONObject) data.get(selectedRow);
                System.out.println("Eliminar ID: " + product.get("id"));
                new ProducModel().remove(); // <-- Puedes pasar el ID aquí

                // Refrescar vista
                SwingUtilities.getWindowAncestor(button).dispose();
                new ProductController().products();
            }
            clicked = false;
            return label;
        }

        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}
