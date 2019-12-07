package com.alvin.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * rsa加密工具类
 *
 * @ClassName: RSAUtil
 * @Description: TODO rsa加密工具类
 * @CreateAutor: cxc
 * @CreateDate: 2019/11/27 0027 上午 10:46
 * @UpdateUser: $
 * @UpdateDate: $
 * @UpdateRemark: $
 * @Version: v3.0
 */
public final class RSAUtil {


    private static final String ALGORITHM_NAME = "RSA";

    private static final int KEY_SIZE = 1024;

    private static final String CHARSET = "UTF-8";

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     */
    public static String encrypt(String str, String publicKey) {
        if (StringUtil.isBlank(str) || StringUtil.isBlank(publicKey)) {
            return "";
        }
        try {
        	publicKey=FileUtils.readFileToString(new File(publicKey));
            byte[] decoded = Base64.decodeBase64(publicKey);
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(ALGORITHM_NAME).generatePublic(new X509EncodedKeySpec(decoded));
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            String result= Base64.encodeBase64String(cipher.doFinal(str.getBytes(CHARSET)));
            result=result.replace("+", "-push-");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 明文
     */
    public static String decrypt(String str, String privateKey) {
        if (StringUtil.isBlank(str) || StringUtil.isBlank(privateKey)) {
            return null;
        }
        try {
        	str=str.replace("-push-", "+");
        	privateKey=FileUtils.readFileToString(new File(privateKey));
            //64位解码加密后的字符串
            byte[] inputByte = Base64.decodeBase64(str.getBytes(CHARSET));
            //base64编码的私钥
            byte[] decoded = Base64.decodeBase64(privateKey);
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(ALGORITHM_NAME).generatePrivate(new PKCS8EncodedKeySpec(decoded));
            //RSA解密
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            return new String(cipher.doFinal(inputByte));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 生成大小为1kb的公匙密匙
     *
     * @return {@link KeyPair}
     */
    public static KeyPair genRSAKes() {
        return genRSAKes(KEY_SIZE);
    }

    /**
     * 生成rsa公匙 密匙
     *
     * @param keySize 公匙密匙长度
     * @return {@link KeyPair}
     */
    public static KeyPair genRSAKes(int keySize) {
        if (keySize < 0) {
            return null;
        }
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyPairGenerator keyPairGenerator = null;
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");

            keyPairGenerator.initialize(keySize, secureRandom);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

  
    }
    
    private void createRSA(){
    	  KeyPair keyPair = RSAUtil.genRSAKes();

          // 公钥
          Key publicKey = keyPair.getPublic();
          byte[] publicKeyBytes = publicKey.getEncoded();
          String publicKeyBase64 = Base64.encodeBase64String(publicKeyBytes);
          System.out.println("public:"+publicKeyBase64);

          // 私钥
          Key privateKey = keyPair.getPrivate();
         byte[] privateKeyBytes = privateKey.getEncoded();
          String privateKeyBase64 = Base64.encodeBase64String(privateKeyBytes);
          System.out.println("private:"+privateKeyBase64);
    }
    
    public static void main(String[] args) throws IOException {
    	  String sn = "1_ad_dd_dd";

          long time = System.currentTimeMillis();

          String publicKeyFilename = "C:\\Users\\Alvin\\Workspaces\\MyEclipse2017\\.metadata\\.me_tcat85\\webapps\\LoginService\\WEB-INF\\classes\\public.key";
          String privateKeyFilename = "C:\\Users\\Alvin\\Workspaces\\MyEclipse2017\\.metadata\\.me_tcat85\\webapps\\LoginService\\WEB-INF\\classes\\private.key";
          //String puk = FileUtils.readFileToString(new File(publicKeyFilename));
          //String prk = FileUtils.readFileToString(new File(privateKeyFilename));


          //明文
          String cipherText = sn + time;

          //使用公式加密
          String encrypt = RSAUtil.encrypt(cipherText,publicKeyFilename);
          System.out.println("加密后" + encrypt);

          //使用私匙解密
          String decrypt = RSAUtil.decrypt(encrypt, privateKeyFilename);
          System.out.println("解密后" + decrypt);
	}

}