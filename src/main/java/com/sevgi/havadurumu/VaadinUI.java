package com.sevgi.havadurumu;

import com.sevgi.havadurumu.model.Weather;
import com.sevgi.havadurumu.service.WeatherService;
import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
@Theme("valo")
public class VaadinUI extends UI
{
    @Autowired
    WeatherService weatherService;

    @Autowired
    Weather weather;

    private Label myInfo, info, cityWeatherMain, cityWeatherDescription, cordinats, temprature, tempratureMin, tempratureMax, pressure, humidity, windSpeed;

    @Override
    protected void init(VaadinRequest vaadinRequest)
    {
        TextField cityName = new TextField("Şehir adı giriniz:");
        Button button = new Button("Bilgileri Getir");

        info = new Label("Girilen Şehre Ait Bilgiler Aşağıda Listenelenecektir..");
        myInfo = new Label("Sevgi Alkan 140202014");
        cityWeatherMain = new Label("");
        cityWeatherDescription = new Label("");
        cordinats = new Label("");
        temprature = new Label("");
        tempratureMin = new Label("");
        tempratureMax = new Label("");
        pressure = new Label("");
        humidity = new Label("");
        windSpeed = new Label("");


        VerticalLayout layout = new VerticalLayout(myInfo, cityName, button, info, cityWeatherMain, cityWeatherDescription, cordinats, temprature, pressure, tempratureMin, tempratureMax, windSpeed, humidity);
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);

        button.addClickListener((Button.ClickListener) clickEvent -> {


            try
            {
                weather = weatherService.getWeatherDescription(cityName.getValue());

                info.setValue(cityName.getValue() + " Şehrine Ait Bilgiler..");
                cityWeatherMain.setValue("Girilen şehrin hava durumu : " + weather.getCityWeatherMain());
                cityWeatherDescription.setValue("Açıklama : " + weather.getCityWeatherDescription());
                cordinats.setValue("Kordinatlar : " + weather.getCordinats());
                temprature.setValue("Sıcaklık : " + weather.getTemprature() + " °C");
                pressure.setValue("Basınç : " + weather.getPressure());
                tempratureMin.setValue("En düşük sıcaklık : " + weather.getTempratureMin() + " °C");
                tempratureMax.setValue("En yüksek sıcalık : " + weather.getTempratureMax() + " °C");
                windSpeed.setValue("Rüzgar hızı: " + weather.getWindSpeed());
                humidity.setValue("Nem: %" + weather.getHumidity());

                Notification bildirim = new Notification(cityName.getValue() + " Şehrine ait bilgiler getirildi..", Notification.TYPE_WARNING_MESSAGE);

                bildirim.setDelayMsec(5000);
                bildirim.setPosition(Position.TOP_CENTER);
                bildirim.show(Page.getCurrent());

            }
            catch (Exception e)
            {
                info.setValue("Girdiğiniz Bilgiler Yanlış!! Lütfen Doğru bir şehir ismi giriniz!");
                cityWeatherDescription.setValue("");
                cityWeatherMain.setValue("");
                cordinats.setValue("");
                tempratureMax.setValue("");
                tempratureMin.setValue("");
                temprature.setValue("");
                pressure.setValue("");
                windSpeed.setValue("");
                humidity.setValue("");

                Notification bildirim = new Notification(" Girdiğiniz Bilgiler Yanlış!! Lütfen Doğru bir şehir ismi giriniz!", Notification.TYPE_ERROR_MESSAGE);

                bildirim.setDelayMsec(5000);
                bildirim.setPosition(Position.TOP_CENTER);
                bildirim.show(Page.getCurrent());

                e.printStackTrace();
            }


        });

    }
}
