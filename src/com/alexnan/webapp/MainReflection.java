package com.alexnan.webapp;

import com.alexnan.webapp.model.Resume;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException,
            InvocationTargetException, NoSuchMethodException {
        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(resume);


        Class resumeClass = resume.getClass();

        Method[] methods = resumeClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("" +
                    "Name of method = " + method.getName() +
                    ", return type = " + method.getReturnType() +
                    ", parameter types = " + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("***************");

        Constructor constructor = resumeClass.getConstructor();
        Object resume1 = constructor.newInstance();
        System.out.println(resume1);

        Constructor<Resume> constructor1 = resumeClass.getConstructor(String.class);
        Resume resume2 = constructor1.newInstance("another_uuid");
        System.out.println(resume2);

        Method method = resumeClass.getMethod("toString");
        Object invoke = method.invoke(resume);
        System.out.println(invoke);

    }
}
