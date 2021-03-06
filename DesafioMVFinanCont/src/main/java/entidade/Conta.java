package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONTA")
public class Conta {

	@Id
	@Column(name = "ID_CONTA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_id_conta")
	@SequenceGenerator(name = "s_id_conta", sequenceName = "S_ID_CONTA", initialValue = 1, allocationSize = 1)
	private int idConta;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "STATUS_CONTA")
	private String statusConta;

	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
	@ManyToOne
	private Cliente cliente;

	@OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
	private List<Movimentacoes> listaMovimentacoes;

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getStatusConta() {
		return statusConta;
	}

	public void setStatusConta(String statusConta) {
		this.statusConta = statusConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Movimentacoes> getListaMovimentacoes() {
		return listaMovimentacoes;
	}

	public void setListaMovimentacoes(List<Movimentacoes> listaMovimentacoes) {
		this.listaMovimentacoes = listaMovimentacoes;
	}

	@Override
	public String toString() {
		return "Conta [idConta=" + idConta + ", numero=" + numero + ", statusConta=" + statusConta + ", cliente="
				+ cliente + ", listaMovimentacoes=" + listaMovimentacoes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + idConta;
		result = prime * result + ((listaMovimentacoes == null) ? 0 : listaMovimentacoes.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((statusConta == null) ? 0 : statusConta.hashCode());
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
		Conta other = (Conta) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (idConta != other.idConta)
			return false;
		if (listaMovimentacoes == null) {
			if (other.listaMovimentacoes != null)
				return false;
		} else if (!listaMovimentacoes.equals(other.listaMovimentacoes))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (statusConta == null) {
			if (other.statusConta != null)
				return false;
		} else if (!statusConta.equals(other.statusConta))
			return false;
		return true;
	}

}
