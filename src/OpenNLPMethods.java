import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;


public class OpenNLPMethods {
	
	
	public static String[] findPersonName(String[] sentence) throws IOException {
		InputStream is = new FileInputStream("en-ner-person.bin");
	 
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
	 
		NameFinderME nameFinder = new NameFinderME(model);
	 
		/*String []sentence = new String[]{
			    "Mike",
			    "Smith",
			    "is",
			    "a",
			    "good",
			    "man"
			    };
		*/
		System.out.println("Before Processing: ");
		for(int i=0;i<sentence.length;i++){
		System.out.println(sentence[i]);
		}
	 
			Span nameSpans[] = nameFinder.find(sentence);
	 
			System.out.println("============================");
			System.out.println("After Processing: ");
			String names[] = null;
			int i=0;
			for(Span s: nameSpans)
			{
				names[i]=s.toString();
				System.out.println(s.toString());
				i++;
			}
			return names;
			
	}
	public static String[] Tokenize(String sentence) throws InvalidFormatException, IOException {
		InputStream is = new FileInputStream("en-token.bin");
	 
		TokenizerModel model = new TokenizerModel(is);
	 
		Tokenizer tokenizer = new TokenizerME(model);
	 
		//String sentence = "Hi. How are you? This is Mike.";
		
		String tokens[] = tokenizer.tokenize(sentence);
		
		System.out.println("Before Processing: ");
		System.out.println(sentence);
		
		System.out.println("============================");
		System.out.println("After Processing: ");
		
		for (String a : tokens)
			System.out.println(a);
	 
		is.close();
		return tokens;
	}
}
