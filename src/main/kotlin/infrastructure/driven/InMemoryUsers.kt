package com.example.infrastructure.driven

import com.example.application.domain.Name
import com.example.application.domain.User
import com.example.application.domain.UserId
import com.example.application.domain.UserStatus.ACTIVE
import com.example.application.domain.UserStatus.DEACTIVATED
import com.example.application.port.driven.UserFinder

class InMemoryUsers : UserFinder {

    private val users: List<User> = listOf(
        User(UserId(USER_ID_1), Name("Elisa"), ACTIVE),
        User(UserId(USER_ID_2), Name("Carlos"), ACTIVE),
        User(UserId(USER_ID_3), Name("Roberta"), DEACTIVATED)
    )

    override fun findAll(): List<User> = users

    override fun find(userId: UserId): User? = users.find { it.id == userId }
}
