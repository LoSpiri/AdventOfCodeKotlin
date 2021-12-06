fun main() {

    fun part1(input: List<String>): Int {
        var gamma = 0
        val size = input[0].length
        for(i in input[0].indices){
            var count = 0
            for(line in input) {
                if (line[i] == '1') {
                    count += 1
                }
            }

            if(count>(input.size)/2) {gamma += (Math.pow(2.toDouble(),size.toDouble()-i-1)).toInt()}
        }
        val max = (Math.pow(2.toDouble(),size.toDouble())).toInt()-1
        return gamma*(max-gamma)
    }


    fun part2(input: List<String>): Int {
        var arr = input
        var arr2 = input
        var i = 0
        while(arr.size>1){
            var count = 0
            for(line in arr) {
                if (line[i] == '1') {
                    count += 1
                }
                else{
                    count -= 1
                }
            }
            arr = if (count>=0) {
                arr.filter {it[i]=='1'}
            }
            else {
                arr.filter {it[i]=='0'}
            }
            i++
        }
        i=0
        while(arr2.size>1){
            var count = 0
            for(line in arr2) {
                if (line[i] == '0') {
                    count += 1
                }
                else{
                    count -= 1
                }
            }
            arr2 = if (count<=0) {
                arr2.filter {it[i]=='0'}
            }
            else {
                arr2.filter {it[i]=='1'}
            }
            i++
        }
        var oxy = 0
        for(j in 0 until arr[0].length){
            oxy += if(arr[0][j]=='1') (Math.pow(2.toDouble(),(arr[0].length-j-1).toDouble())).toInt() else 0
        }
        var co2 = 0
        for(k in 0 until arr[0].length){
            co2 += if(arr2[0][k]=='1') (Math.pow(2.toDouble(),(arr2[0].length-k-1).toDouble())).toInt() else 0
        }
        return oxy*co2

    }


    val inputTest = readInput("Day03Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}