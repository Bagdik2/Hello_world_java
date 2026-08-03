package hi;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");

	}
	
	interface TextAnalyzer {
		Label processText(String text);
	}
	
	enum Label {
		SPAM, NEGATIVE_TEXT, TOO_LONG, OK
	}
	
	class SpamAnalyzer implements TextAnalyzer {
		
	}
	
	class NegativeTextAnalyzer implements TextAnalyzer {
		
	}
	
	class TooLongTextAnalyzer implements TextAnalyzer {
		
	}
	
	Label[] analyzeText(TextAnalyzer[] analyzers, String text) {
		
	}

}
