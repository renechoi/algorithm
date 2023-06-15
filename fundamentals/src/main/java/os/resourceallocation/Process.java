package os.resourceallocation;
import java.util.HashMap;
import java.util.Map;

public class Process {

    private String name;
    private Map<Resource, Integer> maxDemand;
    private Map<Resource, Integer> allocatedResources;
    private Map<Resource, Integer> remainingDemand;

    public Process(String name) {
        this.name = name;
        this.maxDemand = new HashMap<>();
        this.allocatedResources = new HashMap<>();
        this.remainingDemand = new HashMap<>();
    }

    // 최대 요구량 설정
    public void setMaxDemand(Resource resource, int maxUnits) {
        maxDemand.put(resource, maxUnits);
    }

    // 현재 할당 자원 설정
    public void allocateResource(Resource resource, int units) {
        int currentAllocation = allocatedResources.getOrDefault(resource, 0);
        allocatedResources.put(resource, currentAllocation + units);
    }

    // 할당 해제
    public void deallocateResource(Resource resource, int units) {
        int currentAllocation = allocatedResources.getOrDefault(resource, 0);
        int newAllocation = Math.max(currentAllocation - units, 0);
        if (newAllocation == 0) {
            allocatedResources.remove(resource);
        } else {
            allocatedResources.put(resource, newAllocation);
        }
    }

    public void setRemainingDemand(Resource resource, int remainingUnits) {
        remainingDemand.put(resource, remainingUnits);
    }

    public String getName() {
        return name;
    }

    public int getMaxDemand(Resource resource) {
        return maxDemand.getOrDefault(resource, 0);
    }

    public int getAllocatedResource(Resource resource) {
        return allocatedResources.getOrDefault(resource, 0);
    }

    public int getRemainingDemand(Resource resource) {
        return remainingDemand.getOrDefault(resource, 0);
    }

    @Override
    public String toString() {
        return name;
    }
}
