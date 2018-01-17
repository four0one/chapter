package com.demo.study02;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.pool.KryoFactory;
import com.esotericsoftware.kryo.pool.KryoPool;

/**
 * @author wei.chen1
 * @since 2018/1/15
 */
public class KryoFactoryPool {

	private static KryoFactory factory = new KryoFactory() {
		public Kryo create() {
			Kryo kryo = new Kryo();
			return kryo;
		}
	};

	public static final KryoPool pool = new KryoPool.Builder(factory).build();

	public static KryoPool getPool() {
		return pool;
	}

	public static Kryo getKryo() {
		return pool.borrow();
	}

	public static void release(Kryo kryo) {
		pool.release(kryo);
	}
}
