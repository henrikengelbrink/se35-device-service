package se35.device.service.models.entities

import se35.device.service.models.interfaces.WaterUsage

class WaterUsageGallon(
        var waterUsageLiter: WaterUsageLiter
): WaterUsage {

    override var waterUsage: Double
        get() = convertLiterToGallon(waterUsageLiter.waterUsage)
        set(waterUsageGallon) {
            waterUsageLiter.waterUsage = convertGallonToLiter(waterUsageGallon)
        }

    private fun convertGallonToLiter(gallonUsage: Double): Double = gallonUsage * 3.7854
    private fun convertLiterToGallon(literUsage: Double): Double = literUsage * 0.264172052358148

}
