package se35.device.service.services

import se35.device.service.dto.interfaces.CreateDeviceDTO
import se35.device.service.dto.interfaces.DeviceDTO
import se35.device.service.exceptions.APIException
import se35.device.service.exceptions.APIExceptionCode
import se35.device.service.models.entities.WashingMachine
import se35.device.service.models.enums.DeviceType
import se35.device.service.models.enums.WashingMachineModel
import se35.device.service.models.interfaces.Device
import se35.device.service.repositories.DeviceRepository
import se35.device.service.utils.DeviceDTOEntityConverter
import java.util.*
import javax.inject.Inject

class DeviceService {

    @Inject
    private lateinit var deviceRepository: DeviceRepository

    fun createDevice(createDTO: CreateDeviceDTO): Device {
        val converter = DeviceDTOEntityConverter.createConverter(createDTO.type)
        val device = converter.convertCreateDTOtoEntity(createDTO)
        return deviceRepository.save(device)
    }

    fun getDevice(deviceId: String): DeviceDTO {
        val device: Device = getDeviceEntity(deviceId)
        val converter = DeviceDTOEntityConverter.createConverter(device.type)
        return converter.convertEntityToDTO(device)
    }

    fun cloneDevice(deviceId: String): DeviceDTO {
        val device: Device = getDeviceEntity(deviceId)
        var newDevice = device.clone()
        newDevice = deviceRepository.save(newDevice)
        val converter = DeviceDTOEntityConverter.createConverter(newDevice.type)
        return converter.convertEntityToDTO(newDevice)
    }

    private fun getDeviceEntity(deviceId: String): Device {
        val uuid = UUID.fromString(deviceId)
        val device = deviceRepository.findById(uuid)
        if (device != null) {
            return device
        } else {
            throw APIException(APIExceptionCode.DEVICE_NOT_FOUND)
        }
    }

}