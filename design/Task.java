package design;

public class Task {
	int id, priority, timestamp;
	public Task() {
		id = 0;
		priority = 0;
		timestamp = 0;
	}
	
	public Task(int id, int priority, int timestamp) {
		this.id = id;
		this.priority = priority;
		this.timestamp = timestamp;
	}
}
