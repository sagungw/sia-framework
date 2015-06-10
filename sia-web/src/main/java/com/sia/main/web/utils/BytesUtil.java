package com.sia.main.web.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BytesUtil {
	
	public static byte[] toBytes(Object object) throws IOException {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();
        } finally {
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
        }
        return bytes;
	}
	
	public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {
		Object object = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object = objectInputStream.readObject();
        } finally {
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
        }
        return object;
    }
	
	public static String toString(byte[] bytes) {
        return new String(bytes);
    }
	
}
