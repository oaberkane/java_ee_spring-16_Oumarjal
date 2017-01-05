package fr.eservices.week402.model;

public class TimeObject {
	
	public String 
		day, time, locale;
	public long timestamp;
	
	@Override
	public String toString() {
		return "param : [day=" + day + ", time=" + time + ", locale=" + locale + ", timestamp=" + timestamp + "]";
	}
	

	
}
