package se35.device.service.repositories

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import se35.device.service.models.interfaces.Device
import java.util.*

@Repository
interface DeviceRepository : CrudRepository<Device, String> {

    fun findById(id: UUID): Device?

}
