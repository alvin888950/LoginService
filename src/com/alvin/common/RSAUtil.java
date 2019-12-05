package com.alvin.common;

import org.apache.commons.codec.binary.Base64;

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
            byte[] decoded = Base64.decodeBase64(publicKey);
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(ALGORITHM_NAME).generatePublic(new X509EncodedKeySpec(decoded));
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            return Base64.encodeBase64String(cipher.doFinal(str.getBytes(CHARSET)));
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

//        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 公钥
//        Key publicKey = keyPair.getPublic();
//        byte[] publicKeyBytes = publicKey.getEncoded();
//        String publicKeyBase64 = Base64.encodeBase64String(publicKeyBytes);

        // 私钥
//        Key privateKey = keyPair.getPrivate();
//        byte[] privateKeyBytes = privateKey.getEncoded();
//        String privateKeyBase64 = Base64.encodeBase64String(privateKeyBytes);
    }

}