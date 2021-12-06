import java.lang.Integer.max
import java.lang.Integer.min
import java.util.Collections.swap

fun main() {

    fun part1(input: List<String>): Int {

        val arr = mutableListOf<MutableList<Int>>()
        for(i in 0..999){
            arr.add(mutableListOf())
            for(j in 0..999){
                arr[i].add(0)
            }
        }

        for(i in input){
            val str = i.replace(" -> ",",").split(",").map{it.toInt()}
            //swap
            if(str[0]>str[2]){
                swap(str,0,2)
            }
            if(str[1]>str[3]){
                swap(str,1,3)
            }

            if(str[0]==str[2]){ //x1,y1-x2,y2
                for(j in str[1]..str[3]){
                    arr[j][str[0]] += 1
                }
            }
            else if(str[1]==str[3]){
                for(j in str[0]..str[2]){
                    arr[str[1]][j] += 1
                }
            }
        }
        return arr.flatten().count {it>1}
    }


    fun part2(input: List<String>): Int {

        val arr = mutableListOf<MutableList<Int>>()
        for(i in 0..999){
            arr.add(mutableListOf())
            for(j in 0..999){
                arr[i].add(0)
            }
        }


        for(i in input){
            val str = i.replace(" -> ",",").split(",").map{it.toInt()}

            if(str[0]==str[2]){ //x1,y1-x2,y2
                for(j in min(str[1],str[3])..max(str[1],str[3])){
                    arr[j][str[0]] += 1
                }
            }
            else if(str[1]==str[3]){
                for(j in min(str[0],str[2])..max(str[0],str[2])){
                    arr[str[1]][j] += 1
                }
            }
            else{
                val max = max(str[0],str[2])
                val min = min(str[0],str[2])
                if(str[2]>str[0] && str[3]>str[1]){
                    for(j in 0..max-min) {
                        arr[str[0] + j][str[1] + j] += 1
                    }
                }
                else if(str[2]>str[0]){
                    for(j in 0..max-min) {
                        arr[str[0] + j][str[1] - j] += 1
                    }
                }
                else if(str[3]>str[1]){
                    for(j in 0..max-min) {
                        arr[str[0] - j][str[1] + j] += 1
                    }
                }
                else if(str[3]-str[1]==str[2]-str[0]){
                    for(j in 0..max-min) {
                        arr[str[2] + j][str[3] + j] += 1
                    }
                }
            }
        }
        return arr.flatten().count {it>1}
    }





    val inputTest = readInput("Day05Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
