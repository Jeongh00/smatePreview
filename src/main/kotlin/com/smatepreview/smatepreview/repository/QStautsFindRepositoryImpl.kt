package com.smatepreview.smatepreview.repository

import com.querydsl.jpa.impl.JPAInsertClause
import com.querydsl.jpa.impl.JPAQueryFactory
import com.querydsl.sql.Configuration
import com.querydsl.sql.MySQLTemplates
import com.querydsl.sql.RelationalPathBase
import com.querydsl.sql.SQLQueryFactory
import com.smatepreview.smatepreview.domain.QStauts
import com.smatepreview.smatepreview.domain.Stauts
import com.smatepreview.smatepreview.dto.Detail
import com.smatepreview.smatepreview.dto.StatusRequestDto
import com.smatepreview.smatepreview.dto.StatusResponseDto
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.sql.DataSource

@Repository
class QStautsFindRepositoryImpl(em: EntityManager?) : QuerydslRepositorySupport(Stauts::class.java), QStautsFindRepository {

    private val queryFactory: JPAQueryFactory

    init {
        queryFactory = JPAQueryFactory(em)
    }

    override fun searchStatus(statusRequestDto: StatusRequestDto): Stauts? {

        val s = QStauts("s")

        return queryFactory
            .selectFrom(s)
            .where(
                s.bno.`in`(statusRequestDto.b_no)
            )
            .fetchOne()
    }

}