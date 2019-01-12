package nezoter;


public class App {
	
	private final Reader reader;
	private final Facade test;
	private final Console console;
	private final Writer writer;
	
	public App() {
		console = new Console();
		reader = new Reader();
		test = new Facade(reader.getData("foglaltsag.txt"), reader.getData("kategoria.txt"));
		writer = new Writer("szabad.txt");
	}
	
	public static void main(String[] args) {
		new App().run();
	}
	
	private void run() {
		System.out.println("1. feladat: Az adatok beolvas�sa.\n");
		int sor = console.readInt("2.feladat: K�rem az �l�hely adatait. Sor: ");
		int szek = console.readInt("Sz�ksz�m: ");
		if (test.getChairInfo(sor, szek).equals("x")) {
			System.out.println("A �l�hely foglalt.\n");
		} else {
			System.out.println("Az �l�hely szabad.\n");
		}
		System.out.println("3.feladat: Az el�ad�sra eddig " + test.soldTicket() + " jegyet adtak el, ez a n�z�t�r "+ Math.round(((double)test.soldTicket()/(20*15))*100) + "%-a.\n");
		System.out.println("4.feladat: A legt�bb jegyet a(z) " + test.mostSold() + ". �rkateg�ri�ban �rt�kes�tett�k.\n");
		System.out.println("5. feladat: Az eddigi teljes bev�tel " + test.allIncome() + " Ft.-\n");
		System.out.println("6. feladat: �sszesen " + test.singleChair() + " darab 'egyed�l�ll�' �res hely van a n�z�t�ren.\n");
		System.out.println("7. feladat: A szabad.txt el��ll�t�sa.");
		writer.printAll(test.makeText());
	}

}
