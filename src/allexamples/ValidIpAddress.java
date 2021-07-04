package allexamples;

/*
* Given a string IP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168@1.1" are invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

1 <= xi.length <= 4
xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.
For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.



Example 1:

Input: IP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:

Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:

Input: IP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
Example 4:

Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
Output: "Neither"
Example 5:

Input: IP = "1e1.4.5.6"
Output: "Neither"
*
* */


public class ValidIpAddress {


    public static String getIPType(String ip) {
        if (ip.contains(":")) {
            String[] iprangeIpV6 = ip.split(":", -1);
            if (iprangeIpV6.length != 8) {
                return "Neither";
            }
            for (int i = 0; i < iprangeIpV6.length; i++) {
                boolean isValid = isValidIPV6(iprangeIpV6[i], i);
                if (!isValid) {
                    return "Neither";
                }
            }
            return "IPv6";
        } else if (ip.contains(".")) {
            String[] iprangeIpV4 = ip.split("\\.", -1);
            if (iprangeIpV4.length != 4) {
                return "Neither";
            }
            for (int i = 0; i < iprangeIpV4.length; i++) {
                boolean isValid = isValidIPV4(iprangeIpV4[i], i);
                if (!isValid) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
        return "Neither";
    }

    public static boolean isValidIPV4(String str, int index) {
        if (str.isEmpty() || !str.matches("^\\d+$") || str.length() > 3) {
            return false;
        }
        int range = Integer.parseInt(str);
        return !(str.startsWith("0") && str.length() > 1) && range >= 0 && range <= 255;
    }

    public static boolean isValidIPV6(String str, int index) {
        return !str.isEmpty() && str.length() <= 4 && str.matches("^[a-fA-F0-9]*$");
    }


    public static void main(String[] args) {
        String ip4 = "11111111111111111111111111111111111111111111111111111111111111111111111111111111111..";
        System.out.println(getIPType(ip4));
        String ip6 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(getIPType(ip6));
        String ipv6Invalid = "02001:0db8:85a3:0000:0000:8a2e:0370:7334";
        System.out.println(getIPType(ipv6Invalid));
        String ipv6Invalid1 = "2001:db8:85a3:0::8a2E:0370:7334";
        System.out.println(getIPType(ipv6Invalid1));

    }
}
