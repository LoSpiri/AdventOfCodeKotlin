fun main() {

    fun part1(input: List<String>): Int {
        var count = 0
        for(i in input){
            val line = i.split(" ")
            val len = line.size
            val out = line.slice(len-4 until line.size)
            count += out.count {it.length==2 || it.length==4 || it.length==3 || it.length==7}
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        for(i in input){
            val line = i.split(" ")
            val len = line.size
            val inp = line.slice(0 until len-5)
            var arr = inp.filter {it.length!=2 && it.length!=4 && it.length!=3 && it.length!=7}
            val set = mutableSetOf<Char>()
            var map = mutableMapOf<String,Int>()

            map[inp.first {it.length == 4}.toCharArray().sorted().joinToString("")] = 4
            map[inp.first {it.length == 3}.toCharArray().sorted().joinToString("")] = 7
            map[inp.first {it.length == 7}.toCharArray().sorted().joinToString("")] = 8
            map[inp.first {it.length == 2}.toCharArray().sorted().joinToString("")] = 1

            //NOVE
            inp.first { it.length==4 }.forEach {set.add(it)}
            var nove = ""
            var cont = 0
            for(i in arr) {
                cont = 0
                for(j in i) {if(set.contains(j)) {
                cont++
                if(cont == 4){nove = i}
            }}}
            arr = arr.filter {it != nove}
            map[nove.toCharArray().sorted().joinToString("")] = 9
            //ZERO
            set.clear()
            inp.first { it.length==3 }.forEach {set.add(it)}
            var zero = ""
            for(i in arr) {
                cont = 0
                for(j in i) {if(set.contains(j)) {
                    cont++
                    if(cont == 3 && i.length == 6){zero = i}
                }}}
            arr = arr.filter {it != zero}
            map[zero.toCharArray().sorted().joinToString("")] = 0
            //TRE
            var tre = ""
            for(i in arr) {
                cont = 0
                for(j in i) {if(set.contains(j)) {
                    cont++
                    if(cont == 3){tre = i}
                }}}
            arr = arr.filter {it != tre}
            map[tre.toCharArray().sorted().joinToString("")] = 3
            //SEI
            val sei = arr.first {it.length == 6}
            arr = arr.filter {it != sei}
            map[sei.toCharArray().sorted().joinToString("")] = 6
            //CINQUE
            set.clear()
            sei.forEach {set.add(it)}
            var cinque = ""
            for(i in arr) {
                cont = 0
                for(j in i) {if(set.contains(j)) {
                    cont++
                    if(cont == 5){cinque = i}
                }}}
            arr = arr.filter {it != cinque}
            map[cinque.toCharArray().sorted().joinToString("")] = 5
            //DUE
            map[arr.first().toCharArray().sorted().joinToString("")] = 2
            var str = ""
            val out = line.slice(len-4 until line.size)
            for(i in out) {
                str += map[i.toCharArray().sorted().joinToString("")]
            }
            count += str.toInt()
        }
        return count
    }




    val inputTest = readInput("Day08Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}
