package com.dastan.utilities;

import com.dastan.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {
    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider(parallel = true)
    public static Object[] getData(Method method) {

        String testname = method.getName();

        if (list.isEmpty()) {
            list = ExelUtils.getTestDetails(FrameworkConstants.getIterationsdatasheet());
        }

        List<Map<String, String>> smalllist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("testname").equalsIgnoreCase(testname) &&
                 (list.get(i).get("execute").equalsIgnoreCase("yes"))) {
                    smalllist.add(list.get(i));
                }

        }
        list.removeAll(smalllist);
        return smalllist.toArray();
    }
}
