package monkey.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IPHelper {

    private final static Logger log = LoggerFactory.getLogger(IPHelper.class);
    private static String localAddress = "-";

    public static String getLocalAddress() {
        if (localAddress.equals("-")) {
            try {
                InetAddress address = getLocalAvailableAddress();
                localAddress = address.getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            log.info("主机地址: " + localAddress);
        }
        return localAddress;
    }

    private static InetAddress getLocalAvailableAddress() throws UnknownHostException {
        try {
            InetAddress backupAddress = null;
            for (Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces(); networkInterfaces.hasMoreElements(); ) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (networkInterface.isUp()) {
                    for (Enumeration addresses = networkInterface.getInetAddresses(); addresses.hasMoreElements(); ) {
                        InetAddress address = (InetAddress) addresses.nextElement();
                        if (!address.isLoopbackAddress()) {
                            if (address.isSiteLocalAddress()) {
                                return address;
                            } else if (backupAddress == null) {
                                backupAddress = address;
                            }
                        }
                    }
                }
            }

            if (backupAddress != null) {
                return backupAddress;
            }

            backupAddress = InetAddress.getLocalHost();
            if (backupAddress == null) {
                throw new UnknownHostException("Failed to get local host.");
            } else {
                return backupAddress;
            }
        } catch (Exception e) {
            UnknownHostException exception = new UnknownHostException("Failed to get local address: " + e);
            exception.initCause(e);
            throw exception;
        }
    }
}
