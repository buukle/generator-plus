package top.buukle.opensource.arche.generator.utils;


import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @description 
 * @Author zhanglei1102
 * @Date 2019/9/9
 */
public class SystemUtil {


    public final static String PID = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];

    public static String ipPid() {
        return JsonUtil.toJSONString(getIpList()) + "_" + PID;
    }
    public static List<String> getIpList() {
        List<String> ipList = new ArrayList<>();
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains(":") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                                ipList.add(ipaddress) ;
                                System.out.println(ipaddress);
                            }
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            System.out.println("获取ip地址异常");
            ipList.add("127.0.0.1") ;
            ex.printStackTrace();
        }
        return ipList;
    }

    public static String getStoreDir() {
        if(isWindows()){
            return "D://file/temp";
        }
        return "/opt/temp";
    }

    public static boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }
}
