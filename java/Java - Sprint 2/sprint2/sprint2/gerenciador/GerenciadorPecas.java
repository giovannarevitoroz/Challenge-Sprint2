package sprint2.gerenciador;

import java.util.ArrayList;

import sprint2.model.Peca;

public class GerenciadorPecas {
	private ArrayList<Peca> pecas;
	
	public GerenciadorPecas() {
		this.pecas = new ArrayList<Peca>();
	}
	
	public void alterarDisponibilidadePeca(Peca peca) {
		if (peca.isDisponibilidadePeca() == true) {
			peca.setDisponibilidadePeca(false);
		} else {
			peca.setDisponibilidadePeca(true);
		}
	}
	
	public void adicionarPeca(Peca peca) {
		pecas.add(peca);
		System.out.println("Peça adicionada com sucesso.");
	}
	
	public void removerPeca(Peca peca) {
		pecas.remove(peca);
		System.out.println("Peça removida com sucesso.");
	}
	
	public void listarPecas() {
		System.out.println("\n*-* LISTA DE PEÇAS *-*\n");
		for (Peca peca : this.pecas) {
			peca.imprimirPeca();
		}
	}
	
	public ArrayList<Peca> retornaListaPecas() {
		return pecas;
	}
	
	public void consultarDisponibilidadePeca(Peca pecaSolicitada) {
		if (pecaSolicitada.isDisponibilidadePeca() == true) {
			System.out.println("A peça " + pecaSolicitada.getNomePeca() + " está disponível.");
		} else {
			System.out.println("A peça " + pecaSolicitada.getNomePeca() + " está indisponível.");
		}
	}
}
