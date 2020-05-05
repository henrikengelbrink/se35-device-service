package se35.device.service.models.projection

import se35.device.service.models.entities.WaterUsageLiter
import java.util.*

interface WashingCycleFlyweight {
    val id: UUID
    val start: Date
    val end: Date
    val waterUsage: WaterUsageLiter
}
