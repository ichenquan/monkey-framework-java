package monkey.common;

import org.apache.commons.lang.CharUtils;
import org.springframework.util.DigestUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class StringHelper {

	public static final String EMPTY_SRING = "";
	private static final String DEFAULT_SPLIT = "\\s|,|\\|";
	private static final String MOBILE_REG = "^0?(13[0-9]|15[0-9]|18[0-9]|14[157])[0-9]{8}$";

	public static String toString(Object value) {
		return String.valueOf(value);
	}

	/**
	 * 验证字符串是否为空
	 */
	public static boolean isEmpty(Object str) {
		return str == null || EMPTY_SRING.equals(str) || "null".equals(str);
	}

	/**
	 * 验证字符串是否为不为空
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static boolean isNotEmpty(Object str) {
		return !isEmpty(str);
	}

	/**
	 * 给字符串加密，采用md5加密算法
	 *
	 * @param str
	 * @return
	 */
	public static String encryption(String str) {
		if (str == null) {
			return null;
		}
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}

	/**
	 * 两个字符串链接后md5加密
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public static String encryption(String username, String password) {
		String result = null;
		if (username != null) {
			result = username;
		}
		if (password != null) {
			result = result == null ? password : result.concat(password);
		}
		if (result == null) {
			return null;
		}
		return DigestUtils.md5DigestAsHex(result.getBytes());
	}

/*	public static void main(String[] args) throws Exception {
		String str = ""+System.currentTimeMillis();
		System.out.println(encryption(str));
	}*/

	/**
     * 生成签名数据
     *
     * @param data 待加密的数据
     * @param key  加密使用的key
     */
    public static byte[] sha1Signature(String data,byte[] key) {
        try {
        	SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA1");
	        Mac mac = Mac.getInstance("HmacSHA1");
	        mac.init(signingKey);
	        return mac.doFinal(data.getBytes());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    /**
     * 生成签名数据
     *
     * @param data 待加密的数据
     * @param key  加密使用的key
     */
    public static String sha1Signature(String data,String key) {
        return byte2hex(sha1Signature(data, key.getBytes()));
    }

	/**
	 * sha1加密字符串
	 *
	 * @param str
	 * @return
	 */
	public static String sha1(String str) {
		if (str == null) {
			return str;
		} else {
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-1");
				digest.update(str.getBytes());
				return byte2hex(digest.digest());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	/**
	 * 将字节数组转换成16进制字符串
	 *
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		StringBuilder sbDes = new StringBuilder();
		String tmp = null;
		for (int i = 0; i < b.length; i++) {
			tmp = (Integer.toHexString(b[i] & 0xFF));
			if (tmp.length() == 1) {
				sbDes.append("0");
			}
			sbDes.append(tmp);
		}
		return sbDes.toString();
	}

	/**
	 * 默认空格，“，”，“|”
	 *
	 * @param string
	 * @return
	 */
	public static String[] split(String string) {
		if (isEmpty(string)) {
			return null;
		}
		return string.split(DEFAULT_SPLIT);
	}

	public static String[] split(String string, String split) {
		if (isEmpty(string)) {
			return null;
		}
		if (isEmpty(split)) {
			return new String[] { string };
		}
		return string.split(split);
	}

	public static String filter(String str, String filterStr) {
		if (isEmpty(str))
			return EMPTY_SRING;
		if (isEmpty(filterStr)) {
			return str;
		}
		return str.replaceAll(filterStr, EMPTY_SRING);
	}

	/**
	 * 随机生成一个字符串
	 *
	 * @param letterLength
	 * @param numberLength
	 * @return
	 */
	public static String randStr(int letterLength, int numberLength) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < letterLength; i++) {
			int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
			sb.append((char) (choice + random.nextInt(26)));
		}
		for (int i = 0; i < numberLength; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

	/**
	 * 随机生成一个全数字的字符串
	 *
	 * @param numberLength 字符串长度
	 * @return String		字符
	 */
	public static String randNumberStr(int numberLength) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < numberLength; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

	public static boolean isQQEmail(String email) {
		if (isEmpty(email)) {
			return false;
		}
		String[] strs = split(email, "@");
		if (strs.length != 2) {
			return false;
		} else {
			String sux = strs[1];
			return "qq.com".equals(sux);
		}
	}

	/**
	 * 判断是否是合法的手机号码
	 *
	 * @param mobile
	 * @return
	 */
	public static boolean isMobileNumber(String mobile) {
		if (isEmpty(mobile)) {
			return false;
		}
		Pattern pattern = Pattern.compile(MOBILE_REG);
		return pattern.matcher(mobile).find();
	}

	public static boolean isNumber(String content) {
		try {
			Long.valueOf(content);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * @param str   要匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 */
	public static boolean isEmail(String str){
//		Pattern pattern = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 读取最后一行内容
	 *
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static String readLastLine(File file, String charset) {
		if (!file.exists() || file.isDirectory() || !file.canRead()) {
			return null;
		}
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "r");
			long len = raf.length();
			if (len == 0L) {
				return "";
			} else {
				long pos = len - 1;
				while (pos > 0) {
					pos--;
					raf.seek(pos);
					if (raf.readByte() == '\n') {
						break;
					}
				}
				if (pos == 0) {
					raf.seek(0);
				}
				byte[] bytes = new byte[(int) (len - pos)];
				raf.read(bytes);
				if (charset == null) {
					return new String(bytes);
				} else {
					return new String(bytes, charset);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (Exception e2) {
				}
			}
		}
		return null;
	}

	/**
	 * 过滤4个字节的字符
	 * @param nickName
	 * @return
	 */
	public static String nameFilter(String nickName) {
		if (isEmpty(nickName)) {
			return EMPTY_SRING;
		}
		String result = nickName;
		try {
			byte[] t1 = nickName.getBytes("UTF-8");
			for (int i = 0; i < t1.length;) {
				byte tt = t1[i];
				if (CharUtils.isAscii((char) tt)) {
					byte[] ba = new byte[1];
					ba[0] = tt;
					i++;
				}
				if ((tt & 0xE0) == 0xC0) {
					byte[] ba = new byte[2];
					ba[0] = tt;
					ba[1] = t1[i + 1];
					i++;
					i++;
				}
				if ((tt & 0xF0) == 0xE0) {
					byte[] ba = new byte[3];
					ba[0] = tt;
					ba[1] = t1[i + 1];
					ba[2] = t1[i + 2];
					i++;
					i++;
					i++;
				}
				if ((tt & 0xF8) == 0xF0) {
					byte[] ba = new byte[4];
					ba[0] = tt;
					ba[1] = t1[i + 1];
					ba[2] = t1[i + 2];
					ba[3] = t1[i + 3];
					i++;
					i++;
					i++;
					i++;
					String r = new String(ba);
					result =  nickName.replaceAll(r, "");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
