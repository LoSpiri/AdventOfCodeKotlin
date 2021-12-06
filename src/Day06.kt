fun main() {

    fun part1(input: List<String>): Long {
        var arr = mutableListOf<Int>()
        input[0].split(",").forEach {arr.add(it.toInt())}
        var count = 0
        for(j in 0..80){
            for(k in 0 until count){
                arr.add(8)
            }
            val iterator = arr.listIterator()
            count = 0
            while(iterator.hasNext()){
                val nxt = iterator.next()
                if(nxt == 0) {
                    iterator.set(6)
                    //arr.add(8)
                    count++
                }
                else {
                    iterator.set(nxt - 1)
                }
            }
        }
        return arr.size.toLong()
    }

    fun part2(input: List<String>): Long {
        var arr = mutableListOf<Int>()
        for (i in input[0].split(",")){
            arr.add(i.toInt())
        }

        var map = arr.groupBy {it}. map {(number,dimension) -> number to dimension.size.toLong()}.toMap().toMutableMap()

        for(i in 0 until 256){
            val new = map.map { (number, dimension) ->
                if(number==0) {6 to dimension}
                else {number-1 to dimension}
                } + (8 to (map[0]?:0))
            map.clear()
            new.forEach { (number,dimension) -> map[number] = (map[number] ?:0) + dimension }
        }

        return map.values.sum()
    }




    val inputTest = readInput("Day06Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
