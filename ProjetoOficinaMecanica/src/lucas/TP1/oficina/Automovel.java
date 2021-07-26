package lucas.TP1.oficina;

public class Automovel {
	
	private String codigo, marca, modelo, anoModelo, combustivel, placa;
	private Integer quilometragem;
	public Automovel(String codigo, String marca, String modelo, String anoModelo, String combustivel, String placa, Integer quilometragem) {
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.combustivel = combustivel;
		this.placa = placa;
		this.quilometragem = quilometragem;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getAnoModelo() {
		return anoModelo;
	}
	
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	public String getCombustivel() {
		return combustivel;
	}
	
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public Integer getQuilometragem() {
		return quilometragem;
	}
	
	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Retorna uma cópia do automóvel
	 */
	public Automovel copy(){
		return new Automovel(codigo, marca, modelo, anoModelo, combustivel, placa, quilometragem);
	}

	
}
