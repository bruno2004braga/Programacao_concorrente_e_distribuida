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
    private static int contadorClientes = 0; 

    private int cliente;
    private Conta conta;
    private Loja[] lojas;

    public Cliente(Conta conta, Loja[] lojas) {
        this.cliente = ++contadorClientes; 
        this.conta = conta; 
        this.lojas = lojas; 
    }

    @Override
    public void run() {
        while (conta.getSaldo() > 0) { 
            double valorCompra = Math.random() < 0.5 ? 100 : 200; 
            int indiceLoja = (int) (Math.random() * lojas.length); 
            Loja loja = lojas[indiceLoja];
            synchronized (loja.getConta()) { 
                if (conta.receber(valorCompra)) {
                    loja.getConta().investir(valorCompra); 
                    
                    System.out.printf("\nCliente %d ", cliente); 
                    System.out.printf("\nComprou na loja %d", indiceLoja +1);
                    System.out.printf("\nValor: R$ %.2f\n", valorCompra);
                } else {
                    break; 
                }
            }
        }
    }
}
