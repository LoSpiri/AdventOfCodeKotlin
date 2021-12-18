

fun main() {

    fun part1(input: List<String>): Int {

        val matrix = Array(input.size) {IntArray (input[0].length)}

        val arr = inputToMatrix(input)

        for(i in arr.indices){
            for(j in arr[i].indices){
                if(i==0 && j==0){matrix[i][j] = 0}
                else if(i == 0){
                    matrix[i][j] = matrix[i][j-1] + arr[i][j]
                }
                else if(j == 0){
                    matrix[i][j] = matrix[i-1][j] + arr[i][j]
                }
                else {
                    matrix [i][j] =
                            if(matrix[i-1][j]>matrix[i][j-1]) {matrix[i][j-1] + arr[i][j]}
                            else {matrix[i-1][j] + arr[i][j]}
                }
            }
        }
        return matrix[matrix.size-1][matrix[0].size-1]
    }

    fun part2(input: List<String>): Int {
        val matrix = Array(input.size*5) {IntArray (input[0].length*5)}

        val arr = inputToMatrix(input)

        val arr5 = Array(input.size*5) {IntArray (input[0].length*5)}

        for(h in 0..4) {
            for (k in 0..4) {
                for (i in arr.indices) {
                    for (j in arr[i].indices) {
                        arr5[i+(input.size*h)][j+(input[0].length*k)] =
                                if((arr[i][j] + h + k) > 9) {(arr[i][j] + h + k)-9}
                                else {(arr[i][j] + h + k)}
                    }
                }
            }
        }


        for(i in arr5.indices){
            for(j in arr5[i].indices){
                if(i==0 && j==0){matrix[i][j] = 0}
                else if(i == 0){
                    matrix[i][j] = matrix[i][j-1] + arr5[i][j]
                }
                else if(j == 0){
                    matrix[i][j] = matrix[i-1][j] + arr5[i][j]
                }
                else {
                    matrix [i][j] =
                            if(matrix[i-1][j]>matrix[i][j-1]) {matrix[i][j-1] + arr5[i][j]}
                            else {matrix[i-1][j] + arr5[i][j]}
                }
            }
        }
        return matrix[matrix.size-1][matrix[0].size-1]
    }



    val inputTest = readInput("Day15Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day15")
    println(part1(input))
    println(part2(input))
}
