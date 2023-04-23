# 📚 Redis

---

## Redis 이란?

- In-Memory 기반의 Data Structure Store 이다.
- 주로 캐시 용도로 많이 사용된다.
- 인메모리 기반이기 때문에 서버가 재시작하면 휘발된다.
- Redis Persistence를 통한 일정 주기마다 데이터를 디스크에 스냅 샷 형태로 백업하는 용도로 사용

## Redis에서 사용하는 자료 구조

![사용가능한 자료구조](./img/img.png)
- Strings
- Sets
- Sorted Sets
- Lists
- Hashes
- Bitmaps
- Bitfields
- HyperLogLog
- Geospatial indexes
- Streams

## Spring boot 에 적용하기


***build.gradle***
```groovy
implementation 'org.springframework.boot:spring-boot-starter-data-redis'
```

***RedisConfig.java***
```java
@RequiredArgsConstructor
@Configuration
@EnableRedisRepositories
public class RedisConfig {
    
    @Value("${spring.data.redis.host}")
    private String host;
    
    @Value("${spring.data.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        return new LettuceConnectionFactory(host, port);
    }

    //
    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> redisTemplate =  new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
```