package ru.skillfactorydemo.tgbot.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlRootElement(name = "GetCursOnDateXML", namespace = "http://web.cbr.ru/")
@Data //Геттеры и сеттеры
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCursOnDateXml {

    public void setOnDate(XMLGregorianCalendar onDate) {
        this.onDate = onDate;
    }

    @XmlElement(name = "On_date", required = true, namespace = "http://web.cbr.ru/") //Указание на то, в каком теге XML должно быть данное поле
    protected XMLGregorianCalendar onDate;
}