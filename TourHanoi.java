public class TourHanoi {

	static int[][] tours = new int[][] {{9,6,3,0,0,0,0,0,0},{8,5,2,0,0,0,0,0,0},{7,4,1,0,0,0,0,0,0}};
	
	public static void main(String[] args) {
		affiche();
		algo(9,recherche(9));
		affiche();
	}
	
	static void affiche() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(tours[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// renvoie la colonne de n
	static int recherche(int n) {
		int tour = -1;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				if (tours[i][j] == n) {
					tour = i;
				}
			}
		}
		
		return tour;
	}
	
	// renvoie la colonne qui est ni A ni celle de n
	static int interm(int Pn, int A) {
		int i = 0;
		while (i == Pn || i == A) {
			i++;
		}
		return i;
	}
	
	// renvoie la premiere case libre de la colonne donnee
	static int caseLibre(int colonne) {
		int etage = 0;
		boolean trouve = false;
		int i = 0;
		while (trouve == false) {
			if (tours[colonne][i] == 0) {
				trouve = true;
				etage = i;
			}
			i++;
		}
		return etage;
	}

	// n = numero de la piece
	// A = destination (la ou on veut la mettre)
	static void algo(int n,int A) {
		if (n != 0) {
			int tourActuelle = recherche(n);
			if (tourActuelle == A) {
				algo(n-1,A);
			}
			else {
				algo(n-1,interm(tourActuelle,A));
				tours[A][caseLibre(A)] = n;
				tours[tourActuelle][caseLibre(tourActuelle)-1] = 0;
				affiche();
				algo(n-1,A);
			}
		}
	}
	
}
