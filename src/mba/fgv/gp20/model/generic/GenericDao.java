package mba.fgv.gp20.model.generic;

import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDao<T> {
	/**
	 *  Inicia uma transacao do EntityManager 
	 */
	public void beginTx() throws Exception;
	
	/**
	 *  Commita e transacao do EntityManager
	 */
	public void commitTx() throws Exception;
	
	/**
	 * Fecha uma transacao do EntityManager
	 */
	public void closeTx() throws Exception;
	
	/**
	 * Insere um registro.
	 * @param entidade
	 * @return True se tudo ocorrer bem.
	 */
	public boolean add(T entidade);
	
	/**
	 * Busca um registro pelo Id.
	 * @param entidade_id
	 * @return
	 */
	public T findById(long entidadeId) throws Exception;

	/**
	 * Busca todos os registros.
	 * @return Uma lista de elementos
	 */
	public List<T> findAll() throws Exception;
	
	/**
	 * Atualiza um registro.
	 * @param entidade
	 * @return
	 */
	public boolean update(T entidade);
	
	/**
	 * Exclui um registro.
	 * @param entidade_id
	 * @return
	 */
	public boolean remove(long entidadeId);
	

	/**
	 * Retorna a quantidade de registros da tabela.
	 * @return
	 */
	public int count(String table) throws Exception;

	/**
	 * Retorna o EntityManager para aquela transação.
	 * @return
	 */
	public EntityManager getEntityManager() throws Exception;
}
