public class Processo implements Comparable<Processo> {
    private int pid;
    private int arrivalTime;
    private int burstTime;
    private int priority;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Processo(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    @Override
    public int compareTo(Processo otherProcess) {
        return Integer.compare(this.arrivalTime, otherProcess.arrivalTime);
    }

    public int compareToPriority(Processo otherProcess) {
        return Integer.compare(this.priority, otherProcess.priority);
    }

    @Override
    public String toString() {
        return "PID: " + pid + ", Arrival Time: "+ arrivalTime + ", Burst Time: "+ burstTime + ", Priority: " + priority;
    }
}


