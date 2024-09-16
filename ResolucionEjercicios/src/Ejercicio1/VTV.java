package Ejercicio1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VTV {
	// Atributos
	private LocalDate fechaVTV;
	private boolean motor;
	private boolean frenos;
	private boolean suspension;
	private String patente;

	// constructor
	public VTV(LocalDate fechaVTV, boolean motor, boolean frenos, boolean suspension, String patente) {
		super();
		this.fechaVTV = fechaVTV;
		this.motor = motor;
		this.frenos = frenos;
		this.suspension = suspension;
		this.patente = patente;
	}
	
	// constructor vacio, solo le paso patente para crearlo
	public VTV(String patente) {
		super();
		this.fechaVTV = LocalDate.now();
		this.motor = false;
		this.frenos = false;
		this.suspension = false;
		this.patente = patente;
	}
	// Get y Set

	
	public LocalDate getFechaVTV() {
		return fechaVTV;
	}

	public void setFechaVTV() {
		this.fechaVTV = LocalDate.of(validarNumeros("Ingrese año"),validarNumeros("Ingrese mes"),validarNumeros("Ingrese dìa"));
	}

	public boolean isMotor() {
		return motor;
	}

	public void setMotor(boolean motor) {
		this.motor = motor;
	}

	public boolean isFrenos() {
		return frenos;
	}

	public void setFrenos(boolean frenos) {
		this.frenos = frenos;
	}

	public boolean isSuspension() {
		return suspension;
	}

	public void setSuspension(boolean suspension) {
		this.suspension = suspension;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String mostrarEstado(boolean estado) {
		if (estado==true) {
			return "Bueno";
		} else {
			return "Necesita reparación";
		}

	}

	
	public int validarNumeros(String mensaje) {
		boolean flag ;
		String num ="" ;
		do {
			flag =true;
			num = JOptionPane.showInputDialog(mensaje);
			while (num.isEmpty()) {
				num = JOptionPane.showInputDialog(mensaje);
			}
			for (int i = 0; i < num.length(); i++) {
				if (!Character.isDigit(num.charAt(i))) {
					flag = false;
					break;
				}
			}
		} while (!flag);
		
		return Integer.parseInt(num);
	}
	
	public String validarCaracteres(String mensaej) {
		String palabra = "";
		while (palabra.equals("")) {
			palabra = JOptionPane.showInputDialog(mensaej);
		}
		return palabra;
	}
	// Como es un método de instancia lo hace un objeto, no le envio información por
	// esto mismo
	public void realizarVtv() {
		// Verifico que la fecha de la vtv del auto no este vencida
		if (LocalDate.now().isBefore(this.fechaVTV)) {
			Period vigente = Period.between(LocalDate.now(), fechaVTV);
			if (vigente.getYears() > 0) {
				JOptionPane.showMessageDialog(null,
						"Todavia esta vigente la vtv, le quedan " + vigente.getYears() + " año/s");
			} else if (vigente.getMonths() > 0) {
				JOptionPane.showMessageDialog(null,
						"Todavia esta vigente la vtv, le quedan " + vigente.getMonths() + " mes/es");
			} else {
				JOptionPane.showMessageDialog(null,
						"Todavia esta vigente la vtv, le quedan " + vigente.getDays() + " día/s");
			}

		} else {
			JOptionPane.showMessageDialog(null, "La vtv esta vencida. Se realiza la inspección......");

			String reparaciones = this.inspeccionarVehiculo();
			if (reparaciones.equals("")) {
				JOptionPane.showMessageDialog(null, "Pasa la vtv, esta en buen estado !");
				this.fechaVTV = LocalDate.now().plusYears(1);

			} else {
				JOptionPane.showMessageDialog(null, "Se debe reparar estas partes : " + reparaciones);
			}
		}

	}

	public String inspeccionarVehiculo() {
		String reparaciones = "";
		if (frenos) {
			JOptionPane.showMessageDialog(null, "Pasa la verifiacion de frenos");
		} else {
			JOptionPane.showMessageDialog(null,
					"No pasa la verifiacion de frenos, se añade a la lista de reparaciones");
			reparaciones = reparaciones + "Frenos en mal estado";
		}
		if (motor) {
			JOptionPane.showMessageDialog(null, "Pasa la verifiacion de motor");
		} else {
			JOptionPane.showMessageDialog(null, "No pasa la verifiacion de motor, se añade a la lista de reparaciones");
			reparaciones = reparaciones + "Motor en mal estado";
		}
		if (suspension) {
			JOptionPane.showMessageDialog(null, "Pasa la verifiacion de suspension");
		} else {
			JOptionPane.showMessageDialog(null,
					"No pasa la verifiacion de suspension, se añade a la lista de reparaciones");
			reparaciones = reparaciones + "suspension en mal estado";
		}
		return reparaciones;

	}

	public void reparar() {
		String reparaciones = this.inspeccionarVehiculo();
		if (reparaciones.equals("")) {
			JOptionPane.showMessageDialog(null, "No hay reparaciones para hacer");

		} else {
			this.frenos = true;
			this.suspension = true;
			this.motor = true;
			JOptionPane.showMessageDialog(null, "Se repararon todas las partes dañadas...");
		}

	}
	public void menu() {
		 String[] menu = {"Ver estado de auto","Realizar vtv","Reparar auto","Salir"};
	     int opcion ;
	     do {
	    	 opcion =JOptionPane.showOptionDialog(null, "Elija una opción \n" +this.getPatente(),"Menu", JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/mecanico.png")), menu, menu[0]);
	    	 switch (opcion) {
			case 0:
				JOptionPane.showMessageDialog(null, this);
				break;
			case 1:
				this.realizarVtv();
				break;
			case 2:
				this.reparar();
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "A bueno adios master", "", JOptionPane.DEFAULT_OPTION , new ImageIcon(Main.class.getResource("/img/adios.gif")));
				break;
			case 4:
	JOptionPane.showMessageDialog(null, "Turno terminado");			break;
			}
			
		} while (opcion!=3 );
	}
	
	
	@Override
	public String toString() {
		return "VTV [fechaVTV=" + fechaVTV + ", motor=" + mostrarEstado(motor) + ", frenos=" + mostrarEstado(frenos)
				+ ", suspension=" + mostrarEstado(suspension) + ", patente=" + patente + "]";
	}

}
