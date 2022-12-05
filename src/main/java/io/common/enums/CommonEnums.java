package io.common.enums;

public class CommonEnums {

	public enum Option {
	    FALSE("FALSE", "0"),
	    TRUE("TRUE", "1");

	    private String name;
	    private String option;

	    private Option(String name, String option) {
	        this.name = name;
	        this.option = option;
	    }

	    public String getName() {
	        return name;
	    }
	    public String getOption() {
	        return option;
	    }
	}

}