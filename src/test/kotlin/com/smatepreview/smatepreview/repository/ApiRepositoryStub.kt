package com.smatepreview.smatepreview.repository

import com.smatepreview.smatepreview.domain.Api
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import java.util.*
import java.util.function.Function
import kotlin.collections.HashMap

class ApiRepositoryStub: ApiRepository {

    val map: HashMap<Long, Api?> = HashMap()
    var count = 0

    override fun <S : Api?> save(entity: S): S{
        this.map[0L] = entity
        entity?.id = 0L
        count += 1
        return entity
    }

    override fun <S : Api?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<Api> {
        TODO("Not yet implemented")
    }

    override fun findAll(sort: Sort): MutableList<Api> {
        TODO("Not yet implemented")
    }

    override fun <S : Api?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : Api?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<Api> {
        TODO("Not yet implemented")
    }

    override fun <S : Api?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<Long>): MutableList<Api> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : Api?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Api) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<Long>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<Api>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : Api?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : Api?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : Api?, R : Any?> findBy(
        example: Example<S>,
        queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>
    ): R {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun <S : Api?> saveAndFlush(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun <S : Api?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch(entities: MutableIterable<Api>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun deleteAllByIdInBatch(ids: MutableIterable<Long>) {
        TODO("Not yet implemented")
    }

    override fun getReferenceById(id: Long): Api {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): Api {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): Api {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun existsById(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Optional<Api> {
        TODO("Not yet implemented")
    }
}