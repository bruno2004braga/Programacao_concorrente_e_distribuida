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

public class Loja {
    private Conta conta; 

    public Loja(double saldoInicial) {
        this.conta = new Conta(saldoInicial); 
    }

    public Conta getConta() {
        return conta;
    }

    public void pagarSalarios() {
        System.out.println("======================================");
        System.out.println("Funcionario recebeu pagamento !!!");
    }
}
