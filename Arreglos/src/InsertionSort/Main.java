package InsertionSort;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int elementos;
		float aux;
		elementos = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de elementos"));
		
		float[] numeros = new float[elementos];
		
		System.out.println("Digite los elementos del arreglo: ");
		for (int i=0;i<elementos;i++) {
			numeros[i] = in.nextFloat();
		}
				
		//BubbleSort
		for (int i=0; i <elementos-1;i++) {
			for (int j=0; j <elementos-1;j++) {
				if(numeros[j]>numeros[j+1]) {
					aux= numeros[j];
					numeros[j]=numeros[j+1];
					numeros[j+1]=aux;
				}
			}
		}
		
		System.out.println("\n Los elementos del arreglo son: ");
		for(float i:numeros) {
			System.out.println(i + " ");
		}
	
		
		
	}

}
