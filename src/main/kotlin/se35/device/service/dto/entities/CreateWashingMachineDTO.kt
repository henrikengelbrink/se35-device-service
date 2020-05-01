package se35.device.service.dto.entities

import se35.device.service.dto.interfaces.CreateDeviceDTO
import se35.device.service.models.enums.DeviceType
import se35.device.service.models.enums.WashingMachineModel

data class CreateWashingMachineDTO(
        override val type: DeviceType,
        val model: WashingMachineModel,
        val wpsEnabled: Boolean
): CreateDeviceDTO
