package com.joe.qiao.headfirst.command.undo;

import com.joe.qiao.headfirst.command.undo.CeilingFan;
import com.joe.qiao.headfirst.command.undo.Command;

public class CeilingFanOnCommand implements Command {
	CeilingFan ceilingFan;

	public CeilingFanOnCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
	public void execute() {
		ceilingFan.high();
	}
	public void undo() {
		ceilingFan.off();
	}
}
