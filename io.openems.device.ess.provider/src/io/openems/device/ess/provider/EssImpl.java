package io.openems.device.ess.provider;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;

import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import io.openems.device.ess.api.Ess;
import osgi.enroute.debug.api.Debug;

@ObjectClassDefinition
@interface Config {
	int minSoc();
};
@Designate(ocd = Config.class)
@Component( //
		name = "io.openems.device.ess", //
		property = { //
				Debug.COMMAND_SCOPE + "=ess", //
				Debug.COMMAND_FUNCTION + "=setMinSoc" //
		},
		configurationPolicy = ConfigurationPolicy.REQUIRE,
		service= Ess.class)
public class EssImpl implements Ess {

	@Reference
	private ConfigurationAdmin cm;

	@Activate
	public void activate(Config config) throws IOException, InvalidSyntaxException {
		System.out.println("Activate EssImpl");
		System.out.println("  MinSoc=" + config.minSoc());
	}

	@Modified
	public void modified(Config config) {
		System.out.println("Modified - MinSoc=" + config.minSoc());
	}
	
	public void setMinSoc() throws IOException, InvalidSyntaxException {
		Configuration c = cm.getConfiguration("io.openems.device.ess");
        Dictionary<String, Object> d = new Hashtable<>();
        d.put("minSoc", ThreadLocalRandom.current().nextInt(0, 100));
        c.update(d);
	}

	@Override
	public int getStateOfCharge() {
		return ThreadLocalRandom.current().nextInt(0, 100);
	}

	@Override
	public boolean isOnGrid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setActivePower(int power) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getActivePower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setReactivePower(int power) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getReactivePower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSOC() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllowedCharge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllowedDischarge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getApparentPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

}
