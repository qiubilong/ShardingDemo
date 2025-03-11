package com.roy.shardingDemo;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;

import java.util.ServiceLoader;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chenxuegui
 * @since 2025/3/10
 */
public class TestMe {
    public static final char[] DEFAULT_ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static void main(String[] args) {

        ServiceLoader<KeyGenerateAlgorithm> algorithms = ServiceLoader.load(KeyGenerateAlgorithm.class);
        for (KeyGenerateAlgorithm algorithm : algorithms) {
            System.out.println(algorithm.getType());
        }

    }

}
