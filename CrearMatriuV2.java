package uf1act1;

import java.util.Random;
import java.util.Scanner;



public class TocatEnfonsat {
	public static void  omplirRandom (char vTauler [] [], int quantVaixell, int mida) {/*Funció per omplir vTauler de vaixells aleatòriament */
		Random rnd = new Random();
		int i,j,contPunts=0,posCol,posFil,k=0, direccio;
				//em dona la mida del vaixell, genero la posició on comença de forma aleatoria
				//si en aquesta posició o en les següents hi ha qualsevol caràcter que no sigui un punt genera nova posició
				//comprobo si la posició inicial del vaixell més la seva mida dona una posició major que els limits
				//de la matriu 
				//si la direcció és horitzontal tan sols incrementare la i
				//si la direcció és vertical tan sols incrementare la j
				// després de posar el vaixell omplire de * el seu voltant
			
				// Nota: es mejor poner la restricción del límite en el random y no tener que comprobarlo después
				//el límite será la 10-mida
		while(k!=quantVaixell) {//un while que s'executa fins a posar els vaixells de cada tipus
			direccio=rnd.nextInt(2);//si dona 1 la direcció serà vertical, si dona 0 serà horitzontal
			if(direccio==0) {//en cas de ser horitzontal
				contPunts=0;
				posCol=rnd.nextInt(10-mida);//posicio inicial de columna  del 0 a 10-mida 
				posFil=rnd.nextInt(10);//posicio inicial de fila  del 0 al 9
				for(i=0;i<=mida;i++) {//comrpobar si n'hi ha punts en les successives posicions del vaixell
					if(vTauler[posFil] [posCol+i]=='.') {
						contPunts=contPunts+1;
					}
				}
				if(contPunts==mida+1) {//si n'hi ha tants punts com espais necessita el vaixell, ho escriu
					if(posFil==0) {//si es tracta de la primera  fila
						if(posCol==0) {
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després del vaixell
						}
						else if(posCol!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil] [posCol-1]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil] [posCol+i]='X';
							vTauler[posFil+1] [posCol+i]='*';//reserva l'espall  sota del vaixell
						}
						k++;
					}
					if(posFil==9) {//si es tracta de l'última  fila
						if(posCol==0) {
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després del vaixell
						}
						else if(posCol!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil] [posCol-1]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil] [posCol+i]='X';
							vTauler[posFil-1] [posCol+i]='*';//reserva l'espall  sobre  el vaixell
						}
						k++;
					}
					else if (posFil!=9 && posFil!=0) {
						if(posCol==0) {
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després del vaixell
						}
						else if(posCol!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil] [posCol-1]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil] [posCol+i]='X';
							vTauler[posFil-1] [posCol+i]='*';//reserva l'espall sota i sobre  el vaixell
							vTauler[posFil+1] [posCol+i]='*';
						}
						k++;
					}
				}
				
			}
			if(direccio==1) {//en cas de ser vertical
				contPunts=0;
				posCol=rnd.nextInt(10);//posicio inicial de columna   del 0 al 9
				posFil=rnd.nextInt(10-mida);//posicio inicial de fila  del 0 a 10-mida
				for(i=0;i<=mida;i++) {//comrpobar si n'hi ha punts en les successives posicions del vaixell
					if(vTauler[posFil+i] [posCol]=='.') {
						contPunts++;
					}
				}
				if(contPunts==mida+1) {//si n'hi ha tants punts com espais necessita el vaixell, ho escriu
					if(posCol==0) {//si es tracta de la primera  columna
						if(posFil==0) {
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després del vaixell
						}
						else if(posFil!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil-1] [posCol]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil+i] [posCol]='X';
							vTauler[posFil+i] [posCol+1]='*';//reserva l'espall  a la dreta del vaixell
						}
						k++;
					}
					if(posCol==9) {//si es tracta de l'última  columna
						if(posFil==0) {
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després del vaixell
						}
						else if(posFil!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil-1] [posCol]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil+i] [posCol]='X';
							vTauler[posFil+i] [posCol-1]='*';//reserva l'espall  a l'esquerra del vaixell
						}
						k++;
					}
					else if (posCol!=9 && posCol!=0) {
						if(posFil==0) {
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després del vaixell
						}
						else if(posFil!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil-1] [posCol]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil+i] [posCol]='X';
							vTauler[posFil+i] [posCol+1]='*';//reserva l'espall  a amdos costats del vaixell
							vTauler[posFil+i] [posCol-1]='*';
							
						}
						k++;
					}
				}
				
			}
			
		}
		
			
	}

	public static void main(String[] args) {
		/*Crear la matriu vTauler amb els vaixells de forma aleatoria */
		
		Scanner teclat = new Scanner(System.in);
		Random rnd = new Random();
		int  i,j,mida,quantVaixell;
		char [] [] vTauler=new char [10] [10];//matriu principal amb els vaixells
		
		for (i=0;i<vTauler.length;i++){//omplir la matriu amb punts
			for (j=0;j<vTauler[i].length;j++){
				vTauler[i] [j]='.';
			}
		}
		omplirRandom(vTauler, 1,4);	/*1 vaixell de 4, 2 de 3, 3 de 2 i 4 d’1*/
		omplirRandom(vTauler, 2,3);
		omplirRandom(vTauler, 3,2);
		omplirRandom(vTauler, 4,1);
		
		for (i=0;i<vTauler.length;i++){//mostrar la matriu
			for (j=0;j<vTauler[i].length;j++){
				System.out.print(vTauler[i] [j]+" ");
			}
			System.out.println();
		}
		
		
		teclat.close();
		
		
	}

}
