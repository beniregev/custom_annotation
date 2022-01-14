package com.beniregev.custom_annotation_example.base;

/**
 * Base interface for Data Access Object (DAO).
 */
public interface BaseDao {

	/**
	 * Persist entity to DB.
	 *
	 * @param object entity for saving.
	 * @return persisted entity
	 */
	<T extends BaseEntity> T saveOrUpdate(T object);

	/**
	 * Flush session.
	 */
	void flush();

	/**
	 * Clear session cache.
	 */
	void clear();
}
