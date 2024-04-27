/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Bruno Lucas Caixeta Braga
 * Matrícula: UC22101373
 */

public class Funcionario extends Thread {
    private static int contadorFuncionarios = 0; // Contador de funcionários

    private int numeroFuncionario;
    private Conta salario; 
    private Conta investimento;

    public Funcionario(Conta salario, Conta investimento) {
        this.numeroFuncionario = ++contadorFuncionarios; // Incrementa o número do funcionário
        this.salario = salario; // Recebe a conta do salário
        this.investimento = investimento; // Recebe a conta do investimento
    }

    @Override
    public void run() { // Executa a thread
        salario.receber(1400); // Pagamento do salário
        double valorInvestimento = 1400 * 0.2; // Investimento de 20%
        investimento.investir(valorInvestimento);
        System.out.printf("Funcionário %d da loja %d:\nSalário = %.2f, Investimento = %.2f \n", numeroFuncionario, numeroFuncionario / 2 + 1, salario.getSaldo(), investimento.getSaldo()); // Retorna os valores relacionados ao funcionário 
    }
    
    public Conta getSalario() {
        return salario;
    }

    public Conta getInvestimento() {
        return investimento;
    }
}
