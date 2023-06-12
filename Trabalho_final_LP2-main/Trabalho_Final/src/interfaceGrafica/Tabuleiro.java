package interfaceGrafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Tabuleiro {

	static Jogador player_red = new Jogador("Harry", "red");
	static Jogador player_blue = new Jogador("Potter", "blue");

	private static Timer animaçãoVermelhoX;
	private static Timer animaçãoAzulX;
	private static Timer animaçãoVermelhoY;
	private static Timer animaçãoAzulY;
	private static Timer adicionarCarta;
	private static Timer tempoDeEspera;

	private static CartaPergunta carta;
	//carta = new CartaPergunta();
	
	private static int contadorAnimadoVermelho;
	private static int contadorAnimadoAzul;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		

			public void run() {
				try {
					chamaTabuleiro();
					// Exibição da janela.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void chamaTabuleiro() {
		
		int contadorVermelho = contadorAnimadoVermelho;
		int contadorAzul = contadorAnimadoAzul;
		
		// Criação da janela principal.
		JFrame frame = new JFrame("Projeto LP2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1020, 720);

		// Criação de um painel.
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Criação de um rótulo com uma imagem.
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Tabuleiro.class.getResource("./assets/map_scaled.png")));
		label.setBounds(0, 0, 1020, 720);
		panel.add(label);

		// Mostra o gato vermelho na tela.
		JLabel playerRedIcon = new JLabel(Manipulacao.getNomeCliente()/*player_red.getNome()*/);
		playerRedIcon.setIcon(new ImageIcon(Tabuleiro.class.getResource(player_red.getAtualSprite())));
		playerRedIcon.setBounds(player_red.getPosiçãoInicialX(), player_red.getPosiçãoInicialY(), 100, 52);
		panel.add(playerRedIcon);

		// Mostra o gato azul na tela.
		JLabel playerBlueIcon = new JLabel(player_blue.getNome());
		playerBlueIcon.setIcon(new ImageIcon(Tabuleiro.class.getResource(player_blue.getAtualSprite())));
		playerBlueIcon.setBounds(player_blue.getPosiçãoInicialX(), player_blue.getPosiçãoInicialY(), 100,
				52);
		panel.add(playerBlueIcon);

		panel.setComponentZOrder(label, 1);
		panel.setComponentZOrder(playerRedIcon, 0);
		panel.setComponentZOrder(playerBlueIcon, 0);

		frame.setVisible(true);

		// Função para mover gato vermelhinho
		animaçãoVermelhoX = new Timer(10, e -> {
			// Código a ser executado a cada 0,1 milissegundos
			player_red.mover();
			playerRedIcon.setIcon(new ImageIcon(Tabuleiro.class.getResource(player_red.getAtualSprite())));
			playerRedIcon.setBounds(player_red.getPosiçãoAtualX(), player_red.getPosiçãoAtualY(), 100, 52);

			if (contadorAnimadoVermelho == player_red.getMovimento()) {
				player_red.setAtualSprite(player_red.getFrontSprite());
				playerRedIcon.setIcon(new ImageIcon(Tabuleiro.class.getResource(player_red.getAtualSprite())));
				player_red.setCasaAtual(player_red.getCasaAtual() + 1);
				System.out.println(player_red.getCasaAtual());
				contadorAnimadoVermelho = 0;

				adicionarCarta.start();
				animaçãoVermelhoX.stop();
			}

			contadorAnimadoVermelho++;
		});

		animaçãoAzulX = new Timer(10, e -> {
			// Código a ser executado a cada 0,1 milissegundos

			player_blue.mover();

			playerBlueIcon
					.setIcon(new ImageIcon(Tabuleiro.class.getResource(player_blue.getAtualSprite())));
			playerBlueIcon.setBounds(player_blue.getPosiçãoAtualX(), player_blue.getPosiçãoAtualY(), 100,
					52);

			if (contadorAnimadoAzul == 105) {
				player_blue.setAtualSprite(player_blue.getFrontSprite());
				playerBlueIcon
						.setIcon(new ImageIcon(Tabuleiro.class.getResource(player_blue.getAtualSprite())));
				player_blue.setCasaAtual(player_blue.getCasaAtual() + 1);
				System.out.println(player_blue.getCasaAtual());
				contadorAnimadoAzul = 0;

				adicionarCarta.start();
				animaçãoAzulX.stop();
			}

			contadorAnimadoAzul++;
		});

		// Adiciona Carta.
		adicionarCarta = new Timer(10, e -> {
			
			try {
				carta = new CartaPergunta();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			carta.getFrame().setVisible(true);
			adicionarCarta.stop();

		});
		
		tempoDeEspera = new Timer(12000, e2 -> {
			try {
				//alterei para andar com resposta do servidor
				if (Manipulacao.getRespostaServidor().equals(Manipulacao.getNomeCliente() + " " + "acertou")) {
					animaçãoVermelhoX.start();
					tempoDeEspera.start();
				}else { 
					adicionarCarta.start();
				}
			} catch (IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		tempoDeEspera.start();
		
		

		animaçãoVermelhoX.start();
		animaçãoAzulX.start();

		if (carta.isHit_miss()) {
			animaçãoVermelhoX.start();
		}
	}

}