/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

public class Banco {
    public static void main(String[] args) {
        Conta[] contasClientes = new Conta[5]; // Cria as contas dos clientes
        for (int i = 0; i < contasClientes.length; i++) {
            contasClientes[i] = new Conta("Cliente " + (i + 1), 1000); // Valor inicial
        }

        Loja[] lojas = new Loja[2]; // Cria as lojas
        for (int i = 0; i < lojas.length; i++) {
            lojas[i] = new Loja("Loja " + (i + 1), 0); // Valor inicial
        }

        Funcionario[] funcionarios = new Funcionario[4]; // Cria os funcionários
        for (int i = 0; i < funcionarios.length; i++) {
            Conta salarioLoja = lojas[i / 2].getConta(); // Conta: salário
            Conta contaInvestimento = new Conta("Investimento Funcionário " + (i + 1), 0); // Investimento
            funcionarios[i] = new Funcionario("Funcionário " + (i + 1), salarioLoja, contaInvestimento);
            funcionarios[i].start();
        }

        Cliente[] clientes = new Cliente[5]; // Cria os clientes
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente("Cliente " + (i + 1), contasClientes[i], lojas);
            clientes[i].start();
        }

        // Executa todas as threads: clientes
        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Executa o pagamento das lojas
        for (Loja loja : lojas) {
            loja.pagarSalarios(); // Executa o pagamento dos funcionários
        }

        // Exibe os saldos finais
        System.out.println("Resultado das operações:");
        for (Conta contaCliente : contasClientes) {
            System.out.println(contaCliente.getTitular() + ": " + contaCliente.getSaldo());
        }
        for (Loja loja : lojas) {
            System.out.println(loja.getNome() + ": " + loja.getConta().getSaldo());
        }
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + ", Salário: " + funcionario.getSalario().getSaldo() + ", Investimento: " + funcionario.getInvestimento().getSaldo());
        }
    }
}
