package com.teksystems.directoryreader.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.teksystems.directoryreader.IDirectoryReader;
import com.teksystems.directoryreader.exception.DirectoryException;
import com.teksystems.directoryreader.impl.DirectoryReader;

public class DirectoryReaderTest {


	private IDirectoryReader directoryReader;

	@Rule
	public TemporaryFolder folder= new TemporaryFolder();

	@Before
	public void setUp() throws Exception {
		directoryReader = new DirectoryReader(0);
	}

	@Test
	public void testListAllFilesRecursively() throws DirectoryException, IOException{
		File file = folder.newFolder("testdirectory");
		directoryReader.listAllFilesRecursively(file, 0);
		assertTrue(file.exists());	
	}


	@Test(expected = DirectoryException.class)
	public void testListAllFilesRecursivelyException() throws DirectoryException{
		File rootDirectory = new File("");
		directoryReader.listAllFilesRecursively(rootDirectory, 0);
	}

}
