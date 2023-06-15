package os.resourceallocation;

import java.util.*;

public class ResourceAllocationGraph {
    public static void main(String[] args) {
        // 프로세스 집합 P
        Process p1 = new Process("p1");
        Process p2 = new Process("p2");
        Process p3 = new Process("p3");

        // 자원 집합 R
        Resource r1 = new Resource("r1", 1, p1 );
        Resource r2 = new Resource("r2", 1, p2);
        Resource r3 = new Resource("r3", 2, p3);

        // 요구 간선 집합 Q
        Set<Pair<Process, Resource>> Q = new HashSet<>();
        Q.add(new Pair<>(p1, r2));

        // 할당 간선 집합 S
        Set<Pair<Resource, Process>> S = new HashSet<>();
        S.add(new Pair<>(r1, p1));
        S.add(new Pair<>(r2, p2));
        S.add(new Pair<>(r3, p3));

        // 자원 할당 그래프 출력
        System.out.println("프로세스 집합 P:");
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println(p3.getName());
        System.out.println();

        System.out.println("자원 집합 R:");
        System.out.println(r1.getName() + " (할당 중: " + r1.getAllocatedProcess().getName() + ")");
        System.out.println(r2.getName() + " (할당 중: " + r2.getAllocatedProcess().getName() + ")");
        System.out.println(r3.getName() + " (할당 중: " + r3.getAllocatedProcess().getName() + ")");
        System.out.println();

        System.out.println("요구 간선 집합 Q:");
        for (Pair<Process, Resource> edge : Q) {
            System.out.println(edge.getFirst().getName() + " -> " + edge.getSecond().getName());
        }
        System.out.println();

        System.out.println("할당 간선 집합 S:");
        for (Pair<Resource, Process> edge : S) {
            System.out.println(edge.getFirst().getName() + " -> " + edge.getSecond().getName());
        }
    }


}
