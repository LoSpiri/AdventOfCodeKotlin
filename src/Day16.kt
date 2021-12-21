
fun main() {

    fun part1(input: List<String>): Int {
        /*
        var str = ""
        for(i in input[0]){
            str += when (i) {
                '0' -> "0000"
                '1' -> "0001"
                '2' -> "0010"
                '3' -> "0011"
                '4' -> "0100"
                '5' -> "0101"
                '6' -> "0110"
                '7' -> "0111"
                '8' -> "1000"
                '9' -> "1001"
                'A' -> "1010"
                'B' -> "1011"
                'C' -> "1100"
                'D' -> "1101"
                'E' -> "1110"
                'F' -> "1111"
                else-> ""
            }
        }
         */

        val hex = Integer.parseInt(input[0],16)
        val str = Integer.toBinaryString(hex)

        var versionSum = 0
        var pointer = 0
        while(pointer<str.length){
            versionSum += Integer.parseInt(str.substring(pointer,pointer+3),2)
            pointer += 3
            val typeId = Integer.parseInt(str.substring(pointer,pointer+3),2)
            pointer += 3
            if(typeId==4){
                //literal value
            }
            else{
                if(str[pointer]=='0'){
                    pointer++
                    val subPacketsLength = Integer.parseInt(str.substring(pointer,pointer+15),2)
                    //next 15 bits = length in bits of sub-packets
                }
                else{
                    //next 11 bits = number of subpackets
                }
            }

        }

        return 0
    }

    fun part2(input: List<String>): Int {
        return 0
    }


    val inputTest = readInput("Day02Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}