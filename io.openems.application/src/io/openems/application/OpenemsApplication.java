package io.openems.application;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(name="io.openems")
public class OpenemsApplication {

	@Activate
	public void activate() {
		System.out.println();
		System.out.println("Activate OpenemsApplication");
	}
	
}
