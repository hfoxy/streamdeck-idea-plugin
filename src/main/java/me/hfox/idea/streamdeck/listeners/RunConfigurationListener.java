package me.hfox.idea.streamdeck.listeners;

import com.intellij.execution.RunManagerListener;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.openapi.application.ApplicationManager;
import me.hfox.idea.streamdeck.services.RunConfigurationService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RunConfigurationListener implements RunManagerListener {

    @Override
    public void runConfigurationAdded(@NotNull RunnerAndConfigurationSettings settings) {
        RunConfigurationService service = ApplicationManager.getApplication().getService(RunConfigurationService.class);
        service.add(settings);
    }

    @Override
    public void runConfigurationRemoved(@NotNull RunnerAndConfigurationSettings settings) {
        RunConfigurationService service = ApplicationManager.getApplication().getService(RunConfigurationService.class);
        service.remove(settings);
    }

    @Override
    public void runConfigurationChanged(@NotNull RunnerAndConfigurationSettings settings, @Nullable String existingId) {
        RunConfigurationService service = ApplicationManager.getApplication().getService(RunConfigurationService.class);
        service.update(settings, existingId);
    }

    @Override
    public void runConfigurationChanged(@NotNull RunnerAndConfigurationSettings settings) {
        RunConfigurationService service = ApplicationManager.getApplication().getService(RunConfigurationService.class);
        service.update(settings, settings.getUniqueID());
    }

}
