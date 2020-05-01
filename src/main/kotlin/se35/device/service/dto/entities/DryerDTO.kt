package se35.device.service.dto.entities

import se35.device.service.dto.interfaces.DeviceDTO
import se35.device.service.models.enums.DeviceType
import java.util.*

data class DryerDTO(
        override val id: UUID
): DeviceDTO {
    override val type: DeviceType = DeviceType.DRYER
}
