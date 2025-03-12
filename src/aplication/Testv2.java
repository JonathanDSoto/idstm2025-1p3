package aplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Testv2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testv2 window = new Testv2();
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
	public Testv2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 642, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(213, 255, 20), 15, true));
		panel.setBackground(new Color(213, 255, 20));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(10, 10));

		JLabel lblNewLabel = new JLabel("Registro de usuarios");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setForeground(new Color(239, 19, 29));
		lblNewLabel.setBackground(new Color(239, 19, 29));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(213, 255, 39));
		panel.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 377, 0, 0, 0, 0 }; // Mejor dejar en 0 para que se ajusten dinámicamente
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 0.0 }; // Distribuir el espacio horizontalmente
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 0.0 }; // Que las filas crezcan de manera uniforme
		panel_1.setLayout(gbl_panel_1);

		JPanel panel_5 = new JPanel();
		panel_5.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_5.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_5.setBackground(new Color(208, 170, 253));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(0, 0, 4, 4);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_1.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 25));

		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_5.add(lblNewLabel_2);

		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_5.add(lblNewLabel_3);

		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_5.add(btnNewButton);

		JPanel panel_4 = new JPanel();
		panel_4.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_4.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_4.setBorder(new TitledBorder(null, "Perfil de usuario ", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(59, 25, 53)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.SOUTHEAST;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		panel_1.add(panel_4, gbc_panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setLocation(93, 25);
		lblNewLabel_1.setSize(110, 127);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/jonathan/eclipse-workspace/idstm2025-1p3/wifi-connection.png"));
		panel_4.add(lblNewLabel_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(6, 158, 128, 23);
		panel_4.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setBounds(146, 158, 128, 23);
		panel_4.add(chckbxNewCheckBox_1);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		panel_2.setBackground(new Color(44, 153, 247));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.WEST;
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setAlignmentY(Component.TOP_ALIGNMENT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.NORTH;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 1;
		panel_1.add(panel_3, gbc_panel_3);
	}

}
