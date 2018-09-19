package com.hcmony.utils;

import java.io.*;

/**
 * @author hcmony 2015年11月12日 下午2:56:35
 * @ClassName SerializableUtil.java
 * @Description 类实现描述: 序列化和反序列化
 */
public class SerializableUtil {

    /**
     * 将对象序列化为byte[]
     *
     * @param value
     * @return
     */
    public static byte[] toByteArray(Object value) {
        byte[] bytes = null;
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(value);
            oos.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                    bytes = baos.toByteArray();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bytes;
    }

    /**
     * 将byte[]反序列化为Object
     *
     * @param bytes
     * @return
     */
    public static Object toObject(byte[] bytes) {
        Object obj = null;
        ObjectInputStream ois = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            obj = ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }
}
