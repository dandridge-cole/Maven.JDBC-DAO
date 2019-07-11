package daos;

import models.Dto;

import java.util.List;

public abstract class Dao<E extends Dto>{
    List<E> dtos;
    E aDto;

    public abstract E findById(int id);

    public abstract List<E> findAll();

    public abstract Boolean update (E dto);

    public abstract Boolean create(E dto);

    public abstract Boolean delete (int id);
}