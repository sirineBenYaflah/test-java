package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Service {

    String username="";

    public Service(String username)
        {
        this.username = username;
        }

    public void serviceDate()
        {

        // pattern of date
    Pattern pattern = Pattern.compile("((0[1-9]|[12][0-9]|3[01])(\\s|-|\\/|,|;|_)*"
            + "((Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|June?|July?|Aug(ust)?|Sep(t(ember)?)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)|"
            + "(1[0-2]|0[1-9]))+|((Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|June?|July?|Aug(ust)?|Sep(t(ember)?)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)|"
            + "(1[0-2]|0[1-9]))+(\\s|-|\\/|,|;|_)+(0[1-9]|[12][0-9]|3[01]))(\\s|-|\\/|,|;|_)*((19|20)[0-9][0-9])");


    Matcher matcher = pattern.matcher(username);

    List<MyDate> listeDates = new ArrayList<MyDate>();

        while (matcher.find()) {
        MyDate d= new MyDate();
        // start index of match
        int start = matcher.start();
        // end index of match
        int end = matcher.end();



        /////test for the day
        if(matcher.group(2)==null)
            {
            d.setDay(Integer.parseInt(matcher.group(31)));
            }
        else
            {
            d.setDay(Integer.parseInt(matcher.group(2)));
            }

        /////test for the month 17:possition in the pattern
        if(matcher.group(17)!=null){

            d.setMonth(matcher.group(17));
        }else
        {
            d.setMonth(matcher.group(4));
        }


        d.setYear(Integer.parseInt(matcher.group(33)));

        listeDates.add(d);
        String myText = username.substring(start, end);
        username = username.replaceAll(myText, replaceCara(start,end));
    }

    /////count of occurrence of date grouped by year
    Map<Integer, Long> counters = listeDates.stream().collect(Collectors.groupingBy(date -> date.getYear(),Collectors.counting()));

    /////Collection of dates by year
    Map<Integer, List<MyDate>> groupByYearMap =listeDates.stream().collect(Collectors.groupingBy(d->d.getYear()));
        for (Map.Entry<Integer, Long> entry1 : counters.entrySet())
        {
        for (Map.Entry<Integer, List<MyDate>> entry2 : groupByYearMap.entrySet())
            {
            if(entry2.getKey()==(int)(long)entry1.getKey())
                {
                System.out.println(entry1.getKey() + "/" + entry1.getValue()+ "-----"+entry2.getValue());

                }
            }
        }



}


    /////function of replacing the date with spaces
    static String replaceCara(int start,int end)
    {

        int result = end - start;
        String s="";
        for(int i=0;i<result;i++)
            {

            s+=" ";
            }
        return s;
    }
}
