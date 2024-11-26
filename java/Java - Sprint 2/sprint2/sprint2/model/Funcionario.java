package sprint2.model;

public class Funcionario {
    private int matriculaFuncionario;
    private String nomeFuncionario;
    private Cargo cargo;
    private CentroAutomotivo centroAutomotivo;
    private boolean disponibilidade;
    private String horarioTrabalho;

    public Funcionario(int matriculaFuncionario, String nomeFuncionario, Cargo cargo, CentroAutomotivo centroAutomotivo, boolean disponibilidade, String horarioTrabalho) {
        this.matriculaFuncionario = matriculaFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
        this.centroAutomotivo = centroAutomotivo;
        this.disponibilidade = disponibilidade;
        this.horarioTrabalho = horarioTrabalho;
    }


	public int getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    public void setMatriculaFuncionario(int matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public CentroAutomotivo getCentroAutomotivo() {
        return centroAutomotivo;
    }

    public void setCentroAutomotivo(CentroAutomotivo centroAutomotivo) {
        this.centroAutomotivo = centroAutomotivo;
    }
    
    public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getHorarioTrabalho() {
		return horarioTrabalho;
	}


	public void setHorarioTrabalho(String horarioTrabalho) {
		this.horarioTrabalho = horarioTrabalho;
	}

	public void imprimirFuncionario() {
		System.out.println("Matrícula: " + getMatriculaFuncionario());
		System.out.println("Nome: " + getNomeFuncionario());
		System.out.println("Cargo: " + getCargo().getNomeCargo());
		System.out.println("Área do Cargo: " + getCargo().getAreaCargo());
		System.out.println("Oficina: " + getCentroAutomotivo().getNomeCentro());
		System.out.println("Disponibilidade: " + (isDisponibilidade() == true ? "Disponível" : "Indisponível"));
		System.out.println("Horário de trabalho: " + getHorarioTrabalho() + "\n");
	}
    
}