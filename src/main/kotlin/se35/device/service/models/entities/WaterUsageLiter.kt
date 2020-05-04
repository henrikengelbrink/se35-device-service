package se35.device.service.models.entities

import se35.device.service.models.interfaces.WaterUsage

class WaterUsageLiter(
        override var waterUsage: Double
): WaterUsage
