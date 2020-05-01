package se35.device.service.models.enums

enum class DryerModel(val dryerType: DryerType) {
    D_2020_1(DryerType.CONDENSATION),
    D_2020_2(DryerType.EXHAUST_AIR),
}
