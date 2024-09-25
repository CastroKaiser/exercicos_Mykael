/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author c.nunes
 */
public class Projeto_15 {

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        int[] num = new int[5];
        boolean verificacao = true;
        
        for (int i = 0; i < 5; i++) {
            verificacao = false;
            while (!verificacao) {
                try {
                    System.out.print("Digite o " + (i + 1) + " número para guardar no vetor: ");
                    num[i] = ler.nextInt(); 
                    verificacao = true;
                } catch (InputMismatchException e) {
                    System.out.println("ERR: Entrada inválida. Por favor, digite um número.");
                    ler.nextLine(); // Limpa o buffer do scanner
                }
            }
            System.out.print("Digite o " + ( i + 1) + " numero para guardar no vetor:");
            num[i] = ler.nextInt();

            FileWriter arquivo = new FileWriter ("C:\\Users\\c.nunes\\Documents\\play\\arquivo"+ i + ".txt");
            PrintWriter gravar = new PrintWriter(arquivo);

            for (int j = 1; j <= 10; j++) {
                gravar.printf("\n" + j + " X " + num[i] + " = " + (j * num[i]));
            }
            gravar.print("\n------------");
            arquivo.close();        
        } 
    }
}
