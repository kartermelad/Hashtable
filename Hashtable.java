import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * A hash table for storing hash objects
 * 
 * @author Karter Melad
 * @version Fall 2023
 */
public abstract class Hashtable {

    protected int size;
    protected int capacity;
    protected double loadFactor;
    protected HashObject hash[];
    protected int duplicate;
    protected double totalProbes;

    /**
     * Constructor for creating a new Hashtable
     * 
     * @param capacity
     * @param loadFactor
     */
    public Hashtable(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.hash = new HashObject[capacity];
        this.size = 0;
        this.duplicate = 0;
        this.totalProbes = 0;
    }
    protected abstract int h(HashObject element, int probe);

    /**
     * Searches the Hashtable for a HashObject
     * 
     * @param key
     * @return HashObject if found, else null
     */
    public HashObject search(HashObject k) {
        int i = 0;
        while (hash[i] != null || i != capacity) {
            int probe = h(k, i);
            if (hash[probe] == k) {
                return hash[probe];
            }
        }
        return null;
    }

    /**
     * Inserts a HashObject into the Hashtable
     * 
     * @param k
     * @return integer
     */
    public int insert(HashObject k) {
        int i = 0;
        int counter = 0;
        while(i < capacity) {
            int probe = h(k, i);
            if(hash[probe] == null) {
                hash[probe] = k;
                hash[probe].probeCount += 1;
                size++;
                counter = 1;
                totalProbes +=  i + 1;
                return counter;
            } if(hash[probe].getKey().equals(k.getKey())) {
                hash[probe].frequency += 1;
                duplicate++;
                counter = -1;
                return counter;
            } else {
                k.probeCount++;
                i++;
            }
        }
        return counter;
    }

    /**
     * Returns the ratio of objects to table size
     * 
     * @return double loadFactor
     */
    public double loadFactor() {
        return (double)size / (double)capacity;
    }

    /**
     * Prints the file contents
     * 
     * @param fileName
     */
    public void dumpToFile(String fileName) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        for(int i = 0; i < capacity; i++) {
            if(hash[i] != null) {
                out.print("table[" + i + "]:");
                out.print(hash[i].toString());
                out.println();
            }
        }
       out.close();
    }

    /**
     * Gets the number of duplicates
     * 
     * @return integer duplicate
     */
    public int getDuplicates() {
        return duplicate;
    }

    /**
     * Get the average number of probes
     * 
     * @return double totalProbes
     */
    public double avgProbes() {
        return (double)totalProbes / (double)size;
    }
}
