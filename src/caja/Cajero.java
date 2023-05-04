package caja;


import java.util.ArrayList;
import java.util.Arrays;




public class Cajero {

	private final double caja_chica = 0;
	private ArrayList<Ticket> listaTickets = new ArrayList<Ticket>();
	private boolean pagoTarjeta;
	private double cajaFinalMetalico;
	private double cajaFinalTarjeta;

	// Valores de las monedas y billetes
	public static final double CENT_1 = 0.01;

	public static final double CENT_2 = 0.02;

	public static final double CENT_5 = 0.05;

	public static final double CENT_10 = 0.1;

	public static final double CENT_20 = 0.2;

	public static final double CENT_50 = 0.5;

	public static final double EURO_1 = 1;

	public static final double EURO_2 = 2;

	public static final int BILLETE_5 = 5;

	public static final int BILLETE_10 = 10;

	public static final int BILLETE_20 = 20;

	public static final int BILLETE_50 = 50;

	public static final int BILLETE_100 = 100;

	/**
	 * Metodo para añadir tiquet a la lista de tiquets
	 * 
	 * @param tiquet numero de tiquet
	 * @return devuelve si la operacion se ha realizado o no
	 */

	public boolean cobrarTicket(Ticket ticket) {

		boolean cobrado = false;

		
		if(listaTickets.add(ticket)) {
			cobrado = true;
		}
		return cobrado;
	}

	/**
	 * Metodo para calcular la cuantia de la vuelta del pago del cliente
	 * 
	 * @param precio valor que tiene el producto o productos comprados
	 * @param pagado valor aportado por el cliente para pagar el producto o
	 *               productos comprados
	 * @return Devuelve la cantidad a devolver
	 */

