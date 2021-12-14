

fun <K> increment(map: MutableMap<K, Long>, key: K) {                         // The one below is a better version of this I found online
    if (map.computeIfPresent(key, { _, v -> v + 1.toLong() }) == null) {      // But I still like to keep this one also
        map[key] = 1.toLong()
    }
}

fun <T> MutableMap<T, Long>.inc(k: T, i: Long = 1) = set(k, get(k)?.plus(i) ?: i)
fun <T> MutableMap<T, Long>.dec(k: T, i: Long) = set(k, get(k)?.minus(i) ?: error(""))


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

        val pairs: MutableMap<Pair<Char, Char>, Char> = mutableMapOf()
        var template: MutableMap<Pair<Char, Char>, Long> = mutableMapOf()

        input.forEach { line ->
            if (line.indexOf(">") > 0) {
                line.split(" -> ").let { x -> pairs[x[0][0] to x[0][1]] = x[1][0] }
            } else if (line != "") {
                for (i in 0 until line.length - 1) {
                    template.inc(line[i] to line[i + 1])
                }
            }
        }

        repeat(40) {
            val t = template.toMutableMap()
            for (pair in pairs) {
                val quantity = template[pair.key] ?: 0
                if (quantity > 0) {
                    t.dec(pair.key, quantity)
                    t.inc(pair.key.first to pair.value, quantity)
                    t.inc(pair.value to pair.key.second, quantity)
                }
            }
            template = t
        }

        val letters = mutableMapOf<Char, Long>()
        for (e in template) {
            letters.inc(e.key.first, e.value)
        }
        letters.map { it.value }.let {
            return (it.maxOrNull()!! - it.minOrNull()!! - 1)
        }
        return 0
    }

    val inputTest = readInput("Day14Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day14")
    println(part1(input))
    println(part2(input))
}
