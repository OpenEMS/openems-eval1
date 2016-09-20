package io.openems.device.ess.provider;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import io.openems.device.ess.api.Ess;
import osgi.enroute.debug.api.Debug;

@Component(
		name = "io.openems.device.ess",
		property = {
				Debug.COMMAND_SCOPE + "=ess",
				Debug.COMMAND_FUNCTION + "=getStateOfCharge"
		})
public class EssImpl implements Ess {

	@Activate
	public void activate() {
		System.out.println("Activate EssImpl");
	}
	
	@Override
	public int getStateOfCharge() {
		return 15;
	}

}
