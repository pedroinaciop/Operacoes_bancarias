package br.com.pedro;
import br.com.pedro.models.Operacoes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Operacoes operacao = new Operacoes();
        int opcao = 0;

        System.out.println("\n          Bem-vindo ao PedroBank        \n");

        while (opcao != 7) {
            operacoesMenu();

            System.out.println("\nDigite o número de operação desejada: ");
            opcao = leitura.nextInt();

            switch(opcao) {
                case 1:
                    operacao.cadastrarConta();
                    break;
                case 2:
                    operacao.consultarContas();
                    break;
                case 3:
                    operacao.depositar();
                    break;
                case 4:
                    operacao.sacar();
                    break;
                case 5:
                    operacao.consultarSaldo();
                    break;
                case 6:
                    operacao.consultarRegistros();
                    break;
                case 7:
                    operacao.encerrandoOperacoes();
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    public static void operacoesMenu() {
        System.out.println("___________________________________");
        System.out.println("\n1 - Cadastrar conta");
        System.out.println("2 - Listar contas");
        System.out.println("3 - Depósito bancário");
        System.out.println("4 - Saque bancário");
        System.out.println("5 - Consultar saldo");
        System.out.println("6 - Consultar operação registradas");
        System.out.println("7 - Sair");
        System.out.println("_____________________________________");
    }
}
