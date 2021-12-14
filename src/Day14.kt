
fun <K> increment(map: MutableMap<K, Long>, key: K) {
    if (map.computeIfPresent(key, { _, v -> v + 1.toLong() }) == null) {
        map[key] = 1.toLong()
    }
}

fun main() {

    fun part1(input: List<String>): Int {
        var template = input[0]
        var map = mutableMapOf<String, String>()
        for (i in 2 until input.size) {
            val recipe = input[i].split(" -> ")
            map[recipe[0]] = recipe[1]
        }

        var res = mutableListOf<String>()

        repeat(10) {
            res.clear()
            res.add(template[0].toString())
            for (j in 0 until template.length - 1) {
                res.add(map[template.substring(j, j + 2)]!!)
                res.add(template[j + 1].toString())
            }
            template = res.joinToString("")
        }

        val numByElem = res.groupingBy { it }.eachCount()
        val mostCommon = numByElem.maxByOrNull { it.value }?.value ?: -1
        val leastCommon = numByElem.minByOrNull { it.value }?.value ?: -1

        return mostCommon - leastCommon
    }

    fun part2(input: List<String>): Long {
        var template = input[0]
        var map = mutableMapOf<String, String>()
        for (i in 2 until input.size) {
            val recipe = input[i].split(" -> ")
            map[recipe[0]] = recipe[1]
        }

        var mapRes = mutableMapOf<Char, Long>()
        var res = StringBuilder()

        val windows = template.windowed(2, 1)
        for (i in windows) {

            template = i
            repeat(20) {
                res.clear()
                res.append(template[0])
                for (j in 0 until template.length - 1) {
                    res.append(map[template.substring(j, j + 2)]!!)
                    res.append(template[j + 1])
                }
                template = res.toString()
            }

            val windowed = template.windowed(2, 1)
            for (h in windowed) {
                template = h
                repeat(20) {
                    res.clear()
                    res.append(template[0])
                    for (j in 0 until template.length - 1) {
                        res.append(map[template.substring(j, j + 2)]!!)
                        res.append(template[j + 1])
                    }
                    template = res.toString()
                }
                for (k in res) {
                    increment(mapRes, k)

                }
            }
        }
        val mostCommon = mapRes.maxByOrNull { it.value }?.value ?: -1
        val leastCommon = mapRes.minByOrNull { it.value }?.value ?: -1

        return mostCommon - leastCommon
    }







    val inputTest = readInput("Day14Test")
    println(part1(inputTest))
    //println(part2(inputTest))

    val input = readInput("Day14")
    println(part1(input))
    println(part2(input))
}
