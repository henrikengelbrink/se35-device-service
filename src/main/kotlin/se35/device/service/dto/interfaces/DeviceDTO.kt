package se35.device.service.dto.interfaces

import se35.device.service.models.enums.DeviceType
import java.util.*

interface DeviceDTO {
    val id: UUID
    val type: DeviceType
}
