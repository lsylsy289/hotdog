package hotdog.commons;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Strings을 Dates와 Timestamps로 변환
 *
 */
public class DateUtil {
    protected final static Log log = LogFactory.getLog(DateUtil.class);

    private static final String TIME_PATTERN = "HH:mm";

    /**
     * 유틸리티 클래스는 기본 생성자 사용 안함.
     */
    private DateUtil() {
    }

    /**
     * 기본 날짜 패턴 (yyyy/MM/dd) 반환
     *
     * @return UI에 사용하기 위한 date pattern 반환
     */
    public static String getDatePattern() {
        return "yyyy/MM/dd";
    }

    public static String getDateTimePattern() {
        return DateUtil.getDatePattern() + " HH:mm:ss.S";
    }

    /**
     * 폼에서 dd-MMM-yyyy 형태를 mm/dd/yyyy 형태로 오라클 날짜 포맷으로 변환.
     *
     * @param aDate
     *            date from database as a string
     * @return UI를 위해 포맷화된 문자열 반환
     */
    public static String getDate(Date aDate) {
        SimpleDateFormat df;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat("yyyy/MM/dd");
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * 입력하는 포맷에서 date/time의 문자열 생성
     *
     * @param aMask
     *            입력되는 날짜 패턴
     * @param strDate
     *            날짜 문자열 표현
     * @return 변환된 날짜 객체 반환
     * @see java.text.SimpleDateFormat
     * @throws ParseException
     *             when String doesn't match the expected format
     */
    public static Date convertStringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df;
        Date date;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            // log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    public static String getDate(String aMask, String strDate) {
        SimpleDateFormat df;
        Date date;
        String returnValue = "";

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        }

        try {
            df = new SimpleDateFormat(aMask);
            date = df.parse(strDate);

            returnValue = df.format(date);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return returnValue;
    }

    /**
     * 현재 날짜 시간을 다음 포맷으로 반환: MM/dd/yyyy HH:MM a
     *
     * @param 현재
     *            시간
     * @return 현재 date/time 반환
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(TIME_PATTERN, theTime);
    }

    /**
     * 현재 날짜를 다음 포맷을 반환: MM/dd/yyyy
     *
     * @return 현재 날짜 반환
     * @throws ParseException
     *             when String doesn't match the expected format
     */
    public static Calendar getToday() {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * 현재시간
     *
     * @return 현재 날짜 반환
     * @throws ParseException
     *             when String doesn't match the expected format
     */
    public static String getTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmssms");

        return sdf.format(cal.getTime());
    }

    /**
     * 일시
     *
     * @see java.text.SimpleDateFormat
     */
    public static String getDateTime() {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        return sdf.format(cal.getTime());
    }

