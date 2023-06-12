package interfaceGrafica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Deck extends DeckInterface {
	public static int numCarta;
	public static String cartaConteudo;
	public static boolean hit_miss;
	ArrayList<Integer> randonsExistentes = new ArrayList<>();

	public Deck() {
		this.hit_miss = false;
		this.randonsExistentes = randonsExistentes;
	}

	public void generateRandomQuestion(int questionIndex) {
		System.out.println(idNum.get(questionIndex) + ":" + pergunta.get(questionIndex) + "\n a) Sim b) Não");
	}

	public String verificarAcerto(String resposta, int questionIndex) {
        if (respostasCorretas.get(questionIndex).equalsIgnoreCase(resposta)) {
            return "Acertou";
        } else {
            // System.out.println("Você errou!");
            return "Errou!";
        }
    }

	public Boolean verifyBool(String x) throws IOException, InterruptedException {
        if (x.equalsIgnoreCase("Acertou")) {
            Manipulacao.writeAtualizacao("acertou");
            System.out.println(Manipulacao.getRespostaServidor());
            return true;
        }
        else {
            Manipulacao.writeAtualizacao("errou");
            System.out.println(Manipulacao.getRespostaServidor());
            return false;
        }
    }

	public void getQuestion(Deck n) {
		Cartas num_pergunta = new Cartas();// pegando o indice e a pergunta de carta
		int randomIndex;
		do {
			randomIndex = Cartas.numCard();
		} while (randonsExistentes.contains(randomIndex));
		randonsExistentes.add(randomIndex);
		n.generateRandomQuestion(randomIndex);
		num_pergunta.numCarta = randomIndex;
		num_pergunta.cartaConteudo = pergunta.get(randomIndex);
	}

	public static void main(String[] args) {
	}
}