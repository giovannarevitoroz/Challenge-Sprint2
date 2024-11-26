package sprint2.model;

public class Servico {
	private int idServico;
    private String tipoServico;
    private String descricaoServico;
    private double precoServico;
    private int duracaoServico;
    private Peca peca;
    private Funcionario responsavel;

    public Servico(int idServico, String tipoServico, String descricaoServico, double precoServico, int duracaoServico, Peca peca) {
    	this.idServico = idServico;
        this.tipoServico = tipoServico;
        this.descricaoServico = descricaoServico;
        this.precoServico = precoServico;
        this.duracaoServico = duracaoServico;
        this.peca = peca;
    }
    
    public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public double getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(double precoServico) {
        this.precoServico = precoServico;
    }

    public int getDuracaoServico() {
        return duracaoServico;
    }

    public void setDuracaoServico(int duracaoServico) {
        this.duracaoServico = duracaoServico;
    }
    
	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public void imprimirServico() {
		System.out.println("Tipo do serviço: " + getTipoServico());
    	System.out.println("Descrição: " + getDescricaoServico());
    	System.out.println("Preço: R$" + getPrecoServico());
    	System.out.println("Duração estimada: " + getDuracaoServico() + " minutos\n");
	}


}
