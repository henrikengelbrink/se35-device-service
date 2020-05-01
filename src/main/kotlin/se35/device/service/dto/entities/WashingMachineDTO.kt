package se35.device.service.dto.entities

import se35.device.service.dto.interfaces.DeviceDTO
import se35.device.service.models.enums.DeviceType
import java.util.*

data class WashingMachineDTO(
        override val id: UUID,
        val wpsEnabled: Boolean
): DeviceDTO {
    override val type: DeviceType = DeviceType.WASHING_MACHINE
}
