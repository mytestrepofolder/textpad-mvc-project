
package com.edia.mvc.textpad.readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckSyllable {

	private static final Pattern[] SubSyl = new Pattern[] { Pattern.compile("cial"), Pattern.compile("tia"),
			Pattern.compile("cius"), Pattern.compile("cious"), Pattern.compile("giu"), // belgium!
			Pattern.compile("ion"), Pattern.compile("iou"), Pattern.compile("sia$"), Pattern.compile(".ely$"), // absolutely!
	};

	private static final Pattern[] AddSyl = new Pattern[] { Pattern.compile("ia"), Pattern.compile("riet"),
			Pattern.compile("dien"), Pattern.compile("iu"), Pattern.compile("io"), Pattern.compile("ii"),
			Pattern.compile("[aeiouym]bl$"), Pattern.compile("[aeiou]{3}"), Pattern.compile("^mc"),
			Pattern.compile("ism$"), Pattern.compile("([^aeiouy])\1l$"), Pattern.compile("[^l]lien"),
			Pattern.compile("^coa[dglx]."), Pattern.compile("[^gq]ua[^auieo]"), Pattern.compile("dnt$") };

	/**
	 * @return syllable count for word.
	 */
	public static final int syllable(final String _word) {
		if (_word == null || "".equals(_word)) {
			return 0;
		}

		final String word = _word.toLowerCase().replaceAll("'", "").replaceAll("e$", "");

		if (word.length() == 1) {
			return 1;
		}

		final String[] scrugg = word.split("[^aeiouy]+");

		int syl = 0;

		for (final Pattern p : SubSyl) {
			final Matcher m = p.matcher(word);

			if (m.find()) {
				syl--;
			}
		}

		for (final Pattern p : AddSyl) {
			final Matcher m = p.matcher(word);

			if (m.find()) {
				syl++;
			}
		}

		if (scrugg.length > 0 && "".equals(scrugg[0])) {
			syl += scrugg.length - 1;
		} else {
			syl += scrugg.length;
		}

		if (syl == 0) {
			syl = 1;
		}

		return syl;
	}
}
