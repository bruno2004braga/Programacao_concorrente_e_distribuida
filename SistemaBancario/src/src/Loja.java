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
    private Conta conta; // Conta da loja

    public Loja(double saldoInicial) {
        this.conta = new Conta(saldoInicial); // Cria o objeto conta da loja
    }

    public Conta getConta() {
        return conta;
    }

    public void pagarSalarios() {
        // Executa o pagamento dos salários dos funcionários e retorna uma mensagem de confirmação
        System.out.println("Pagamento dos salários dos funcionários efetuado");
    }
}
