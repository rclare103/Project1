package com.revature.pojo;

import java.util.HashMap;
import java.util.Map;

public class EventTypes {
	public static Map<String, Double> reEvent = new HashMap<String, Double>(){{
	put("university_course", 0.8);
	put("seminar", 0.6);
	put("certification_preparation_class", 0.75);
	put("certification", 1.0);
	put("technical_training", 0.9);
	put("other", 0.3);
	}};

	public Map<String, Double> getReEvent() {
		return reEvent;
	}

	public void setReEvent(Map<String, Double> reEvent) {
		EventTypes.reEvent = reEvent;
	}
	
	
}
