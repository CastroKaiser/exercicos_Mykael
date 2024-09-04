/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Projeto_13;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author edmun
 */
public class Projeto_13 {

    static int valores[] = null;
    public static void main(String[] args) {
        int indice_1 = 0; 
        int indice_2 = 0;
        int operacao;
        boolean verificador = false;
        int resultados;
        boolean verificacao_2 = true;
        

        Scanner ler = new Scanner (System.in);
        try{
            System.out.print("Digite a quantidade de elementos que deseja inserir no vetor:");
            int tamanho_vetor = ler.nextInt();
            valores = new int[tamanho_vetor];
            try{
                for(int i = 0; i < valores.length; i++){
                        System.out.print("Digite o valor da "+(i+1)+" posicao:");
                        valores[i] = ler.nextInt();
                }
                for (int i = 0; i < valores. length; i++) {
                    System.out.println("Indice:"+i+" || Valor: "+valores[i]);
                }
                do{
                    try {
                        System.out.print("Insira o " + 1 + " indice referente ao elemento:");
                        indice_1 = ler.nextInt();
                        System.out.println("Voce escolheu o indice "+indice_1+" que contem o valor "+valores[indice_1]);
                        
                        System.out.print("Insira o " + 2 + " indice referente ao elemento:");
                        indice_2 = ler.nextInt();
                        System.out.println("Voce escolheu o indice "+indice_2+" que contem o valor "+valores[indice_2]);
                        
                        verificacao_2 = false;
                        do{
                            System.out.println("Digite a operacao que deseja realizar");
                            System.out.println("1 - Soma");
                            System.out.println("2 - Subtracao");
                            System.out.println("3 - Multiplicacao");
                            System.out.println("4 - Divisao");
                            System.out.print("Resposta:");
                            operacao = ler.nextInt();	
                            if(operacao == 1){
                                resultados = valores[indice_1]+valores[indice_2];
                                System.out.println("Resultado:"+resultados);
                                verificador = false;
                            }else if(operacao == 2){
                                resultados = valores[indice_1]+valores[indice_2];
                                System.out.println("Resultado:"+resultados);
                                verificador = false;
                            }else if(operacao == 3){
                                resultados = valores[indice_1]+valores[indice_2];
                                System.out.println("Resultado:"+resultados);
                                verificador = false;
                            }else if(operacao == 4){
                                try{
                                    resultados = valores[indice_1]/valores[indice_2];
                                    System.out.println("Resultado:"+resultados);
                                    verificador = false;
                                }catch (ArithmeticException e) {
                                    System.out.println("ERRO: nao e possivel dividir por zero."+e.getMessage());
                                }
                            }else{
                                    System.out.println("operacao invalida");
                                    verificador = true;
                            }
                        }while (verificador == true);
                    } catch (ArrayIndexOutOfBoundsException e1) {
                        System.out.println("ERRO: Indice fora dos limites do array - " + e1.getMessage());
                        verificacao_2 = true;
                    } catch (InputMismatchException e2) {
                        System.out.println("ERRO: Esperava numero."+e2.getMessage());
                        verificacao_2 = true;
                    } 
                }while(verificacao_2 == true);
            } catch (InputMismatchException e){
                    System.out.println("ERRO: Esperava numero "+e.getMessage());
            }
        } catch (InputMismatchException e) {
                System.out.println("ERRO: Esperava numero "+e.getMessage());
        }
    }
}
