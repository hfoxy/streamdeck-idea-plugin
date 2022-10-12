package me.hfox.idea.streamdeck.services;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;

public class ProjectService {

    public Project getProject(String name) {
        Project[] openProjects = ProjectManager.getInstance().getOpenProjects();
        for (Project project : openProjects) {
            if (project.getName().equalsIgnoreCase(name)) {
                return project;
            }
        }

        throw new IllegalArgumentException("Unknown project: " + name);
    }

}
