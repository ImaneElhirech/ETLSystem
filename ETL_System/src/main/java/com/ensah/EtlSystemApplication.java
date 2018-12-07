package com.ensah;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ensah.bo.Fichier;
import com.ensah.service.ETLService;

@SpringBootApplication
public class EtlSystemApplication  implements CommandLineRunner {
	@Resource
	private ETLService etlserv;

	public static void main(String[] args){
		SpringApplication.run(EtlSystemApplication.class, args);
		
		
		
	}
	@Override
	public void run(String... args) throws Exception {
		Fichier F1=new Fichier("D:/ENSAH BI/Berexia/Korea Policy File 100k.csv");
		etlserv.loadColums(F1.getName());
		etlserv.loadDataFirstColumn(F1.getName());
		
	}
}
