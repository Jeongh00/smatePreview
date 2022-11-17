package com.smatepreview.smatepreview.domain

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Getter
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id


//@Entity
//@Getter
//@Setter
//class Api {
//    @Id
//    @GeneratedValue
//    @JsonProperty("apiId")
//    @Column(name = "apiId")
//    private val id: Long? = null
//
//    @JsonProperty("bno")
//    @Column(name = "bno")
//    private val bno: String? = null
//
//    @JsonProperty("pnm")
//    @Column(name = "pnm")
//    private val pnm: String? = null
//
//    @JsonProperty("corpno")
//    @Column(name = "corpno")
//    private val corpno: String? = null
//}

@Entity
data class Api(
    @Id
    @GeneratedValue
    @Column(name = "apiId")
    var id: Long?,
    @Column(name = "bno")
    var bno: String?,
    @Column(name = "pnm")
    var pnm: String?,
    @Column(name = "corpno")
    var corpno: String?) {
    constructor(bno: String?, pnm: String?, corpno: String?): this(null, bno, pnm, corpno)
}