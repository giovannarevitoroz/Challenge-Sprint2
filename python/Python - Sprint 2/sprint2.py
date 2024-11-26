# módulo importado para utilização de regex
import re

# declaração de variáveis
problema = ''
usuarioDados = []
usuarioVeiculo = []
dadosServico = []
# expressões regulares
regexCpf = r'^\d{3}\.\d{3}\.\d{3}-\d{2}$'
regexTel = r'\d{2} 9\d{4}-\d{4}'
regexNome = r"^[A-Za-zÀ-ÿ'\- ]+$"
regexPlaca = r'^[A-Z]{3}-\d{1}[A-Z]{1}\d{2}$'

#peças e a disponibilidade
pecas_dados = {
    'Alinhamento': {'Braço de direção': 10, 'Terminal de direção': 3, 'Coxim do amortecedor': 0, 'Barra axial': 2},
    'Amortecedor e molas': {'Amortecedor dianteiro': 21, 'Amortecedor traseiro': 10, 'Mola dianteira': 23, 'Mola traseira': 0},
    'Ar condicionado': {'Compressor': 2, 'Condensador': 4, 'Evaporador': 6, 'Sensores de temperatura': 5},
    'Arrefecimento': {'Radiador': 10, 'Bomba de água': 20, 'Termostato': 6, 'Mangueira de radiador': 4},
    'Balanceamento': {'Pneus': 54, 'Rodas': 42, 'Contrapesos': 0, 'Porcas de fixação': 102},
    'Bateria': {'Bateria 40ah': 10, 'Bateria 60ah': 23, 'Cabos de ligação': 32, 'Cabos da bateria': 54},
    'Cambagem / caster': {'Cambagem dianteira': 10, 'Cambagem traseira': 13, 'Caster dianteiro': 32, 'Caster traseiro': 14},
    'Correias do Motor': {'Correia dentada': 2, 'Correia do alternador': 6, 'Correia da direção hidráulica': 0, 'Correia do ar condicionado': 9},
    'Freio': {'Discos de freio dianteiros': 43, 'Discos de freio traseiros': 53, 'Pastilhas de freio dianteiras': 32, 'Pastilhas de freio traseiras': 54},
    'Embreagens': {'Disco de embreagem': 5, 'Platô': 4, 'Atuador hidráulico': 10, 'Cilindro mestre': 15},
    'Filtros': {'Filtro de ar': 30, 'Filtro de óleo': 40, 'Filtro de combustível': 45, 'Filtro de cabine': 23},
    'Óleo do motor': {'Óleo lubrificante 5W-30': 32, 'Óleo lubrificante 10W-40': 24, 'Filtro de óleo': 12, 'Tampão do cárter': 12},
    'Palhetas do limpador': {'Palheta do limpador dianteiro': 10, 'Palheta do limpador traseiro':10, 'Braço do limpador dianteiro': 0, 'Braço do limpador traseiro': 0},
    'Suspensão': {'Braço oscilante': 10, 'Pivô': 21, 'Barra estabilizadora': 32, 'Batente de suspensão': 10},
    'Ignição': {'Vela de ignição': 21, 'Bobina de ignição': 32, 'Cabos de vela': 21, 'Sensor de posição': 0}
}

# preços dos serviços
servicos_preco = {'Ar-condicionado': 75, 'Arrefecimento': 100, 'Freios': 200, 'Filtros e Velas': 50, 'Balanceamento': 200, 'Alinhamento de Rodas': 75, 'Elétrica': 75, 'Óleo do Motor': 75}

#marcas disponiveis
marcas = {
        'Chevrolet': {'Corsa': [1995, 2002, 2009], 'Onix': [2012, 2017, 2021], 'Prisma': [2006, 2013, 2018]},
        'Ford':{'Ka': [1997, 2005, 2012], 'EcoSport': [2003, 2010, 2018], 'Focus': [1998, 2008, 2015]},
        'Honda': {'Civic': [1996, 2004, 2011], 'Fit': [2001, 2008, 2015], 'HR-V': [2014, 2017, 2020]},
        'Volkswagen': {'Gol': [1980, 1998, 2012], 'Polo': [1995, 2002, 2010], 'Jetta': [1984, 1999, 2007]},
        'Toyota': {'Corolla': [1990, 2002, 2010], 'Hilux': [1998, 2005, 2013], 'Etios': [2010, 2015, 2020]},
        'Hyundai': {'HB20': [2012, 2016, 2020], 'Tucson': [2004, 2010, 2016], 'Creta': [2014, 2018, 2022]},
        'Fiat': {'Uno': [1983, 1996, 2004], 'Argo': [2017, 2020, 2023], 'Toro': [2016, 2019, 2022]},
        'Nissan': {'March': [2002, 2010, 2018], 'Versa': [2006, 2013, 2020], 'Kicks': [2016, 2019, 2023]},
        'Jeep': {'Renegade': [2014, 2017, 2021], 'Compass': [2006, 2012, 2018], 'Grand Cherokee': [1992, 2005, 2014]},
        'Renault': {'Kwid': [2015, 2018, 2022], 'Sandero': [2008, 2014, 2019], 'Duster': [2010, 2015, 2020]}
    }

