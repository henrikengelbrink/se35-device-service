package se35.device.service.models.entities

import java.util.*

class WashingCycle(
        val machine: WashingMachine,
        val start: Date,
        val end: Date,
        val waterUsage: WaterUsageLiter
): BaseEntity()
