package com.tuqi.common;

import com.tuqi.util.MyMD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Xianrui Ke on 2017/4/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MD5Test {
    private String password = "xyz777";
    @Test
    public void encodeTest(){
        try {
            String result = MyMD5Util.getEncryptedPwd("gasjdavb");
            System.out.println(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String getEncodeResult(String pwd){
        try {
            String result = MyMD5Util.getEncryptedPwd(pwd);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
