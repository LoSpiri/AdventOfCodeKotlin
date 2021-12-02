fun main() {

    fun part1(input: List<String>): Int {
        var horiz = 0
        var depth = 0
        for(i in input){
            val cmd = i.split(" ")
            when(cmd[0]){
                "forward" -> horiz += cmd[1].toInt()
                "down"    -> depth += cmd[1].toInt()
                "up"      -> depth -= cmd[1].toInt()
            }
        }
        return horiz*depth
    }

    fun part2(input: List<String>): Int {
        var horiz = 0
        var depth = 0
        var aim = 0
        for(i in input){
            val cmd = i.split(" ")
            when(cmd[0]){
                "forward" -> {
                    horiz += cmd[1].toInt()
                    depth += cmd[1].toInt()*aim
                }
                "down"    -> aim += cmd[1].toInt()
                "up"      -> aim -= cmd[1].toInt()
            }
        }
        return horiz*depth
    }




    val inputTest = readInput("Day02Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
