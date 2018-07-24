package lava.ct.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import lava.ct.webxml.WeatherWS;
import lava.ct.webxml.WeatherWS.RegionCountry;

public class WebxmlTest {

	WeatherWS weatherWS;
	
	@Before
	public void setUp() throws Exception {
		weatherWS=new WeatherWS();
	}

	@Test
	public void testWeatherWS() throws Exception {
		Map<String,RegionCountry> regions= weatherWS.getRegionCountry();
		assertTrue(regions.size()>0);
	}

}
