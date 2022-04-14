package modelo;

//	Classe faz referência à tabela.
public class Cliente {
	
	//	Atributos faz referência as colunas.
	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;
	
	// Construtores para alimentar e acessar as linhas da tabela
	public Cliente() {
		
	}
		
	public Cliente(String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		
	}
	
	public Cliente(Integer id, String nome, String cpf, String telefone) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		
	}
	
	//Getters e setters
	public Integer getId() {
		return this.id;
		
	}
	
	public void setId(Integer id) {
		this.id = id;
		
	}
	
	public String getNome() {
		return this.nome;
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		
	}
	
	public String getCpf() {
		return this.cpf;
		
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
		
	}
	
	public String getTelefone() {
		return this.telefone;
		
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
		
	}
	
	// Método toString para saída formatada dos dados
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + "]";
		
	}
	
	
	
	
}
