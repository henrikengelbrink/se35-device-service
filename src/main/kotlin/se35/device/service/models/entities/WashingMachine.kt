package se35.device.service.models.entities

import se35.device.service.models.enums.DeviceType
import se35.device.service.models.enums.WashingMachineModel
import se35.device.service.models.interfaces.Device
import java.util.*

class WashingMachine(
        override val userId: UUID,
        override val type: DeviceType,
        val model: WashingMachineModel,
        val wpsEnabled: Boolean,
        val location: Locale
): BaseEntity(), Device
