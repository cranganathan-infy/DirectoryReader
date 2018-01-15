package com.teksystems.directoryreader.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.directoryreader.IDirectoryReader;
import com.teksystems.directoryreader.exception.DirectoryException;
import com.teksystems.directoryreader.impl.DirectoryReader;

public class DirectoryReaderUitlTest {

	File rootDirectory;
	int directoryFileLength;
	@Before
	public void setUp() throws Exception {
		rootDirectory = new File("./testdirectory/Main Project");
		directoryFileLength = rootDirectory.getAbsolutePath().length() - rootDirectory.getName().length();

	}

	@Test
	public void testDirectoryUtilSuccess() throws DirectoryException {
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream stdout = new PrintStream(os);
		System.setOut(stdout);


		IDirectoryReader directoryReaderUitl = new DirectoryReader(directoryFileLength);
		directoryReaderUitl.listAllFilesRecursively(rootDirectory, 0);

		String expected="- Project: Main Project - URL: Main Project\r\n" + 
				"  - Project: Project 1 - URL: Main Project\\Project 1\r\n" + 
				"    - Document: WordFile1.docx - Extension: .docx - URL: Main Project\\Project 1\\WordFile1.docx\r\n" + 
				"    - Document: ExcelFile1.xlsx - Extension: .xlsx - URL: Main Project\\Project 1\\ExcelFile1.xlsx\r\n" + 
				"    - Project: Project A - URL: Main Project\\Project 1\\Project A\r\n" + 
				"      - Document: PPTFile1.pptx - Extension: .pptx - URL: Main Project\\Project 1\\Project A\\PPTFile1.pptx\r\n" + 
				"  - Project: Project 2 - URL: Main Project\\Project 2\r\n" + 
				"    - Document: WordFile2.docx - Extension: .docx - URL: Main Project\\Project 2\\WordFile2.docx\r\n" + 
				"    - Document: ExcelFile2.xlsx - Extension: .xlsx - URL: Main Project\\Project 2\\ExcelFile2.xlsx";
		assertEquals(expected,os.toString().trim());

	}
	
	@Test(expected = DirectoryException.class)
	public void testDirectoryUtilException() throws DirectoryException {
		rootDirectory = new File("./test");
		IDirectoryReader directoryReaderUitl = new DirectoryReader(directoryFileLength);
		directoryReaderUitl.listAllFilesRecursively(rootDirectory, 0);
	}


}
