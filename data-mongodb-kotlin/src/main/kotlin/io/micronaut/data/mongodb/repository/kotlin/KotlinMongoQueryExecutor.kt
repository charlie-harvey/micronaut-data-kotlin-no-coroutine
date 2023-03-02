package io.micronaut.data.mongodb.repository.kotlin

import com.mongodb.client.model.DeleteOptions
import com.mongodb.client.model.UpdateOptions
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.mongodb.operations.options.MongoAggregationOptions
import io.micronaut.data.mongodb.operations.options.MongoFindOptions
import org.bson.conversions.Bson

/**
 * MongoDB specific repository that allows to use direct BSON objects.
 *
 * @param <E> The entity type
 * @author Denis Stepanov
 * @since 3.3
 */
interface KotlinMongoQueryExecutor<E> {

    /**
     * Finds one result.
     *
     * @param filter The filter to be applied
     * @return The optional result
     */
    fun findOne(filter: Bson?): E?

    /**
     * Finds one result.
     *
     * @param options The options
     * @return The optional result
     */
    fun findOne(options: MongoFindOptions): E?

    /**
     * Finds all results.
     *
     * @param filter The filter to be applied
     * @return The records
     */
    fun findAll(filter: Bson?): List<E>

    /**
     * Finds all results.
     *
     * @param options The options
     * @return The records
     */
    fun findAll(options: MongoFindOptions): List<E>

    /**
     * Finds a page of records.
     *
     * @param filter   The filter
     * @param pageable The pageable
     * @return The page
     */
    fun findAll(filter: Bson?, pageable: Pageable): Page<E>

    /**
     * Finds a page of records.
     *
     * @param options  The options
     * @param pageable The pageable
     * @return The page
     */
    fun findAll(options: MongoFindOptions, pageable: Pageable): Page<E>

    /**
     * Finds a page of records.
     *
     * @param pipeline The pipeline to be applied
     * @return The optional result
     */
    fun findOne(pipeline: Iterable<Bson>): E?

    /**
     * Finds one result.
     *
     * @param pipeline The pipeline to be applied
     * @param options  The aggregation options
     * @return The optional result
     */
    fun findOne(pipeline: Iterable<Bson>, options: MongoAggregationOptions): E?

    /**
     * Finds all results.
     *
     * @param pipeline The pipeline to be applied
     * @return The results
     */
    fun findAll(pipeline: Iterable<Bson>): List<E>

    /**
     * Finds all results.
     *
     * @param pipeline The pipeline to be applied
     * @param options  The options
     * @return The results
     */
    fun findAll(pipeline: Iterable<Bson>, options: MongoAggregationOptions): List<E>

    /**
     * Count the records.
     *
     * @param filter The filter to be applied
     * @return The count
     */
    fun count(filter: Bson?): Long

    /**
     * Delete the records matching the filter.
     *
     * @param filter The filter to be applied
     * @return The deleted count
     */
    fun deleteAll(filter: Bson): Long

    /**
     * Delete the records matching the filter.
     *
     * @param filter  The filter to be applied
     * @param options The delete options
     * @return The deleted count
     */
    fun deleteAll(filter: Bson, options: DeleteOptions): Long

    /**
     * Update the records matching the filter.
     *
     * @param filter The filter to be applied
     * @param update The update modification
     * @return The updated count
     */
    fun updateAll(filter: Bson, update: Bson): Long

    /**
     * Update the records matching the filter.
     *
     * @param filter  The filter to be applied
     * @param update  The update modification
     * @param options The update options
     * @return The updated count
     */
    fun updateAll(filter: Bson, update: Bson, options: UpdateOptions): Long
}
