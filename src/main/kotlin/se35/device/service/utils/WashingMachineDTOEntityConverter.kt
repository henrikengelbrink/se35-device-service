package se35.device.service.utils

import se35.device.service.dto.entities.CreateWashingMachineDTO
import se35.device.service.dto.entities.WashingMachineDTO
import se35.device.service.dto.interfaces.CreateDeviceDTO
import se35.device.service.dto.interfaces.DeviceDTO
import se35.device.service.models.entities.WashingMachine
import se35.device.service.models.enums.DeviceType
import se35.device.service.models.interfaces.Device
import java.util.*

class WashingMachineDTOEntityConverter: DeviceDTOEntityConverter {

    override fun convertCreateDTOtoEntity(dto: CreateDeviceDTO): WashingMachine {
        val washingMachineDTO = dto as CreateWashingMachineDTO
        return WashingMachine(
                type = DeviceType.WASHING_MACHINE,
                userId = washingMachineDTO.userId,
                model = washingMachineDTO.model,
                wpsEnabled = washingMachineDTO.wpsEnabled,
                location = Locale.GERMANY
        )
    }

    override fun convertEntityToDTO(device: Device): DeviceDTO {
        val washingMachine = device as WashingMachine
        return WashingMachineDTO(
                id = washingMachine.id,
                wpsEnabled = washingMachine.wpsEnabled
        )
    }

}
