
fun inputToMatrix (input: List<String>): Array<IntArray>{
    var arr = Array(input.size) {IntArray(input[0].length)}
    for (i in input.indices){
        for(j in input[i].indices){
            arr[i][j] = input[i][j].toString().toInt()
        }
    }
    return arr
}

fun basin (arr: Array<IntArray>,x: Int,y: Int): Boolean {
    val basn = arr[x][y]
    if(
            (arr.getOrNull(x+1)?.getOrNull(y)==null || arr[x+1][y]>basn) &&
            (arr.getOrNull(x-1)?.getOrNull(y)==null || arr[x-1][y]>basn) &&
            (arr.getOrNull(x)?.getOrNull(y+1)==null || arr[x][y+1]>basn) &&
            (arr.getOrNull(x)?.getOrNull(y-1)==null || arr[x][y-1]>basn)
    ){
        return true
    }
    return false
}

fun basinAdj (arr: Array<IntArray>,x: Int,y: Int, count: IntArray, seen: MutableSet<Pair<Int,Int>>){
    val basn = arr[x][y]

    if(arr.getOrNull(x+1)?.getOrNull(y)!=null && arr[x+1][y]>basn && arr[x+1][y]<9){
        basinAdj(arr,x+1,y, count,seen)
    }
    if(arr.getOrNull(x-1)?.getOrNull(y)!=null && arr[x-1][y]>basn && arr[x-1][y]<9){
        basinAdj(arr,x-1,y,count,seen)
    }
    if(arr.getOrNull(x)?.getOrNull(y+1)!=null && arr[x][y+1]>basn && arr[x][y+1]<9){
        basinAdj(arr,x,y+1,count,seen)
    }
    if(arr.getOrNull(x)?.getOrNull(y-1)!=null && arr[x][y-1]>basn && arr[x][y-1]<9){
        basinAdj(arr,x,y-1,count,seen)
    }
    if(!seen.contains(Pair(x,y))){
        count[0]++
        seen.add(Pair(x,y))
    }
}

fun main() {

    fun part1(input: List<String>): Int {
        var arr = inputToMatrix(input)
        var count = 0
        for(i in arr.indices){
            for(j in arr[i].indices){
                if(basin(arr,i,j)){
                    count += arr[i][j] + 1
                }
            }
        }
        return count
    }


    fun part2(input: List<String>): Int {
        var arr = inputToMatrix(input)
        var count = IntArray(1) {0}
        var res = mutableListOf<Int>()
        var seen = mutableSetOf<Pair<Int,Int>>()

        for(i in arr.indices){
            for(j in arr[i].indices){
                if(basin(arr,i,j)){
                    seen.clear()
                    count[0] = 0
                    basinAdj(arr,i,j,count,seen)
                    res.add(count[0])
                }
            }
        }
        return res.sorted().takeLast(3).fold(1){total,it -> total*it}
    }

    val inputTest = readInput("Day09Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day09")
    println(part1(input))
    println(part2(input))
}