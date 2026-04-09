import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrincipalMain {

	public static void main(String[] args) {
		Hospital hospi;
		Doctor doctor;
		Especialitat esp;
		Pacient pacient;
		GestorXML gestorXML = new GestorXML();
		GestorCSV gestorCSV = new GestorCSV();
		LocalDate fecha = LocalDate.parse("21/04/1994", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		try {
			hospi = new Hospital("Santa maria de los dolores", "Calle falsa 123");
			esp = new Especialitat("Cirugia Estetica", "Pa' ponerse guapo", 18, 100);
			doctor = new Doctor("Manolo", "52198720J", fecha, "645424804", esp);
			pacient = new Pacient("Raul", "47667949N", fecha, "635695619", "MED12345678", "Alergico a todo");

			hospi.sumarEspecialidad(esp);
			hospi.sumarDoctor(doctor);
			hospi.sumarPaciente(pacient);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	public static void pintarMenu() {

		System.out.println("0 ->");
		System.out.println("1 ->");
		System.out.println("2 ->");
		System.out.println("3 ->");
		System.out.println("4 ->");
		System.out.println("5 ->");
		System.out.println("6 ->");
		System.out.println("7 ->");
		System.out.println("8 ->");
	}
}
