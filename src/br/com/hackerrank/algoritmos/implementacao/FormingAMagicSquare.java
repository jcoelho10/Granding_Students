package br.com.hackerrank.algoritmos.implementacao;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 * 
 * Um quadrado mágico é uma matriz (3 \times 3) de inteiros positivos distintos de 1 a 9, 
 * onde a soma de qualquer linha, coluna ou diagonal é sempre igual ao mesmo número, 
 * conhecido como a constante mágica. Você receberá uma matriz (3 \times 3) e 
 * precisará transformá-la em um quadrado mágico com o menor custo possível. 
 * O custo de transformar um número (a) em (b) é (|a - b|).
 * 
 * Entrada: 
 * Uma matriz (3 \times 3) de inteiros no intervalo inclusivo [1, 9].
 * 
 * Saída:
 * Um único inteiro que representa o custo mínimo para transformar a matriz dada em um quadrado mágico.
 * 
 * Entrada:
 * 
 * 4 8 2
 * 4 5 7
 * 6 1 6
 * 
 * Saída:
 * 
 * 4
 * 
 * Para transformar a matriz dada em um quadrado mágico, você pode, por exemplo, transformar a matriz em:
 * 
 * 4 9 2
 * 3 5 7
 * 8 1 6
 * 
 * O custo total das transformações necessárias é 4.
 * 
 * Entenda o Problema:
 * 
 * Você precisa transformar uma matriz (3 \times 3) em um quadrado mágico com o menor custo possível.
 * Um quadrado mágico é uma matriz onde a soma de cada linha, coluna e diagonal é a mesma.
 * 
 * Estratégia de Solução:
 * 
 * Existem apenas 8 possíveis quadrados mágicos (3 \times 3) com números de 1 a 9.
 * Calcule o custo de transformar a matriz dada em cada um desses quadrados mágicos.
 * Retorne o menor custo encontrado.
 * 
 * *** Segunda solução
 * 
 * 1 - Reduzir Complexidade:
 * A solução atual já é eficiente, pois compara a matriz dada com todas as 8 possíveis matrizes mágicas (3 \times 3).
 * No entanto, garantir que o código seja claro e fácil de entender é sempre uma boa prática.
 * 
 * 2 - Melhorar a Legibilidade:
 * Certifique-se de que o código seja bem estruturado e comentado para facilitar a manutenção e a compreensão.
 * 
 * Melhorias Aplicadas:
 * 
 * - Constantes: Defini os quadrados mágicos como uma constante estática (MAGIC_SQUARES) para melhorar a legibilidade e a organização do código.
 * - Comentários: Adicionei comentários para explicar cada parte do código, facilitando a compreensão.
 * - Estrutura e Formatação: Mantive a estrutura do código clara e organizada, com indentação consistente e separação lógica dos blocos de código.
 * 
 * Essa abordagem mantém o código eficiente e fácil de entender, o que é crucial para a manutenção e colaboração em projetos maiores.
 * 
 * Explicação das Alterações:
 * 
 * List<List<Integer>>: Substituí int[][] por List<List<Integer>> para representar a matriz.
 * Leitura da Entrada: Usei ArrayList para ler a matriz de entrada.
 * Acesso aos Elementos: Ajustei o acesso aos elementos da matriz para usar os métodos get de List.
 * Essa abordagem mantém a funcionalidade original enquanto utiliza List<List<Integer>> para representar a matriz, conforme solicitado.
 */
public class FormingAMagicSquare {

	public static void main(String[] args) {
		int[][] s = new int[3][3];
		
		List<List<Integer>> list = new ArrayList<>();
		
        for (int i = 0; i < s.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < s[i].length; j++) {
                row.add(s[i][j]);
            }
            list.add(row);
        }

		System.out.println("Primeira solução: " + primeiraSolucao(s));
		System.out.println("Segunda solução: " + segundaSolucao(list));
	}


	public static int primeiraSolucao(int[][] s) {
        int[][][] magicSquares = {
            { {8, 1, 6}, {3, 5, 7}, {4, 9, 2} },
            { {6, 1, 8}, {7, 5, 3}, {2, 9, 4} },
            { {4, 9, 2}, {3, 5, 7}, {8, 1, 6} },
            { {2, 9, 4}, {7, 5, 3}, {6, 1, 8} },
            { {8, 3, 4}, {1, 5, 9}, {6, 7, 2} },
            { {4, 3, 8}, {9, 5, 1}, {2, 7, 6} },
            { {6, 7, 2}, {1, 5, 9}, {8, 3, 4} },
            { {2, 7, 6}, {9, 5, 1}, {4, 3, 8} }
        };
        
        int minCost = Integer.MAX_VALUE;
        
        for (int[][] magicSquare : magicSquares) {
            int currentCost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    currentCost += Math.abs(s[i][j] - magicSquare[i][j]);
                }
            }
            minCost = Math.min(minCost, currentCost);
        }
        
        return minCost;
	}

	public static int segundaSolucao(List<List<Integer>> ss) {
		// Definição dos 8 possíveis quadrados mágicos 3x3
	    final int[][][] MAGIC_SQUARES = {
	        { {8, 1, 6}, {3, 5, 7}, {4, 9, 2} },
	        { {6, 1, 8}, {7, 5, 3}, {2, 9, 4} },
	        { {4, 9, 2}, {3, 5, 7}, {8, 1, 6} },
	        { {2, 9, 4}, {7, 5, 3}, {6, 1, 8} },
	        { {8, 3, 4}, {1, 5, 9}, {6, 7, 2} },
	        { {4, 3, 8}, {9, 5, 1}, {2, 7, 6} },
	        { {6, 7, 2}, {1, 5, 9}, {8, 3, 4} },
	        { {2, 7, 6}, {9, 5, 1}, {4, 3, 8} }
	    };
	    
        int minCost = Integer.MAX_VALUE;
        
        // Calcular o custo de transformação para cada quadrado mágico
        for (int[][] magicSquare : MAGIC_SQUARES) {
            int currentCost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    currentCost += Math.abs(ss.get(i).get(j) - magicSquare[i][j]);
                }
            }
            minCost = Math.min(minCost, currentCost);
        }
        
        return minCost;
	}
}
