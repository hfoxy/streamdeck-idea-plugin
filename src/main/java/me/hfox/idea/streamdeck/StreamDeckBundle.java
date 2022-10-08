package me.hfox.idea.streamdeck;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.PropertyKey;

import static me.hfox.idea.streamdeck.utils.Constants.BUNDLE;

public class StreamDeckBundle extends DynamicBundle {

    public static final StreamDeckBundle INSTANCE = new StreamDeckBundle();

    public StreamDeckBundle() {
        super(BUNDLE);
    }

    @SuppressWarnings("SpreadOperator")
    public static void message(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
        INSTANCE.getMessage(key, params);
    }

    @SuppressWarnings({"SpreadOperator", "unused"})
    public static void messagePointer(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
        INSTANCE.getLazyMessage(key, params);
    }

}
