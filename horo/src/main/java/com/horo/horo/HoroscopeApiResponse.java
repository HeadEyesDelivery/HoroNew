package com.horo.horo;
import java.util.List;
import com.horo.horo.HoroApplication;

public class HoroscopeApiResponse {

    private List<HoroscopeApiInfo> horoscope;

    public HoroscopeApiResponse(List<HoroscopeApiInfo> horoscope) {
        this.horoscope = horoscope;
    }

    public HoroscopeApiResponse() {
    }

    public List<HoroscopeApiInfo> getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(List<HoroscopeApiInfo> horoscope) {
        this.horoscope = horoscope;
    }

}
