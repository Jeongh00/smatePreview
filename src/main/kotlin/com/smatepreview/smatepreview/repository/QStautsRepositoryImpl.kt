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
class QStautsRepositoryImpl(datasource: DataSource) : QuerydslRepositorySupport(Stauts::class.java), QStautsRepository {

    private val queryFactory: SQLQueryFactory

    init {
        val temp = MySQLTemplates()
        queryFactory = SQLQueryFactory(Configuration(temp), datasource)
    }

    override fun saveStatus(detail: Detail): Long? {
//        val s = QStauts("s")

        val insert = queryFactory
            .insert(RelationalPathBase(Stauts::class.java,
                "", "ApiDB", "stauts"))
            .values(1L, detail.b_no, detail.b_stt, detail.tax_type)
        return insert.execute()
    }

}