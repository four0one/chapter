package com.demo.demo2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class App {

	public static void main(String[] args) throws Exception {

		List<String> listDev = getJars("E:\\test.txt");
		List<String> listSb = getJars("E:\\sb.txt");

		System.out.println(listDev);
		System.out.println(listSb);

		for (String jd : listDev) {
			if (!listSb.contains(jd)) {
				System.out.println(jd);
			}
		}
	}

	private static List<String> getJars(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));

		String line = br.readLine();

		List<String> listDev = new ArrayList<String>();
		while (line != null) {
			String[] strings = line.split("\\s+");
			listDev.addAll(Arrays.asList(strings));
			line = br.readLine();
		}
		return listDev;
	}
}
