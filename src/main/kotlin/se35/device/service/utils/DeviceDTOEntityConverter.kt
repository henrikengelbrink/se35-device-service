package se35.device.service.utils

import se35.device.service.dto.interfaces.CreateDeviceDTO
import se35.device.service.dto.interfaces.DeviceDTO
import se35.device.service.models.enums.DeviceType
import se35.device.service.models.interfaces.Device

interface DeviceDTOEntityConverter {

    fun convertCreateDTOtoEntity(dto: CreateDeviceDTO): Device
    fun convertEntityToDTO(device: Device): DeviceDTO

    companion object {
        fun createConverter(type: DeviceType): DeviceDTOEntityConverter = when (type) {
            DeviceType.WASHING_MACHINE -> WashingMachineDTOEntityConverter()
            DeviceType.DRYER  -> DryerDTOEntityConverter()
        }
    }

}
