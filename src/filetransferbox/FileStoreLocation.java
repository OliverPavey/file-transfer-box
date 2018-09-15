package filetransferbox;

import java.io.File;

public class FileStoreLocation {
	
	private final static String DATA_DIRECTORY = "FileTransferBox";
	
	static File getTempFolder() {
        File tempFolder = new File(System.getProperty("java.io.tmpdir"));
        return tempFolder;
	}
	
	public static File getFolder() {
        File tempFolder = getTempFolder();

        File uploadFolder = new File( tempFolder, DATA_DIRECTORY );
        uploadFolder.mkdirs();
        
        return uploadFolder;
	}
}
