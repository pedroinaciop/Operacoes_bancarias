package br.com.pedro.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Operacoes {
    Scanner leitura = new Scanner(System.in);
    ArrayList<RegistrarOperacao> listaDeOperacoes = new ArrayList<RegistrarOperacao>();
    ArrayList<Conta> listaDeContas = new ArrayList<Conta>();

    public void cadastrarConta() {
        try {
            Scanner leitura = new Scanner(System.in);

            System.out.println("\nDigite o número da conta:");
            Integer numeroDaConta = leitura.nextInt();
            leitura.nextLine();

            Conta conta = FiltrarConta(numeroDaConta);

            if (conta != null) {
                System.out.println("\nO número da conta informado já possui uma conta, por favor, insira outro!");
            } else  {
                System.out.println("\nDigite sua senha:");
                String senha = leitura.nextLine();

                listaDeContas.add(new Conta(numeroDaConta, senha, BigDecimal.ZERO));
                System.out.println("\nConta cadastrada com sucesso!");
            }
        } catch (InputMismatchException e) {
            System.out.println("\nO número da conta deve ser um número inteiro.");
        }
    }

    public void consultarContas() {
        if (listaDeContas.isEmpty()) {
            System.out.println("\nNão há contas registradas.");
        } else {
            System.out.println("\n" + listaDeContas);
        }
    }

    public void depositar() {
        try {
            System.out.println("\nDigite a conta: ");
            Integer numeroDaConta = leitura.nextInt();
            leitura.nextLine();

            System.out.println("\nDigite sua senha: ");
            String senha = leitura.nextLine();

            Conta conta = FiltrarConta(numeroDaConta);

            if (conta.getSenha().equals(senha)) {
                System.out.println("\nDigite o valor do depósito: ");
                BigDecimal valorDeposito = leitura.nextBigDecimal();

                if (valorDeposito.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("\nValor não permitido para operação.");
                } else {
                    BigDecimal novoSaldo = conta.getSaldo().add(valorDeposito);
                    conta.setSaldo(novoSaldo);

                    System.out.println("\nDepósito realizado com sucesso!");

                    listaDeOperacoes.add(new RegistrarOperacao("Depósito", conta.getNumero(), valorDeposito, java.time.LocalDate.now()));
                }
            } else {
                System.out.println("\nSenha incorreta!");
            }
        } catch (NullPointerException e) {
            System.out.println("\nNão há conta cadastrada com esse número.");
        } catch (InputMismatchException e) {
            System.out.println("\nEsse campo dever conter somente números");
        }
    }

    public void sacar() {
        try {
            System.out.println("\nDigite o número da conta: ");
            Integer numeroDaConta = leitura.nextInt();
            leitura.nextLine();

            System.out.println("\nDigite sua senha: ");
            String senha = leitura.nextLine();

            Conta conta = FiltrarConta(numeroDaConta);

            if (conta.getSenha().equals(senha)) {
                System.out.println("\nDigite o valor do saque: ");
                BigDecimal valorSaque = leitura.nextBigDecimal();

                if (valorSaque.compareTo(conta.getSaldo()) > 0) {
                    System.out.println("\nEssa conta não possui saldo suficiente para realizar essa operação.");
                } else {
                    BigDecimal novoSaldo = conta.getSaldo().subtract(valorSaque);
                    conta.setSaldo(novoSaldo);
                    System.out.println("\nSaque realizado com sucesso!");

                    listaDeOperacoes.add(new RegistrarOperacao("Saque", conta.getNumero(), valorSaque, java.time.LocalDate.now()));
                }
            } else {
                System.out.println("\nSenha incorreta!");
            }
        } catch (NullPointerException e) {
            System.out.println("\nNão há conta cadastrada com esse número.");
        } catch (InputMismatchException e) {
            System.out.println("\nEsse campo deve conter somente números");
        }
    }

    public void consultarSaldo() {
        try {
            System.out.println("\nDigite o número da conta: ");
            Integer numeroDaConta = leitura.nextInt();
            leitura.nextLine();

            System.out.println("\nDigite sua senha: ");
            String senha = leitura.nextLine();

            Conta conta = FiltrarConta(numeroDaConta);

            if (conta.getSenha().equals(senha)) {
                System.out.println("Saldo atual: R$" + conta.getSaldo());
            } else {
                System.out.println("\nSenha incorreta!");
            }
        } catch (InputMismatchException e) {
            System.out.println("\nEsse campo dever conter somente números");
        }
    }

    public void consultarRegistros() {
        if (listaDeOperacoes.isEmpty()) {
            System.out.println("\nNão há operações registradas.");
        } else {
            System.out.println("\n" + listaDeOperacoes);
        }
    }

    public void encerrandoOperacoes() {
        System.exit(0);
    }

    public Conta FiltrarConta(Integer numeroDaConta) {
        Conta contaAtual = null;

        for (Conta conta: listaDeContas) {
            if (conta.getNumero().equals(numeroDaConta)) {
                contaAtual = conta;
                break;
            }
        }
        return contaAtual;
    }
}
