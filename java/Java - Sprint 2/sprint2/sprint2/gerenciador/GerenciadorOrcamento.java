package sprint2.gerenciador;

import sprint2.model.Diagnostico;
import sprint2.model.Orcamento;

public class GerenciadorOrcamento {

	public GerenciadorOrcamento() {

	}
	
	public Orcamento gerarOrcamento(Diagnostico diagnostico) {
		Orcamento orcamento = new Orcamento();
		orcamento.setIdOrcamento(diagnostico.getIdDiagnostico());
		orcamento.setPeca(diagnostico.getSolucao().getPeca());
		orcamento.setServico(diagnostico.getSolucao());
		orcamento.setValor_total(orcamento.getPeca().getPrecoPeca() + orcamento.getServico().getPrecoServico());
		orcamento.setStatusOrcamento("Realizado");
		
		return orcamento;
	}
	
	public void alterarDescricao(Orcamento orcamento, String novaDescricao) {
		orcamento.setDescricaoOrcamento(novaDescricao);
	}
	
	
	
}
