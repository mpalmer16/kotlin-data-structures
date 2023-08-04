package tree

data class BinaryTreeNode<T : Comparable<T>>(
    val data: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null,
) {
    fun insert(data: T) {
        when {
            this.data < data -> when (this.right) {
                null -> this.right = BinaryTreeNode(data)
                else -> this.right!!.insert(data)
            }

            else -> when (this.left) {
                null -> this.left = BinaryTreeNode(data)
                else -> this.left!!.insert(data)
            }
        }
    }

    fun find(d: T): T? {
        when (this.data) {
            d -> return d
            else -> when {
                this.data < d -> return this.right?.find(d)
                else -> return this.left?.find(d)
            }
        }
    }

    fun printInOrder() {
        this.left?.printInOrder()
        print("${this.data} ")
        this.right?.printInOrder()
    }
}
