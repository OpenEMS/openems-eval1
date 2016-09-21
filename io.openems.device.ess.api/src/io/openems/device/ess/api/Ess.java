package io.openems.device.ess.api;

public interface Ess {

	public int getStateOfCharge();
	
	public  boolean isOnGrid();

	public  boolean isRunning();

	public  void setActivePower(int power);

	public  int getActivePower();

	public  void setReactivePower(int power);

	public  int getReactivePower();

	public  int getSOC();

	public  int getAllowedCharge();

	public  int getAllowedDischarge();

	public  void start();

	public  void stop();

	public  int getApparentPower();

	public  int getMaxCapacity();
	
}
