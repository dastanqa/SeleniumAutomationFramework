package com.dastan.listeners;

import com.dastan.constants.FrameworkConstants;
import com.dastan.utilities.ExelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public  class MethodIntercepter implements IMethodInterceptor {


    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        //loginLogouttest and newTest

        List<Map<String, String>> list=ExelUtils.getTestDetails(FrameworkConstants.getRunmanagersheet());
        List<IMethodInstance> result = new ArrayList<>();

        for(int i=0;i<methods.size();i++){
            for(int j=0;j<list.size();j++){

                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))&&
                   (list.get(j).get("execute").equalsIgnoreCase("yes"))){
                       methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                       methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
                       methods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
                       result.add(methods.get(i));
                   }
                }

            }

        return result;
    }
}
