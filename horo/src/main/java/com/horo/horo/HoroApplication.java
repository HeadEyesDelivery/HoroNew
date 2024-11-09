package com.horo.horo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.lightcouch.CouchDbClient;

@EnableFeignClients
@SpringBootApplication
public class HoroApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoroApplication.class, args);

		CouchDbClient db = CouchDBConnection.connect();
		if (db != null) {
			System.out.println("Подключение установлено!");

			// Создание тестовых данных
			Horoscope horoscope = new Horoscope();
			horoscope.setSign("Virgo");
			horoscope.setText("Сегодня будет удачный день!");
			horoscope.setDate("today");
			horoscope.setType("Daily");

			// используем API



			// Сохранение тестовых данных в базу данных
			db.save(horoscope);
			System.out.println("Тестовые данные добавлены в базу данных.");
		} else {
			System.out.println("Не удалось подключиться к базе данных.");
		}
	}
}

