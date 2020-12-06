package com.vogella.tasks.common.interfaces;

public enum TaskPriority {
	
	LOW(0, "Low"), MEDIUM(1, "Medium"), HIGH(2, "High");
	
	private String displayText;
	private final int value;
	
	private TaskPriority(int value, String displayText) {
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
	 * Creates the {@link TaskPriority} from the given value.
	 * @param value - 
	 * @return {@link TaskPriority}
	 * @throws IllegalArgumentException in case that given value is not valid 
	 */
	public static TaskPriority fromValue(int value) {
		switch (value)
		{
			case 0:
				return LOW;
			case 1:
				return MEDIUM;
			case 2:
				return HIGH;
		
			default:
				throw new IllegalArgumentException("Unknown value: " + value);
		}
	}
}
