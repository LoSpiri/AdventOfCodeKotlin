import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Graph<T> {
    val adjacencyMap: HashMap<T, HashSet<T>> = HashMap()

    fun addEdge(sourceVertex: T, destinationVertex: T) {
        // Add edge to source vertex / node.
        adjacencyMap
                .computeIfAbsent(sourceVertex) { HashSet() }
                .add(destinationVertex)
        // Add edge to destination vertex / node.
        adjacencyMap
                .computeIfAbsent(destinationVertex) { HashSet() }
                .add(sourceVertex)
    }

    override fun toString(): String = StringBuffer().apply {
        for (key in adjacencyMap.keys) {
            append("$key -> ")
            append(adjacencyMap[key]?.joinToString(", ", "[", "]\n"))
        }
    }.toString()
}

fun breadthFirstTraversal(graph: Graph<String>,
                              startNode: String,
                              endNode: String, ): MutableList<MutableList<String>> {

    val queue = ArrayDeque<MutableList<String>>()
    var res = mutableListOf<MutableList<String>>()
    var path = mutableListOf<String>()

    path.add(startNode)
    queue.add(path)
    var i = 0

    while(queue.isNotEmpty()){
        i++
        path = queue.pop()
        var last = path[path.size-1]

        if(last == endNode){
            res.add(path)
            continue
        }

        for(node in graph.adjacencyMap[last]!!){
            if(node[0].isUpperCase() || !(path.contains(node))){
                val newPath = path.toMutableList()
                newPath.add(node)
                queue.add(newPath)
            }
        }
    }
    return res
}

fun breadthFirstTraversal2(graph: Graph<String>,
                          startNode: String,
                          endNode: String, ): Int {

    val queue = ArrayDeque<MutableList<String>>()
    var res = 0
    var path = mutableListOf<String>()

    path.add(startNode)
    queue.add(path)
    var i = 0

    while(queue.isNotEmpty()){
        i++
        path = queue.pop()
        var last = path[path.size-1]

        if(last == endNode){
            res++
            continue
        }

        for(node in graph.adjacencyMap[last]!!){
            val noReps = path.filter {it[0].isLowerCase()}.size == path.filter {it[0].isLowerCase()}.distinct().size
            if( node[0].isUpperCase() || (!path.contains(node) && node != startNode ) || (noReps && node != startNode )){
                val newPath = path.toMutableList()
                newPath.add(node)
                queue.add(newPath)
            }
        }
    }
    return res
}


fun main() {

    fun part1(input: List<String>): Int {
        var graph = Graph<String>()
        input.map {
            val line = it.split("-")
            graph.addEdge(line[0],line[1])
        }
        return (breadthFirstTraversal(graph,"start","end")).size
    }

    fun part2(input: List<String>): Int {
        var graph = Graph<String>()
        input.map {
            val line = it.split("-")
            graph.addEdge(line[0],line[1])
        }
        return (breadthFirstTraversal2(graph,"start","end"))
    }


    val inputTest = readInput("Day12Test")
    println(part1(inputTest))
    println(part2(inputTest))

    val input = readInput("Day12")
    println(part1(input))
    println(part2(input))
}
