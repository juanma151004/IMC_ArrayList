import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Casosestudio1 {
	ArrayList<Double> Peso = new ArrayList<Double>();
	
	ArrayList<Double> Altura = new ArrayList<Double>();
	
	ArrayList<Double> Resultado = new ArrayList<Double>();
	
	ArrayList<String> Nombre = new ArrayList<String>();
	
	ArrayList<Integer> Id = new ArrayList<Integer>();
	
	ArrayList<Integer> Telefono = new ArrayList<Integer>();
	
	double IMC;
	
	String estado = "";
	
	String mensaje = "";
	public void inicio() {
		System.out.println("Inicio");
		String menu="calcular imc\n";
		menu+="1. agregar personas\n";
		menu+="2. buscar resultados individuales\n";
		menu+="3. imprimir datos\n";
		menu+="4. Actualizar\n";
		menu+="5. Borrar persona\n";
		menu+="6. Borrar todo\n";
		menu+="7. Salir\n";
		
		int opcion = 0;
		do {
			opcion= Integer.parseInt(JOptionPane.showInputDialog(menu));
			validacionmenu(opcion);
		} while (opcion!=7);
	}
	
	
	
	public void validacionmenu(int opcion) {
		switch (opcion) {
		case 1: 
			pedirdatos();
			break;
			
		case 2:
			if (Id!=null) {
				Mensaje();	
			}else {
				System.out.println("debe primero llenar datos");
			}
			break;
			
		case 3:
			if (validarArreglo()) {
				Imprimirdatos();	
			}
			break;
			
		case 4: 
			if (validarArreglo()) {
				actualizar();	
			}
			break;
			
		case 5: 
			if (validarArreglo()) {
				borrarPersona();	
			}
			break;
		
		case 6: 
			if (validarArreglo()) {
				borrarTodo();	
			}
			break;
		case 7: 
			System.out.println("chao con adios");
			
			break; 
			
		default:
			System.out.println("ingrese una opcion valida");
		}
	}



	private void borrarPersona() {
		System.out.println("Lista de personas ingresadas");
		for (int i = 0; i < Nombre.size(); i++) {
			System.out.println((i+1)+" "+Nombre.get(i));
		}
		int index = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la persona que desea actualizar"));
		
		if (index >= 1 && index<=Nombre.size()) {
			System.out.println("La persona selecionada fue: "+Nombre.get(index-1));
			Id.remove(index-1);
			Nombre.remove(index-1);
			Telefono.remove(index-1);
			Peso.remove(index-1);
			Altura.remove(index-1);
			Resultado.remove(index-1);
			
			System.out.println("La persona seleccionada ha sido eliminada");
			
		}
		
	}



	public boolean validarArreglo() {
		if (Nombre!=null) {
			return true;
		}else {
			System.out.println("Debe primero llenar datos");
			return false;
		}
		}
	
	
	private void Imprimirdatos() {
		System.out.println("Impresion de datos");
		for (int i = 0; i < Nombre.size(); i++) {
			System.out.println("Nombre: "+Nombre.get(i)+" Documento: "+Id.get(i)+" Telefono: "+Telefono.get(i)+" Resultado: "+Resultado.get(i));
		}
		
	}
	private void Mensaje() {
		int documentobuscar = Integer.parseInt(JOptionPane.showInputDialog("ingrese su documento"));
		int contador=0;
		
		for (int i = 0; i < Id.size(); i++) {
			if (Id.get(i)==documentobuscar) {
				mensaje="Señor(a) "+Nombre.get(i)+", identificado con el documento "+Id.get(i)+"\n";
				mensaje+="con el telefono "+Telefono.get(i)+". El resultado de su IMC fue "+Resultado.get(i)+"\n";
				mensaje+="el cual dice que usted padece "+estado;
				System.out.println(mensaje);
				contador++;
			}
		}
		if (contador==0) {
			System.out.println("La persona a buscar no ha sido encontrada");
		}
	}


	

	public void actualizar() {
		
		
		System.out.println("Lista de personas ingresadas");
		for (int i = 0; i < Nombre.size(); i++) {
			System.out.println((i+1)+" "+Nombre.get(i));
		}
		int index = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la persona que desea actualizar"));
		
		if (index >= 1 && index<=Nombre.size()) {
			System.out.println("La persona selecionada fue: "+Nombre.get(index-1));
			
			
			String opciones ="Ingrese el numero de lo que desea actualizar\n";
			opciones +="1.Documento\n";
			opciones +="2.Nombre\n";
			opciones +="3.Telefono\n";
			opciones +="4.Peso\n";
			opciones +="5.Altura";
			
			int eleccion = Integer.parseInt(JOptionPane.showInputDialog(opciones));
			
			switch (eleccion) {
			case 1: 
				int nuevoDoc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo documento"));
				Id.set(index-1, nuevoDoc);
				
				break;
				
			case 2: 
				String nuevoNom = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
				Nombre.set(index-1, nuevoNom);
				
				break;
			
			case 3: 
				int nuevoTel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo telefono"));
				Telefono.set(index-1, nuevoTel);
				
				break;
				
			case 4: 
				Double nuevoPes = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo peso"));
				Peso.set(index-1, nuevoPes);
				
				break;
				
			case 5: 
				Double nuevaAlt = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva altura"));
				Altura.set(index-1, nuevaAlt);
				
				break;
			
			default:
				JOptionPane.showMessageDialog(null, "El numero ingresado no es valido");
			}
		}
		System.out.println("actualizacion\n");
		System.out.println(Id.get(index-1));
		System.out.println(Nombre.get(index-1));
		System.out.println(Telefono.get(index-1));
		System.out.println(Peso.get(index-1));
		System.out.println(Altura.get(index-1));
		
	}
	
	
	public void borrarTodo() {
		Id.clear();
		Nombre.clear();
		Telefono.clear();
		Peso.clear();
		Altura.clear();
		Resultado.clear();
		System.out.println("Todos los datos han sido eliminados");
	}

	public void pedirdatos() {
		
		Id.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de documento")));
		
		Nombre.add(JOptionPane.showInputDialog("Ingrese su nombre"));
		
		Telefono.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su telefono")));
		
		Peso.add(Double.parseDouble(JOptionPane.showInputDialog("Ingrese su peso")));
		
		Altura.add(Double.parseDouble(JOptionPane.showInputDialog("Ingrese su altura")));
		
		for (int i = 0; i <Nombre.size(); i++) {
			IMC=Peso.get(i)/(Altura.get(i)*Altura.get(i));
			
			Resultado.add(IMC);
			
			if(IMC<18) {
			estado = "anorexia";
		}else if(IMC>=18 && IMC<20) {
			estado = "delgadez";
		}else if(IMC>=20 && IMC<27) {
			estado = "normalidad";
		}else if(IMC>=27 && IMC<30) {
			estado = "obesidad grado 1";
		}else if(IMC>=30 && IMC<35) {
			estado = "obesidad grado 2";
		}else if(IMC>=35 && IMC<40) {
			estado = "obesidad grado 3";
		}else if(IMC>=40) {
			estado = "obesidad morbida";
		}
			
			
		}
	}
	
	

}

