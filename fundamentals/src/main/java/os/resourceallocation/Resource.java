package os.resourceallocation;

public class Resource {
    private String name;
    private int availableUnits;
    private Process allocatedProcess;

    public Resource(String name, int availableUnits, Process allocatedProcess) {
        this.name = name;
        this.availableUnits = availableUnits;
        this.allocatedProcess = allocatedProcess;
    }

    public String getName() {
        return name;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    public Process getAllocatedProcess() {
        return allocatedProcess;
    }

    public void setAllocatedProcess(Process allocatedProcess) {
        this.allocatedProcess = allocatedProcess;
    }
}
