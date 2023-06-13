package interfaceGrafica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cartas {
	public static int numCarta;
	public static String cartaConteudo;

	public Cartas() {
		

	}

	// gerar um indice
	public static int numCard() {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(70);
				return numeroAleatorio;
	}

	// pegar a pergunta gerada, e suas respectivas respostas
	// vai sempre gerar uma pergunta, quando jogo for iniciado e enquanto cada
	// resposta for respondida
	public static void getMyQuestion() throws InterruptedException {
		Deck n = new Deck();
		n.getQuestion(n);
	}

	public static void main(String[] args) {

	}

}