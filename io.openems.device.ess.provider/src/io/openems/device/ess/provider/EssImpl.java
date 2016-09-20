package io.openems.device.ess.provider;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.openems.device.ess.api.Ess;

@Component(name = "io.openems.device.ess.provider.EssImpl")
public class EssImpl implements Ess {

	@Reference
	private ConfigurationAdmin cm;
	
//	@ObjectClassDefinition
//	@interface Configuration {
//		int minSoc() default 10;
//	};	
	@Activate
//	public void activate(Configuration config) {
	public void activate(Map<String, Object> map) {
//	public void activate(EssConfig config) {
		System.out.println();
		System.out.println("Activate EssImpl");
		System.out.println("  Config: " + map);
//		System.out.println("  Config: minSoc = " + config.minSoc());
	}
	
	@Override
	public int getStateOfCharge() {
		try {
			Configuration c = cm.getConfiguration("io.openems.device.ess.provider.EssImpl");
//			Configuration c = (Configuration) cm.getConfiguration("io.openems.device.ess.provider.EssImpl");
//			EssConfig c = (EssConfig) cm.getConfiguration("io.openems.device.ess.provider.EssImpl");
			System.out.println(c.toString());
			Dictionary<String, Object> d = new Hashtable<>();
			d.put("minSOC", new Integer(5));
//			c.minSoc = 15;
//			c.update(d);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ThreadLocalRandom.current().nextInt(0, 100);
	}

}
