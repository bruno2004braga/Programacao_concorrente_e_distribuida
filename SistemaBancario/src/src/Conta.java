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
        this.saldo = saldoInicial; 
        this.trava = new ReentrantLock(); 
    }

    public double getSaldo() { 
        return saldo;
    }

    public void investir(double valor) {
        trava.lock();
        try {
            saldo += valor; 
        } finally {
            trava.unlock(); 
        }
    }

    public boolean receber(double valor) { 
        trava.lock(); 
        try {
            if (saldo >= valor) { 
                saldo -= valor; 
                return true; 
            }
            return false; 
        } finally {
            trava.unlock();
        }
    }
}