# localização de oficinas da Porto
oficinas = {
    'Lins de Vasconcelos': 'Av. Lins de Vasconcelos, 2474 - Vila Mariana, São Paulo - SP, 04112-001',
    'Conceição': 'Av. Diederichsen, 1426 - Vila Guarani (Zona Sul), São Paulo - SP, 04310-001',
    'São Caetano do Sul': 'Av. Sen. Roberto Símonsen, 1305 - Cerâmica, São Caetano do Sul - SP, 09530-402', 
    'Jardim Paulista': 'Av. Brigadeiro Luís Antônio, 3383 - Jardim Paulista, São Paulo - SP, 01401-001',
    'Ipiranga': 'R. Silva Bueno, 1176 - Ipiranga, São Paulo - SP, 04208-000',
    'Bosque da Saúde': 'Av. Bosque da Saúde, 1276 - Jabaquara, São Paulo - SP, 04142-082',
    'Vila Mariana': 'R. França Pinto, 1115 - Vila Mariana, São Paulo - SP, 04016-034',
    'Campo Belo': 'R. Otávio Tarquínio de Sousa, 304 - Campo Belo, São Paulo - SP, 04613-000',
    'Planalto Paulista': 'Av. dos Bandeirantes, 5024 - Planalto Paulista, São Paulo - SP, 04071-000',
    'Mooca': 'Rua dos Trilhos, 1327 - Alto da Mooca, São Paulo - SP, 03168-009' 
}

# datas ficticias para servicos
datas = ['20/05', '21/05', '22/05', '23/05', '24/05', '25/05', '26/05']

# cadastro do usuario
def cadastro_usuario():
    print("Iniciando cadastro do usuário...\n")
    if len(usuarioDados) > 0:
        print("Você já está cadastrado. Irei te redirecionar para o menu...")
        return
    # cadastro nome
    while True:
        nome = input("Digite o seu nome........................: ")
        if re.match(regexNome, nome) is None:
            print("Digite um nome válido.")
            continue
        else:
            usuarioDados.append(nome)
            break 
    # cadastro idade   
    while True:
        idade = input("Digite sua idade.........................: ")
        if not idade.isdigit() or int(idade) < 18 or int(idade) > 90:
            print("Digite uma idade válida.")
            continue
        else:
            usuarioDados.append(idade)
            break
    # cadastro CPF
    while True:
        cpf = input("Digite o seu CPF (ex: xxx.xxx.xxx-xx)....: ")
        if re.match(regexCpf, cpf) is None:
            print("Digite um CPF válido.")
            continue
        else:
            usuarioDados.append(cpf)
            break
    # cadastro endereço
    while True:
        endereco = input("Digite o seu endereço....................: ")
        if re.match(regexNome, endereco) is None:
            print("Digite um endereço válido.")
            continue
        else:
            usuarioDados.append(endereco)
            break
    # cadastro telefone
    while True:
        telefone = input("Digite o seu telefone (ex: xx xxxxx-xxxx): ")
        if re.match(regexTel, telefone) is None:
            print("Digite um número de telefone válido.")
            continue
        else: 
            usuarioDados.append(telefone)
            break
    print("\nUsuário cadastrado com sucesso!")

