package sprint2.gerenciador;

import java.util.ArrayList;
import sprint2.model.CentroAutomotivo;

public class GerenciadorCentro {
    private ArrayList<CentroAutomotivo> centrosAutomotivos;

    public GerenciadorCentro() {
        this.centrosAutomotivos = new ArrayList<CentroAutomotivo>();
    }

    public void adicionarUnidade(CentroAutomotivo centroAutomotivo) {
    	System.out.println("Centro adicionado a lista com sucesso.");
        this.centrosAutomotivos.add(centroAutomotivo);
    }
    
    public void removerUnidade(CentroAutomotivo centroAutomotivo) {
    	System.out.println("Centro removido da lista com sucesso.");
    	this.centrosAutomotivos.remove(centroAutomotivo);
    }

    public void listarUnidades() {
        System.out.println("\n*-* LISTA DE UNIDADES *-*\n");
        for (CentroAutomotivo centroAutomotivo : this.centrosAutomotivos) {
            System.out.println("ID: " + centroAutomotivo.getIdCentro());
            System.out.println("Nome do Centro: " + centroAutomotivo.getNomeCentro());
            System.out.println("Endereço: " + centroAutomotivo.getEnderecoCentro());
            System.out.println("Telefone: " + centroAutomotivo.getTelefoneCentro());
            System.out.println("Horário de funcionamento: " + centroAutomotivo.getHorarioFuncionamento() + "\n");                   
        }
    }
    
    public ArrayList<CentroAutomotivo> retornaListaCentros() {
    	return centrosAutomotivos;
    }
    
    public CentroAutomotivo retornaCentro(String nomeCentro) {
        for (CentroAutomotivo centroAutomotivo : centrosAutomotivos) {
            if (centroAutomotivo.getNomeCentro().equalsIgnoreCase(nomeCentro)) {
                return centroAutomotivo;
            }
        }

        return null;
    }
}
