package org.example.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class DAOUsageExample {
    public static void main(String[] args) {

        ProjectService projectService = new ProjectService(new ProjectDAODB());

        int randID = (new Random()).nextInt(99);
        Project project = new Project("Project #" + randID, new Date());
        projectService.persist(project);

        List<Project> projects = projectService.findAll();
        projects.stream().forEach(p -> System.out.println(p));

        Project projectFromDB = projectService.findById(projects.get(0).getId());
        System.out.println("\nProject from DB:" + projectFromDB);

        projectService.delete(projectFromDB);
        System.out.println("Project id: " + projectFromDB.getId() + " deleted");

        System.out.println("\nProjects list after delete:");
        projects =projectService.findAll();
        projects.stream().forEach(p -> System.out.println(p));
    }
}
