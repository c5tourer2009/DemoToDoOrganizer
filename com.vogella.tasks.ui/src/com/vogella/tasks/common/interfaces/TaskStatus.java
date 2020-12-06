package com.vogella.tasks.common.interfaces;

public enum TaskStatus {
	
	NOT_DONE(0,"Not Done"), IN_PROGRESS(1, "In Progress"), BLOCKED(2, "Blocked"), DONE(3, "Done");
	
	private String displayText;
	private final int value;
	
	private TaskStatus(int value, String displayText) {
		this.value = value;
		this.displayText = displayText;
	}
	
	/**
	 * Returns the display text of the given enumeration
	 * 
	 * @return
	 */
	public String getDisplayText() {
		return displayText;
	}
	
	/**
	 * Returns the integer value of the given enumeration
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Creates the {@link TaskStatus} from the given value.
	 * @param value - 
	 * @return {@link TaskStatus}
	 * @throws IllegalArgumentException in case that given value is not valid 
	 */
	public static TaskStatus fromValue(int value) {
		switch (value)
		{
			case 0:
				return NOT_DONE;
			case 1:
				return IN_PROGRESS;
			case 2:
				return BLOCKED;
			case 3:
				return DONE;
		
			default:
				throw new IllegalArgumentException("Unknown value: " + value);
		}
	}
}
