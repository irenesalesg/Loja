package classes;

import java.util.Scanner;

public class produto {
	private String nome;
	private int codigo;
	private double valorUnit;
	private int qntEstoque;
	
	//construtor, responsavel por inicializar os atributos, sempre com o mesmo nome da classe
	public produto(){
		this.nome = "";
		this.codigo = 0;
		this.valorUnit = 0;
		this.qntEstoque = 0;
	}
	
	public void preencher(Scanner sc) {
		
		System.out.println("Informe os dados do produto: ");
		System.out.print("Informe o nome do produto: ");
		this.nome = sc.nextLine();
		
		System.out.print("Informe o codigo do produto: ");
		this.codigo = sc.nextInt();
		
		System.out.print("Informe o valor por unidade do produto: ");
		this.valorUnit = sc.nextDouble();
		
		System.out.print("Informe a quantidade que deseja adicionar: ");
		this.qntEstoque = sc.nextInt();
		sc.nextLine();
	}
	
	
	public void imprimir() {
		System.out.println("**********DADOS DO PRODUTO**********");
		System.out.println("nome: " + this.nome);
		System.out.println("codigo: " + this.codigo);
		System.out.println("valorUnit: " + this.valorUnit);
		System.out.println("qntEstoque: " + this.qntEstoque);
		System.out.println("************************************");
	}
	
	
	public void copiar() {
		
	}

	//produto
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//codigo
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}	
	
	//valor unidade
	public double getValorUnit() {
		return valorUnit;
	}
	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}
	
	//quantidade em estoque
	public int getQntEstoque() {
		return qntEstoque;
	}
	public void setQntEstoque(int qntEstoque) {
		this.qntEstoque = qntEstoque;
	}
	
	
	public void copiar(produto copia){ 

		this.nome = copia.getNome(); 
		this.codigo = copia.getCodigo(); 
		this.valorUnit = copia.getValorUnit(); 
		this.qntEstoque = copia.getQntEstoque(); 
		} 
}
