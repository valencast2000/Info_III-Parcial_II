
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) {

		List<Test> testeos = new ArrayList<>();

		try {
			try (BufferedReader br = new BufferedReader(
					new FileReader("src\\iua\\info3\\parcial2\\Covid19Casos-10.csv"))) {
				String line;
				while ((line = br.readLine()) != null) {

					String[] values = line.split(",");

					for (int i = 0; i < values.length; i++) {

						if (values[i].length() > 1)
							values[i] = values[i].substring(1, values[i].length() - 1);

						/*
						 * try { //Ponemos a "Dormir" el programa durante los ms que queremos
						 * Thread.sleep(2*1000); } catch (Exception e) { System.out.println(e); } }
						 */

						System.out.println("");

						Test t = new Test();
						// TO DO: Hacer todos los sets

						testeos.add(t);
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		infoEstadistica(testeos);

	} // fin metodo main

	// if(args[0]=="estad"){

	/*
	 * }
	 * 
	 * if(args[0]=="p_casos"){
	 * 
	 * } if(args[0]=="p_muertes"){
	 * 
	 * } if(args[0]=="casos_edad"){
	 * 
	 * } if(args[0]=="casos_cui"){
	 * 
	 * }
	 */

	public static void infoEstadistica(List<Test> testeos) {

		/*
		 * Información estadística: Cantidad total de muestras (un contador noma)
		 * Cantidad total de infectados (un contador noma) Cantidad de fallecidos (un
		 * contador noma) % de infectado por muestras ((infectados*100)/muestras) % de
		 * fallecidos por infectados ((fallecidos*100)/infectados) Cantidad de
		 * infectados por rango etario (rango de 10 años) (array) Cantidad de muertes
		 * por rango etario (rango de 10 años) (array)
		 */
		boolean flag = false;
		int muestras = 0;
		int infectados = 0;
		int fallecidos = 0;
		int tmp;
		int[] infectadosRango = new int[11];
		int[] fallecidosRango = new int[11];

		for (Test i : testeos) { // 1

			System.out.println("llego aca1");

			muestras++;

			if (i.getClasificacionResumen().equals("Confirmado")) { // +2
				infectados++;
				flag = true;
			}

			if (i.isEdadTipo().equals("Años") && flag) { // +3
				tmp = i.getEdad() / 10;
				infectadosRango[tmp]++;
			} else if (flag) { // +4
				infectadosRango[0]++;
			}

			System.out.println("llego aca2");

			if (i.isFallecido().equals("Si") && flag) {
				fallecidos++;
				flag = true;
			}

			if (i.isEdadTipo().equals("Años") && flag) {
				tmp = i.getEdad() / 10;
				fallecidosRango[tmp]++;
			} else if (flag) {
				fallecidosRango[0]++;
			}

			flag = false;

			System.out.println("llego aca3");

		}

		System.out.println("llego aca4");

		int pInf = (infectados / muestras) * 100;
		int pMue = (fallecidos / infectados) * 100;

		System.out.printf("Cantidad total de muestras: %d %n", muestras);
		System.out.printf("Cantidad de infectados: %d %n ", infectados);
		System.out.printf("Cantidad de fallecidos: %d %n ", fallecidos);
		System.out.printf("Porcentaje de infectados por muestra: %d %% %n ", pInf);
		System.out.printf("Porcentaje de muertes por infectado: %d %% %n", pMue);
		System.out.print("Cantidad de infectados por rango etario: ");
		for (int i = 0; i < infectadosRango.length; i++) {
			System.out.printf("Desde %d hasta %d : %d %n", i * 10, (i * 10) + 9, infectadosRango[i]);

		}
		System.out.print("Cantidad de fallecidos por rango etario: ");
		for (int i = 0; i < fallecidosRango.length; i++) {
			System.out.printf("Desde %d hasta %d : %d %n", i * 10, (i * 10) + 9, fallecidosRango[i]);

		}
	}// end-infoestadistica

	// Mostrará las n primeras provincias con más contagios ordenadas de más a
	// menos. Si n no es pasado, se mostrarán todas las provincias.
	// public static void provContagio(List<Test> testeos) {

	// } fin provContagio

}
// fin clase main
