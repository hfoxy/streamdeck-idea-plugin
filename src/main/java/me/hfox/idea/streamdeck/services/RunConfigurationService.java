package me.hfox.idea.streamdeck.services;

import com.intellij.execution.ExecutionManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.runners.ExecutionEnvironmentBuilder;
import com.intellij.openapi.project.Project;

import java.util.HashMap;
import java.util.Map;

public class RunConfigurationService {

    private Map<String, RunnerAndConfigurationSettings> activeConfigurations = new HashMap<>();

    public Map<String, RunnerAndConfigurationSettings> getActiveConfigurations() {
        return activeConfigurations;
    }

    public void add(RunnerAndConfigurationSettings settings) {
        activeConfigurations.put(settings.getUniqueID(), settings);
        // Messages.showInfoMessage("Run configuration added", String.format("Added %s (%s)", settings.getUniqueID(), settings.getName()));
    }

    public void update(RunnerAndConfigurationSettings settings, String existingId) {
        activeConfigurations.remove(existingId);
        activeConfigurations.put(settings.getUniqueID(), settings);
        // Messages.showInfoMessage("Run configuration updated", String.format("Updated %s (%s)", settings.getUniqueID(), settings.getName()));
    }

    public void remove(RunnerAndConfigurationSettings settings) {
        activeConfigurations.remove(settings.getUniqueID());
        // Messages.showInfoMessage("Run configuration removed", String.format("Removed %s (%s)", settings.getUniqueID(), settings.getName()));
    }

    public boolean run(Project project, RunnerAndConfigurationSettings settings) {
        ExecutionEnvironmentBuilder builder = ExecutionEnvironmentBuilder.createOrNull(DefaultRunExecutor.getRunExecutorInstance(), settings);
        if (builder != null) {
            ExecutionManager.getInstance(project).restartRunProfile(builder.build());
            return true;
        }

        return false;
    }

}
