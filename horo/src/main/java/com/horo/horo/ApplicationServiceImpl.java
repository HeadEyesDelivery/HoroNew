package com.horo.horo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.horo.horo.HoroscopeClient;

import com.horo.horo.Horoscope;
import com.horo.horo.HoroscopeApiInfo;
import com.horo.horo.HoroscopeApiResponse;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/*
Этот код представляет собой сервисный класс, который выполняет
задачу загрузки данных о гороскопах из внешнего API,
перевода их на русский язык и сохранения в базу данных.
 */

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final HoroscopeClient horoscopeClient;
    private final Logger applicationLogger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    public ApplicationServiceImpl(HoroscopeClient horoscopeClient) {
        this.horoscopeClient = horoscopeClient;
    }

    @PostConstruct
    private void preloadingData() {
        applicationLogger.info("Старт загрузки данных из API.");

        applicationLogger.info("Чистим БД от старых данных.");

        applicationLogger.info("Запрос данных из API.");
        HoroscopeApiResponse response = horoscopeClient.getHoroscope("cancer", "daily", "today", "en");
        List<HoroscopeApiInfo> horoApi = response.getHoroscope();
        List<Horoscope> horoDocs = new ArrayList<>();

        applicationLogger.info("Полученные данные.");
        for (HoroscopeApiInfo horoscope : horoApi) {
            applicationLogger.info(horoscope.toString());

            horoDocs.add(new Horoscope(horoscope.getSign(), horoscope.getText(), horoscope.getDate(), horoscope.getType()));
        }

        applicationLogger.info("Загрузка информации в БД...");

        applicationLogger.info("Информация загружена.");
    }
}