package com.envel.audit.services

import com.envel.audit.domain.models.AccountActivity
import com.envel.audit.domain.repositories.AccountActivityRepository
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLMutation
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.security.RolesAllowed

@Service
@Transactional
@GraphQLApi
class AccountActivityServiceImpl(val accountActivityRepository: AccountActivityRepository):AccountActivityService {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @GraphQLMutation(name ="save")
    @RolesAllowed("user")
    override fun save(@GraphQLArgument(name = "accountActivity") accountActivity: AccountActivity):AccountActivity{
       val user = SecurityContextHolder.getContext().authentication.principal
        logger.info("Auth: {}",user.toString())
        accountActivity.userId = user.toString()
       return accountActivityRepository.save(accountActivity)
    }

    @GraphQLQuery(name = "findById")
    override fun findById(@GraphQLArgument(name = "accountActivityId")accountActivityId: Long):AccountActivity {
        TODO("Not yet implemented")
    }
}