#cadastro do veiculo
def cadastro_veiculo():
    print("Iniciando cadastro de veículo...\n")
    if len(usuarioVeiculo) > 0:
        print("Você já possui um veículo cadastrado. Irei te redirecionar para o menu...")
        return
    # cadastro marca através de um menu
    while True:
        print("==============[ MARCA ]==============\n")
        for i in range(len(marcas)):
            print(f"{i:<2} - {list(marcas)[i]}")
        marca = input("\nSelecione a marca do seu carro...........: ")
        if not marca.isdigit() or (int(marca) >= 10 or int(marca) < 0):
            print("\nSelecione uma opção válida.\n")
            continue
        else:
            marca = int(marca)
            usuarioVeiculo.append(list(marcas.keys())[marca])
            break
    # cadastro modelo através de um menu
    while True:
        print("\n==============[ MODELO ]==============\n")
        for i in range(len(marcas[usuarioVeiculo[0]])):
            print(f"{i} - {list(marcas[usuarioVeiculo[0]])[i]}")
        modelo = input("\nSelecione o modelo do seu carro..........: ")
        if not modelo.isdigit() or (int(modelo) > 2 or int(modelo) < 0):
            print("\nSelecione uma opção válida.")
            continue
        else:
            modelo = int(modelo)
            usuarioVeiculo.append(list(marcas[usuarioVeiculo[0]].keys())[modelo])
            break
    # cadastro do ano do veículo
    while True:
        print("\n==============[ ANO ]==============\n")
        for i in range(len(marcas[usuarioVeiculo[0]][usuarioVeiculo[1]])):
            print(f"{i} - {list(marcas[usuarioVeiculo[0]][usuarioVeiculo[1]])[i]}")
        ano = input("\nSelecione o ano do seu carro.............: ")
        if not ano.isdigit() or (int(ano) > 2 or int(ano) < 0):
            print("\nSelecione uma opção válida.")
            continue
        else:
            ano = int(ano)
            usuarioVeiculo.append(marcas[usuarioVeiculo[0]][usuarioVeiculo[1]][ano])
            break
    # cadastro da placa do veículo
    while True:
        placaVeiculo = input("Qual a placa do seu carro? (ex: ABC-1D23): ")
        if re.match(regexPlaca, placaVeiculo) is None:
            print("Insira um formato de placa válido.")
            continue
        else:
            usuarioVeiculo.append(placaVeiculo)
            break
    print("\nVeículo foi cadastrado com sucesso!")

#remover usuario 
def deletar_usuario():
    while True:
        if not usuarioDados:
            print("\nVocê não está cadastrado ainda.")
            break
        op_delete = input("\nDeseja realmente deletar o seu cadastro? S ou N: ")
        if op_delete.upper() != "S" and op_delete.upper() != "N":
            print("\nDigite uma opção válida.")
            continue
        elif op_delete.upper() == "S":
            usuarioDados.clear()
            print("\nCadastro removido com sucesso.")
            break
        elif op_delete.upper() == "N":
            print("\nO cadastro não foi removido.")
            break

#remover veiculo
def deletar_veiculo():
    while True:
        if not usuarioVeiculo:
            print("\nVocê não possui nenhum veículo registrado.")
            break
        op_delete = input("\nDeseja realmente remover o veículo? S ou N: ")
        if op_delete.upper() != "S" and op_delete.upper() != "N":
            print("\nDigite uma opção válida.")
            continue
        elif op_delete.upper() == "S":
            usuarioVeiculo.clear()
            print("\nVeículo removido com sucesso.")
            break
        elif op_delete.upper() == "N":
            print("\nO veículo não foi removido.")
            break
            
# visualização das informações do usuário (Nome, Idade, CPF, endereço e telefone)
def gerenciar_usuario(usuarioDados):
        print("\nIniciando menu de gerenciamento do usuário...") 
        while True:
            if usuarioDados == []:
                print("\nVocê ainda não se cadastrou.")
                break
            print("\n==============[ GERENCIAMENTO USUÁRIO ]==============\n")
            print("1 - Remover usuário")
            print("2 - Visualizar informações do usuário")
            print("0 - Sair")
            verif_usuario_op = input("\nSelecione uma opção: ")
            if not verif_usuario_op.isdigit() or int(verif_usuario_op) > 2 or int(verif_usuario_op) < 0:
                print("\nSelecione uma opção válida.")
                continue
            verif_usuario_op = int(verif_usuario_op)
            if verif_usuario_op == 0:
                break
            elif verif_usuario_op == 1:
                deletar_usuario()
                break
            elif verif_usuario_op == 2:
                print("\n==============[ INFORMAÇÕES DO USUÁRIO ]==============\n") 
                print(f"Nome....: {usuarioDados[0]}") 
                print(f"Idade...: {usuarioDados[1]}") 
                print(f"CPF.....: {usuarioDados[2]}") 
                print(f"Endereço: {usuarioDados[3]}") 
                print(f"Telefone: {usuarioDados[4]}\n") 
                input("Pressione ENTER para voltar ao menu: ")
                print("Retornando ao menu do usuário...")
                continue

