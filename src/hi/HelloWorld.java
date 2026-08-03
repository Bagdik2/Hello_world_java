package hi;

import java.util.Iterator;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		String[] textus = {
				"Корабли лавировали, лавировали...",
				"Блин, ну ничего не выловировали :( ,,,;(",
				"Пирожки, покупай пока горячие!",
				"Грустно. Но грустить не очем, веселимся!"
		};
		String[] spamKeywords = {
				"Лавировали", "Заработай", "Купи", "Продай", "Покупай"
 		};
		
		TextAnalyzer spam = new SpamAnalyzer(spamKeywords);
		TextAnalyzer negat = new NegativeTextAnalyzer();
		TextAnalyzer lengthMax = new TooLongTextAnalyzer(32);
		
		TextAnalyzer[] analyzers = {
				spam,
				negat,
				lengthMax
		};
		
		for (String text : textus) {
			
			System.out.println("\nТекст: \"" + text + "\"");
			System.out.println("Длина: " + text.length() + " символов");
			
			Label[] results = analyzeText(analyzers, text);
			
            System.out.println("Результаты проверок:");
            System.out.println("  Спам: " + results[0]);
            System.out.println("  Негатив: " + results[1]);
            System.out.println("  Длина: " + results[2]);
		}
		
//		for (int i = 0; i < textus.length; i++) {
//			System.out.println("Текст " + i + ":");
//			System.out.println("SpamAnalyzer:");
//			System.out.println(spam.processText(textus[i]).toString());
//			System.out.println("NegativeTextAnalyzer:");
//			System.out.println(negat.processText(textus[i]).toString());
//		}

	}
	
	interface TextAnalyzer {
		Label processText(String text);
	}
	
	enum Label {
		SPAM, NEGATIVE_TEXT, TOO_LONG, OK
	}
	
	static class SpamAnalyzer implements TextAnalyzer {
		
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
	
	static class NegativeTextAnalyzer implements TextAnalyzer {
		
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
	
	static class TooLongTextAnalyzer implements TextAnalyzer {
		
		private int maxLength;
		
		public TooLongTextAnalyzer(int maxLength) {
			this.maxLength = maxLength;
		}
		
		@Override
		public Label processText(String text) {
			if (text.length() > maxLength) {
				return Label.TOO_LONG;
			}
			
			return Label.OK;
		}
	}
	
	public static Label[] analyzeText(TextAnalyzer[] analyzers, String text) {
		
		Label[] results = new Label[analyzers.length];
		
		for (int i = 0; i < analyzers.length; i++) {
			results[i] = analyzers[i].processText(text);
		}
		return results;
	}

}
