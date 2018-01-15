/**
 * 
 */
package com.teksystems.directoryreader.impl;

import java.io.File;
import java.util.List;

import com.teksystems.directoryreader.IDirectoryReader;
import com.teksystems.directoryreader.exception.DirectoryException;
import com.teksystems.directoryreader.helper.DirectoryHelper;

/**
 * @author rpcha
 *
 */
public class DirectoryReader implements IDirectoryReader {

	int lenghtOfDirectory;
	DirectoryHelper helper = new DirectoryHelper();
	public DirectoryReader(int lenghtOfDirectory) {
		this.lenghtOfDirectory = lenghtOfDirectory;
	}


	/**
	 * This methods list and print all files recursively
	 *
	 * @param dir
	 * @param tabs
	 * @throws DirectoryException 
	 */
	public void listAllFilesRecursively(File dir, int tabs) throws DirectoryException {
			if (dir != null) {
				if (dir.isDirectory()) {
					for (int i = 0; i < tabs; i++) {
						System.out.print("  ");
					}
					System.out.println("- Project: " + dir.getName() + " - URL: "
							+ dir.getAbsolutePath().substring(lenghtOfDirectory));
					String listOfFileNames[] = dir.list();
					// sortedList = sort(s);
					List<String> sortedListOfFiles = helper.sortFilesByExtensions(listOfFileNames);
					iterateListOfFiles(sortedListOfFiles, tabs, dir);
				} else {
					System.out.println("Please provide a path to root directory");
					throw new DirectoryException("Please provide a path to root directory");
				}
			}
		}

	/**
	 * Iterate directory and sub directory
	 *
	 * @param sortedListOfFiles
	 * @param tabs
	 * @param dir
	 */
	private void iterateListOfFiles(List<String> sortedListOfFiles, int tabs, File dir)  throws  DirectoryException{
		try {
			for (String item : sortedListOfFiles) {
				tabs++;
				File file = new File(dir + "/" + item);
				if (file.isDirectory()) {
					listAllFilesRecursively(file, tabs);
					tabs--;
				} else {
					helper.printFileOnconsole(file, tabs,lenghtOfDirectory);
					tabs--;
				}
			}
		}catch(Exception e) {
			throw new DirectoryException("Exception occured while iterating over list of files "+ e.getMessage());
		}

	}

}
