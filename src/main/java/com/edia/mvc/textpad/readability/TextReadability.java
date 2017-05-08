package com.edia.mvc.textpad.readability;

import com.edia.mvc.textpad.readability.StringAnalyzer.Stats;


/**
 * Returns the Fog index.
 * 
 * <p>
 * The Fog Index is a readability test designed to show how easy or
 * difficult a text is to read. It uses the following formula: Reading Level
 * (Grade) = (Average No. of words in sentences + Percentage of words of
 * three or more syllables) x 0.4. The resulting number is your Gunning Fog
 * Index.
 * </p>
 * 
 */

public final class TextReadability {
	private TextReadability() {
	}

	public static float calcFog(final Stats stats) {
		return (wordsPerSentence(stats) + percentComplexWords(stats)) * 0.4f;
	}

	public static float wordsPerSentence(final Stats stats) {
		return ((float) stats.getNumWords()) / stats.getNumSentences();
	}

	public static float percentComplexWords(final Stats stats) {
		return (((float) stats.getNumComplexWords()) / stats.getNumWords()) * 100;
	}
}