# visualização das informações do veículo (Marca, modelo, ano e placa)
def gerenciar_veiculo(usuarioVeiculo):
    print("\nIniciando menu de gerenciamento do veículo...")
    while True:
        if usuarioVeiculo == []:
            print("\nVocê ainda não cadastrou o veículo.")
            break
        print("\n==============[ GERENCIAMENTO VEÍCULO ]==============\n")
        print("1 - Remover veículo")
        print("2 - Visualizar informações do veículo")
        print("0 - Sair")
        verif_veic_op = input("\nSelecione uma opção: ")
        if not verif_veic_op.isdigit() or int(verif_veic_op) > 2 or int(verif_veic_op) < 0:
            print("\nSelecione uma opção válida.")
            continue
        verif_veic_op = int(verif_veic_op)
        if verif_veic_op == 0:
            break
        elif verif_veic_op == 1:
            deletar_veiculo()
            break
        elif verif_veic_op == 2:
            print("\n==============[ INFORMAÇÕES DO VEÍCULO ]==============\n") 
            print(f"Marca.....: {usuarioVeiculo[0].capitalize()}") 
            print(f"Modelo....: {usuarioVeiculo[1]}") 
            print(f"Ano.......: {usuarioVeiculo[2]}") 
            print(f"Placa.....: {usuarioVeiculo[3]}\n")
            input("Pressione ENTER para voltar ao menu: ")
            print("Retornando ao menu do veículo...")
            continue

# pré-diagnóstico básico, apenas com if e palavras-chave
def auto_diagnostico(usuarioVeiculo, usuarioDados):
    print("\nIniciando autodiagnóstico...")
    while True:
        if usuarioVeiculo == [] and usuarioDados == []:
            print("\nVocê não possui um veículo cadastrado e nem se cadastrou.")
            break
        elif usuarioVeiculo == []:
            print("\nVocê não cadastrou nenhum veículo.")
            break
        elif usuarioDados == []:
            print("\nVocê não se cadastrou.")
            break
        problema = (input("\nQual o problema enfrentado no carro?: ")).lower()
        if 'ar-condicionado' in problema or 'ar condicionado' in problema or 'gelando' in problema or 'esfriando' in problema:
            print("\nO problema apresentado está relacionado a alguma peça do ar-condicionado.")
            problema = 'Ar-condicionado'
            return problema
        elif 'superaquecimento' in problema or 'motor' in problema or 'aquecendo' in problema:
            print("\nO problema apresentado está relacionado ao sistema de arrefecimento, possivelmente afetado por uma falha na bomba d'água ou vazamento no radiador.")
            problema = 'Arrefecimento'
            return problema
        elif 'freio' in problema or 'frear' in problema or 'freiar' in problema or 'frenagem' in problema:
            print("\nO problema apresentado está relacionado aos discos e pastilhas de freio.")
            problema = 'Freios'
            return problema
        elif 'devagar' in problema or 'lento' in problema or 'potência' in problema or 'aceleração' in problema:
            print("\nO problema apresentado está relacionado ao desempenho do motor, possivelmente afetado por problemas de filtragem ou falhas nas velas de ignição.")
            problema = 'Filtros e Velas'
            return problema
        elif 'volante' in problema or 'tremer' in problema or 'tremendo' in problema or 'vibração' in problema or 'vibrando' in problema or 'pneu' in problema or 'roda' in problema:
            print("\nO problema apresentado está relacionado ao balanceamento das rodas.")
            problema = 'Balanceamento'
            return problema
        elif 'desalinhado' in problema or 'puxando' in problema or 'volante desalinhado' in problema:
            print('\nO problema apresentado está relacionado ao desalinhamento das rodas.')
            problema = 'Alinhamento de Rodas'
            return problema
        elif 'não liga' in problema or 'partida' in problema or 'luz fraca' in problema or 'elétrica' in problema:
            print("\nO problema apresentado está em alguma parte elétrica do carro (bateria, cabos, ignição)")
            problema = 'Elétrica'
            return problema
        elif 'óleo' in problema or 'nível de óleo baixo' in problema or 'vazamento' in problema:
            print("\nO problema apresentado está relacionado ao óleo do motor do carro.")
            problema = 'Óleo do Motor'
            return problema
        else:
            print("Problema não registrado.")
            continue

