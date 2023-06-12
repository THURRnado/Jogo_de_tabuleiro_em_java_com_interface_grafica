package interfaceGrafica;

//panel.setComponentZOrder(lblNewLabel, 1); precisa ser a ultima coisa colocada
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

/*

 */

public class CartaPergunta {
	private int segundos = 30;
	private JFrame frame;
	private static Boolean trocaCarta = false;
	private Semaphore semaphore = new Semaphore(1);
	public boolean hit_miss;
	Manipulacao m = new Manipulacao();


	public void setHit_miss(boolean hit_miss) {
		this.hit_miss = hit_miss;
	}

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

	public CartaPergunta() throws InterruptedException {
		initialize();
	}

	private void initialize() throws InterruptedException {
		Cartas c = new Cartas();
		Deck d = new Deck();
		createNextCard(c, d);
	}

	private void createNextCard(Cartas c, Deck d) throws InterruptedException {
		c.getMyQuestion();
		showCard(c, d);
		this.hit_miss = Deck.hit_miss;
		// System.out.println("testando: "+hit_miss);
	}

	private void showCard(Cartas c, Deck d) {
		frame = new JFrame();
		frame.setBounds(365, 150, 640, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 640, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(295, 25, 52, 47);
		panel.add(lblNewLabel);
		defineContador(lblNewLabel, 10);

		JLabel lblNewLabel_1 = new JLabel("<html>" + Cartas.cartaConteudo + "</html>");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(80, 65, 502, 122);
		panel.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Sim");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(34, 197, 94));
		btnNewButton.setBounds(128, 271, 114, 47);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Não");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(220, 38, 38));
		btnNewButton_1.setBounds(394, 271, 122, 47);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CartaPergunta.class.getResource("./assets/carta.png")));
		lblNewLabel_2.setBounds(0, 0, 640, 400);
		panel.add(lblNewLabel_2);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = d.verificarAcerto("Sim", Cartas.numCarta);
				d.verificarAcerto("Sim", Cartas.numCarta);
				try {
					hit_miss = d.verifyBool(str);
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(hit_miss);
				frame.dispose();
				//JOptionPane.showMessageDialog(btnNewButton, d.verificarAcerto("Sim", Cartas.numCarta), null, 3);
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = d.verificarAcerto("Não", Cartas.numCarta);
				d.verificarAcerto("Não", Cartas.numCarta);
				try {
					hit_miss = d.verifyBool(str);
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(hit_miss);
				frame.dispose();
				//JOptionPane.showMessageDialog(btnNewButton, d.verificarAcerto("Não", Cartas.numCarta), null, 3);

			}
		});
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
		if (this.segundos == 0) {
			this.hit_miss = false;
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

	public boolean isHit_miss() {
		return hit_miss;
	}


}
