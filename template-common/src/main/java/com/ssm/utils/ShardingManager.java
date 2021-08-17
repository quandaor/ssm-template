package com.ssm.utils;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author quandaoran
 * @date 2021/8/17 1:31 下午
 * @describe ShardingHelper
 **/
public interface ShardingManager extends Range {

    /**
     * 分片大小 默认取 10000条
     */
    Long DEFAULT_SHARDING_SPAN = 1_000L;


    default List<ShardTask> doSharding() {
        List<ShardTask> shardingList = ShardingManager.getShardingList(getMinId(),
                getMaxId(),
                DEFAULT_SHARDING_SPAN);
//        ShardingUtil.ShardingVO shardingVo = ShardingUtil.getShardingVo();

        List<ShardTask> result = Lists.newArrayList();
//        int index = shardingVo.getIndex();
//        int i = 0;
//        for (ShardTask shardTask : shardingList) {
//            int total = shardingVo.getTotal();
//            if (i % total == index) {
//                result.add(shardTask);
//            }
//            i++;
//        }
//        return result;
        return null;
    }

    static List<ShardTask> getShardingList(long minPrimaryId, long maxPrimaryId, long shardingSpan) {
        long total = maxPrimaryId - minPrimaryId + 1;
        long count = total % shardingSpan == 0 ? total / shardingSpan : total / shardingSpan + 1;
        List<ShardTask> tasks = Lists.newArrayList();
        long start = minPrimaryId;
        for (int i = 0; i < count; i++) {
            long end = Math.min(maxPrimaryId, start + shardingSpan - 1);
            ShardTask task = new ShardTask(start, end);
            start = end + 1;
            tasks.add(task);
        }
        return tasks;
    }

    static void main(String[] args) {
        // ([3,15] , 5) = {[3,7] ,[8,12] ,[13,14,15]}
        List<ShardTask> shardingList = getShardingList(3L, 15L, 5L);
        for (ShardTask shardTask : shardingList) {
            System.out.println("[" + shardTask.minId + "-" + shardTask.maxId + "]");
        }
    }


    @Data
    @AllArgsConstructor
    class ShardTask {
        private Long minId;
        private Long maxId;
    }

}
