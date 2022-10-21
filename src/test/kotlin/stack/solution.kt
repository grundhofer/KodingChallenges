package stack

/*
LinkedList based implementation
*/
private object Solution1 {
    private class Stack<E> {
        private var first: Node<E>? = null

        var size = 0
            private set

        fun add(element: E) {
            val node = Node(element)

            if (first == null) {
                first = node
            } else {
                node.next = first
                first = node
            }

            size++
        }

        fun remove(): E? {
            if (size == 0) return null

            val node = first
            first = first?.next
            size--
            return node?.data
        }

        fun peek(): E? = first?.data

        fun isEmpty() = first == null
    }

    private data class Node<E>(val data: E, var next: Node<E>? = null)
}

/*
List based implementation
*/
private object Solution2 {
    private class Stack<E> {
        private val list = mutableListOf<E>()

        val size get() = list.size

        fun add(element: E) {
            list.add(element)
        }

        fun remove() = if (list.isEmpty()) null else list.removeAt(list.lastIndex)

        fun peek() = list.lastOrNull()

        fun isEmpty() = list.isEmpty()
    }
}
