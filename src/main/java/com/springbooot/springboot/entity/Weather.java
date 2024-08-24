package com.springbooot.springboot.entity;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

/*@Component
public class Weather {
	 
	@JsonProperty("data")
	    private WeatherData data;

	    // Getters and setters

	    public WeatherData getData() {
	        return data;
	    }

	    public void setData(WeatherData data) {
	        this.data = data;
	    }

	    public static class WeatherData {
	        @JsonProperty("timelines")
	        private Timeline[] timelines;

	        // Getters and setters

	        public Timeline[] getTimelines() {
	            return timelines;
	        }

	        public void setTimelines(Timeline[] timelines) {
	            this.timelines = timelines;
	        }
	    }

	    
	    public static class Timeline {
	        @JsonProperty("intervals")
	        private Interval[] intervals;

	        // Getters and setters

	        public Interval[] getIntervals() {
	            return intervals;
	        }

	        public void setIntervals(Interval[] intervals) {
	            this.intervals = intervals;
	        }
	    }

	    public static class Interval {
	        @JsonProperty("values")
	        private Values values;

	        // Getters and setters

	        public Values getValues() {
	            return values;
	        }

	        public void setValues(Values values) {
	            this.values = values;
	        }
	    }

	    
	    public static class Values {
	        @JsonProperty("temperature")
	        private double temperature;

	        // Other weather attributes

	        // Getters and setters

	        public double getTemperature() {
	            return temperature;
	        }

	        public void setTemperature(double temperature) {
	            this.temperature = temperature;
	        }
	    }}
*/