package br.com.hackerrank.algoritmos.implementacao;

/*
 * https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
 * 
 * Você tem dois gatos e um rato posicionados em diferentes pontos de uma linha. 
 * Você receberá as posições iniciais dos gatos e do rato. 
 * Sua tarefa é determinar qual gato alcançará o rato primeiro, assumindo que o rato não se move e que os gatos se movem à mesma velocidade. 
 * Se os gatos chegarem ao mesmo tempo, o rato escapará enquanto eles lutam.
 * 
 * Entrada:
 * Vários casos de teste.
 * Para cada caso de teste, três inteiros ( x ), ( y ) e ( z ) representando as posições dos gatos A, B e do rato C, respectivamente.
 * 
 * Saída: 
 * Para cada caso de teste, imprima:
 * “Cat A” se o gato A alcançar o rato primeiro.
 * “Cat B” se o gato B alcançar o rato primeiro.
 * “Mouse C” se ambos os gatos alcançarem o rato ao mesmo tempo.
 * 
 * Exemplo:
 * 
 * Entrada: x = 1, y = 2, z = 3
 * Saída: Cat B
 * 
 * Entenda o Problema:
 * 
 * Você precisa determinar qual dos dois gatos alcançará o rato primeiro, ou se ambos chegarão ao mesmo tempo.
 * Se ambos os gatos chegarem ao mesmo tempo, o rato escapará.
 * 
 * Estratégia de Solução:
 * Calcule a distância entre cada gato e o rato.
 * Compare as distâncias para determinar qual gato está mais próximo.
 * Se as distâncias forem iguais, o rato escapa.
 * 
 * Explicação do Código:
* 
* Função catAndMouse:
* Calcula a distância entre o gato A e o rato (distanceCatA).
* Calcula a distância entre o gato B e o rato (distanceCatB).
* 
* Compara as distâncias:
* Se distanceCatA for menor, retorna “Cat A”.
* Se distanceCatB for menor, retorna “Cat B”.
* Se as distâncias forem iguais, retorna “Mouse C”.
* 
* Função main:
* Lê o número de casos de teste.
* Para cada caso de teste, lê as posições dos gatos e do rato.
* Chama a função catAndMouse e imprime o resultado.
 */
public class CatAndAMouse {

	public static void main(String[] args) {
		int x = 2;
		int y = 5;
		int z = 4;
		
		System.out.println("Primeira Solução:" + primeiraSolucao(x, y, z));
		System.out.println("Segunda Solução:" + segundaSolucao(x, y, z));

	}

	public static String primeiraSolucao(int x, int y, int z) {
		
		int distanceCatA = Math.abs(x - z);
		int distanceCatB = Math.abs(y - z);
		
		if (distanceCatA < distanceCatB) {
			return "Cat A";
		
		} else if (distanceCatB < distanceCatA) {
			return "Cat B";
			
		} else {
			return "Mouse";
		}
		
	}
	
	public static String segundaSolucao(int x, int y, int z) {
		
		int distanceCatA = Math.abs(z - x);
		int distanceCatB = Math.abs(z - y);
		
		if (distanceCatA == distanceCatB) {
			return "Mouse C";
			
		} else {
			return distanceCatA < distanceCatB ? "Cat A" : "Cat B";
		}
		
	}

}
