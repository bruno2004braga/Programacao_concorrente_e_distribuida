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

public class Cliente extends Thread {
    private static int contadorClientes = 0; // Contador de clientes

    private int numeroCliente;
    private Conta conta;
    private Loja[] lojas;

    public Cliente(Conta conta, Loja[] lojas) {
        this.numeroCliente = ++contadorClientes; // Incrementa o número do cliente
        this.conta = conta; // Recebe a conta do cliente
        this.lojas = lojas; // Recebe as lojas
    }

    @Override
    public void run() {
        while (conta.getSaldo() > 0) { // Repete enquanto houver saldo na conta do cliente
            double valorCompra = Math.random() < 0.5 ? 100 : 200; // Realiza uma compra aleatória de 100 ou 200
            int indiceLoja = (int) (Math.random() * lojas.length); // Escolhe uma loja aleatória
            Loja loja = lojas[indiceLoja];
            synchronized (loja.getConta()) { // Garante o acesso sincronizado à conta da loja
                if (conta.receber(valorCompra)) {
                    loja.getConta().investir(valorCompra); // Realiza a compra na loja
                    System.out.printf("Cliente %d realizou uma compra na loja %d\nValor da compra: R$ %.2f\n", numeroCliente, indiceLoja + 1, valorCompra); // Exibe o valor da compra
                } else {
                    break; // Se não houver saldo suficiente, sai do loop
                }
            }
        }
    }
}
