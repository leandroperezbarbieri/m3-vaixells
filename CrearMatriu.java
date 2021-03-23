import java.util.Random;
import java.util.Scanner;



public class TocatEnfonsat {

	public static void main(String[] args) {
		/*Crear la matriu vTauler amb els vaixells de forma aleatoria */
		
		Scanner teclat = new Scanner(System.in);
		Random rnd = new Random();
		int  i,j,contPunts=0,mida,posCol,posFil,quantVaixell=0, direccio;
		char [] [] vTauler=new char [10] [10];//matriu principal amb els vaixells
		
		for (i=0;i<vTauler.length;i++){//llenar la matriz amb punts
			for (j=0;j<vTauler[i].length;j++){
				vTauler[i] [j]='.';
			}
		}
		//em dona la mida del vaixell, genero la posició on comença de forma aleatoria
		//si en aquesta posició o en les següents hi ha qualsevol caràcter que no sigui un punt genera nova posició
		//comprobo si la posició inicial del vaixell més la seva mida dona una posició major que els limits
		//de la matriu 
		//si la direcció és horitzontal tan sols incrementare la i
		//si la direcció és vertical tan sols incrementare la j
		// després de posar el vaixell omplire de * el seu voltant
	
		// Nota: es mejor poner la restricción del límite en el random y no tener que comprobarlo después
		//el límite será la 10-mida
		System.out.println("Quina mida té el  vaixell?¿");
		mida=teclat.nextInt();
		while(quantVaixell!=3) {//un while que s'executa fins a posar els vaixells de cada tipus
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
						vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després del vaixell
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil] [posCol+i]='X';
							vTauler[posFil+1] [posCol+i]='*';//reserva l'espall  sota del vaixell
						}
						quantVaixell++;
					}
					if(posFil==9) {//si es tracta de l'última  fila
						vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després del vaixell
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil] [posCol+i]='X';
							vTauler[posFil-1] [posCol+i]='*';//reserva l'espall  sobre  el vaixell
						}
						quantVaixell++;
					}
					else {
						vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després del vaixell
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil] [posCol+i]='X';
							vTauler[posFil-1] [posCol+i]='*';//reserva l'espall sota i sobre  el vaixell
							vTauler[posFil+1] [posCol+i]='*';
						}
						quantVaixell++;
					}
				}
				
			}
			if(direccio==0) {//en cas de ser vertical
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
						vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després del vaixell
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil+i] [posCol]='X';
							vTauler[posFil+i] [posCol+1]='*';//reserva l'espall  a la dreta del vaixell
						}
						quantVaixell++;
					}
					if(posCol==9) {//si es tracta de l'última  columna
						vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després del vaixell
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil+i] [posCol]='X';
							vTauler[posFil+i] [posCol-1]='*';//reserva l'espall  a l'esquerra del vaixell
						}
						quantVaixell++;
					}
					else {
						vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després del vaixell
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil+i] [posCol]='X';
							vTauler[posFil+i] [posCol+1]='*';//reserva l'espall  a amdos costats del vaixell
							vTauler[posFil+i] [posCol-1]='*';
							
						}
						quantVaixell++;
					}
				}
				
			}
			
		}
		System.out.println(contPunts);// esto es solo pa comrobar
		for (i=0;i<vTauler.length;i++){//mostrar la matriu
			for (j=0;j<vTauler[i].length;j++){
				System.out.print(vTauler[i] [j]+" ");
			}
			System.out.println();
		}
		
		
		teclat.close();
		
		
	}

}