	public void calcularVuelta(double precio, double pagado) {

		double totalDevolver = pagado - precio;
		sugerenciaCambio(totalDevolver);

	}
	/*Este metodo podria ser implementado en el futuro para ser menos cutre pero necesitariamos que los tipos de datos numericos 
	 * fueran de tipo BigDecimal
	 * 
	public void sugerenciaCambio(BigDecimal totalDevolver) {
	    if (totalDevolver.compareTo(BigDecimal.ZERO) < 0) {
	        throw new IllegalArgumentException("El valor a devolver debe ser positivo.");
	    }

	    List<BigDecimal> monedas = Arrays.asList(
	        BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(20), BigDecimal.valueOf(10), 
	        BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.valueOf(1), BigDecimal.valueOf(0.5), 
	        BigDecimal.valueOf(0.2), BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.05), BigDecimal.valueOf(0.02), 
	        BigDecimal.valueOf(0.01)
	    );
	    Map<BigDecimal, Integer> contadores = new HashMap<>();

	    System.out.println("Total a devolver: " + totalDevolver);
	    for (BigDecimal moneda : monedas) {
	        while (totalDevolver.compareTo(moneda) >= 0) {
	            totalDevolver = totalDevolver.subtract(moneda);
	            contadores.put(moneda, contadores.getOrDefault(moneda, 0) + 1);
	        }
	    }

	    contadores.forEach((k, v) -> {
	        if (v > 0) {
	            if (k.compareTo(BigDecimal.ONE) >= 0) {
	                System.out.println(v + " billete(s) de " + k + " euros");
	            } else {
	                System.out.println(v + " moneda(s) de " + k.multiply(BigDecimal.valueOf(100)) + " centios");
	            }
	        }
	    });
	}*/
	public void sugerenciaCambio(double totalDevolver) {

		// damos el valor que tiene cada moneda en euros.

		int contadorCent1 = 0;
		int contadorCent2 = 0;
		int contadorCent5 = 0;
		int contadorCent10 = 0;
		int contadorCent20 = 0;
		int contadorCent50 = 0;
		int contadorEur1 = 0;
		int contadorEur2 = 0;
		int contadorEur5 = 0;
		int contadorEur10 = 0;
		int contadorEur20 = 0;
		int contadorEur50 = 0;
		int contadorEur100 = 0;
		
		
		 /* Aqui comenzamos a restar al valor de la devolucion
		 * empezando desde la mas grande a la mas pequeña hasta conseguir que lo que
		 * queda a devolver sea igual a 0, utilizando tambien un contador para cada tipo
		 * de moneda y billete y asi obtener el numero total de cada una.
		 */
		
		System.out.println("Total a devolver: " + totalDevolver);
		do {
			
			while (totalDevolver >= BILLETE_100) {
				totalDevolver = totalDevolver - BILLETE_100;
				contadorEur100++;
			}
			while (totalDevolver >= BILLETE_50) {
				totalDevolver = totalDevolver - BILLETE_50;
				contadorEur50++;
			}
			while (totalDevolver >= BILLETE_20) {
				totalDevolver = totalDevolver - BILLETE_20;
				contadorEur20++;
			}
			while (totalDevolver >= BILLETE_10) {
				totalDevolver = totalDevolver - BILLETE_10;
				contadorEur10++;
			}
			while (totalDevolver >= BILLETE_5) {
				totalDevolver = totalDevolver - BILLETE_5;
				contadorEur5++;
			}
			while (totalDevolver >= EURO_2) {
				totalDevolver = totalDevolver - EURO_2;
				contadorEur2++;
			}
			while (totalDevolver >= EURO_1) {
				totalDevolver = totalDevolver - EURO_1;
				contadorEur1++;
			}
			while (totalDevolver >= CENT_50) {
				totalDevolver = totalDevolver - CENT_50;
				contadorCent50++;
			}
			while (totalDevolver >= CENT_20) {
				totalDevolver = totalDevolver - CENT_20;
				contadorCent20++;
			}
			while (totalDevolver >= CENT_10) {
				totalDevolver = totalDevolver - CENT_10;
				contadorCent10++;
			}
			while (totalDevolver >= CENT_5) {
				totalDevolver = totalDevolver - CENT_5;
				contadorCent5++;
			}
			while (totalDevolver >= CENT_2) {
				totalDevolver = totalDevolver - CENT_2;
				contadorCent2++;
			}
			while (totalDevolver >= CENT_2) {
				totalDevolver = totalDevolver - CENT_2;
				contadorCent1++;
			}
			
		} while (totalDevolver < 0);

		 //imprimimos solo las monedas o billetes cuyo contador es mayor que 0.
		
		if (contadorEur100 > 0) {
			System.out.println(contadorEur100 + " billetes de " + BILLETE_100 + " euros");
		}
		if (contadorEur50 > 0) {
			System.out.println(contadorEur50 + " billetes de " + BILLETE_50 + " euros");
		}
		if (contadorEur20 > 0) {
			System.out.println(contadorEur20 + " billetes de " + BILLETE_20 + " euros");
		}
		if (contadorEur10 > 0) {
			System.out.println(contadorEur10 + " billetes de " + BILLETE_10 + " euros");
		}
		if (contadorEur5 > 0) {
			System.out.println(contadorEur5 + " billetes de " + BILLETE_5 + " euros");
		}
		if (contadorEur2 > 0) {
			System.out.println(contadorEur2 + " monedas de " + (int)EURO_2 + " euros");
		}
		if (contadorEur1 > 0) {
			System.out.println(contadorEur1 + " monedas de " + (int)EURO_1 + " euro");
		}
		if (contadorCent50 > 0) {
			System.out.println(contadorCent50 + " monedas de " + (int)(CENT_50*100) + " centimos");
		}
		if (contadorCent20 > 0) {
			System.out.println(contadorCent20 + " monedas de " + (int)(CENT_20*100) + " centimos");
		}
		if (contadorCent10 > 0) {
			System.out.println(contadorCent10 + " monedas de " + (int)(CENT_10*100) + " centimos");
		}
		if (contadorCent5 > 0) {
			System.out.println(contadorCent5 + " monedas de " + (int)(CENT_5*100) + " centimos");
		}
		if (contadorCent2 > 0) {
			System.out.println(contadorCent2 + " monedas de " + (int)(CENT_2*100) + " centimos");
		}
		if (contadorCent1 > 0) {
			System.out.println(contadorCent1 + " monedas de " + (int)(CENT_1*100) + " centimo");
		}
	
	}

	//CONSTRUCTOR, GETTERS Y SETTERS
	public Cajero(ArrayList<Ticket> listaTickets, boolean pagoTarjeta) {
		super();
		this.listaTickets = listaTickets;
		this.pagoTarjeta = pagoTarjeta;
		
	}

	public ArrayList<Ticket> getListaTickets() {
		return listaTickets;
	}

	public void setListaTickets(ArrayList<Ticket> listaTickets) {
		this.listaTickets = listaTickets;
	}

	public boolean isPagoTarjeta() {
		return pagoTarjeta;
	}

	public void setPagoTarjeta(boolean pagoTarjeta) {
		this.pagoTarjeta = pagoTarjeta;
	}

	public double getCajaFinalMetalico() {
		return cajaFinalMetalico;
	}

	public void setCajaFinalMetalico(double cajaFinalMetalico) {
		this.cajaFinalMetalico = cajaFinalMetalico;
	}

	public double getCajaFinalTarjeta() {
		return cajaFinalTarjeta;
	}

	public void setCajaFinalTarjeta(double cajaFinalTarjeta) {
		this.cajaFinalTarjeta = cajaFinalTarjeta;
	}

	public double getCaja_chica() {
		return caja_chica;
	}
}