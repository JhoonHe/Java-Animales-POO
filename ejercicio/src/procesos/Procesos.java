package procesos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import animal.Animal;

public class Procesos {

	ArrayList<Animal> listaAnimales = new ArrayList<Animal>();
	ArrayList<String> listaIdentificaciones = new ArrayList<String>();

	public Procesos() {
		iniciar();
	}

	private void iniciar() {

		String menu = obtenerMenu();

		int opcion = 0;

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarOpcion(opcion);
		} while (opcion != 6);

	}

	private void validarOpcion(int opcion) {

		switch (opcion) {

		case 1:
			registrarAnimales();
			break;

		case 2:
			if (!listaAnimales.isEmpty()) {
				listaAnimales();
				break;
			}
			JOptionPane.showMessageDialog(null, "No hay datos registrados");
			break;

		case 3:
			if (!listaAnimales.isEmpty()) {
				buscarAnimal();
				break;
			}
			JOptionPane.showMessageDialog(null, "No hay datos registrados");
			break;

		case 4:
			if (!listaAnimales.isEmpty()) {
				actualizarAnimal();
				break;
			}
			JOptionPane.showMessageDialog(null, "No hay datos registrados");
			break;

		case 5:
			if (!listaAnimales.isEmpty()) {
				eliminarAnimal();
				break;
			}
			JOptionPane.showMessageDialog(null, "No hay datos registrados");
			break;

		case 6:
			JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opcion incorrecta");

		}
	}

	private void registrarAnimales() {

		int cantidad = 0;
		cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de animales a registrar"));

		for (int i = 0; i < cantidad; i++) {

			Animal animal = new Animal();

			animal.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del animal a registrar").toLowerCase());

			do {
				animal.setIdentificacion(JOptionPane
						.showInputDialog("Ingrese la identificacion del animal " + animal.getNombre()).toLowerCase());
				if (listaIdentificaciones.contains(animal.getIdentificacion())) {
					JOptionPane.showMessageDialog(null, "La identificacion ingresada para el animal "
							+ animal.getNombre() + " ya existe, por favor ingrese una diferente");
				}
			} while (listaIdentificaciones.contains(animal.getIdentificacion()));

			animal.setGenero(
					JOptionPane.showInputDialog("Ingrese el genero del animal " + animal.getNombre()).toLowerCase());
			animal.setColor(
					JOptionPane.showInputDialog("Ingrese el color del animal " + animal.getNombre()).toLowerCase());
			animal.setEspecie(
					JOptionPane.showInputDialog("Ingrese la especie del animal " + animal.getNombre()).toLowerCase());
			animal.setEdad(
					Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del animal " + animal.getNombre())));

			listaAnimales.add(animal);
			listaIdentificaciones.add(animal.getIdentificacion());
		}
	}

	private void listaAnimales() {

		String mensaje = "**** Lista animales ****\n";

		mensaje += "\n********************";

		for (Animal animal : listaAnimales) {
			mensaje += "\n Nombre: " + animal.getNombre();
			mensaje += "\n Identificacion: " + animal.getIdentificacion();
			mensaje += "\n Genero: " + animal.getGenero();
			mensaje += "\n Color: " + animal.getColor();
			mensaje += "\n Edad: " + animal.getEdad();
			mensaje += "\n Especie: " + animal.getEspecie();
			mensaje += "\n Sonido: " + animal.hacerSonido();
			mensaje += "\n Saltar: " + animal.saltar();
			mensaje += "\n Jugar: " + animal.jugar();
			mensaje += "\n Dormir: " + animal.dormir();
			mensaje += "\n Correr: " + animal.correr();
			mensaje += "\n********************";

		}

		JOptionPane.showMessageDialog(null, mensaje);
	}

	private void buscarAnimal() {
		String mensaje = "**** Buscar por identificación ****\n";
		String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion del animal a consultar")
				.toLowerCase();

		boolean animalEncontrado = false;

		for (Animal animal : listaAnimales) {
			if (animal.getIdentificacion().equals(identificacion)) {
				mensaje += "\n Nombre: " + animal.getNombre();
				mensaje += "\n Identificación: " + animal.getIdentificacion();
				mensaje += "\n Género: " + animal.getGenero();
				mensaje += "\n Color: " + animal.getColor();
				mensaje += "\n Edad: " + animal.getEdad();
				mensaje += "\n Especie: " + animal.getEspecie();
				mensaje += "\n Sonido: " + animal.hacerSonido();
				mensaje += "\n Saltar: " + animal.saltar();
				mensaje += "\n Jugar: " + animal.jugar();
				mensaje += "\n Dormir: " + animal.dormir();
				mensaje += "\n Correr: " + animal.correr();

				animalEncontrado = true;
			}
		}

		if (!animalEncontrado) {
			mensaje = "La identificación ingresada no pertenece a ningún animal registrado en el sistema";
		}

		JOptionPane.showMessageDialog(null, mensaje);
	}

	private void actualizarAnimal() {

		String nombre;
		String genero;
		String color;
		int edad;
		String especie;

		boolean animalEncontrado = false;

		int opcion = 0;

		String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion del animal a actualizar")
				.toLowerCase();

		for (Animal animal : listaAnimales) {

			if (animal.getIdentificacion().equals(identificacion)) {

				do {
					opcion = Integer.parseInt(JOptionPane.showInputDialog(
							"Seleccione por favor que desea actualizar:\n1- Nombre\n2- Genero\n3- Edad\n4- Color\n5- Especie"));
				} while (opcion < 1 || opcion > 5);

				switch (opcion) {

				case 1:
					nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del animal").toLowerCase();
					animal.setNombre(nombre);
					break;

				case 2:
					genero = JOptionPane.showInputDialog("Ingrese el nuevo genero del animal").toLowerCase();
					animal.setGenero(genero);
					break;

				case 3:
					edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad del animal"));
					animal.setEdad(edad);
					break;

				case 4:
					color = JOptionPane.showInputDialog("Ingrese el nuevo color del animal");
					animal.setColor(color);

				case 5:
					especie = JOptionPane.showInputDialog("Ingrese la nueva especie del animal");
					animal.setEspecie(especie);
				}

				JOptionPane.showMessageDialog(null, "Actualizacion exitosa");

				animalEncontrado = true;
			}
		}

		if (!animalEncontrado) {
			JOptionPane.showMessageDialog(null,
					"La identificacion ingresada no pertenece a ningun animal registrado en el sistema");
		}
	}

	private void eliminarAnimal() {

		String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion del animal a eliminar")
				.toLowerCase();

		boolean animalEncontrado = false;

		for (Animal animal : listaAnimales) {

			if (animal.getIdentificacion().equals(identificacion)) {
				listaAnimales.remove(animal);
				listaIdentificaciones.remove(identificacion);
				JOptionPane.showMessageDialog(null, "Los datos del animal se eliminaron con exito");
				animalEncontrado = true;
				break;
			}
		}

		if (!animalEncontrado) {
			JOptionPane.showMessageDialog(null,
					"La identificacion ingresada no pertenece a ningun animal registrado en el sistema");
		}

	}

	private String obtenerMenu() {

		String menu = "";

		menu += "***** Bienvenido *****";
		menu += "\n\nIngrese la opcion:\n";
		menu += "\n1- Registrar animal.";
		menu += "\n2- Consultar lista de animales.";
		menu += "\n3- Consultar animal.";
		menu += "\n4- Modificar datos de un animal.";
		menu += "\n5- Eliminar datos de un animal.";
		menu += "\n6- Salir.\n\n";

		return menu;
	}

}
