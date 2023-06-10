package interfaceGrafica;

//panel.setComponentZOrder(lblNewLabel, 1); precisa ser a ultima coisa colocada

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class CartaPergunta {

	private int segundos = 30;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartaPergunta window = new CartaPergunta();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CartaPergunta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(365, 150, 640, 400);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 640, 400);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(294, 0, 52, 47);
		panel.add(lblNewLabel);
		defineContador(lblNewLabel, 10);
		
		JLabel lblNewLabel_1 = new JLabel("A pergunta ficará aqui");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(69, 58, 502, 122);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Verdadeiro");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(191, 255, 191));
		btnNewButton.setBounds(128, 271, 114, 47);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Falso");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(255, 89, 89));
		btnNewButton_1.setBounds(394, 271, 122, 47);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CartaPergunta.class.getResource("/fundoCartaPergunta.jpg")));
		lblNewLabel_2.setBounds(0, 0, 640, 400);
		panel.add(lblNewLabel_2);

		
	}
	
	public void defineContador(JLabel label, int segundos) {
		
		setSegundos(segundos);
		
		Timer timer = new Timer(1000, e -> {
            this.segundos--;
            fecharJanela();
            label.setText("" + this.segundos);
        });
        timer.start();
       
	}
	
	public void fecharJanela() {
		if(this.segundos == 0) {
        	frame.dispose();
        }
	}
	
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
