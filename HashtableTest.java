import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * A tester for the Hashtable class
 * 
 * @author Karter Melad
 * @version Fall 2023
 */
public class HashtableTest {
    public static void main(String[] args) throws FileNotFoundException {

        String data = null;
        int dataType = 0;
        double loadFactor = 0;
        int debugLevel = 0;
        int capacity = TwinPrimeGenerator.generateTwinPrime(95500,96000);

        if(args.length < 2 || args.length > 3) {
            System.out.println("Command line arguements are incorrect. Use as shown below.");
            System.out.println("java HashtableTest <dataType> <loadFactor> [<debugLevel>]");
            System.exit(1);
        } else if(args.length == 3) {
            dataType = Integer.parseInt(args[0]);
            loadFactor = Double.parseDouble(args[1]);
            debugLevel = Integer.parseInt(args[2]);
        } else {
            dataType = Integer.parseInt(args[0]);
            loadFactor = Double.parseDouble(args[1]);
            debugLevel = 0;
        }
        
        // Create the linear and double hash tables
        LinearProbing linearProbe = new LinearProbing(capacity, loadFactor);
        DoubleHashing doubleHash = new DoubleHashing(capacity, loadFactor);

        // Populates the linear and double hash tables with integer HashObjects
        if(dataType == 1) {
            Random rand = new Random(123);
            int random;
            while(linearProbe.loadFactor() < loadFactor) {
                random = rand.nextInt();
                HashObject obj = new HashObject(random);
                int linear = linearProbe.insert(obj);
                int dble = doubleHash.insert(obj);
                if(debugLevel == 2) {
                    if(linear == 1) {
                        System.out.println(obj.toString() + "  Linear Probe Successful!");
                    }
                    if(linear == -1) {
                        System.out.println(obj.toString() + "  Linear Probe Duplicate!");
                    }
                    if(dble == 1) {
                        System.out.println(obj.toString() + "   Double Hash Successful! No Duplicate.");
                    }
                    if(dble == -1) {
                        System.out.println(obj.toString() + "   Double Hash Duplicate!");
                    }
                }
            }
            data = "Integer";
        }

        // Populates the linear and double hash tables with date HashObjects
        if(dataType == 2) {
            long current = new Date().getTime();
            while(linearProbe.loadFactor() < loadFactor) {
                Date date = new Date(current);
                HashObject obj = new HashObject(date);
                int linear = linearProbe.insert(obj);
                int dble = doubleHash.insert(obj);
                current += 1000;
                if(debugLevel == 2) {
                    if(linear == 1) {
                        System.out.println(obj.toString() + "  Linear Probe Successful!");
                    }
                    if(linear == -1) {
                        System.out.println(obj.toString() + "  Linear Probe Duplicate!");
                    }
                    if(dble == 1) {
                        System.out.println(obj.toString() + "   Double Hash Successful! No Duplicate.");
                    }
                    if(dble == -1) {
                        System.out.println(obj.toString() + "   Double Hash Duplicate!");
                    }
                }
            }
            data = "Date";
        }

        // Populates the linear and double hash tables with string HashObjects
        if(dataType == 3) {
            File file = new File("word-list.txt");
            Scanner scan = new Scanner(file);
            while(linearProbe.loadFactor() < loadFactor) {
                if(scan.hasNextLine()) {
                    String word = scan.nextLine();
                    HashObject obj1 = new HashObject(word);
                    HashObject obj2 = new HashObject(word);
                    int linear = linearProbe.insert(obj1);
                    int dble = doubleHash.insert(obj2);
                    if(debugLevel == 2) {
                        if(linear == 1) {
                            System.out.println(obj1.toString() + "  Linear Probe Successful!");
                        }
                        if(linear == -1) {
                            System.out.println(obj1.toString() + "  Linear Probe Duplicate!");
                        }
                        if(dble == 1) {
                            System.out.println(obj2.toString() + "  Double Hash Successful!");
                        }
                        if(dble == -1) {
                            System.out.println(obj2.toString() + "  Double Hash Successful!");
                        }
                    }
                }
            }
            scan.close();
            data = "Word-List";
        }

        // Print Debug Level 0
        if(debugLevel == 0) {
            DecimalFormat dec = new DecimalFormat("0.00");
            System.out.println("HashtableTest: Found a twin prime for table capacity: " + capacity);
            System.out.println("HashtableTest: Input: " + data + "    LoadFactor: " + loadFactor);
            System.out.println("    Using Linear Probing");
            System.out.println("HashtableTest: size of hash table is " + linearProbe.size);
            System.out.println("    Inserted " + (linearProbe.size + linearProbe.getDuplicates()) + " elements, of which " + linearProbe.getDuplicates() + " were duplicates");
            System.out.println("    Avg. no. of probes = " + dec.format(linearProbe.avgProbes()));
            System.out.println("");
            System.out.println("    Using Double Hashing");
            System.out.println("HastableTest: size of hash table is " + doubleHash.size);
            System.out.println("    Inserted " + (doubleHash.size + doubleHash.getDuplicates()) + " elements, of which " + doubleHash.getDuplicates() + " were duplicates");
            System.out.println("    Avg. no. of probes = " + dec.format(doubleHash.avgProbes()));
            System.out.println("");
        }

        // Print Debug Level 1
        if(debugLevel == 1) {
            DecimalFormat dec = new DecimalFormat("0.00");
            System.out.println("HashtableTest: Found a twin prime for table capacity: " + capacity);
            System.out.println("HashtableTest: Input: " + data + "    LoadFactor: " + loadFactor);
            System.out.println("        Using Linear Probing");
            System.out.println("HashtableTest: size of hash table is " + linearProbe.size);
            System.out.println("        Inserted " + linearProbe.size + linearProbe.getDuplicates() + " elements, of which " + linearProbe.getDuplicates() + " were duplicates");
            System.out.println("        Avg. no. of probes = " + dec.format(linearProbe.avgProbes()));
            linearProbe.dumpToFile("linear-dump.txt");
            System.out.println("HashtableTest: Saved dump of hash table");
            System.out.println("");
            System.out.println("        Using Double Hashing");
            System.out.println("HastableTest: size of hash table is " + doubleHash.size);
            System.out.println("       Inserted " + doubleHash.size + doubleHash.getDuplicates() + " elements, of which " + doubleHash.getDuplicates() + " were duplicates");
            System.out.println("        Avg. no. of probes = " + dec.format(doubleHash.avgProbes()));
            doubleHash.dumpToFile("double-dump.txt");
            System.out.println("HashtableTest: Saved dump of hash table");
            System.out.println("");
        }
    }
}
