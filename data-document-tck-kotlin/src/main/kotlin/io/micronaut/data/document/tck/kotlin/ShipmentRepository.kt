package io.micronaut.data.document.tck.kotlin

import io.micronaut.data.document.tck.entities.Shipment
import io.micronaut.data.document.tck.entities.ShipmentId
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface ShipmentRepository : KotlinCrudRepository<Shipment, ShipmentId> {

    fun findByShipmentIdCountry(country: String): Shipment?

    fun findByShipmentIdCountryAndShipmentIdCity(country: String, city: String): Shipment?
}
