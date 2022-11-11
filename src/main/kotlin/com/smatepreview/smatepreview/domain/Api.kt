package com.smatepreview.smatepreview.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
class Api {
    @Id
    @GeneratedValue
    @Column(name = "keyId")
    var id: id,

}