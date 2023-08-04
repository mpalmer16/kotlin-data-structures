package tree

import org.junit.jupiter.api.Test
import java.util.*

class BinaryTreeTests {

    @Test
    fun `create tree from node`() {
        val foo = BinaryTreeNode(2)
        foo.insert(1)
        foo.insert(3)

        assert(foo.data == 2)
        assert(foo.left!!.data == 1)
        assert(foo.right!!.data == 3)
    }

    @Test
    fun `create tree from node out of order`() {
        val bt = BinaryTreeNode(3)

        bt.insert(1)
        bt.insert(2)
        bt.insert(4)

        assert(bt.data == 3)
        assert(bt.left!!.data == 1)
        assert(bt.left!!.right!!.data == 2)
        assert(bt.right!!.data == 4)
    }

    @Test
    fun `find in a big tree`() {
        val knownValue = UUID.randomUUID()
        val bt = makeRandomBinaryTreeNode(100, knownValue)

        assert(bt.find(knownValue) == knownValue)
    }

    private fun makeRandomBinaryTreeNode(size: Int, knownValue: UUID): BinaryTreeNode<UUID> {
        val tree = BinaryTreeNode<UUID>(UUID.randomUUID())

        (0..size).forEach { _ ->
            tree.insert(UUID.randomUUID())
        }
        tree.insert(knownValue)

        return tree
    }

}