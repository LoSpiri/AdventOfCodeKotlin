fun main() {
    fun part1(input: List<String>): Int {
        var res = 0
        for(i in 1 until input.size){
            if(input[i].toInt()>input[i-1].toInt()){
                res++
            }
        }
        return res
    }

    fun part2(input: List<String>): Int {
        var res = 0
        for(i in 3 until input.size){
            if(input[i].toInt()>input[i-3].toInt()){
                res++
            }
        }
        return res
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
