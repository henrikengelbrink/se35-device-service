package se35.device.service.dto.entities

import se35.device.service.dto.interfaces.CreateDeviceDTO
import se35.device.service.models.enums.DeviceType
import se35.device.service.models.enums.WashingMachineModel
import java.util.*

data class CreateWashingMachineDTO(
        override val type: DeviceType,
        override val userId: UUID,
        val model: WashingMachineModel,
        val wpsEnabled: Boolean
): CreateDeviceDTO
