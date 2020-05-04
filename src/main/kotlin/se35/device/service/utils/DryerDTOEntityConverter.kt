package se35.device.service.utils

import se35.device.service.dto.entities.CreateDryerDTO
import se35.device.service.dto.entities.DryerDTO
import se35.device.service.dto.interfaces.CreateDeviceDTO
import se35.device.service.models.entities.Dryer
import se35.device.service.models.enums.DeviceType
import se35.device.service.models.interfaces.Device

class DryerDTOEntityConverter: DeviceDTOEntityConverter {

    override fun convertCreateDTOtoEntity(dto: CreateDeviceDTO): Dryer {
        val dryerDTO = dto as CreateDryerDTO
        return Dryer(
                type = DeviceType.DRYER,
                userId = dryerDTO.userId,
                model = dryerDTO.model,
                dryerType = dryerDTO.model.dryerType
        )
    }

    override fun convertEntityToDTO(device: Device): DryerDTO {
        val dryer = device as Dryer
        return DryerDTO(
                id = dryer.id
        )
    }

}