    /**
     * 입력하는 포맷에서 날짜의 date/time의 문자열 생성
     *
     * @param aMask
     *            입력되는 날짜 패턴
     * @param aDate
     *            날짜 객체
     * @return 포맷팅된 문자열 날짜 표현
     *
     * @see java.text.SimpleDateFormat
     */
    public static String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * 입력하는 포맷에서 시스템 프로퍼니의 'dateFormat'를 기초로 하여 날짜의 date/time의 문자열 생성
     *
     * @param aDate
     *            변환할 날짜
     * @return 날짜의 문자열 표현 반환
     */
    public static String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * 날짜 패턴을 이용하여 String --> date로 변환
     *
     * @param strDate
     *            변환할 날짜 (다음 포맷으로: MM/dd/yyyy)
     * @return 날짜 객체 반환
     * @throws ParseException
     *             when String doesn't match the expected format
     */
    public static Date convertStringToDate(String strDate) {
        Date aDate = null;

        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }

            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate + "' to a date, throwing exception");
            pe.printStackTrace();
        }

        return aDate;
    }

    public static String getYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR); // YEAR 는 모두 대문자로 써야한다.
        return String.valueOf(year);
    }

    public static String getMonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1; // MONTH 는 모두 대문자로 써야한다.(월에는 1을 더해줘야 한다.)

        return StringUtil.getZeroMask(String.valueOf(month), 2);
    }

    public static String getDay() {
        Calendar cal = Calendar.getInstance();
        int dat = cal.get(Calendar.DATE); // DATE 는 모두 대문자로 써야한다.

        return StringUtil.getZeroMask(String.valueOf(dat), 2);
    }


    public static String getWeek() {
        Calendar cal = Calendar.getInstance();

        int weeknum = cal.get(Calendar.DAY_OF_WEEK);
        String weekstr = "00";
        switch (weeknum) {
        case 1:
            weekstr = "일";
            break;
        case 2:
            weekstr = "월";
            break;
        case 3:
            weekstr = "화";
            break;
        case 4:
            weekstr = "수";
            break;
        case 5:
            weekstr = "목";
            break;
        case 6:
            weekstr = "금";
            break;
        case 7:
            weekstr = "토";
            break;
        }

        return String.valueOf(weekstr);
    }

    public static String getHour() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        return String.valueOf(hour);
    }

    public static String getHourHH() {
        Calendar cal = Calendar.getInstance();
        int dat =  cal.get ( Calendar.HOUR_OF_DAY ); // DATE 는 모두 대문자로 써야한다.

        return StringUtil.getZeroMask(String.valueOf(dat), 2);
    }

    public static String getMinute() {
        Calendar cal = Calendar.getInstance();
        int min = cal.get(Calendar.MINUTE);
        return String.valueOf(min);
    }

    public static String getSecond() {
        Calendar cal = Calendar.getInstance();
        int sec = cal.get(Calendar.SECOND);
        return String.valueOf(sec);
    }

    public static boolean getLeapYear() {
        boolean tf = false;
        int year = Integer.parseInt(getYear());
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            tf = true;
            // System.out.println("올해는 윤년입니다");
        }

        return tf;
    }

    public static String getDate() {
        return getYear() + getMonth() + getDay();
    }

    public static String getDateYM() {
        return getYear() + getMonth();
    }

    /**
     * 일시
     *
     * @see java.text.SimpleDateFormat
     */
    public static String getSysDate() {
        String dateString = "";

        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String textDate = format.format(cal.getTime());

            java.util.Date date = format.parse(textDate);
            java.text.SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            dateString = format1.format(date);

        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        return dateString;
    }

    /**
     * 일시
     *
     * @see java.text.SimpleDateFormat
     */
    public static String getConvertDate(String str, String pattern) {
        String dateString = "";

        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String textDate = format.format(str);

            java.util.Date date = format.parse(textDate);
            java.text.SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyyMMdd");

            dateString = format1.format(date);

        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        return dateString;
    }

    /**
     * check date string validation with the default format "yyyyMMdd".
     *
     * @param s
     *            date string you want to check with default format "yyyyMMdd".
     * @return date java.util.Date
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 format 에 맞지 않는 경우.
     **/
    public static java.util.Date check(String s) throws java.text.ParseException {
        return check(s, "yyyyMMdd");
    }

    /**
     *날짜를 표현하는 형식을 변경하여 변경된 문자열을 리턴한다.
     *
     * @param s
     *            날짜를 나타내는 문자열
     * @param format
     *            소스(s) 날짜의 형식을 설명하는 문자열 ,예) "yyyy-MM-dd"
     * @param toformat
     *            변경될 날짜의 형식을 설명하는 문자열 ,예) "yyyy-MM-dd"
     * @return toformat형태로 변경된 날짜를 표시하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 format 에 맞지 않는 경우.
     */
    public static String changeFormat(String s, String format, String toformat) throws java.text.ParseException {
        java.util.Date date = check(s, format);
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(toformat, java.util.Locale.KOREA);
        String dateString = formatter.format(date);
        return dateString;

    }

    /**
     *날짜를 표현하는 형식을 변경하여 변경된 문자열을 리턴한다.
     *
     * @param date
     *            날짜를 나타내는 Date객체
     * @param toformat
     *            변경될 날짜의 형식을 설명하는 문자열 ,예) "yyyy-MM-dd"
     * @return toformat형태로 변경된 날짜를 표시하는 문자열
     */
    public static String changeFormat(Date date, String toformat) {

        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(toformat, java.util.Locale.KOREA);
        String dateString = formatter.format(date);
        return dateString;

    }

    /**
     * check date string validation with an user defined format.
     *
     * @param s
     *            date string you want to check.
     * @param format
     *            string representation of the date format. For example, "yyyy-MM-dd".
     * @return date java.util.Date
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 format 에 맞지 않는 경우 발생
     */
    public static java.util.Date check(String s, String format) throws java.text.ParseException {
        if (s == null)
            throw new java.text.ParseException("date string to check is null", 0);
        if (format == null)
            throw new java.text.ParseException("format string to check date is null", 0);

        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format, java.util.Locale.KOREA);
        java.util.Date date = null;
        try {
            date = formatter.parse(s);
        } catch (java.text.ParseException e) {
            /*
             * throw new java.text.ParseException( e.getMessage() + " with format \"" + format + "\"", e.getErrorOffset() );
             */
            throw new java.text.ParseException(" wrong date:\"" + s + "\" with format \"" + format + "\"", 0);
        }

        if (!formatter.format(date).equals(s))
            throw new java.text.ParseException("Out of bound date:\"" + s + "\" with format \"" + format + "\"", 0);
        return date;
    }

    /**
     * check date string validation with the default format "HH:mm:ss".
     *
     * @param s
     *            date string you want to check with default format "HH:mm:ss"
     * @return <tt>true</tt> 날짜 형식이 맞고, 존재하는 날짜일 때. <tt>false</tt> 날짜 형식이 맞지 않거나, 존재하지 않는 날짜일 때
     */
    public static boolean isValid(String s) {
        return isValid(s, "HH:mm:ss");
    }

    /**
     * "HH:mm" 또는 "HH/mm" 형태의 <code>java.util.Date</code> 객체를 리턴한다.
     *
     * @param s
     *            "HH:mm" 또는 "HH/mm" 형태의 현재 시각(몇시 몇분)을 나타내는 문자열
     * @return 인자로 전달된 시각에 해당하는 <code>java.util.Date</code> 객체
     * @throws java.text.ParseException
     *             인자로 전달된 시각이 지정된 포멧("HH:mm" or "HH/mm" 에) 맞지 않거나 올바른 시간이 아닐경우 발생.
     */
    public static Date getDateInstance(String s) throws java.text.ParseException {
        String format = "HH:mm";

        if (!isValid(s, "HH:mm")) {
            if (isValid(s, "HH/mm")) {
                format = "HH/mm";
            } else {
                throw new java.text.ParseException("wrong data or format", 0);
            }
        }
        return check(s, format);
    }

    /**
     * check date string validation with an user defined format.
     *
     * @param s
     *            date string you want to check.
     * @param format
     *            string representation of the date format. For example, "yyyy-MM-dd".
     * @return <tt>true</tt> 날짜 형식이 맞고, 존재하는 날짜일 때. <tt>false</tt> 날짜 형식이 맞지 않거나, 존재하지 않는 날짜일 때
     */
    public static boolean isValid(String s, String format) {
        /*
         * if ( s == null ) throw new NullPointerException("date string to check is null"); if ( format == null ) throw new NullPointerException("format string to check date is null");
         */
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format, java.util.Locale.KOREA);
        java.util.Date date = null;
        try {
            date = formatter.parse(s);
        } catch (java.text.ParseException e) {
            return false;
        }

        if (!formatter.format(date).equals(s))
            return false;

        return true;
    }

    /**
     * 현재 날짜를 "yyyy-MM-dd" 형태의 포멧으로 표현하는 문자열을 리턴한다.
     *
     * @return formatted string representation of current day with "yyyy-MM-dd".
     */
    public static String getDateString() {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.KOREA);
        return formatter.format(new java.util.Date());
    }

    /**
     *
     * 오늘 날짜를 숫자로 리턴한다. <code>getNumberByPattern("dd");</code>
     *
     * @return 오늘 날짜.(1~31)
     * @see #getNumberByPattern(String)
     */
    /*
     * public static int getDay() { return getNumberByPattern("dd"); }
     */
    /**
     *
     * 올해를 숫자로 리턴한다. <code> getNumberByPattern("yyyy");</code>
     *
     * @return 올해를 표현하는 4자리 숫자(예:2005)
     * @see #getNumberByPattern(String)
     */
    /*
     * public static int getYear() { return getNumberByPattern("yyyy"); }
     */
    /**
     *
     * 이번달을 숫자로 리턴한다. <code>getNumberByPattern("MM");</code>
     *
     * @return 이번달을 표현하는 숫자 (1~12)
     * @see #getNumberByPattern(String)
     */
    /*
     * public static int getMonth() { return getNumberByPattern("MM"); }
     */
    /**
     *
     * 현재 시간을 리턴한다. <code>getNumberByPattern("HH");</code>
     *
     * @return 현재 시간을 표현하는 숫자(1~24)
     * @see #getNumberByPattern(String)
     */
    /*
     * public static int getHour() { return getNumberByPattern("HH"); }
     */

    /**
     *
     * 현재 시각의 분을 리턴한다. <code>getNumberByPattern("mm");</code>
     *
     * @return 현재 시각중 분을 표현하는 숫자(0~59)
     * @see #getNumberByPattern(String)
     */
    public static int getMin() {
        return getNumberByPattern("mm");
    }

    /**
     *
     *인자로 전달된 패턴에 해당하는 값을 숫자로 리턴한다.
     *
     * 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int currentYearValue = DateTimeUtil.getNumberByPattern(&quot;yyyy&quot;);
     * </pre>
     *
     * </blockquote>
     *
     *
     * @param pattern
     *            "yyyy, MM, dd, HH, mm, ss,SSS"
     * @return 현재의 날짜,달,연,시간,분,초 등을 나타내는 숫자값
     */
    public static int getNumberByPattern(String pattern) {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(pattern, java.util.Locale.KOREA);
        String dateString = formatter.format(new java.util.Date());
        return Integer.parseInt(dateString);
    }

    /**
     *인자로 전달된 시각을 표현하는 문자열에서 특정 부분의(년도 or 시 or 분 or 초 ...) 값을 숫자로 리턴한다.
     *
     *시각을 표현하는 문자열 2005/01/21 12:45:31 에서 초 부분을 나타내는 값을 얻어오려면 아래와 같이 코딩하면 된다.
     * <p>
     * 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int seconds = DateTimeUtiil.getNumberByPattern(&quot;2005/01/21 12:45:31&quot;, &quot;yyyy/MM/dd hh:mm:ss&quot;, &quot;ss&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param dates
     *            기준 시각
     * @param spattern
     *            <code>dates</code> 시각을 표현하는 날짜 포멧
     * @param pattern
     *            "yyyy, MM, dd, HH, mm, ss and more"
     * @return formatted string representation of current day and time with your pattern.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 spattern format 에 맞지 않는 경우.
     */
    public static int getNumberByPattern(String dates, String spattern, String pattern) throws java.text.ParseException {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(pattern, java.util.Locale.KOREA);
        String dateString = formatter.format(check(dates, spattern));
        return Integer.parseInt(dateString);
    }

    /**
     * 현재 시각을 인자로 전달된 형태의 포멧으로 표현하는 문자열을 리턴한다. 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String time = DateTime.getFormatString(&quot;yyyy-MM-dd HH:mm:ss:SSS&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param pattern
     *            "yyyy, MM, dd, HH, mm, ss and more"
     * @return formatted string representation of current day and time with your pattern.
     */
    public static String getFormatString(String pattern) {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(pattern, java.util.Locale.KOREA);
        String dateString = formatter.format(new java.util.Date());
        return dateString;
    }

    /**
     * 현재 시각을 "yyyyMMdd" 형태의 문자열로 표현하여 리턴한다. 예) "20040205" <code>getFormatString("yyyyMMdd");</code>
     *
     * @return formatted string representation of current day with "yyyyMMdd".
     * @see #getFormatString(String)
     */
    public static String getShortDateString() {
        return getFormatString("yyyyMMdd");
    }

    /**
     * 현재 시각을 "yyyy-MM-dd" 형태의 문자열로 표현하여 리턴한다. 예) "2004-02-05" <code>getFormatString("yyyy-MM-dd");</code>
     *
     * @return formatted string representation of current day with "yyyy-MM-dd".
     * @see #getFormatString(String)
     */
    public static String getShortDateDashString() {
        return getFormatString("yyyy-MM-dd");
    }

    /**
     * 현재 시각을 "HHmmss" 형태의 문자열로 표현하여 리턴한다. <code>getFormatString("HHmmss");</code>
     *
     * @return formatted string representation of current time with "HHmmss".
     * @see #getFormatString(String)
     */
    public static String getShortTimeString() {

        return getFormatString("HHmmss");
    }

    /**
     * 현재 시각을 "yyyy-MM-dd-HH:mm:ss:SSS" 형태의 문자열로 표현하여 리턴한다. <code>getFormatString("yyyy-MM-dd-HH:mm:ss:SSS");</code>
     *
     * @return formatted string representation of current time with "yyyy-MM-dd-HH:mm:ss".
     * @see #getFormatString(String)
     */
    public static String getTimeStampString() {

        return getFormatString("yyyy-MM-dd-HH:mm:ss:SSS");
    }

    /**
     * 현재 시각을 "HH:mm:ssSSS" 형태의 문자열로 표현하여 리턴한다. 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String timeString = getFormatString(&quot;HH:mm:ss&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @return formatted string representation of current time with "HH:mm:ss".
     * @see #getFormatString(String)
     */
    public static String getTimeString() {
        return getFormatString("HH:mm:ss");
    }

    /**
     * 인자로 전달된 "yyyyMMdd" 형태의 날짜가 무슨 요일 인지 리턴한다. 요일에 해당하는 값은 숫자로 리턴되고 이 값은 1~7에 해당한다.
     *
     * 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String s = &quot;20000529&quot;;
     * int dayOfWeek = whichDay(s);
     * if (dayOfWeek == java.util.Calendar.MONDAY)
     * 	System.out.println(&quot; 월요일: &quot; + dayOfWeek);
     * if (dayOfWeek == java.util.Calendar.TUESDAY)
     * 	System.out.println(&quot; 화요일: &quot; + dayOfWeek);
     * </pre>
     *
     * </blockquote>
     *
     * return days between two date strings with default defined format.(yyyyMMdd)
     *
     * @param s
     *            date string you want to check.
     * @return 다음의 값중 하나를 리턴.
     *
     *         <pre>
     *          1: 일요일 (java.util.Calendar.SUNDAY)
     *          2: 월요일 (java.util.Calendar.MONDAY)
     *          3: 화요일 (java.util.Calendar.TUESDAY)
     *          4: 수요일 (java.util.Calendar.WENDESDAY)
     *          5: 목요일 (java.util.Calendar.THURSDAY)
     *          6: 금요일 (java.util.Calendar.FRIDAY)
     *          7: 토요일 (java.util.Calendar.SATURDAY)
     * </pre>
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 "yyyyMMdd" 형식에 맞지 않는 경우.
     *
     */
    public static int whichDay(String s) throws java.text.ParseException {
        return whichDay(s, "yyyyMMdd");
    }

    /**
     * 인자로 전달된 <code>format</code>형태의 날짜 <code>s</code>가 무슨 요일 인지 리턴한다. 요일에 해당하는 값은 숫자로 리턴되고 이 값은 1~7에 해당한다.
     *
     * 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String s = &quot;2000-05-29&quot;;
     * int dayOfWeek = whichDay(s, &quot;yyyy-MM-dd&quot;);
     * if (dayOfWeek == java.util.Calendar.MONDAY)
     * 	System.out.println(&quot; 월요일: &quot; + dayOfWeek);
     * if (dayOfWeek == java.util.Calendar.TUESDAY)
     * 	System.out.println(&quot; 화요일: &quot; + dayOfWeek);
     * </pre>
     *
     * </blockquote>
     *
     * @param s
     *            date string you want to check.
     * @param format
     *            날짜를 표현하는 포멧.
     * @return 다음의 값중 하나를 리턴.
     *
     *         <pre>
     *          1: 일요일 (java.util.Calendar.SUNDAY)
     *          2: 월요일 (java.util.Calendar.MONDAY)
     *          3: 화요일 (java.util.Calendar.TUESDAY)
     *          4: 수요일 (java.util.Calendar.WENDESDAY)
     *          5: 목요일 (java.util.Calendar.THURSDAY)
     *          6: 금요일 (java.util.Calendar.FRIDAY)
     *          7: 토요일 (java.util.Calendar.SATURDAY)
     * </pre>
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 format 형식에 맞지 않는 경우.
     */
    public static int whichDay(String s, String format) throws java.text.ParseException {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format, java.util.Locale.KOREA);
        java.util.Date date = check(s, format);

        java.util.Calendar calendar = formatter.getCalendar();
        calendar.setTime(date);
        return calendar.get(java.util.Calendar.DAY_OF_WEEK);
    }

    /**
     * 인자로 전달된 <code>from</code> 날짜와 <code>to</code> 날짜 사이의 '날(day)'차이를 리턴한다. 두 날짜의 표현포멧은 "yyyyMMdd"이다.
     * <p>
     * 2005년 1월1일부터 2005년3월25일 사이의 날짜수를 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int daysCount = DateTimeUtil.daysBetween(&quot;20050101&quot;, &quot;20050325&quot;);
     * </pre>
     *
     * </blockquote> return days between two date strings with default defined format.("yyyyMMdd")
     *
     * @param from
     *            date string
     * @param to
     *            date string
     * @return 두 날짜 사이의 '날(day)'의 차이.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 "yyyyMMdd" 형식에 맞지 않는 경우.
     */
    public static int daysBetween(String from, String to) throws java.text.ParseException {
        return daysBetween(from, to, "yyyyMMdd");
    }

    /**
     * 인자로 전달된 <code>from</code> 날짜와 <code>to</code> 날짜 사이의 '날(day)'차이를 리턴한다. 이때 두 날짜를 표현하는 포멧은 <code>format</code>을 사용한다.
     * <p>
     * 2005년 1월1일부터 2005년3월25일 사이의 날짜수를 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int daysCount = DateTimeUtil.daysBetween(&quot;20050101&quot;, &quot;20050325&quot;, &quot;yyyyMMdd&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param from
     *            date string
     * @param to
     *            date string
     * @param format
     *            두 시각을 표현하는 포멧 문자열.
     * @return 두 시각 사이의 '날(day)'의 차이.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 format 형식에 맞지 않는 경우.
     */
    public static int daysBetween(String from, String to, String format) throws java.text.ParseException {
        java.util.Date d1 = check(from, format);
        java.util.Date d2 = check(to, format);

        long duration = d2.getTime() - d1.getTime();

        return (int) (duration / (1000 * 60 * 60 * 24));
        // seconds in 1 day
    }

    /**
     * 인자로 전달된 <code>from</code>시각과 <code>to</code> 시각 사이의 '시간 (time)'차이를 리턴한다. 두 시각의 표현포멧은 "yyyyMMdd"이다.
     *<p>
     * 2005년 1월1일부터 2005년3월25일 사이의 시간을 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int timesCount = DateTimeUtil.timesBetween(&quot;20050101&quot;, &quot;20050325&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param from
     *            date string
     * @param to
     *            date string
     * @return 두 시각 사이의 '시간(time)'의 차이.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 "yyyyMMdd" 형식에 맞지 않는 경우.
     */
    public static int timesBetween(String from, String to) throws java.text.ParseException {
        return timesBetween(from, to, "yyyyMMdd");
    }

    /**
     * 인자로 전달된 <code>from</code> 시각과 <code>to</code> 시각 사이의 '시간(time)'차이를 리턴한다. 두 시각의 표현포멧은 <code>format</code>을 사용한다.
     * <p>
     * 2005년 1월1일부터 11시와 2005년3월25일 23시 사이의 시간을 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int timesCount = DateTimeUtil.timesBetween(&quot;2005/01/01/ 11&quot;, &quot;2005/03/25 23&quot;, &quot;yyyy/MM/dd hh&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param from
     *            date string
     * @param to
     *            date string
     * @param format
     *            시각들을 표현하는 포멧 문자열.
     * @return 두 시각 사이의 '시간(time)'의 차이.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static int timesBetween(String from, String to, String format) throws java.text.ParseException {

        java.util.Date d1 = check(from, format);
        java.util.Date d2 = check(to, format);

        long duration = d2.getTime() - d1.getTime();

        return (int) (duration / (1000 * 60 * 60));
        // seconds in 1 day
    }

    /**
     * 인자로 전달된 <code>from</code> 시각과 <code>to</code> 시각 사이의 '분(minute)'차이를 리턴한다. 두 시간의 표현포멧은 <code>format</code>을 사용한다. <p<2005년 1월1일 11시 10분 부터 2005년3월25일 23시 59분 사이의 '분'을 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int minCount = DateTimeUtil.minsBetween(&quot;2005/01/01 11:10&quot;, &quot;2005/03/25 23:59&quot;, &quot;yyyy/MM/dd hh:mm&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param from
     *            date string
     * @param to
     *            date string
     * @param format
     *            시각들을 표현하는 포멧 문자열.
     * @return 두 시각 사이의 '시간(time)'의 차이.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static int minsBetween(String from, String to, String format) throws java.text.ParseException {

        java.util.Date d1 = check(from, format);
        java.util.Date d2 = check(to, format);

        long duration = d2.getTime() - d1.getTime();

        return (int) (duration / (1000 * 60));
        // seconds in 1 day
    }

    /**
     * 인자로 전달된 <code>from</code> 시각과 <code>to</code> 시각 사이의 시간차이를 'hh시간 mm분' 이란 문자열로 리턴한다. 두 시각의 표현 포멧은 <code>format</code>을 사용한다. 2005년 1월1일 11시 10분 부터 2005년3월25일 23시 59분 사이의 시간차를 표현하는 문자열을 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String timeGap = DateTimeUtil.timesBetweenStr(&quot;2005/01/01 11:10&quot;, &quot;2005/03/25 23:59&quot;, &quot;yyyy/MM/dd hh:mm&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param from
     *            date string
     * @param to
     *            date string
     * @param format
     *            시각들을 표현하는 포멧 문자열.
     * @return 두 날짜 사이의 시간차이를 표현하는 'hh시간 mm분'이란 형태의 문자열.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static String timesBetweenStr(String from, String to, String format) throws java.text.ParseException {

        int min = minsBetween(from, to, format);
        if (min < 0) {
            throw new RuntimeException("비교시간 결과가 음수 입니다");
        }
        int time = min / 60;
        min = min % 60;
        return new String(time + "시간 " + min + "분");
        // seconds in 1 day
    }

    /**
     * 인자로 전달된 <code>from</code> 시각과 <code>to</code> 시각 사이의 개월수 차이를 리턴한다. 두 시각의 표현 포멧은 <code>"yyyyMMdd"</code>를 사용한다. 2005년 1월1일부터 2005년3월25일 사이의 개월수 차 를 표현하는 문자열을 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int monthGap = DateTimeUtil.monthsBetween(&quot;20050101&quot;, &quot;20050325&quot;);
     *
     * </pre>
     *
     * </blockquote>
     *
     * @param from
     *            date string
     * @param to
     *            date string
     * @return 두 날짜 사이의 개월수 차이
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>"yyyyMMdd"</code> 형식에 맞지 않는 경우.
     */
    public static int monthsBetween(String from, String to) throws java.text.ParseException {
        return monthsBetween(from, to, "yyyyMMdd");
    }

    /**
     * 인자로 전달된 <code>from</code> 시각과 <code>to</code> 시각 사이의 개월수 차이를 리턴한다. 두 시각의 표현 포멧은 <code>format</code>을 사용한다. 2005년 1월1일 11시 10분 부터 2005년3월25일 23시 59분 사이의 개월수 차 를 표현하는 문자열을 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int monthGap = DateTimeUtil.monthsBetween(&quot;2005/01/01 11:10&quot;, &quot;2005/03/25 23:59&quot;, &quot;yyyy/MM/dd hh:mm&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param from
     *            date string
     * @param to
     *            date string
     * @param format
     *            시각들을 표현하는 포멧 문자열.
     * @return 두 날짜 사이의 개월수 차이
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static int monthsBetween(String from, String to, String format) throws java.text.ParseException {
        java.util.Date fromDate = check(from, format);
        java.util.Date toDate = check(to, format);

        // if two date are same, return 0.
        if (fromDate.compareTo(toDate) == 0)
            return 0;

        java.text.SimpleDateFormat yearFormat = new java.text.SimpleDateFormat("yyyy", java.util.Locale.KOREA);
        java.text.SimpleDateFormat monthFormat = new java.text.SimpleDateFormat("MM", java.util.Locale.KOREA);
        java.text.SimpleDateFormat dayFormat = new java.text.SimpleDateFormat("dd", java.util.Locale.KOREA);

        int fromYear = Integer.parseInt(yearFormat.format(fromDate));
        int toYear = Integer.parseInt(yearFormat.format(toDate));
        int fromMonth = Integer.parseInt(monthFormat.format(fromDate));
        int toMonth = Integer.parseInt(monthFormat.format(toDate));
        int fromDay = Integer.parseInt(dayFormat.format(fromDate));
        int toDay = Integer.parseInt(dayFormat.format(toDate));

        int result = 0;
        result += ((toYear - fromYear) * 12);
        result += (toMonth - fromMonth);

        // if (((toDay - fromDay) < 0) ) result += fromDate.compareTo(toDate);
        // ceil과 floor의 효과
        if (((toDay - fromDay) > 0))
            result += toDate.compareTo(fromDate);

        return result;
    }

    /**
     * 인자로 전달된 <code>from</code> 시각과 <code>to</code> 시각 사이의 년도 차이를 리턴한다. 두 시각의 표현 포멧은 "yyyyMMdd"이다.
     *
     * <p>
     * 1975년 2월 5일 태어난 사람의 현재 만 나이를 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int age = DateTimeUtil.ageBetween(&quot;19750205&quot;, getFormatString(&quot;yyyyMMdd&quot;));
     * </pre>
     *
     * </blockquote>
     *
     * @param from
     *            date string
     * @param to
     *            date string
     * @return 두 날짜 사이의 년도 차이(나이)를 리턴한다.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>"yyyyMMdd"</code> 형식에 맞지 않는 경우.
     */
    public static int ageBetween(String from, String to) throws java.text.ParseException {
        return ageBetween(from, to, "yyyyMMdd");
    }

    /**
     * 현재 시각을 기준으로 인자로 전달된 날짜 사이의 연도 차이를 리턴한다. 날짜의 표현 포멧은 "yyyyMMdd"이다. return age between two date strings with default defined format.("yyyyMMdd")
     *<p>
     * 1975년 2월 5일 태어난 사람의 현재 만 나이를 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int age = DateTimeUtil.age(&quot;19750205&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param birth
     *            비교하고자 하는 기준이 되는 날짜
     * @return 현재 날짜와 birth 사이의 년도 차이를 리턴한다.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>"yyyyMMdd'</code> 형식에 맞지 않는 경우.
     * @see #ageBetween(String, String)
     */
    public static int age(String birth) throws java.text.ParseException {
        return ageBetween(birth, getFormatString("yyyyMMdd"), "yyyyMMdd");
    }

    /**
     * 인자로 전달된 <code>from</code> 시각과 <code>to</code> 시각 사이의 년도 차이를 리턴한다. 두 시각의 표현 포멧은<code>format</code>을 사용한다.
     * <p>
     * 1975년 2월 5일 태어난 사람의 현재 만 나이를 구하는 코드:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int age = DateTimeUtil.ageBetween(&quot;19750205&quot;, getFormatString(&quot;yyyyMMdd&quot;), &quot;yyyyMMdd&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param from
     *            date string
     * @param to
     *            date string
     * @param format
     *            날짜를 표현할 때 사용할 표현 포멧을 나타내는 문자열.
     * @return 두 날짜 사이의 년도 차이를 리턴한다.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static int ageBetween(String from, String to, String format) throws java.text.ParseException {
        return (int) (daysBetween(from, to, format) / 365);
    }

    /**
     * 인자로 전달된 날짜 <code>s</code>를 기준으로 특정 일(day) 수를 더한 날짜를 표현하는 문자열을 리턴한다. 날짜의 포현 포멧은 "yyyyMMdd"를 사용한다.
     * <p>
     * 2005년 2월 25일에서 일주일(7일) 후의 날짜를 표현하는 문자열을 얻어오는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String dateString = DateTimeUtil.addDays(&quot;20050225&quot;, 7);
     * </pre>
     *
     * </blockquote>
     *
     * @param s
     *            기준 날짜
     * @param day
     *            더할 일수
     * @return 더해진 날짜를 표현하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>"yyyyMMdd"</code> 형식에 맞지 않는 경우.
     */
    public static String addDays(String s, int day) throws java.text.ParseException {
        return addDays(s, day, "yyyyMMdd");
    }

    /**
     * 오늘을 기준으로 특정 일(day) 수를 더한 날짜를 표현하는 문자열을 리턴한다. 날짜의 포현 포멧은 "yyyyMMdd"를 사용한다.
     * <p>
     * 오늘을 기준으로 일주일(7일) 후의 날짜를 표현하는 문자열 얻어오는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String dateString = DateTimeUtil.addDays(7);
     * </pre>
     *
     * </blockquote>
     *
     * @param day
     *            더할 일수
     * @return 더해진 날짜를 표현하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>"yyyyMMdd"</code> 형식에 맞지 않는 경우.
     */
    public static String addDays(int day) throws java.text.ParseException {
        return addDays(getShortDateString(), day, "yyyyMMdd");
    }

    /**
     * 오늘기준으로 특정 일(day) 수를 더한 날짜를 구한 후 인자로 전달된 <code>format</code> 형식으로 표현하는 문자열을 리턴한다.
     * <p>
     * 오늘을 기준으로 일주일(7일) 후의 날짜를 "yyyy/MM/dd" 형식으로 표현하는 문자열 얻어오는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String dateString = DateTimeUtil.addDays(7, &quot;yyyy/MM/dd&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param day
     *            더할 일수
     * @param format
     *            날짜 표현 포멧
     * @return 더해진 날짜를 표현하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>"yyyyMMdd"</code> 형식에 맞지 않는 경우.
     */
    public static String addDays(int day, String format) throws java.text.ParseException {
        String today = getShortDateString();
        String tmp = addDays(today, day, "yyyyMMdd");
        return changeFormat(tmp, "yyyyMMdd", format);
    }

    /**
     * 인자로 전달된 날짜 <code>s</code> 에서 특정 일(day) 수를 더한 날짜를 인자로 전달된 <code>format</code> 형식으로 표현하는 문자열을 리턴한다.
     * <p>
     * 2005년 2월 25일에서 일주일(7일) 후의 날짜를 표현하는 문자열 얻어오는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String dateString = DateTimeUtil.addDays(&quot;20050225&quot;, 7, &quot;yyyyMMdd&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param s
     *            기준 날짜
     * @param day
     *            더할 일수
     * @param format
     *            날짜 표현 포멧
     * @return 더해진 날짜를 표현하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static String addDays(String s, int day, String format) {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format, java.util.Locale.KOREA);
        java.util.Date date = null;

        try {
            date = check(s, format);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        date.setTime(date.getTime() + ((long) day * 1000 * 60 * 60 * 24));
        return formatter.format(date);
    }

    /**
     * 인자로 전달된 시각 <code>s</code> 에서 특정 시간(time)을 더한 시각을 인자로 전달된 <code>format</code> 형식으로 표현하는 문자열을 리턴한다.
     * <p>
     * 2005년 2월 25일에서 일주일(7일) 후의 날짜를 표현하는 문자열 얻어오는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String dateString = DateTimeUtil.addDays(&quot;20050225&quot;, 7, &quot;yyyyMMdd&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param s
     *            기준 날짜
     * @param time
     *            더할 시간
     * @param format
     *            날짜 표현 포멧
     * @return 더해진 시각을 표현하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static String addTimes(String s, int time, String format) throws java.text.ParseException {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format, java.util.Locale.KOREA);
        java.util.Date date = check(s, format);

        date.setTime(date.getTime() + ((long) 1000 * 60 * 60 * time));
        return formatter.format(date);
    }

    /**
     * 현재시각 에서 특정 시간(time)을 더한 시각을 인자로 전달된 <code>format</code> 형식으로 표현하는 문자열을 리턴한다.
     * <p>
     * 현재시각에서 23시간 후를 표현하는 문자열 얻어오는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String dateString = DateTimeUtil.addDays(23, &quot;yyyy/MM/dd hh:mm&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param time
     *            더할 시간
     * @param format
     *            시각 표현 포멧
     * @return 더해진 시각을 표현하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static String addTimes(int time, String format) throws java.text.ParseException {
        String fomatted = getFormatString(format);
        return addTimes(fomatted, time, format);
    }

    /**
     * 세계표준시(Universal Time Coordinated)를 "yyyy-MM-ddTHH:mm:ss:SSSZ" 형태의 포멧으로 리턴한다.
     *
     * @return UTC time
     */
    public static String getUTCTimeString() {
        String ret = "";
        try {
            ret = addTimes(-9, "yyyy-MM-dd HH:mm:ss:SSS ");
            char rets[] = ret.toCharArray();
            rets[10] = 'T';
            rets[23] = 'Z';
            ret = new String(rets);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 인자로 전달된 날짜 <code>s</code>를 기준으로 특정 개월(month) 수를 더한 날짜를 표현하는 문자열을 리턴한다. 날짜의 포현 포멧은 "yyyyMMdd"를 사용한다.
     * <p>
     * 2005년 2월 25일에서 7개월 전의 날짜를 표현하는 문자열을 얻어오는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String monthString = DateTimeUtil.addDays(&quot;20050225&quot;, -7);
     * </pre>
     *
     * </blockquote>
     *
     * @param s
     *            기준 날짜
     * @param month
     *            더할 개월수
     * @return 더해진 날짜를 표현하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>"yyyyMMdd"</code> 형식에 맞지 않는 경우.
     */
    public static String addMonths(String s, int month) throws ParseException {
        return addMonths(s, month, "yyyyMMdd");
    }

    /**
     * 인자로 전달된 시각 <code>s</code> 에서 특정 개월(month)을 더한 시각을 인자로 전달된 <code>format</code> 형식으로 표현하는 문자열을 리턴한다.
     * <p>
     * 2005년 2월 25일에서 7개월 후의 날짜를 표현하는 문자열 얻어오는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String dateString = DateTimeUtil.addDays(&quot;20050225&quot;, 7, &quot;yyyyMMdd&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param s
     *            기준 날짜
     * @param addMonth
     *            더할 개월
     * @param format
     *            날짜 표현 포멧
     * @return 더해진 시각을 표현하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static String addMonths(String s, int addMonth, String format) throws ParseException {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format, java.util.Locale.KOREA);
        java.util.Date date = check(s, format);

        java.text.SimpleDateFormat yearFormat = new java.text.SimpleDateFormat("yyyy", java.util.Locale.KOREA);
        java.text.SimpleDateFormat monthFormat = new java.text.SimpleDateFormat("MM", java.util.Locale.KOREA);
        java.text.SimpleDateFormat dayFormat = new java.text.SimpleDateFormat("dd", java.util.Locale.KOREA);
        int year = Integer.parseInt(yearFormat.format(date));
        int month = Integer.parseInt(monthFormat.format(date));
        int day = Integer.parseInt(dayFormat.format(date));

        month += addMonth;
        if (addMonth > 0) {
            while (month > 12) {
                month -= 12;
                year += 1;
            }
        } else {
            while (month <= 0) {
                month += 12;
                year -= 1;
            }
        }
        java.text.DecimalFormat fourDf = new java.text.DecimalFormat("0000");
        java.text.DecimalFormat twoDf = new java.text.DecimalFormat("00");
        String tempDate = String.valueOf(fourDf.format(year)) + String.valueOf(twoDf.format(month)) + String.valueOf(twoDf.format(day));
        java.util.Date targetDate = null;

        try {
            targetDate = check(tempDate, "yyyyMMdd");
        } catch (java.text.ParseException pe) {
            day = lastDay(year, month);
            tempDate = String.valueOf(fourDf.format(year)) + String.valueOf(twoDf.format(month)) + String.valueOf(twoDf.format(day));
            targetDate = check(tempDate, "yyyyMMdd");
        }

        return formatter.format(targetDate);
    }

    /**
     * 인자로 전달된 날짜 <code>s</code>를 기준으로 특정 연도(year) 수를 더한 날짜를 표현하는 문자열을 리턴한다. 날짜의 포현 포멧은 "yyyyMMdd"를 사용한다.
     * <p>
     * 2005년 2월 28일에서 3년 전의 날짜를 표현하는 문자열을 얻어오는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String yearString = DateTimeUtil.addDays(&quot;20050228&quot;, -3);
     * </pre>
     *
     * </blockquote>
     *
     * @param s
     *            기준 날짜
     * @param year
     *            더할 년수
     * @return 더해진 날짜를 표현하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>"yyyyMMdd"</code> 형식에 맞지 않는 경우.
     */
    public static String addYears(String s, int year) throws java.text.ParseException {
        return addYears(s, year, "yyyyMMdd");
    }

    /**
     * 인자로 전달된 날짜 <code>s</code>를 기준으로 특정 연도(year) 수를 더한 날짜를 표현하는 문자열을 리턴한다. 날짜의 포현 포멧은 <code>format</code>를 사용한다.
     * <p>
     * 2005년 2월 28일에서 3년 전의 날짜를 표현하는 문자열을 얻어오는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String yearString = DateTimeUtil.addDays(&quot;20050228&quot;, -3, &quot;yyyyMMdd&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param s
     *            기준 날짜
     * @param year
     *            더할 년수
     * @param format
     *            날짜를 표현하는 포현 포멧
     * @return 더해진 날짜를 표현하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static String addYears(String s, int year, String format) throws java.text.ParseException {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format, java.util.Locale.KOREA);
        java.util.Date date = check(s, format);
        date.setTime(date.getTime() + ((long) year * 1000 * 60 * 60 * 24 * (365 + 1)));
        return formatter.format(date);
    }

    /**
     * 인자로 전달된 날짜 <code>src</code>에 해당하는 달의 마지막 날을 표현하는 날짜를 리턴한다. 날짜 표시 포멧으로 "yyyyMMdd"을 사용한다. 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String datesStr = DateTimeUtil.lastDayOfMonth(&quot;20050203&quot;);
     * datesStr.equals(&quot;20050228&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param src
     *            기준이 되는 날짜
     * @return src에 날짜중 그 달의 마지막 날을 표시하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>"yyyyMMdd"</code> 형식에 맞지 않는 경우.
     */

    public static String lastDayOfMonth(String src) throws java.text.ParseException {
        return lastDayOfMonth(src, "yyyyMMdd");
    }

    /**
     * 인자로 전달된 날짜 <code>src</code>에 해당하는 달의 마지막 날을 표현하는 날짜를 리턴한다. 날짜 표시 포멧으로 <code>format</code>을 사용한다. 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * String datesStr = DateTimeUtil.lastDayOfMonth(&quot;20050203&quot;, &quot;yyyyMMdd&quot;);
     * datesStr.equals(&quot;20050228&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param src
     *            기준이 되는 날짜
     * @param format
     *            날짜를 표시하는 표시포멧
     * @return src에 날짜중 그 달의 마지막 날을 표시하는 문자열
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>format</code> 형식에 맞지 않는 경우.
     */
    public static String lastDayOfMonth(String src, String format) throws java.text.ParseException {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format, java.util.Locale.KOREA);
        java.util.Date date = check(src, format);

        java.text.SimpleDateFormat yearFormat = new java.text.SimpleDateFormat("yyyy", java.util.Locale.KOREA);
        java.text.SimpleDateFormat monthFormat = new java.text.SimpleDateFormat("MM", java.util.Locale.KOREA);

        int year = Integer.parseInt(yearFormat.format(date));
        int month = Integer.parseInt(monthFormat.format(date));
        int day = lastDay(year, month);

        java.text.DecimalFormat fourDf = new java.text.DecimalFormat("0000");
        java.text.DecimalFormat twoDf = new java.text.DecimalFormat("00");
        String tempDate = String.valueOf(fourDf.format(year)) + String.valueOf(twoDf.format(month)) + String.valueOf(twoDf.format(day));
        date = check(tempDate, format);

        return formatter.format(date);
    }

    /**
     * 특정 연도 특정 월의 일수를 리턴한다.
     * <p>
     * 2005 년 2월은 몇일이 존재하는지 확인하는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * int days = DateTimeUtil.lastDay(2005, 2);
     * </pre>
     *
     * </blockquote>
     *
     * @param year
     *            년도
     * @param month
     *            개월
     * @return 마지막 일자(일 수)
     */
    private static int lastDay(int year, int month) {
        int day = 0;
        switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            day = 31;
            break;
        case 2:
            if ((year % 4) == 0) {
                if ((year % 100) == 0 && (year % 400) != 0) {
                    day = 28;
                } else {
                    day = 29;
                }
            } else {
                day = 28;
            }
            break;
        default:
            day = 30;
        }
        return day;
    }

    /**
     * 인자로 전달된 날짜를 나타내는 <code>s</code> 문자열이 "yyyy/MM/dd HH:mm" 형식에 맞는지 확인한다.
     *
     * @param s
     *            확인하려는 날짜를 나타내는 문자열
     * @return 인자로 전달된 날짜를 나타내는 문자열.
     * @exception java.text.ParseException
     *                잘못된 날짜이거나. 날짜를 표현하는 문자열이 <code>"yyyy/MM/dd HH:mm"</code> 형식에 맞지 않는 경우.
     */
    public static String checkDateTime(String s) throws ParseException {
        check(s, "yyyy/MM/dd HH:mm");
        return s;
    }

    /**
     * 기준 시각 (<code>checkTime</code>)이 시작시각(<code>startTime</code>) 과 종료시각( <code>endTime</code>) 사이에 위치하는지 여부를 리턴한다. 인자로 전달되는 시각들은 "HH:mm" 또는 "HH/mm" 형태의 포멧이어야 한다.
     * <p>
     * 영업시간이 오전 9시부터 18시 30분까지 일 경우 현재 시간에 영업이 가능한 지 확인하는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * boolean isOpen = DateTimeUtil.isMiddleTime(&quot;09:00&quot;, &quot;18:30&quot;, getFormatString(&quot;HH:mm&quot;));
     * </pre>
     *
     * </blockquote>
     *
     * @param startTime
     *            시작 시각 ("HH:mm" or "HH/mm" 포멧)
     * @param endTime
     *            종료 시각 ("HH:mm" or "HH/mm" 포멧)
     * @param checkTime
     *            기준 시각 ("HH:mm" or "HH/mm" 포멧)
     * @return <tt>true</tt> 기준 시각 (<code>checkTime</code>)이 시작시각( <code>startTime</code>) 과 종료시각(<code>endTime</code>) 사이에 위치한다.
     * @throws java.text.ParseException
     *             인자로 전달된 시각이 지정된 포멧("HH:mm" or "HH/mm" 에) 맞지 않거나 올바른 시간이 아닐경우 발생.
     */
    public static boolean isMiddleTime(String startTime, String endTime, String checkTime) throws ParseException {
        Date a = getDateInstance(startTime);
        Date b = getDateInstance(endTime);
        Date c = getDateInstance(checkTime);
        return isMiddleTime(a, b, c);

    }

    /**
     * 기준 시각 (<code>checkTime</code>)이 시작시각(<code>startTime</code>) 과 종료시각( <code>endTime</code>) 사이에 위치하는지 여부를 리턴한다.
     *
     * @param startTime
     *            시작 시각
     * @param endTime
     *            종료 시각
     * @param checkTime
     *            기준 시각
     * @return <tt>true</tt> 기준 시각 (<code>checkTime</code>)이 시작시각( <code>startTime</code>) 과 종료시각(<code>endTime</code>) 사이에 위치한다.
     */
    public static boolean isMiddleTime(Date startTime, Date endTime, Date checkTime) {

        if (startTime.before(endTime)) {
            if (endTime.after(checkTime) && startTime.before(checkTime))
                return true;
        } else {
            if (endTime.after(checkTime) || startTime.before(checkTime)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 현재 시각이 시작시각(<code>startTime</code>) 과 종료시각(<code>endTime</code>) 사이에 위치하는지 여부를 리턴한다. 인자로 전달되는 시각들은 "HH:mm" 또는 "HH/mm" 형태의 포멧이어야 한다.
     * <p>
     * 영업시간이 오전 9시부터 18시 30분까지 일 경우 현재 시간에 영업이 가능한 지 확인하는 코드 사용예:
     * <p>
     * <blockquote>
     *
     * <pre>
     * boolean isOpen = DateTimeUtil.isMiddleTime(&quot;09:00&quot;, &quot;18:30&quot;);
     * </pre>
     *
     * </blockquote>
     *
     * @param startTime
     *            시작 시각 ("HH:mm" or "HH/mm" 포멧)
     * @param endTime
     *            종료 시각 ("HH:mm" or "HH/mm" 포멧)
     * @return <tt>true</tt> 현재 시각이 시작 시각(<code>startTime</code>) 과 종료 시각( <code>endTime</code>) 사이에 위치한다.
     * @throws java.text.ParseException
     *             인자로 전달된 시각이 지정된 포멧("HH:mm" or "HH/mm" 에) 맞지 않거나 올바른 시간이 아닐경우 발생.
     */
    public static boolean isMiddleTime(String startTime, String endTime) throws ParseException {

        String curTime = getFormatString("HH:mm");
        return isMiddleTime(startTime, endTime, curTime);

    }

    public static String getDateFormatStr(String sFormat) throws Exception {
        Calendar cal = Calendar.getInstance();
        Object objDate = cal.getTime();
        String sObj = objDate.toString();
        if (sObj.length() < 1) {
            return sObj;
        } else {
            SimpleDateFormat sdfDate = new SimpleDateFormat(sFormat);
            StringBuffer sbDate = new StringBuffer();
            sdfDate.format(objDate, sbDate, new FieldPosition(0));
            return sbDate.toString();
        }
    }

    public static String getDateFormatStr(String sFormat, int addDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.add(5, addDay);
        Object objDate = cal.getTime();
        String sObj = objDate.toString();
        if (sObj.length() < 1) {
            return sObj;
        } else {
            SimpleDateFormat sdfDate = new SimpleDateFormat(sFormat);
            StringBuffer sbDate = new StringBuffer();
            sdfDate.format(objDate, sbDate, new FieldPosition(0));
            return sbDate.toString();
        }
    }

    public static String getDateFormat(Date date, String format) {
        return getDateFormat(date, format, Locale.KOREA);
    }

    public static String getDateFormat(Date date, String format, Locale locale) {
        if (date == null)
            return "";
        SimpleDateFormat formatter = new SimpleDateFormat(format, locale);
        try {
            return formatter.format(date);
        } catch (Exception ex) {
            return "";
        }
    }

    public static void main(String[] args) throws ParseException {
        System.out.println("일:"+DateUtil.getDay());
        System.out.println("시:"+DateUtil.getHourHH());
        System.out.println("시:"+DateUtil.getDate());
        System.out.println("현재:"+DateUtil.getSysDate());

    }

}
