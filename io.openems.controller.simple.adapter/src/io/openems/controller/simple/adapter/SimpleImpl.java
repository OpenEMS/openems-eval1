package io.openems.controller.simple.adapter;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.openems.device.ess.api.Ess;

/**
 * 
 */
@Component(name = "io.openems.controller.simple")
public class SimpleImpl {
	
	@Reference
	private Ess ess;
	
	@Activate
	public void activate() {
		System.out.println("Activate SimpleImpl");
		System.out.println("ESS - SOC: " + ess.getStateOfCharge());
	}

}
