package fr.eni.ecole.LocationCycles;

import java.time.LocalDate;
import java.time.Month;

public class LocationCycles {

	public static void main(String[] args) {
		Cycles[] aLouer = {
				
				new Velo( "Lapierre", "speed 400",LocalDate.of(2017, Month.JUNE, 2), 27),
				new Velo("Btwin", "riverside 900", LocalDate.of(2018, Month.APRIL, 9),10),
				new Gyropode( "Segway", "Ninebot Elite",LocalDate.of(2018, Month.JUNE, 5), 40, 150),
				new Gyropode("Weebot", "Echo", LocalDate.of(2017, Month.MAY, 2),35, 160),
				new Gyroroue( "Immotion", "v8", LocalDate.of(2018, Month.MARCH, 25), 40),
				new Gyroroue( "Segway", "Ninebot One E+", LocalDate.of(2018, Month.MARCH, 25), 30)
		};
		
		for(Cycles c : aLouer) {
			System.out.printf(" - %s %5.2f€/heure%n", c.toString(), c.getTarif());
		}


	}

}
