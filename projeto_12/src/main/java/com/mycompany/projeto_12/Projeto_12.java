/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_12;

import java.util.Scanner;

/**
 *
 * @author c.nunes
 */
public class Projeto_12 {
    static String nome_jogadorUm;
    static String nome_filme;
    static String dicas[] = new String[5];
    static boolean verificacao = false;
    
    public static void main(String[] args) {
        jogadorUm();
        clear();
        jogadorDois();
        if(verificacao == false){
            System.out.println("Jogador "+nome_jogadorUm+" ganhou!!");
        }
    }
    public static void jogadorUm(){
        Scanner ler = new Scanner(System.in);
        System.out.print("Jogador 1 - nome:");
        nome_jogadorUm = ler.nextLine();
        System.out.print("Jogador 1 - Digite o nome do filme (tudo minusculo):");
        nome_filme = ler.nextLine();
        for (int i = 0; i < 5; i++) {
            System.out.print("Jogador 1 - Insira a dica "+(i+1)+":");
            dicas[i] = ler.nextLine();
        }
    }
    public static void jogadorDois(){
        String resposta;
        Scanner ler = new Scanner(System.in);
        String nome_jogadorDois;
        System.out.print("Jogador 2 - nome:");
        nome_jogadorDois = ler.nextLine();
        for (int i = 0; i < 5; i++) {
            System.out.print("Jogador 2 - Qual o nome do filme:");
            resposta = ler.nextLine();
            if(resposta.equals(nome_filme)){
                System.out.print("Jogador 2 ganhou!!");
                verificacao = true;
                break;
            }else{
                System.out.println("Errado!");
                System.out.println("Dica "+(i+1)+":"+dicas[i]);
            }
        }
    }
    public static void clear(){
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }
}
