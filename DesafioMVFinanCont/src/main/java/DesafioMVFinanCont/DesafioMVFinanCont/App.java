package DesafioMVFinanCont.DesafioMVFinanCont;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import dao.ClienteDao;
import dao.ContaDao;
import dao.EnderecoDao;
import dao.MovimentacoesDao;
import dao.impl.ClienteDaoImpl;
import dao.impl.ContaDaoImpl;
import dao.impl.EnderecoDaoImpl;
import dao.impl.MovimentacoesDaoImpl;
import entidade.Cliente;
import entidade.Conta;
import entidade.Endereco;
import entidade.Menu;
import entidade.Movimentacoes;

public class App {
	public static void main(String[] args) {

		Date data = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

		Endereco end = new Endereco();
		EnderecoDao enderecoDao = new EnderecoDaoImpl();

		Conta cont = new Conta();
		ContaDao contaDao = new ContaDaoImpl();
		List<Conta> listaConta = new ArrayList<Conta>();

		Cliente cli = new Cliente();
		ClienteDao clienteDao = new ClienteDaoImpl();

		Movimentacoes mov = new Movimentacoes();
		MovimentacoesDao movDao = new MovimentacoesDaoImpl();
		List<Movimentacoes> listaMov = new ArrayList<Movimentacoes>();

		int menu = 0;
		Scanner fcInt = new Scanner(System.in);
		Scanner fcString = new Scanner(System.in);

		do {
			Menu.menu();
			Menu.subMenu();
			System.out.println("Informe a op??o desejada: ");
			menu = fcInt.nextInt();

			switch (menu) {

			case 1: // Cadastros
				Menu.menu();
				Menu.opCad();
				System.out.println("Informe a op??o desejada: ");
				int opcao = fcInt.nextInt();

				switch (opcao) {

				case 1: // Novo Cadastro
					Menu.menu();
					Menu.opcao();
					System.out.println("Informe a op??o desejada: ");
					int resp = fcInt.nextInt();
					if (resp == 1) { // Novo Cadastro Cliente
						System.out.println("Informe 1-PJ / 2-PF: ");
						int op = fcInt.nextInt();
						if (op == 1) {
							System.out.println("Informe o Cnpj: ");
							cli.setCpfCnpj(fcString.nextLine());
							System.out.println("Informe a Insc.Estadual: ");
							cli.setIe(fcString.nextLine());
						} else {
							System.out.println("Informe o CPF: ");
							cli.setCpfCnpj(fcString.nextLine());
							System.out.println("Informe o RG: ");
							cli.setRg(fcString.nextLine());
						}
						System.out.println("\nInforme o Nome: ");
						cli.setNome(fcString.nextLine());
						System.out.println("Informe o Telefone");
						cli.setTelefone(fcString.nextLine());

						System.out.println("Informe a Rua: ");
						end.setRua(fcString.nextLine());
						System.out.println("\nInforme o N?mero: ");
						end.setNumero(fcInt.nextInt());
						System.out.println("\nInforme o Complemento: ");
						end.setComplemento(fcString.nextLine());
						System.out.println("\nInforme o Bairro: ");
						end.setBairro(fcString.nextLine());
						System.out.println("\nInforme o Cep: ");
						end.setCep(fcInt.nextInt());
						System.out.println("\nInforme a Cidade: ");
						end.setCidade(fcString.nextLine());
						System.out.println("\nInforme a Uf: ");
						end.setUf(fcString.nextLine());
						System.out.println("Informe o N?mero da Conta: ");
						cont.setNumero(fcString.nextLine());
						cont.setStatusConta("A");
						cont.setCliente(cli);
						listaConta.add(cont);
						System.out.println("Deseja Cadastrar mais Contas? 1-Sim / 2-N?o: ");
						int cadConta = fcInt.nextInt();
						while (cadConta == 1) {

							System.out.println("Informe o N?mero da Conta: ");
							cont.setNumero(fcString.nextLine());
							cont.setStatusConta("A");
							cont.setCliente(cli);
							listaConta.add(cont);
							System.out.println("Deseja Cadastrar mais Contas? 1-Sim / 2-N?o: ");
							cadConta = fcInt.nextInt();
						}
						System.out.println("Informe o Saldo Inicial: ");
						cli.setSaldoInicial(fcInt.nextDouble());
						cli.setSaldoAtual(cli.getSaldoInicial());
						System.out.println("Informe a data de cadastro(dd/mm/aaaa): ");
						cli.setDtCadastro(fcString.nextLine());
						// cli.setDtCadastro(date.format(data));
						cli.setEndereco(end);
						cli.setListaConta(listaConta);

						clienteDao.salvar(cli);

					} else if (resp == 2) { // Novo Cadastro Endere?o
						System.out.println("Informe a Rua: ");
						end.setRua(fcString.nextLine());
						System.out.println("\nInforme o N?mero: ");
						end.setNumero(fcInt.nextInt());
						System.out.println("\nInforme o Complemento: ");
						end.setComplemento(fcString.nextLine());
						System.out.println("\nInforme o Bairro: ");
						end.setBairro(fcString.nextLine());
						System.out.println("\nInforme o Cep: ");
						end.setCep(fcInt.nextInt());
						System.out.println("\nInforme a Cidade: ");
						end.setCidade(fcString.nextLine());
						System.out.println("\nInforme a Uf: ");
						end.setUf(fcString.nextLine());

						enderecoDao.salvar(end);

					} else if (resp == 3) { // Novo Cadastro Conta
						System.out.println("Informe o N?mero da Conta: ");
						cont.setNumero(fcString.nextLine());
						cont.setStatusConta("A");

						contaDao.salvar(cont);

					}

					break;

				case 2: // Altera??es
					Menu.menu();
					Menu.opcao();
					System.out.println("Informe a op??o desejada: ");
					int op = fcInt.nextInt();
					if (op == 1) { // Altera??o Cliente

						System.out.println("Informe 1-PJ / 2-PF: ");
						int tipo = fcInt.nextInt();
						if (tipo == 1) {
							System.out.println("Informe o Cnpj: ");
							cli.setCpfCnpj(fcString.nextLine());
							System.out.println("Informe a Insc.Estadual: ");
							cli.setIe(fcString.nextLine());
						} else {
							System.out.println("Informe o CPF: ");
							cli.setCpfCnpj(fcString.nextLine());
							System.out.println("Informe o RG: ");
							cli.setRg(fcString.nextLine());
						}
						Cliente cliente = clienteDao.pesquisar(cli);
						cli = cliente;

						if (tipo == 1) {
							System.out.println("Informe o  Cnpj: ");
							cli.setCpfCnpj(fcString.nextLine());
							System.out.println("Informe a  Insc.Estadual: ");
							cli.setIe(fcString.nextLine());
						} else {
							System.out.println("Informe o CPF: ");
							cli.setCpfCnpj(fcString.nextLine());
							System.out.println("Informe o RG: ");
							cli.setRg(fcString.nextLine());
						}
						System.out.println("\nInforme o Nome: ");
						cli.setNome(fcString.nextLine());
						System.out.println("Informe o Telefone");
						cli.setTelefone(fcString.nextLine());

						clienteDao.alterar(cli);

					} else if (op == 2) { // Altera??o Endere?o

						List<Endereco> listaEndereco = enderecoDao.listarTodos();
						Menu.menu();
						System.out.println("Codigo Rua Numero Complemento Bairro Cidade UF Cep");
						for (Endereco endereco : listaEndereco) {
							System.out.println(endereco.getIdEndereco() + "   " + endereco.getRua() + "     "
									+ endereco.getNumero() + "  " + endereco.getComplemento() + "   "
									+ endereco.getBairro() + "  " + endereco.getCidade() + "     " + endereco.getUf()
									+ "    " + endereco.getCep());
						}
						System.out.println("Informe o C?digo do Endere?o: ");
						end.setIdEndereco(fcInt.nextInt());
						System.out.println("Informe a Rua: ");
						end.setRua(fcString.nextLine());
						System.out.println("\nInforme o N?mero: ");
						end.setNumero(fcInt.nextInt());
						System.out.println("\nInforme o Complemento: ");
						end.setComplemento(fcString.nextLine());
						System.out.println("\nInforme o Bairro: ");
						end.setBairro(fcString.nextLine());
						System.out.println("\nInforme o Cep: ");
						end.setCep(fcInt.nextInt());
						System.out.println("\nInforme a Cidade: ");
						end.setCidade(fcString.nextLine());
						System.out.println("\nInforme a Uf: ");
						end.setUf(fcString.nextLine());

						enderecoDao.alterar(end);

					} else if (op == 3) { // Altera??o Conta

						System.out.println("1-PJ / 2-PF");
						int tpCli = fcInt.nextInt();
						if (tpCli == 1) {
							System.out.println("CNPJ: ");
							cli.setCpfCnpj(fcString.nextLine());
							System.out.println("Insc.Estadual: ");
							cli.setIe(fcString.nextLine());
						} else {
							System.out.println("CPF: ");
							cli.setCpfCnpj(fcString.nextLine());
							System.out.println("RG: ");
							cli.setRg(fcString.nextLine());
						}
						Cliente cliente = clienteDao.pesquisar(cli);
						System.out.println("Informe o N?mero da Conta: ");
						cont.setNumero(fcString.nextLine());
						cont.setCliente(cliente);
						Conta conta = contaDao.pesquisar(cont);
						mov.setConta(conta);
						mov.setCliente(cliente);
						int qtMov = 0;
						qtMov = movDao.idMov(mov, qtMov);
						if (qtMov > 0) {
							System.out.println(
									"Foram realizadas movimenta??es nessa conta," + " n?o ser? poss?vel alterar!");
						} else {
							System.out.println("Informe o novo Numero: ");
							cont.setNumero(fcString.nextLine());

							contaDao.alterar(cont);

						}
					}

					break;

				case 3: // Exclus?es

					Menu.menu();
					Menu.opcao();
					System.out.println("Informe a op??o desejada: ");
					op = fcInt.nextInt();

					if (op == 1) { // Exclus?o Cliente

						System.out.println("1-PJ / 2-PF");
						int tpCli = fcInt.nextInt();
						if (tpCli == 1) {
							System.out.println("CNPJ: ");
							cli.setCpfCnpj(fcString.nextLine());
							System.out.println("Insc.Estadual: ");
							cli.setIe(fcString.nextLine());
						} else {
							System.out.println("CPF: ");
							cli.setCpfCnpj(fcString.nextLine());
							System.out.println("RG: ");
							cli.setRg(fcString.nextLine());
						}
						Cliente cliente = clienteDao.pesquisar(cli);
						mov.setCliente(cliente);
						Movimentacoes movim = movDao.pesquisar(mov);
						if (movim != null) {
							System.out.println(
									"Foram realizadas movimenta??es nesse cliente," + "n?o ser? poss?vel excluir!");
						} else {
							clienteDao.remover(cliente);
						}
					} else if (op == 2) { // Exclus?o Endere?o
						List<Endereco> listaEndereco = enderecoDao.listarTodos();
						Menu.menu();
						System.out.println("Codigo Rua Numero Complemento Bairro Cidade UF Cep");
						for (Endereco endereco : listaEndereco) {
							System.out.println(endereco.getIdEndereco() + "   " + endereco.getRua() + "     "
									+ endereco.getNumero() + "  " + endereco.getComplemento() + "   "
									+ endereco.getBairro() + "  " + endereco.getCidade() + "     " + endereco.getUf()
									+ "    " + endereco.getCep());
						}
						System.out.println("Informe o C?digo do Endere?o: ");
						int idEnd = fcInt.nextInt();

						enderecoDao.remover(idEnd);

					} else if (op == 3) { // Exclus?o Conta
						System.out.println("Informe o N?mero da Conta: ");
						cont.setNumero(fcString.nextLine());
						Conta conta = contaDao.pesquisar(cont);
						mov.setConta(conta);
						Movimentacoes movim = movDao.pesquisar(mov);
						if (movim.getIdMovim() > 0) {
							cont.setStatusConta("I");
							contaDao.alterar(cont);
							System.out.println("Conta Inativa com sucesso!");

						} else {
							contaDao.remover(conta.getIdConta());
						}
					}

					break;

				default:
					System.out.println("Op??o Inv?lida!");
					break;
				}
				break;

			case 2: // Relat?rios
				Menu.menu();
				Menu.opRel();
				System.out.println("Informe a op??o desejada: ");
				int rel = fcInt.nextInt();
				switch (rel) {
				case 1: // Saldo Por Cliente

					Menu.menu();
					System.out.println("1-PJ / 2-PF");
					int tpCli = fcInt.nextInt();
					if (tpCli == 1) {
						System.out.println("CNPJ: ");
						cli.setCpfCnpj(fcString.nextLine());
						System.out.println("Insc.Estadual: ");
						cli.setIe(fcString.nextLine());
					} else {
						System.out.println("CPF: ");
						cli.setCpfCnpj(fcString.nextLine());
						System.out.println("RG: ");
						cli.setRg(fcString.nextLine());
					}
					Cliente cliente = clienteDao.pesquisar(cli);
					Endereco endereco = enderecoDao.pesquisar(cliente.getEndereco());
					Menu.menu();
					int tpMov = 0, credito = 0, debito = 0;
					Double vlPago = 0.00;
					List<Movimentacoes> listaMovim = movDao.listarTodos();
					for (Movimentacoes moviment : listaMovim) {
						if (moviment.getCliente().getIdCliente() == (cliente.getIdCliente())) {
							tpMov = ((Movimentacoes) moviment).getTpMovim();
							if (tpMov == 1) {
								credito = credito + 1;
							} else {
								debito = debito + 1;
							}

						}
					}

					if ((credito + debito) <= 10) {
						vlPago = 1.00;
					} else if ((credito + debito) > 10 && (credito + debito) <= 20) {
						vlPago = 0.75;
					} else {
						vlPago = 0.50;
					}
					System.out.println("RELAT?RIO DE SALDO POR CLIENTE");
					System.out.println("------------------------------------");
					System.out
							.println("Cliente: " + cliente.getNome() + " - Cliente desde: " + cliente.getDtCadastro());
					System.out.println("Endere?o: " + endereco.getRua() + ", " + endereco.getNumero() + ", "
							+ endereco.getComplemento() + ", " + endereco.getBairro() + ", " + endereco.getCidade()
							+ ", " + endereco.getUf() + ", " + endereco.getCep());
					System.out.println("Movimenta??es de Cr?dito: " + credito);
					System.out.println("Movimenta??es de D?bito: " + debito);
					System.out.println("Total de Movimenta??es: " + (credito + debito));
					System.out.println("Valor Pago Pelas Movimenta??es: " + ((credito + debito) * vlPago));
					System.out.println("Saldo Inicial: " + cliente.getSaldoInicial());
					System.out.println("Saldo Atual: " + cliente.getSaldoAtual());

					break;
				case 2: // Saldo Por Cliente/Periodo
					break;
				case 3: // Saldo Clientes Geral

					List<Cliente> listaCliente = clienteDao.listarTodos();
					Menu.menu();
					System.out.println("RELAT?RIO DE SALDO DE TODOS OS CLIENTES");
					System.out.println("--------------------------------------------");
					for (Cliente clientes : listaCliente) {
						System.out.println(
								"Cliente: " + clientes.getNome() + " Cliente desde: " + clientes.getDtCadastro() + "-"
										+ " Saldo em " + date.format(data) + ": " + clientes.getSaldoAtual());
					}

					break;

				case 4: // Receita Empresa
					break;

				default:
					break;
				}
				break;
			case 3: // Movimenta??es
				Movimentacoes movimento = new Movimentacoes();
				Menu.menu();
				System.out.println("1-PJ / 2-PF");
				int tpCli = fcInt.nextInt();
				if (tpCli == 1) {
					System.out.println("CNPJ: ");
					cli.setCpfCnpj(fcString.nextLine());
					System.out.println("Insc.Estadual: ");
					cli.setIe(fcString.nextLine());
				} else {
					System.out.println("CPF: ");
					cli.setCpfCnpj(fcString.nextLine());
					System.out.println("RG: ");
					cli.setRg(fcString.nextLine());
				}
				Cliente cliente = clienteDao.pesquisar(cli);
				movimento.setCliente(cliente);
				cont.setCliente(cliente);
				System.out.println("N?mero da conta: ");
				cont.setNumero(fcString.nextLine());
				Conta conta = contaDao.pesquisar(cont);
				movimento.setConta(conta);
				System.out.println("1-Cr?dito / 2-D?bito: ");
				movimento.setTpMovim(fcInt.nextInt());
				System.out.println("Valor da Movimenta??o: ");
				Double vlMovimento = fcInt.nextDouble();
				System.out.println("Data do movimento(dd/mm/aaaa): ");
				movimento.setDataMovim(fcString.nextLine());
				if (movimento.getTpMovim() == 1) {
					cliente.setSaldoAtual(cliente.getSaldoAtual() + vlMovimento);
				} else if (movimento.getTpMovim() == 2) {
					cliente.setSaldoAtual(cliente.getSaldoAtual() - vlMovimento);
				}
				movDao.salvar(movimento);
				clienteDao.alterar(cliente);
				break;
			case 4: // Sair
				System.out.println("Programa finalizado!");
				break;

			default:
				System.out.println("Op??o Inv?lida!");
				break;

			}
		} while (menu != 4);

		System.exit(0);
	}

}
