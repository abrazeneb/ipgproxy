package com.sepacyber.ipgproxy.integrationprovider.ipg;

import com.sepacyber.ipgproxy.provideradapter.ipg.IpgChecksumUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class IpgIntegrationUtilsTest {

    @Test
    public void doStuff() {
        String actual = IpgChecksumUtil.generateSyncTransactionAmd5Checksum(50001,
                "azL8AHD8D3nghiTY3bJTIFiL0uww6y8V",
                "12346",
                50.10);

        assertEquals("9842f7a8d8dd797e026a92cf70aa0431", actual);
    }
}
