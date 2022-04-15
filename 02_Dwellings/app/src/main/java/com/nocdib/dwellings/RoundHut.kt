package com.nocdib.dwellings

import java.lang.Math.PI
import java.lang.Math.pow

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents){

    override val name = "Round Hut"
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * pow(radius, 2.0)
    }

}