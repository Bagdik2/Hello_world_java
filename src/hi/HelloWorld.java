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
		
		private String[] keywords;
		
		public SpamAnalyzer (String[] keywords) {
			
			this.keywords = keywords;
		}
		
		@Override
		public Label processText(String text) {
			
			String lowerText = text.toLowerCase();
			
			for (String keyword : keywords) {
				if (lowerText.contains(keyword.toLowerCase())) {
					return Label.SPAM;
				}
			}
			
			return Label.OK;
		}
	}
	
	class NegativeTextAnalyzer implements TextAnalyzer {
		
		private static final String NEGATIVE_SMILE = ":(";
		
		public NegativeTextAnalyzer() {
			
		}
		
		@Override
		public Label processText(String text) {
			if (text.contains(NEGATIVE_SMILE)) {
				return Label.NEGATIVE_TEXT;
			}
			
			return Label.OK;
		}
	}
	
	class TooLongTextAnalyzer implements TextAnalyzer {
		
	}
	
	Label[] analyzeText(TextAnalyzer[] analyzers, String text) {
		
	}

}
