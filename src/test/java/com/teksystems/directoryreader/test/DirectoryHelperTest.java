/**
 * 
 */
package com.teksystems.directoryreader.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.teksystems.directoryreader.exception.DirectoryException;
import com.teksystems.directoryreader.helper.DirectoryHelper;

/**
 * @author rpcha
 *
 */
public class DirectoryHelperTest {

	/**
	 * @throws java.lang.Exception
	 */

	DirectoryHelper helper = new DirectoryHelper();


	@Rule
	public TemporaryFolder folder= new TemporaryFolder();

	@Before
	public void setUp() throws Exception {}

	@Test
	public void testSortFilesByExtension() throws DirectoryException {
		String[] listOfFileNames = { "Excel 1.xlsx", "Word 2.docx","Excel 2.xlsx","PPT1.pptx" };
		String[] expected = {"Word 2.docx", "PPT1.pptx", "Excel 1.xlsx", "Excel 2.xlsx"};
		assertEquals(Arrays.asList(expected), helper.sortFilesByExtensions(listOfFileNames));
	}

}
