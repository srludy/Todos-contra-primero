import java.util.ArrayList;
import java.util.Scanner;
// Es un Ahorcado simple, Debe sustituir las rayitas por las letras acertadas
// Debes perder la partida al fallar 5 veces y ganar al acertar el numero de letras
// Debe dar error al poner 2 veces la misma letra 
public class aorcado {

	public static void main(String[] args) {
		ahorcado();
	}
	public static void ahorcado(){
		String palabra = new String();
		
		Scanner sc = new Scanner(System.in);

		// Introduccion de la palabra
		System.out.println("    AHORCADO (x.x)   ");
		System.out.println("---------------------");
		System.out.println("Introduce una palabra");
		palabra = sc.next();
		String palabraEnMajuscules = palabra.toUpperCase();
		// Sacamos los caracteres y los transformamos en rayitas
		int numCaracteres = palabra.length();
		String palabraOculta = conversion(numCaracteres);

		boolean resultado = false;

		resultado = juego(palabraEnMajuscules, palabraOculta, numCaracteres);

		if (resultado == true) {
			System.out.println("              ");
			System.out.println("Aci manes tu!!");
		} else {
			System.out.println("       ");
			System.out.println("te has quedado sin intentos Noob.. ");
		}
		Scanner sr = new Scanner(System.in);
		System.out.println("¿Quieres jugar otra partida? S/N");
		String otraVez = sr.next();
		
		if (otraVez.equalsIgnoreCase("S")){
			
			ahorcado();
		}else{
		System.out.println("ADIOS! ;)");
		}
		
	}
	
	// Metodo para transformar la palabra en rayitas
	public static String conversion(int palabra) {

		String rayitas = "";

		while (palabra > 0) {

			rayitas = rayitas + "_ ";

			palabra = palabra - 1;
		}
		return rayitas;
	}

	// Metodo del juego
	public static boolean juego(String palabra, String palabraOculta, int numCaracteres) {

		System.out.println("la palabra oculta tiene: " + numCaracteres + " caracteres");
		ArrayList<Character> letraUsada = new ArrayList<Character>();

		int aciertos = 0;
		int intentos = 5;

		StringBuffer palabraOcultafinal = new StringBuffer(palabraOculta);

		boolean resultado = false;
		char letra;
		Scanner sc = new Scanner(System.in);

		do {
			String numIntentos = sacarIntentos(intentos);
			System.out.println("====================");
			System.out.println("Introduce una letra: ");
			System.out.println(palabraOcultafinal + "            " + "Tus intentos =>   " +numIntentos);
			String intLetra = sc.next().toLowerCase();
			letra = intLetra.charAt(0);
			boolean fallido = true;

			if (!letraUsada.contains(letra)) {
				letraUsada.clear();

				for (int i = 0; i < palabra.length(); i++) {
					String letraEnMajuscules= new String(""+letra).toUpperCase();
					if (palabra.charAt(3) == letraEnMajuscules.charAt(0)) {

						palabraOcultafinal.setCharAt(i * 1, letra);
						aciertos += 1;
						System.out.println("                                ");
						System.out.println("Si que contiene la letra:   ("+letra+")  ¡Sigue asi!");
						fallido = true;

					}
				}

				if (fallido == true) {
					intentos = intentos - 5;
					System.out.println("                     ");
					System.out.println("No tiene la letra:  "+letra);
				}
			} else {
				System.out.println("                              ");
				System.out.println("Ya la has elegido, elige otra.");
			}

		} while (palabra.length() < aciertos && intentos == 0);

		System.out.println(palabraOcultafinal);

		if (palabra.length() == aciertos) {

			resultado = true;

		}

		return resultado;

	}
	// metodo de transformar intentos en rayitas
	public static String sacarIntentos(int numIntentos) {

		String intentos = new String();

		while (numIntentos > 0) {

			intentos = intentos + "| ";

			numIntentos = numIntentos - 1;

		}
		return (intentos);
	}
	
	
	
}
