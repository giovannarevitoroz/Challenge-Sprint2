package sprint2.gerenciador;

import java.util.ArrayList;

import sprint2.model.Funcionario;
import sprint2.model.Servico;

public class GerenciadorServico {
    // Atributos
    private ArrayList<Servico> servicos;

    // Construtor
    public GerenciadorServico() {
        this.servicos = new ArrayList<Servico>();
    }

    // Métodos
    public void adicionarServico(Servico servico) {
    	System.out.println("Serviço adicionado a lista com sucesso.");
    	servicos.add(servico);
    }
    
    public void removerServico(Servico servico) {
    	System.out.println("Serviço removido da lista com sucesso.");
    	servicos.remove(servico);
    }
    
    public void adicionarResponsavel(Funcionario funcionario, Servico servico) {
    	if (funcionario.getCargo().getNomeCargo().equalsIgnoreCase("Mecânico")) {
    		servico.setResponsavel(funcionario);
    	} else {
    		System.out.println("Funcionário não é um mecânico.");
    	}
    }
    
    public void listarServicos() {
    	System.out.println("\n*-* LISTA DE SERVIÇOS *-*\n");
        for (Servico servico: servicos) {
        	servico.imprimirServico();
        }
    }
    
    public ArrayList<Servico> retornaListaServicos() {
    	return servicos;
    }

    public Servico retornaServico(String descricao) {
        for (Servico servico : this.servicos) {
            if (servico.getDescricaoServico().equalsIgnoreCase(descricao)) {
                return servico;
            }
        }

        return null;
    }
}
