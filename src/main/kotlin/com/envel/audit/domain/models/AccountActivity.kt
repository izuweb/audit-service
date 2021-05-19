package com.envel.audit.domain.models

import io.leangen.graphql.annotations.GraphQLQuery
import javax.persistence.*

@Entity
@Table(name = "ACCOUNT_ACTIVITY",schema = "audit")
data class AccountActivity
    (
    @Id
    @SequenceGenerator(name = "SEQ_GEN",sequenceName = "ACCOUNT_ACTIVITY_SEQUENCE",schema = "AUDIT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_GEN")
    @Column(name = "ACCOUNT_ACTIVITY_ID")
    @GraphQLQuery(name = "accountActivityId")
    var accountActivityId: Long = 0,
): BaseModel(){
    @Column(name = "ACTION")
    @GraphQLQuery(name = "action")
    var action: String? = null

    @Column(name = "ENTITY")
    @GraphQLQuery(name = "entity")
    var entity: String? = null

    @Column(name = "RESOURCE_ID")
    @GraphQLQuery(name = "resourceId")
    var resourceId: String? = null

    @Column(name = "ACTION_PROPERTY")
    @GraphQLQuery(name = "actionProperty")
    var actionProperty: String? = null

    @Column(name = "USER_ID")
    @GraphQLQuery(name = "userId")
    var userId: String? = ""
    constructor(
        action: String?,
        entity: String?,
        resourceId: String?,
        actionProperty: String?,
        userId: String?
    ):this(0){
        this.action = action
        this.entity = entity
        this.resourceId = resourceId
        this.actionProperty = actionProperty
        this.userId = userId
    }

}

