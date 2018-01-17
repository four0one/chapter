package com.demo.study03;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author wei.chen1
 * @since 2018/1/16
 */
public class CacheApp {
	public static void main(String[] args) {
		LoadingCache<String, Object> caches = CacheBuilder.newBuilder()
				.maximumSize(100)
				.expireAfterWrite(10, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Object>() {
					@Override
					public Object load(String key) throws Exception {
						return null;
					}
				});
		try {
			System.out.println(caches.get("key-zorro"));
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
