package se35.device.service.repositories

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import se35.device.service.models.entities.WashingCycle
import se35.device.service.models.interfaces.Device
import se35.device.service.models.projection.WashingCycleFlyweight
import java.util.*

@Repository
interface WashingCycleRepository : CrudRepository<WashingCycle, String> {

    fun findByMachineId(machineId: UUID): List<WashingCycle>
    fun findByMachineIdProjection(machineId: UUID): List<WashingCycleFlyweight>

}
