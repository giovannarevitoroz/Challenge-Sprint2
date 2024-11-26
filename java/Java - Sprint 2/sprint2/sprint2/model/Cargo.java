package sprint2.model;

public class Cargo {
	private int idCargo;
	private String nomeCargo;
	private String descricaoCargo;
	private String areaCargo;
	private double salarioCargo;
	
	public Cargo(int idCargo, String nomeCargo, String descricaoCargo, String areaCargo, double salarioCargo) {
		this.idCargo = idCargo;
		this.nomeCargo = nomeCargo;
		this.descricaoCargo = descricaoCargo;
		this.areaCargo = areaCargo;
		this.salarioCargo = salarioCargo;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getDescricaoCargo() {
		return descricaoCargo;
	}

	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}

	public String getAreaCargo() {
		return areaCargo;
	}

	public void setAreaCargo(String areaCargo) {
		this.areaCargo = areaCargo;
	}
	
	public double getSalarioCargo() {
		return salarioCargo;
	}

	public void setSalarioCargo(double salarioCargo) {
		this.salarioCargo = salarioCargo;
	}

	public void imprimirCargo() {
		System.out.println("ID: " + getIdCargo());
		System.out.println("Nome do Cargo: " + getNomeCargo());
		System.out.println("Descrição: " + getDescricaoCargo());
		System.out.println("Área do Cargo: " + getAreaCargo());
		System.out.println("Salário: R$" + getSalarioCargo() + "\n");
	}
}