# auto-orçamento com base no pré-diagnóstico
def auto_orcamento(problemaUsuario, usuarioVeiculo, usuarioDados):
    while True:
        print("\nIniciando auto orçamento...")
        # o autoorçamento só será feito caso o problema tenha sido descoberto no pré-diagnóstico.
        if usuarioVeiculo == [] and usuarioDados == []:
            print("\nVocê não possui um veículo cadastrado e nem se cadastrou.")
            break
        elif usuarioVeiculo == []:
            print("\nVocê não cadastrou nenhum veículo.")
            break
        elif usuarioDados == []:
            print("\nVocê não se cadastrou.")
            break
        elif not problemaUsuario:
            print("\nVocê não fez um autodiagnóstico ainda.")
            break
        else:
            for servico, preco in servicos_preco.items():
                if servico == problemaUsuario:
                    print("\n==============[ ORÇAMENTO ]==============\n")
                    print(f"Problema...........: {servico}")
                    print(f"Preço do serviço...: R${preco:.2f}")
                    input("\nPressione ENTER para voltar ao menu: ")
                    print("Retornando ao menu principal...")
            break

# verificar a disponibilidade de determinada peça
def disponibilidade_pecas():
    print("Iniciando verificação da disponibilidade de peça...")
    while True:
        print("\n==============[ CONJUNTOS ]==============\n")
        for i in range(len(pecas_dados)):
            print(f"{i+1:<2d} - {list(pecas_dados)[i]}")
        print("0  - Sair\n")
        option_pecas = input("Selecione um dos conjuntos para continuar: ")
        if not option_pecas.isdigit() or (int(option_pecas) > 15 or int(option) < 0):
            print("\nSelecione uma opção válida.")
            continue
        option_pecas = int(option_pecas)
        if option_pecas == 0:
            print("Retornando ao menu principal...")
            break
        if 1 <= option_pecas <= 15:
            i = option_pecas - 1
            # obtem a chave da opção selecionada
            chave = list(pecas_dados.keys())[i]
            # imprime o conjunto selecionado e as peças, juntamente com a quantidade disponível
            print(f"\n==============[ PEÇAS - {chave.upper()} ]==============\n") 
            for peca, disponivel in pecas_dados[chave].items():
                if disponivel == 0:
                    print(f"{peca:<30} - {'Peça indisponível'}")
                elif disponivel == 1:
                    print(f"{peca:<30} - {disponivel:>2} disponível")
                else:
                    print(f"{peca:<30} - {disponivel:>2} disponíveis")
        input("\nPressione ENTER para voltar ao menu de peças: ")
        print("Retornando ao menu de peças...")

# mostra a localização de todas as oficinas
def localizacao_oficinas():
    while True:
        print("\n==============[ OFICINAS ]==============\n")
        for oficina, localizacao in oficinas.items():
            print(f"{oficina:.<20}: {localizacao}")
        input("\nPressione ENTER para voltar ao menu principal: ")
        print("Retornando ao menu principal...")
        break

# agenda um serviço para o usuário
def agendar_servico(usuarioDados, usuarioVeiculo):
    print("Iniciando agendamento do serviço...")
    while True:
        if usuarioDados == [] and usuarioVeiculo == []:
            print("\nVocê ainda não se cadastrou nem cadastrou um veículo.")
            break
        elif usuarioVeiculo == []:
            print("\nVocê ainda não cadastrou um veículo.")
            break
        elif usuarioDados == []:
            print("\nVocê ainda não se cadastrou.")
            break
        elif dadosServico != []:
            print("\nVocê já possui um agendamento marcado.")
            break
        while True:
            print("\n==============[ SERVIÇOS ]==============\n")
            for i in range(len(list(servicos_preco))):
                print(f"{i} - {list(servicos_preco)[i]}")
            op_servico = input("\nQual serviço deseja realizar?: ")
            if not op_servico.isdigit() or int(op_servico) > 7 or int(op_servico) < 0:
                print("\nSelecione uma opção válida.")
                continue
            else: 
                op_servico = int(op_servico)
                dadosServico.append(list(servicos_preco)[op_servico])
                break
        while True:
            print("\n==============[ OFICINAS ]==============\n")
            for i in range(len(list(oficinas))):
                print(f"{i} - {list(oficinas)[i]}")
            op_oficina = input("\nEm qual oficina deseja realizar o serviço?: ")
            if not op_oficina.isdigit() or int(op_oficina) > 9 or int(op_oficina) < 0:
                print("\nSelecione uma opção válida.")
                continue
            else: 
                op_oficina = int(op_oficina)
                dadosServico.append(list(oficinas)[op_oficina])
                break
        while True:
            print("\n==============[ DATAS ]==============\n")
            for i in range(len(datas)):
                print(f"{i} - {datas[i]}")
            op_data = input("\nQual a data que deseja realizar o serviço?: ")
            if not op_data.isdigit() or int(op_data) > 6 or int(op_data) < 0:
                print("\nSelecione uma opção válida.")
                continue
            else: 
                op_data = int(op_data)
                dadosServico.append(datas[op_data])
                break
        print("\nServiço agendado com sucesso!")
        break

