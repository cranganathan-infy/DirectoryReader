package com.teksystems.directoryreader.helper;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

import com.teksystems.directoryreader.exception.DirectoryException;

public class DirectoryHelper {
	
	
	/**
	 * This methods sort the list of files by extension
	 *
	 * @param listOfFileNames
	 * @return
	 */
	public List<String> sortFilesByExtensions(String[] listOfFileNames) throws DirectoryException{
		List<String> orginalList = new CopyOnWriteArrayList<>(Arrays.asList(listOfFileNames));
		Set<String> setOfuniqueExtension = new TreeSet<>();

		for (String item : listOfFileNames) {
			if (item.contains(".")) {
				String[] split = item.split(HelperContstants.DELIMETER);
				String temp = "." + split[split.length - 1];
				setOfuniqueExtension.add(temp);
			}
		}

		List<String> finalListOfAllFiles = new LinkedList<>();
		setOfuniqueExtension.stream().forEach((s1) -> {
			for (int i = 0; i < orginalList.size(); i++) {
				if (orginalList.get(i).contains(s1)) {
					finalListOfAllFiles.add(orginalList.get(i));
					orginalList.remove(orginalList.get(i));
					i--;
				}
			}
		});

		orginalList.stream().filter((s1) -> (!finalListOfAllFiles.contains(s1))).forEach((s1) -> {
			finalListOfAllFiles.add(s1);
		});

		return finalListOfAllFiles;
	}
	
	
	/**
	 * This method prints directory and files on console
	 *
	 * @param file
	 * @param tabs
	 */
	public void printFileOnconsole(File file, int tabs,int lenghtOfDirectory) throws DirectoryException{
		System.out.println("file ->" + file);
		String fileName = file.getName();
		String[] split = fileName.split(HelperContstants.DELIMETER);
		for (int i = 0; i < tabs; i++) {
			System.out.print("  ");
		}
		System.out.println("- Document: " + file.getName() + " - Extension: ." + split[split.length - 1] + " - URL: "
				+ file.getAbsolutePath().substring(lenghtOfDirectory));
	}



}
