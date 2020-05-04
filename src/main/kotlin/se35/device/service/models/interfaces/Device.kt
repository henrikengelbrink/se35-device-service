package se35.device.service.models.interfaces

import se35.device.service.models.enums.DeviceType
import java.util.*

interface Device: Cloneable {
    var id: UUID
    val type: DeviceType
    val userId: UUID

    public override fun clone(): Device {
        val device = super.clone() as Device
        return device.apply { id = UUID.randomUUID() }
    }

}
