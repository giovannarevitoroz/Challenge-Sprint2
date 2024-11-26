package sprint2.gerenciador;

import java.util.ArrayList;

import sprint2.model.Cargo;

public class GerenciadorCargo {
	private ArrayList<Cargo> cargos;
	
	public GerenciadorCargo() {
		this.cargos = new ArrayList<Cargo>();
	}
	
	public void adicionarCargo(Cargo cargo) {
		System.out.println("Cargo adicionado a lista com sucesso.");
		cargos.add(cargo);
	}
	
	public void removerCargo(Cargo cargo) {
		System.out.println("Cargo removido da lista com sucesso.");
		cargos.remove(cargo);
	}
	
	public void listarCargos() {
		System.out.println("\n*-* LISTA DE CARGOS *-*\n");
		for (Cargo cargo : cargos) {
			cargo.imprimirCargo();
		}
	}
	
	public ArrayList<Cargo> retornaListaCargos() {
		return cargos;
	}
	
	public Cargo retornaCargo(String nomeCargo) {
        for (Cargo cargo : cargos) {
            if (cargo.getNomeCargo().equalsIgnoreCase(nomeCargo)) {
                return cargo;
            }
        }

        return null;
    }
}
