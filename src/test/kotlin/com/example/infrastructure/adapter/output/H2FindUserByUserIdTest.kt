package com.example.infrastructure.adapter.output

import com.example.application.domain.UserId
import com.example.application.domain.UserNotFound
import com.example.fixtures.DatabaseUtils.Companion.save
import com.example.fixtures.builders.buildUser
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchException
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class H2FindUserByUserIdTest : H2Test {
    private val h2FindUserByUserId = H2FindUserByUserId()

    private val storedUser = buildUser()

    @BeforeEach
    fun beforeEach() {
        transaction { UserTable.deleteAll() }
    }

    @Test
    fun `should find a user`() {
        // Given
        save(storedUser)
        // When
        val result = h2FindUserByUserId(storedUser.id)
        // Then
        assertThat(result).isEqualTo(storedUser)
    }

    @Test
    fun `should fail when cannot find user`() {
        // When
        val result = catchException { h2FindUserByUserId(UserId("some-id")) }
        // Then
        assertThat(result).isEqualTo(UserNotFound)
    }
}
