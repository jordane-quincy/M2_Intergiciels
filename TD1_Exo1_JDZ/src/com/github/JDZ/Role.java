package com.github.JDZ;

import java.io.Serializable;

public class Role implements Serializable {
	private static final long serialVersionUID = -5666799472674602976L;
	String theRole;
	public Role(String theRole) {
		this.theRole = theRole;
	}
	@Override
	public String toString() {
		return "Role [theRole=" + theRole + "]";
	}	
}
