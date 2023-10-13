package com.example.incendio.proxy;

import com.example.incendio.observer.ObserverSonda;

public class SondaProxy implements ISondaProxy{
	
    ObserverSonda sonda;
	
	public SondaProxy( ObserverSonda sonda) {
		super();
		this.sonda = sonda;
		avviso(sonda);
	}

	@Override
	public String avviso( ObserverSonda sonda) {
		String alarm_url = "http://host/alarm?segnaleId="+sonda.getId()+"&lat="+ sonda.getLatitudine()+"&lon="+sonda.getLongitudine()+"&smokeLevel="+sonda.getLivelloFumo();
		System.out.println(alarm_url);
		return alarm_url;
	}


}
