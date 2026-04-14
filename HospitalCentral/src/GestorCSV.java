import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class GestorCSV implements GestorFitxers {

	public GestorCSV() {

	}

	public Set<Pacient> llegir(String nomFitxer) throws Exception {

		File fitxer = new File(nomFitxer);

		FileReader fReader = null;

		String linia;
		Set<Pacient> total = new HashSet<>();

		try (BufferedReader bReader = new BufferedReader(new FileReader(fitxer))) {
			String info;
			while ((linia = bReader.readLine()) != null) {

				String nom, dni, telefon, codi, historic, fechaNaix;
				String[] elemento = linia.split("; ");

				nom = elemento[0];
				dni = elemento[1];
				fechaNaix = elemento[2];
				telefon = elemento[3];
				codi = elemento[4];
				historic = elemento[5];
				total.add(new Pacient(nom, dni, fechaNaix, telefon, codi, historic));
			}
			return total;

		} catch (FileNotFoundException e) {

			System.out.println("Fitxer no existeix");
			return total;
		} catch (IOException e) {

			System.out.println(e.getMessage());
			return total;
		}
	}

	public void desa(String nomFitxer, Set<Pacient> pacientes) {
		boolean append = false;

		PrintWriter pWriter = null;

		FileWriter fWriter = null;

		try {

			fWriter = new FileWriter(nomFitxer, append);

			pWriter = new PrintWriter(fWriter);
			for (Pacient p : pacientes) {

				pWriter.println();
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {

			try {

				if (fWriter != null)

					fWriter.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

			if (pWriter != null)

				pWriter.close();

		}

	}
}
