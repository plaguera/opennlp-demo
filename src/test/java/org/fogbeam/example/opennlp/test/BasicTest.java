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

public class BasicTest {
	
	static TokenizerModel model;
	static Tokenizer tokenizer;

	@BeforeClass
	public static void setUp() throws Exception {
		model = new TokenizerModel(new FileInputStream("models/en-token.model"));
		tokenizer = new TokenizerME(model);
	}

	@Test
	public void test() throws InvalidFormatException, IOException {
		String[] tokens = tokenizer.tokenize("A ranger journeying");
		assertEquals("A", tokens[0]);
		assertEquals("ranger", tokens[1]);
		assertEquals("journeying", tokens[2]);
	}

}
