package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Movimentacoes")
public class Movimentacoes {

	@Id
	@Column(name = "ID_MOVIM")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_id_movim")
	@SequenceGenerator(name = "s_id_movim", sequenceName = "S_ID_MOVIM", allocationSize = 1, initialValue = 1)
	private int idMovim;

	@Column(name = "DATA_MOVIM")
	private String dataMovim;

	@Column(name = "TP_MOVIM")
	private int TpMovim;

	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
	@ManyToOne
	private Cliente cliente;

	@JoinColumn(name = "ID_CONTA", referencedColumnName = "ID_CONTA")
	@ManyToOne
	private Conta conta;

	public int getIdMovim() {
		return idMovim;
	}

	public void setIdMovim(int idMovim) {
		this.idMovim = idMovim;
	}

	public String getDataMovim() {
		return dataMovim;
	}

	public void setDataMovim(String dataMovim) {
		this.dataMovim = dataMovim;
	}

	public int getTpMovim() {
		return TpMovim;
	}

	public void setTpMovim(int tpMovim) {
		TpMovim = tpMovim;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Movimentacoes [idMovim=" + idMovim + ", dataMovim=" + dataMovim + ", TpMovim=" + TpMovim + ", cliente="
				+ cliente + ", conta=" + conta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TpMovim;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((dataMovim == null) ? 0 : dataMovim.hashCode());
		result = prime * result + idMovim;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacoes other = (Movimentacoes) obj;
		if (TpMovim != other.TpMovim)
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (dataMovim == null) {
			if (other.dataMovim != null)
				return false;
		} else if (!dataMovim.equals(other.dataMovim))
			return false;
		if (idMovim != other.idMovim)
			return false;
		return true;
	}

}
