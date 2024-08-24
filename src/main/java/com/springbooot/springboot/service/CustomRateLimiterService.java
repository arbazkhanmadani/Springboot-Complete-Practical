package com.springbooot.springboot.service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

@Service
public class CustomRateLimiterService {
	
	private final ConcurrentMap<String, RateLimitBucket> buckets = new ConcurrentHashMap<>();

	    public boolean isRateLimitExceeded(String key, int limit, int durationInMillis) {
	        RateLimitBucket bucket = buckets.computeIfAbsent(key, k -> new RateLimitBucket(limit, durationInMillis));
	        return !bucket.tryConsume();
	    }

	    private static class RateLimitBucket {
	        
	    	private final int limit;
	        private final long durationInMillis;
	        private int tokens;
	        private Instant lastRefillTime;

	        RateLimitBucket(int limit, int durationInMillis) {
	            this.limit = limit;
	            this.durationInMillis = durationInMillis;
	            this.tokens = limit;
	            this.lastRefillTime = Instant.now();
	        }

	        synchronized boolean tryConsume() {
	            refillTokens();
	            if (tokens > 0) {
	                tokens--;
	                return true;
	            }
	            return false;
	        }

	        private void refillTokens() {
	            Instant now = Instant.now();
	            long elapsed = Duration.between(lastRefillTime, now).toMillis();
	            if (elapsed > durationInMillis) {
	                int refillCount = (int) (elapsed / durationInMillis);
	                tokens = Math.min(limit, tokens + refillCount);
	                lastRefillTime = now;
	            }
	        }
	    }
	
	
}
