package interfaceGrafica;

public class Jogador {

	private String nome;
	//Esse vai ser claramente mudado depois
	private String sprite;
	private int posicao;
	private boolean acertoPergunta;
	private String mensagem;
	
	public Jogador(String nome, String sprite, int posicao) {
		this.nome = nome;
		this.sprite = sprite;
		this.posicao = posicao;
		acertoPergunta = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public boolean isAcertoPergunta() {
		return acertoPergunta;
	}

	public void setAcertoPergunta(boolean acertoPergunta) {
		this.acertoPergunta = acertoPergunta;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void andar(int novaPosicao) {
		this.posicao = novaPosicao;
	}
	
	public void informacaoJogador(String nome) {
		//Claramente também vai ser alterado
		System.out.println(this.nome + this.posicao);
	}
	
	//Não lembro o que isso precisa fazer
	public boolean respondendo() {
		return true;
	}
	
}
