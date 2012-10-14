package view.application;

public class Event {
	private final String name;
	private final Object data;

	public Event(String name, Object data) {
		super();
		this.name = name;
		this.data = data;
	}

	public Object getData() {
		return this.data;
	}

	public String getName() {
		return this.name;
	}
}
