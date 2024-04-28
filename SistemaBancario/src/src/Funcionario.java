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
    private static int contador = 0; 

    private int funcionario;
    private Conta salario; 
    private Conta investimento;

    public Funcionario(Conta salario, Conta investimento) {
        this.funcionario = ++contador; 
        this.salario = salario; 
        this.investimento = investimento; 
    }

    @Override
    public void run() { 
        salario.receber(1400); 
        double valorInvestimento = 1400 * 0.2; 
        investimento.investir(valorInvestimento);
        System.out.println("***********************************");
        System.out.printf("Funcionario %d \n", funcionario);  
        System.out.printf("Loja %d \n", funcionario / 2 + 1);
        System.out.printf("Salario: R$ %.2f \n", salario.getSaldo());
        System.out.printf("Investiu: R$ %.2f \n", investimento.getSaldo());
        System.out.println("***********************************");
    }
    
    public Conta getSalario() {
        return salario;
    }

    public Conta getInvestimento() {
        return investimento;
    }
}
