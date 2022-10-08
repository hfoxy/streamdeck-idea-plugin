package me.hfox.idea.streamdeck.services;

import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.openapi.ui.Messages;

import java.util.HashSet;
import java.util.Set;

public class RunConfigurationService {

    private Set<RunnerAndConfigurationSettings> activeConfigurations = new HashSet<>();

    public Set<RunnerAndConfigurationSettings> getActiveConfigurations() {
        return activeConfigurations;
    }

    public void add(RunnerAndConfigurationSettings settings) {
        activeConfigurations.add(settings);
        Messages.showInfoMessage("Run configuration added", String.format("Added %s (%s)", settings.getUniqueID(), settings.getName()));
    }

    public void update(RunnerAndConfigurationSettings settings, String existingId) {
        activeConfigurations.add(settings);
        Messages.showInfoMessage("Run configuration updated", String.format("Updated %s (%s)", settings.getUniqueID(), settings.getName()));
    }

    public void remove(RunnerAndConfigurationSettings settings) {
        activeConfigurations.remove(settings);
        Messages.showInfoMessage("Run configuration removed", String.format("Removed %s (%s)", settings.getUniqueID(), settings.getName()));
    }

}
