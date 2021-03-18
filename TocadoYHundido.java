
package PROJECTE_VAIXELLS;

import java.util.Scanner;
import java.util.Random;
public class main {
	
	public static void mostrar(char[][] mT) { //Mostrarem el tauler amb caracters.
		int f,c;
		
		System.out.print(" ");
		for(f=0; f<mT.length; f++) { //Muestra los numeros de arriba
			System.out.print(" ");
			System.out.print(f);
		}
		System.out.println();
		for(f=0; f<mT.length; f++) {
			System.out.print(f);
			for(c=0; c<mT.length; c++) {
				System.out.print(" " + mT[f][c]);
			}
			System.out.println();
		}
		
	}
	public static void omplir(char[][] mT, char valor, int filaUser, int colUser) { //Omplirem el tauler amb punts.
		int f,c;
		for(f=0; f<mT.length; f++) {
			for(c=0; c<mT.length; c++) {
				mT[f][c]=valor;
				if(f==filaUser && c==colUser) {
				mT[f][c]='x';
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclat=new Scanner(System.in);
		Random ran=new Random();
		char [][] mTauler=new char[10][10];
		int f,c;
		int userFila, userCol;
		
		System.out.println("Introdueix la fila: ");
		userFila=teclat.nextInt();
		
		System.out.println("Introdueix la columna: ");
		userCol=teclat.nextInt();
		
		omplir(mTauler,'·', userFila, userCol);
		mostrar(mTauler);
		teclat.close();
	}

}
