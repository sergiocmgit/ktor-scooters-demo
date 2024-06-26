package com.example.application.domain

import com.example.application.domain.UserStatus.ACTIVE
import com.example.application.domain.UserStatus.DEACTIVATED
import com.example.fixtures.isLeftWith
import com.example.fixtures.isRightWith
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserTest {
    @Test
    fun `should check User is active`() {
        // Given
        val user = User(UserId("A"), Name("Eli"), ACTIVE)
        // When
        val result = user.checkIsActive()
        // Then
        assertThat(result).isRightWith(user)
    }

    @Test
    fun `should check User is not active`() {
        // Given
        val user = User(UserId("A"), Name("Eli"), DEACTIVATED)
        // When
        val result = user.checkIsActive()
        // Then
        assertThat(result).isLeftWith(UserInvalidStatus)
    }
}
