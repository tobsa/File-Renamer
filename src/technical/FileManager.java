package technical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {
    
    public static void save(String filename, Object object) throws FileNotFoundException, IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(object);
        output.close();
    }
    
    public static Object load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        Object object = input.readObject();
        input.close();
        return object;        
    }
    
    public static boolean fileExist(String filename) {
        return new File(filename).exists();
    }
    
    public static boolean isDirectory(String filename) {
        return new File(filename).isDirectory();
    }
    
}
