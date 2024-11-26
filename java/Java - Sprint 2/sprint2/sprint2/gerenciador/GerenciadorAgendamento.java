package sprint2.gerenciador;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sprint2.model.Agendamento;
import sprint2.model.CentroAutomotivo;
import sprint2.model.Diagnostico;
import sprint2.model.Servico;
import sprint2.model.Usuario;
import sprint2.model.Veiculo;

public class GerenciadorAgendamento {
    private ArrayList<Agendamento> agendamentos;
    private Scanner scanner;
    
    public GerenciadorAgendamento() {
        this.agendamentos = new ArrayList<Agendamento>();
    }

    public Agendamento realizarAgendamento(GerenciadorServico gs, GerenciadorUsuario gu, Usuario usuario, GerenciadorCentro gc) {
    	System.out.println("\n*-* INICIANDO AGENDAMENTO *-*\n");
    	scanner = new Scanner(System.in);
    	Pattern regexHora = Pattern.compile("^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])(:([0-5][0-9]))?$");
    	Pattern regexData = Pattern.compile("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])$");
    	boolean marcou = false;
    	Agendamento agendamento = new Agendamento();
    	while (true) {
    		if (gu.getUsuarioLogado() != usuario) {
    			System.out.println("Você não está logado. Realize o login primeiro.");
    			break;
    		} else {
    			for (Agendamento agendamentoDoUsuario : agendamentos) {
    				if (agendamentoDoUsuario.getUsuario() == usuario) {
    					marcou = true;
    					System.out.println("Você já possui um agendamento marcado.");
    					break;
    				}
    			}
    			if (marcou == true) {
    				break;
    			} else {
    				agendamento.setUsuario(usuario);
    			}	
    		}
    		while (true) {
	        	System.out.print("Qual a data do agendamento?: ");
	            String inputData = scanner.nextLine();
	            Matcher matcherData = regexData.matcher(inputData);
	            if (matcherData.matches()) {
	            	agendamento.setData(inputData);
	            	break;
	            } else {
	            	System.out.println("Data inválida.");
	            	continue;
	            }
	        }
    		while (true) {
    	        System.out.print("Qual o horário do agendamento?: ");
    	        String inputHora = scanner.nextLine();
    	        Matcher matcherHora = regexHora.matcher(inputHora);
    	           if (matcherHora.matches()) {
    	        	   agendamento.setHora(inputHora);
    	        	   break;
    	            } else {
    	            	System.out.println("Horário inválido.");
    	            	continue;
    	            }
    	        }
    		while(true) {
        		System.out.println("Qual serviço deseja agendar?: ");
        		String inputServico = scanner.nextLine();
        		for (Servico servico : gs.retornaListaServicos()) {
        			if (servico.getDescricaoServico().equalsIgnoreCase(inputServico)) {
        				if (servico.getPeca().isDisponibilidadePeca() == true) {
        					agendamento.setServico(servico); 
            				break;
        				} else {
        					System.out.println("A peça utilizada no serviço está indisponível.");
        					break;
        				}
        			} 
        		}
        		if (agendamento.getServico() != null) {
        			break;
        		} else {
        			System.out.println("Serviço indisponível. Escolha outro.");
        			continue;
        		}
        	}
        	while(true) {
        		System.out.println("Qual centro deseja realizar o serviço?: ");
        		String inputCentro = scanner.nextLine();
        		for (CentroAutomotivo centro : gc.retornaListaCentros()) {
        			if (centro.getNomeCentro().equalsIgnoreCase(inputCentro)) {
        				agendamento.setCentro(centro); 
        				break;
        			} 
        		}
        		if (agendamento.getCentro() != null) {
        			break;
        		} else {
        			System.out.println("O Centro Automotivo informado não está registrado em nosso sistema.");
        			continue;
        		}
        	}
        	while(true) {
        		System.out.println("Em qual veículo será realizado o serviço? (informe a placa): ");
        		String inputPlacaVeiculo = scanner.nextLine();
        		for (Veiculo veiculo : usuario.getVeiculos()) {
        			if (veiculo.getPlaca().equalsIgnoreCase(inputPlacaVeiculo)) {
        				agendamento.setVeiculo(veiculo);
        				break;
        			} 
        		}
        		if (agendamento.getVeiculo() != null) {
        			break;
        		} else {
        			System.out.println("A placa informada está incorreta ou o veículo não foi registrado.");
        			continue;
        		}
        	}
        	System.out.println("\nAgendamento realizado com sucesso!\n");
        	break;
    	}
    	return agendamento;
    }
    
