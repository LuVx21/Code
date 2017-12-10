package me.ren.pattern.Adapter;

import org.junit.Test;

public class AdapterTest {

	@Test
	public void chargeTest() {
		GBSocketInterface gbSocket = new GBSocket();

		Hotel hotel = new Hotel();

		SocketAdapter socketAdapter = new SocketAdapter(gbSocket);

		hotel.setSocket(socketAdapter);

		hotel.charge();
	}
}