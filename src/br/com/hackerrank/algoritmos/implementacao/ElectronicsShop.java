package br.com.hackerrank.algoritmos.implementacao;

import java.util.Arrays;

/*
 * https://www.hackerrank.com/challenges/electronics-shop/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * 
 * Uma pessoa quer determinar o teclado de computador e o pen drive USB 
 * mais caros que podem ser comprados com um orçamento dado. 
 * Dadas as listas de preços de teclados e pen drives USB, e um orçamento, 
 * você deve encontrar o custo máximo para comprar ambos os itens. 
 * Se não for possível comprar ambos os itens dentro do orçamento, retorne -1.
 * 
 * Entrada:
 * 
 * Um número inteiro b que representa o orçamento.
 * Uma lista de inteiros keyboards que representa os preços dos teclados.
 * Uma lista de inteiros drives que representa os preços dos pen drives USB.
 * 
 * Saída:
 * 
 * Um número inteiro que representa o custo máximo para comprar ambos os itens ou -1 se não for possível.
 * 
 * Exemplo:
 * 
 * Entrada: b = 60, keyboards = [40, 50, 60], drives = [5, 8, 12]
 * Saída: 58 (comprando o teclado de 50 e o pen drive de 8)
 * 
 * 1 - Entenda o Problema:
 * 
 * Você precisa encontrar a combinação mais cara de um teclado e um pen drive USB que pode ser comprada dentro de um orçamento dado.
 * Se não for possível comprar ambos os itens dentro do orçamento, você deve retornar -1.
 * 
 * 2 - Estratégia de Solução:
 * Percorra todas as combinações possíveis de teclados e pen drives.
 * Calcule o custo total de cada combinação.
 * Verifique se o custo total está dentro do orçamento e, se estiver, mantenha o maior valor encontrado.
 * 
 * Explicação do Código:
 * 
 * Leitura dos Dados: 
 * O código lê o orçamento, o número de teclados e pen drives, e os preços de cada um.
 * 
 * Combinações de Preços: 
 * Percorre todas as combinações possíveis de teclados e pen drives, calcula o custo total e verifica se está dentro do orçamento.
 * 
 * Resultado: 
 * Mantém o maior valor encontrado que esteja dentro do orçamento e retorna esse valor. Se nenhuma combinação for possível, retorna -1.
 * 
 * ***Segunda Solução
 * 
 * 1 - Ordenação e Pesquisa Binária:
 * Ordenar os arrays de teclados e pen drives.
 * Para cada teclado, usar pesquisa binária para encontrar o pen drive mais caro que ainda esteja dentro do orçamento.
 * 
 * 2 - Reduzir Comparações:
 * Em vez de verificar todas as combinações, você pode parar de verificar assim que encontrar uma combinação que exceda o orçamento, 
 * uma vez que os arrays estão ordenados.
 * 
 * * ***Terceira Solução
 * 
 * 1 - Reduzir o Número de Comparações:
 * Em vez de verificar todas as combinações possíveis, 
 * você pode usar uma abordagem mais eficiente ao iterar sobre os arrays de forma ordenada e 
 * parar assim que o custo total exceder o orçamento.
 * 
 * 2 - Usar Pesquisa Binária:
 * Ordenar os arrays e usar pesquisa binária para encontrar o pen drive mais caro que ainda esteja dentro do orçamento para cada teclado.
 * 
 */
public class ElectronicsShop {

	public static void main(String[] args) {
		int b = 60;
		int[] keyboards = {40, 50, 60};
		int[] drivers = {5, 8, 12};
		
		System.out.println("Primeira solução: " + primeiraSolucao(keyboards, drivers, b));
		System.out.println("Segunda solução: " + segundaSolucao(keyboards, drivers, b));
		System.out.println("Terceira solução: " + terceiraSolucao(keyboards, drivers, b));
	}
	
	public static int primeiraSolucao(int[] keyboards, int[] drivers, int b) {
		int maxSpent = -1;
		
		for (int keyboard : keyboards) {
			for (int drive : drivers) {
				int totalCost = keyboard + drive;
				if (totalCost < b && totalCost > maxSpent) {
					maxSpent = totalCost;
				}
			}
		}
		
		return maxSpent;
	};
	
	public static int segundaSolucao(int[] keyboards, int[] drivers, int b) {
		
		Arrays.sort(keyboards);
		Arrays.sort(drivers);
		
		int maxSpent = -1;
		
		// Percorrer os teclados do mais caro ao mais barato
		for (int i = keyboards.length -1; i >= 0; i--) {
			
			if (keyboards[i] >= b) continue; // Ignorar teclados que já são maiores que o orçamento
			
			for (int j = 0; j < drivers.length; j++) {
				
				int totalCost = keyboards[i] + drivers[j];
				
				if (totalCost > b) break; // Parar se o custo total exceder o orçamento
				
				if (totalCost > maxSpent) {
					maxSpent = totalCost;
				}
				
			}
		}
		
		return maxSpent;
		
	};
	
	// Essa solução foi a que funcionou por total o site do Hackerrank
	public static int terceiraSolucao(int[] keyboards, int[] drives, int budget) {
		
		   // Ordenar os arrays
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        
        int maxSpent = -1;
        
        // Percorrer os teclados do mais caro ao mais barato
        for (int i = keyboards.length - 1; i >= 0; i--) {
            if (keyboards[i] >= budget) continue; // Ignorar teclados que já são mais caros que o orçamento
            
            // Usar pesquisa binária para encontrar o pen drive mais caro dentro do orçamento
            int left = 0, right = drives.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int totalCost = keyboards[i] + drives[mid];
                
                if (totalCost <= budget) {
                    maxSpent = Math.max(maxSpent, totalCost);
                    left = mid + 1; // Procurar por um pen drive mais caro
                } else {
                    right = mid - 1; // Procurar por um pen drive mais barato
                }
            }
        }
        
        return maxSpent;
	}

}
