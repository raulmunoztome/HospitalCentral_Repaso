import java.util.Objects;

public class Especialitat {
	private String nom;
	private String desc;
	private int edatMin;
	private int edatMax;

	public Especialitat(String nom, String desc, int edatMin, int edatMax) throws Exception {
		if(nom.isBlank()) throw new Exception("Nombre de la especialidad obligatorio");
		this.nom = nom;
		this.desc = desc;
		if(edatMin < 0) throw new Exception("Edad minima erronea: "+edatMin);
		this.edatMin = edatMin;
		this.edatMax = edatMax;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		if(!desc.isBlank())this.desc = desc;
	}

	public int getEdatMin() {
		return edatMin;
	}

	public void setEdatMin(int edatMin) {
		if(edatMin < edatMax)this.edatMin = edatMin;
	}

	public int getEdatMax() {
		return edatMax;
	}

	public void setEdatMax(int edatMax) {
		if(edatMax > edatMin)this.edatMax = edatMax;
	}

	@Override
	public int hashCode() {

		return Objects.hash(nom);

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Especialitat other = (Especialitat) obj;

		return Objects.equals(nom, other.nom);

	}

	@Override
	public String toString() {
		return "Especialitat [nom=" + nom + ", desc=" + desc + ", edatMin=" + edatMin + ", edatMax=" + edatMax + "]";
	}
	

}
