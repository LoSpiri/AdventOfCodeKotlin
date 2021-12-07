
import kotlin.math.abs


fun main() {

    fun part1(input: List<String>): Int {
        val arr = input[0].split(",").map{it.toInt()}.sorted()
        val median = arr[arr.size/2]
        var fuel = 0
        for(i in arr){
            fuel += abs(i - median)
        }
        return fuel
    }


    fun part2(input: List<String>): Int {
        val arr = input[0].split(",").map{it.toInt()}
        val media = arr.average().toInt()
        var fuel = 0
        for (i in arr){
            val diff = abs(i - media)
            fuel += (diff*(diff+1))/2
        }
        return fuel
    }





    val inputTest = readInput("Day07Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}
