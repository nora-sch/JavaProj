package fr.eni.papeterie.dal;

import java.util.List;


public interface DAO<T> {
	public void insert(T obj) throws DALException;
	public void update(T obj)throws DALException;
	public T selectById(int id)throws DALException;
	public List<T> selectAll()throws DALException;
	public void deleteById(int id) throws DALException;
	public void deleteAll() throws DALException;

}
