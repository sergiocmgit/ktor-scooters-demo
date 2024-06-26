package com.example.fixtures.builders

import com.example.application.domain.Scooter
import com.example.application.domain.ScooterId
import com.example.application.domain.ScooterStatus
import com.example.application.domain.ScooterStatus.LOCKED
import com.example.application.domain.UserId
import com.example.infrastructure.adapter.input.ScooterDto

const val DEFAULT_SCOOTER_ID: Int = 1

fun buildScooter(
    scooterId: Int = DEFAULT_SCOOTER_ID,
    status: ScooterStatus = LOCKED,
    lastRider: String = DEFAULT_USER_ID,
) = Scooter(
    ScooterId(scooterId),
    status,
    UserId(lastRider),
)

fun buildScooterDto(scooterId: Int = DEFAULT_SCOOTER_ID) =
    ScooterDto(
        scooterId,
        LOCKED,
        DEFAULT_USER_ID,
    )
