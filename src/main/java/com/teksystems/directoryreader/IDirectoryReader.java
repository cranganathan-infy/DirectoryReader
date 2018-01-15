package com.teksystems.directoryreader;

import java.io.File;

import com.teksystems.directoryreader.exception.DirectoryException;

public interface IDirectoryReader {
	
	public void listAllFilesRecursively(File dir, int tabs) throws DirectoryException;
	
}
