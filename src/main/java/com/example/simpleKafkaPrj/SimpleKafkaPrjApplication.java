package com.example.simpleKafkaPrj;

import com.example.simpleKafkaPrj.controllers.producerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SimpleKafkaPrjApplication implements CommandLineRunner {

	@Autowired
	private producerController producerController;

	public static void main(String[] args) {
		SpringApplication.run(SimpleKafkaPrjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ready");

		List<String> stringArrayList = new ArrayList<>();

		String s1 = "My";
		stringArrayList.add(s1);
		String s2 = "Name";
		stringArrayList.add(s2);
		String s3 = "is";
		stringArrayList.add(s3);
		String s4 = "John";
		stringArrayList.add(s4);
		String s5 = "konegton";
		stringArrayList.add(s5);

		producerController.setStringArrayList(stringArrayList);

//		List<Integer> integerArrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
//		producerController.setIntegerArrayList(integerArrayList);
	}
}