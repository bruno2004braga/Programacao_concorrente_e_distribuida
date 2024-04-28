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

public class Banco {
    public static void main(String[] args) {
        Conta[] conta = new Conta[5]; 
        for (int i = 0; i < conta.length; i++) {
            conta[i] = new Conta(1000); 
        }

        Loja[] lj = new Loja[2]; 
        for (int i = 0; i < lj.length; i++) {
            lj[i] = new Loja(0); 
        }

        Funcionario[] funcionarios = new Funcionario[4]; 
        for (int i = 0; i < funcionarios.length; i++) {
            Conta salarioLoja = lj[i / 2].getConta(); 
            Conta contaInvestimento = new Conta(0); 
            funcionarios[i] = new Funcionario(salarioLoja, contaInvestimento);
            funcionarios[i].start();
        }

        Cliente[] clientes = new Cliente[5]; 
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(conta[i], lj);
            clientes[i].start();
        }

        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Loja loja : lj) {
            loja.pagarSalarios(); 
        }
        
        System.out.println(" ");
        System.out.println("===============================================");
        System.out.println("Resultado das operacoes:");
        System.out.println("===============================================");
        
        for (int i = 0; i < conta.length; i++) {
            System.out.printf("Cliente %d", (i + 1));
            System.out.printf(": R$ %.2f \n", conta[i].getSaldo());
        }
        
        System.out.println(" ");
        
        for (int i = 0; i < lj.length; i++) {
            System.out.println("Loja " + (i + 1) + ": " + lj[i].getConta().getSaldo());
        }
        
        System.out.println(" ");
        
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println("===============================================");
            System.out.printf("Funcionario %d \n", (i + 1));
            System.out.printf("Loja %d \n", (i / 2 + 1));
            System.out.printf("Salario: R$ %.2f \n", funcionarios[i].getSalario().getSaldo());
            System.out.printf("Valor Investido: R$ %.2f \n", funcionarios[i].getInvestimento().getSaldo());
            System.out.println("==============================================="); 
            
        }
    }
}  

