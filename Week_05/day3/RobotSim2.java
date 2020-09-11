import java.util.HashSet;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/9 0009 10:55
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 *
 *
 *
 * 示例 1：
 *
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 *
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 */
public class RobotSim2 {

    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length == 0) return 0;
        int direct = 0;
        int maxDistance = Integer.MIN_VALUE;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + "_" + obstacles[i][1]);
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1){
                direct = (direct + 1) % 4;
            }else if (commands[i] == -2){
                direct = (direct + 3) % 4;
            }else {
                for (int j = 0; j < commands[i]; j++) {
                    int next_x = x + dir[direct][0];
                    int next_y = y + dir[direct][1];
                    if (!set.contains(next_x + "_" + next_y)){
                        x = next_x;
                        y = next_y;
                    }
                }
                maxDistance = Math.max(maxDistance,x * x + y * y);
            }
        }
        return maxDistance;
    }
}
