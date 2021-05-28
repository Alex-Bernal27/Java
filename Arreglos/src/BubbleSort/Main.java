package BubbleSort;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int elementos, pos;
		float aux;
		elementos = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de elementos"));
		
		float[] numeros = new float[elementos];
		
		System.out.println("Digite los elementos del arreglo: ");
		for (int i=0;i<elementos;i++) {
			numeros[i] = in.nextFloat();
		}
				
		//InsertionSort
		for (int i=0; i<elementos;i++) {
			pos = i;
			aux = numeros[i];
			
			while((pos>0) && (numeros[pos-1]>aux)) {
				numeros[pos] = numeros[pos-1];
				pos--;
			}
			numeros[pos] = aux;
		}
		
		System.out.println("\n Los elementos del arreglo son: ");
		for(float i:numeros) {
			System.out.println(i + " ");
		}
	
		
		
	}

}
