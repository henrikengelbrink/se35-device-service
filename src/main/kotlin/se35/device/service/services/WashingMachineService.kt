package se35.device.service.services

import se35.device.service.dto.entities.WashingCycleDTO
import se35.device.service.models.entities.WashingMachine
import se35.device.service.models.entities.WaterUsageGallon
import se35.device.service.repositories.WashingCycleRepository
import java.util.*
import javax.inject.Inject

class WashingMachineService {

    @Inject
    private lateinit var washingCycleRepository: WashingCycleRepository

    fun loadWashingMachineCyclesForMachine(machine: WashingMachine): List<WashingCycleDTO> {
        val allCycles = washingCycleRepository.findByMachineIdProjection(machineId = machine.id)
        val allCycleDTOs = mutableListOf<WashingCycleDTO>()
        for (cycle in allCycles) {
            var waterUsage = cycle.waterUsage.waterUsage
            if (machine.location == Locale.US) {
                waterUsage = WaterUsageGallon(cycle.waterUsage).waterUsage
            }
            allCycleDTOs.add(WashingCycleDTO(
                    id = cycle.id,
                    start = cycle.start,
                    end = cycle.end,
                    waterUsage = waterUsage
            ))
        }
        return allCycleDTOs
    }

}