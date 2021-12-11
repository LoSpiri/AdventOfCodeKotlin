fun flash (arr:Array<IntArray>, x:Int, y:Int){
    if(arr.getOrNull(x+1)?.getOrNull(y)!=null){
        arr[x+1][y]++
        if(arr[x+1][y]==10){flash(arr,x+1,y)}
    }
    if(arr.getOrNull(x-1)?.getOrNull(y)!=null){
        arr[x-1][y]++
        if(arr[x-1][y]==10){flash(arr,x-1,y)}
    }
    if(arr.getOrNull(x)?.getOrNull(y+1)!=null){
        arr[x][y+1]++
        if(arr[x][y+1]==10){flash(arr,x,y+1)}
    }
    if(arr.getOrNull(x)?.getOrNull(y-1)!=null){
        arr[x][y-1]++
        if(arr[x][y-1]==10){flash(arr,x,y-1)}
    }
    if(arr.getOrNull(x+1)?.getOrNull(y+1)!=null){
        arr[x+1][y+1]++
        if(arr[x+1][y+1]==10){flash(arr,x+1,y+1)}
    }
    if(arr.getOrNull(x-1)?.getOrNull(y-1)!=null){
        arr[x-1][y-1]++
        if(arr[x-1][y-1]==10){flash(arr,x-1,y-1)}
    }
    if(arr.getOrNull(x+1)?.getOrNull(y-1)!=null){
        arr[x+1][y-1]++
        if(arr[x+1][y-1]==10){flash(arr,x+1,y-1)}
    }
    if(arr.getOrNull(x-1)?.getOrNull(y+1)!=null){
        arr[x-1][y+1]++
        if(arr[x-1][y+1]==10){flash(arr,x-1,y+1)}
    }
}

fun step (arr:Array<IntArray>){
    for(i in arr.indices){
        for(j in arr[i].indices){
            arr[i][j]++
            if(arr[i][j]==10){
                flash(arr,i,j)
            }
        }
    }
}


fun main() {

    fun part1(input: List<String>): Int {

        var arr = Array(10) {IntArray(10)}
        for (i in input.indices){
            for(j in input[i].indices){
                arr[i][j] = input[i][j].toString().toInt()
            }
        }

        var count = 0
        repeat(100){
            step(arr)
            for(i in arr.indices){
                for(j in arr[i].indices){
                    if(arr[i][j]>9){
                        count++
                        arr[i][j] = 0
                    }
                }
            }
        }

        return count
    }

    fun part2(input: List<String>): Int {
        var arr = Array(10) {IntArray(10)}
        for (i in input.indices){
            for(j in input[i].indices){
                arr[i][j] = input[i][j].toString().toInt()
            }
        }

        var count = 0
        var iter = 1
        while(true){
            count = 0
            step(arr)
            for(i in arr.indices){
                for(j in arr[i].indices){
                    if(arr[i][j]>9){
                        count++
                        arr[i][j] = 0
                    }
                }
            }
            if(count == 100){
                return iter
            }
            iter++
        }
        return 0
    }




    val inputTest = readInput("Day11Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day11")
    println(part1(input))
    println(part2(input))
}
