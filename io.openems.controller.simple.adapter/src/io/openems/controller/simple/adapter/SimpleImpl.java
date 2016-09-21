package io.openems.controller.simple.adapter;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import io.openems.device.ess.api.Ess;

/**
 * 
 */
@Component(name = "io.openems.controller.simple")
public class SimpleImpl {

	@Reference(cardinality = ReferenceCardinality.AT_LEAST_ONE)
	private List<Ess> ess = new ArrayList<>();

	@Activate
	public void activate() {
		System.out.println("Activate SimpleImpl");
		for (Ess storage : ess) {
			System.out.println("ESS - SOC: " + storage.getStateOfCharge());
		}
	}

}
