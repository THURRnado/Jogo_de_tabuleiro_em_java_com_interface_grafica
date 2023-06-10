package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceDeTeste {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceDeTeste window = new InterfaceDeTeste();
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
	public InterfaceDeTeste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 227, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(InterfaceDeTeste.class.getResource("/dadoProjetoLP2TamanhoMenor.png")));
		lblNewLabel.setBounds(26, 11, 174, 180);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("aumentar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBounds(0, 0, 434, 261);
			}
		});
		btnNewButton.setBounds(69, 177, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("diminuir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBounds(0, 0, 227, 261);
			}
		});
		btnNewButton_1.setBounds(69, 213, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(224, 0, 210, 261);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(InterfaceDeTeste.class.getResource("/fundoCartaPergunta.jpg")));
		lblNewLabel_1.setBounds(0, 0, 210, 261);
		panel_1.add(lblNewLabel_1);
	}
}
