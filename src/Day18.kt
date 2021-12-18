

fun explode(string:MutableList<String>, index:Int):MutableList<String>{
    val a = string[index-3].toInt()
    val b = string[index-1].toInt()  //vediamo un po'

    for(i in index-4 downTo 0) { //left
        val num = string[i].toIntOrNull()
        if(num != null){
            string[i] = (num + a).toString()
            break
        }
    }

    for(i in index until string.size) { //right
        val num = string[i].toIntOrNull()
        if(num != null){
            string[i] = (num + b).toString()
            break
        }
    }

    repeat(4){
        string.removeAt(index-4)
    }
    string[index-4] = "0"
    return string
}


fun split(string:MutableList<String>, index:Int): MutableList<String> {
    val num = string[index].toDouble()/2
    string[index] = "]"
    string.add(index, kotlin.math.ceil(num).toInt().toString())
    string.add(index,",")
    string.add(index, kotlin.math.floor(num).toInt().toString())
    string.add(index, "[")
    return string
}


fun reduce(string:String): MutableList<String> {
    var stack = 0
    var flag = true
    var flag2 = false
    var str = string.split("").toMutableList()
    var splits = mutableListOf<Int>()

    while(flag){
        stack = 0
        splits.clear()
        //println(str.joinToString(""))
        for(i in str.indices){
            when {
                str[i] == "[" -> stack++
                str[i] == "]" -> {
                    stack--
                    if(stack>3){
                        str = explode(str,i)
                        break
                    }
                }
                str[i].toIntOrNull()!=null && str[i].toInt()>9 -> {
                    splits.add(i)
                }
            }
            if(i==str.size-1){
                if(splits.isEmpty()){
                    flag = false
                }
                else{
                    str = split(str,splits[0])
                }
            }
        }
    }
    return str
}

fun magnitude(string: MutableList<String>): Int{
    while(true){
        for(i in 0 until string.size-4){
            if( string[i] == "[" && string[i+1].toIntOrNull()!=null && string[i+2] == "," && string[i+3].toIntOrNull()!=null && string[i+4] == "]"){
                val n1 = string[i+1].toInt()
                val n2 = string[i+3].toInt()
                repeat(4) {
                    string.removeAt(i)
                }
                string[i] = (3*n1 + 2*n2).toString()
                break
            }
        }
        if(string.size == 3) break
    }
    return string[1].toInt()
}

fun somma (str12:MutableList<String>, str2:String):MutableList<String> {

    val str22 = reduce(str2)

    str12.add(0,"[")
    str12.add(",")
    str22.add("]")

    return reduce((str12 + str22).joinToString(""))
}




fun main() {

    fun part1(input: List<String>): Int {

        var str1 = reduce(input[0])

        for(i in 1 until input.size){
            var str2 = input[i]
            str1 = somma(str1,str2)
        }

        return magnitude(str1)
    }

    fun part2(input: List<String>): Int {

        var max = 0
        for(i in input.indices){
            val str1 = input[i]
            for(j in i+1 until input.size){
                val str2 = input[j]
                val sum = magnitude(somma(reduce(str1),str2))
                if(sum>max) max = sum
                val sum2 = magnitude(somma(reduce(str2),str1))
                if(sum2>max) max = sum2
            }
        }

        return max
    }




    val inputTest = readInput("Day18Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day18")
    println(part1(input))
    println(part2(input))
}
