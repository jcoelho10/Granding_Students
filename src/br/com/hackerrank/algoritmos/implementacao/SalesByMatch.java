package br.com.hackerrank.algoritmos.implementacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true
 * 
 * Você trabalha em uma loja de roupas onde há uma grande pilha de meias que precisam ser emparelhadas por cor. 
 * Dada uma lista de inteiros representando a cor de cada meia, 
 * o objetivo é determinar quantos pares de meias com cores correspondentes existem.
 * 
 * Exemplo:
 * 
 * Entrada: n = 9, ar = [10, 20, 20, 10, 10, 30, 50, 10, 20]
 * Saída: 3 (há três pares de meias: dois pares de cor 10 e um par de cor 20)
 * 
 */
public class SalesByMatch {

	// Solução com HashSet - Java 15
	public static void main(String[] args) {
		int n = 9;
		int[] arrayOfSocks = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		List<Integer> sm = new ArrayList<>();
		sm.add(10);
		sm.add(20);
		sm.add(20);
		sm.add(10);
		sm.add(10);
		sm.add(30);
		sm.add(50);
		sm.add(10);
		sm.add(20);

		salesByMatchFirstSolution(n, arrayOfSocks);
		salesByMatchSecondSolution(n, sm);
	}

	public static void salesByMatchFirstSolution(int n, int[] arrayOfSocks) {
		Set<Integer> set = new HashSet<>();
		int numberOfMatchingPairs = 0;
		for (int sock : arrayOfSocks) {
			if (!set.contains(sock)) {
				set.add(sock);
			} else {
				set.remove(sock);
				numberOfMatchingPairs++;
			}
		}
		System.out.println("Primeira Solução: ");
		System.out.println(numberOfMatchingPairs);
	}

	public static void salesByMatchSecondSolution(int n, List<Integer> ar) {
		int qtd = 0;
		Collections.sort(ar);
		int corrente = 0;
		boolean sim = false;

		for (int i = 0; i < n; i++) {
			if (ar.get(i).intValue() != corrente) {
				corrente = ar.get(i).intValue();
				sim = true;

			} else {
				if (sim)
					qtd++;
				sim = !sim;
			}
		}
		System.out.println("Segunda Solução: ");
		System.out.println(qtd);
	}

}
