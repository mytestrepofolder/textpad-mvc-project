package com.edia.mvc.textpad.readability;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * TextReadability and general measurements of English text.
 * </p>
 */
public final class StringAnalyzer {
	private static final String[] abbreviations = new String[] {
			// titles
			"Mr", "Mrs", "M", "Dr", "Prof", "Det", "Insp",
			// Other abbreviations
			"Pty", "PLC", "Ltd", "Inc", "etc", "vs", };

	public static Stats analyze(final String s) {
		return analyzeWords(new Stats(), s);
	}

	private static final Pattern WORD_PAT = Pattern.compile("\\b([a-z][-'a-z]*)\\b");
	private static final Pattern VOWELS = Pattern.compile("[aeiouy]");
	private static final Pattern VALID_HYPHENS = Pattern.compile("[a-z]{2,}-[a-z]{2,}");
	private static final Pattern END_SENTENCE = Pattern.compile("\\b\\s*[.!?]\\s*\\b");
	private static final Pattern END_SENTENCE_END_LINE = Pattern.compile("\\b\\s*[.!?]\\s*$");

	private static Stats analyzeWords(final Stats _stats, final String _s) {
		final Stats stats = _stats == null ? new Stats() : _stats;

		String s = _s.toLowerCase().trim();

		Matcher m = WORD_PAT.matcher(s);

		while (m.find()) {
			final String word = m.group(1);

			if (!VOWELS.matcher(word).find()) {
				continue;
			}

			if (word.indexOf('-') > 0 && (!VALID_HYPHENS.matcher(word).matches())) {
				continue;
			}

			stats.addWord(word);

			final int syl = CheckSyllable.syllable(word);

			if (syl > 2 && word.indexOf('-') < 0) {
				stats.numComplexWords++;
			}
		}

		s = replaceAbbr(s);

		s.replaceAll("[\"']", "");

		m = END_SENTENCE.matcher(s);

		while (m.find()) {
			stats.numSentences++;
		}

		m = END_SENTENCE_END_LINE.matcher(s);

		if (m.find()) {
			stats.numSentences++;
		}

		return stats;
	}

	private static final String replaceAbbr(final String s) {
		String ret = s;

		for (final String a : abbreviations) {
			ret = ret.replaceAll("\\s" + a + "\\.\\s", a);
		}

		return ret;
	}

	public static final class Stats {
		private int numWords = 0;
		private int numSentences = 0;
		private final int numTextLines = 0;
		private final int numBlankLines = 0;
		private int numComplexWords = 0;

		private final Map<String, Integer> uniqueWords = new HashMap<String, Integer>();

		private Stats() {
		}

		@Override
		public String toString() {
			return String.format("Stats:[words: %d, sentences: %d, text: %d, blank: %d, syllables: %d, complex: %d]",
					this.numWords, this.numSentences, this.numTextLines, this.numBlankLines, this.numComplexWords);
		}

		private void addWord(final String s) {
			final Integer i = this.uniqueWords.get(s);
			this.uniqueWords.put(s, i == null ? 1 : 1 + i.intValue());
			this.numWords++;
		}

		public int getNumBlankLines() {
			return this.numBlankLines;
		}

		public int getNumSentences() {
			return this.numSentences;
		}

		public int getNumTextLines() {
			return this.numTextLines;
		}

		public int getNumWords() {
			return this.numWords;
		}

		public int getNumComplexWords() {
			return this.numComplexWords;
		}

	}
}
