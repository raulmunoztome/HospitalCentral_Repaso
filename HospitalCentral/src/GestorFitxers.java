import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface GestorFitxers {
	Set<Pacient> llegir(String nombreFichero) throws FileNotFoundException, Exception;

	void desa(String fichero, Set<Pacient> v) throws FileNotFoundException, IOException;
}
