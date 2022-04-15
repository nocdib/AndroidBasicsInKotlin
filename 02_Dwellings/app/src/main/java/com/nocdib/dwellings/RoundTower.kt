package com.nocdib.dwellings

class RoundTower(residents: Int, radius: Double, val floors: Int=2) : RoundHut(residents, radius) {

    override val name = "Round Tower"
    override val buildingMaterial = "Stone"
    override val capacity = 4

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}