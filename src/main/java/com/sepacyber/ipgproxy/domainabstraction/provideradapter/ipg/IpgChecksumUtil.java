package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

@Slf4j
@UtilityClass
public class IpgChecksumUtil {

    public static String generateSyncTransactionAmd5Checksum(final long merchantId,
                                                             final String secureKey,
                                                         final String merchantTransactionId,
                                                         final Double amount){
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            final byte[] messageDigestBytes =  messageDigest.digest(String.format("%d|%s|%s|%.2f", merchantId, secureKey, merchantTransactionId, amount).getBytes());
            StringBuilder sb = new StringBuilder(2*messageDigestBytes.length);
            for(byte mByte : messageDigestBytes) {
                sb.append(String.format("%02x", mByte&0xff));
            }
            return sb.toString().toLowerCase();

        } catch (NoSuchAlgorithmException e) {
            log.error("Failed to calculate md5 checksum for merchant id: {}, sKey: {}, merchant transaction id: {} and amount: {}", merchantId, secureKey, merchantTransactionId, amount);
           return null;
        }

    }
}
