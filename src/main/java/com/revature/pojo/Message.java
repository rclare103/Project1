package com.revature.pojo;

public class Message {
	private int rID;
	
	private String dsMessage;
	
	private String dhMessage;
	
	private String bcMessage;

	public String getDsMessage() {
		return dsMessage;
	}

	public void setDsMessage(String dsMessage) {
		this.dsMessage = dsMessage;
	}

	public String getDhMessage() {
		return dhMessage;
	}

	public void setDhMessage(String dhMessage) {
		this.dhMessage = dhMessage;
	}

	public String getBcMessage() {
		return bcMessage;
	}

	public void setBcMessage(String bcMessage) {
		this.bcMessage = bcMessage;
	}

	
	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bcMessage == null) ? 0 : bcMessage.hashCode());
		result = prime * result + ((dhMessage == null) ? 0 : dhMessage.hashCode());
		result = prime * result + ((dsMessage == null) ? 0 : dsMessage.hashCode());
		result = prime * result + rID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (bcMessage == null) {
			if (other.bcMessage != null)
				return false;
		} else if (!bcMessage.equals(other.bcMessage))
			return false;
		if (dhMessage == null) {
			if (other.dhMessage != null)
				return false;
		} else if (!dhMessage.equals(other.dhMessage))
			return false;
		if (dsMessage == null) {
			if (other.dsMessage != null)
				return false;
		} else if (!dsMessage.equals(other.dsMessage))
			return false;
		if (rID != other.rID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [rID=" + rID + ", dsMessage=" + dsMessage + ", dhMessage=" + dhMessage + ", bcMessage="
				+ bcMessage + "]";
	}

	public Message(int rID, String dsMessage, String dhMessage, String bcMessage) {
		super();
		this.rID = rID;
		this.dsMessage = dsMessage;
		this.dhMessage = dhMessage;
		this.bcMessage = bcMessage;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
