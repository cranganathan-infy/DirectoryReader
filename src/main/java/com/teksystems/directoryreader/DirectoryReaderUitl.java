package com.teksystems.directoryreader;

import java.io.File;

import com.teksystems.directoryreader.exception.DirectoryException;
import com.teksystems.directoryreader.impl.DirectoryReader;

/**
 * The purpose of this utility is to read and print all the file names under
 * parent directory and all it's subdirectories recursively. The project is
 * working code based on Maven and Java 8. The candidates are supposed to
 * re-factor this utility using good OO principles e.g. Single responsibility
 * principle, interface segregation and code readability. Besides this proper
 * exception handling should also be implemented when make sense. All the code
 * should be and must be backed by unit testing. Note: the code can be imported
 * and run in any ide, but when candidates submit the code, they are supposed to
 * take all the ide specific code out and submit the project as a zip file with
 * candidate first name and last name as the file name. To run: mvn package and
 * then mvn exec:java
 *
 * @author rjilani
 */
public class DirectoryReaderUitl {

	/**
	 * Main driver and entry point
	 *
	 * @param args
	 * @throws DirectoryException 
	 */
	public static void main(String[] args) throws DirectoryException {
		try {
			File rootDirectory = new File("./testdirectory/Main Project");
			int directoryFileLength = rootDirectory.getAbsolutePath().length() - rootDirectory.getName().length();
			IDirectoryReader directoryReaderUitl = new DirectoryReader(directoryFileLength);
			directoryReaderUitl.listAllFilesRecursively(rootDirectory, 0);
		}catch(DirectoryException e) {
			throw new DirectoryException("An exception occured while reading directory" + e.getMessage());
		}
	}

}
