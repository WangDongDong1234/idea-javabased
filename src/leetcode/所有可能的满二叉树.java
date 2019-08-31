package leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 *
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-08-30 18:41
 **/
public class 所有可能的满二叉树 {
}
// class Solution13 {
//     public List<TreeNode> allPossibleFBT(int N) {
//         if (N % 2 == 0) {
//             return new ArrayList<>(0);
//         }
//         List<TreeNode> list = new ArrayList<>();
//         if (N == 1) {
//             list.add(new TreeNode(0));
//             return list;
//         }
//         N--;
//         for (int i = 1; i < N; i += 2) {
//             List<TreeNode> left = allPossibleFBT(i);
//             List<TreeNode> right = allPossibleFBT(N - i);
//             for (TreeNode l : left) {
//                 for (TreeNode r : right) {
//                     TreeNode node = new TreeNode(0);
//                     node.left = l;
//                     node.right = r;
//                     list.add(node);
//                 }
//             }
//         }
//         return list;
//     }
// }

