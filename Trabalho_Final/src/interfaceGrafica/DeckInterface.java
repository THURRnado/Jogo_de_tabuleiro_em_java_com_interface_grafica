package interfaceGrafica;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class DeckInterface extends Cartas {
	public static ArrayList<String> idNum, pergunta, respostas, respostasCorretas;
	static String dataBaseCards[] = {
			"Pergunta 1: Threads são uma forma de um processo executar tarefas concorrentemente?, *a) Sim, b) Não,",
			"Pergunta 2: Uma thread de execução é a maior sequência de instruções programadas que pode ser gerenciada independentemente por um escalonador?, *a) Sim, b) Não",
			"Pergunta 3: É correto afirmar threads não permitem que um processo divida a si mesmo em duas ou mais tarefas?, a) Sim, b) *Não",
			"Pergunta 4: As threads são exclusivas para o curso ciência da computação?, a) Sim, *b) Não",
			"Pergunta 5: As threads podem compartilhar recursos e dados com outras threads do mesmo processo?, *a) Sim, b) Não",
			"Pergunta 6: Uma única thread é capaz de executar várias tarefas simultaneamente?, a) Sim, *b) Não",
			"Pergunta 7: As threads são independentes umas das outras e não têm nenhum relacionamento entre si?, *a) Sim, b) Não",
			"Pergunta 8: As threads podem ser criadas e destruídas dinamicamente durante a execução de um programa?, *a) Sim, b) Não",
			"Pergunta 9: Cada thread de um processo tem seu próprio espaço de memória separado?, *a) Sim, b) Não",
			"Pergunta 10: As threads podem executar em paralelo em sistemas de processadores com múltiplos núcleos?, *a) Sim, b) Não",
			"Pergunta 11: As threads oferecem um mecanismo eficiente para lidar com operações de entrada e saída bloqueantes?, *a) Sim, b) Não",
			"Pergunta 12: Um processo com várias threads é sempre mais rápido do que um processo com apenas uma thread?, a) Sim, *b) Não",
			"Pergunta 13: As threads podem ser usadas para melhorar a capacidade de resposta de um programa?, *a) Sim, b) Não",
			"Pergunta 14: As threads são uma forma de paralelismo?, *a) Sim, b) Não",
			"Pergunta 15: Threads não compartilham o mesmo contexto de execução incluindo o valor dos registradores e o contador de programa?, a) Sim, *b) Não",
			"Pergunta 16: Uma thread pode bloquear-se enquanto espera por uma condição para ser satisfeita?, *a) Sim, b) Não",
			"Pergunta 17: Threads podem ser implementadas em nível de hardware?, *a) Sim, b) Não",
			"Pergunta 18: As threads são exclusivas para sistemas operacionais multitarefa?, a) Sim, *b) Não",
			"Pergunta 19: As threads podem ser usadas para realizar cálculos paralelos em um processador gráfico (GPU)?, *a) Sim, b) Não",
			"Pergunta 20: As threads são mais leves em termos de consumo de recursos (memória e tempo de criação) do que os processos?, *a) Sim, b) Não",
			"Pergunta 21: As threads permitem que um programa execute várias operações em segundo plano enquanto continua respondendo a eventos de entrada do usuário?, *a) Sim, b) Não",
			"Pergunta 22: As threads podem ser usadas para facilitar a implementação de algoritmos de busca em profundidade (DFS)?, *a) Sim, b) Não",
			"Pergunta 23: Um programa com várias threads sempre será mais eficiente do que um programa com apenas uma thread?, a) Sim, *b) Não",
			"Pergunta 24: Threads podem ser usadas para melhorar a utilização da capacidade de processamento em sistemas de computação distribuída?, *a) Sim, b) Não",
			"Pergunta 25: É falso que as threads podem ser usadas para realizar tarefas assíncronas em um programa?, a) Sim, *b) Não",
			"Pergunta 26: Uma thread pode ser interrompida a qualquer momento pelo sistema operacional?, *a) Sim, b) Não",
			"Pergunta 27: As threads são implementadas apenas em linguagens de programação de alto nível?, a) Sim, *b) Não",
			"Pergunta 28: Uma thread não pode acessar e modificar variáveis compartilhadas com outras threads do mesmo processo?, a) Sim, *b) Não",
			"Pergunta 29: Threads podem ser usadas para evitar bloqueios em operações de entrada e saída demoradas?, *a) Sim, b) Não",
			"Pergunta 30: É falso que as threads podem ser usadas para facilitar a implementação de servidores web concorrentes?, a) Sim, *b) Não",
			"Pergunta 31: Threads são uma forma de um processo executar tarefas concorrentemente?, *a) Sim, b) Não",
			"Pergunta 32: Uma thread de execução é a maior sequência de instruções programadas que pode ser gerenciada independentemente por um escalonador?, *a) Sim, b) Não",
			"Pergunta 33: As threads compartilham o mesmo espaço de memória em um processo?, *a) Sim, b) Não",
			"Pergunta 34: Threads podem ser criadas e finalizadas dinamicamente durante a execução de um programa?, *a) Sim, b) Não",
			"Pergunta 35: Threads oferecem uma forma eficiente de aproveitar o poder de processamento de sistemas com múltiplos núcleos?, *a) Sim, b) Não",
			"Pergunta 36: Cada thread possui seu próprio conjunto de registradores e pilha de execução?, *a) Sim, b) Não",
			"Pergunta 37: Uma aplicação multithread pode executar várias tarefas simultaneamente?, *a) Sim, b) Não",
			"Pergunta 38: Threads podem ser utilizadas para melhorar a capacidade de resposta de uma aplicação?, *a) Sim, b) Não",
			"Pergunta 39: É possível que uma thread seja interrompida em qualquer ponto de sua execução?, *a) Sim, b) Não",
			"Pergunta 40: As threads de um processo compartilham recursos como arquivos abertos e conexões de rede?, *a) Sim, b) Não",
			"Pergunta 41: É possível sincronizar o acesso a recursos compartilhados entre threads?, *a) Sim, b) Não",
			"Pergunta 42: Threads são independentes entre si e não podem se comunicar?, *a) Sim, b) Não",
			"Pergunta 43: Threads podem ser implementadas em linguagens de programação como Java e C++?, *a) Sim, b) Não",
			"Pergunta 44: Uma aplicação monolítica sempre utiliza threads?, *a) Sim, b) Não",
			"Pergunta 45: Threads podem ser utilizadas para paralelizar a execução de um loop em um programa?, *a) Sim, b) Não",
			"Pergunta 46: O número de threads que um processo pode criar é limitado?, *a) Sim, b) Não",
			"Pergunta 47: As threads de um processo compartilham a mesma prioridade de escalonamento?, *a) Sim, b) Não",
			"Pergunta 48: Threads podem ser utilizadas para realizar operações de entrada e saída de forma assíncrona?, *a) Sim, b) Não",
			"Pergunta 49: O escalonador de threads decide qual thread será executada em cada momento?, *a) Sim, b) Não",
			"Pergunta 50: Threads podem ser utilizadas para dividir uma tarefa em partes menores e executá-las em paralelo?, *a) Sim, b) Não",
			"Pergunta 51: É possível que uma thread bloqueie sua execução aguardando por um evento?, *a) Sim, b) Não",
			"Pergunta 52: Threads podem ser utilizadas para melhorar a eficiência de algoritmos de busca?, *a) Sim, b) Não",
			"Pergunta 53: Threads podem ser utilizadas para realizar cálculos em background enquanto a interface gráfica do programa permanece responsiva?, *a) Sim, b) Não",
			"Pergunta 54: É possível que uma thread acesse a mesma posição de memória simultaneamente a outra thread?, *a) Sim, b) Não",
			"Pergunta 55: Threads podem ser utilizadas para dividir um problema em subproblemas e resolvê-los em paralelo?, *a) Sim, b) Não",
			"Pergunta 56: É possível que uma thread seja interrompida e posteriormente retome sua execução?, *a) Sim, b) Não",
			"Pergunta 57: Threads podem ser utilizadas para aumentar a capacidade de processamento de um servidor web?, *a) Sim, b) Não",
			"Pergunta 58: Cada thread possui seu próprio contador de programa?, *a) Sim, b) Não",
			"Pergunta 59: Threads podem ser utilizadas para melhorar a latência de comunicação em sistemas distribuídos?, *a) Sim, b) Não",
			"Pergunta 60: Uma thread pode ser interrompida por outra thread em um sistema multitarefa preemptivo?, *a) Sim, b) Não",
			"Pergunta 61: Threads podem ser utilizadas para implementar algoritmos de ordenação de forma mais eficiente?, *a) Sim, b) Não",
			"Pergunta 62: É possível que uma thread espere pela conclusão de outra thread?, *a) Sim, b) Não",
			"Pergunta 63: Threads podem ser utilizadas para melhorar a velocidade de renderização em um jogo?, *a) Sim, b) Não",
			"Pergunta 64: As threads de um processo compartilham o mesmo espaço de endereçamento?, *a) Sim, b) Não",
			"Pergunta 65: Threads podem ser utilizadas para melhorar a latência em sistemas de processamento de eventos?, *a) Sim, b) Não",
			"Pergunta 66: É possível que uma thread seja finalizada por outra thread em um sistema multitarefa preemptivo?, *a) Sim, b) Não",
			"Pergunta 67: Threads podem ser utilizadas para realizar operações de banco de dados em paralelo?, *a) Sim, b) Não",
			"Pergunta 68: O escalonador de threads decide a ordem exata de execução das threads em um sistema multitarefa?, *a) Sim, b) Não",
			"Pergunta 69: Threads podem ser utilizadas para implementar servidores de aplicação mais eficientes?, *a) Sim, b) Não",
			"Pergunta 70: É possível que uma thread compartilhe variáveis com outras threads do mesmo processo?, *a) Sim, b) Não"};

	public DeckInterface() {
		idNum = new ArrayList<>();
		pergunta = new ArrayList<>();
		respostas = new ArrayList<>();
		respostasCorretas = new ArrayList<>();

		for (int j = 0; j < dataBaseCards.length; j++) {
			String[] cards = dataBaseCards[j].split(":");
			String[] alternativas = cards[1].split(", ");
			String id = cards[0];
			this.idNum.add(id);
			this.pergunta.add(alternativas[0]);
			this.respostas.add(alternativas[1]);
			String respostaCorreta = alternativas[1].substring(0, 1);
			if (respostaCorreta.equals("*")) {
				this.respostasCorretas.add("Sim");
			} else {
				this.respostasCorretas.add("Não");
			}
		}
	}

	public static void main(String[] args) {
		DeckInterface d = new DeckInterface();
		for (int i=0; i<d.dataBaseCards.length; i++) {
			System.out.println(d.pergunta.get(i)+" resposta: "+d.respostasCorretas.get(i));
		}
		
	}

}