    public Agendamento agendarComDiagnostico(Diagnostico diagnostico, GerenciadorUsuario gu, GerenciadorCentro gc) {
    	System.out.println("\n*-* INICIANDO AGENDAMENTO COM DIAGNÓSTICO *-*\n");
    	scanner = new Scanner(System.in);
    	Pattern regexHora = Pattern.compile("^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])(:([0-5][0-9]))?$");
    	Pattern regexData = Pattern.compile("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])$");
    	boolean marcou = false;
    	Agendamento agendamento = new Agendamento();
    	while (true) {
    		if (gu.getUsuarioLogado() != diagnostico.getUsuario()) {
    			System.out.println("Você não está logado. Realize o login primeiro.");
    			break;
    		} else {
    			for (Agendamento agendamentoDoUsuario : agendamentos) {
    				if (agendamentoDoUsuario.getUsuario() == diagnostico.getUsuario()) {
    					marcou = true;
    					System.out.println("Você já possui um agendamento marcado.");
    					break;
    				}
    			}
    			if (marcou == true) {
    				break;
    			} else {
    				agendamento.setUsuario(diagnostico.getUsuario());
    			}	
    		}
    		while (true) {
	        	System.out.print("Qual a data do agendamento?: ");
	            String inputData = scanner.nextLine();
	            Matcher matcherData = regexData.matcher(inputData);
	            if (matcherData.matches()) {
	            	agendamento.setData(inputData);
	            	break;
	            } else {
	            	System.out.println("Data inválida.");
	            	continue;
	            }
	        }
    		while (true) {
    	        System.out.print("Qual o horário do agendamento?: ");
    	        String inputHora = scanner.nextLine();
    	        Matcher matcherHora = regexHora.matcher(inputHora);
    	           if (matcherHora.matches()) {
    	        	   agendamento.setHora(inputHora);
    	        	   break;
    	            } else {
    	            	System.out.println("Horário inválido.");
    	            	continue;
    	            }
    	        }
    		while(true) {
        		System.out.println("Qual centro deseja realizar o serviço?: ");
        		String inputCentro = scanner.nextLine();
        		for (CentroAutomotivo centro : gc.retornaListaCentros()) {
        			if (centro.getNomeCentro().equalsIgnoreCase(inputCentro)) {
        				agendamento.setCentro(centro); 
        				break;
        			} 
        		}
        		if (agendamento.getCentro() != null) {
        			break;
        		} else {
        			System.out.println("O Centro Automotivo informado não está registrado em nosso sistema.");
        			continue;
        		}
        	}
    		System.out.println("\nAgendamento realizado com sucesso!\n");
        	break;
    	}
    	agendamento.setVeiculo(diagnostico.getVeiculo());
    	agendamento.setServico(diagnostico.getSolucao());
    	return agendamento;
    }
    	
 
    
    public void adicionarAgendamento(Agendamento agendamento) {
    	agendamentos.add(agendamento);
    }
    
    public void removerAgendamento(Agendamento agendamento) {
    	agendamentos.remove(agendamento);
    }
    
    public ArrayList<Agendamento> retornaListaAgendamentos() {
    	return agendamentos;
    }
    
    public void imprimirAgendamentos() {
    	System.out.println("\n*-* LISTA DE AGENDAMENTOS *-*\n");
    	for (Agendamento agendamento : agendamentos) {
    		agendamento.imprimirAgendamento();
    	}
    }
}
