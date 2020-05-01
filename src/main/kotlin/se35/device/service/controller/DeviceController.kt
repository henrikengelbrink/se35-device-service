package se35.device.service.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import se35.device.service.dto.entities.CreateWashingMachineDTO
import se35.device.service.dto.interfaces.DeviceDTO
import se35.device.service.models.interfaces.Device
import se35.device.service.services.DeviceService
import javax.inject.Inject

@Controller("/devices")
class DeviceController {

    @Inject
    private lateinit var deviceService: DeviceService

    @Post(produces = [MediaType.APPLICATION_JSON])
    fun postDevices(
            @Body body: CreateWashingMachineDTO
    ): HttpResponse<Device> {
        val newDevice = deviceService.createDevice(body)
        return HttpResponse.ok(newDevice)
    }

    @Get(value = "/{deviceId}", produces = [MediaType.APPLICATION_JSON])
    fun getDevice(
            @PathVariable deviceId: String
    ): HttpResponse<DeviceDTO> {
        val deviceDTO = deviceService.getDevice(deviceId)
        return HttpResponse.ok(deviceDTO)
    }

    @Get(value = "/{deviceId}", produces = [MediaType.APPLICATION_JSON])
    fun cloneDevice(
            @PathVariable deviceId: String
    ): HttpResponse<DeviceDTO> {
        val deviceDTO = deviceService.cloneDevice(deviceId)
        return HttpResponse.ok(deviceDTO)
    }

}