package tech.qijin.study.consistent.hash;

import com.google.common.collect.Maps;

import java.util.TreeMap;

public class ConsistentHash {
    private TreeMap<Long, HashNode> hashRing = Maps.newTreeMap();
    private int virtualNodeNum;

    public ConsistentHash(int virtualNodeNum) {
        this.virtualNodeNum = virtualNodeNum;
        for (int i = 0; i < virtualNodeNum; i++) {
        }
    }

    public HashNode getNode() {
        return null;
    }

    private long hash() {
        return 0L;
    }

    static class HashNode {
        //
    }
}
