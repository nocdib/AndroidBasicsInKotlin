package com.nocdib.dwellings

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents){

    override val name = "Square Cabin"
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea() = Math.pow(length, 2.0)

}