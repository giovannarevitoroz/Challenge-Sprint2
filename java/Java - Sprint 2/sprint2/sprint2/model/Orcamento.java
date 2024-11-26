package sprint2.model;

public class Orcamento {
	private int idOrcamento;
	private String descricaoOrcamento;
	private double valor_total;
	private String statusOrcamento;
	private Servico servico;
	private Peca peca;
	
	public Orcamento() {
		this.valor_total = 0;
		this.descricaoOrcamento = "Nenhuma";
		this.statusOrcamento = "Não Feito";
	}

	public int getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(int idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public String getDescricaoOrcamento() {
		return descricaoOrcamento;
	}

	public void setDescricaoOrcamento(String descricaoOrcamento) {
		this.descricaoOrcamento = descricaoOrcamento;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	public String getStatusOrcamento() {
		return statusOrcamento;
	}

	public void setStatusOrcamento(String statusOrcamento) {
		this.statusOrcamento = statusOrcamento;
	}

	public void imprimirOrcamento() {
		System.out.println("\n*-* ORÇAMENTO *-*\n");
		System.out.println("Preço serviço: R$" + getServico().getPrecoServico());
		System.out.println("Preço peça: R$" + getPeca().getPrecoPeca());
		System.out.println("Valor total: R$" + getValor_total());
	}
	
	
}
