package lucas.TP1.oficina;

/**
 * Classe que contém todas as informações de um automóvel.
 *
 * @author Lucas Reis
 */
public class Automovel {
	
	private String codigo, marca, modelo, anoModelo, combustivel, placa;
	private Integer quilometragem;
	
	/**
	 * Construtor da classe Automóvel
	 * 
	 * @param codigo código do automóvel;
	 * @param marca marca do automóvel;
	 * @param modelo modelo do automóvel;
	 * @param anoModelo ano do modelo do automóvel;
	 * @param combustivel tipo de combustivel do automóvel;
	 * @param placa numeração da placa do automóvel;
	 * @param quilometragem quilometragem do automóvel;
	 */
	public Automovel(String codigo, String marca, String modelo, String anoModelo, String combustivel, String placa, Integer quilometragem) {
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.combustivel = combustivel;
		this.placa = placa;
		this.quilometragem = quilometragem;
	}
	
	/**
	 * @return marca atualmente atribuída ao automóvel.
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * @param marca nova marca a ser atribuída ao automóvel.
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	/**
	 * @return modelo atualmente atribuído ao automóvel.
	 */
	public String getModelo() {
		return modelo;
	}
	
	/**
	 * @param modelo novo modelo a ser atribuído ao automóvel.
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * @return ano do modelo atualmente atribuído ao automóvel.
	 */
	public String getAnoModelo() {
		return anoModelo;
	}
	
	/**
	 * @param anoModelo novo ano de modelo a ser atribuído ao automóvel.
	 */
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	/**
	 * @return tipo de combustível atualmente atribuído ao automóvel.
	 */
	public String getCombustivel() {
		return combustivel;
	}
	
	/**
	 * @param combustivel novo tipo de combustível a ser atribuído ao automóvel.
	 */
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	
	/**
	 * @return numeração da placa atualmente atribuída ao automóvel.
	 */
	public String getPlaca() {
		return placa;
	}
	
	/**
	 * @param placa nova numeração de placa a ser atribuída ao automóvel.
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	/**
	 * @return valor da quilometragem atualmente atribuída ao automóvel.
	 */
	public Integer getQuilometragem() {
		return quilometragem;
	}
	
	/**
	 * @param quilometragem novo valor de quilometragem a ser atribuída ao automóvel.
	 */
	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}
	
	/**
	 * @return código atualmente atribuído ao automóvel.
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * @param codigo novo código a ser atribuído ao automóvel.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Retorna uma cópia do automóvel.
	 * 
	 * @return um novo objeto <code>Automovel</code> com os mesmos valores deste, isto é, uma cópia do mesmo.
	 */
	public Automovel copy(){
		return new Automovel(codigo, marca, modelo, anoModelo, combustivel, placa, quilometragem);
	}

	
}
