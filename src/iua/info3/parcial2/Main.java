import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import structures.AvlTree;

class Main {

	public static void main(String[] args) throws Exception {
		String fileName = "";
		long t_inicio = 0; /* Para contar cuanto tarda */
		long t_final = 0;

		t_inicio = System.nanoTime();

		List<Test> testeos = new ArrayList<>(); // Guardamos todo en una lista

		if (args[args.length - 1].contains(".csv")) {
			fileName = args[args.length - 1];
		}

		try (BufferedReader br = new BufferedReader(new FileReader("src\\iua\\info3\\parcial2\\" + fileName))) {
			String line;
			while ((line = br.readLine()) != null) {

				String[] values = line.split(","); // Dividimos todo por lineas

				Test t = new Test(); // Creamos t para ir almacenando los datos de cada linea

				for (int i = 0; i < values.length; i++) {

					if (values[i].length() > 1) {
						values[i] = values[i].substring(1, values[i].length() - 1); // esto nos sirve para eliminar las
																					// comillas
					} else {
						values[i] = "0"; // cuando sea ,DATO,,DATO, lo ponemos en 0
					}

				}

				t.setIdEventoCaso(values[0]);
				t.setSexo(values[1]);
				t.setEdad(values[2]);
				t.setEdadTipo(values[3]);
				t.setResidenciaPais(values[4]);
				t.setResidenciaProvincia(values[5]);
				t.setResidenciaDepartamento(values[6]);
				t.setCargaProvincia(values[7]);
				t.setFechaInicioSintomas(values[8]); // SETEAMOS TODOS LOS VALORES, PARA GUARDARLOS EN t q es del tipo
														// Test
				t.setFechaApertura(values[9]);
				t.setSepiApertura(values[10]);
				t.setFechaInternacion(values[11]);
				t.setCuidadoIntensivo(values[12]);
				t.setFechaCuidadoIntensivo(values[13]);
				t.setFallecido(values[14]);
				t.setFechaFallecimiento(values[15]);
				t.setAsistenciaRespiratoriaMecanica(values[16]);
				t.setCargaProvinciaId(values[17]);
				t.setOrigenFinanciamiento(values[18]);
				t.setClasificacion(values[19]);
				t.setClasificacionResumen(values[20]);
				t.setResidenciaProvinciaId(values[21]);
				t.setFechaDiagnostico(values[22]);
				t.setResidenciaDepartamentoId(values[23]);
				t.setUltimaActualizacion(values[24]);

				testeos.add(t); // Guardamos t en la lista

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String tmp = args.length > 2 ? args[1] : "null";

		if (args[0].equals("-estad")) {
			infoEstadistica(testeos);

		} else if (args[0].equals("-p_casos")) {
			if (tmp.equals("null")) {
				provContagio(testeos, 0);
			} else {
				int n = Integer.parseInt(tmp);
				provContagio(testeos, n);
			}

		} else if (args[0].equals("-p_muertes")) {
			if (tmp.equals("null")) {
				provMuertes(testeos, 0);
			} else {
				int n = Integer.parseInt(tmp);
				provMuertes(testeos, n);
			}

		} else if (args[0].equals("-casos_edad")) {
			if (tmp.equals("null")) {
				System.out.println("No paso edad");
			} else {
				int n = Integer.parseInt(tmp);
				casosEdad(testeos, n);
			}

		} else if (args[0].equals("-casos_cui")) {
			if (tmp.equals("null")) {
				casosCui(testeos, "1000-01-01");
			} else {
				casosCui(testeos, tmp);
			}
		}

		// final COMPROBAR PARAMETROS

		t_final = System.nanoTime();

		System.out.println((t_final - t_inicio) / 1000000 + "ms"); // Para que imprima el tiempo final en ms

	} // fin metodo main

	public static void infoEstadistica(List<Test> testeos) { // inicio parametro -estad

		int muestras = 0;
		int infectados = 0;
		int fallecidos = 0;

		int[] infectadosRango = new int[13];
		int[] fallecidosRango = new int[13];

		for (Test i : testeos) { // 1

			boolean infectado = false; // Creamos banderas para comprobar si:
			boolean fallecido = false; // esta infectado y si fallecio.

			muestras++; // contabilizamos todas las muestras

			if (i.getClasificacionResumen().equals("Confirmado")) { // Vemos si el caso esta confirmado, si lo esta:
				infectados++; // aumentamos contador de infectados
				infectado = true; // Ponemos flag de infectado a true
			}

			if (i.isEdadTipo().equals("Años") && infectado && i.getEdad() != 0 && i.getEdad() < 129) { // (*)
																										// Comprobamos
																										// si: la edad
																										// esta escrita
																										// en años, esta
																										// infectado
				int tmp = i.getEdad() / 10; // Calculamos rango etario // Si la edad fue cargada y si es menor a 129
											// (rango maximo)
				infectadosRango[tmp]++;
			} else if (infectado && i.getEdad() != 0 && i.getEdad() < 129) {
				infectadosRango[0]++; // Como no esta escrita en años quiere decir q la persona tiene menos de un año
			}

			if (i.isFallecido().equals("SI") && infectado) { // Vemos si la persona fallecio, si lo esta:
				fallecidos++; // Aumentamos contador de fallecidos
				fallecido = true; // Cambiamos bandera a true
			}

			if (i.isEdadTipo().equals("Años") && fallecido && i.getEdad() != 0 && i.getEdad() < 129) { // Igual que en
																										// (*)
				int tmp = i.getEdad() / 10;
				fallecidosRango[tmp]++;

			} else if (fallecido && i.getEdad() != 0 && i.getEdad() < 129) {
				fallecidosRango[0]++;
			}

		}

		double pInf = (double) infectados / muestras * 100; // Sacamos porcentajes
		double pMue = (double) fallecidos / infectados * 100;

		System.out.printf("Cantidad total de muestras: %d %n", muestras);
		System.out.printf("Cantidad de infectados: %d %n ", infectados);
		System.out.printf("Cantidad de fallecidos: %d %n ", fallecidos);
		System.out.printf("Porcentaje de infectados por muestra: %.2f %% %n ", pInf);
		System.out.printf("Porcentaje de muertes por infectado: %.2f %% %n",
				pMue);/* IMPRIMIMOS TODAS LAS ESTADISTICAS */
		System.out.print("Cantidad de infectados por rango etario: ");
		for (int i = 0; i < infectadosRango.length; i++) {
			System.out.printf("Desde %d hasta %d : %d %n", i * 10, (i * 10) + 9, infectadosRango[i]);

		}
		System.out.print("Cantidad de fallecidos por rango etario: ");
		for (int i = 0; i < fallecidosRango.length; i++) {
			System.out.printf("Desde %d hasta %d : %d %n", i * 10, (i * 10) + 9, fallecidosRango[i]);

		}
	}// end-infoestadistica

	public static void provContagio(List<Test> testeos, int limite) throws Exception {

		HashTablePrueba ht = new HashTablePrueba(100); // Creamos una hastable. (La hash table cuando se da una colision
														// hace un push en una pila)
		int[] idProv = new int[25]; // Seteamos el valor a 25 para reservar espacio para todas las provincias
		Arrays.fill(idProv, 0); // Rellenamos todo el array de 0

		int r = 0;

		for (Test i : testeos) {
			if (i.getClasificacionResumen().equals("Confirmado")) { // Vemos si el caso esta confirmado
				ht.insert(i.getCargaProvinciaId(), i); // Insertamos el valor, por key
				for (int j = 0; j < idProv.length; j++) {
					if (idProv[j] == i.getCargaProvinciaId()) {
						j += idProv.length;
					} else if (idProv[j] == 0) {
						idProv[j] = i.getCargaProvinciaId();
						r++;
						break;
					}
				}
			}
		}

		ordenar(idProv, ht, r); // Ordenamos las keys.
		System.out.println(r);

		/*
		 * if (limite > r) { // r es una variable, q utilizamos para saber limite = r;
		 * // cuanto del arr idProv utilizamos }
		 * 
		 * if (limite != 0) { // Si hay parametro n, imprimimos hasta ahi for (int i =
		 * 0; i < limite; i++) { System.out.print("1:"); ht.getPrint(idProv[i]); } }
		 * else { // Si no, imprimos todo for (int i = 0; idProv[i] != 0; i++) {
		 * System.out.print("1:"); ht.getPrint(idProv[i]); } }
		 */

	}// fin provContagio

	public static void provMuertes(List<Test> testeos, int limite) throws Exception {
		HashTablePrueba ht = new HashTablePrueba(100);
		int[] idProv = new int[25];
		Arrays.fill(idProv, 0);
		int r = 0;
		for (Test i : testeos) {
			if (i.getClasificacionResumen().equals("Confirmado")) { //
				if (i.isFallecido().equals("SI")) { //
					ht.insert(i.getCargaProvinciaId(), i); // Igual que metodo provContagio
					for (int j = 0; j < idProv.length; j++) { // con if adicional en linea 236
						if (idProv[j] == i.getCargaProvinciaId()) { // q compara si la persona fallecio.
							j += idProv.length; //
						} else if (idProv[j] == 0) { //
							idProv[j] = i.getCargaProvinciaId(); //
							r++;
							break;
						}
					}
				}
			}
		}

		ordenar(idProv, ht, r);

		if (limite > r) {
			limite = r;
		}

		if (limite != 0) {

			for (int i = 0; i < limite; i++) {
				System.out.print("1:");
				ht.getPrint(idProv[i]);
			}
		} else {
			for (int i = 0; idProv[i] != 0; i++) {
				System.out.print("1:");
				ht.getPrint(idProv[i]);
			}

		}

	}

	public static void casosEdad(List<Test> testeos, int n) throws Exception {
		HashTablePrueba ht = new HashTablePrueba(100);
		int[] idProv = new int[25];
		Arrays.fill(idProv, 0);
		int r = 0;
		int edad = n;
		for (Test i : testeos) { //
			if (i.getClasificacionResumen().equals("Confirmado")) { // igual q metodo idProv solo que almacena por edad
				if (i.getEdad() == edad) { //
					ht.insert(i.getCargaProvinciaId(), i); //
					for (int j = 0; j < idProv.length; j++) { //
						if (idProv[j] == i.getCargaProvinciaId()) { //
							j += idProv.length; //
						} else if (idProv[j] == 0) { //
							idProv[j] = i.getCargaProvinciaId(); //
							r++;
							break;
						}
					}
				}
			}
		}

		ordenarNombre(idProv, ht, r); // Ordenamos por nombre las key almacenadas en idProv

		for (int i = 0; idProv[i] != 0; i++) {
			System.out.print(i + 1 + ": ");
			ht.getPrint(idProv[i]);
		}

	}

	public static void casosCui(List<Test> testeos, String fechaprueba) throws ParseException {
		SimpleDateFormat fechaformato = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		if (fechaprueba != "null") {
			fecha = fechaformato.parse(fechaprueba);
		} else {
			fechaprueba = "2000-01-01";
			fecha = fechaformato.parse(fechaprueba);
		}

		CuiFecha cuiFechaGeneral = new CuiFecha(fecha, null);
		AvlTree<CuiFecha> arbol = new AvlTree<>();

		for (Test i : testeos) {

			if (i.getFechaCuidadoIntensivo() != null) {
				CuiFecha cuiFecha = new CuiFecha(i.getFechaCuidadoIntensivo(), i);
				if (cuiFecha.compareTo(cuiFechaGeneral) >= 0) {
					arbol.insert(cuiFecha);
				}
			}
		}
		arbol.printTree();
	}

	public static void ordenar(int[] claves, HashTablePrueba ht, int r) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < r; j++) {
				if (ht.getSize(claves[i]) > ht.getSize(claves[j])) {
					int tmp = (claves[i]);
					claves[i] = claves[j]; // *Utilizamos el metodo
					claves[j] = tmp; // *burbuja para ordenar
										// *las claves,
				}
			}
		}
	}

	public static void ordenarNombre(int[] claves, HashTablePrueba ht, int r) throws Exception {

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < r; j++) {

				if (!ht.getNombre(claves[i]).equals(ht.getNombre(claves[j]))) {
					if (ht.getNombre(claves[i]).charAt(0) < ht.getNombre(claves[j]).charAt(0)) { // Utilizamos metodo
																									// burbuja
						int tmp = (claves[i]); // para ordenar por nombre
						claves[i] = claves[j];
						claves[j] = tmp;
					}
				}
			}

		}

	}

}// fin clase main
