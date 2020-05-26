package com.beans;

public class Event {
		private int eventID;
		private String eventType;
		private int eventPercentage;
		public Event() {
			super();
		}
		public Event(int eventID, String eventType, int eventPercentage) {
			super();
			this.eventID = eventID;
			this.eventType = eventType;
			this.eventPercentage = eventPercentage;
		}
		public int getEventID() {
			return eventID;
		}
		public void setEventID(int eventID) {
			this.eventID = eventID;
		}
		public String getEventType() {
			return eventType;
		}
		public void setEventType(String eventType) {
			this.eventType = eventType;
		}
		public int getEventPercentage() {
			return eventPercentage;
		}
		public void setEventPercentage(int eventPercentage) {
			this.eventPercentage = eventPercentage;
		}
		@Override
		public String toString() {
			return "Event [eventID=" + eventID + ", eventType=" + eventType + ", eventPercentage=" + eventPercentage
					+ "]";
		};
		
		
}
