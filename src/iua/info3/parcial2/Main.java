
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) {

		List<Test> testeos = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("src\\iua\\info3\\parcial2\\Covid19Casos-10.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {

				String[] values = line.split(",");

				Test t = new Test();

				for (int i = 0; i < values.length; i++) {

					if (values[i].length() > 1)
						values[i] = values[i].substring(1, values[i].length() - 1);


					/*
					 * int idEventoCaso, char sexo, int edad, String edadTipo, String
					 * residenciaPais, String residenciaProvincia, String residenciaDepartamento,
					 * String cargaProvincia, String fechaInicioSintomas, String fechaApertura,
					 * String sepiApertura, String fechaInternacion, boolean cuidadoIntensivo,
					 * String fallecido, String fechaCuidadoIntensivo,String fechaFallecimiento,
					 * boolean asistenciaRespiratoriaMecanica, int cargaProvinciaId, boolean
					 * origenFinanciamiento, String clasificacion, String clasificacionResumen, int
					 * residenciaProvinciaId, String fechaDiagnostico, int residenciaDepartamentoId,
					 * String ultimaActualizacion
					 */

					// TO DO: Hacer todos los sets

				}
				t.setIdEventoCaso(values[0]);
				t.setSexo(values[1]);
				t.setEdad(values[2]);
				t.setEdadTipo(values[3]);
				t.setResidenciaPais(values[4]);
				t.setResidenciaProvincia(values[5]);
				t.setResidenciaDepartamento(values[6]);
				t.setCargaProvincia(values[7]);
				t.setFechaInicioSintomas(values[8]);
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

				testeos.add(t);
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

		int muestras = 0;
		int infectados = 0;
		int fallecidos = 0;

		int[] infectadosRango = new int[11];
		int[] fallecidosRango = new int[11];

		for (Test i : testeos) { // 1

			boolean infectado = false, fallecido = false;
			int tmp = 0;


			muestras++;

			if (i.getClasificacionResumen().equals("Confirmado")) { // +2
				infectados++;
				infectado = true;
			}

			if (i.isEdadTipo().equals("Años") && infectado) { // +3
				tmp = i.getEdad() / 10;
				infectadosRango[tmp]++;
			} else if (infectado) { // +4
				infectadosRango[0]++;
			}

			if (i.isFallecido().equals("Si") && infectado) {
				fallecidos++;
				fallecido = true;
			}

			if (i.isEdadTipo().equals("Años") && fallecido) {
				tmp = i.getEdad() / 10;
				fallecidosRango[tmp]++;
			} else if (fallecido) {
				fallecidosRango[0]++;
			}

		}

		double pInf = (double) infectados / muestras * 100;
		double pMue = (double) fallecidos / infectados * 100;

		System.out.printf("Cantidad total de muestras: %d %n", muestras);
		System.out.printf("Cantidad de infectados: %d %n ", infectados);
		System.out.printf("Cantidad de fallecidos: %d %n ", fallecidos);
		System.out.printf("Porcentaje de infectados por muestra: %.2f %% %n ", pInf);
		System.out.printf("Porcentaje de muertes por infectado: %.2f %% %n", pMue);
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
