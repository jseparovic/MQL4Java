/**
 Copyright 2016 Jason Separovic

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.jseppa.mql4java.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil
{
    public final static Logger LOG = LoggerFactory.getLogger(DateUtil.class);

    /**
     *
     * @return
     * @throws DatatypeConfigurationException
     */
    public static String getXMLDateString() throws DatatypeConfigurationException {
        return getXMLDateString(0);
    }
    /**
     *
     * @param offset
     * @return
     * @throws DatatypeConfigurationException
     */
    public static String getXMLDateString(int offset) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(Calendar.getInstance().getTime());
        c.add(Calendar.SECOND, offset);
        //return DatatypeFactory.newInstance().newXMLGregorianCalendar(c).toXMLFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(c.getTime()) + "T" + stf.format(c.getTime()) + "Z";
    }

    /**
     *
     * @param offset
     * @return
     * @throws DatatypeConfigurationException
     */
    public static String getOMDateString(int offset) throws DatatypeConfigurationException {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        c.add(Calendar.SECOND, offset);
        return format.format(c.getTime());
    }

    /**
     *
     * @return
     * @throws DatatypeConfigurationException
     */
    public static XMLGregorianCalendar getXMLGregorianCalenderDate() throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(Calendar.getInstance().getTime());
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    }

    /**
     *
     * @param xmlDate
     * @return
     * @throws DatatypeConfigurationException
     */
    public static XMLGregorianCalendar getXMLGregorianCalenderDate(String xmlDate) throws DatatypeConfigurationException {
        GregorianCalendar c = (GregorianCalendar) javax.xml.bind.DatatypeConverter.parseDateTime(xmlDate);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    }

    /**
     *
     * @return
     * @throws DatatypeConfigurationException
     */
    public static String getFileDateString() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_hhmmss");
        return format.format(c.getTime());
    }

    public static String getDateString(DateTime datetime) {
        Calendar c = Calendar.getInstance();
        c.setTime(datetime.toDate());
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(c.getTime());
    }

    public static String toMT4TimeString(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return format.format(c.getTime());
    }

    public static Date getDateTime(String dateString) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.parse(dateString);
    }

    static SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("mm.dd.yyyy ");
    static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("mm.dd.yyyy HH:mm");

    public static Date getDateFromCurrentAnd24HRTime(Date current, String hr24Time) throws ParseException
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        Calendar newCalendar = Calendar.getInstance();
        newCalendar.set(Calendar.DAY_OF_MONTH, day);
        newCalendar.set(Calendar.MONTH, month);
        newCalendar.set(Calendar.YEAR, year);
        newCalendar.setTimeZone(calendar.getTimeZone());
        String[] hr24TimeBits = hr24Time.split(":");
        newCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hr24TimeBits[0]));
        newCalendar.set(Calendar.MINUTE, Integer.parseInt(hr24TimeBits[1]));
        newCalendar.set(Calendar.SECOND, 0);
        newCalendar.set(Calendar.MILLISECOND, 0);
        return newCalendar.getTime();
    }

    public static DateTimeZone DATE_TZ = DateTimeZone.forOffsetHours(0);

    public static DateTime addDateAndTime(LocalDate date, LocalTime time)
    {
        return new DateTime(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth(),
                time.getHourOfDay(), time.getMinuteOfHour(), time.getSecondOfMinute(), DATE_TZ);
    }
}
