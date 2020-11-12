package iua.info3.parcial2;

import java.io.*;
import java.util.*;

class Main {
  
	public static void main (String[] args){
		
		List<Test> testeos = new ArrayList<>();
		/*ArrayStack<Test> casos = new ArrayStack<>();*/
		
		try {
			try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Valen\\Documents\\Info_III-Parcial_II\\Info_III-Parcial_II\\src\\iua\\info3\\parcial2\\Covid19Casos-10.csv"))) {
				String line;
				while ((line = br.readLine()) != null) {
					
					String[] values = line.split(",");
					
					for(int i=0; i < values.length; i ++) {
						
						if(values[i].length() > 1)
							values[i] = values[i].substring(1, values[i].length() - 1);
           
					/*try {
						//Ponemos a "Dormir" el programa durante los ms que queremos
						Thread.sleep(2*1000);
					 } catch (Exception e) {
						System.out.println(e);
					 }
					}*/
					
					System.out.println("");
         		
					Test t = new Test();
					//TODO: Hacer todos los sets
						
					testeos.add(t);
					}

				}
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} //fin metodo main

		
			
		

		
/*
	if(args[0]=="estad"){
		infoEstadistica(testeos);

	}
	
	if(args[0]=="p_casos"){

	}
	if(args[0]=="p_muertes"){

	}
	if(args[0]=="casos_edad"){

	}
	if(args[0]=="casos_cui"){

	}
	*/


	public static void infoEstadistica (List<Test> testeos){
			/*Información estadística:
		  Cantidad total de muestras (un contador noma)
		  Cantidad total de infectados
		  Cantidad de fallecidos
          % de infectado por muestras
          % de fallecidos por infectados
          Cantidad de infectados por rango etario ( rango de 10 años)
		  Cantidad de muertes por rango etario ( rango de 10 años)
		  */
		
		
		for(Test i : testeos) {
			
			int muestras =  0;
			int infectados = 0;
			int fallecidos = 0;
			muestras++;

			if (i.getClasificacionResumen().equals("Confirmado")){
				infectados++;
				if (i.isFallecido().equals("Si")){
					fallecidos++;


				}
			}

			
			




		}



	}

}//fin clase main 






