package idiomas;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class Messages {
	private static final String BUNDLE_NAME = "idiomas/messages"; //$NON-NLS-1$
	private static final Map<Locale, ResourceBundle> BUNDLES = new HashMap<>();
	static {
		charge(new Locale("es", "ES"));
		charge(new Locale("en", "GB"));
		charge(new Locale("eu", "ES"));
	}

	private static void charge(Locale locale) {
		BUNDLES.put(locale, ResourceBundle.getBundle(BUNDLE_NAME, locale));
	}

	public static String getString(String key) {
		try {
			return getString(key, Locale.getDefault());
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static String getString(String key, Locale locale) {
		ResourceBundle bundle = BUNDLES.get(locale);
		Optional<ResourceBundle> opt = Optional.ofNullable(bundle);
		bundle = opt.orElse(BUNDLES.get(new Locale("eu", "ES")));
		Stream<ResourceBundle> flujo = Stream.of(bundle);
		Stream<String> trad = flujo.map(rsc -> rsc.getString(key));
		return trad.findFirst().get();
	}
}
