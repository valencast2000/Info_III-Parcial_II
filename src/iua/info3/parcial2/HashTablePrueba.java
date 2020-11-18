import java.util.Arrays;

import structures.LinkedStack;

public class HashTablePrueba {
    HashEntry[] table;

    public HashTablePrueba(int size) {
        this.table = new HashEntry[size];
        Arrays.fill(table, null);
    }

    private int hashFunc(int key) {
        return (int) key % table.length;
    }

    public void insert(int clave, Test value) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] != null) {
            table[pos].pila.push(value);
        } else {
            table[pos] = new HashEntry(clave, value);
        }
    }

    public void print(Test t) {
        System.out.print(t.getIdEventoCaso() + " - " + t.getEdad() + " - " + t.isEdadTipo() + " - " + t.getSexo()
                + " - " + t.getResidenciaPais() + " - " + t.getResidenciaProvincia() + " - "
                + t.getResidenciaDepartamento() + " - " + t.getCargaProvincia() + " - " + t.getFechaInicioSintomas()
                + " - " + t.getFechaApertura() + " - " + t.getSepiApertura() + " - " + t.getFechaInternacion() + " - "
                + t.isCuidadoIntensivo() + " - " + t.getFechaCuidadoIntensivo() + " - " + t.isFallecido() + " - "
                + t.getFechaFallecimiento() + " - " + t.isAsistenciaRespiratoriaMecanica() + " - "
                + t.getCargaProvinciaId() + " - " + t.isOrigenFinanciamiento() + " - " + t.getClasificacion() + " - "
                + t.getClasificacionResumen() + " - " + t.getResidenciaProvinciaId() + " - " + t.getFechaDiagnostico()
                + " - " + t.getResidenciaDepartamentoId() + " - " + t.getUltimaActualizacion());

        System.out.println();

    }

    public int getSize(int clave) {
        if (table[hashFunc(clave)].pila.size == 0 || clave == 99) {
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

        System.out.print("Provincia: " + table[pos].pila.top().getCargaProvincia());
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
        } else if (table[pos].getKey() != clave) {
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
            pila = new LinkedStack<>();
            pila.push(value);
        }

        public int getKey() {
            return key;
        }

    }

}
