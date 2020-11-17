
package structures;

import java.util.Arrays;

public class HashTablePrueba<TypeKey extends Comparable> {
    HashEntry<TypeKey>[] table;

    public HashTablePrueba(int size) {
        this.table = new HashEntry[size];
        Arrays.fill(table, null);
    }

    private int hashFunc(TypeKey key) {
        return (int) key % table.length;
    }

    public void insert(TypeKey clave, int value) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] != null) {
            throw new Exception("Colision");
        }
        table[pos] = new HashEntry<>(clave, value);
    }

    public int get(TypeKey clave) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] == null) {
            throw new Exception("404");
        } else if (!table[pos].getKey().equals(clave)) {
            throw new Exception("404");
        }

        return table[pos].getValue();
    }

    public void remove(TypeKey clave) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] == null) {
            throw new Exception("404");
        } else if (!table[pos].getKey().equals(clave)) {
            throw new Exception("404");
        }
        table[pos] = null;
    }

    private static class HashEntry<TypeKey> {
        TypeKey key;
        int value;

        public HashEntry(TypeKey key, int value) { // cambiar ese value a 1 para usarlo como contador
            this.key = key;
            this.value = this.value + value;
        }

        public TypeKey getKey() {
            return key;
        }

        /*
         * public void setKey(TypeKey key) { this.key = key; }
         */

        public int getValue() {
            return value;
        }

        /*
         * public void setValue(TypeValue value) { this.value = value; }
         */
    }

}
