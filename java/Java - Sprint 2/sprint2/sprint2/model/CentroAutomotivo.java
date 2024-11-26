package sprint2.model;

public class CentroAutomotivo {
    private int idCentro;
    private String nomeCentro;
    private String enderecoCentro;
    private String telefoneCentro;
    private String horarioFuncionamento;

    public CentroAutomotivo(int idCentro, String nomeCentro, String enderecoCentro, String telefoneCentro, String horarioFuncionamento) {
        this.idCentro = idCentro;
        this.nomeCentro = nomeCentro;
        this.enderecoCentro = enderecoCentro;
        this.telefoneCentro = telefoneCentro;
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }
    
    public String getNomeCentro() {
        return nomeCentro;
    }

    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }

    public String getEnderecoCentro() {
        return enderecoCentro;
    }

    public void setEnderecoCentro(String enderecoCentro) {
        this.enderecoCentro = enderecoCentro;
    }

    public String getTelefoneCentro() {
        return telefoneCentro;
    }

    public void setTelefoneCentro(String telefoneCentro) {
        this.telefoneCentro = telefoneCentro;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

	public void imprimirCentro() {
		System.out.println("ID: " + getIdCentro());
        System.out.println("Nome do Centro: " + getNomeCentro());
        System.out.println("Endereço: " + getEnderecoCentro());
        System.out.println("Telefone: " + getTelefoneCentro());
        System.out.println("Horário de funcionamento: " + getHorarioFuncionamento() + "\n");    
	}

    
}
