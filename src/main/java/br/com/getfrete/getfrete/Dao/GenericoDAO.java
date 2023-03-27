package br.com.getfrete.getfrete.Dao;

import br.com.getfrete.getfrete.Model.CaminhoneiroModel;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericoDAO<E> extends Serializable {
    List<E> listar();

    void inserir(E e);
    void alterar(E e);


    void remover(CaminhoneiroModel caminhoneiroModel);

    CaminhoneiroModel listarPorID(CaminhoneiroModel caminhoneiroModel) ;
}
