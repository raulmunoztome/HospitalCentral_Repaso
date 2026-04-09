import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

public class GestorXML implements GestorFitxers {

	public GestorXML() {

	}

	public Set<Pacient> llegir(String nomFitxero) throws FileNotFoundException {

		XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(nomFitxero)));
		Pacient p2 = (Pacient) d.readObject();
		d.close();
		return (Set<Pacient>) p2;

	}

	public void desa(String nomFitxer, Set<Pacient> pacientes) throws FileNotFoundException {
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nomFitxer)));
		e.writeObject(pacientes);
		e.close();
	}
}
