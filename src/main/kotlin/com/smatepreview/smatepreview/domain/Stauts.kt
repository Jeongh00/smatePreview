package com.smatepreview.smatepreview.domain

import com.querydsl.core.types.Projections.constructor
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Stauts (

    @Id
    @GeneratedValue
    @Column(name = "statusId")
    var id: Long?,
    @Column(name = "bno")
    var bno: String?,
    @Column(name = "bstt")
    var bstt: String?,
    @Column(name = "taxtype")
    var taxtype: String?){
        constructor(bno: String?, bstt: String?, taxtype: String?): this(null, bno, bstt, taxtype)
    }