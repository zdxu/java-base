package com.zdxu.introspector;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by zhaodexu on 2019/4/29.
 */
public class PropertyDescriptorQuest {

    public static void main(String[] args) throws Exception{
        JavaBeanDemo beanDemo = new JavaBeanDemo();
        String propertyName = "column1";
        Object propertyValue = "column name set";
        setProperty(propertyName, propertyValue, beanDemo);
        System.out.println(beanDemo.getColumn1());


        Object ret = getProperty(propertyName, beanDemo);
        System.out.println(ret);

        propertyName = "column2";
        ret = getProperty(propertyName, beanDemo);
        System.out.println(ret);

    }

    public static void setProperty(String propertyName, Object propertyValue, Object obj) throws Exception{
        PropertyDescriptor propDesc = new PropertyDescriptor(propertyName, obj.getClass());
        Method methodSetProperty = propDesc.getWriteMethod();
        methodSetProperty.invoke(obj, propertyValue);
    }

    public static Object getProperty(String propertyName, Object obj) throws Exception{
        PropertyDescriptor propDesc = new PropertyDescriptor(propertyName, obj.getClass());
        Method methodGetProperty = propDesc.getReadMethod();
        return methodGetProperty.invoke(obj);
    }
}
