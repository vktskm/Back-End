package com.example.incendio.factory;

public class FactoryCentroControllo implements IFactoryCentroControllo {
	
      @Override
      public CentroControllo crea(){
    	  
    	  return new CentroControllo();
      }
	
}
