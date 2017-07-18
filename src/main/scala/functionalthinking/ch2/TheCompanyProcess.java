package functionalthinking.ch2;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by dj on 2017/7/5.
 */
public class TheCompanyProcess {

    public String cleanNames(List<String> listOfNames) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < listOfNames.size(); i++) {
            if (listOfNames.get(i).length() > 1) {
                result.append(capitalizeString(listOfNames.get(i))).append(",");
            }
        }
        return result.substring(0, result.length() - 1).toString();
    }

    public static String capitalizeString(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }

    public String cleanNamesInJava8(List<String> listOfNames) {
        return listOfNames
                .stream()
                .filter(name -> name.length() > 1)
                .map(TheCompanyProcess::capitalizeString)
                .collect(Collectors.joining(","));
    }
}
