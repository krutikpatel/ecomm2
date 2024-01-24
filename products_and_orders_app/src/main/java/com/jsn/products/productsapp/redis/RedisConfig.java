package com.jsn.products.productsapp.redis;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.RedisSerializationContext;

//@Configuration
//@EnableRedisRepositories
/*
 * knote: not sure if this class is needed since config is in application.properties
 * this ref uses it: https://github.com/bezkoder/spring-boot-redis-example/blob/master/src/main/java/com/bezkoder/spring/redis/config/RedisConfig.java
 * 		may be because he is trying to use lettuce. spring uses jedis
 * 
 * another config example at: https://www.youtube.com/watch?v=oRGqCz8OLcM&t=1135s&ab_channel=JavaTechie
 * 	-trying to use serializer
 * 
 * example with no java config like mine: https://medium.com/simform-engineering/spring-boot-caching-with-redis-1a36f719309f 
 */
//@Configuration
//@AutoConfigureAfter(RedisAutoConfiguration.class)
//@EnableCaching
//@EnableRedisRepositories
public class RedisConfig {
	
	//@Autowired
	//private CacheManager cacheManager;

	@Value("${spring.redis.host}")
	private String redisHost;

	@Value("${spring.redis.port}")
	private int redisPort;
	/*
	@Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(redisHost);
        configuration.setPort(redisPort);
        return new JedisConnectionFactory(configuration);
    }
    */
	/*
	@Bean
    public RedisTemplate<String, Object> template() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new JdkSerializationRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }
	*/
	/*
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
		/*
		RedisCacheConfiguration redisCacheConfiguration = config
				.serializeKeysWith(
						RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair
						.fromSerializer(new GenericJackson2JsonRedisSerializer()));
		 
		RedisCacheManager redisCacheManager = RedisCacheManager.builder(factory).cacheDefaults(config)
				.build();
		return redisCacheManager;
	}
*/
}