# deletar o agendamento feito
def deletar_agendamento():
    while True:
        if not dadosServico:
            print("\nVocê não agendou um serviço ainda.")
            break
        op_delete = input("\nDeseja realmente remover o seu agendamento? S ou N: ")
        if op_delete.upper() != "S" and op_delete.upper() != "N":
            print("\nDigite uma opção válida.")
            continue
        elif op_delete.upper() == "S":
            dadosServico.clear()
            print("\nAgendamento removido com sucesso.")
            break
        elif op_delete.upper() == "N":
            print("\nO agendamento não foi removido.")
            break

# gerenciar o serviço agendado
def gerenciar_servico(dadosServico):
    print("\nIniciando menu de gerenciamento do serviço...") 
    while True:
        if dadosServico == []:
            print("\nVocê ainda não agendou um serviço.")
            break
        print("\n==============[ GERENCIAMENTO SERVIÇO ]==============\n")
        print("1 - Remover agendamento de serviço")
        print("2 - Visualizar informações do agendamento")
        print("0 - Sair")
        verif_gerenc_op = input("\nSelecione uma opção: ")
        if not verif_gerenc_op.isdigit() or int(verif_gerenc_op) > 2 or int(verif_gerenc_op) < 0:
            print("\nSelecione uma opção válida.")
            continue
        verif_gerenc_op = int(verif_gerenc_op)
        if verif_gerenc_op == 0:
            break
        elif verif_gerenc_op == 1:
            deletar_agendamento()
            break
        elif verif_gerenc_op == 2:
            print("\n==============[ INFORMAÇÕES DO AGENDAMENTO ]==============\n") 
            print(f"Serviço....: {dadosServico[0]}") 
            print(f"Oficina....: {dadosServico[1]}") 
            print(f"Data.......: {dadosServico[2]}") 
            input("\nPressione ENTER para voltar ao menu: ")
            print("\nRetornando ao menu do serviço...")
            continue


# menu inicial
while True:
    print("\n==============[ MENU ]==============\n")
    print("1  - Cadastro Usuário")
    print("2  - Cadastro Veículo")
    print("3  - Gerenciar Usuário")
    print("4  - Gerenciar Veículo")
    print("5  - Autodiagnóstico")
    print("6  - Auto orçamento")
    print("7  - Disponibilidade de peças")
    print("8  - Localização das oficinas")
    print("9  - Agendar Serviço")
    print("10 - Gerenciar Serviço")
    print("0  - Sair\n")
    option = input("Opção: ")
    if not option.isdigit() or (int(option) > 10 or int(option) < 0):
        print("\nSelecione uma opção válida.")
        continue
    option = int(option)
    if option == 0:
        print("\nSolicitação encerrada.\n")
        break
    elif option == 1:
        cadastro_usuario()
    elif option == 2:
        cadastro_veiculo()      
    elif option == 3:
        gerenciar_usuario(usuarioDados)
    elif option == 4:
        gerenciar_veiculo(usuarioVeiculo)
    elif option == 5:
        problema = auto_diagnostico(usuarioVeiculo, usuarioDados)
    elif option == 6:
        auto_orcamento(problema, usuarioVeiculo, usuarioDados)
    elif option == 7:
        disponibilidade_pecas()
    elif option == 8:
        localizacao_oficinas()
    elif option == 9:
        agendar_servico(usuarioDados, usuarioVeiculo)
    elif option == 10:
        gerenciar_servico(dadosServico)