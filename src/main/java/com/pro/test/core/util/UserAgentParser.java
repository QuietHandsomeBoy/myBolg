package com.pro.test.core.util;

/**
 * Created by hxpeng on 2016/8/24.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A convenience class for parsing the user agent string that
 * is presented by web browsers. This work is based on the great
 * work that is documented at the texsoft website:
 *
 * http://www.texsoft.it/index.php?c=software&m=sw.php.useragent&l=it
 *
 * @author Glen Smith (glen@bytecode.com.au)
 */
public class UserAgentParser {
    private String userAgentString;
    private String browserName;
    private String browserVersion;
    private String browserOperatingSystem;
    private List<UserAgentDetails> parsedBrowsers = new ArrayList<UserAgentDetails>();

    private static Pattern pattern = Pattern.compile(
            "([^/\\s]*)(/([^\\s]*))?(\\s*\\[[a-zA-Z][a-zA-Z]\\])?" +
                    "\\s*(\\((([^()]|(\\([^()]*\\)))*)\\))?\\s*");

    /**
     * Parses the incoming user agent string into useful data about
     * the browser and its operating system.
     * @param userAgentString the user agent header from the browser.
     */
    public UserAgentParser(String userAgentString) {
        this.userAgentString = userAgentString;
        Matcher matcher = pattern.matcher(this.userAgentString);

        while (matcher.find()) {
            /*
            for(int i=0; i< matcher.groupCount(); i++) {
                System.err.println(i +": " + matcher.group(i));
            }
            */
            String nextBrowserName = matcher.group(1);
            String nextBrowserVersion = matcher.group(3);
            String nextBrowserComments = null;
            if (matcher.groupCount() >= 6) {
                nextBrowserComments = matcher.group(6);
            }
            parsedBrowsers.add(new UserAgentDetails(nextBrowserName,
                    nextBrowserVersion, nextBrowserComments));

        }

        if (parsedBrowsers.size() > 0) {
            processBrowserDetails();
        } else {
            throw new UserAgentParseException("Unable to parse user agent string: " + userAgentString);
        }

    }

    /**
     * Wraps the process of extracting browser name, version, and
     * operating sytem.
     */
    private void processBrowserDetails() {

        String[] browserNameAndVersion = extractBrowserNameAndVersion();
        browserName = browserNameAndVersion[0];
        browserVersion = browserNameAndVersion[1];

        browserOperatingSystem = extractOperatingSystem(parsedBrowsers.get(0).getBrowserComments());

        if (browserOperatingSystem == null)
            browserOperatingSystem = extractOperatingSystem(parsedBrowsers.get(1).getBrowserComments());

    }

    /**
     * Iterates through all component browser details to try and find the
     * canonical browser name and version.
     *
     * @return a string array with browser name in element 0 and browser
     * version in element 1. Null can be present in either or both.
     */
    private String[] extractBrowserNameAndVersion() {

        String[] knownBrowsers = new String[] {
                "nokiabrowser", "mqqbrowser", "qqbrowser", "baidubrowser", "360se", "sougou",
                "firefox", "netscape", "chrome", "safari", "uc", "ucweb", "camino", "mosaic", "opera",
                "galeon", "coolpad", "huawei", "zhongxing", "oppo", "tianyu"
        };

        for(UserAgentDetails nextBrowser : parsedBrowsers) {
            for (String nextKnown : knownBrowsers) {
                if (nextBrowser.getBrowserName().toLowerCase().startsWith(nextKnown)) {
                    return new String[] { nextBrowser.getBrowserName(), nextBrowser.getBrowserVersion() };
                }
                // TODO might need special case here for Opera's dodgy version
            }

        }

        UserAgentDetails firstAgent = parsedBrowsers.get(0);

        if (firstAgent.getBrowserName().toLowerCase().startsWith("mozilla")) {

            if (firstAgent.getBrowserComments() != null) {
                String[] comments = firstAgent.getBrowserComments().split(";");
                if (comments.length > 2 && comments[0].toLowerCase().startsWith("compatible")) {
                    String realBrowserWithVersion = comments[1].trim();
                    int firstSpace = realBrowserWithVersion.indexOf(' ');
                    int firstSlash = realBrowserWithVersion.indexOf('/');
                    if ((firstSlash > -1 && firstSpace > -1) ||
                            (firstSlash > -1 && firstSpace == -1)) {
                        // we have slash and space, or just a slash,
                        // so let's choose slash for the split
                        return new String[] {
                                realBrowserWithVersion.substring(0, firstSlash),
                                realBrowserWithVersion.substring(firstSlash+1)
                        };
                    }
                    else if (firstSpace > -1) {
                        return new String[] {
                                realBrowserWithVersion.substring(0, firstSpace),
                                realBrowserWithVersion.substring(firstSpace+1)
                        };
                    }
                    else { // out of ideas for version, or no version supplied
                        return new String[] { realBrowserWithVersion, null };
                    }
                }
            }

            // Looks like a *real* Mozilla :-)
            if (new Float(firstAgent.getBrowserVersion()) < 5.0) {
                return new String[] { "Netscape", firstAgent.getBrowserVersion() };
            } else {
                // TODO: get version from comment string
                return new String[] { "Mozilla",
                        firstAgent.getBrowserComments().split(";")[0].trim() };
            }
        } else {
            return new String[] {
                    firstAgent.getBrowserName(), firstAgent.getBrowserVersion()
            };
        }

    }

