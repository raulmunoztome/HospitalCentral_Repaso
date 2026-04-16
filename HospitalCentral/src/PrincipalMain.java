import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Hospital hospi = new Hospital();
		;
		Doctor doctor;
		Especialitat esp;
		Pacient pacient;
		GestorXML gestorXML = new GestorXML();
		GestorCSV gestorCSV = new GestorCSV();
		List<Pacient> lista = new ArrayList<>();

		try {
			hospi = new Hospital("Santa maria de los dolores", "Calle falsa 123");
			esp = new Especialitat("Cirugia Estética", "Pa' ponerse guapo", 18, 100);
			doctor = new Doctor("Manolo", "52198720J", "20/10/1999", "645424804", esp);
			pacient = new Pacient("Raul", "47667949N", "10/05/1979", "635695619", "MED12345678", "Alergico a todo");

			hospi.sumarEspecialidad(esp);
			hospi.sumarDoctor(doctor);
			hospi.sumarPaciente(pacient);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		String opcion = "";
		while (!opcion.equals("0")) {
			String nom, dni, telefon, fecha;
			pintarMenu();
			opcion = sc.nextLine();
			switch (Integer.parseInt(opcion)) {
			case 1:
				// creamos y añadimos paciente al hospital
				System.out.println("introduce el nombre del paciente: ");
				nom = sc.nextLine();
				System.out.println("introduce el dni del paciente: ");
				dni = sc.nextLine();
				System.out.println("introduce el telefono del paciente: ");
				telefon = sc.nextLine();
				System.out.println("introduce el código del paciente: ");
				String codi = sc.nextLine();
				System.out.println("introduce la fecha de nacimiento: ");
				fecha = sc.nextLine();
				System.out.println("introduce el historial del paciente: ");
				String historial = sc.nextLine();

				try {
					pacient = new Pacient(nom, dni, fecha, telefon, codi, historial);
					hospi.sumarPaciente(pacient);
				} catch (Exception e) {

					System.out.println(e.getMessage());
				}
				break;
			case 2:
				// Creamos y añadimos doctor al hospital
				System.out.println("introduce el nombre del doctor: ");
				nom = sc.nextLine();
				System.out.println("introduce el dni del doctor: ");
				dni = sc.nextLine();
				System.out.println("introduce el telefono del doctor: ");
				telefon = sc.nextLine();
				System.out.println("introduce la fecha de nacimiento: ");
				fecha = sc.nextLine();
				System.out.println("Introduce la especialidad del doctor:");
				String especial = sc.nextLine();
				List<Especialitat> listado = hospi.infoEspecialitat();
				boolean encontrado = false;
				for (Especialitat e : listado) {
					if (e.equals(especial)) {
						encontrado = true;
						try {
							Doctor d1 = new Doctor(nom, dni, fecha, telefon, e);
							hospi.sumarDoctor(d1);
						} catch (Exception e1) {
							System.out.println(e1.getMessage());
						}
					}
				}
				if (!encontrado) {
					System.out.println("Especialidad no encontrada");
				}
				break;
			case 3:
				System.out.println("Introduce el nombre de la especialidad");
				nom = sc.nextLine();
				System.out.println("Describe la especialidad: ");
				String des = sc.nextLine();
				System.out.println("Introduce la edad minima de la especialidad: ");
				String min = sc.nextLine();
				System.out.println("Introduce la edad máxima de la especialidad: ");
				String max = sc.nextLine();
				try {
					Especialitat e1 = new Especialitat(nom, des, Integer.parseInt(min), Integer.parseInt(max));
					hospi.sumarEspecialidad(e1);
				} catch (NumberFormatException e1) {
					System.out.println(e1.getMessage());
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case 4:
				boolean encontrado1 = false;
				List<Doctor> doctores = hospi.infoDoctor();
				List<Pacient> pacientes = hospi.infoPaciente();
				Pacient pacienteC;
				Doctor doctorC;
				String hora, data;
				System.out.println("introduce el nombre del doctor con quien quiere la cita: ");
				for (Doctor d : doctores) {
					System.out.println(d.getNom());
				}
				String doctorCita = sc.nextLine();
				doctorC = null;
				for (Doctor d : doctores) {
					if (d.getNom().equalsIgnoreCase(doctorCita)) {
						encontrado1 = true;
						doctorC = d;
					}
				}
				if (!encontrado1)
					System.out.println("El doctor indicado no es correcto");

				boolean encontrado2 = false;
				System.out.println("Introduce el dni del paciente: ");
				dni = sc.nextLine();
				pacienteC = null;
				for (Pacient p : pacientes) {
					if (p.getDni().equals(dni)) {
						pacienteC = p;
						encontrado2 = true;
					}

				}
				if (!encontrado2)
					System.out.println("Paciente no encontrado");
				System.out.println("Introduce la hora de la cita (HH:MM):");
				hora = sc.nextLine();
				System.out.println("introduce la fecha de la cita (DD/MM/YYYY)");
				String ano = sc.nextLine();
				if (encontrado1 && encontrado2) {
					LocalDate a = LocalDate.parse(ano, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					LocalTime t = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
					// conversion de las fechas
					Cita generarCita = null;
					try {
						generarCita = new Cita(pacienteC, doctorC, a, t);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());

					}
					hospi.sumarCita(generarCita);
				}
				break;
			case 5:

			}

		}
	}

	public static void pintarMenu() {
		System.out.println("INTRODUCE TU OPCION NUMERICA: ");
		System.out.println("0 -> SALIR");
		System.out.println("1 -> AÑADIR PACIENTE");
		System.out.println("2 -> AÑADIR DOCTOR");
		System.out.println("3 -> AÑADIR ESPECIALIDAD>");
		System.out.println("4 -> AÑADIR CITA");
		System.out.println("5 -> ELIMINAR PACIENTE>");
		System.out.println("6 -> ELIMINAR DOCTOR");
		System.out.println("7 -> ELIMINAR ESPECIALIDAD>");
		System.out.println("8 -> ELIMINAR CITA");
		System.out.println("9 ->  INFO DE LOS PACIENTES DEL HOSPITAL");
		System.out.println("10 -> INFO DE LOS DOCTORES DEL HOSPITAL");
		System.out.println("11 -> INFO DE LAS CITAS DEL HOSPITAL");
		System.out.println("12 -> VERIFICAR LA CITA DE UN PACIENTE");
		System.out.println("13 -> PACIENTES CREADOS??");
	}
}
