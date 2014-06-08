package domain.exceptions;

import java.io.File;

public class FileExistException extends InvalidException {
    
    public FileExistException(File file) {
        super("\"" + file.getName() + "\" already exists!" );
    }
}
