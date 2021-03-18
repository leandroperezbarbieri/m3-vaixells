import java.util.Scanner;
import java.util.Random;
public class TocadoYHundido {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclat=new Scanner(System.in);
		Random ran=new Random();
		int [][] mTauler=new int[10][10];
		int[] vVaixells = {4,3,2,1};
		int i,j; 
		int intents=25;
		System.out.println("Benvingut al joc Tocat i Enfonsat.");
		
		while(intents!=0) { //Un bucle
			System.out.print(" ");
			for(i=0; i<mTauler.length; i++) {
				System.out.print(" ");
				System.out.print(i);
			}
			System.out.println("");
			for(i=0; i<mTauler.length; i++) {
				System.out.print(i);
				for(j=0; j<mTauler.length; j++){
					System.out.print(" ·");
					
				}
				System.out.println("");
			}
			
			intents=0;
		}
		teclat.close();
	}

}
