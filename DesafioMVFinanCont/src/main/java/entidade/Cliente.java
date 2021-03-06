package entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@Column(name = "ID_CLIENTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_id_cliente")
	@SequenceGenerator(name = "s_id_cliente", sequenceName = "S_ID_CLIENTE", allocationSize = 1, initialValue = 1)
	private int idCliente;
	
	@Column(name = "NOME")
	private String nome;

	@Column(name = "CPF_CNPJ")
	private String cpfCnpj;

	@Column(name = "RG")
	private String rg;

	@Column(name = "IE")
	private String ie;
	
	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "SALDO_INICIAL")
	private Double saldoInicial;

	@Column(name = "SALDO_ATUAL")
	private Double saldoAtual;

	@Column(name = "DT_CADASTRO")
	private String dtCadastro;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO")
	private Endereco endereco;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Conta> listaConta;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Movimentacoes> listaMovimentacoes;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(Double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public String getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(String dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Conta> getListaConta() {
		return listaConta;
	}

	public void setListaConta(List<Conta> listaConta) {
		this.listaConta = listaConta;
	}

	public List<Movimentacoes> getListaMovimentacoes() {
		return listaMovimentacoes;
	}

	public void setListaMovimentacoes(List<Movimentacoes> listaMovimentacoes) {
		this.listaMovimentacoes = listaMovimentacoes;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpfCnpj=" + cpfCnpj + ", rg=" + rg + ", ie="
				+ ie + ", telefone=" + telefone + ", saldoInicial=" + saldoInicial + ", saldoAtual=" + saldoAtual
				+ ", dtCadastro=" + dtCadastro + ", endereco=" + endereco + ", listaConta=" + listaConta
				+ ", listaMovimentacoes=" + listaMovimentacoes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
		result = prime * result + ((dtCadastro == null) ? 0 : dtCadastro.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + idCliente;
		result = prime * result + ((ie == null) ? 0 : ie.hashCode());
		result = prime * result + ((listaConta == null) ? 0 : listaConta.hashCode());
		result = prime * result + ((listaMovimentacoes == null) ? 0 : listaMovimentacoes.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((saldoAtual == null) ? 0 : saldoAtual.hashCode());
		result = prime * result + ((saldoInicial == null) ? 0 : saldoInicial.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpfCnpj == null) {
			if (other.cpfCnpj != null)
				return false;
		} else if (!cpfCnpj.equals(other.cpfCnpj))
			return false;
		if (dtCadastro == null) {
			if (other.dtCadastro != null)
				return false;
		} else if (!dtCadastro.equals(other.dtCadastro))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (ie == null) {
			if (other.ie != null)
				return false;
		} else if (!ie.equals(other.ie))
			return false;
		if (listaConta == null) {
			if (other.listaConta != null)
				return false;
		} else if (!listaConta.equals(other.listaConta))
			return false;
		if (listaMovimentacoes == null) {
			if (other.listaMovimentacoes != null)
				return false;
		} else if (!listaMovimentacoes.equals(other.listaMovimentacoes))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (saldoAtual == null) {
			if (other.saldoAtual != null)
				return false;
		} else if (!saldoAtual.equals(other.saldoAtual))
			return false;
		if (saldoInicial == null) {
			if (other.saldoInicial != null)
				return false;
		} else if (!saldoInicial.equals(other.saldoInicial))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
