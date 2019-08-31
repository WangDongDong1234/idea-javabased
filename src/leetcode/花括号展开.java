package leetcode;

/**
 * 如果只给出单一的元素 x，那么表达式表示的字符串就只有 "x"。 
 * 例如，表达式 {a} 表示字符串 "a"。
 * 而表达式 {ab} 就表示字符串 "ab"。
 * 当两个或多个表达式并列，以逗号分隔时，我们取这些表达式中元素的并集。
 * 例如，表达式 {a,b,c} 表示字符串 "a","b","c"。
 * 而表达式 {a,b},{b,c} 也可以表示字符串 "a","b","c"。
 * 要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。
 * 例如，表达式 {a,b}{c,d} 表示字符串 "ac","ad","bc","bd"。
 * 表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
 * 例如，表达式 a{b,c,d} 表示字符串 "ab","ac","ad"​​​​​​。
 * 例如，表达式 {a{b,c}}{{d,e}f{g,h}} 可以代换为 {ab,ac}{dfg,dfh,efg,efh}，表示字符串 "abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"。
 *
 *
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-08-30 09:42
 * 思路：
 * 将花括号按层展开，用变量level表示当前是第几层括号，初始值为0，遇到一个左括号{时，level值增加1，遇到右括号}时，level值减少1。用递归处理每一层，每一层的结构为{}{}...{} + {}{}...{} + ...，和四则运算法则同理，先调用下一层函数计算括号内的，然后先乘后加。当前层递归函数只用笛卡尔积和并集处理层数为0的表达式，进入下一层，就用start变量标记该层的起始位置，直到找到该层的结束位置时，调用下一层递归函数。遍历时候，每遇到一个逗号（,）就在groups里面新开一个list，遍历完后，将groups里的每个list进行笛卡尔积运算，再取并集。
 *
 **/
public class 花括号展开 {
}

// class8 Solution:
//         def braceExpansionII(self, expression: str) -> List[str]:
//         groups = [[]]
//         level = 0
//         for i, c in enumerate(expression):
//         if c == '{':
//         if level == 0:
//         start = i+1
//         level += 1
//         elif c == '}':
//         level -= 1
//         if level == 0:
//         groups[-1].append(self.braceExpansionII(expression[start:i]))
//         elif c == ',' and level == 0:
//         groups.append([])
//         elif level == 0:
//         groups[-1].append([c])
//         print(c, groups)
//         word_set = set()
//         # 加运算，取并集
//         for group in groups:
//         word_set |= set(map(''.join, itertools.product(*group))) # 乘运算，取笛卡尔积
//         return sorted(word_set)

