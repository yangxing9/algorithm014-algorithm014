import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/31 0031 10:21
 * 841. 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 *
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 *
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 */
public class CanVisitAllRooms {

    // 默认进去第一个房间，所以从 1 开始
    private int count = 1;

    public static void main(String[] args) {
        CanVisitAllRooms demo = new CanVisitAllRooms();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());
//        rooms.add(Arrays.asList(4,3,2));
        System.out.println(demo.canVisitAllRooms2(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return true;
        // 定义缓存，进入过的房间
        boolean[] used = new boolean[rooms.size()];
        // 默认第一个房间能进去
        used[0] = true;
        // 进入第一个房间
        doCanVisitAllRooms(rooms,0,used);
        // 如果count == room 则表示每个房间都进去过了
        return count == rooms.size();
    }

    private void doCanVisitAllRooms(List<List<Integer>> rooms, int roomNum,boolean[] used) {
        // 拿到当前房间的钥匙
        for (int key :rooms.get(roomNum)) {
            // 如果钥匙对应的房间没进去过
            if (!used[key]) {
                // 置为已进入
                used[key] = true;
                // 进入房间次数加一
                count++;
                // 优化：如果已经都进去过了，剩余的就不用再去进了，虽然也进不去，至少省了递归进去再判断的逻辑
                if (count == rooms.size()) return;
                // 进入当前钥匙对应的房间
                doCanVisitAllRooms(rooms,key,used);
            }
        }
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return true;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < rooms.get(0).size(); i++) {
            deque.offer(rooms.get(0).get(i));
        }
        // 定义缓存，进入过的房间
        boolean[] used = new boolean[rooms.size()];
        used[0] = true;
        while (!deque.isEmpty()){
            Integer roomNum = deque.poll();
            used[roomNum] = true;
            List<Integer> room = rooms.get(roomNum);
            for (Integer key: room) {
                if (!used[key]){
                    deque.offer(key);
                    used[key] = true;
                }
            }
        }
        for (boolean b : used) if (!b) return false;
        return true;
    }
}
