package sprint2.main;

import sprint2.gerenciador.GerenciadorAgendamento;
import sprint2.gerenciador.GerenciadorCargo;
import sprint2.gerenciador.GerenciadorCentro;
import sprint2.gerenciador.GerenciadorDiagnostico;
import sprint2.gerenciador.GerenciadorServico;
import sprint2.gerenciador.GerenciadorFuncionario;
import sprint2.gerenciador.GerenciadorOrcamento;
import sprint2.gerenciador.GerenciadorPecas;
import sprint2.gerenciador.GerenciadorUsuario;
import sprint2.gerenciador.GerenciadorVeiculo;
import sprint2.model.Agendamento;
import sprint2.model.Cargo;
import sprint2.model.CentroAutomotivo;
import sprint2.model.Diagnostico;
import sprint2.model.Servico;
import sprint2.model.Funcionario;
import sprint2.model.Orcamento;
import sprint2.model.Peca;
import sprint2.model.Usuario;
import sprint2.model.Veiculo;


public class Main {
    public static void main(String[] args) {
    	
    	// testando métodos
    	
    	// cria peça, adiciona na lista e imprime
        System.out.println("*-* Criando e adicionando peças para a lista de peças *-*\n");
        Peca peca1 = new Peca(112, true, "Filtro de Cabine", 69.99);
        Peca peca2 = new Peca(113, false, "Disco de pastilha traseiro", 39.99);
        Peca peca3 = new Peca(114, true, "Bateria 40ah", 69.99);
        Peca peca4 = new Peca(115, true, "Bateria 60ah", 129.99);
        Peca peca5 = new Peca(116, true, "Óleo 20w50 500ml", 20.99);
        Peca peca6 = new Peca(117, false, "Lâmpada Farol H4 12V 60/55W", 26.79);
        GerenciadorPecas gerenciadorPecas = new GerenciadorPecas();
        gerenciadorPecas.adicionarPeca(peca1);
        gerenciadorPecas.adicionarPeca(peca2);
        gerenciadorPecas.adicionarPeca(peca3);
        gerenciadorPecas.adicionarPeca(peca4);
        gerenciadorPecas.adicionarPeca(peca5);
        gerenciadorPecas.adicionarPeca(peca6);
        gerenciadorPecas.listarPecas();
        
        // consulta disponibilidade
        System.out.println("*-* Consulta disponibilidade de peças *-*\n");
        gerenciadorPecas.consultarDisponibilidadePeca(peca1);
        gerenciadorPecas.consultarDisponibilidadePeca(peca2);
        gerenciadorPecas.consultarDisponibilidadePeca(peca3);
        gerenciadorPecas.consultarDisponibilidadePeca(peca4);
        gerenciadorPecas.consultarDisponibilidadePeca(peca5);
        gerenciadorPecas.consultarDisponibilidadePeca(peca6);
        
        // alterando a disponibilidade da peça
        gerenciadorPecas.alterarDisponibilidadePeca(peca3);
        System.out.println("\n*-* Alterando a disponibilidade da peca3 *-*");
        System.out.println("\nDisponibilidade peca3: " + peca3.isDisponibilidadePeca());
        
        // remove uma peça
        System.out.println("\n*-* Removendo peca3 da lista de peças *-*\n");
        gerenciadorPecas.removerPeca(peca3);
        gerenciadorPecas.listarPecas();
    	
    	System.out.println("\n===================================");
    	
    	// criação dos centrosAutomotivos
    	CentroAutomotivo centroAutomotivo1 = new CentroAutomotivo(111111, "Centro Automotivo Ipiranga", "R. Silva Bueno, 1176", "(11) 3476-0004", "8:30 - 19:30");
    	CentroAutomotivo centroAutomotivo2 = new CentroAutomotivo(121212, "Centro Automotivo Lins de Vasconcelos", "Av. Lins de Vasconcelos, 2474", "(11) 3294-1040", "7:30 - 20:30");
    	CentroAutomotivo centroAutomotivo3 = new CentroAutomotivo(121213, "Centro Automotivo Ibirapuera", "R. França Pinto, 1115", "(11) 2872-1115", "8:00 - 18:00");
    	
    	// adiciona unidades para a lista de centros automotivos
        GerenciadorCentro gerenciadorCentro = new GerenciadorCentro();
        
        System.out.println("*-* Adicionando Centros *-*\n");
        gerenciadorCentro.adicionarUnidade(centroAutomotivo1);
        gerenciadorCentro.adicionarUnidade(centroAutomotivo2);
        gerenciadorCentro.adicionarUnidade(centroAutomotivo3);
        gerenciadorCentro.listarUnidades();
        
        // remove centroAutomotivo da lista
        System.out.println("*-* Removendo centroAutomotivo1 da lista de unidades *-*\n");
        gerenciadorCentro.removerUnidade(centroAutomotivo1);
        gerenciadorCentro.listarUnidades();
        
        System.out.println("===================================");
    	
    	// Criação dos cargos
    	Cargo cargo1 = new Cargo(01, "Gerente", "Gerencia o Centro Automotivo", "Administrativa", 7000);
    	Cargo cargo2 = new Cargo(02, "Mecânico", "Trabalha na manutenção dos veículos", "Prática", 2500);
    	Cargo cargo3 = new Cargo(03, "Atendente", "Realiza o atendimento dos clientes no balcão", "Prática", 1500);
    	Cargo cargo4 = new Cargo(04, "Lavador", "Realiza a lavagem interna e externa dos veículos", "Prática", 1200);
    	
    	 // adiciona os cargos a lista e imprime
        GerenciadorCargo gerenciadorCargo = new GerenciadorCargo();
        
        System.out.println("*-* Adicionando cargos *-*\n");
        
        gerenciadorCargo.adicionarCargo(cargo1);
        gerenciadorCargo.adicionarCargo(cargo2);
        gerenciadorCargo.adicionarCargo(cargo3);
        gerenciadorCargo.adicionarCargo(cargo4);
        gerenciadorCargo.listarCargos();
        
        // remove cargo da lista
        System.out.println("*-* Removendo cargo 4 da lista *-*\n");
        gerenciadorCargo.removerCargo(cargo4);
        gerenciadorCargo.listarCargos();
        
        // retorna cargo com base no nome
        System.out.println("*-* Cargo 'Gerente' retornado com base em seu nome *-*\n");
        Cargo cargoTeste = gerenciadorCargo.retornaCargo("Gerente");
        cargoTeste.imprimirCargo();
        
        System.out.println("===================================");
    	
    	// Criação dos funcionários
    	Funcionario funcionario1 = new Funcionario(2222, "Mauricio", cargo4, centroAutomotivo1, true, "07:30 - 18:30");
    	Funcionario funcionario2 = new Funcionario(2223, "Carlos", cargo2, centroAutomotivo2, false, "06:30 - 15:30");
    	Funcionario funcionario3 = new Funcionario(2224, "José", cargo2, centroAutomotivo2, true, "06:30 - 18:30");
    	
    	// adiciona funcionários a lista de funcionários
    	GerenciadorFuncionario gerenciadorFuncionario = new GerenciadorFuncionario();
    	
    	System.out.println("*-* Adicionando funcionários *-*\n");
    	gerenciadorFuncionario.adicionarFuncionario(funcionario1);
    	gerenciadorFuncionario.adicionarFuncionario(funcionario2);
    	gerenciadorFuncionario.adicionarFuncionario(funcionario3);
    	gerenciadorFuncionario.listarFuncionarios();
        
        // alteração dos dados do Funcionário
        gerenciadorFuncionario.alterarCargo(funcionario1, cargo2);
        gerenciadorFuncionario.alterarCentroAutomotivo(funcionario1, centroAutomotivo2);
        gerenciadorFuncionario.alterarDisponibilidade(funcionario1);
        gerenciadorFuncionario.alterarHorarioTrabalho(funcionario1, "07:00 - 18:00");
        System.out.println("*-* Alterando dados do funcionario1 *-*\n");
        funcionario1.imprimirFuncionario();
        
        System.out.println("*-* Remoção do funcionário2 da lista de funcionários *-*\n");
        // remoção do funcionário
        gerenciadorFuncionario.removerFuncionario(funcionario2);
        gerenciadorFuncionario.listarFuncionarios();
        
        System.out.println("===================================");
        
     // Criação de serviços e adição deles na lista de serviços
    	GerenciadorServico gerenciadorServico = new GerenciadorServico();
    	
    	System.out.println("*-* Adicionando serviços *-*\n");
    	gerenciadorServico.adicionarServico(new Servico(1001, "Mecânica", "Troca de óleo", 100.0, 30, peca5));
    	gerenciadorServico.adicionarServico(new Servico(1002, "Mecânica", "Substituição das pastilhas de freio", 300.0, 60, peca2));
    	gerenciadorServico.adicionarServico(new Servico(1003, "Eletrônica", "Troca de bateria", 200.0, 30, peca4));
    	gerenciadorServico.adicionarServico(new Servico(1004, "Eletrônica", "Troca de lâmpadas", 50.0, 15, peca6));
    	
    	Servico servico2 = new Servico(1001, "Manutenção Automotiva", "Troca do filtro de cabine", 79.99, 15, peca1);
    	gerenciadorServico.adicionarServico(servico2);
    	gerenciadorServico.listarServicos();
    	
    	
    	System.out.println("*-* Removendo o servico2 da lista de serviços *-*\n");
    	// remoção do serviço da lista
    	gerenciadorServico.removerServico(servico2);
    	gerenciadorServico.listarServicos();
    	
    	// obtenção de um serviço na lista através da descrição
    	System.out.println("*-* Obtenção do serviço pela descrição 'Troca de óleo' *-*\n");
    	Servico servico1 = gerenciadorServico.retornaServico("Troca de óleo");
    	servico1.imprimirServico();
    	
    	// adiciona responsável pelo serviço
    	gerenciadorServico.adicionarResponsavel(funcionario3, servico1);
    	
    	System.out.println("==================================================");
        
        // criando um usuario novo e logando
        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
        Usuario usuario1 = gerenciadorUsuario.cadastrar();
        //Usuario usuario2 = gerenciadorUsuario.cadastrar();
        gerenciadorUsuario.imprimirUsuarios();
        
        System.out.println("*-* Tentativa Logout sem estar logado *-*\n");
        gerenciadorUsuario.logout();
        gerenciadorUsuario.login();
        
        System.out.println("\n===================================");
       
        
        // criando e adicionando veículos para cada usuário
        GerenciadorVeiculo gerenciadorVeiculo = new GerenciadorVeiculo();
        Veiculo veiculo1 = gerenciadorVeiculo.criarVeiculo();
        gerenciadorUsuario.adicionarVeiculoAoUsuario(veiculo1, usuario1);
        Veiculo veiculo2 = gerenciadorVeiculo.criarVeiculo();
        gerenciadorUsuario.adicionarVeiculoAoUsuario(veiculo2, usuario1);
        
        // lista os veiculos do usuario
        gerenciadorUsuario.listarVeiculosDoUsuario(usuario1);
        
        // remove veículo do usuário
        gerenciadorUsuario.removerVeiculoDoUsuario(veiculo1, usuario1);
        gerenciadorUsuario.listarVeiculosDoUsuario(usuario1);
        
        // retorna lista com veículos de marca específica
        System.out.println("\n*-* Retorna lista com veículos de uma marca específica cadastrados *-*");
        gerenciadorVeiculo.buscarVeiculosPorMarca("Chevrolet");
        
        System.out.println("\n======================================");
        
        GerenciadorAgendamento gerenciadorAgendamento = new GerenciadorAgendamento();
        
        // solicitando um agendamento
        Agendamento agendamento1 = gerenciadorAgendamento.realizarAgendamento(gerenciadorServico, gerenciadorUsuario, usuario1, gerenciadorCentro);
        gerenciadorAgendamento.adicionarAgendamento(agendamento1);
        gerenciadorAgendamento.imprimirAgendamentos();
        
        System.out.println("*-* Tentando agendar um serviço com um já marcado *-*");
        
        // tentando agendar um serviço com um já marcado.
        gerenciadorAgendamento.realizarAgendamento(gerenciadorServico, gerenciadorUsuario, usuario1, gerenciadorCentro);
        
        System.out.println("\n======================================");
        
        // criando um diagnostico e o adicionando a lista de diagnosticos. (OBS.: como o autodiagnóstico é uma funcionalidade em conjunto do chatbot com o python, aqui estamos apenas instanciando com valores já definidos)
        Diagnostico diagnostico1 = new Diagnostico(100001, usuario1, veiculo2, "Sinto ruídos ao freiar", gerenciadorServico.retornaServico("Substituição das pastilhas de freio"), "Freios", "Atenção");
        GerenciadorDiagnostico gerenciadorDiagnostico = new GerenciadorDiagnostico();
        gerenciadorDiagnostico.adicionarDiagnostico(diagnostico1);
        
        // gera um orçamento com base no diagnostico, e imprime o diagnostico + orcamento
        GerenciadorOrcamento gerenciadorOrcamento = new GerenciadorOrcamento();
        Orcamento orcamento1 = gerenciadorOrcamento.gerarOrcamento(diagnostico1);
        diagnostico1.setOrcamento(orcamento1);
        
        // imprime o diagnostico completo
        diagnostico1.imprimirDiagnostico();
        
        System.out.println("\n======================================\n");
        
        System.out.println("*-* Removendo agendamento atual, iniciando agendamento com o diagnóstico criado *-*");
        // cancela agendamento atual, e agenda um novo usando as informações do diagnóstico.
        gerenciadorAgendamento.removerAgendamento(agendamento1);
        Agendamento agendamentoDiagnostico = gerenciadorAgendamento.agendarComDiagnostico(diagnostico1, gerenciadorUsuario, gerenciadorCentro);
        gerenciadorAgendamento.adicionarAgendamento(agendamentoDiagnostico);
        gerenciadorAgendamento.imprimirAgendamentos();
        
        // realiza logout, usuarioLogado é zerado.
        gerenciadorUsuario.logout();
       
        

    }
}