
package org.fogbeam.example.opennlp;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

/**
 * Prueba de Entidad Tokenizer
 * @author Pedro Lagüera
 */
public class TokenizerMain
{
	/**
	 * Main Function
	 * @param args Invocation Arguments
	 * @throws Exception Execution may Throw an Exception
	 */
	public static void main( String[] args ) throws Exception
	{
		
		// the provided model
		// InputStream modelIn = new FileInputStream( "models/en-token.bin" );

		// The model we trained
		InputStream modelIn = new FileInputStream( "models/en-token.model" );
		// The text to tokenize
		String filePath = "eval_data/en-sent.eval";
		
		try
		{
			TokenizerModel model = new TokenizerModel(modelIn);
		
			Tokenizer tokenizer = new TokenizerME(model);
			
			/* note what happens with the "three depending on which model you use */			
			String[] tokens = tokenizer.tokenize(new String(Files.readAllBytes(Paths.get(filePath))));
			
			// If file is empty use given string
			if (tokens.length == 0)
				tokens = tokenizer.tokenize
				(  "A ranger journeying with Oglethorpe, founder of the Georgia Colony, " 
						+ " mentions \"three Mounts raised by the Indians over three of their Great Kings" 
						+ " who were killed in the Wars.\"" );
			
			for( String token : tokens )
				System.out.println( token );
			
		}
		catch( IOException e ) { e.printStackTrace(); }
		finally
		{
			if( modelIn != null )
			{
				try
				{
					modelIn.close();
				}
				catch(IOException e){}
			}
		}
		System.out.println("\n-----\ndone");
	}
}
