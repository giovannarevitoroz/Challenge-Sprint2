package sprint2.model;

import java.util.UUID;

public class Agendamento {
	private String idAgendamento;
    private String data;
    private String hora;
    private String descricao;
    private CentroAutomotivo centro;
    private Servico servico;
    private Usuario usuario;
    private Veiculo veiculo;

	public Agendamento() {
		this.idAgendamento = UUID.randomUUID().toString();
	}

    public Agendamento(String data, String hora, String descricao, CentroAutomotivo centro, Servico servico, Usuario usuario, Veiculo veiculo) {
    	this.idAgendamento = UUID.randomUUID().toString();
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.centro = centro;
        this.servico = servico;
        this.usuario = usuario;
        this.veiculo = veiculo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public CentroAutomotivo getCentro() {
		return centro;
	}

	public void setCentro(CentroAutomotivo centro) {
		this.centro = centro;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	

	public String getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(String idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public void imprimirAgendamento() {
		System.out.println("ID Agendamento: " + getIdAgendamento());
		System.out.println("Serviço.......: " + getServico().getDescricaoServico());
		System.out.println("Peça..........: " + getServico().getPeca().getNomePeca());
		System.out.println("Oficina.......: " + getCentro().getNomeCentro());
		System.out.println("Data..........: " + getData());
		System.out.println("Horário.......: " + getHora());
		System.out.println("Usuário.......: " + getUsuario().getNomeUsuario());
		System.out.println("Veículo.......: " + getVeiculo().getMarca() + " " + getVeiculo().getModelo() + " " + getVeiculo().getAno() + " " + getVeiculo().getPlaca());
		System.out.println("Técnico responsável: " + (getServico().getResponsavel() != null ? getServico().getResponsavel().getNomeFuncionario() : "Não especificado") + "\n");
	}

	
}
