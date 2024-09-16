package Ejercicio1;

import java.time.LocalDate;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
    
    	int opcion = 0;
		
        VTV agile = new VTV(LocalDate.of(2023, 10, 10),true,true,true,"agile");
        
        VTV volkswagen = new VTV(LocalDate.of(2022, 10, 10),false,true,true,"volkswagen");
        
        VTV toyota = new VTV(LocalDate.of(2023, 10, 10),true,false,true,"toyota");
        
        VTV chevrolet = new VTV(LocalDate.of(2024, 10, 10),true,false,true,"chevrolet spin");
    	do {
	
    
     VTV generico = new VTV("");
     
     String[] autos = {"agile","volkswagen","toyota","chevrolet","Terminar día"};
     int opcion2 = JOptionPane.showOptionDialog(null, "Seleccione un modelo", null, 0, 0, null, autos, autos[0]);
     switch (opcion2) {
	case 0:
		generico = agile;
		break;
	case 1:
		generico = volkswagen;
		break;
	case 2:
		generico = toyota;
		break;
	case 3:
		generico = chevrolet;
		break;
	case 4:
		opcion= 4;
		break;
	}
     
     if (opcion!=4) {
    	 generico.menu();
		
	} else {
		JOptionPane.showMessageDialog(null, "Final del turno");
	}
     
    
		} while (opcion!=4);

    }
}
