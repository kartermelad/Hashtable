import java.util.Objects;

/**
 * An object used for the hashtable.
 * 
 * @author Karter Melad
 * @version Fall 2023
 */
public class HashObject {

    Object key;
    int frequency;
    int probeCount;

    /**
     * Constructor for creating a new HashObject
     * 
     * @param key
     */
    public HashObject(Object key) {
        this.key = key;
        frequency = 1;
        probeCount = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashObject that = (HashObject) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public String toString() {
        String string = " " + key + " " + frequency + " " + probeCount;
        return string;
    }

    /**
     * Returns the key
     */
    public Object getKey() {
        return key;
    }
}
