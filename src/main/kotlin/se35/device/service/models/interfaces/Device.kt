package se35.device.service.models.interfaces

import se35.device.service.models.enums.DeviceType
import java.util.*

interface Device: Cloneable {
    val id: UUID
    val type: DeviceType
}
