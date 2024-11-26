package sprint2.model;

public class Diagnostico {
	private int idDiagnostico;
	private Usuario usuario;
	private Veiculo veiculo;
	private String descricaoSintomas;
	private Servico solucao;
	private Orcamento orcamento;
	private String categoria;
	private String status;
	
	public Diagnostico(int idDiagnostico, Usuario usuario, Veiculo veiculo, String descricaoSintomas, Servico solucao, String categoria, String status) {
		System.out.println("\n*-* Diagnóstico criado *-*\n");
		this.idDiagnostico = idDiagnostico;
		this.usuario = usuario;
		this.veiculo = veiculo;
		this.descricaoSintomas = descricaoSintomas;
		this.solucao = solucao;
		this.categoria = categoria;
		this.status = status;
	}

	public int getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
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

	public String getDescricaoSintomas() {
		return descricaoSintomas;
	}

	public void setDescricaoSintomas(String descricaoSintomas) {
		this.descricaoSintomas = descricaoSintomas;
	}

	public Servico getSolucao() {
		return solucao;
	}

	public void setSolucao(Servico solucao) {
		this.solucao = solucao;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void imprimirDiagnostico() {
		System.out.println("*-* DIAGNÓSTICO *-*");
		System.out.println("ID Diagnóstico: " + getIdDiagnostico());
		System.out.println("Usuário: " + getUsuario().getNomeUsuario());
		System.out.println("Veículo: " + getVeiculo().getMarca() + " " + getVeiculo().getModelo() + " (" + getVeiculo().getAno() + ", " + getVeiculo().getPlaca() + ", " + getVeiculo().getQuilometragem() + "km)");
		System.out.println("Sintomas: " + getDescricaoSintomas());
		System.out.println("Solução: " + getSolucao().getDescricaoServico());
		System.out.println("Categoria: " + getCategoria());
		System.out.println("Status: " + getStatus());
		if (orcamento != null) {
			orcamento.imprimirOrcamento();
		} else {
			System.out.println("\n*-* ORÇAMENTO *-*\n");
			System.out.println("       Nenhum orçamento realizado     ");
		}
		
	}
	
	
	
}
