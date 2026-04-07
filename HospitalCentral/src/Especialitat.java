
public class Especialitat {
	private String nom;
	private String desc;
	private int edatMin;
	private int edatMax;

	public Especialitat(String nom, String desc, int edatMin, int edatMax) {

		this.nom = nom;
		this.desc = desc;
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
		this.desc = desc;
	}

	public int getEdatMin() {
		return edatMin;
	}

	public void setEdatMin(int edatMin) {
		this.edatMin = edatMin;
	}

	public int getEdatMax() {
		return edatMax;
	}

	public void setEdatMax(int edatMax) {
		this.edatMax = edatMax;
	}

}
