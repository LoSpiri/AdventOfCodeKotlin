import java.util.ArrayDeque

fun main() {

    fun part1(input: List<String>): Int {
        var count = 0
        for (i in input) {
            val arr = i.toCharArray()
            var stack = ArrayDeque<Char>()
            for (j in arr) {
                when (j) {
                    '(' -> stack.push(j)
                    '[' -> stack.push(j)
                    '{' -> stack.push(j)
                    '<' -> stack.push(j)
                    ')' -> if (stack.pop() != '(') {
                        count += 3;break
                    }
                    ']' -> if (stack.pop() != '[') {
                        count += 57;break
                    }
                    '}' -> if (stack.pop() != '{') {
                        count += 1197;break
                    }
                    '>' -> if (stack.pop() != '<') {
                        count += 25137;break
                    }
                }
            }
        }
        return count
    }

    fun part2(input: List<String>): Long {
        var count: Long = 0
        var res = mutableListOf<Long>()
        for (i in input) {
            val arr = i.toCharArray()
            var stack = ArrayDeque<Char>()
            var flag = true
            count = 0.toLong()
            for (j in arr) {
                when (j) {
                    '(' -> stack.push(j)
                    '[' -> stack.push(j)
                    '{' -> stack.push(j)
                    '<' -> stack.push(j)
                    ')' -> if (stack.pop() != '(') {
                        flag = false; break
                    }
                    ']' -> if (stack.pop() != '[') {
                        flag = false; break
                    }
                    '}' -> if (stack.pop() != '{') {
                        flag = false; break
                    }
                    '>' -> if (stack.pop() != '<') {
                        flag = false; break
                    }
                }
            }
            if (!flag) continue
            while (!stack.isEmpty()) {
                when (stack.pop()) {
                    '(' -> count = count * 5 + 1
                    '[' -> count = count * 5 + 2
                    '{' -> count = count * 5 + 3
                    '<' -> count = count * 5 + 4
                }
            }
            res.add(count)
        }
        res.sort()
        println(res)
        println(res.size)
        val mid = res.size/2
        return res[mid]
    }


    val inputTest = readInput("Day10Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day10")
    println(part1(input))
    println(part2(input))
}
