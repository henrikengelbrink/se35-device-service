package se35.device.service.dto.interfaces

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import se35.device.service.models.enums.DeviceType
import se35.device.service.utils.CreateDeviceDTODeserializer
import java.util.*

@JsonDeserialize(using = CreateDeviceDTODeserializer::class)
interface CreateDeviceDTO {
    val type: DeviceType
    val userId: UUID
}
