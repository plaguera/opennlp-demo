package org.fogbeam.example.opennlp.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

/**
 * Tokenizer Tests
 * @author pedro
 */
public class TokenizerTest {
	
	// NLP Model
	static TokenizerModel model;
	// Tokenizer Object
	static Tokenizer tokenizer;

	/**
	 * Set up our NLP model and Tokenizer Object Testing
	 * @throws Exception May throw Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		model = new TokenizerModel(new FileInputStream("models/en-token.model"));
		tokenizer = new TokenizerME(model);
	}
	
	/**
	 * Test "A ranger journeying"
	 * @throws InvalidFormatException May throw InvalidFormatException
	 * @throws IOException May throw IOException
	 */
	@Test
	public void test1() throws InvalidFormatException, IOException {
		String[] tokens = tokenizer.tokenize("A ranger journeying");
		assertEquals(3, tokens.length);
		assertEquals("A", tokens[0]);
		assertEquals("ranger", tokens[1]);
		assertEquals("journeying", tokens[2]);
	}
	
	/**
	 * Test "Great Kings who were killed in the Wars."
	 * @throws InvalidFormatException May throw InvalidFormatException
	 * @throws IOException May throw IOException
	 */
	@Test
	public void test2() throws InvalidFormatException, IOException {
		String[] tokens = tokenizer.tokenize("Great Kings who were killed in the Wars.");
		assertEquals(9, tokens.length);
		assertEquals("Great", tokens[0]);
		assertEquals("Kings", tokens[1]);
		assertEquals("who", tokens[2]);
		assertEquals("were", tokens[3]);
		assertEquals("killed", tokens[4]);
		assertEquals("in", tokens[5]);
		assertEquals("the", tokens[6]);
		assertEquals("Wars", tokens[7]);
		assertEquals(".", tokens[8]);
	}
	
	/**
	 * Test "Oglethorpe, founder of the Georgia Colony"
	 * @throws InvalidFormatException May throw InvalidFormatException
	 * @throws IOException May throw IOException
	 */
	@Test
	public void test3() throws InvalidFormatException, IOException {
		String[] tokens = tokenizer.tokenize("Oglethorpe, founder of the Georgia Colony");
		assertEquals(7, tokens.length);
		assertEquals("Oglethorpe", tokens[0]);
		assertEquals(",", tokens[1]);
		assertEquals("founder", tokens[2]);
		assertEquals("of", tokens[3]);
		assertEquals("the", tokens[4]);
		assertEquals("Georgia", tokens[5]);
		assertEquals("Colony", tokens[6]);
	}

}
