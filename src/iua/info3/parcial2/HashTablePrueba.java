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
        System.out.print("ID:" + t.getIdEventoCaso() + " ");
        System.out.print("Edad:" + t.getEdad() + " ");
        System.out.print("Sexo:" + t.getSexo() + " ");
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

        System.out.print("Provincia: " + table[pos].pila.top().getResidenciaProvincia());
        System.out.println(" Casos: " + table[pos].pila.size);

        for (int i = 0; i < table[pos].pila.size;) {
            Test tmp = table[pos].pila.topAndPop();
            print(tmp);
        }
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
