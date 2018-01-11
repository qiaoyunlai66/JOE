package com.joe.qiao.headfirst.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
