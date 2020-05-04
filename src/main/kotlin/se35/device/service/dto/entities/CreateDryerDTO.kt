package se35.device.service.dto.entities

import se35.device.service.dto.interfaces.CreateDeviceDTO
import se35.device.service.models.enums.DeviceType
import se35.device.service.models.enums.DryerModel
import java.util.*

data class CreateDryerDTO(
        override val userId: UUID,
        override val type: DeviceType,
        val model: DryerModel
): CreateDeviceDTO
