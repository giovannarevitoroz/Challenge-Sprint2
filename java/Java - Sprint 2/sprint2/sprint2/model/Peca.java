package sprint2.model;

public class Peca {
	private int idPeca;
	private boolean disponibilidadePeca;
	private String nomePeca;
	private double precoPeca;
	
	public Peca(int idPeca, boolean disponibilidadePeca, String nomePeca, double precoPeca) {
		this.idPeca = idPeca;
		this.disponibilidadePeca = disponibilidadePeca;
		this.nomePeca = nomePeca;
		this.precoPeca = precoPeca;
	}

	public int getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(int idPeca) {
		this.idPeca = idPeca;
	}

	public boolean isDisponibilidadePeca() {
		return disponibilidadePeca;
	}

	public void setDisponibilidadePeca(boolean disponibilidadePeca) {
		this.disponibilidadePeca = disponibilidadePeca;
	}

	public String getNomePeca() {
		return nomePeca;
	}

	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}

	public double getPrecoPeca() {
		return precoPeca;
	}

	public void setPrecoPeca(double precoPeca) {
		this.precoPeca = precoPeca;
	}

	public void imprimirPeca() {
		System.out.println("ID: " + getIdPeca());
		System.out.println("Nome: " + getNomePeca());
		System.out.println("Preço: R$" + getPrecoPeca());
		System.out.println("Disponibilidade: " + (isDisponibilidadePeca() == true ? "Disponível" : "Indisponível") + "\n");
	}
}
