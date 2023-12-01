package cn.beichenhpy.springsessiondemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.AbstractRedisHttpSessionConfiguration;

/**
 * 核心
 * {@link org.springframework.session.web.http.SessionRepositoryFilter} 替换了 ServletHttpRequest 和 ServletHttpResponse
 * 替换为 {@link org.springframework.session.web.http.SessionRepositoryFilter.SessionRepositoryRequestWrapper}
 * {@link org.springframework.session.web.http.SessionRepositoryFilter.SessionRepositoryResponseWrapper}
 * 重写了getSession和setAttribute方法，与存储介质联动，实现分布式session
 * 这个Filter最好最先执行，保证替换ServletHttpRequest 和 ServletHttpResponse
 */
@Configuration
public class RedisSessionConfig {


    /**
     * 设置redis序列化方式
     *
     * @return 返回序列化方式
     * @see AbstractRedisHttpSessionConfiguration#createRedisTemplate()
     * @see AbstractRedisHttpSessionConfiguration#getDefaultRedisSerializer()
     */
    @Bean(name = "springSessionDefaultRedisSerializer")
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        return RedisSerializer.json();
    }
}
