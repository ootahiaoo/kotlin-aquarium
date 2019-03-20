package Exercices.Buildings


fun main(args: Array<String>){
    Building(Wood()).build()
}

open class BaseBuildingMaterial{
    open val numberNeeded = 1
}

class Wood : BaseBuildingMaterial(){
    override val numberNeeded = 4
}

class Brick : BaseBuildingMaterial(){
    override val numberNeeded = 8
}

class Building<out T: BaseBuildingMaterial>(val buildingMaterial: T){
    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = baseMaterialsNeeded * (buildingMaterial.numberNeeded)

    fun build(){
        println("The type is ${buildingMaterial::class.simpleName} and it requires $actualMaterialsNeeded number of materials.")
    }
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>){
    if(building.actualMaterialsNeeded < 500) println("small building")
    else println("large building")
}