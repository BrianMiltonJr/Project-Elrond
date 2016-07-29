package com.gmail.lonelyretardxd.elrond.mobs;

import java.lang.reflect.Field;

public class MobUtils {

	
	public static Object getPrivateField(String fieldName, @SuppressWarnings("rawtypes") Class clazz, Object object)
    {
        Field field;
        Object o = null;

        try
        {
            field = clazz.getDeclaredField(fieldName);

            field.setAccessible(true);

            o = field.get(object);
        }
        catch(NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return o;
    }
}
