package com.demo.study02;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author wei.chen1
 * @since 2018/1/15
 */
public class KryoUtils {

	public void decode(){

	}

	public void encode() throws IOException {
		Kryo kryo = KryoFactoryPool.getKryo();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		Output out = new Output(output);
		Person person = new Person();
		person.setAge(12);
		person.setName("chenwei");
		kryo.writeClassAndObject(out, person);
		out.close();
		output.close();
		byte[] bytes = out.getBuffer();
		for(byte b:bytes){
			System.out.print(b);
		}
		KryoFactoryPool.release(kryo);
	}

}
