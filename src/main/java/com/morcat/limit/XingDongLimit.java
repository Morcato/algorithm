package com.morcat.limit;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *  超级无敌东星限流器
 *
 *  @author shenzixing
 *  @since 2021-06-10
 */
public class XingDongLimit {

    List<InnerQueue> queues = new ArrayList<>();
    private static OffsetDateTime NOW = OffsetDateTime.now();

    public XingDongLimit(List<Rule> rules) {
        for (Rule rule : rules) {
            queues.add(new InnerQueue(rule));
        }
    }

    public synchronized boolean limit() {
        NOW = OffsetDateTime.now();
        System.out.println("收到请求");
        for (InnerQueue queue : queues) {
            if (!queue.limit()) {
                System.out.println("限流啦!!!");
                for (InnerQueue q : queues) {
                    q.remove(NOW);
                }
                return false;
            }
        }
        System.out.println("可放过");
        return true;
    }


    public static class InnerQueue {
        Queue<OffsetDateTime> queue = new LinkedList<>();
        private Long second;
        private Long size;

        public InnerQueue(Rule rule) {
            this.second = rule.second;
            this.size = rule.size;
        }

        public void remove(Object o) {
            queue.remove(o);
        }

        public Boolean limit() {
            if (queue.size() >= size) {
                if (queue.peek().plusSeconds(second).isBefore(NOW)) {
                    queue.poll();
                    queue.offer(NOW);
                    return true;
                } else {
                    return false;
                }
            } else {
                queue.offer(NOW);
                return true;
            }
        }


        /**
         * 设置频率
         */
        public void setRule(Rule rule) {
            this.second = rule.second;
            this.size = rule.size;
        }
    }

    public static class Rule {
        private Long second;
        private Long size;

        public Rule(Long second, Long size) {
            this.second = second;
            this.size = size;
        }
    }

}
