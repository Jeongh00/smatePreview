package com.smatepreview.smatepreview.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.domain.QApi
import com.smatepreview.smatepreview.domain.Stauts
import com.smatepreview.smatepreview.dto.SearchCondition
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class QApiRepositoryImpl(em: EntityManager?) : QuerydslRepositorySupport(Api::class.java), QApiRepository {

    private val queryFactory: JPAQueryFactory

    init {
        queryFactory = JPAQueryFactory(em)
    }

    override fun search(search: SearchCondition): Api? {

        val m = QApi("m")

        return queryFactory
            .select(m)
            .from(m)
            .where(
                m.bno.eq(search.b_no)
                    .and(m.pnm.eq(search.p_nm))
            )
            .fetchOne()

    }

    override fun saveStatus(stauts: Stauts): Stauts? {

        val m = QStauts("m")

        return queryFactory
            .insert(m)
            .values()

    }

}