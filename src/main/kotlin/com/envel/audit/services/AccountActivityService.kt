package com.envel.audit.services

import com.envel.audit.domain.models.AccountActivity

interface AccountActivityService {
    fun save(accountActivity: AccountActivity): AccountActivity
    fun findById(accountActivityId: Long):AccountActivity
}