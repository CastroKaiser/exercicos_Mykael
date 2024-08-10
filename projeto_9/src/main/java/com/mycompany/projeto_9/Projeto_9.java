/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_9;

/**
 *
 * @author edmun
 */
public class Projeto_9 {

    public static void main(String[] args) {
        Random gerador = new Random();
        int fila_principal_intersecaoUm = gerador.nextInt(50);
        int fila_secundaria_intersecaoUm = 0;

        int fila_principal_intersecaoDois= gerador.nextInt(50);
        int fila_secundaria_intersecaoDois = 0;

        int fila_principal_intersecaoTres = gerador.nextInt(50);
        int fila_secundaria_intersecaoTres = 0;

        int timer_verde = 30;
        int timer_amarelo = 5;

        int quantidade_congestionamento = 0;

        int contador_carros_intersecaoUm = 0;
        int contador_carros_intersecaoDois = 0;
        int contador_carros_intersecaoTres = 0;

        int tempo_espera_intersecaoUm = 0;
        int tempo_espera_intersecaoDois = 0;
        int tempo_espera_intersecaoTres = 0;

        String estado_sinais = "";
        int add_carro_intervalo = 15;
        int timer_total = 600;

        if(fila_principal_intersecaoUm >= 10){
            int auxiliar = fila_principal_intersecaoUm;
            fila_principal_intersecaoUm = 10;
            fila_secundaria_intersecaoUm = auxiliar-fila_principal_intersecaoUm;
            quantidade_congestionamento = fila_secundaria_intersecaoUm;
        }
        if(fila_principal_intersecaoDois >= 10){
            int auxiliar = fila_principal_intersecaoDois;
            fila_principal_intersecaoDois = 10;
            fila_secundaria_intersecaoDois = auxiliar-fila_principal_intersecaoDois;
            quantidade_congestionamento = fila_secundaria_intersecaoDois;
        }
        if(fila_principal_intersecaoTres >= 10){
            int auxiliar = fila_principal_intersecaoTres;
            fila_principal_intersecaoTres = 10;
            fila_secundaria_intersecaoTres = auxiliar-fila_principal_intersecaoTres;
            quantidade_congestionamento = fila_secundaria_intersecaoTres;
        }

        for(int timer_corrido = 1; timer_corrido <= timer_total; timer_corrido++){
            int ciclo_sinal = timer_verde + 50;
            int tempo_atual = timer_corrido % ciclo_sinal;

            if (tempo_atual < timer_verde) {
                estado_sinais = "verde";
            } else if (tempo_atual < timer_verde + timer_amarelo) {
                estado_sinais = "amarelo";
            } else {
                estado_sinais = "vermelho";
            }

            System.out.println("Tempo do Semaforo:"+tempo_atual+"|| sinal 1:"+estado_sinais+"|| sinal 2:"+estado_sinais+"|| sinal 3:"+estado_sinais);
            
            if (timer_corrido % add_carro_intervalo == 0) {
                if (fila_principal_intersecaoUm >= 10){
                    fila_secundaria_intersecaoUm++;
                    quantidade_congestionamento++;
                } else {
                    fila_principal_intersecaoUm++;
                }

                if (fila_principal_intersecaoDois >= 10){
                    fila_secundaria_intersecaoDois++;
                    quantidade_congestionamento++;
                } else {
                    fila_principal_intersecaoDois++;
                }

                if (fila_principal_intersecaoTres >= 10){
                    fila_secundaria_intersecaoTres++;
                    quantidade_congestionamento++;
                } else {
                    fila_principal_intersecaoTres++;
                }
            }
            
            tempo_espera_intersecaoUm += fila_principal_intersecaoUm + fila_secundaria_intersecaoUm;
            tempo_espera_intersecaoDois += fila_principal_intersecaoDois + fila_secundaria_intersecaoDois;
            tempo_espera_intersecaoTres += fila_principal_intersecaoTres + fila_secundaria_intersecaoTres;
            
            if (estado_sinais.equals("verde")){
                while(estado_sinais.equals("verde") && tempo_atual <= timer_verde){
                    if (fila_principal_intersecaoUm > 0) {
                        fila_principal_intersecaoUm--;
                        contador_carros_intersecaoUm++;
                    }
                    if (fila_principal_intersecaoDois > 0) {
                        fila_principal_intersecaoDois--;
                        contador_carros_intersecaoDois++;
                    }
                    if (fila_principal_intersecaoTres > 0) {
                        fila_principal_intersecaoTres--;
                        contador_carros_intersecaoTres++;
                    }

                    // Movendo carros da fila secundária para a fila principal
                    if(fila_secundaria_intersecaoUm > 0 && fila_principal_intersecaoUm < 10){
                        fila_secundaria_intersecaoUm--;
                        fila_principal_intersecaoUm++;
                    }

                    if(fila_secundaria_intersecaoDois > 0 && fila_principal_intersecaoDois < 10){
                        fila_secundaria_intersecaoDois--;
                        fila_principal_intersecaoDois++;
                    }

                    if(fila_secundaria_intersecaoTres > 0 && fila_principal_intersecaoTres < 10){
                        fila_secundaria_intersecaoTres--;
                        fila_principal_intersecaoTres++;
                    }
                    tempo_atual++;
                }
            }
        }

        // Calculo do tempo médio de espera em cada fila 
        double tempo_medio_espera_um = (double) tempo_espera_intersecaoUm / (contador_carros_intersecaoUm == 0 ? 1 : contador_carros_intersecaoUm);
        double tempo_medio_espera_dois = (double) tempo_espera_intersecaoDois / (contador_carros_intersecaoDois == 0 ? 1 : contador_carros_intersecaoDois);
        double tempo_medio_espera_tres = (double) tempo_espera_intersecaoTres / (contador_carros_intersecaoTres == 0 ? 1 : contador_carros_intersecaoTres);

        relatorio(contador_carros_intersecaoUm, contador_carros_intersecaoDois, contador_carros_intersecaoTres, quantidade_congestionamento,
        tempo_medio_espera_um, tempo_medio_espera_dois, tempo_medio_espera_tres);
    }

    public static void relatorio(int contador_carros_intersecaoUm, int contador_carros_intersecaoDois, int contador_carros_intersecaoTres, int quantidade_congestionamento,
                                 double tempo_medio_espera_um, double tempo_medio_espera_dois, double tempo_medio_espera_tres) {
        System.out.println("Carros passados pela intersecao 1: " + contador_carros_intersecaoUm);
        System.out.println("Carros passados pela intersecao 2: " + contador_carros_intersecaoDois);
        System.out.println("Carros passados pela intersecao 3: " + contador_carros_intersecaoTres);
        System.out.println("Quantidade de carros no congestionamento: " + quantidade_congestionamento);
        System.out.println("Tempo medio de espera na intersecao 1: " + tempo_medio_espera_um + " segundos");
        System.out.println("Tempo medio de espera na intersecao 2: " + tempo_medio_espera_dois + " segundos");
        System.out.println("Tempo medio de espera na intersecao 3: " + tempo_medio_espera_tres + " segundos");
    }
}
