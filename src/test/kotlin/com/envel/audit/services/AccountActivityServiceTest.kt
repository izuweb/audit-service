package com.envel.audit.services

import com.envel.audit.domain.models.AccountActivity
import com.envel.audit.domain.repositories.AccountActivityRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.context.support.WithSecurityContext
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig
internal class AccountActivityServiceTest {

    @MockBean
    lateinit var accountActivityRepository: AccountActivityRepository
    var accountActivityService: AccountActivityService? = null

    @BeforeEach
    fun init(){
        accountActivityService = AccountActivityServiceImpl(accountActivityRepository)
    }

    @Test
    @WithMockUser
    fun saveAccountActivity() {
        Mockito.`when`(accountActivityRepository.save(any()))
            .thenReturn(AccountActivity("Deposit","Account","","","fr63hdj"))
        val accountActivity = accountActivityService?.save(
            AccountActivity(
                "Deposit",
                "Account",
                "11054867",
                "1400.67",
                "fa1f70f5-fb6a-4c90-9e3d-ceee4f22a44e"
            )
        )
        assertNotNull(accountActivity)
    }
}