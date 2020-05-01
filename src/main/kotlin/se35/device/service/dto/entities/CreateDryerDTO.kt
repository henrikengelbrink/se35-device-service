package se35.device.service.dto.entities

import se35.device.service.dto.interfaces.CreateDeviceDTO
import se35.device.service.models.enums.DeviceType
import se35.device.service.models.enums.DryerModel

data class CreateDryerDTO(
        val model: DryerModel,
        override val type: DeviceType
): CreateDeviceDTO
