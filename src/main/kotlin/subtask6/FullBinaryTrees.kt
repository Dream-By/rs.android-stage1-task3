package subtask6

import java.util.*


class FullBinaryTrees {

    // TODO: Complete the following function
    fun stringForNodeCount(count: Int): String {
        //throw NotImplementedError("Not implemented")

        var resultStr: String = ""
        resultvariant(count).stream().forEach { node ->
            var string = "[0,${node}]"

            string = string.replace(",]", "]")
            while (string.endsWith(",null,null]")) {
                string = string.replace(",null,null]", "]")
            }
            resultStr += string
        }
        return "[$resultStr]"
    }

    private var treememo = hashMapOf<Int, List<TreeNode>>()

    private fun resultvariant(N: Int): List<TreeNode> {
        if (!treememo.containsKey(N)) {
            val ans = LinkedList<TreeNode>()
            if (N == 1) {
                ans.add(TreeNode(0))
            } else if (N % 2 == 1) {
                for (x in 0 until N) {
                    val y = N - 1 - x
                    for (left in resultvariant(x))
                        for (right in resultvariant(y)) {
                            val bns = TreeNode(0)
                            bns.left = left
                            bns.right = right
                            ans.add(bns)
                        }
                }
            }
            treememo[N] = ans
        }
        return treememo[N]!!
    }

    class TreeNode(var id: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        override fun toString(): String {
            return if (left != null && right != null) {
                "${left!!.id},${right!!.id}," + left.toString() + right.toString()
            } else {
                "${left.toString()},${right.toString()},"
            }
        }

    }
}
