import java.util.Arrays;

import structures.LinkedStack;

public class HashTablePrueba {
    HashEntry[] table;

    public HashTablePrueba(int size) {
        this.table = new HashEntry[size]; // Crea HashEntry
        Arrays.fill(table, null);
    }

    private int hashFunc(int key) {
        return (int) key % table.length; // El valor de la tabla siempre es 100, por lo tanto dado q los ID van de 0-100
                                         // nunca colisionan prov diferentes
    }

    public void insert(int clave, Test value) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] != null) {
            table[pos].pila.push(value); // Cuando se da una colision pushea en la pila, el test mandado
        } else {
            table[pos] = new HashEntry(clave, value);
        }
    }

    public void print(Test t) {
        System.out.print(t.getIdEventoCaso() + "-" + t.getEdad() + "-" + t.isEdadTipo() + "-" + t.getSexo() + "-"
                + t.getResidenciaPais() + "-" + t.getResidenciaProvincia() + "-" + t.getResidenciaDepartamento() + "-"
                + t.getCargaProvincia() + "-" + t.getFechaInicioSintomas() + "-" + t.getFechaApertura() + "-"
                + t.getSepiApertura() + "-" + t.getFechaInternacion() + "-" + t.isCuidadoIntensivo() + "-" // IMPRIME
                                                                                                           // TODOS LOS
                                                                                                           // DATOS
                + t.getFechaCuidadoIntensivo() + "-" + t.isFallecido() + "-" + t.getFechaFallecimiento() + "-"
                + t.isAsistenciaRespiratoriaMecanica() + "-" + t.getCargaProvinciaId() + "-"
                + t.isOrigenFinanciamiento() + "-" + t.getClasificacionResumen() + "-" + t.getResidenciaProvinciaId()
                + "-" + t.getFechaDiagnostico() + "-" + t.getResidenciaDepartamentoId() + "-"
                + t.getUltimaActualizacion());

        System.out.println();

    }

    public int getSize(int clave) {
        if (table[hashFunc(clave)].pila.size == 0 || clave == 99) { // Este metodo lo utilizamos para ordenar las pilas
            return 0;
        }
        return table[clave].pila.size;
    }

    public void getPrint(int clave) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] == null) {
            throw new Exception("404");
        } else if (table[pos].getKey() != clave) {
            throw new Exception("404");
        }

        System.out.print("Provincia: " + table[pos].pila.top().getCargaProvincia()); // Lo mostramos aca para que no se
                                                                                     // muestre tanto
        System.out.println(" Casos: " + table[pos].pila.size);

        for (int i = 0; i < table[pos].pila.size;) {
            Test tmp = table[pos].pila.topAndPop();
            print(tmp);
        }
    }

    public String getNombre(int clave) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] == null) {
            throw new Exception("404");
        } else if (table[pos].getKey() != clave) { // Nos muestra la provincia donde se cargo el dato
            throw new Exception("404");
        }

        return table[pos].pila.top().getCargaProvincia();

    }

    public void remove(int clave) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] == null) {
            throw new Exception("404");
        } else if (table[pos].getKey() != clave) {
            throw new Exception("404");
        }
        table[pos] = null;
    }

    private static class HashEntry {
        int key;
        LinkedStack<Test> pila;

        public HashEntry(int key, Test value) {
            this.key = key;
            pila = new LinkedStack<>(); // En el constructor crea la pila, mandandando como top el primer valor q le
                                        // mandemos
            pila.push(value);
        }

        public int getKey() {
            return key;
        }

    }

}
