package com.alura.model;

import java.awt.Dialog;

public class StatusControl {
	private Dialog dialog;
	private boolean status;
	
	public StatusControl(boolean status) {
		this.status = status;
	}
	
	public StatusControl(boolean status, Dialog dialog) {
		this.status = status;
		this.dialog = dialog;
	}

	public Dialog getDialog() {
		return dialog;
	}

	public boolean getStatus() {
		return status;
	}
	
}
