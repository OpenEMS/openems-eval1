package io.openems.device.ess.provider;

import junit.framework.TestCase;

public class EssImplTest extends TestCase {
	
	public void testGetStateOfCharge() {
		int soc = new EssImpl().getStateOfCharge();
		assertFalse(soc > 100 || soc < 0);
	}
	
}
