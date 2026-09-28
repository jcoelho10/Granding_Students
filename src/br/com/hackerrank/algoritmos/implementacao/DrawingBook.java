package br.com.hackerrank.algoritmos.implementacao;

import java.util.function.BiFunction;

public class DrawingBook {
/*
 * https://www.hackerrank.com/challenges/drawing-book/problem?isFullScreen=true
 * 
 * Descrição do Problema
 * Um estudante pode começar a virar as páginas da frente ou de trás do livro. 
 * Cada página, exceto a última, é impressa em ambos os lados. 
 * Dado o número total de páginas ( n ) e a página alvo ( p ), o objetivo é encontrar o número mínimo de páginas a serem viradas.
 * 
 * Exemplo
 * Entrada: ( n = 5 ), ( p = 3 )
 * Saída: 1 (O estudante pode virar 1 página da frente ou de trás para chegar à página 3)
 * 
 */
	public static void main(String[] args) {

		System.out.println("Primeira Solução: " + primeiraSolucao(6, 2));
		System.out.println("Primeira Solução: " + primeiraSolucao(5, 4));
		System.out.println("Primeira Solução: " + primeiraSolucao(7, 3));
		System.out.println("Primeira Solução: " + primeiraSolucao(10, 6));
		System.out.println("Primeira Solução: " + primeiraSolucao(8, 5));
		System.out.println("Primeira Solução: " + primeiraSolucao(9, 4));
		System.out.println("Primeira Solução: " + primeiraSolucao(12, 7));
		System.out.println("Primeira Solução: " + primeiraSolucao(15, 14));
		
		System.out.println("Segunda Solução: " + segundaSolucao.apply(6, 2));
		System.out.println("Segunda Solução: " + segundaSolucao.apply(5, 4));
		System.out.println("Segunda Solução: " + segundaSolucao.apply(7, 3));
		System.out.println("Segunda Solução: " + segundaSolucao.apply(10, 6));
		System.out.println("Segunda Solução: " + segundaSolucao.apply(8, 5));
		System.out.println("Segunda Solução: " + segundaSolucao.apply(9, 4));
		System.out.println("Segunda Solução: " + segundaSolucao.apply(12, 7));
		System.out.println("Segunda Solução: " + segundaSolucao.apply(15, 14));
		
	}


	
	public static int primeiraSolucao(int n, int p) {
		int next = (p / 2);
		int back = (n / 2) - (p / 2);
		return Math.min(next, back);
	}
	
	static BiFunction<Integer, Integer, Integer> segundaSolucao = (totalPage, targetPage) -> {
		int next = (targetPage / 2);
		int back = (totalPage / 2) - (targetPage / 2);
		return Math.min(next, back);
	};
	

}
