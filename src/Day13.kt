fun main() {

    fun part1(input: List<String>): Int {

        var maxx = 0
        var maxy = 0

        for(i in 0 until input.indexOf("")){
            val pair = input[i].split(",")
            if(pair[0].toInt()>maxx) {maxx = pair[0].toInt()}
            if(pair[1].toInt()>maxy) {maxy = pair[1].toInt()}
        }
        val matrix = Array(maxy+1) {IntArray(maxx+1) {0} }

        for(i in 0 until input.indexOf("")){
            val pair = input[i].split(",")
            matrix [pair[1].toInt()][pair[0].toInt()] = 1
        }

        val cmd = input[input.indexOf("")+1]
        val lineNum = cmd.substring(cmd.indexOf("=")+1).toInt()
        val coordinate = cmd[cmd.indexOf("=")-1]

        if(coordinate == 'y') {
            for (y in lineNum+1 .. maxy) {
                for (x in 0..maxx) {
                    if (matrix[y][x] == 1) {
                        val diff = y - lineNum
                        matrix[lineNum - diff][x] = 1
                    }
                }
            }
            maxy = lineNum
        }
        else if(coordinate == 'x'){
            for (y in 0 .. maxy) {
                for (x in lineNum+1 .. maxx) {
                    if (matrix[y][x] == 1) {
                        val diff = x - lineNum
                        matrix[y][lineNum-diff] = 1
                    }
                }
            }
            maxx = lineNum
        }

        var count = 0
        for(i in 0 .. maxy){
            for(j in 0 .. maxx){
                if(matrix[i][j]==1) count++
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var maxx = 0
        var maxy = 0

        for(i in 0 until input.indexOf("")){
            val pair = input[i].split(",")
            if(pair[0].toInt()>maxx) {maxx = pair[0].toInt()}
            if(pair[1].toInt()>maxy) {maxy = pair[1].toInt()}
        }
        val matrix = Array(maxy+1) {IntArray(maxx+1) {0} }

        for(i in 0 until input.indexOf("")){
            val pair = input[i].split(",")
            matrix [pair[1].toInt()][pair[0].toInt()] = 1
        }

        for(k in input.indexOf("")+1 until input.size) {
            val cmd = input[k]
            val lineNum = cmd.substring(cmd.indexOf("=") + 1).toInt()
            val coordinate = cmd[cmd.indexOf("=") - 1]

            if (coordinate == 'y') {
                for (y in lineNum + 1..maxy) {
                    for (x in 0..maxx) {
                        if (matrix[y][x] == 1) {
                            val diff = y - lineNum
                            matrix[lineNum - diff][x] = 1
                        }
                    }
                }
                maxy = lineNum
            } else if (coordinate == 'x') {
                for (y in 0..maxy) {
                    for (x in lineNum + 1..maxx) {
                        if (matrix[y][x] == 1) {
                            val diff = x - lineNum
                            matrix[y][lineNum - diff] = 1
                        }
                    }
                }
                maxx = lineNum
            }
        }
        for(i in 0..maxy){
            for(j in 0..maxx){
                print(if(matrix[i][j]==1) "█" else "░") //Cambiato caratteri con questi trovati su reddit dopo essere quasi diventato cieco la prima volta
            }
            println()
        }
        return 0
    }




    val inputTest = readInput("Day13Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day13")
    println(part1(input))
    println(part2(input))
}
