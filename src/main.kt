fun main() {

    println("Welcome to your garage. Here you can create a collection of the cars you have always wanted.")
    val junkCar = Car("Junker", "Rusty", 23)
    val carGarage = mutableListOf(junkCar)
    var choice = 0

    while (choice != 4) {
        println("Please choose an option\n1. Add a car\n2. Remove a car\n3. View cars\n4. Leave garage")
        print("> ")
        choice = readLine()!!.toInt()
        when (choice) {
            1 -> carGarage.add(addCar())
            2 -> carGarage.removeAt(removeCar(carGarage.size))
            3 -> for (car in carGarage) {
                car.display()
                println("")
            }
            4 -> println("Thank you for using the garage.")
        }
    }
}

fun addCar():Car {
    println("What type of car are you adding to the garage?")
    print("> ")
    val newName = readLine()!!
    println("What color is the car?")
    print("> ")
    val newColor = readLine()!!
    println("How old is the car?")
    print("> ")
    val newAge = readLine()!!.toInt()
    return Car(newName, newColor, newAge)
}

fun removeCar(garageSize: Int):Int {
    println("Which garage slot would you like to empty?")
    print("> ")
    var garageSlot = readLine()!!.toInt()
    while (garageSlot !in 1..garageSize) {
        println("That is not a slot in the garage, please type another number.")
        print("> ")
        garageSlot = readLine()!!.toInt()
    }
    return garageSlot - 1
}

class Car constructor(carType: String, carColor: String, carAge: Int) {
    val type = carType
    val age = carAge
    var color = carColor
    fun display(){
        println("This car is a $color $type.")
        println("It is $age years old.")
    }
}