package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Rectangle;

public class TelaDeAddJogador {

	private JFrame frmAdicionarJogador;
	private JTextField txtNomeJogador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeAddJogador window = new TelaDeAddJogador();
					window.getFrmAdicionarJogador().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaDeAddJogador() {
		initialize();
	}

	private void initialize() {
		setFrmAdicionarJogador(new JFrame());
		getFrmAdicionarJogador().setTitle("Gledson Game");
		getFrmAdicionarJogador().getContentPane().setBackground(new Color(191, 255, 191));
		frmAdicionarJogador.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Gledson Game");
		lblNewLabel.setBounds(429, 81, 394, 125);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(new Color(210, 180, 140));
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 49));
		getFrmAdicionarJogador().getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Esperando outro jogador...");
		lblNewLabel_1.setBounds(440, 250, 385, 94);
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.PLAIN, 25));
		getFrmAdicionarJogador().getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);


		JButton btnNewButton_1 = new JButton("Entrar na sala");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton_1.setEnabled(false);
				Thread t1 = new Thread(()->{
					try {
						lblNewLabel_1.setVisible(true);
						Cliente.iniciarCliente();

					} catch (InterruptedException | IOException e1) {
						e1.printStackTrace();
					}
				});
				t1.start();

				Thread t2 = new Thread(()->{
					try {
						Cliente.lockLiberar.acquire();
						Cliente.lockNome.acquire();
						Tabuleiro.criarTabuleiro("Harry", "Potter", Cliente.getCor());
						Tabuleiro.movimentarAzul();
						Tabuleiro.movimentarVermelho();
						Cliente.lockNome.release();
						Cliente.lockLiberar.release();
						getFrmAdicionarJogador().dispose();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					while(true) {
						Tabuleiro.teste();
					}
				});
				t2.start();
				
				/*Thread t3 = new Thread(()->{
					try {
						Cliente.lockLiberar.acquire();
						Cliente.lockNome.acquire();
						Chat chat = new Chat();
						Chat.initialize();
						chat.setChatVisible(true);
						Cliente.lockNome.release();
						Cliente.lockLiberar.release();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				t3.start();*/

			}
		});
		
		btnNewButton_1.setBounds(419, 353, 385, 94);
		btnNewButton_1.setForeground(new Color(139, 69, 19));
		btnNewButton_1.setBackground(new Color(210, 180, 140));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 22));
		getFrmAdicionarJogador().getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBounds(419, 492, 385, 94);
		btnNewButton_2.setForeground(new Color(139, 69, 19));
		btnNewButton_2.setBackground(new Color(210, 180, 140));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaDeInicio window = new TelaDeInicio();
							window.getFrmTelaDeInicio().setVisible(true);
							getFrmAdicionarJogador().dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 22));
		frmAdicionarJogador.getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(550, 173, 124, 85);
		lblNewLabel_2.setIcon(new ImageIcon(TelaDeAddJogador.class.getResource("/gatoLP2.png")));
		frmAdicionarJogador.getContentPane().add(lblNewLabel_2);
		getFrmAdicionarJogador().setForeground(Color.GRAY);
		getFrmAdicionarJogador().setBounds(0, 0, 1240, 720);
		
	}

	public JFrame getFrmAdicionarJogador() {
		return frmAdicionarJogador;
	}

	public void setFrmAdicionarJogador(JFrame frmAdicionarJogador) {
		this.frmAdicionarJogador = frmAdicionarJogador;
		frmAdicionarJogador.setBounds(new Rectangle(100, 0, 1240, 720));
		frmAdicionarJogador.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDeAddJogador.class.getResource("/emojiParaProjetoJava.png")));
	}
}
