package os.resourceallocation.deadlock;

import java.util.HashSet;
import java.util.Set;

import os.resourceallocation.Process;
import os.resourceallocation.Resource;

public class ResourceAllocationGraph {
    private Set<Process> processes;
    private Set<Resource> resources;

    public ResourceAllocationGraph() {
        processes = new HashSet<>();
        resources = new HashSet<>();
    }

    public void addProcess(Process process) {
        processes.add(process);
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void printGraph() {
        for (Resource resource : resources) {
            System.out.println(resource.getName() + " -> " + resource.getAllocatedProcess().getName());
        }
    }

    public static void main(String[] args) {
        ResourceAllocationGraph graph = new ResourceAllocationGraph();

        Process p1 = new Process("p1");
        Process p2 = new Process("p2");
        Process p3 = new Process("p3");

        Resource r1 = new Resource("r1", 1, p1);
        Resource r2 = new Resource("r2", 1, p2);
        Resource r3 = new Resource("r3", 2, p3);

        graph.addProcess(p1);
        graph.addProcess(p2);
        graph.addProcess(p3);

        graph.addResource(r1);
        graph.addResource(r2);
        graph.addResource(r3);

        graph.printGraph();
    }
}
