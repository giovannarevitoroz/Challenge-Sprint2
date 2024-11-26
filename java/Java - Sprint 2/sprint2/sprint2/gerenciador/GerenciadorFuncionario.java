package sprint2.gerenciador;

import java.util.ArrayList;

import sprint2.model.Cargo;
import sprint2.model.CentroAutomotivo;
import sprint2.model.Funcionario;

public class GerenciadorFuncionario {
    private ArrayList<Funcionario> funcionarios;

    public GerenciadorFuncionario() {
    	this.funcionarios = new ArrayList<Funcionario>();
    }

    public void alterarCargo(Funcionario funcionario, Cargo novoCargo) {
    	funcionario.setCargo(novoCargo);
    }	

    public void alterarCentroAutomotivo(Funcionario funcionario, CentroAutomotivo novoCentroAutomotivo) {
        funcionario.setCentroAutomotivo(novoCentroAutomotivo);
    }
    
    public void alterarDisponibilidade(Funcionario funcionario) {
    	if(funcionario.isDisponibilidade() == true) {
    		funcionario.setDisponibilidade(false);
    	} else {
    		funcionario.setDisponibilidade(true);
    	}
    }
    
    public void alterarHorarioTrabalho(Funcionario funcionario, String novoHorarioTrabalho) {
    	funcionario.setHorarioTrabalho(novoHorarioTrabalho);
    }
    
    public void adicionarFuncionario(Funcionario funcionario) {
    	System.out.println("Funcionário adicionado a lista com sucesso.");
    	funcionarios.add(funcionario);
    }
    
    public void removerFuncionario(Funcionario funcionario) {
    	System.out.println("Funcionário removido da lista com sucesso.");
    	funcionarios.remove(funcionario);
    	
    }
    
    public void listarFuncionarios() {
    	System.out.println("\n*-* LISTA DE FUNCIONÁRIOS *-*\n");
    	for (Funcionario funcionario : funcionarios) {
    		funcionario.imprimirFuncionario();
    	}
    }
    
    public ArrayList<Funcionario> retornaListaFuncionarios() {
    	return funcionarios;
    }
    
}
