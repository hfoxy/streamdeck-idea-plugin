package me.hfox.idea.streamdeck.listeners;

import com.intellij.execution.RunManager;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import me.hfox.idea.streamdeck.services.RunConfigurationService;
import org.jetbrains.annotations.NotNull;

public class ProjectOpenCloseListener implements ProjectManagerListener {

    @Override
    public void projectOpened(@NotNull Project project) {
        if (ApplicationManager.getApplication().isUnitTestMode()) {
            return;
        }

        RunConfigurationService service = ApplicationManager.getApplication().getService(RunConfigurationService.class);
        RunManager.getInstance(project).getAllSettings().forEach(service::add);
    }

    @Override
    public void projectClosed(@NotNull Project project) {
        if (ApplicationManager.getApplication().isUnitTestMode()) {
            return;
        }

        RunConfigurationService service = ApplicationManager.getApplication().getService(RunConfigurationService.class);
        RunManager.getInstance(project).getAllSettings().forEach(service::add);
    }

}
