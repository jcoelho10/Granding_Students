package br.com.hackerrank.algoritmos.implementacao;

import java.util.Arrays;

/*
 * https://www.hackerrank.com/challenges/the-hurdle-race/problem?isFullScreen=true
 * 
 * Você está jogando um jogo onde o personagem compete em uma corrida de obstáculos. 
 * Os obstáculos têm alturas variadas, e o personagem tem uma altura máxima que pode pular. 
 * Existe uma poção mágica que ele pode tomar para aumentar a altura máxima de salto em uma unidade para cada dose.
 * 
 * Objetivo: Determinar o número mínimo de doses da poção que o personagem precisa tomar para conseguir pular todos os obstáculos.
 * 
 * Parâmetros da função:
 * 
 * int k: a altura que o personagem pode pular naturalmente.
 * int height[n]: as alturas de cada obstáculo.
 * 
 * Retorno:
 * 
 * int: o número mínimo de doses necessárias, sempre 0 ou mais.
 * 
 * Exemplo:
 * 
 * Entrada: 
 * k = 4, 
 * height = [1, 6, 3, 5, 2]
 * 
 * Saída: 2 (o personagem precisa de 2 doses para pular o obstáculo mais alto de altura 6)
 * 
 * Abordagem:
 * 
 * 1 - Entenda o Problema:
 * Você precisa determinar quantas doses da poção são necessárias para que o personagem consiga pular todos os obstáculos.
 * A altura máxima que o personagem pode pular é dada por k.
 * As alturas dos obstáculos são fornecidas em uma lista height.
 * 
 * 2 - Identifique o Obstáculo Mais Alto:
 * Encontre a altura máxima na lista height.
 * 
 * 3 - Calcule a Diferença:
 * Compare a altura máxima do obstáculo com a altura que o personagem pode pular (k).
 * Se a altura máxima do obstáculo for maior que k, calcule a diferença. Essa diferença será o número de doses necessárias.
 * Se a altura máxima do obstáculo for menor ou igual a k, o personagem não precisa de doses adicionais.
 * 
 * 
 * Explicação: 
 * 
 * Explicação do Código:
 * 
 * Leitura dos Dados: 
 * O código lê o número de obstáculos n e a altura máxima k que o personagem pode pular.
 * 
 * Encontrar a Altura Máxima: 
 * Percorre a lista de alturas dos obstáculos para encontrar a altura máxima.
 * 
 * Calcular Doses Necessárias: 
 * Calcula a diferença entre a altura máxima do obstáculo e a altura que o personagem pode pular (k). 
 * Se a diferença for positiva, essa é a quantidade de doses necessárias; caso contrário, não são necessárias doses adicionais.
 * 
 * Imprimir o Resultado: 
 * O resultado é impresso na tela.
 * 
 */

public class TheHurdleRace {

	public static void main(String[] args) {
		 int k = 4;
		 int[] height = {1, 6, 3, 5, 2};
		 
		 System.out.println("Primeira solução: " + primeiraSolucao(k, height));
		 System.out.println("Segunda solução: " + segundaSolucao(k, height));
		 
		 k = 1;
		 int[] heights = {1, 2, 3, 3, 2};
		 
		 System.out.println("Primeira solução com novos valores: " + primeiraSolucao(k, heights));
		 System.out.println("Segunda solução com novos valores: " + segundaSolucao(k, heights));
	}
	
	public static int primeiraSolucao(int k, int[] height) {
		int maxHeigh = 0;
		
		// Encontra a altura máxima dos obstáculos
		for (int h : height) {
			if (h > maxHeigh) {
				maxHeigh = h;
			}
		}
		
		// Calcula o número de doses necessárias
		int dosesNeeded = maxHeigh - k;		
		return Math.max(0, dosesNeeded);
	}
	
	/**
	 * Otimizando o código com Java 8 - Streams.
	 * 
	 */
	 
    public static int segundaSolucao(int k, int[] height) {
        // Encontrar a altura máxima usando Streams
        int maxHeight = Arrays.stream(height).max().orElse(0);
        
        // Calcular o número de doses necessárias
        int dosesNeeded = maxHeight - k;
        return Math.max(0, dosesNeeded);
    }

}
