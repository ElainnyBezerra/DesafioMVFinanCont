package entidade;

public class Menu {

	public static void menu() {

		System.out.println("\n");
		System.out.println("********************************************");
		System.out.println("*                                          *");
		System.out.println("*               MV FINANCONT               *");
		System.out.println("*                                          *");
		System.out.println("********************************************");
	}

	public static void subMenu() {

		System.out.println("*              1- Cadastros                *");
		System.out.println("*              2- Relat?rios               *");
		System.out.println("*              3- Movimenta??es            *");
		System.out.println("*              4- Sair                     *");
	}

	public static void opCad() {

		System.out.println("*              1- Novo Cadastro            *");
		System.out.println("*              2- Altera??es               *");
		System.out.println("*              3- Exclus?es                *");
		System.out.println("*              4- Voltar                   *");
	}

	public static void opcao() {

		System.out.println("*              1- Cliente                  *");
		System.out.println("*              2- Endere?o                 *");
		System.out.println("*              3- Conta                    *");
		System.out.println("*              4- Voltar                   *");
	}

	public static void opRel() {

		System.out.println("*              1- Saldo Por Cliente        *");
		System.out.println("*              2- Saldo Cli/Per?odo        *");
		System.out.println("*              3- Saldo Cliente Geral      *");
		System.out.println("*              4- Receita Empresa          *");
		System.out.println("*              5- Voltar                   *");
	}

}
