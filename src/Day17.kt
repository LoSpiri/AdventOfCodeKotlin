
fun main() {

    fun part1(input: List<String>): Int {

        val x1 = 117
        val x2 = 164
        val y1 = -140
        val y2 = -89

        var maxY = 0
        for(x in -1000..1000){
            for(y in -1000..1000){
                if(x<0 && x1>0) continue

                var position = mutableListOf(0,0)
                var velocity = mutableListOf(x,y)
                var flag = true
                var tempY = 0
                while(flag){

                    position[0] += velocity[0]
                    position[1] += velocity[1]
                    if(velocity[0]>0) {velocity[0]--}
                    else if(velocity[0]<0) {velocity[0]++}
                    velocity[1]--

                    if(position[1]>tempY) tempY = position[1]

                    if((position[0] in x1 until x2) && (position[1] in y1 .. y2)){
                        flag = false
                        if(tempY>maxY) maxY = tempY
                    }
                    else if (position[1]<y1 && velocity[1]<0){
                        flag = false
                    }
                }
            }
        }

        return maxY
    }

    fun part2(input: List<String>): Int {
        val x1 = 117
        val x2 = 164
        val y1 = -140
        val y2 = -89

        var maxY = 0
        for(x in 1..164){
            for(y in -140..3000){

                var position = mutableListOf(0,0)
                var velocity = mutableListOf(x,y)
                var flag = true
                while(flag){

                    position[0] += velocity[0]
                    position[1] += velocity[1]
                    if(velocity[0]>0) {velocity[0]--}
                    else if(velocity[0]<0) {velocity[0]++}
                    velocity[1]--

                    if((position[0] in x1 .. x2) && (position[1] in y1 .. y2)){
                        flag = false
                        maxY++
                    }
                    else if (position[1]<y1 && velocity[1]<0){
                        flag = false
                    }
                }
            }
        }

        return maxY
    }




    val inputTest = readInput("Day17Test")
    //println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day17")
    //println(part1(input))
    //println(part2(input))
}
