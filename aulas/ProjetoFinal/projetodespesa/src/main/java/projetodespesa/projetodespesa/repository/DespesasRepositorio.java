package projetodespesa.projetodespesa.repository;

import org.springframework.data.repository.CrudRepository;

import projetodespesa.projetodespesa.model.DespesasModel;

public interface DespesasRepositorio extends CrudRepository <DespesasModel, String> {

}
