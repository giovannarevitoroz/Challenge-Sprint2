package sprint2.gerenciador;

import java.util.ArrayList;

import sprint2.model.Diagnostico;

public class GerenciadorDiagnostico {
	private ArrayList<Diagnostico> diagnosticos;
	
	public GerenciadorDiagnostico() {
		this.diagnosticos = new ArrayList<Diagnostico>();
	}
	
	public void adicionarDiagnostico(Diagnostico diagnostico) {
		diagnosticos.add(diagnostico);
	}
	
	public void removerDiagnostico(Diagnostico diagnostico) {
		diagnosticos.remove(diagnostico);
	}
	
	public ArrayList<Diagnostico> retornaListaDiagnosticos() {
		return diagnosticos;
	}
	
	public void listarDiagnosticos() {
		System.out.println("\n*-* LISTA DE DIAGNÓSTICOS *-*\n");
		for (Diagnostico diagnostico : diagnosticos) {
			diagnostico.imprimirDiagnostico();
		}
	}
}
