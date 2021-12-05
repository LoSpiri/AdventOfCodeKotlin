fun main() {
    fun part1(input: List<String>): Int {
        val set = mutableSetOf<Int>()

        for(i in input[0].split(",")){set.add(i.toInt())}
        var cont = 0
        val arr = mutableListOf<MutableList<Int>>()
        arr.add(mutableListOf<Int>())
        for(j in 2 until input.size){
            if(input[j]==""){
                cont++
                arr.add(mutableListOf<Int>())
                continue
            }
            val str = input[j].trim().replace("  "," ")
            val line = str.split(" ")
            for(k in line){
                arr[cont].add(k.toInt())
            }
        }

        for(setElem in set){
            for(arrIter in arr){
                for(arrIndex in arrIter.indices){
                    if(arrIter[arrIndex] == setElem) {
                        arrIter[arrIndex] = -1
                        for(i in 0..4){
                            for(j in 0..4){//consec
                                if(arrIter[(i*5)+j]>=0) {
                                    break
                                }
                                if(j==4){
                                    return (arrIter.filter {it>=0}.sum())*setElem
                                }
                            }
                            for(k in 0..4){//multipli di 5
                                if(arrIter[(k*5)+i]>=0){
                                    break
                                }
                                if(k==4){
                                    return (arrIter.filter {it>=0}.sum())*setElem
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0
    }


    fun part2(input: List<String>): Int {
        val set = mutableSetOf<Int>()

        for(i in input[0].split(",")){set.add(i.toInt())}
        var cont = 0
        val arr = mutableListOf<MutableList<Int>>()
        arr.add(mutableListOf<Int>())
        for(j in 2 until input.size){
            if(input[j]==""){
                cont++
                arr.add(mutableListOf<Int>())
                continue
            }
            val str = input[j].trim().replace("  "," ")
            val line = str.split(" ")
            for(k in line){
                arr[cont].add(k.toInt())
            }
        }

        var remove = 0
        for(setElem in set){
            for(arrIter in arr){
                if(arrIter[0] == -4) {continue}
                for(arrIndex in arrIter.indices){
                    if(arrIter[arrIndex] == setElem) {
                        arrIter[arrIndex] = -1
                        var flag = false
                        for(i in 0..4){
                            for(j in 0..4){//consec
                                if(arrIter[(i*5)+j]>=0) {
                                    break
                                }
                                if(j==4){
                                    if(remove != arr.size-1) {flag = true}
                                    else {return (arrIter.filter {it>=0}.sum())*setElem}
                                }
                            }
                            for(k in 0..4){//multipli di 5
                                if(arrIter[(k*5)+i]>=0){
                                    break
                                }
                                if(k==4){
                                    if(remove < arr.size-1) {flag = true}
                                    else {return (arrIter.filter {it>=0}.sum())*setElem}
                                }
                            }
                        }
                        if(flag){
                            arrIter[0] = -4
                            remove++
                        }
                    }
                }
            }
        }

        return 0
    }

    val inputTest = readInput("Day04Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))

}
