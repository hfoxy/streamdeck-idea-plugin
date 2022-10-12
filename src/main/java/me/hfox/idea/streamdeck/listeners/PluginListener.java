package me.hfox.idea.streamdeck.listeners;

import com.intellij.ide.plugins.CannotUnloadPluginException;
import com.intellij.ide.plugins.DynamicPluginListener;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import me.hfox.idea.streamdeck.wss.DeckWss;
import org.jetbrains.annotations.NotNull;

import java.net.InetSocketAddress;

public class PluginListener implements DynamicPluginListener {

    private static DeckWss wss;

    @Override
    public void beforePluginUnload(@NotNull IdeaPluginDescriptor pluginDescriptor, boolean isUpdate) {
        try {
            if (wss != null) {
                wss.stop();
            }
        } catch (Exception ex) {
            throw new IllegalThreadStateException("Interrupted while stopping websocket server");
        }
    }

    @Override
    public void pluginLoaded(@NotNull IdeaPluginDescriptor pluginDescriptor) {
        if (wss == null) {
            wss = new DeckWss(new InetSocketAddress("localhost", 9853));
            wss.start();
        }
    }

    @Override
    public void checkUnloadPlugin(@NotNull IdeaPluginDescriptor pluginDescriptor) throws CannotUnloadPluginException {
    }

}
