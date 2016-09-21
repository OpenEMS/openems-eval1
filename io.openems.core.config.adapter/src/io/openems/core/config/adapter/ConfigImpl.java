package io.openems.core.config.adapter;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;

import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.openems.device.ess.api.Ess;
import osgi.enroute.debug.api.Debug;

@Component(name = "io.openems.core.config", //
		property = { //
				Debug.COMMAND_SCOPE + "=config", //
				Debug.COMMAND_FUNCTION + "=setConfig" //
		})
public class ConfigImpl {

	@Reference
	private ConfigurationAdmin cm;

	@Reference
	private Ess ess;

	@Activate
	public void activate() throws IOException, InvalidSyntaxException {
		System.out.println("Activate ConfigImpl");
		System.out.println("  ConfigImpl. Got Ess: " + ess);
	}
	
	public void setMinSoc() throws IOException, InvalidSyntaxException {
		Configuration c = cm.getConfiguration("io.openems.device.ess");
        Dictionary<String, Object> d = new Hashtable<>();
        int random = ThreadLocalRandom.current().nextInt(0, 100);
		System.out.println("Set minSoc to " + random);
		d.put("minSoc", random);
        c.update(d);
	}
}
