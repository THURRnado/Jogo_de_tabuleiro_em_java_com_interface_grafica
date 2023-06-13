package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
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
	


	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public TelaDeAddJogador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmAdicionarJogador(new JFrame());
		getFrmAdicionarJogador().setTitle("Adicionar jogador");
		getFrmAdicionarJogador().getContentPane().setBackground(new Color(191, 255, 191));
		frmAdicionarJogador.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gledson Game");
		lblNewLabel.setBounds(429, 81, 394, 125);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(new Color(210, 180, 140));
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 49));
		getFrmAdicionarJogador().getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adicionar jogador:");
		lblNewLabel_1.setBounds(155, 433, 254, 42);
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.PLAIN, 25));
		getFrmAdicionarJogador().getContentPane().add(lblNewLabel_1);
		
		txtNomeJogador = new JTextField();
		txtNomeJogador.setBounds(419, 431, 345, 42);
		txtNomeJogador.setFont(new Font("Verdana", Font.PLAIN, 14));
		getFrmAdicionarJogador().getContentPane().add(txtNomeJogador);
		txtNomeJogador.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(774, 430, 187, 42);
		btnNewButton.setForeground(new Color(139, 69, 19));
		btnNewButton.setBackground(new Color(210, 180, 140));
		btnNewButton.setToolTipText("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtNomeJogador.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Um nome de usuário precisa ser inserido!", null, JOptionPane.WARNING_MESSAGE);
				}else {					
					
					JOptionPane.showMessageDialog(null, txtNomeJogador.getText() + ".txt");
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		getFrmAdicionarJogador().getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Iniciar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//Conecta com o Servidor
							Tabuleiro.criarTabuleiro("Harry", "Potter", "red");
							Tabuleiro.movimentarAzul();
							Tabuleiro.movimentarVermelho();

							while(true) {
							Tabuleiro.teste();
						    
						}} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});*/
				
				Thread t1 = new Thread(()->{
					try {
						Cliente.iniciarCliente();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				t1.start();
				
				Thread t3 = new Thread(()->{
					Tabuleiro.criarTabuleiro("Harry", "Potter", "red");
					Tabuleiro.movimentarAzul();
					Tabuleiro.movimentarVermelho();

					while(true) {
					Tabuleiro.teste();
					}
				});
				t3.start();
				
			}
		});
		btnNewButton_1.setBounds(826, 617, 187, 42);
		btnNewButton_1.setForeground(new Color(139, 69, 19));
		btnNewButton_1.setBackground(new Color(210, 180, 140));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		getFrmAdicionarJogador().getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBounds(1027, 617, 187, 42);
		btnNewButton_2.setForeground(new Color(139, 69, 19));
		btnNewButton_2.setBackground(new Color(210, 180, 140));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaDeInicio window = new TelaDeInicio();
							window.getFrmTelaDeInicio().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		frmAdicionarJogador.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(544, 173, 124, 85);
		lblNewLabel_2.setIcon(new ImageIcon(TelaDeAddJogador.class.getResource("/gatoLP2.png")));
		frmAdicionarJogador.getContentPane().add(lblNewLabel_2);
		getFrmAdicionarJogador().setForeground(Color.GRAY);
		getFrmAdicionarJogador().setBounds(0, 0, 1020, 720);
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
