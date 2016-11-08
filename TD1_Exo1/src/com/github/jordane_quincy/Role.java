package com.github.jordane_quincy;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = -3014969947986932709L;
	private String theRole;

	public Role(String theRole) {
		this.theRole = theRole;
	}

	@Override
	public String toString() {
		return "Role [theRole=" + theRole + "]";
	}
}
