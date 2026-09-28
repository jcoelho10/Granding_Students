package br.com.hackerrank.algoritmos.implementacao;

/*
 * https://www.hackerrank.com/challenges/utopian-tree/problem?isFullScreen=true
 * 
 * A Árvore Utopiana passa por 2 ciclos de crescimento a cada ano:
 * 
 * Durante a primavera, a árvore dobra de altura.
 * Durante o verão, a altura da árvore aumenta em 1 metro.
 * Dada a altura inicial da árvore como 1 metro, você precisa determinar a altura da árvore após um determinado número de ciclos de crescimento.
 * 
 * Entrada:
 * Um número inteiro n que representa o número de ciclos de crescimento.
 * 
 * Saída:
 * Um número inteiro que representa a altura da árvore após n ciclos de crescimento.
 * 
 * Exemplo:
 * 
 * Entrada: n = 5
 * Saída: 14
 * 
 * Explicação:
 * 
 * Ciclo 0: altura = 1
 * Ciclo 1: primavera -> altura = 2
 * Ciclo 2: verão -> altura = 3
 * Ciclo 3: primavera -> altura = 6
 * Ciclo 4: verão -> altura = 7
 * Ciclo 5: primavera -> altura = 14
 * 
 * 
 * Explicação do Código:
 * 
 * Inicialização: 
 * A altura inicial da árvore é definida como 1 metro.
 * 
 * Iteração: 
 * Para cada ciclo, verifica se o ciclo é ímpar (primavera) ou par (verão) e ajusta a altura da árvore de acordo.
 * 
 * Entrada e Saída: 
 * O programa lê o número de casos de teste e, para cada caso, lê o número de ciclos e imprime a altura resultante da árvore.
 * 
 * Explicação das Melhorias:
 * 
 * Operador Ternário: 
 * Utilizar o operador ternário (i % 2 == 1) ? height * 2 : height + 1 para alternar entre os ciclos de primavera e verão de forma mais concisa.
 * 
 * Legibilidade: 
 * O código se torna mais fácil de ler e entender, mantendo a eficiência.
 */
public class UtopianTree {

	public static void main(String[] args) {
		int n = 5;
		
		System.out.println("Primeira Solução: " + primeiraSolucao(n));
		System.out.println("Segunda Solução: " + primeiraSolucao(n));

	}

	public static int primeiraSolucao(int n) {
		// altura inicial da árvore
		int height = 1;
		
		for (int i = 1; i <= n; i++) {
			
			if (i % 2 == 1) {
				
				// Ciclo de primavera (i impar)
				height *= 2;
				
			} else {
				// Ciclo de verão (i par)
				height += 1;
			}
		}
		
		return height;
	}
	
	public static int segundaSolucao(int n) {
		// altura inicial da árvore
		int height = 1;
		
		for (int i = 1; i <= n; i++) {
			
			height = (i % 2 == 1) ? height * 2 : height + 1;
		}
		
		return height;
	}
}