    /**
     * Extracts the operating system from the browser comments.
     *
     * @param comments the comment string afer the browser version
     * @return a string representing the operating system
     */
    private String extractOperatingSystem(String comments) {

        if (comments == null) {
            return null;
        }


        String[] knownOS = new String[] { "windows", "win", "android", "linux", "iphone", "ipad", "mac", "symbian",
                "webos", "palm", "blackberry", "meego", "freebsd", "netbsd", "ubuntu", "redhat", "centos",
                "fedora", "debian", "openbsd", "sunos", "amiga", "beos", "irix", "os/2", "warp"};
        List<String> osDetails = new ArrayList<String>();
        String[] parts = comments.split(";");
        for (String comment : parts) {
            String lowerComment = comment.toLowerCase().trim();
            for (String os : knownOS) {
                if (lowerComment.startsWith(os)) {
                    osDetails.add(comment.trim());
                }
            }

        }
        switch (osDetails.size()) {
            case 0: { return null; }
            case 1: { return osDetails.get(0); }
            default: {
                return "linux".equals(osDetails.get(0)) && osDetails.get(1) != null && osDetails.get(0).length() > 0 ?
                        osDetails.get(0) : osDetails.get(1); // need to parse more stuff here
            }
        }

    }

    /**
     * Returns the name of the browser.
     *
     * @return the name of the browser
     */
    public String getBrowserName() {
        return browserName;
    }

    /**
     * Returns the version of the browser.
     *
     * @return the version of the browser
     */
    public String getBrowserVersion() {
        return browserVersion;
    }

    /**
     * Returns the operating system the browser is running on.
     *
     * @return the operating system the browser is running on.
     */
    public String getBrowserOperatingSystem() {
        return browserOperatingSystem;
    }

    public static void main(String[] args) {

        String[] userAgentArray = new String[] {
                "Mozilla/5.0 (Linux; U; Android 2.2; zh-cn; YL-Coolpad_E239/1.01.019.110627.E239; 320*480; CTC/2.0) CoolpadWebkit/533.1",
                "Mozilla/5.0 (Linux; U; Android 2.2.1; zh-cn; E239 Build/MASTER) UC AppleWebKit/530+ (KHTML, like Gecko) Mobile Safari/530",
                "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)",
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:11.0) Gecko/20100101 Firefox/11.0",
                "Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0; HTC; PC40100)",
                "Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A537a Safari/419.3",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/534.55.3 (KHTML, like Gecko) Version/5.1.3 Safari/534.53.10",
                "Mozilla/5.0 (SymbianOS/9.1; U; [en-us]) AppleWebKit/413 (KHTML, like Gecko) Safari/413",
                "Mozilla/5.0 (BlackBerry; U; BlackBerry AAAA; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/X.X.X.X Mobile Safari/534.11+",
                "Mozilla/5.0 (MeeGo; NokiaN9) AppleWebKit/534.13 (KHTML, like Gecko) NokiaBrowser/8.5.0 Mobile Safari/534.13",
                "Opera/9.80 (Windows NT 6.1; U; es-ES) Presto/2.9.181 Version/12.00",
                "Mozilla/5.0 (Macintosh; PPC Mac OS X; U; en) Opera 8.0 ",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; Win64; x64; SV1; .NET CLR 2.0.50727)",
                "MQQBrowser/2801 Mozilla/5.0 (iPhone;U;CPU iPhone OS 4_1 like Mac OS X;zh-cn) AppleWebKit/532.9(KHTML,like Gecko)Version/4.0.5 Mobile/8B117 Safari/6531.22.7",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.142 Safari/535.19" };


        for (int i = 0; i < userAgentArray.length; i++) {
            UserAgentParser userAgentParser = new UserAgentParser(userAgentArray[i]);

            System.out.println("\n******************" + (i + 1) + "*******************");
            System.out.println("getBrowserName=" + userAgentParser.getBrowserName());
            System.out.println("getBrowserVersio=" + userAgentParser.getBrowserVersion());
            System.out.println("getBrowserOperatingSystem=" + userAgentParser.getBrowserOperatingSystem());
        }
    }



    /**
     * Responsible for handling all parsed browser details since there may
     * be many of these in one browser UserAgent string.
     *
     * @author Glen Smith (glen@bytecode.com.au)
     */
    public class UserAgentDetails {

        private String browserName;
        private String browserVersion;
        private String browserComments;

        /**
         * Constructor.
         *
         * @param browserName the name of the browser
         * @param browserVersion the version of the browser
         * @param browserComments the operating system the browser is running on
         */
        UserAgentDetails(String browserName, String browserVersion, String browserComments) {
            this.browserName = browserName;
            this.browserVersion = browserVersion;
            this.browserComments = browserComments;
        }

        public String getBrowserComments() {
            return browserComments;
        }

        public String getBrowserName() {
            return browserName;
        }

        public String getBrowserVersion() {
            return browserVersion;
        }

    }

    /**
     * Catches scenarios where user agent cannot be parsed.
     * @author Glen Smith (glen@bytecode.com.au)
     */
    public class UserAgentParseException extends RuntimeException {

        private static final long serialVersionUID = -1634543851675054270L;

        public UserAgentParseException(String message) {
            super(message);
        }

    }
}