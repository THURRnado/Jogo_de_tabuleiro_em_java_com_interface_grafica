package interfaceGrafica;

public class Jogador {

	private int posiçãoInicialX = 123 - 105;
	private int posiçãoInicialY = 635;

	private int posiçãoAtualX = this.posiçãoInicialX;
	private int posiçãoAtualY = this.posiçãoInicialY;
	
	private int movimento;
	
	private int casaAtual = -1;

	private String nome = "";

	private String atualSprite = "";
	private String frontSprite = "_front.png";
	private String leftSprite = "_left.png";
	private String rightSprite = "_right.png";
	private String backSprite = "_back.png";

	public Jogador(String nome, String color) {

		this.nome = nome;
		// Define os atributos do gatinho.

		this.movimento = 105;
		
		if (color.equals("red")) {
			// Gatinho olhando para frente
			this.frontSprite = "./assets/" + color + frontSprite;
			// Gatinho olhando para trás
			this.backSprite = "./assets/" + color + backSprite;
			// Gatinho olhando para esquerda
			this.leftSprite = "./assets/" + color + leftSprite;
			// Gatinho olhando para direita
			this.rightSprite = "./assets/" + color + rightSprite;
			// Seta o sprite inicial
			this.atualSprite = this.frontSprite;

			this.posiçãoInicialY -= 78;
			this.posiçãoAtualY = this.posiçãoInicialY;

		} else if (color.equals("blue")) {
			this.frontSprite = "./assets/" + color + frontSprite;
			this.backSprite = "./assets/" + color + backSprite;
			this.leftSprite = "./assets/" + color + leftSprite;
			this.rightSprite = "./assets/" + color + rightSprite;
			this.atualSprite = this.frontSprite;

			this.posiçãoInicialY -= 26;
			this.posiçãoAtualY = this.posiçãoInicialY;

		}

	}

	public Boolean vitoria() {
		if (this.casaAtual == 25)
			return true;
		else
			return false;

	}

	public void mover() {

		// Anda pra direita.
		if ((this.casaAtual >= -1 && this.casaAtual < 7) || (this.casaAtual >= 18 && this.casaAtual < 25)) {
			// Troca o sprite para o gato andando para a direita.
			this.movimento = 105;
			this.atualSprite = this.rightSprite;
			this.posiçãoAtualX++;

		}
		// Anda pra esquerda.
		else if (this.casaAtual >= 9 && this.casaAtual < 16) {
			// Troca o sprite para o gato andando para a esquerda.
			this.movimento = 105;
			this.atualSprite = this.leftSprite;
			this.posiçãoAtualX--;

		}
		else if ((this.casaAtual == 7) || (this.casaAtual == 8) || (this.casaAtual == 16) || (this.casaAtual == 17)) {
			// Troca o sprite para o gato andando para cima.
			this.movimento = 130;
			this.atualSprite = this.backSprite;
			this.posiçãoAtualY--;

		}

	}


	public int getPosiçãoInicialX() {
		return posiçãoInicialX;
	}

	public void setPosiçãoInicialX(int posiçãoInicialX) {
		this.posiçãoInicialX = posiçãoInicialX;
	}

	public int getPosiçãoInicialY() {
		return posiçãoInicialY;
	}

	public void setPosiçãoInicialY(int posiçãoInicialY) {
		this.posiçãoInicialY = posiçãoInicialY;
	}

	public int getPosiçãoAtualX() {
		return posiçãoAtualX;
	}

	public void setPosiçãoAtualX(int posiçãoAtualX) {
		this.posiçãoAtualX = posiçãoAtualX;
	}

	public int getPosiçãoAtualY() {
		return posiçãoAtualY;
	}

	public void setPosiçãoAtualY(int posiçãoAtualY) {
		this.posiçãoAtualY = posiçãoAtualY;
	}

	public int getCasaAtual() {
		return casaAtual;
	}

	public void setCasaAtual(int casaAtual) {
		this.casaAtual = casaAtual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtualSprite() {
		return atualSprite;
	}

	public void setAtualSprite(String atualSprite) {
		this.atualSprite = atualSprite;
	}

	public String getFrontSprite() {
		return frontSprite;
	}

	public void setFrontSprite(String frontSprite) {
		this.frontSprite = frontSprite;
	}

	public String getLeftSprite() {
		return leftSprite;
	}

	public void setLeftSprite(String leftSprite) {
		this.leftSprite = leftSprite;
	}

	public String getRightSprite() {
		return rightSprite;
	}

	public void setRightSprite(String rightSprite) {
		this.rightSprite = rightSprite;
	}

	public String getBackSprite() {
		return backSprite;
	}

	public void setBackSprite(String backSprite) {
		this.backSprite = backSprite;
	}

	public int getMovimento() {
		return movimento;
	}

	public void setMovimento(int movimento) {
		this.movimento = movimento;
	}

	
}
