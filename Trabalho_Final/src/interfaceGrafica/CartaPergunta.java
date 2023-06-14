package interfaceGrafica;

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
import java.awt.Window;
import java.awt.Color;


public class CartaPergunta{
	
	private int segundos;
	private JFrame frame;
	public boolean hit_miss;
	
	private Timer timerNewCard; 
	private CartaPergunta newCard;	
	
	public CartaPergunta() throws InterruptedException{
		
		Cartas carta = new Cartas();
		Deck deck = new Deck();
		createNextCard(carta, deck);
	}
	
	private void createNextCard(Cartas carta, Deck deck) throws InterruptedException {
		carta.getMyQuestion();
		showCard(carta, deck);
	}
	
	private void showCard(Cartas carta, Deck deck) {
		frame = new JFrame();
		frame.setBounds(360, 150, 640, 400);
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
		defineContador(lblNewLabel, 15);

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
				String str = deck.verificarAcerto("Sim", Cartas.numCarta);
				deck.verificarAcerto("Sim", Cartas.numCarta);
				try {
					hit_miss = deck.verifyBool(str);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println(hit_miss);
				frame.dispose();
				//JOptionPane.showMessageDialog(btnNewButton, d.verificarAcerto("Sim", Cartas.numCarta), null, 3);
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = deck.verificarAcerto("Não", Cartas.numCarta);
				deck.verificarAcerto("Não", Cartas.numCarta);
				try {
					hit_miss = deck.verifyBool(str);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println(hit_miss);
				frame.dispose();
				//JOptionPane.showMessageDialog(btnNewButton, d.verificarAcerto("Não", Cartas.numCarta), null, 3);

			}
		});
	}
	
	public void defineContador(JLabel label, int segundos) {
		
		this.segundos = segundos;
		
		Timer timer = new Timer(1000, e -> {
			this.segundos--;
			fecharJanela();
			label.setText("" + this.segundos);
			
		});
		timer.start();
	
	}
	
	
	public synchronized void fecharJanela() {
		if (this.segundos == 0) {
			this.hit_miss = false;
			frame.dispose();
			timerNewCard = new Timer(5000, e -> {
				try {
					newCard = new CartaPergunta();
					newCard.getFrame().setVisible(true);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				timerNewCard.stop();
			});
			timerNewCard.start();
		}
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
	
	
}