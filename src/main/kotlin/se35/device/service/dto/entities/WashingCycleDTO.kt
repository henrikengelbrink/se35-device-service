package se35.device.service.dto.entities

import java.util.*

data class WashingCycleDTO(
        val id: UUID,
        val start: Date,
        val end: Date,
        val waterUsage: Double
)