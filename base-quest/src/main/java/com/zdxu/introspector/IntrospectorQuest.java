package com.zdxu.introspector;


import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by zhaodexu on 2019/4/29.
 */
public class IntrospectorQuest {

    public static void main(String[] args) throws Exception {
        JavaBeanDemo beanDemo = new JavaBeanDemo();

        String propertyName = "column1";
        Object ret = getProperty(propertyName, beanDemo);
        System.out.println("column1 value: " + ret);

        Object propertyValue = "column1 name set";
        setProperty(propertyName, propertyValue, beanDemo);
        System.out.println(beanDemo.getColumn1());

        ret = getProperty(propertyName, beanDemo);
        System.out.println("column1 value: " + ret);

        propertyName = "column2";
        ret = getProperty(propertyName, beanDemo);
        System.out.println("column2 value: " + ret);

        propertyValue = "column2 name set";
        setProperty(propertyName, propertyValue, beanDemo);
        System.out.println(beanDemo.getColumn2());

        propertyName = "column2";
        ret = getProperty(propertyName, beanDemo);
        System.out.println("column2 value: " + ret);

    }

    public static void setProperty(String propertyName, Object propertyValue, Object obj) throws Exception{
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propDescs = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propDesc : propDescs) {
            if(propDesc.getName().equals(propertyName)) {
                Method method = propDesc.getWriteMethod();
                method.invoke(obj, propertyValue);
                return;
            }
        }
    }

    public static Object getProperty(String propertyName, Object obj) throws Exception{
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propDescs = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propDesc : propDescs) {
            if(propDesc.getName().equals(propertyName)) {
                Method method = propDesc.getReadMethod();
                return method.invoke(obj);
            }
        }
        throw new Exception("property name is not exist!");
    }
}
