package ed.lab;

public record MeetingInterval(int startTime, int endTime) {
    @Override
    public String toString() {
        return String.format("[%d-%d]", startTime, endTime);
    }
}
