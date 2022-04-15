package com.nocdib.dwellings

abstract class Dwelling(private var residents: Int) {

    abstract val name: String
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom() = residents < capacity

    abstract fun floorArea(): Double

    override fun toString() = "============\n${name}\n============\n" +
                                "Capacity: ${capacity}\n" +
                                "Material: ${buildingMaterial}\n" +
                                "Area: ${String.format("%.2f", floorArea())}\n" +
                                "Has room?: ${hasRoom()}\n"

}