package projetodespesa.projetodespesa.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DespesasModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	private String descricao;
	private String situação;
	private String observacoes;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public String getSituação() {
		return situação;
	}
	public void setSituação(String situação) {
		this.situação = situação;
	}
		
}
