package br.com.hackerrank.algoritmos.implementacao;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.hackerrank.com/challenges/grading/problem?isFullScreen=true
 * 
 * Você é um professor na Universidade HackerLand e precisa ajustar as notas dos alunos de acordo com as seguintes regras:
 * Qualquer nota menor que 40 é uma nota reprovada.
* Se a diferença entre a nota e o próximo múltiplo de 5 for menor que 3, arredonde a nota para esse próximo múltiplo de 5.
* Se a nota for menor que 38, não há arredondamento, pois a nota já é uma reprovação.
* Exemplo:
* 
* Entrada: grades = [73, 67, 38, 33]
* Saída: [75, 67, 40, 33]
* Explicação:
* 
* A nota 73 é arredondada para 75 (próximo múltiplo de 5).
* A nota 67 não é arredondada, pois a diferença para o próximo múltiplo de 5 é maior que 3.
* A nota 38 é arredondada para 40.
* A nota 33 não é arredondada, pois é menor que 38.
 */
public class GradingStudents {
	
	public static void main(String[] args) {
		List<Integer> grades = new ArrayList<>();
		grades.add(4);
		grades.add(73);
		grades.add(67);
		grades.add(38);
		grades.add(33);
		
		gradingStudentsFirsSolution(grades);
		gradingStudentsSecondSolution();
		gradingStudentsThirdSolution(grades);
	}
	
	public static void gradingStudentsFirsSolution(List<Integer> grades) {
		List<Integer> result = new ArrayList<>();
		for (Integer i : grades) {
			if (i <= 33) {
				result.add(i);
			}
			if (i > 33 && i <= 100) {
				if ((5 - (i % 5)) >= 3) {
					result.add(i);
				} else if ((i % 5) != 0 && (5 - (i % 5)) < 3) {
					int mod = 5 - (i % 5);
					result.add(i + mod);
				}
			}
		}
		
		System.out.println("Primeira Solução: ");
		System.out.println(result);
	}
	
	public static void gradingStudentsSecondSolution() {
		int[] grades = {4, 73, 67, 38, 33}; 
		
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 38) {
				int proximoMultiploDeCinco = ((grades[i] /5) + 1) * 5;
				
				if (proximoMultiploDeCinco - grades[i] < 3) {
					grades[i] = proximoMultiploDeCinco;
				}
			}
		}
		
		List<Integer> result = new ArrayList<>();
		for (int grade : grades) {
			result.add(grade);
		}
		
		System.out.println("Segunda Solução: ");
		System.out.println(result);
	}
	
	public static void gradingStudentsThirdSolution(List<Integer> grades) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < grades.size(); i++) {
			int mark = grades.get(i);
			if (mark < 38) {
				result.add(mark);
				
			} else {
				int multiple = (mark / 5) + 1;
				int mulof5 = multiple * 5;
				int diff = mulof5 - mark;
				if (diff < 3) {
					result.add(mulof5);
					
				}  else {
					result.add(mark);
				}
				
			}
		}
	
		System.out.println("Terceira Solução: ");
		System.out.println(result);
	}

}
