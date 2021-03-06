package se35.device.service.models.entities

import se35.device.service.models.enums.DeviceType
import se35.device.service.models.enums.DryerModel
import se35.device.service.models.enums.DryerType
import se35.device.service.models.interfaces.Device
import java.util.*

class Dryer(
        override val userId: UUID,
        override val type: DeviceType,
        val model: DryerModel,
        val dryerType: DryerType
): BaseEntity(), Device
