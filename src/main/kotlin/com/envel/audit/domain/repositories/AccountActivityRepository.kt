package com.envel.audit.domain.repositories;

import com.envel.audit.domain.models.AccountActivity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountActivityRepository : JpaRepository<AccountActivity, Long> {
}