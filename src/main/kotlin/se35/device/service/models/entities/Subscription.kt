package se35.device.service.models.entities

import se35.device.service.models.enums.PaymentType
import java.util.*

class Subscription private constructor(
        val payment: PaymentType,
        val yearlyPayments: Boolean,
        val advancedGuaranteeUntil: Date,
        val supplementFlat: Boolean,
        val predictiveMaintenance: Boolean,
        val serviceFlatLevel: Int
): BaseEntity() {

    data class Builder(
            var payment: PaymentType? = null,
            var yearlyPayments: Boolean? = null,
            var advancedGuaranteeUntil: Date? = null,
            var supplementFlat: Boolean? = null,
            var predictiveMaintenance: Boolean? = null,
            var serviceFlatLevel: Int? = null
    ) {
        fun payment(payment: PaymentType) = apply {
            this.payment = payment
        }
        fun yearlyPayments(yearlyPayments: Boolean) = apply {
            this.yearlyPayments = yearlyPayments
        }
        fun advancedGuaranteeUntil(advancedGuaranteeUntil: Date) = apply {
            this.advancedGuaranteeUntil = advancedGuaranteeUntil
        }
        fun supplementFlat(supplementFlat: Boolean) = apply {
            this.supplementFlat = supplementFlat
        }
        fun predictiveMaintenance(predictiveMaintenance: Boolean) = apply {
            this.predictiveMaintenance = predictiveMaintenance
        }
        fun serviceFlatLevel(serviceFlatLevel: Int) = apply {
            this.serviceFlatLevel = serviceFlatLevel
        }
    }

}

/*

    Usage:

    val subscription = Subscription.Builder()
         .payment(PaymentType.CREDIT_CARD)
         .supplementFlat(true)
         .serviceFlatLevel(2)

 */
