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

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conta {
    private double saldo; 
    private final Lock trava;

    public Conta(double saldoInicial) { 
        this.saldo = saldoInicial; // Atribui ao saldo o valor fornecido 
        this.trava = new ReentrantLock(); // Inicializa a trava de bloqueio
    }

    public double getSaldo() { // Obtém o saldo da conta
        return saldo;
    }

    public void investir(double valor) { // Realiza investimentos
        trava.lock(); // Bloqueia o acesso à conta
        try {
            saldo += valor; // Altera o saldo com o valor fornecido
        } finally {
            trava.unlock(); // Libera a trava
        }
    }

    public boolean receber(double valor) { // Recebe valores na conta
        trava.lock(); // Bloqueia o acesso à conta
        try {
            if (saldo >= valor) { // Verifica o valor do saldo
                saldo -= valor; // Retira o valor recebido
                return true; // Realizou a compra
            }
            return false; // Saldo insuficiente
        } finally {
            trava.unlock(); // Libera a trava
        }
    }
}
