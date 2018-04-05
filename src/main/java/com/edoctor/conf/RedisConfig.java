package com.edoctor.conf;

import com.edoctor.bean.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    Logger LOG = LogManager.getLogger(RedisConfig.class);

    @Bean
    public RedisTemplate<String, Device> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, Device> redis = new RedisTemplate<>();
        redis.setConnectionFactory(cf);
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new Jackson2JsonRedisSerializer<>(Device.class));
        return redis;
    }

    @Bean
    RedisConnectionFactory redisConnectionFactory(RedisStandaloneConfiguration redisConfig) {
        return new JedisConnectionFactory(redisConfig);
    }

    @Bean
    JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大空闲连接数，默认8个
        poolConfig.setMaxIdle(8);
        //最大连接数，默认8个
        poolConfig.setMaxIdle(10);
        //最小空闲连接数，默认0
        poolConfig.setMinIdle(1);
        //定时对线程池中空闲的链接进行validateObject校验
        poolConfig.setTestWhileIdle(true);
        return poolConfig;
    }

    //Redis ConnectionFactory
    @Profile("production")
    @Bean
    RedisStandaloneConfiguration redisStandaloneConfiguration1() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("10.10.119.18");
        config.setPort(6379);
        config.setPassword(RedisPassword.of("helloWorld@tanktju.com214ForEveryone"));
        return config;
    }

    @Profile({"test", "development"})
    @Bean
    RedisStandaloneConfiguration redisStandaloneConfiguration2() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("59.110.231.87");
        config.setPort(6480);
        config.setPassword(RedisPassword.of("helloWorld@tanktju.com214ForEveryone"));
        return config;
    }
}
