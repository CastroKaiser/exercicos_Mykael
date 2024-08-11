/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_11;
/**
 *
 * @author edmun
 */
import java.util.Scanner;
public class Projeto_11 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        int total_pedidos = 0;
        int total_tempo_processamento = 0;
        int maior_numero_itens = 0;
        int maior_tempo_processamento = 0;
        int pedidos_restantes = 0;
        int tempo_restante_pedido = 0;
        boolean saida = true;
        
        while(saida == true){
            System.out.print("Digite o numero de itens do pedido (0 para encerrar):");
            int itens = ler.nextInt();
            
            if(itens == 0){
                saida = false;
            }else{
                int tempo_processamento = itens * 2;
                pedidos_restantes++;
                total_pedidos++;
                
                if(itens > maior_numero_itens){
                    maior_numero_itens = itens;
                    maior_tempo_processamento = tempo_processamento;
                }
                
                System.out.println("Iniciando Processamento de Itens");
                
                for(int pedido_atual = 1; pedido_atual <= pedidos_restantes; pedido_atual++){
                    tempo_restante_pedido = itens * 2;
                    
                    System.out.println("\nProcessando Pedido #" + pedido_atual + " com " + itens + " itens (Tempo estimado: " + tempo_processamento + " minutos)");
                    while(tempo_restante_pedido > 0){
                        
                        System.out.println("Pedido #" + pedido_atual + ": " + tempo_restante_pedido + " minutos restantes.");
                        tempo_restante_pedido--;
                        total_tempo_processamento++;
                        
                    }
                    System.out.println("Pedido #" + pedido_atual + " concluido.");
                }
                pedidos_restantes = 0;
            }   
        } 
        if (total_pedidos > 0) {
            double tempoMedio = (double) total_tempo_processamento / total_pedidos;

            System.out.println("\nRelatorio Final:");
            System.out.println("Numero total de pedidos processados: " + total_pedidos);
            System.out.println("Tempo total de processamento: " + total_tempo_processamento + " minutos");
            System.out.println("Tempo medio de processamento por pedido: " + String.format("%.2f", tempoMedio) + " minutos");
            System.out.println("Pedido com maior numero de itens: " + maior_numero_itens + " itens, Tempo de processamento: " + maior_tempo_processamento + " minutos");
        } else {
            System.out.println("\nNenhum pedido foi processado.");
        }
    }
}
